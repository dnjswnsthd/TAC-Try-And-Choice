package com.service.tac.model.vo;

// Table Name: large_category
public class LargeCategory {
	private int LargeCategoryId; // LARGE_CATEGORY_ID
	private String LargeCategoryName; // LARGE_CATEGORY_NAME

	public LargeCategory() {
		super();
	}

	public LargeCategory(int largeCategoryId, String largeCategoryName) {
		super();
		LargeCategoryId = largeCategoryId;
		LargeCategoryName = largeCategoryName;
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

	@Override
	public String toString() {
		return "LargeCategory [LargeCategoryId=" + LargeCategoryId + ", LargeCategoryName=" + LargeCategoryName + "]";
	}

}
