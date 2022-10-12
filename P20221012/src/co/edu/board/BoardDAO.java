package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.jdbc.Employee;

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

	
}
