package com.service.tac.model.vo;

// Table Name: large_category
public class SmallCategory {
	private int smallCategoryId; // SMALL_CATEGORY_ID
	private String smallCategoryName; // SMALL_CATEGORY_NAME
	private int largeCategoryId; // LARGE_CATEGORY_ID

	public SmallCategory() {
		super();
	}

	public SmallCategory(int smallCategoryId, String smallCategoryName, int largeCategoryId) {
		super();
		this.smallCategoryId = smallCategoryId;
		this.smallCategoryName = smallCategoryName;
		this.largeCategoryId = largeCategoryId;
	}
	
	public SmallCategory(String smallCategoryName, int largeCategoryId) {
		super();
		this.smallCategoryName = smallCategoryName;
		this.largeCategoryId = largeCategoryId;
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

	public int getLargeCategoryId() {
		return largeCategoryId;
	}

	public void setLargeCategoryId(int largeCategoryId) {
		this.largeCategoryId = largeCategoryId;
	}

	@Override
	public String toString() {
		return "SmallCategory [smallCategoryId=" + smallCategoryId + ", smallCategoryName=" + smallCategoryName
				+ ", largeCategoryId=" + largeCategoryId + "]";
	}

}
