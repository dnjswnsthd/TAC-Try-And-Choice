package com.service.tac.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.tac.model.dao.MemberDAO;
import com.service.tac.model.mapper.MemberMapper;
import com.service.tac.model.service.MemberService;
import com.service.tac.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<Member> showAll() throws SQLException {
		return memberDAO.showAll();
	}

	@Override
	public Member login(Member member) throws SQLException {
		return memberDAO.login(member);
	}

	@Override
	public int register(Member member) throws SQLException {
		return memberDAO.register(member);
	}

	@Override
	public int updateMemberInfo(Member member) throws SQLException {
		return memberDAO.updateMemberInfo(member);
	}

	@Override
	public int updateCardInfo(Member member) throws SQLException {
		return memberDAO.updateCardInfo(member);
	}

	@Override
	public void logout(int memberId) throws SQLException {

	}

	@Override
	public void remove(int memberId) throws SQLException {

	}

	@Override
	public String chkDup(String memberId) throws SQLException {
		return memberDAO.chkDup(memberId);
	}

	@Override
	public void deleteMember(String id) throws SQLException {
		memberDAO.deleteMember(id);
	}

}
