package com.service.tac.model.vo;

// Table Name : Card_Detail
public class CardDetail {
	private int cardDetailId; // card_detail_id
	private int discountPercent; // discount_percent
	private int cardId; // card_idsel
	private int largeCategoryId; // LARGE_CATEGORY_ID
	private int smallCategoryId; // SMALL_CATEGORY_ID
	private int minPayment; // MIN_PAYMENT
	private int maxDiscount; // MAX_DISCOUNT
	private int mixCount; // MAX_COUNT
	
	private SmallCategory smallCategory; 
	
	public CardDetail() {
		super();
	}

	public CardDetail(int cardDetailId, int discountPercent, int cardId, int largeCategoryId, int smallCategoryId,
			int minPayment, int maxDiscount, int mixCount) {
		super();
		this.cardDetailId = cardDetailId;
		this.discountPercent = discountPercent;
		this.cardId = cardId;
		this.largeCategoryId = largeCategoryId;
		this.smallCategoryId = smallCategoryId;
		this.minPayment = minPayment;
		this.maxDiscount = maxDiscount;
		this.mixCount = mixCount;
	}
	
	public CardDetail(int cardDetailId, int discountPercent, int cardId, int largeCategoryId, int smallCategoryId,
			int minPayment, int maxDiscount, int mixCount, SmallCategory smallCategory) {
		super();
		this.cardDetailId = cardDetailId;
		this.discountPercent = discountPercent;
		this.cardId = cardId;
		this.largeCategoryId = largeCategoryId;
		this.smallCategoryId = smallCategoryId;
		this.minPayment = minPayment;
		this.maxDiscount = maxDiscount;
		this.mixCount = mixCount;
		this.smallCategory = smallCategory;
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

	public int getMixCount() {
		return mixCount;
	}

	public void setMixCount(int mixCount) {
		this.mixCount = mixCount;
	}

	public SmallCategory getSmallCategory() {
		return smallCategory;
	}

	public void setSmallCategory(SmallCategory smallCategory) {
		this.smallCategory = smallCategory;
	}

	@Override
	public String toString() {
		return "CardDetail [cardDetailId=" + cardDetailId + ", discountPercent=" + discountPercent + ", cardId="
				+ cardId + ", largeCategoryId=" + largeCategoryId + ", smallCategoryId=" + smallCategoryId
				+ ", minPayment=" + minPayment + ", maxDiscount=" + maxDiscount + ", mixCount=" + mixCount
				+ ", smallCategory=" + smallCategory + "]";
	}

	

}
