package com.service.tac.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.tac.controller.CardCompareController;
import com.service.tac.model.mapper.CardCompareMapper;
import com.service.tac.model.service.CardCompareService;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;

@Service
public class CardCompareServiceImpl implements CardCompareService{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<CardDetail> getDiscountInfoByCard(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getDiscountInfoByCard(cardId);
	}

	@Override
	public Card getCardInfo(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getCardInfo(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg1(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg1(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg2(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg2(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg3(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg3(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg4(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg4(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg5(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg5(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg6(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg6(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg7(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg7(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg8(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg8(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg9(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg9(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg10(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg10(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg11(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg11(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg12(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg12(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg13(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg13(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg14(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg14(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg15(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg15(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg16(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg16(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg17(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg17(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg18(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg18(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg19(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg19(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg20(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg20(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg21(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg21(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg22(int cardId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg22(cardId);
	}
	
	
	

}
