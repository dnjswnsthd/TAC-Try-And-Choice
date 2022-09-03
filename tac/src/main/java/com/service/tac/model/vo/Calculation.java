package com.service.tac.model.vo;

public class Calculation {
	private int largeCategoryId; // large_category_id
	private String largeCategoryName; // large_category_name
	private String largeCategoryImage; // large_category_image
	private int categoryDiscountPrice; // category_discount_price;
	private int maxCount; // max_count;
	private int selectCardDiscountPrice;
	private int myCardDiscountPrice;

	public Calculation() {
		super();
	}
	
	public Calculation(String largeCategoryName, String largeCategoryImage, int categoryDiscountPrice) {
		super();
		this.largeCategoryName = largeCategoryName;
		this.largeCategoryImage = largeCategoryImage;
		this.categoryDiscountPrice = categoryDiscountPrice;
	}
	
	public Calculation(String largeCategoryName, String largeCategoryImage, int categoryDiscountPrice, int selectCardDiscountPrice, int myCardDiscountPrice) {
		super();
		this.largeCategoryName = largeCategoryName;
		this.largeCategoryImage = largeCategoryImage;
		this.categoryDiscountPrice = categoryDiscountPrice;
		this.selectCardDiscountPrice = selectCardDiscountPrice;
		this.myCardDiscountPrice = myCardDiscountPrice;
	}

	public Calculation(int largeCategoryId, String largeCategoryName, String largeCategoryImage, int categoryDiscountPrice, int maxCount) {
		super();
		this.largeCategoryId = largeCategoryId;
		this.largeCategoryName = largeCategoryName;
		this.largeCategoryImage = largeCategoryImage;
		this.categoryDiscountPrice = categoryDiscountPrice;
		this.maxCount = maxCount;
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

	public void setLargeCategoryName(String largeCategoryName) {
		this.largeCategoryName = largeCategoryName;
	}

	public String getLargeCategoryImage() {
		return largeCategoryImage;
	}

	public void setLargeCategoryImage(String largeCategoryImage) {
		this.largeCategoryImage = largeCategoryImage;
	}

	public int getCategoryDiscountPrice() {
		return categoryDiscountPrice;
	}

	public void setCategoryDiscountPrice(int categoryDiscountPrice) {
		this.categoryDiscountPrice = categoryDiscountPrice;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public int getSelectCardDiscountPrice() {
		return selectCardDiscountPrice;
	}

	public void setSelectCardDiscountPrice(int selectCardDiscountPrice) {
		this.selectCardDiscountPrice = selectCardDiscountPrice;
	}

	public int getMyCardDiscountPrice() {
		return myCardDiscountPrice;
	}

	public void setMyCardDiscountPrice(int myCardDiscountPrice) {
		this.myCardDiscountPrice = myCardDiscountPrice;
	}

	@Override
	public String toString() {
		return "Calculation [largeCategoryId=" + largeCategoryId + ", largeCategoryName=" + largeCategoryName
				+ ", largeCategoryImage=" + largeCategoryImage + ", categoryDiscountPrice=" + categoryDiscountPrice
				+ ", maxCount=" + maxCount + ", selectCardDiscountPrice=" + selectCardDiscountPrice
				+ ", myCardDiscountPrice=" + myCardDiscountPrice + "]";
	}
}
