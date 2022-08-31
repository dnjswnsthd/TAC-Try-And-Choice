package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.tac.model.service.AnalyseService;
import com.service.tac.model.service.ConsumeService;
import com.service.tac.model.service.MemberService;
import com.service.tac.model.vo.Consume;
import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;
import com.service.tac.model.vo.Member;

@Controller
public class AnalyseController {
	
	@Autowired
	private AnalyseService analyseService;
	
	@RequestMapping("/analysis")
	public ModelAndView analysis() {
		System.out.println("[AnalyseController] Analysis");
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("1", 100);
		hm.put("2", 200);
		hm.put("3", 300);
		hm.put("4", 400);
		mav.addObject("TEST_HM",hm);
		
		mav.addObject("TEST_NAME", "TEST_VALUE");
		
		ArrayList<ConsumeAnalysis_LargeSum> AnalLargeSum;
		
		try {
			AnalLargeSum = analyseService.AnalyseLC_SUM("RYU");
			mav.addObject("AnalLargeSum", AnalLargeSum);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// set view
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
