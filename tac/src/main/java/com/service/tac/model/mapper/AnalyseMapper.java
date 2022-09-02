package com.service.tac.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.ConsumeAnalysis_ByDate;
import com.service.tac.model.vo.ConsumeAnalysis_ByDay;
import com.service.tac.model.vo.ConsumeAnalysis_Desc;
import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;
import com.service.tac.model.vo.LargeCategory;

public interface AnalyseMapper {
	// 해당 id 나이
	public int MyAge(String id) throws SQLException;
	// 소비 패턴 분석 : 대분류 별 합계
	public ArrayList<ConsumeAnalysis_LargeSum> AnalyseLC_SUM(String id) throws SQLException;
	// 소비 패턴 분석 : 다른 연령대 대분류 별 합계 평균
	public ArrayList<ConsumeAnalysis_LargeSum> AnalyseLC_SUM_AVG(int age) throws SQLException;
	// 소비 패턴 분석 : 모든 소비패턴 정보 가지고 오기
	public ArrayList<ConsumeAnalysis_Desc> AnalyseLC_DESC(String id) throws SQLException;
	// 소비 패턴 분석 : 다른 연령대 날짜별 평균 가지고 오기
	public ArrayList<ConsumeAnalysis_ByDate> AnalyseLC_DESC_AVG(int age) throws SQLException;
	// 소비 패턴 분석 : 해당 아이디 요일 분석
	public ArrayList<ConsumeAnalysis_ByDay> Analyse_DAY(String id) throws SQLException;
	// 대분류 정보 모두 들고오기
	public ArrayList<LargeCategory> LargeCategroyList() throws SQLException;
}
