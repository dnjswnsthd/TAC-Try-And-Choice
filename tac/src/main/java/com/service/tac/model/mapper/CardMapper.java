package com.service.tac.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;

public interface CardMapper {
	public ArrayList<Card> getAllCardInfo() throws SQLException;
	
	public ArrayList<CardDetail> getDiscountInfoByCard(int cardId) throws SQLException;
	
	public Card getCardInfo(int cardId) throws SQLException;
	
	public ArrayList<CardDetail> getBenefitsByCateg(int cardId, int categoryId) throws SQLException;
}
