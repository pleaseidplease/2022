package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO{
	//생성,수정,삭제,한건조회,목록
	
	//생성
	public void memberInsert(MemberVO vo) {		
		try {
			getConnect();
			String sql="insert into members(id,passwd,name,email) values(?,?,?,?)";
			psmt=getConnect().prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			disconnect();
		}
	}
	
	//한건조회
	public MemberVO memberSearch(String id) {
		String sql="select * from members where id=?";
		conn=getConnect();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				MemberVO mv=new MemberVO(rs.getString("id"),rs.getString("passwd"),rs.getString("name"),rs.getString("email"),rs.getString("responsibility"));
				
				return mv;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	//수정
	public void memberUpdate(MemberVO vo) {
		String sql="update members set id=?,passwd=?,name=?,email=? where id=?  ";
		conn=getConnect();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		
	}
	
	//삭제
	public void memberDelete(String id) {
		String sql="delete from members where id=?";
		conn=getConnect();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
				
	}
	
	//전체조회
	public List<MemberVO> memberList(){
		String sql="select * from members";
		conn=getConnect();
		List<MemberVO> list=new ArrayList<MemberVO>();
		try {
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new MemberVO(rs.getString("id"),rs.getString("passwd"),rs.getString("name"),rs.getString("email"),rs.getString("responsibility")));
			};
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}	
		
		return list;
	}

	
	//로그인
	public MemberVO login(String id, String passwd) {
		String sql="select * from members where id=? and passwd=?";
		conn=getConnect();
		MemberVO vo=new MemberVO();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);
			rs=psmt.executeQuery();
			while(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));			
				vo.setResponsibility(rs.getString("responsibility"));
				return vo;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return null;
	}
	
}
