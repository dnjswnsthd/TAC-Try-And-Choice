package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
			memberService.register(member); 
			model.addAttribute("memberId", member.getMemberId());
			return "/member/insertConsume";

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}
	}
	
	@PostMapping("/chkDup")
	@ResponseBody
	public String chkDup(Model model, String id) {
		String chkDup;
		String check = "false";
		try {
			chkDup = memberService.chkDup(id);
			if(chkDup!=null) check = "true";
			return check;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}
	}
  
	@GetMapping("/login")
	public String getLoginForm(Member member, Model model) {
		return "/member/login";
	}
	
	@GetMapping("/logout")
	public String getLogoutForm(Member member, Model model, HttpSession session) {
		Member sessionmember = (Member) session.getAttribute("member");
		if ( sessionmember != null ) {
			session.invalidate();
		}
		return "redirect:/main";
	}
	
	@PostMapping("/login_result")
	public String login(String id, String password, Model model, HttpServletRequest request) {
		
		try {
			Member member = memberService.login(new Member(id, password));
	        if(member != null) {
//	        	System.out.println(member.toString());
	        	model.addAttribute("member", member);
	        	HttpSession session = request.getSession();
	        	session.setAttribute("member",member);
	            return "redirect:/main";
	        }else {
	            return "/error";
	        }
	    } catch (Exception e) {
	        return "/error";
	    }
	}
	
	@PostMapping("/member/update")
	public String update(Member member, HttpServletRequest request) {
		try {
			memberService.updateMemberInfo(member);
			HttpSession session = request.getSession();
			member.setPassword(null);
			session.setAttribute("member", member);
			return "redirect:/mypage";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}
	}
	
	@PostMapping("/member/cardUpdate")
	public String cardUpdate(int cardId2, String memberId, HttpServletRequest request) {
		Member member = new Member(memberId, cardId2);
		try {
			memberService.updateCardInfo(member);
			HttpSession session = request.getSession();
			Member member2 = (Member) session.getAttribute("member");
			member2.setCardId(cardId2);
			session.setAttribute("member", member2);
			return "redirect:/mypage";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}
		
	}

	@RequestMapping("/needlogin")
	public String needlogin() {
		return "/member/you_need_login";
	}
	
	@RequestMapping("/notadmin")
	public String notadmin() {
		return "/member/you_need_authority";
	}
}
