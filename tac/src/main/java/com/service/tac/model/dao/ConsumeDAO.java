package com.service.tac.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.service.tac.model.vo.Consume;

public interface ConsumeDAO {
	public int addConsumeInfo(Consume consume) throws SQLException;
	
	public ArrayList<HashMap<String, Object>> getConsume(String memberId) throws SQLException;
	
	public int deleteConsumeInfo(int consumeId) throws SQLException;
	
	public int updateConsumeInfo(Consume consume) throws SQLException;
}
