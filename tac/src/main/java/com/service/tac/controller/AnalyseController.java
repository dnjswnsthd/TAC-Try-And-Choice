package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.tac.model.service.AnalyseService;
import com.service.tac.model.vo.ConsumeAnalysis_Desc;
import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;

@Controller
public class AnalyseController {
	
	@Autowired
	private AnalyseService analyseService;
	
	@RequestMapping("/analysis")
	public ModelAndView analysis() {
		System.out.println("[AnalyseController] Analysis");
		ModelAndView mav = new ModelAndView();
		// json 용
		List<HashMap<String, Object>> bList = new ArrayList<HashMap<String, Object>>();
		// ID
		String id = "RYU";
		
		// 1. 대분류 통계
		ArrayList<ConsumeAnalysis_LargeSum> AnalLargeSum;
		try {
			HashMap<String, Object> hmap = new HashMap<>();
			AnalLargeSum = analyseService.AnalyseLC_SUM(id);
			for(ConsumeAnalysis_LargeSum temp : AnalLargeSum ) {
				hmap.put(temp.getLCname(), temp.getCount() + ", " + temp.getSum() );
			}
			bList.add(hmap);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// 2. 날짜 통계
		try {
			HashMap<String, Object> hmap = new HashMap<>();
			HashMap<String, Object> hmap_bydate = new HashMap<>();
			ArrayList<ConsumeAnalysis_Desc> list = analyseService.AnalyseLC_DESC(id);
			for (int i = 0; i < list.size(); i++) {
				ConsumeAnalysis_Desc temp = list.get(i);
				hmap.put( Integer.toString(i+1) , temp.getLCName() + ", " + temp.getSCName() + ", " + temp.getPrice() + ", " + temp.getDate() );
				hmap_bydate.put(temp.getDate(), (Integer) hmap_bydate.getOrDefault(temp.getDate(), 0) + temp.getPrice() );
			}
			bList.add(hmap);
			bList.add(hmap_bydate);
			
			// 날자별 바로 넣어버리자
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		//json		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(bList);
		mav.addObject("Object", json);
		// set view
		String view = "consumptionAnalysis";
		mav.setViewName(view);
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
