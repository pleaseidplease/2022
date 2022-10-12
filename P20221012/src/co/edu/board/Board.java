package co.edu.board;



public class Board {

	private int number;
	private String title;
	private String content;
	private String writer;
	private String date;
	private int cnt;
	
	public Board() {
		
	}
	
	public Board(int number, String title, String content, String writer, String date, int cnt) {
		super();
		this.number = number;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.cnt = cnt;
	}
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Board [number=" + number + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", date=" + date + ", cnt=" + cnt + "]";
	}
	
	
}




//create table board(
//board_num int PRIMARY key,--글번호
//board_title VARCHAR2(100) not null,--제목
//board_content VARCHAR2(300) not null,--내용
//board_writer VARCHAR2(20) not null,--작성자
//creation_date date DEFAULT SYSDATE ,--작성일시
//cnt int DEFAULT 0 --글을 읽은 횟수
//);
//
//insert into board (board_num, board_title,board_content, board_writer)
//values(1,'첫글입니다','게시판을 생성합니다','user1');
//
//insert into board (board_num, board_title,board_content, board_writer)
//values(11,'JDBC프로그램은 ','Oracle Driver를 이용합니다.','user1');
//
//update board
//set board_content='바뀐내용', creation_date=sysdate
//where board_num=1;
//
//update board set cnt=cnt+1 where board_num=1;
//
//DELETE from board where board_num=11;
//
//
//select * from board order by board_num;
//select *from board where board_num=11;