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
			ArrayList<CardDetail> list = cardService.getDiscountInfoByCard(cardId);
			
			model.addAttribute("list", list);
			model.addAttribute("info", info);
			
			for(int i=1;i<=22;i++) {
				ArrayList<CardDetail> records = cardService.getBenefitsByCateg(cardId, i);
				
				if(records.size()!=0) {
					System.out.println(records.size());
					System.out.println(records);
					for(int j=0;j<records.size();j++) {
						
						CardDetail cardDetail = records.get(j);
						System.out.println(cardDetail);
						String largeCategoryName = cardDetail.getLargeCategory().getLargeCategoryName();
						int consumePrice = cardDetail.getConsume().getConsumePrice();
						System.out.println("소비 금액은:: " + consumePrice);
						System.out.println("소비 분야는 :: "+ largeCategoryName);
					}//if
				}//for
			}//try
			
			
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
