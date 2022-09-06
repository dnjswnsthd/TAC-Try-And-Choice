package com.service.tac.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.Member;

public interface MemberDAO {
	public ArrayList <Member> showAll() throws SQLException;
	
	public int register(Member member) throws SQLException;
	
	public String chkDup(String memberId) throws SQLException;

	public Member login(Member member) throws SQLException;
	
	public int updateMemberInfo(Member member) throws SQLException;
	
	public int updateCardInfo(Member member) throws SQLException;
	
	public void deleteMember(String id) throws SQLException;
}	
