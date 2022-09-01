package com.service.tac.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;

public interface CardService {
	
	// 전체 카드 정보 가져오기
	public ArrayList<Card> getAllCardInfo() throws SQLException;

	// 카테고리별 할인 금액 합계와 전체 합계 금액 가져오기
	public HashMap<String, Integer> discountByCategory(int userId, int cardId) throws SQLException;
			
	// 신규 카드 등록 (Detail도 같이 받아와야함 인자 수정) 
	public int registerCard(Card card) throws SQLException;

	// 카드 수정 (Detail도 같이 받아와야함 인자 수정) 
	public int editCard(Card card) throws SQLException;
	
	// 기존 카드 삭제 (관련된 cardDetail 삭제 cascade)
	public int deleteCard(int cardId) throws SQLException;
}
