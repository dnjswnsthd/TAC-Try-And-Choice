package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping("/register")
	public String register(Member member, Model model) {
		ArrayList<LargeCategory> list;
		try {
			list = categoryService.getAllLargeCategory();
			model.addAttribute("list", list);
			memberService.register(member); model.addAttribute("memberId",
			member.getMemberId());
			return "/member/insertConsume";

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}

	}
	
	@GetMapping("/login")
	public String getLoginForm(Member member, Model model) {
		return "/member/login";
	}
	
	@PostMapping("/login_result")
	public String login(String id, String password, Model model, HttpServletRequest request) {
		
		try {
			Member member = memberService.login(new Member(id, password));
	        if(member != null) {
	        	model.addAttribute("member", member);
	        	HttpSession session = request.getSession();
	        	session.setAttribute("id",id);
	            return "/member/login_result";
	        }else {
	            return "/error";
	        }
	    } catch (Exception e) {
	        return "/error";
	    }
	}

}
