package co.edu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Emp implements Serializable {
	int id;
	String name;
	String dept;

	public Emp(int id, String name, String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "사원id: " + id + ", 이름: " + name + ", 부서: " + dept;
	}
}

public class EmpObjectExam {
	public static void main(String[] args) throws Exception {

		// C:/Temp/emp.dat 읽어들이는 파일
		FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);

		ArrayList<Emp> empList = (ArrayList<Emp>) ois.readObject();
		Scanner scn = new Scanner(System.in);

		while (true) {

			System.out.println("1.사원등록 2.목록출력 3.사원삭제 4.종료");
			System.out.println("선택>>");
			int menu = scn.nextInt();
			
			if (menu == 1) {
				System.out.println("사원번호를 입력하세요");
				int empid = scn.nextInt();
				scn.nextLine();
				System.out.println("이름을 입력하세요");
				String name = scn.nextLine();
				System.out.println("부서명을 입력하세요");
				String dept = scn.nextLine();
				
				
				empList.add(new Emp(empid, name, dept));
				
				System.out.println("등록완료");
			} else if (menu == 2) {
				for (Emp emp : empList) {
					System.out.println(emp.toString());
				}
			}else if(menu==3) {
				//사원번호를 기준으로 삭제
				System.out.println("삭제할 사원번호를 입력하세요.");
				int empid=scn.nextInt();
				for(int i=0; i<empList.size();i++) {
					if(empList.get(i).id==empid) {
						empList.remove(i);
					}
				}
			}else if (menu == 4) {
				
				// 컬렉션에 있던 ObjectOutputStream 을 활용해서 C:/Temp/emp.dat 저장하고 종료.
				FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(empList);
				oos.close();
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}

		}
		System.out.println("시스템이 종료되었습니다.");
	}
}
