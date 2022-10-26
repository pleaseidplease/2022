package co.edu.board;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private String writeDate;
	private int clickCnt;
	private String image;
	
	public BoardVO(int boardNo, String title, String content, String writer, String writeDate, int clickCnt,
			String image) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
		this.clickCnt = clickCnt;
		this.image = image;
	}
	
	
	
}
