package com.service.tac.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.service.tac.model.vo.ConsumeAnalysis_Desc;
import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;

public interface AnalyseMapper {
	
	// 소비 패턴 분석 : 대분류 별 합계
	public ArrayList<ConsumeAnalysis_LargeSum> AnalyseLC_SUM(String id) throws SQLException;
	
	// 소비 패턴 분석 : 모든 소비패턴 정보 가지고 오기
	public ArrayList<ConsumeAnalysis_Desc> AnalyseLC_DESC(String id) throws SQLException;

}
