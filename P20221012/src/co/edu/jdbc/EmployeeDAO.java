package co.edu.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends DAO {

	public void insert(Employee emp) {

		// sql 삽입
		String sql = "insert into empl (employee_id, last_name,email,hire_date,job_id)" + "values("
				+ emp.getEmployeeId() + ",'" + emp.getLastName() + "','" + emp.getEmail() + "','" + emp.getHireDate()
				+ "','" + emp.getJobId() + "')";

		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 조회
	public List<Employee> search() {
		List<Employee> list = new ArrayList<>();
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select*from empl");
			while (rs.next()) {

				list.add(new Employee(rs.getInt("employee_id"), rs.getString("last_name"), rs.getString("email"),
						rs.getString("hire_date"), rs.getString("job_id")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 여러개 업데이트
	public void update(Employee emp) {
		String sql = "update empl set email=?,hire_date=?,job_id=?,last_name=? where employee_id=?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getEmail());
			psmt.setString(2, emp.getHireDate());
			psmt.setString(3, emp.getJobId());
			psmt.setString(4, emp.getLastName());
			psmt.setInt(5, emp.getEmployeeId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경이 완료되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 삭제
	public void delete(int empId) {
		String sql = "delete from empl where employee_id=?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			int r = psmt.executeUpdate();

			System.out.println(r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 한건만 반환.
	public Employee getEmp(int empId) {
		String sql = "select * from empl where employee_id=?";
		conn = getConnect();
		Employee result = new Employee();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				result = new Employee(rs.getInt("employee_id"), rs.getString("last_name"), rs.getString("email"),
						rs.getString("hire_date"), rs.getString("job_id"));
			}
			System.out.println(result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

}
