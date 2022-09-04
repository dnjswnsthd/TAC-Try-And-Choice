package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.service.tac.model.service.CardService;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.CardDetailManage;
import com.service.tac.model.vo.UploadDataVO;

@Controller
public class CardController {
	@Autowired
	CardService cardService;

	@PostMapping("/cardReg")
	@ResponseBody
	public HashMap<String, String> cardReg(@RequestParam Map<String, Object> map) {
		HashMap<String, String> hm = new HashMap<>();
		String cardName = (String) map.get("cardname");
		String cardDesc = (String) map.get("carddesc");
		String maxSale = (String) map.get("maxsale");
		String cardImg = (String) map.get("cardImg");
		
		
		Card card = new Card(cardName, cardDesc, maxSale, cardImg);
		System.out.println(card.toString());
		ArrayList<Card> list_card = null;
		try {
			cardService.registerCard(card);
			list_card = cardService.getAllCardInfo();
			for (Card c : list_card) {
				hm.put(Integer.toString(c.getCardId()), c.getCardName());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return hm;
	}
	
	@PostMapping("/getSelectCard")
	@ResponseBody
	public Card getSelectCard(@RequestParam Map<String, Object> map) {
		/* HashMap<String, String> hm = new HashMap<>(); */
		Card card = null;
		int cardId = Integer.parseInt((String) map.get("cardId"));
		try {
			card = cardService.getSelectedCard(cardId);
			return card;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@PostMapping("/getSelectCardDetail")
	@ResponseBody
	public ArrayList<CardDetailManage> getSelectCardDetail(@RequestParam Map<String, Object> map) {
		ArrayList<CardDetailManage> al = null;
		int cardId = Integer.parseInt((String) map.get("cardId"));
		try {
			al = cardService.getSelectedCardDetail(cardId);
			return al;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@PostMapping("/cardDetailDelete")
	@ResponseBody
	public ArrayList<CardDetailManage> cardDetailDelete(@RequestParam Map<String, Object> map) {
		ArrayList<CardDetailManage> al = null;
		int cardId = Integer.parseInt((String) map.get("cardId"));
		int cardDetailId = Integer.parseInt((String) map.get("cardDetailId"));
		try {
			cardService.cardDetailDelete(cardDetailId);
			al = cardService.getSelectedCardDetail(cardId);
			return al;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@PostMapping("/deleteCard")
	@ResponseBody
	public ArrayList<Card> deleteCard(@RequestParam Map<String, Object> map) {
		ArrayList<Card> card = null;
		int cardId = Integer.parseInt((String) map.get("cardId"));
		try {
			cardService.deleteCard(cardId);
			card = cardService.getAllCardInfo();
			return card;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@PutMapping("/updateCard")
	@ResponseBody
	public Card updateCard(@RequestParam Map<String, Object> map) {
		int cardId = Integer.parseInt((String) map.get("cardId"));
		String cardName = (String) map.get("cardName");
		String cardDesc = (String) map.get("cardDesc");
		String maxDiscount = (String) map.get("maxDiscount");
		Card card = null;
		try {
			cardService.updateCard(new Card(cardId, cardName, cardDesc, maxDiscount));
			card = cardService.getSelectedCard(cardId);
			return card;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@PutMapping("/updateCardDetail")
	@ResponseBody
	public ArrayList<CardDetailManage> updateCardDetail(@RequestParam Map<String, Object> map) {
		int cardId = Integer.parseInt((String) map.get("cardId"));
		int cardDetailId = Integer.parseInt((String) map.get("cardDetailId"));
		int discountPercent = Integer.parseInt((String) map.get("discountPercent"));
		int minPayment = Integer.parseInt((String) map.get("minPayment"));
		int maxDiscount = Integer.parseInt((String) map.get("maxDiscount"));
		int maxCount = Integer.parseInt((String) map.get("maxCount"));

		CardDetail cardDetail = new CardDetail(cardDetailId, discountPercent, minPayment, maxDiscount, maxCount);
		ArrayList<CardDetailManage> al = null;
		try {
			cardService.updateCardDetail(cardDetail);
			al = cardService.getSelectedCardDetail(cardId);
			System.out.println("성공");
			return al;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@PostMapping("/cardReg2")
	@ResponseBody
	public HashMap<String, String> cardReg2(UploadDataVO vo,
			@RequestParam(value = "cardImg") MultipartFile img,
			HttpServletRequest request) {
		HashMap<String, String> hm = new HashMap<>();
		System.out.println(vo.toString());
		
		// 1. 업로드 된 파일 정보를 가지고 있는 MultipartFile을 가장 먼저 받아옵니다.
		System.out.println("[Controller] getUploadfile " + img);
		System.out.println("[Controller] 파일의 사이즈 : " + img.getSize());
		System.out.println("[Controller] 파일의 이름 " + img.getName());
		System.out.println("[Controller] 파일의 오리지널 이름 " + img.getOriginalFilename());
		

		Card card = new Card(vo.getCardname(), vo.getCarddesc(), vo.getMaxsale() );
		ArrayList<Card> list_card = null;
		try {
			cardService.registerCard_Image(card, img, request);
			list_card = cardService.getAllCardInfo();
			for (Card c : list_card) {
				hm.put(Integer.toString(c.getCardId()), c.getCardName());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return hm;
	}
}
