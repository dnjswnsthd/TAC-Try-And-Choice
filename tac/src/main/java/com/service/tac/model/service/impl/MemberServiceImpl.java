package com.service.tac.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.tac.model.mapper.MemberMapper;
import com.service.tac.model.service.MemberService;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.Consume;
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

	@Override
	public Member login(int memberId, String password) throws SQLException {
		return null;
	}

	@Override
	public int register(Member member) throws SQLException {
		return sqlSession.getMapper(MemberMapper.class).register(member);
	}

	@Override
	public int updateMemberInfo(Member member) throws SQLException {
		return 0;
	}

	@Override
	public int updateCardInfo(Card card) throws SQLException {
		return 0;
	}

	@Override
	public void logout(int memberId) throws SQLException {

	}

	@Override
	public void remove(int memberId) throws SQLException {

	}

}
