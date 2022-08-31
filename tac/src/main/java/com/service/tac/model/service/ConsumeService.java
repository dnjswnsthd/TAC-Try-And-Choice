package com.service.tac.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.service.tac.model.vo.Consume;

public interface ConsumeService {
	// 소비 등록
	public int addConsumeInfo(Consume consume) throws SQLException;
	
	// 멤버별 소비 정보 가져오기
	public ArrayList<HashMap<String, Object>> getConsume(String memberId) throws SQLException;

	// 소비 정보 수정
	public int updateConsumeInfo(Consume consume) throws SQLException;

	// 소비 정보 삭제
	public int deleteConsumeInfo(int consumeId) throws SQLException;

	// 요일별 소비 정보 가져오기
	public HashMap<String, ArrayList<Consume>> consumeInfoByDay() throws SQLException;

	// 카테고리별 소비 정보 가져오기 
	public HashMap<String, ArrayList<Consume>> consumeInfoByCategory() throws SQLException;

}
