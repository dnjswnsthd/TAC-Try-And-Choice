package com.service.tac.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

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
	
	// 엑셀 업로드로 소비 등록
	public ArrayList<Consume> uploadExcelFile(MultipartFile excelFile);

}
