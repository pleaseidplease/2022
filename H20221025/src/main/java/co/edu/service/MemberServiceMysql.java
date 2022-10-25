package co.edu.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.vo.MemberVO;

public class MemberServiceMysql implements MemberService{
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	public void addMember(MemberVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMember(MemberVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeMember(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberVO findMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> memberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO login(String id, String passwd) {
		// TODO Auto-generated method stub
		return null;
	}
}
