package com.service.tac.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;

public interface CardMapper {
	public ArrayList<Card> getAllCardInfo() throws SQLException;
	
	
}
