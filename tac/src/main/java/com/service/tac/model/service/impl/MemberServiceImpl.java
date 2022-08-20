package com.service.tac.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.tac.model.mapper.MemberMapper;
import com.service.tac.model.service.MemberService;
import com.service.tac.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<Member> showAll() throws SQLException {
		ArrayList<Member> al = sqlSession.getMapper(MemberMapper.class).showAll();
		return al;
	}

}
