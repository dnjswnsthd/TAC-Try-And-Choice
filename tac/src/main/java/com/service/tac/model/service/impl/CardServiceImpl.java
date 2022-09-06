package com.service.tac.model.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.service.tac.model.dao.CardDAO;
import com.service.tac.model.mapper.CardMapper;
import com.service.tac.model.service.CardService;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.CardDetailManage;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardDAO cardDAO;
	
	@Override
	public ArrayList<Card> getAllCardInfo() throws SQLException {
		return cardDAO.getAllCardInfo();
	}

	@Override
	public int cardDetailDelete(int cardDetailId) throws SQLException {
		return cardDAO.cardDetailDelete(cardDetailId);
	}

	@Override
	public int registerCard(Card card) throws SQLException {
		return cardDAO.registerCard(card);
	}

	@Override
	public int deleteCard(int cardId, String delImg, HttpServletRequest request) throws SQLException {
		return cardDAO.deleteCard(cardId, delImg, request);
	}

	@Override
	public ArrayList<CardDetail> getDiscountInfoByCard(int cardId) throws SQLException {
		return cardDAO.getDiscountInfoByCard(cardId);
	}

	@Override
	public Card getSelectedCard(int cardId) throws SQLException {
		return cardDAO.getSelectedCard(cardId);
	}

	@Override
	public ArrayList<CardDetailManage> getSelectedCardDetail(int cardId) throws SQLException {
		return cardDAO.getSelectedCardDetail(cardId);
	}

	@Override
	public int updateCard(Card card) throws SQLException {
		return cardDAO.updateCard(card);
	}

	@Override
	public int updateCardDetail(CardDetail cardDetail) throws SQLException {
		return cardDAO.updateCardDetail(cardDetail);
	}

	@Override
	public int registerCard_Image(Card card, MultipartFile imgfile, HttpServletRequest request) throws SQLException {
        return cardDAO.registerCard_Image(card, imgfile, request);
	}

	@Override
	public int updateCard2(Card card, MultipartFile img, HttpServletRequest request) throws SQLException {
        return cardDAO.updateCard2(card, img, request);
	}

}
