package com.service.tac.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.Card;

public interface CardMapper {
	public ArrayList<Card> getAllCardInfo() throws SQLException;

	public int insertC(Card card) throws SQLException;
}
