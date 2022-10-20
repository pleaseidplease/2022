package co.edu.project;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectExe extends DAO {

	// 아이디 비밀번호 조회
	public boolean check(String id, String pw) {
		boolean chk = false;
		String sql = "select * from users where id=?";
		conn = getConnect();
		List<String> str = new ArrayList<String>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				str.add(rs.getString("id"));
				str.add(rs.getString("passwd"));
			}
			if (str.get(0).equals(id) && str.get(1).equals(pw)) {
				System.out.println("로그인에 성공하였습니다.");
				chk = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return chk = false;
		} finally {
			disconnect();
		}
		return chk;
	}

	// 직원등록 : 사번,이름,나이,직책,부서
	public void insert(int userid, String name, int age, String rank, String jobid) {
		String sql = "insert into userdata values(?,?,?,?,?)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userid);
			psmt.setString(2, name);
			psmt.setInt(3, age);
			psmt.setString(4, rank);
			psmt.setString(5, jobid);
			psmt.executeUpdate();
			System.out.println("등록이 완료되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 직원수정
	public void modify(int userid, String name, int age, String rank, String jobid) {
		String sql = "update userdata set user_name=?,age=?,user_rank=?,jobid=? where user_id=?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setInt(2, age);
			psmt.setString(3, rank);
			psmt.setString(4, jobid);
			psmt.setInt(5, userid);
			psmt.executeUpdate();
			System.out.println("수정이 완료되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 직원목록조회
	public List<Project> search() {
		String sql = "select * from userdata";
		conn = getConnect();
		List<Project> list = new ArrayList<Project>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new Project(rs.getInt("user_id"), rs.getString("user_name"), rs.getInt("age"),
						rs.getString("user_rank"), rs.getString("jobid")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 직원삭제
	public void delete(int userid) {
		String sql = "delete from userdata where user_id=?";

		conn = getConnect();
		List<Project> list = new ArrayList<Project>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userid);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 직원상세조회
	public List<Project> subsearch(int userid) {
		String sql = "select * from userdata where user_id=?";
		conn = getConnect();
		List<Project> list = new ArrayList<Project>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userid);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Project(rs.getInt("user_id"), rs.getString("user_name"), rs.getInt("age"),
						rs.getString("user_rank"), rs.getString("jobid")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 연차등록
	public void insert(int userid, String username, String hiredate) {
		String sql = "insert into userfree(user_id,user_name,hire_date,user_free)\r\n"
				+ "values(?,?,to_date(?),floor(floor(sysdate-to_date(?))/30))";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userid);
			psmt.setString(2, username);
			psmt.setString(3, hiredate);
			psmt.setString(4, hiredate);
			psmt.executeUpdate();
			System.out.println("등록이 완료되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 연차전체조회
	public List<UserFree> search2() {
		String sql = "select * from userfree";
		conn = getConnect();
		List<UserFree> list = new ArrayList<UserFree>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new UserFree(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("hire_date"),
						rs.getString("user_free")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 연차상세조회
	public List<UserFree> subsearch2(int userid) {
		String sql = "select * from userfree where user_id=? ";
		conn = getConnect();
		List<UserFree> list = new ArrayList<UserFree>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userid);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new UserFree(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("hire_date"),
						rs.getString("user_free")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 연차사용
	public void use(int userid) {
		String sql = "update userfree set user_free=user_free-1 where  user_id=?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userid);
			psmt.executeUpdate();
			System.out.println("적용되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 근무시간 등록
	public void winsert(int userid, String username) {
		String sql = "insert into worktime(user_id,user_name,work_time) values(?,?,'0')";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userid);
			psmt.setString(2, username);
			psmt.executeUpdate();
			System.out.println("등록이 완료되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 전원출근
	public void worktimeupdate() {
		String sql = "update worktime set work_time=work_time+8";
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("데이터가 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 미출근기록
	public void worktimeupdate2(int userid) {
		String sql = "update worktime set work_time=work_time-8 where user_id=?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userid);
			psmt.executeUpdate();
			System.out.println("데이터가 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 총근무시간조회
	public List<WorkTime> worksearch() {
		String sql = "select * from worktime";
		conn = getConnect();
		List<WorkTime> list = new ArrayList<WorkTime>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new WorkTime(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("work_time")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 월근무시간초기화
	public void reset() {
		String sql = "update worktime set work_time=0";
		conn = getConnect();

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("초기화를 완료하였습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 제출용 파일만들기
	public void file(int number) {
		try {
			FileWriter fw = new FileWriter("c://Temp/userfile.txt");
			FileWriter fw2 = new FileWriter("c://Temp/userfree.txt");
			FileWriter fw3 = new FileWriter("c://Temp/worktime.txt");
			String sql1 = "select * from worktime";
			String sql2 = "select * from userfree";
			String sql3 = "select * from userdata";
			conn = getConnect();

			if (number == 1) {
				try {
					List<Project> list = new ArrayList<Project>();
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql3);
					while (rs.next()) {
						list.add(new Project(rs.getInt("user_id"), rs.getString("user_name"), rs.getInt("age"),
								rs.getString("user_rank"), rs.getString("jobid")));
					}
					for (Project pj : list) {
						fw.write(pj.getUserid()+","+pj.getName()+","+pj.getAge()+","+pj.getRank()+","+pj.getJobid()+"\n");
					}
					System.out.println("파일을 생성하였습니다.");
					fw.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					disconnect();
				}
			} else if (number == 2) {
				List<UserFree> list = new ArrayList<UserFree>();
				try {
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql2);
					while (rs.next()) {
						list.add(new UserFree(rs.getInt("user_id"), rs.getString("user_name"),
								rs.getString("hire_date"), rs.getString("user_free")));
					}
					for (UserFree pj : list) {
						fw2.write(pj.getUserid()+","+pj.getName()+","+pj.getHiredate()+","+pj.getUserfree()+"\n");
					}
					System.out.println("파일을 생성하였습니다.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					disconnect();
				}

			} else if (number == 3) {
				List<WorkTime> list = new ArrayList<WorkTime>();
				try {
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql1);
					while (rs.next()) {
						list.add(new WorkTime(rs.getInt("user_id"), rs.getString("user_name"),
								rs.getString("work_time")));
					}
					for (WorkTime pj : list) {
						System.out.println(pj);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					disconnect();
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}

	}
}
