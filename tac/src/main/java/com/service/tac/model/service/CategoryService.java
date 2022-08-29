package com.service.tac.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.LargeCategory;
import com.service.tac.model.vo.SmallCategory;

public interface CategoryService {
	// 대분류 검색
	public ArrayList<LargeCategory> getAllLargeCategory() throws SQLException;

	// 대분류 추가
	public int registerLargeCategory(String largeCategoryName) throws SQLException;

	// 대분류 삭제
	public int deleteLargeCategory(String largeCategoryName) throws SQLException;

	// 소분류 검색
	public ArrayList<SmallCategory> getSmallCategory(int largeCategoryId) throws SQLException;

	// 소분류 추가
	public int registerSmallCategory(String smallCategoryName) throws SQLException;

	// 소분류 삭제
	public int deleteSmallCategory(String smallCategoryName) throws SQLException;
}
