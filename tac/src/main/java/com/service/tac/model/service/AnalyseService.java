package com.service.tac.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;

public interface AnalyseService {
	
	// 소비패턴 분석 : 대분류 별 월 소비 합계 
	public ArrayList<ConsumeAnalysis_LargeSum> AnalyseLC_SUM(String id) throws SQLException;

}
