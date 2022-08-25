package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.tac.model.service.CardService;
import com.service.tac.model.vo.Card;

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
	
	@RequestMapping(value = "/compare", method = RequestMethod.GET)
	public String compare() {
		return "cardCompare1";
	}
	
	@RequestMapping(value = "/cardCompare", method = RequestMethod.GET)
	public String cardCompare() {
		return "cardCompare2";
	}

}
