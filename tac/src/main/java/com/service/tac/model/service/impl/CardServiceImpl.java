package com.service.tac.model.service.impl;

import java.io.File;
import java.io.IOException;
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
	public int cardDetailDelete(int cardDetailId) throws SQLException {
		return sqlSession.getMapper(CardMapper.class).cardDetailDelete(cardDetailId);
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
		return sqlSession.getMapper(CardMapper.class).deleteCard(cardId);
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

	@Override
	public int updateCardDetail(CardDetail cardDetail) throws SQLException {
		return sqlSession.getMapper(CardMapper.class).updateCardDetail(cardDetail);
	}

	@Override
	public int registerCard_Image(Card card, MultipartFile imgfile, HttpServletRequest request) throws SQLException {
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root + "resources\\image\\card\\";

		UUID uuid = UUID.randomUUID();
        String extension = FilenameUtils.getExtension(imgfile.getOriginalFilename());
        String savingFileName = uuid + "." + extension; 
		File copyFile = new File(path + savingFileName);
        
		try {
			imgfile.transferTo(copyFile);
			card.setCardImg(savingFileName);
			return sqlSession.getMapper(CardMapper.class).registerCardImportImage(card);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

        return 0;
	}

}
