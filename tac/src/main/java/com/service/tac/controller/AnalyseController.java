package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.tac.model.service.AnalyseService;
import com.service.tac.model.vo.ConsumeAnalysis_ByDate;
import com.service.tac.model.vo.ConsumeAnalysis_ByDay;
import com.service.tac.model.vo.ConsumeAnalysis_Desc;
import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;
import com.service.tac.model.vo.LargeCategory;
import com.service.tac.model.vo.Member;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
public class AnalyseController {

	@Autowired
	private AnalyseService analyseService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/analysis")
	public ModelAndView analysis(HttpServletRequest request, HttpSession session) {
		System.out.println("[AnalyseController] Analysis");
		logger.info("analysis");
		
		ModelAndView mav = new ModelAndView();
		// json 용
		List<HashMap<String, Object>> bList = new ArrayList<HashMap<String, Object>>();
		// ID
		String id = "";
		Member sessionmember = (Member) session.getAttribute("member");
		if ( sessionmember == null ) {
			System.out.println("로그인 안한 오류");
			String view = "consumptionAnalysis";
			mav.setViewName(view);
			return mav;
		}
		
		id = sessionmember.getMemberId();
//		System.out.println("[ID] " + id);

		// 1. 대분류 통계
		ArrayList<ConsumeAnalysis_LargeSum> AnalLargeSum = new ArrayList<ConsumeAnalysis_LargeSum>();
		try {
			HashMap<String, Object> hmap = new HashMap<>();
			AnalLargeSum = analyseService.AnalyseLC_SUM(id);
//			System.out.println("나의 대분류-----------------------------------------------------------------------");
			for (ConsumeAnalysis_LargeSum temp : AnalLargeSum) {
//				System.out.println(temp.toString());
				hmap.put(temp.getLCname(), temp.getCount() + ", " + temp.getSum() + ", " + temp.getImage());
			}
//			System.out.println("--------------------------------------------------------------------------");
			bList.add(hmap);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// 2. 날짜 통계
		int startM = 0;
		int middleM = 0;
		int endM = 0;
		try {
			HashMap<String, Object> hmap = new HashMap<>();
			HashMap<String, Object> hmap_bydate = new HashMap<>();
			ArrayList<ConsumeAnalysis_Desc> list = analyseService.AnalyseLC_DESC(id);
			for (int i = 0; i < list.size(); i++) {
				ConsumeAnalysis_Desc temp = list.get(i);
				System.out.println(temp.toString());
				int day = Integer.parseInt(temp.getDate().substring(2,4));
				if ( 1 <= day && day <= 10 ) {
					startM += temp.getPrice();
				} else if ( 11 <= day && day <= 20 ) {
					middleM += temp.getPrice();
				} else {
					endM += temp.getPrice();
				}
				hmap.put(Integer.toString(i + 1),
						temp.getLCName() + ", " + temp.getSCName() + ", " + temp.getPrice() + ", " + temp.getDate());
				hmap_bydate.put(temp.getDate(),
						(Integer) hmap_bydate.getOrDefault(temp.getDate(), 0) + temp.getPrice());
			}
			bList.add(hmap);
			bList.add(hmap_bydate);
			// 날자별 바로 넣어버리자
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// 3. 나이대 평균 구하기
		int MyAge = -1;
		ArrayList<ConsumeAnalysis_LargeSum> AnalLargeSumAvg = new ArrayList<ConsumeAnalysis_LargeSum>();
		try {
			HashMap<String, Object> hmap = new HashMap<>();
			MyAge = analyseService.MyAge(id);
			AnalLargeSumAvg = analyseService.AnalyseLC_SUM_AVG(MyAge);
//			System.out.println("평균-----------------------------------------------------------------------");
			for (ConsumeAnalysis_LargeSum temp : AnalLargeSumAvg) {
//				System.out.println(temp.toString());
				hmap.put(temp.getLCname(), temp.getCount() + ", " + temp.getSum());
			}
//			System.out.println("-----------------------------------------------------------------------");
			bList.add(hmap);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// 4. 문구 보내주기
		// 4-1. 보여줄 문구
		// 높은거 낮은거 분리해서
		// 총합 높은거 / 낮은거
		// AnalLargeSum 내거
		// AnalLargeSumAvg 평균거
		ArrayList<String> bigger = new ArrayList<String>();
		ArrayList<String> same = new ArrayList<String>();
		ArrayList<String> smaller = new ArrayList<String>();
		String mybiggest = "";
		int mybiggestM = -1;

		String avgbiggest = "";
		int avgbiggestM = -1;
		
		// 가장 차이 많이 나는 
		String gap = "";
		int gapM = Integer.MIN_VALUE;

		int myTotalConsume = 0;
		int avgTotalConsume = 0;
		for (int i = 0; i < AnalLargeSum.size(); i++) {
			int meSum = AnalLargeSum.get(i).getSum();
			int avgSum = AnalLargeSumAvg.get(i).getSum();
//			System.out.println(AnalLargeSum.get(i).getLCname() + " : " + meSum + "   -----     " + avgSum);
//			System.out.println(Math.abs(meSum - avgSum));
			myTotalConsume += meSum;
			avgTotalConsume += avgSum;
			if (meSum > avgSum) {
				bigger.add(AnalLargeSum.get(i).getLCname());
			} 
			if ( (meSum != 0 && avgSum != 0) && Math.abs(avgSum - meSum) <= 30000 ) {
				same.add(AnalLargeSum.get(i).getLCname());
			} 
			if (meSum < avgSum) {
				smaller.add(AnalLargeSum.get(i).getLCname());
			}

			// 내 최대
			if (mybiggestM < meSum) {
				mybiggest = AnalLargeSum.get(i).getLCname();
				mybiggestM = meSum;
			} 
			
			// 평균의 최대
			if (avgbiggestM < avgSum) {
				avgbiggest = AnalLargeSumAvg.get(i).getLCname();
				avgbiggestM = avgSum;
			} 
			
			// 가장 차이 많이는 분류
			if ( Math.abs(meSum - avgSum) > gapM ) {
				gap = AnalLargeSum.get(i).getLCname();
				gapM =  Math.abs(meSum - avgSum);
//				System.out.println(gap + " : " + gapM);
			}

			
		}

//		System.out.println(mybiggest);
//		System.out.println(mybiggestM);
//		System.out.println(avgbiggest);
//		System.out.println(avgbiggestM);
//		System.out.println(gap);
//		System.out.println(gapM);
		// 
		mav.addObject("mybiggest",mybiggest);
		mav.addObject("mybiggestM",mybiggestM);
		mav.addObject("avgbiggest",avgbiggest);
		mav.addObject("avgbiggestM",avgbiggestM);
		mav.addObject("gap",gap);
		mav.addObject("gapM",gapM);
		//
		mav.addObject("myTotalConsume", myTotalConsume);
		mav.addObject("avgTotalConsume", avgTotalConsume);
		mav.addObject("bigger", bigger);
		mav.addObject("same", same);
		mav.addObject("smaller", smaller);

		// 4-2. 패턴 문구 정리
		// 나의 패턴은.
//		System.out.println(mybiggest);
//		System.out.println(mybiggestM);
		
		String type = "잘 모르겠어요";
		if ( mybiggest.equals("베이커리") ||  mybiggest.equals("카페") ) {
			type = "빵과 커피를 사랑하는";
		} else if ( mybiggest.equals("주유") || mybiggest.equals("이동통신요금") || mybiggest.equals("교통") || mybiggest.equals("공과금")   ) {
			type = "꼭 필요한 것만 사용하는";
		} else if ( mybiggest.equals("홈쇼핑") || mybiggest.equals("인터넷 쇼핑")  ) {
			type = "택배상자 수집형";
		} else if ( mybiggest.equals("외식") ) {
			type = "먹는 것은 또 하나의 즐거움";
		} else if ( mybiggest.equals("놀이공원") || mybiggest.equals("호텔") || mybiggest.equals("온천")  ) {
			type = "문화시민";
		} else if ( mybiggest.equals("의료") ) {
			type = "건강이 우선";
		} else if ( mybiggest.equals("간편결제") ) {
			type = "휴대폰으로 돈을 다 쓰는";
		} else if ( mybiggest.equals("오프라인 쇼핑몰") || mybiggest.equals("유기농식품점") ) {
			type = "물건은 직접 보고 사는";
		} else if ( mybiggest.equals("서적") || mybiggest.equals("학원") ) {
			type = "스마트 앤 댄디";
		} else if ( mybiggest.equals("편의점") ) {
			type = "편도족";
		} else if ( mybiggest.equals("영화") ) {
			type = "영화광";
		} else if ( mybiggest.equals("부산YMCA 시민체육센터") ) {
			type = "부산 체육인";
		}
		mav.addObject("ConsumeType", type);
		
		// 5. 평균 날짜
		ArrayList<ConsumeAnalysis_ByDate> AnalDate = new ArrayList<ConsumeAnalysis_ByDate>();
		try {
			HashMap<String, Object> hmap = new HashMap<>();
			AnalDate = analyseService.AnalyseLC_DESC_AVG(MyAge);
			for (ConsumeAnalysis_ByDate temp : AnalDate) {
				
				hmap.put(temp.getDate(), (Integer) temp.getMoney());
			}
			bList.add(hmap);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// 6. 타입
		String daytype = "내 맴대로 쓰는 ";
		String dattypeDesc = "돈을 일정한 규칙없이 사용하시는 군요.";	
		
		double startMD = (double) ( (double) startM / (double) myTotalConsume );
		double middleMD = (double) ( (double) middleM / (double) myTotalConsume );
		double endMD = (double) ( (double) endM / (double) myTotalConsume );
		double mybiggestMD = (double) ( (double) mybiggestM / (double) myTotalConsume );
		System.out.println(startM + "  " + middleM + "   " + endM);
		if ( startM > middleM && startM > endM ) {
			daytype = "일단 돈을 쓰고 시작하는";
			dattypeDesc = "달의 출발을 소비와 함께 시작하시는군요. ";
		} else if ( middleM > startM && middleM > endM ) {
			daytype = "주로 월 중반에 돈을 사용하는";
			dattypeDesc = "달 중간에 소비를 많이 하시네요. 월급날이 있으신가요?";
		} else if ( endM > middleM && endM > startM ) {
			daytype = "월말에 돈을 몰아서 쓰는";
			dattypeDesc = "월 말에 돈을 많이 사용하시네요.";
		} else if ( mybiggestMD < 0.23 ) {
			daytype = "골고루 돈을 사용하시는";
			dattypeDesc = "매일 규칙적으로 돈을 사용하십니다.";
		}
		
		if ( mybiggestM <= 40000 ) {
			daytype = "무소비";
			dattypeDesc = "돈을 잘 사용하시지 않으시네요.";
		}
		
		if ( mybiggestMD >= 0.3	 ) {
			daytype = "간헐적 지름";
			dattypeDesc = "가끔씩 돈을 크게 사용하실 때가 있네요.";
		} else if ( mybiggestMD >= 0.5 ) {
			daytype = "큰거 한방 쓰시는";
			dattypeDesc = "이번 달에는 지름신인 강림하셨네요.";
		}

		mav.addObject("Daytype", daytype);
		mav.addObject("DaytypeDesc", dattypeDesc);
		
		// 7. 요일 
		String maxday = "아무요일";
		int maxdaymoney = 0;
		ArrayList<ConsumeAnalysis_ByDay> AnalDay = new ArrayList<>();
		try {
			HashMap<String, Object> hmap = new HashMap<>();
			hmap.put("월요일", 0);
			hmap.put("화요일", 0);
			hmap.put("수요일", 0);
			hmap.put("목요일", 0);
			hmap.put("금요일", 0);
			hmap.put("토요일", 0);
			hmap.put("일요일", 0);
			AnalDay = analyseService.Analyse_DAY(id);
			for (ConsumeAnalysis_ByDay temp : AnalDay) {
				hmap.put(temp.getDay(), (Integer) temp.getMoney());
				if ( temp.getMoney() > maxdaymoney ) {
					maxday = temp.getDay();
					maxdaymoney = temp.getMoney();
				}
			}
			bList.add(hmap);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		mav.addObject("maxday",maxday);
		mav.addObject("maxdaymoney",maxdaymoney);
		
		// 8. 대분류 이미지 들고오기
		ArrayList<LargeCategory> LargeCategoryList = new ArrayList<>();
		try {
			HashMap<String, Object> hmap = new HashMap<>();
			LargeCategoryList = analyseService.LargeCategroyList();
			for (LargeCategory temp : LargeCategoryList) {
				hmap.put(temp.getLargeCategoryName(), temp.getLargeCategoryImage());
			}
			bList.add(hmap);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	// json
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
	
	@RequestMapping("/cardCompare")
	public String LargeCategoryImg(Model model){

		ArrayList<LargeCategory> LargeCategoryList = new ArrayList<>();
		ArrayList<String> categoryName=new ArrayList<>();
		ArrayList<String> categoryImg=new ArrayList<>();
		try {
			
			LargeCategoryList = analyseService.LargeCategroyList();
			for (LargeCategory temp : LargeCategoryList) {
				categoryName.add(temp.getLargeCategoryName());
				categoryName.add(temp.getLargeCategoryImage());
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		model.addAttribute("categoryName",categoryName);
		model.addAttribute("categoryImg", categoryImg);

		
		return "/cardCompare2";
	}
}
