package co.edu.project;

public class WorkTime {
	int userid;
	String username;
	String worktime;
	
	public WorkTime(int userid, String username, String worktime) {
		super();
		this.userid = userid;
		this.username = username;
		this.worktime = worktime;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWorktime() {
		return worktime;
	}

	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}

	@Override
	public String toString() {
		return "사번 : " + userid + " 이름: " + username + " 근무시간 : " + worktime;
	}
	
	
}
