package com.service.tac.model.vo;

public class CardDetailManage {
	private int cardDetailId; // card_detail_id
	private int discountPercent; // discount_percent
	private int cardId; // card_idsel
	private int largeCategoryId; // LARGE_CATEGORY_ID
	private int smallCategoryId; // SMALL_CATEGORY_ID
	private String largeCategoryName; // LARGE_CATEGORY_ID
	private String smallCategoryName; // SMALL_CATEGORY_ID
	private int minPayment; // MIN_PAYMENT
	private int maxDiscount; // MAX_DISCOUNT
	private int maxCount; // MAX_COUNT
	private int mixCount; // MAX_COUNT

	public CardDetailManage() {
		super();
	}

	public CardDetailManage(int cardDetailId, int discountPercent, int cardId, int largeCategoryId, int smallCategoryId,
			String largeCategoryName, String smallCategoryName, int minPayment, int maxDiscount, int maxCount,
			int mixCount) {
		super();
		this.cardDetailId = cardDetailId;
		this.discountPercent = discountPercent;
		this.cardId = cardId;
		this.largeCategoryId = largeCategoryId;
		this.smallCategoryId = smallCategoryId;
		this.largeCategoryName = largeCategoryName;
		this.smallCategoryName = smallCategoryName;
		this.minPayment = minPayment;
		this.maxDiscount = maxDiscount;
		this.maxCount = maxCount;
		this.mixCount = mixCount;
	}

	public int getCardDetailId() {
		return cardDetailId;
	}

	public void setCardDetailId(int cardDetailId) {
		this.cardDetailId = cardDetailId;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getLargeCategoryId() {
		return largeCategoryId;
	}

	public void setLargeCategoryId(int largeCategoryId) {
		this.largeCategoryId = largeCategoryId;
	}

	public int getSmallCategoryId() {
		return smallCategoryId;
	}

	public void setSmallCategoryId(int smallCategoryId) {
		this.smallCategoryId = smallCategoryId;
	}

	public String getLargeCategoryName() {
		return largeCategoryName;
	}

	public void setLargeCategoryName(String largeCategoryName) {
		this.largeCategoryName = largeCategoryName;
	}

	public String getSmallCategoryName() {
		return smallCategoryName;
	}

	public void setSmallCategoryName(String smallCategoryName) {
		this.smallCategoryName = smallCategoryName;
	}

	public int getMinPayment() {
		return minPayment;
	}

	public void setMinPayment(int minPayment) {
		this.minPayment = minPayment;
	}

	public int getMaxDiscount() {
		return maxDiscount;
	}

	public void setMaxDiscount(int maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public int getMixCount() {
		return mixCount;
	}

	public void setMixCount(int mixCount) {
		this.mixCount = mixCount;
	}

	@Override
	public String toString() {
		return "CardDetailManage [cardDetailId=" + cardDetailId + ", discountPercent=" + discountPercent + ", cardId="
				+ cardId + ", largeCategoryId=" + largeCategoryId + ", smallCategoryId=" + smallCategoryId
				+ ", largeCategoryName=" + largeCategoryName + ", smallCategoryName=" + smallCategoryName
				+ ", minPayment=" + minPayment + ", maxDiscount=" + maxDiscount + ", maxCount=" + maxCount
				+ ", mixCount=" + mixCount + "]";
	}

}
