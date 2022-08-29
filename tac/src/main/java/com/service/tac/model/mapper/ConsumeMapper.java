package com.service.tac.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.service.tac.model.vo.Consume;
import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;

public interface ConsumeMapper {
	public HashMap<String, ArrayList<Consume>> consumeInfoByCategory() throws SQLException;
}
