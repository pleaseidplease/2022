package co.edu.dao;

import java.sql.SQLException;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO{
	//생성,수정,삭제,한건조회,목록
	
	//생성
	public void memberInsert(MemberVO vo) {
		conn=getConnect();
		String sql="insert into members(id,passwd,name,email) values(?,?,?,?)";
		try {
			psmt=conn.prepareStatement(sql);
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
				MemberVO mv=new MemberVO(rs.getString("id"),rs.getString("passwd"),rs.getString("name"),rs.getString("email"));
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
		
	}
	
	public void memberDelete(String id) {
		
	}
	
	public List<MemberVO> memberList(){
	return null;
	}
	
}
