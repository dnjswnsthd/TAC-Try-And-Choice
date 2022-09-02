package com.service.tac.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.CardDetailManage;

public interface CardMapper {
	public ArrayList<Card> getAllCardInfo() throws SQLException;

	public int registerCard(Card card) throws SQLException;

	public ArrayList<CardDetail> getDiscountInfoByCard(int cardId) throws SQLException;
	
	public Card getCardInfo(int cardId) throws SQLException;
	
	public Card getSelectedCard(int cardId) throws SQLException;
	
	public ArrayList<CardDetailManage> getSelectedCardDetail(int cardId) throws SQLException;
	
	public int updateCard(Card card) throws SQLException;
}
