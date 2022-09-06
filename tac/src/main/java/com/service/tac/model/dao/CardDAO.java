package com.service.tac.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.CardDetailManage;

public interface CardDAO {
	public ArrayList<Card> getAllCardInfo() throws SQLException;
	
	public Card getSelectedCard(int cardId) throws SQLException;
	
	public ArrayList<CardDetailManage> getSelectedCardDetail(int cardId) throws SQLException;

	public int cardDetailDelete(int cardDetailId) throws SQLException;
	
	public int registerCard(Card card) throws SQLException;

	public int deleteCard(int cardId, String delImg, HttpServletRequest request) throws SQLException;

	public int updateCard(Card card) throws SQLException;

	public int updateCardDetail(CardDetail cardDetail) throws SQLException;
	
	public ArrayList<CardDetail> getDiscountInfoByCard(int cardId) throws SQLException;
		
	public int registerCard_Image(Card card, MultipartFile imgfile, HttpServletRequest request) throws SQLException;
	
	public int updateCard2(Card card,MultipartFile img, HttpServletRequest request) throws SQLException;
}
