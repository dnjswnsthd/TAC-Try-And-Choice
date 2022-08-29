package com.service.tac.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;

public interface AnalyseMapper {
	// 대분류 별 합계
	public ArrayList<ConsumeAnalysis_LargeSum> AnalyseLC_SUM(String id) throws SQLException;

}
