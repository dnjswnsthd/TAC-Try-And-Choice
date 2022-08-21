package com.service.tac.model.vo;

public class Consume {
	private int consumeId; // CONSUME_ID
	private int consumePrice; // CONSUME_PRICE
	private String consumeDate; // CONSUME_DATE
	private String largeCategoryId; // LARGE_CATEGORY_ID
	private String smallCategoryId; // SMALL_CATEGORY_ID

	public Consume() {
		super();
	}

	public Consume(int consumeId, int consumePrice, String consumeDate, String largeCategoryId,
			String smallCategoryId) {
		super();
		this.consumeId = consumeId;
		this.consumePrice = consumePrice;
		this.consumeDate = consumeDate;
		this.largeCategoryId = largeCategoryId;
		this.smallCategoryId = smallCategoryId;
	}

	public int getConsumeId() {
		return consumeId;
	}

	public void setConsumeId(int consumeId) {
		this.consumeId = consumeId;
	}

	public int getConsumePrice() {
		return consumePrice;
	}

	public void setConsumePrice(int consumePrice) {
		this.consumePrice = consumePrice;
	}

	public String getConsumeDate() {
		return consumeDate;
	}

	public void setConsumeDate(String consumeDate) {
		this.consumeDate = consumeDate;
	}

	public String getLargeCategoryId() {
		return largeCategoryId;
	}

	public void setLargeCategoryId(String largeCategoryId) {
		this.largeCategoryId = largeCategoryId;
	}

	public String getSmallCategoryId() {
		return smallCategoryId;
	}

	public void setSmallCategoryId(String smallCategoryId) {
		this.smallCategoryId = smallCategoryId;
	}

	@Override
	public String toString() {
		return "Consume [consumeId=" + consumeId + ", consumePrice=" + consumePrice + ", consumeDate=" + consumeDate
				+ ", largeCategoryId=" + largeCategoryId + ", smallCategoryId=" + smallCategoryId + "]";
	}

}
