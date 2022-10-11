package co.edu.memo;

import java.io.Serializable;

public class Memo implements Serializable{
	private int no;
	private String date;
	private String content;
	
	public Memo(int no, String date,String content) {
		this.no=no;
		this.date=date;
		this.content=content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "번호: "+getNo()+", 날짜: "+getDate()+", 내용: "+getContent();
	}
}
