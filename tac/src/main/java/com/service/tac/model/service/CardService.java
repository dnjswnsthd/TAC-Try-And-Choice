package com.service.tac.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.CardDetailManage;

public interface CardService {
	
	// 전체 카드 정보 가져오기
	public ArrayList<Card> getAllCardInfo() throws SQLException;
	
	// 선택된 카드 정보 가져오기
	public Card getSelectedCard(int cardId) throws SQLException;
	
	// 선택된 카드 상세 정보 가져오기
	public ArrayList<CardDetailManage> getSelectedCardDetail(int cardId) throws SQLException;

	// 카테고리별 할인 금액 합계와 전체 합계 금액 가져오기
	public HashMap<String, Integer> discountByCategory(int userId, int cardId) throws SQLException;
	
	// 카드 할인정보 가져오기
	public ArrayList<CardDetail> getDiscountInfoByCard(int cardId) throws SQLException;
	
	// 카드 정보 가져오기(객체 만들어서 card vo에 cardDetail객체로 생성해서 넣어줄 예정)
	public Card getCardInfo(int cardId) throws SQLException;
	
	// 신규 카드 등록 (Detail도 같이 받아와야함 인자 수정) 
	public int registerCard(Card card) throws SQLException;

	// 카드 수정 (Detail도 같이 받아와야함 인자 수정) 
	public int editCard(Card card) throws SQLException;
	
	// 기존 카드 삭제 (관련된 cardDetail 삭제 cascade)
	public int deleteCard(int cardId) throws SQLException;

	// 카드 정보 수정
	public int updateCard(Card card) throws SQLException;
}
