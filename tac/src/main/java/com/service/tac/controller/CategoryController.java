package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.tac.model.service.CategoryService;
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
}
