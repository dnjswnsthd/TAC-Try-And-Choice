package com.service.tac.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.service.tac.model.vo.ConsumeAnalysis_Desc;
import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;

public interface AnalyseService {
	
	// 소비패턴 분석 : 대분류 별 월 소비 합계 
	public ArrayList<ConsumeAnalysis_LargeSum> AnalyseLC_SUM(String id) throws SQLException;
	
	// 소비 패턴 분석 : 모든 소비패턴 정보 가지고 오기
	public ArrayList<ConsumeAnalysis_Desc> AnalyseLC_DESC(String id) throws SQLException;

}
