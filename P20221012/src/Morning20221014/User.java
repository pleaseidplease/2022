package Morning20221014;

import java.io.Serializable;

public class User implements Serializable{
	String userId;
	String userName;
	int userPoint;
	
	public User() {
	
	}
	
	public User(String userId, String userName, int userPoint) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPoint = userPoint;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPoint=" + userPoint + "]";
	}
	
	
	
}
