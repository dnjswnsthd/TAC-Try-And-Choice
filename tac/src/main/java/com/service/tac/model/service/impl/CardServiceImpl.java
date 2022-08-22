package com.service.tac.model.service.impl;

import java.sql.SQLException;
import java.util.HashMap;

import com.service.tac.model.service.CardService;
import com.service.tac.model.vo.Card;

public class CardServiceImpl implements CardService {

	@Override
	public HashMap<String, Integer> discountByCategory(int userId, int cardId) throws SQLException {
		return null;
	}

	@Override
	public Card getCardInfo(int cardId) throws SQLException {
		return null;
	}

	@Override
	public int registerCard(Card card) throws SQLException {
		return 0;
	}

	@Override
	public int editCard(Card card) throws SQLException {
		return 0;
	}

	@Override
	public int deleteCard(int cardId) throws SQLException {
		return 0;
	}

}
