package com.service.tac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String intro() {
		return "intro";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "/main/main";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		return "/member/signup";
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
	public String manage_test3() {
		return "/manage/insert_card_test3";
	}
	
}
