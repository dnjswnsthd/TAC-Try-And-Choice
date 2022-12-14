package com.service.tac.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.tac.model.dao.AnalyseDAO;
import com.service.tac.model.mapper.AnalyseMapper;
import com.service.tac.model.service.AnalyseService;
import com.service.tac.model.vo.ConsumeAnalysis_ByDate;
import com.service.tac.model.vo.ConsumeAnalysis_ByDay;
import com.service.tac.model.vo.ConsumeAnalysis_Desc;
import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;
import com.service.tac.model.vo.LargeCategory;

@Service
public class AnalyseServiceImpl implements AnalyseService {

	@Autowired
	private AnalyseDAO analyseDAO;
	
	@Override
	public ArrayList<ConsumeAnalysis_LargeSum> AnalyseLC_SUM(String id) throws SQLException {
		return analyseDAO.AnalyseLC_SUM(id);
	}

	@Override
	public ArrayList<ConsumeAnalysis_Desc> AnalyseLC_DESC(String id) throws SQLException {
		return analyseDAO.AnalyseLC_DESC(id);
	}

	@Override
	public ArrayList<ConsumeAnalysis_LargeSum> AnalyseLC_SUM_AVG(int age) throws SQLException {
		return analyseDAO.AnalyseLC_SUM_AVG(age);
	}

	@Override
	public int MyAge(String id) throws SQLException {
		return analyseDAO.MyAge(id);
	}

	@Override
	public ArrayList<ConsumeAnalysis_ByDate> AnalyseLC_DESC_AVG(int age) throws SQLException {
		return analyseDAO.AnalyseLC_DESC_AVG(age);
	}

	@Override
	public ArrayList<ConsumeAnalysis_ByDay> Analyse_DAY(String id) throws SQLException {
		return analyseDAO.Analyse_DAY(id);
	}

	@Override
	public ArrayList<LargeCategory> LargeCategroyList() throws SQLException {
		return analyseDAO.LargeCategroyList();
	}
	
	

}
