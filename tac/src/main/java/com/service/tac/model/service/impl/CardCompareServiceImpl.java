package com.service.tac.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.tac.model.dao.AnalyseDAO;
import com.service.tac.model.dao.CardCompareDAO;
import com.service.tac.model.mapper.AnalyseMapper;
import com.service.tac.model.mapper.CardCompareMapper;
import com.service.tac.model.service.CardCompareService;
import com.service.tac.model.vo.Calculation;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;

@Service
public class CardCompareServiceImpl implements CardCompareService{
	
	@Autowired
	private CardCompareDAO cardCompoareDAO;
	
	@Autowired
	private AnalyseDAO analyseDAO;

	@Override
	public ArrayList<CardDetail> getDiscountInfoByCard(int cardId) throws SQLException {
		return cardCompoareDAO.getDiscountInfoByCard(cardId);
	}

	@Override
	public Card getCardInfo(int cardId) throws SQLException {
		return cardCompoareDAO.getCardInfo(cardId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg1(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg1(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg2(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg2(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg3(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg3(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg4(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg4(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg5(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg5(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg6(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg6(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg7(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg7(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg8(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg8(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg9(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg9(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg10(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg10(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg11(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg11(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg12(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg12(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg13(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg13(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg14(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg14(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg15(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg15(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg16(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg16(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg17(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg17(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg18(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg18(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg19(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg19(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg20(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg20(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg21(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg21(cardId, memberId);
	}

	@Override
	public ArrayList<CardDetail> getBenefitsByCateg22(int cardId, String memberId) throws SQLException {
		return cardCompoareDAO.getBenefitsByCateg22(cardId, memberId);
	}

	@Override
	public String getLargeCategoryName(int largeCategoryId) throws SQLException {
		return cardCompoareDAO.getLargeCategoryName(largeCategoryId);
	}

	@Override
	public ArrayList<ConsumeAnalysis_LargeSum> AnalyseLC_SUM(String id) throws SQLException {
		return analyseDAO.AnalyseLC_SUM(id);
	}

	@Override
	public ArrayList<Calculation> getBenefitsByCategory(HashMap<String, Object> map) throws SQLException {
		return cardCompoareDAO.getBenefitsByCategory(map);
	}
	
	
	

}
