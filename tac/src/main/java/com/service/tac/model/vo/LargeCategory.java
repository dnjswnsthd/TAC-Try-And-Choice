package com.service.tac.model.vo;

// Table Name: large_category
public class LargeCategory {
	private int LargeCategoryId; // LARGE_CATEGORY_ID
	private String LargeCategoryName; // LARGE_CATEGORY_NAME
	private String LargeCategoryImage; // LARGE_CATEGORY_NAME_IMAGE
	
	public LargeCategory() {};
	public LargeCategory(int largeCategoryId, String largeCategoryName, String largeCategoryImage) {
		super();
		LargeCategoryId = largeCategoryId;
		LargeCategoryName = largeCategoryName;
		LargeCategoryImage = largeCategoryImage;
	}
	
	public int getLargeCategoryId() {
		return LargeCategoryId;
	}
	public void setLargeCategoryId(int largeCategoryId) {
		LargeCategoryId = largeCategoryId;
	}
	public String getLargeCategoryName() {
		return LargeCategoryName;
	}
	public void setLargeCategoryName(String largeCategoryName) {
		LargeCategoryName = largeCategoryName;
	}
	public String getLargeCategoryImage() {
		return LargeCategoryImage;
	}
	public void setLargeCategoryImage(String largeCategoryImage) {
		LargeCategoryImage = largeCategoryImage;
	}
	
	@Override
	public String toString() {
		return "LargeCategory [LargeCategoryId=" + LargeCategoryId + ", LargeCategoryName=" + LargeCategoryName
				+ ", LargeCategoryImage=" + LargeCategoryImage + "]";
	}
}
