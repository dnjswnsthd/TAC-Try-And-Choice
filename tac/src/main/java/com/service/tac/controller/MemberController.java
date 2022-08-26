package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.tac.model.service.MemberService;
import com.service.tac.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/test")
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView();
		ArrayList<Member> al = null;
		try {
			al = memberService.showAll();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		mav.addObject("Alllist", al);
		mav.setViewName("test");
		return mav;
	}
	
	@RequestMapping("/analysis")
	public ModelAndView analysis() {
		System.out.println("[Member Controller] Analysis");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("consumptionAnalysis");
		return mav;
	}
	
	@RequestMapping("/analysisDetail1")
	public ModelAndView analysisDetail1() {
		System.out.println("[Member Controller] analysisDetail1");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("analysisDetail1");
		return mav;
	}
}
