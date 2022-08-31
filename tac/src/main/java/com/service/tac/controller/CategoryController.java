package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.tac.model.service.CategoryService;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.LargeCategory;
import com.service.tac.model.vo.SmallCategory;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@PostMapping("/getSmallCategory")
	@ResponseBody
	public HashMap<String, String> getSmallCategory(@RequestParam Map<String, Object> map) {
		HashMap<String, String> hm = new HashMap<>();
		int largeCategoryId = Integer.parseInt((String) map.get("id"));
		ArrayList<SmallCategory> list = null;
		try {
			list = categoryService.getSmallCategory(largeCategoryId);
			for (SmallCategory s : list) {
				hm.put(Integer.toString(s.getSmallCategoryId()), s.getSmallCategoryName());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return hm;
	}
	
	@PostMapping("/LargeRegAndgetCategory")
	@ResponseBody
	public HashMap<String, String> LargeRegAndgetCategory(@RequestParam Map<String, Object> map) {
		HashMap<String, String> hm = new HashMap<>();
		String largeCategoryName = (String) map.get("name");
		ArrayList<LargeCategory> list = null;
		try {
			categoryService.registerLargeCategory(largeCategoryName);
			list = categoryService.getAllLargeCategory();
			for (LargeCategory s : list) {
				
				hm.put(Integer.toString(s.getLargeCategoryId()), s.getLargeCategoryName());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return hm;
	}
	
	@PostMapping("/deleteLargeCategory")
	@ResponseBody
	public HashMap<String, String> deleteLargeCategory(@RequestParam Map<String, Object> map) {
		HashMap<String, String> hm = new HashMap<>();
		String largeCategoryName = (String) map.get("name");
		ArrayList<LargeCategory> list = null;
		try {
			categoryService.deleteLargeCategory(largeCategoryName);
			list = categoryService.getAllLargeCategory();
			for (LargeCategory s : list) {
				
				hm.put(Integer.toString(s.getLargeCategoryId()), s.getLargeCategoryName());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return hm;
	}
	
	
	
	@PostMapping("LargeReg.do")
	public String doRegLargeCategory(String largeCategoryName, Model model) {
		try {
			// 성공페이지
			categoryService.registerLargeCategory(largeCategoryName);
			return "/manage/insertCard";
		} catch(Exception e) {
			// 에러페이지
			model.addAttribute("title", "에러");
			return "error";
		}
	}
	
}
