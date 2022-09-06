package com.service.tac.model.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.tac.model.dao.MemberDAO;
import com.service.tac.model.mapper.MemberMapper;
import com.service.tac.model.vo.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<Member> showAll() throws SQLException {
		ArrayList<Member> al = sqlSession.getMapper(MemberMapper.class).showAll();
		return al;
	}

	@Override
	public Member login(Member member) throws SQLException {
		Member m=sqlSession.getMapper(MemberMapper.class).login(member);
		return m;
	}

	@Override
	public int register(Member member) throws SQLException {
		return sqlSession.getMapper(MemberMapper.class).register(member);
	}

	@Override
	public int updateMemberInfo(Member member) throws SQLException {
		return sqlSession.getMapper(MemberMapper.class).updateMemberInfo(member);
	}

	@Override
	public int updateCardInfo(Member member) throws SQLException {
		return sqlSession.getMapper(MemberMapper.class).updateCardInfo(member);
	}

	@Override
	public String chkDup(String memberId) throws SQLException {
		return sqlSession.getMapper(MemberMapper.class).chkDup(memberId);
	}

	@Override
	public void deleteMember(String id) throws SQLException {
		sqlSession.getMapper(MemberMapper.class).deleteMember(id);
	}

}
