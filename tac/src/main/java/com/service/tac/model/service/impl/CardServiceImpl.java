package com.service.tac.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.tac.model.mapper.CardMapper;
import com.service.tac.model.service.CardService;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.CardDetailManage;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<Card> getAllCardInfo() throws SQLException {
		return sqlSession.getMapper(CardMapper.class).getAllCardInfo();
	}

	@Override
	public HashMap<String, Integer> discountByCategory(int userId, int cardId) throws SQLException {
		return null;
	}

	
	@Override
	public int registerCard(Card card) throws SQLException {
		return sqlSession.getMapper(CardMapper.class).registerCard(card);
	}

	@Override
	public int editCard(Card card) throws SQLException {
		return 0;
	}

	@Override
	public int deleteCard(int cardId) throws SQLException {
		return 0;
	}

	@Override
	public ArrayList<CardDetail> getDiscountInfoByCard(int cardId) throws SQLException {
		
		return sqlSession.getMapper(CardMapper.class).getDiscountInfoByCard(cardId);
	}

	@Override
	public Card getSelectedCard(int cardId) throws SQLException {
		return sqlSession.getMapper(CardMapper.class).getSelectedCard(cardId);
	}

	@Override
	public ArrayList<CardDetailManage> getSelectedCardDetail(int cardId) throws SQLException {
		return sqlSession.getMapper(CardMapper.class).getSelectedCardDetail(cardId);
	}
	
	@Override
	public int updateCard(Card card) throws SQLException {
		return sqlSession.getMapper(CardMapper.class).updateCard(card);
	}
}
