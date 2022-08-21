package com.service.tac.model.vo;

// Table Name : Card_Detail
public class CardDetail {
	private int cardDetailId; // card_detail_id
	private int discountPercent; // discount_percent
	private int cardId; // card_id
	private int largeCategoryId; // LARGE_CATEGORY_ID
	private int smallCategoryId; // SMALL_CATEGORY_ID

	public CardDetail() {
		super();
	}

	public CardDetail(int cardDetailId, int discountPercent, int cardId, int largeCategoryId, int smallCategoryId) {
		super();
		this.cardDetailId = cardDetailId;
		this.discountPercent = discountPercent;
		this.cardId = cardId;
		this.largeCategoryId = largeCategoryId;
		this.smallCategoryId = smallCategoryId;
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

	@Override
	public String toString() {
		return "CardDetail [cardDetailId=" + cardDetailId + ", discountPercent=" + discountPercent + ", cardId="
				+ cardId + ", largeCategoryId=" + largeCategoryId + ", smallCategoryId=" + smallCategoryId + "]";
	}

}
