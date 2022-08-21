package com.service.tac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IntroController {
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public String intro() {
		return "intro";
	}
	@RequestMapping(value= "/signup", method = RequestMethod.GET)
	public String signup() {
		return "signup";
	}
}
