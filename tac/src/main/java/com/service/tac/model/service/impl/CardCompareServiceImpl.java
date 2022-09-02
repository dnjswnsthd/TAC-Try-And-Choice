package com.service.tac.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.tac.model.mapper.AnalyseMapper;
import com.service.tac.model.mapper.CardCompareMapper;
import com.service.tac.model.service.CardCompareService;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;

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
	public ArrayList<CardDetail> getBenefitsByCateg1(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg1(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg2(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg2(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg3(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg3(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg4(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg4(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg5(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg5(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg6(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg6(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg7(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg7(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg8(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg8(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg9(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg9(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg10(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg10(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg11(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg11(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg12(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg12(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg13(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg13(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg14(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg14(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg15(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg15(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg16(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg16(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg17(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg17(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg18(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg18(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg19(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg19(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg20(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg20(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg21(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg21(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg22(int cardId, String memberId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getBenefitsByCateg22(cardId, memberId);
	}

	@Override
	public String getLargeCategoryName(int largeCategoryId) throws SQLException {
		return sqlSession.getMapper(CardCompareMapper.class).getLargeCategoryName(largeCategoryId);
	}

	@Override
	public ArrayList<ConsumeAnalysis_LargeSum> AnalyseLC_SUM(String id) throws SQLException {
		return sqlSession.getMapper(AnalyseMapper.class).AnalyseLC_SUM(id);
	}
	
	
	

}
