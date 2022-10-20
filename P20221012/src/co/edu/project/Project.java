package co.edu.project;

public class Project {
	String id;
	String password;
	
	//직원등록 사번,이름,나이,직책,부서
	int userid;
	String name;
	int age;
	String rank;
	String jobid;
	
	
	public Project(int userid) {
		this.userid=userid;
	}
	
	public Project(int userid, String name, int age, String rank, String jobid) {
		super();
		this.userid = userid;
		this.name = name;
		this.age = age;
		this.rank = rank;
		this.jobid = jobid;
	}
	
	
	
	public void Project() {
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "사번: " + userid + " 이름: " + name + " 나이: " + age + " 직급: " + rank + " 부서: " + jobid
				;
	}
	
	
	
}
