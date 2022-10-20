package Morning20221014;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UserApp {
	public static void main(String[] args) throws Exception  {
		Scanner scn=new Scanner(System.in);
		UserDAO userexe=new UserDAO();
		FileReader fr=new FileReader("C:/Temp/memberList.txt");
		FileWriter fw=new FileWriter("C:/Temp/memberList.txt");
		FileWriter fw2=new FileWriter("C:/Temp/memberList.txt",true);
		User user=new User();
		
		while(true) {
			
			System.out.println("1.등록 2.목록조회 3.종료");
			System.out.println(">>>>");
			int menu=scn.nextInt();
			if(menu==1) {
				ArrayList<User> list=new ArrayList<User>();
				scn.nextLine();
				System.out.println("등록할 회원아이디를 입력하세요.");
				String userid=scn.nextLine();
				System.out.println("등록할 회원이름을 입력하세요.");
				String username=scn.nextLine();
				System.out.println("등록할 회원포인트를 입력하세요.");
				int userpoint=scn.nextInt();
				user.setUserId(userid);
				user.setUserName(username);
				user.setUserPoint(userpoint);
				if(fr==null) {
					fw.write(user.toString());
					fw.close();
				}else {
					fw2.write(user.toString());
					fw2.close();
				}
			}else if(menu==2) {
				
			}else if(menu==3) {
				
			}else {
				System.out.println("잘못된 메뉴를 선택하였습니다.");
			}
		}
	}
}
