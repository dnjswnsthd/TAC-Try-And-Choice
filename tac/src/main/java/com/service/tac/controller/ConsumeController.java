package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.tac.model.service.ConsumeService;
import com.service.tac.model.vo.Consume;

@Controller
@RequestMapping("/consume")
public class ConsumeController {
	
	@Autowired
	ConsumeService consumeService;
	
	@PostMapping("/register")
	@ResponseBody
	public String addConsumeInfo(@RequestParam Map<String, Object> map) {
		Consume consume = new Consume(
				Integer.parseInt((String) map.get("price")), 
				(String) map.get("consumeDate"), 
				Integer.parseInt((String)map.get("largeCategoryId")), 
				Integer.parseInt((String)map.get("smallCategoryId")), 
				(String) map.get("memberId"));
		try {
			consumeService.addConsumeInfo(consume);
			return "";  
		} catch (SQLException e) {
			e.printStackTrace();
			return "/error";
		}
	}
	
	
	@PostMapping("/getConsume")
	@ResponseBody
	public ArrayList<HashMap<String,Object>> getConsume(@RequestParam Map<String, Object> map) {
		String memberId = (String) map.get("memberId");
		ArrayList<HashMap<String, Object>> hm = null;
		try {
			hm = consumeService.getConsume(memberId);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return hm;
	}
	
	@DeleteMapping("/deleteConsume")
	public String deleteConsume(@RequestParam Map<String, Object> map) {
		int consumeId =  Integer.parseInt((String) map.get("consumeId"));
		System.out.println(consumeId);
		try {
			consumeService.deleteConsumeInfo(consumeId);
			return "";
		} catch (SQLException e) {
			e.printStackTrace();
			return "/error";
		}
	}
}
