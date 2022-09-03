package com.service.tac.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.tac.model.mapper.CardMapper;
import com.service.tac.model.mapper.CategoryMapper;
import com.service.tac.model.service.CategoryService;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.LargeCategory;
import com.service.tac.model.vo.SmallCategory;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<LargeCategory> getAllLargeCategory() throws SQLException {
		return sqlSession.getMapper(CategoryMapper.class).getAllLargeCategory();
	}

	@Override
	public int registerLargeCategory(String largeCategoryName) throws SQLException {
		return sqlSession.getMapper(CategoryMapper.class).registerLargeCategory(largeCategoryName);
	}

	@Override
	public int deleteLargeCategory(String largeCategoryName) throws SQLException {
		return sqlSession.getMapper(CategoryMapper.class).deleteLargeCategory(largeCategoryName);
	}
	
	@Override
	public ArrayList<SmallCategory> getSmallCategory(int largeCategoryId) throws SQLException {
		return sqlSession.getMapper(CategoryMapper.class).getSmallCategory(largeCategoryId);
	}

	@Override
	public int registerSmallCategory(SmallCategory smallCategory) throws SQLException {
		return sqlSession.getMapper(CategoryMapper.class).registerSmallCategory(smallCategory);
	}

	@Override
	public int deleteSmallCategory(String smallCategoryName) throws SQLException {
		return sqlSession.getMapper(CategoryMapper.class).deleteSmallCategory(smallCategoryName);
	}

	@Override
	public int registerCardDetail(CardDetail cardDetail) throws SQLException {
		return sqlSession.getMapper(CategoryMapper.class).registerCardDetail(cardDetail);
	}

}
