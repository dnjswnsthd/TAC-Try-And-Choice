package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.tac.model.service.CardService;
import com.service.tac.model.service.CategoryService;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.SmallCategory;

@Controller
public class CardController {
	@Autowired
	CardService cardservice;
	
	@PostMapping("cardReg.do")
	public String doRegPhone(Card card, Model model) {
		System.out.println("1111111111111");
		try {
			// 성공페이지
			cardservice.registerCard(card);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 성공");
			return "/manage/insert_card_test3";
		} catch(Exception e) {
			// 에러페이지
			model.addAttribute("title", "에러");
			return "error";
		}
	}
}
