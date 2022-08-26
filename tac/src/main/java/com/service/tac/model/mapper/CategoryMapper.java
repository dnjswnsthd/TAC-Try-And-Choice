package com.service.tac.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.LargeCategory;
import com.service.tac.model.vo.SmallCategory;

public interface CategoryMapper {
	// 대분류 검색
	public ArrayList<LargeCategory> getAllLargeCategory() throws SQLException;

	// 소분류 검색
	public ArrayList<SmallCategory> getSmallCategory(int largeCategoryId) throws SQLException;
}
