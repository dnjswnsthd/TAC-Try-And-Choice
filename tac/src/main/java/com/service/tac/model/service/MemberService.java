package com.service.tac.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.Consume;
import com.service.tac.model.vo.Member;

public interface MemberService {
	public ArrayList<Member> showAll() throws SQLException;

	// 로그인
	public Member login(Member member) throws SQLException;
	// 회원등록 card, consume map이나 vo생성해서 넘길 예정
	public int register(Member member) throws SQLException;

	// 개인 정보 수정
	public int updateMemberInfo(Member member) throws SQLException;

	// 카드 정보 수정
	public int updateCardInfo(Member member) throws SQLException;

	// 로그 아웃
	public void logout(int memberId) throws SQLException;

	// 회원 탈퇴
	public void remove(int memberId) throws SQLException;
	
	// 아이디 중복 체크
	public String chkDup(String memberId) throws SQLException;
	
	// 회원 삭제
	public void deleteMember(String id) throws SQLException;
}
