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
	private int maxCount; // MAX_COUNT
	private int mixCount; // MAX_COUNT
	private int discountAmount; //discount_amount
	private int maxDiscountMonth; //max_discount_month
	
	private SmallCategory smallCategory; 
	private LargeCategory largeCategory;
	private Consume consume;
	
	public CardDetail() {
		super();
	}

	public CardDetail(int cardDetailId, int discountPercent, int cardId, int largeCategoryId, int smallCategoryId,
			int minPayment, int maxDiscount, int maxCount) {
		super();
		this.cardDetailId = cardDetailId;
		this.discountPercent = discountPercent;
		this.cardId = cardId;
		this.largeCategoryId = largeCategoryId;
		this.smallCategoryId = smallCategoryId;
		this.minPayment = minPayment;
		this.maxDiscount = maxDiscount;
		this.maxCount = maxCount;
	}
	
	public CardDetail(int discountPercent, int cardId, int largeCategoryId, int smallCategoryId,
			int minPayment, int maxDiscount, int maxCount) {
		super();
		this.discountPercent = discountPercent;
		this.cardId = cardId;
		this.largeCategoryId = largeCategoryId;
		this.smallCategoryId = smallCategoryId;
		this.minPayment = minPayment;
		this.maxDiscount = maxDiscount;
		this.maxCount = maxCount;
	}
	
	public CardDetail(int cardDetailId, int discountPercent, int cardId, int largeCategoryId, int smallCategoryId,
			int minPayment, int maxDiscount, int mixCount,int discountAmount, int maxDiscountMonth, SmallCategory smallCategory) {
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
		this.discountAmount = discountAmount;
		this.maxDiscountMonth = maxDiscountMonth;
	}
	
	public CardDetail(int cardDetailId, int discountPercent, int cardId, int largeCategoryId, int smallCategoryId,
			int minPayment, int maxDiscount, int mixCount, int discountAmount, int maxDiscountMonth,
			SmallCategory smallCategory, LargeCategory largeCategory, Consume consume) {
		super();
		this.cardDetailId = cardDetailId;
		this.discountPercent = discountPercent;
		this.cardId = cardId;
		this.largeCategoryId = largeCategoryId;
		this.smallCategoryId = smallCategoryId;
		this.minPayment = minPayment;
		this.maxDiscount = maxDiscount;
		this.mixCount = mixCount;
		this.discountAmount = discountAmount;
		this.maxDiscountMonth = maxDiscountMonth;
		this.smallCategory = smallCategory;
		this.largeCategory = largeCategory;
		this.consume = consume;
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
		return maxCount;
	}

	public void setMixCount(int mixCount) {
		this.maxCount = mixCount;
	}

	public SmallCategory getSmallCategory() {
		return smallCategory;
	}

	public void setSmallCategory(SmallCategory smallCategory) {
		this.smallCategory = smallCategory;
	}

	public LargeCategory getLargeCategory() {
		return largeCategory;
	}

	public void setLargeCategory(LargeCategory largeCategory) {
		this.largeCategory = largeCategory;
	}

	public Consume getConsume() {
		return consume;
	}

	public void setConsume(Consume consume) {
		this.consume = consume;
	}

	public int getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	public int getMaxDiscountMonth() {
		return maxDiscountMonth;
	}

	public void setMaxDiscountMonth(int maxDiscountMonth) {
		this.maxDiscountMonth = maxDiscountMonth;
	}

	@Override
	public String toString() {
		return "CardDetail [cardDetailId=" + cardDetailId + ", discountPercent=" + discountPercent + ", cardId="
				+ cardId + ", largeCategoryId=" + largeCategoryId + ", smallCategoryId=" + smallCategoryId
				+ ", minPayment=" + minPayment + ", maxDiscount=" + maxDiscount + ", mixCount=" + mixCount
				+ ", discountAmount=" + discountAmount + ", maxDiscountMonth=" + maxDiscountMonth + ", smallCategory="
				+ smallCategory + ", largeCategory=" + largeCategory + ", consume=" + consume + "]";
	}

	

	

}
