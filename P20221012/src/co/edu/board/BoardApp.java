package co.edu.board;

import java.util.List;
import java.util.Scanner;

//main 메소드
public class BoardApp {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		BoardDAO bdDao= new BoardDAO();
		while(true) {
			System.out.println("1.글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 6.종료");
			int menu=scn.nextInt();
			if(menu==1) {
				System.out.println("글의 번호 입력하세요");
				int num=scn.nextInt();
				scn.nextLine();
				System.out.println("글의 제목을 입력하세요");
				String title=scn.nextLine();
				System.out.println("글의 내용을 입력하세요");
				String content=scn.nextLine();
				System.out.println("글의 작가를 입력하세요");
				String writer=scn.nextLine();
				String date=null;
				int cnt=0;
				Board bd1=new Board(num, title, content, writer, date, cnt);
				bdDao.insert(bd1);
				System.out.println("등록이 완료되었습니다.");
				
			}else if(menu==2) {
				System.out.println("수정할 글의 번호 입력하세요");
				int num=scn.nextInt();
				scn.nextLine();
				System.out.println("수정할 글의 제목을 입력하세요");
				String title=scn.nextLine();
				System.out.println("수정할 글의 내용을 입력하세요");
				String content=scn.nextLine();
				System.out.println("수정할 글의 작가를 입력하세요");
				String writer=scn.nextLine();
				String date=null;
				int cnt=0;
				Board bd1=new Board(num, title, content, writer, date, cnt);
				bdDao.update(bd1);
				System.out.println("수정이 완료되었습니다.");
			}else if(menu==3) {
				System.out.println("삭제할 글의 번호를 입력하세요");
				int num=scn.nextInt();
				bdDao.delete(num);
			}else if(menu==4) {
				List<Board> board=bdDao.search();
				for(Board bd:board) {
					System.out.println(bd);
				}
			}else if(menu==5) {
				System.out.println("상세보기할 글의 번호를 입력하세요.");
				int num=scn.nextInt();
				bdDao.getNum(num);
			}else if(menu==6) {
				System.out.println("프로그램을 종료하겠습니다.");
				break;
			}else {
				System.out.println("잘못된 메뉴를 선택하였습니다.");
				
			
			
			}
		}
	}
}
