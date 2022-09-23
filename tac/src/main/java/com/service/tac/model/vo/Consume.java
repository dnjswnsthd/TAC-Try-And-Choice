package com.service.tac.model.vo;

public class Consume {
	private int consumeId; // CONSUME_ID
	private int consumePrice; // CONSUME_PRICE
	private String consumeDate; // CONSUME_DATE
	private int largeCategoryId; // LARGE_CATEGORY_ID
	private String largeCategoryName; // LARGE_CATEGORY_NAME
	private int smallCategoryId; // SMALL_CATEGORY_ID
	private String smallCategoryName; // SMALL_CATEGORY_NAME
	private String memberId;

	public Consume() {
		super();
	}
	
	public Consume(int consumeId, String consumeDate) {
		super();
		this.consumeId = consumeId;
		this.consumeDate = consumeDate;
	}


	public Consume(int consumePrice, String consumeDate, int largeCategoryId, int smallCategoryId, String memberId) {
		super();
		this.consumePrice = consumePrice;
		this.consumeDate = consumeDate;
		this.largeCategoryId = largeCategoryId;
		this.smallCategoryId = smallCategoryId;
		this.memberId = memberId;
	}

	public Consume(int consumeId, int consumePrice, String consumeDate, int largeCategoryId, int smallCategoryId,
			String memberId) {
		super();
		this.consumeId = consumeId;
		this.consumePrice = consumePrice;
		this.consumeDate = consumeDate;
		this.largeCategoryId = largeCategoryId;
		this.smallCategoryId = smallCategoryId;
		this.memberId = memberId;
	}
	
	public Consume(int consumeId, int consumePrice, String consumeDate, int largeCategoryId, String largeCategoryName,
			int smallCategoryId, String smallCategoryName, String memberId) {
		super();
		this.consumeId = consumeId;
		this.consumePrice = consumePrice;
		this.consumeDate = consumeDate;
		this.largeCategoryId = largeCategoryId;
		this.largeCategoryName = largeCategoryName;
		this.smallCategoryId = smallCategoryId;
		this.smallCategoryName = smallCategoryName;
		this.memberId = memberId;
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

	public int getLargeCategoryId() {
		return largeCategoryId;
	}

	public void setLargeCategoryId(int largeCategoryId) {
		this.largeCategoryId = largeCategoryId;
	}

	public String getLargeCategoryName() {
		return largeCategoryName;
	}

	public void setLaregeCategoryName(String largeCategoryName) {
		this.largeCategoryName = largeCategoryName;
	}

	public int getSmallCategoryId() {
		return smallCategoryId;
	}

	public void setSmallCategoryId(int smallCategoryId) {
		this.smallCategoryId = smallCategoryId;
	}

	public String getSmallCategoryName() {
		return smallCategoryName;
	}

	public void setSmallCategoryName(String smallCategoryName) {
		this.smallCategoryName = smallCategoryName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Consume [consumeId=" + consumeId + ", consumePrice=" + consumePrice + ", consumeDate=" + consumeDate
				+ ", largeCategoryId=" + largeCategoryId + ", largeCategoryName=" + largeCategoryName
				+ ", smallCategoryId=" + smallCategoryId + ", smallCategoryName=" + smallCategoryName + ", memberId="
				+ memberId + "]";
	}

}
