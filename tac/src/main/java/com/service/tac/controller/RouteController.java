package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.tac.model.service.CardService;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;

@Controller
public class RouteController {
	
	@Autowired
	CardService cardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String intro() {
		return "intro";
	}

	@GetMapping(value = "/main")
	public String main(Model model) {
		try {
			ArrayList <Card> list = cardService.getAllCardInfo();
			model.addAttribute("list", list);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "/main/main";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		return "/member/signup";
	}
	
	@RequestMapping(value="/compare", method= RequestMethod.GET)
	public String compare(HttpServletRequest request, Model model) {
		int cardId = Integer.parseInt(request.getParameter("cardId"));
		
		try {
			Card info = cardService.getCardInfo(cardId);
			System.out.println(info);
			String cardName = info.getCardName();
			String cardImg = info.getCardImg();
			ArrayList<CardDetail> list = cardService.getDiscountInfoByCard(cardId);
			System.out.println(cardImg);
			System.out.println(cardName);
			System.out.println(list.size());
			model.addAttribute("list", list);
			model.addAttribute("cardImg", cardImg);
			model.addAttribute("cardName", cardName);
			model.addAttribute("info", info);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return "cardCompare1";
	}
	
	@RequestMapping(value = "/cardCompare", method = RequestMethod.GET)
	public String cardCompare() {
		
		return "cardCompare2";
	}

}
