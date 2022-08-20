package com.service.tac.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.Member;

public interface MemberService {
	public ArrayList<Member> showAll() throws SQLException;
}
