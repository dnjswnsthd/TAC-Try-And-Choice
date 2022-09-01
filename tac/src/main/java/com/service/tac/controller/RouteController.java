package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.tac.model.service.CardService;
import com.service.tac.model.service.CategoryService;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.LargeCategory;
import com.service.tac.model.vo.Member;

@Controller
public class RouteController {
	
	@Autowired
	CardService cardService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String intro() {
		return "intro";
	}

	@GetMapping(value = "/main")
	public String main(Model model) {
		try {
			ArrayList <Card> list = cardService.getAllCardInfo();
			model.addAttribute("list", list);
			return "/main/main";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}
	}

	@GetMapping(value = "/signup")
	public String signup(Model model) {
		try {
			ArrayList <Card> list = cardService.getAllCardInfo();
			model.addAttribute("list", list);
			return "/member/signup";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}
		
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
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manage() {
		return "/manage/insert_card";
	}
	@RequestMapping(value = "/manage_test", method = RequestMethod.GET)
	public String manage_test() {
		return "/manage/insert_card_test";
	}
	@RequestMapping(value = "/manage_test2", method = RequestMethod.GET)
	public String manage_test2() {
		return "/manage/insert_card_test2";
	}
	@RequestMapping(value = "/manage_test3", method = RequestMethod.GET)
	public String manage_test3(Model model) {
		try {
			List<LargeCategory> list = categoryService.getAllLargeCategory();
			model.addAttribute("largeCategory", list);
			return "/manage/insert_card_test3";
			
		} catch(Exception e) {
			// 에러페이지
			return "/error";
		}
	}
	
	@GetMapping(value= "/error")
	public String error() {
		return "/error";
	}
	
	@GetMapping(value= "/calendarTest")
	public String calendarTest() {
		return "/member/insertConsume";
	}
	
	@GetMapping(value="/mypage")
	public String moveMypage(Model model) {
		try {
			ArrayList <Card> list = cardService.getAllCardInfo();
			model.addAttribute("list", list);
			return "/member/mypage";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}
	}
	
	@GetMapping(value="/updateConsume")
	public String moveUpdateConsume(Model model, HttpServletRequest request) {
		ArrayList<LargeCategory> list;
		try {
			list = categoryService.getAllLargeCategory();
			model.addAttribute("list", list);
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("member");
			model.addAttribute("memberId", member.getMemberId());
			return "/member/updateConsume";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}
	}

}
