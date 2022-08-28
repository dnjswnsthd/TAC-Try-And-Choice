package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.tac.model.service.CategoryService;
import com.service.tac.model.service.MemberService;
import com.service.tac.model.vo.LargeCategory;
import com.service.tac.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	CategoryService categoryService;
	
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
	public ModelAndView ryu() {
		System.out.println("[Member Controller] Analysis");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ConsumptionAnalysis");
		return mav;
	}
	
	@PostMapping("/register")
	public String register(Member member, Model model) {
		ArrayList<LargeCategory> list;
		try {
			list = categoryService.getAllLargeCategory();
			memberService.register(member);
			model.addAttribute("list", list);
			model.addAttribute("memberId", member.getMemberId());
			return "/member/signupConsume";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}
	}
	
}
