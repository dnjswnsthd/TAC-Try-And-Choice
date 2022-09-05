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
			ArrayList<Card> list = cardService.getAllCardInfo();
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
			ArrayList<Card> list = cardService.getAllCardInfo();
			model.addAttribute("list", list);
			return "/member/signup";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}

	}

	@GetMapping(value = "/addLargeCategory")
	public String addLargeCategory(Model model) {
		try {
			List<LargeCategory> list = categoryService.getAllLargeCategory();
			model.addAttribute("largeCategory", list);	
			return "/manage/insert_card_largeCategory";
			
		} catch(Exception e) {
			// 에러페이지
			return "/error";
		}
	}

	@GetMapping(value = "/error")
	public String error() {
		return "/error";
	}

	@GetMapping(value = "/calendarTest")
	public String calendarTest() {
		return "/member/insertConsume";
	}

	@GetMapping(value = "/mypage")
	public String moveMypage(Model model) {
		try {
			ArrayList<Card> list = cardService.getAllCardInfo();
			model.addAttribute("list", list);
			return "/member/mypage";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}
	}

	@GetMapping(value = "/updateConsume")
	public String moveUpdateConsume(Model model, HttpServletRequest request) {
		ArrayList<LargeCategory> list;
		try {
			list = categoryService.getAllLargeCategory();
			model.addAttribute("list", list);
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("member");
			model.addAttribute("memberId", member.getMemberId());
			return "/member/update_consume";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}
	}

	
	@RequestMapping(value = "/manage_card", method = RequestMethod.GET)
    public String manage_card(Model model) {
        try {
            List<LargeCategory> large_list = categoryService.getAllLargeCategory();
            model.addAttribute("largeCategory", large_list);
            List<Card> card_list = cardService.getAllCardInfo();
            model.addAttribute("showAllCard", card_list);
            return "/manage/insertCard";

        } catch(Exception e) {
            // 에러페이지
            return "/error";
        }
    }

	@GetMapping(value = "/addSmallCategory")
	    public String addSmallCategory(Model model) {
	        try {
	
	        List<LargeCategory> list = categoryService.getAllLargeCategory();
	        model.addAttribute("largeCategory", list);
	        return "/manage/insert_card_smallCategory";
	        
	    } catch(Exception e) {
	        // 에러페이지
	        return "/error";
	    }
	}

	@RequestMapping(value = "/manage_card_update", method = RequestMethod.GET)
	public String manage_card_update(Model model) {
		try {
			List<LargeCategory> large_list = categoryService.getAllLargeCategory();
			model.addAttribute("largeCategory", large_list);
			List<Card> card_list = cardService.getAllCardInfo();
			model.addAttribute("showAllCard", card_list);
			return "/manage/updateCard";
			
		} catch(Exception e) {
			// 에러페이지
			return "/error";
		}
	}
	
}
