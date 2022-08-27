package com.service.tac.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.Member;

public interface MemberMapper {
	public ArrayList <Member> showAll() throws SQLException;
	
	public int register(Member member) throws SQLException;
}	
