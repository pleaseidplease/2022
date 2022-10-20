package co.gui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.jdbc.Employee;

public class EmpDAO extends DAO {

	// 입력
	public void insertEmp(EmployeeVO vo) {
		conn = getConnect();
		String sql = "insert into empl (employee_id,first_name, last_name, email,hire_date,job_id) values(employees_seq.nextval,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력이 완료되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public void deleteEmp(int employeeid) {
		conn = getConnect();
		String sql = "delete from empl where employee_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, employeeid);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}
	// 수정
	public void updateEmp(EmployeeVO vo) {
		conn=getConnect();
		String sql="update empl set firs_name=?,last_name=?,email=?,hire_date=?,job_id=? where employee_id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			psmt.setInt(6, vo.getEmployeeId());
			int r=psmt.executeUpdate();
			System.out.println(r+"건 수정이 완료되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}				
	}
	
	// 목록
	public List<EmployeeVO> empList(EmployeeVO vo){
		conn=getConnect();
		List<EmployeeVO> empList=new ArrayList<EmployeeVO>();
		String sql="select * from empl "
				+"where 1=1 and employee_id=decode(?,0,employee_id,?)"
				+"and first_name like '%'||?||'%'"
				+"and last_name like '%'||?||'%'"
				+"and email like '%'||?||'%'"
				+"and to_char(hire_date,'yyyy-mm-dd') like '%'||?||'%'"
				+"and job_id=nvl(?,job_id)"
				+"order by employee_id";		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, vo.getEmployeeId());
			psmt.setInt(2, vo.getEmployeeId());
			psmt.setString(3, vo.getFirstName());
			psmt.setString(4, vo.getLastName());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getHireDate());
			psmt.setString(7, vo.getJobId());
			rs=psmt.executeQuery();
			while(rs.next()) {
				empList.add(new EmployeeVO(rs.getInt("employee_id")
						, rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getString("email"), 
						rs.getString("hire_date"), 
						rs.getString("job_id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}		
		return empList;		
	}
	
}
