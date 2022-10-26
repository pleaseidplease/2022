package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.board.BoardVO;
import co.edu.common.DAO;

public class BoardDAO extends DAO {
	// 입력,조회,수정,삭제...
	public BoardVO insertBoard(BoardVO vo) {
		// 입력처리중 에러가 발생하면 null;

		getConnect();
		String sql = "select board_seq.nextval from dual";
		String sql2 = "insert into tbl_board (board_no,title,content,writer) values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int nextSeq = 0;
			if (rs.next()) {
				nextSeq = rs.getInt(1);
			}
			// insert
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, nextSeq);
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			int r = psmt.executeUpdate();
			if (r > 0) {
				vo.setBoardNo(nextSeq);
				return vo;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return null;//실패할 경우 null을 반환


	}

	public BoardVO searchBoard(int boardNo) {
		return null;

	}

	public List<BoardVO> boardList(BoardVO vo){
		String sql="select * from tbl_board "
				+ "where 1=1"
				+ "and title like '%'||?||'%'"
				+ "and content like '%'||?||'%'"
				+ "and writer likd '%'||?||'%'";
		conn=getConnect();
		List<BoardVO> list=new ArrayList<BoardVO>();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3,vo.getWriter());
			rs=psmt.executeQuery();
			while(rs.next()) {
				list.add(new BoardVO(rs.getInt("board_no"),rs.getString("title"),rs.getString("content"),rs.getString("writer"),rs.getString("wirte_date"),rs.getInt("click_cnt"),rs.getString("image")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	public boolean updateBoard(BoardVO vo) {
		// 처리건수가 0이면 false;
		return false;

	}

	public boolean deleteBoard(int boardNo) {
		// 처리건수가 0이면 false;
		return false;

	}

}
