package com.service.tac.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;

public interface CardCompareService {
	// 카드 할인정보 가져오기
		public ArrayList<CardDetail> getDiscountInfoByCard(int cardId) throws SQLException;
		
		// 카드 정보 가져오기(객체 만들어서 card vo에 cardDetail객체로 생성해서 넣어줄 예정)
		public Card getCardInfo(int cardId) throws SQLException;
		
		// 소비에 따른 카드별 혜택 금액 확인
		public ArrayList<CardDetail> getBenefitsByCateg1(int cardId) throws SQLException; 
		public ArrayList<CardDetail> getBenefitsByCateg2(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg3(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg4(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg5(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg6(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg7(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg8(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg9(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg10(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg11(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg12(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg13(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg14(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg15(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg16(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg17(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg18(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg19(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg20(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg21(int cardId) throws SQLException;
		public ArrayList<CardDetail> getBenefitsByCateg22(int cardId) throws SQLException;
}
