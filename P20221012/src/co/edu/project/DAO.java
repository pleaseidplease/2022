package co.edu.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DB연결 Connection 생성
public class DAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;

	// Connection 반환 getConnect
	public Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("연결실패");
		}		
		return conn;
	}

	// Resource 해제하는 disconnect
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
			if (psmt != null)
				psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
