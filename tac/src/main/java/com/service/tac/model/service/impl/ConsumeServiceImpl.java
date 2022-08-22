package com.service.tac.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.service.tac.model.service.ConsumeService;
import com.service.tac.model.vo.Consume;

public class ConsumeServiceImpl implements ConsumeService {

	@Override
	public ArrayList<Consume> getConsume(int memberId) throws SQLException {
		return null;
	}

	@Override
	public int updateConsumeInfo(Consume consume) throws SQLException {
		return 0;
	}

	@Override
	public int deleteConsumeInfo(int consumeId) throws SQLException {
		return 0;
	}

	@Override
	public HashMap<String, ArrayList<Consume>> consumeInfoByDay() throws SQLException {
		return null;
	}

	@Override
	public HashMap<String, ArrayList<Consume>> consumeInfoByCategory() throws SQLException {
		return null;
	}

}
