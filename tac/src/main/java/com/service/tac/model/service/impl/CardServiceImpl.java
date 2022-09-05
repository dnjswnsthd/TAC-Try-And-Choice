package com.service.tac.model.service.impl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.imageio.ImageIO;
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
	public int deleteCard(int cardId, String delImg, HttpServletRequest request) throws SQLException {
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root + "resources\\image\\card\\";
		
		if ( !delImg.equals("card_none.png")) {
			// 서버에 있는 파일 삭제
			// 1.
			path = root + "resources\\image\\card\\";
			File file = new File(path + delImg);
			if( file.exists() ) {
	        	file.delete();
	        }
			// 2. 호라이즌 
			path = root + "resources\\image\\card_horizon\\";
			file = new File(path + delImg);
			if( file.exists() ) {
	        	file.delete();
	        }
		}
		
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
		String path = "";
		
		UUID uuid = UUID.randomUUID();
        String extension = FilenameUtils.getExtension(imgfile.getOriginalFilename());
        String savingFileName = uuid + "." + extension; 
        
		try {
			// 일단 호라이즌 넣기 // 가로는 바로 넣어도 됨
	 		path = root + "resources\\image\\card_horizon\\";
	 		File copyFile2 = new File(path + savingFileName);
	 		// 가로에는 바로 저장
			imgfile.transferTo(copyFile2);
			
			// 돌려서 넣어야함
			path = root + "resources\\image\\card\\";
			File copyFile = new File(path + savingFileName);
			
			BufferedImage oldImage = ImageIO.read(copyFile2);	
			BufferedImage newImage = new BufferedImage(oldImage.getHeight(), oldImage.getWidth(), oldImage.getType());
			Graphics2D graphics = (Graphics2D) newImage.getGraphics();
			graphics.rotate(Math.toRadians(90), newImage.getWidth() / 2, newImage.getHeight() / 2);
			graphics.translate((newImage.getWidth() - oldImage.getWidth()) / 2, (newImage.getHeight() - oldImage.getHeight()) / 2);
			graphics.drawImage(oldImage, 0, 0, oldImage.getWidth(), oldImage.getHeight(), null);
			// 파일 넣어주기
			FileOutputStream fo = new FileOutputStream(copyFile);
			ImageIO.write(newImage, extension, fo);
			fo.close();
			
			card.setCardImg(savingFileName);
			card.setCardImgHorizon(savingFileName);
			return sqlSession.getMapper(CardMapper.class).registerCardImportImage(card);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

        return 0;
	}

	@Override
	public int updateCard2(Card card, MultipartFile img, HttpServletRequest request) throws SQLException {
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = "";
		
		// 기존 이미지는 삭제하기 
		String deleteImg = card.getCardImg();
		if ( !deleteImg.equals("card_none.png")) {
			// 서버에 있는 파일 삭제
			// 1.
			path = root + "resources\\image\\card\\";
			File file = new File(path + deleteImg);
			if( file.exists() ) {
				file.delete();
	        }
			// 2. 호라이즌 
			path = root + "resources\\image\\card_horizon\\";
			file = new File(path + deleteImg);
			if( file.exists() ) {
				file.delete();
	        }
		}
		
        // 새로운 이미지 추가
		UUID uuid = UUID.randomUUID();
        String extension = FilenameUtils.getExtension(img.getOriginalFilename());
        String savingFileName = uuid + "." + extension; 
		
		try {
			// 일단 호라이즌 넣기 // 가로는 바로 넣어도 됨
	 		path = root + "resources\\image\\card_horizon\\";
	 		File copyFile2 = new File(path + savingFileName);
	 		// 가로에는 바로 저장
	 		img.transferTo(copyFile2);
			
			// 돌려서 넣어야함
			path = root + "resources\\image\\card\\";
			File copyFile = new File(path + savingFileName);
			
			BufferedImage oldImage = ImageIO.read(copyFile2);	
			BufferedImage newImage = new BufferedImage(oldImage.getHeight(), oldImage.getWidth(), oldImage.getType());
			Graphics2D graphics = (Graphics2D) newImage.getGraphics();
			graphics.rotate(Math.toRadians(90), newImage.getWidth() / 2, newImage.getHeight() / 2);
			graphics.translate((newImage.getWidth() - oldImage.getWidth()) / 2, (newImage.getHeight() - oldImage.getHeight()) / 2);
			graphics.drawImage(oldImage, 0, 0, oldImage.getWidth(), oldImage.getHeight(), null);
			// 파일 넣어주기
			FileOutputStream fo = new FileOutputStream(copyFile);
			ImageIO.write(newImage, extension, fo);
			fo.close();
			
			card.setCardImg(savingFileName);
			card.setCardImgHorizon(savingFileName);
			return sqlSession.getMapper(CardMapper.class).updateCard2(card);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return 0;
	}

}
