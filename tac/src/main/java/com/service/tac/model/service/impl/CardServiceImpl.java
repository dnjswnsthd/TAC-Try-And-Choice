package com.service.tac.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.tac.model.mapper.CardMapper;
import com.service.tac.model.service.CardService;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;

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
