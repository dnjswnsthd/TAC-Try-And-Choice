package com.service.tac.model.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.tac.model.dao.ConsumeDAO;
import com.service.tac.model.mapper.ConsumeMapper;
import com.service.tac.model.vo.Consume;

@Repository
public class ConsumeDAOImpl implements ConsumeDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int addConsumeInfo(Consume consume) throws SQLException {
		return sqlSession.getMapper(ConsumeMapper.class).addConsumeInfo(consume);
	}

	@Override
	public ArrayList<HashMap<String, Object>> getConsume(String memberId) throws SQLException {
		return sqlSession.getMapper(ConsumeMapper.class).getConsume(memberId);
	}

	@Override
	public int updateConsumeInfo(Consume consume) throws SQLException {
		return sqlSession.getMapper(ConsumeMapper.class).updateConsumeInfo(consume);
	}

	@Override
	public int deleteConsumeInfo(int consumeId) throws SQLException {
		return sqlSession.getMapper(ConsumeMapper.class).deleteConsumeInfo(consumeId);
	}

}
