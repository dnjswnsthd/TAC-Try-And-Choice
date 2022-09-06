package com.service.tac.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.service.tac.model.vo.Calculation;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;

public interface CardCompareDAO {
	public ArrayList<CardDetail> getDiscountInfoByCard(int cardId) throws SQLException;
	
	public Card getCardInfo(int cardId) throws SQLException;
	
	public String getLargeCategoryName(int largeCategoryId) throws SQLException;
	
	public ArrayList<CardDetail> getBenefitsByCateg1(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg2(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg3(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg4(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg5(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg6(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg7(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg8(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg9(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg10(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg11(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg12(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg13(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg14(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg15(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg16(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg17(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg18(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg19(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg20(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg21(int cardId, String memberId) throws SQLException;
	public ArrayList<CardDetail> getBenefitsByCateg22(int cardId, String memberId) throws SQLException;
	
	public ArrayList<ConsumeAnalysis_LargeSum> AnalyseLC_SUM(String id) throws SQLException;
	
	public ArrayList<Calculation> getBenefitsByCategory(HashMap <String, Object> map) throws SQLException;
}
