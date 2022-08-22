package com.service.tac.model.service;

import java.sql.SQLException;

public interface CategoryService {
	// 대분류 추가
	public int registerLargeCategory(String largeCategoryName) throws SQLException;

	// 대분류 삭제
	public int deleteLargeCategory(String largeCategoryName) throws SQLException;

	// 소분류 추가
	public int registerSmallCategory(String smallCategoryName) throws SQLException;

	// 소분류 삭제
	public int deleteSmallCategory(String smallCategoryName) throws SQLException;
}
