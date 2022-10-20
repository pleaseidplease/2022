package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



///create table board(
//board_num int PRIMARY key,--글번호
//board_title VARCHAR2(100) not null,--제목
//board_content VARCHAR2(300) not null,--내용
//board_writer VARCHAR2(20) not null,--작성자
//creation_date date DEFAULT SYSDATE ,--작성일시
//cnt int DEFAULT 0 --글을 읽은 횟수
//);
//CeateReadUpdateDelete 기능

public class BoardDAO extends DAO {

//	/입력
	public void insert(Board bd) {
		String sql = "insert into board (board_num, board_title,board_content, board_writer)\r\n" + "values("
				+ bd.getNumber() + ",'" + bd.getTitle() + "','" + bd.getContent() + "','" + bd.getWriter() + "')";

		conn = getConnect();

		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 목록
	public List<Board> search() {
		List<Board> list = new ArrayList<>();
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select*from board");
			while (rs.next()) {

				list.add(new Board(rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 수정
	public void update(Board bd) {
		
		String sql = "update board\r\n" + "set board_content=?, creation_date=sysdate\r\n" + "where board_num=?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bd.getContent());
			psmt.setInt(2, bd.getNumber());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경이 완료되었습니다.");
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	//삭제
	public void delete(int num) {
		String sql = "delete from board where board_num=?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			int r = psmt.executeUpdate();

			System.out.println(r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//상세조회
	public Board getNum(int num) {
		String sql = "select * from board where board_num=?";
		
		conn = getConnect();
		Board result = new Board();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			while (rs.next()) {
				result = new Board(rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt"));
			}
			System.out.println(result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}
	
	//아이디 비밀번호 조회
	public boolean check(String id, String pw) {
		boolean chk=false;
		String sql = "select * from users where id=?";
		System.out.println(sql);
		conn=getConnect();
		List<String>str=new ArrayList<String>();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				str.add(rs.getString("id"));
				str.add(rs.getString("passwd"));
			}
			
			
			System.out.println(str.get(0));
			System.out.println(str.get(1));
			System.out.println(id);
			System.out.println(pw);
			
			if(str.get(0).equals(id)&&str.get(1).equals(pw)) {
				
				System.out.println("로그인 성공");
				chk=true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return chk=false;
		}
		return chk;
		
	}
	
	//유저네임 가져오기
	public List<String> username(String id){
		String sql = "select * from users where id=?";
		List<String>str=new ArrayList<String>();
		conn=getConnect();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				str.add(rs.getString("id"));
				str.add(rs.getString("passwd"));
				str.add(rs.getString("user_name"));
			}
			
			
			System.out.println(str.get(0));
			System.out.println(str.get(1));
			System.out.println(str.get(2));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	//댓글
	public List<String> subupdate(int num) {
		String sql = "select * from reply where board_num=?";
		System.out.println(sql);
		conn=getConnect();
		List<String>str=new ArrayList<String>();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs=psmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				str.add(rs.getString("rep_seq"));
				str.add(rs.getString("board_num"));
				str.add(rs.getString("rep_content"));
				str.add(rs.getString("rep_writer"));
				str.add(rs.getString("creation_date"));
			}
			
			System.out.println(str.get(1));
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
		
	} 
	
	public List<String> reply(int num){
		String sql="select * from reply where board_num=?";
		System.out.println(sql);
		conn=getConnect();
		List<String>str=new ArrayList<String>();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs=psmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				str.add(rs.getString("board_num"));
			}
			
			System.out.println(str.get(0));
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	

	
}
