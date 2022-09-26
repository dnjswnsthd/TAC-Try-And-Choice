from sqlalchemy.orm import Session
from sqlalchemy.exc import SQLAlchemyError

from models.consume import ConsumeTable, Consume

# 고객의 소비 정보 등록
def insert_consumeInfo(db: Session, consume: Consume):
    db_consume = ConsumeTable()
    db_consume.consume_date = consume.consume_date
    db_consume.consume_price = consume.consume_price
    db_consume.large_category_id = consume.large_category_id
    db_consume.small_category_id = consume.small_category_id
    try:
        db.add(db_consume)
        db.commit()
        db.refresh(db_consume)
    except:
        db.rollback()
        raise SQLAlchemyError

    return db_consume