from sqlalchemy import Column, Integer, String, DateTime
from pydantic import BaseModel
from database import db


# Response Consume Database
class ConsumeTable(db.Base):
    __tablename__ = 'consume'
    consume_id = Column(Integer, primary_key=True, autoincrement=True)
    consume_price = Column(String(45), nullable=False)
    consume_date = Column(Integer, nullable=False)
    large_category_id = Column(String(80))
    small_category_id = Column(String(70))
    member_id = Column(String(30), nullable=False)

# Request Consume Database
class Consume(BaseModel):
    consume_id: str
    consume_price: int
    consume_date: str
    large_category_id: int
    small_category_id: int


# Request UpdateMember Database
class UpdateConsume(BaseModel):
    consume_id: int
    consume_price: int
    consume_date: int
    large_category_id: int
    small_category_id: int
    member_id: str