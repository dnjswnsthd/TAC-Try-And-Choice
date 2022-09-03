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

import com.service.tac.model.service.CardService;
import com.service.tac.model.service.CategoryService;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.LargeCategory;
import com.service.tac.model.vo.SmallCategory;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CardService cardService;
	
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
	
	@PostMapping("/getLargeCategory")
	@ResponseBody
	public HashMap<String, String> getLargeCategory(@RequestParam Map<String, Object> map) {
		HashMap<String, String> hm = new HashMap<>();
		ArrayList<LargeCategory> list = null;
		try {
			list = categoryService.getAllLargeCategory();
			for (LargeCategory s : list) {
				hm.put(Integer.toString(s.getLargeCategoryId()), s.getLargeCategoryName());
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
	
	@PostMapping("/smallRegAndgetCategory")
	@ResponseBody
	public HashMap<String, String> SmallRegAndgetCategory(@RequestParam Map<String, Object> map) {
		HashMap<String, String> hm = new HashMap<>();
		String smallCategoryName = (String) map.get("smallname");
		int largeCategoryId = Integer.parseInt((String) map.get("largeid"));
		SmallCategory smallCategory = new SmallCategory(smallCategoryName, largeCategoryId);
		ArrayList<SmallCategory> list = null;
		try {
			categoryService.registerSmallCategory(smallCategory);
			list = categoryService.getSmallCategory(largeCategoryId);
			for (SmallCategory s : list) {
				hm.put(Integer.toString(s.getSmallCategoryId()), s.getSmallCategoryName());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return hm;
	}
	
	@PostMapping("/deleteSmallCategory")
	@ResponseBody
	public HashMap<String, String> deleteSmallCategory(@RequestParam Map<String, Object> map) {
		HashMap<String, String> hm = new HashMap<>();
		String smallCategoryName = (String) map.get("name");
		int largeCategoryId = Integer.parseInt((String) map.get("largeid"));
		ArrayList<SmallCategory> list = null;
		try {
			categoryService.deleteSmallCategory(smallCategoryName);
			list = categoryService.getSmallCategory(largeCategoryId);
			for (SmallCategory s : list) {
				hm.put(Integer.toString(s.getSmallCategoryId()), s.getSmallCategoryName());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return hm;
	}
	
	@PostMapping("/registerCardDetail")
	@ResponseBody
	public HashMap<String, String> registerCardDetail(@RequestParam Map<String, Object> map) {
		HashMap<String, String> hm = new HashMap<>();
		int discountPercent = Integer.parseInt((String) map.get("discountpercent"));
		int cardId = Integer.parseInt((String) map.get("cardid"));
		int largeId = Integer.parseInt((String) map.get("largeid"));
		int smallId = Integer.parseInt((String) map.get("smallid"));
		int minPrice = Integer.parseInt((String) map.get("minprice"));
		int maxPrice = Integer.parseInt((String) map.get("maxprice"));
		int maxCount = Integer.parseInt((String) map.get("maxcount"));
		CardDetail cardDetail = new CardDetail(discountPercent, cardId, largeId, smallId, minPrice, maxPrice, maxCount);
		ArrayList<Card> list_card = null;
		try {
			categoryService.registerCardDetail(cardDetail);
			list_card = cardService.getAllCardInfo();
			for (Card c : list_card) {
				hm.put(Integer.toString(c.getCardId()), c.getCardName());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return hm;
	}
	
}
