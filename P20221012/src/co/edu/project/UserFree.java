package co.edu.project;

public class UserFree {
	
	int userid;
	String name;
	String hiredate;
	String userfree;
	
	public UserFree(int userid,String name,String hiredate) {
		this.userid=userid;
		this.name=name;
		this.hiredate=hiredate;
	}

	public UserFree(int userid,String name,String hiredate,String userfree) {
		this.userid=userid;
		this.name=name;
		this.hiredate=hiredate;
		this.userfree=userfree;
	}

	
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getUserfree() {
		return userfree;
	}

	public void setUserfree(String userfree) {
		this.userfree = userfree;
	}

	@Override
	public String toString() {
		return "사번: " + userid + " 이름: " + name + " 입사일: " + hiredate + " 남은연차: " + userfree
				;
	}
	
	
}
