package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Student{
	String name;
	int score;
	
	@Override
	public int hashCode() {
		return Objects.hash(name, score);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
}

public class MapExample3 {
	public static void main(String[] args) {
		//1.저장 2.조회 3.종료
		Map<Student,Integer> students=new HashMap<>();
		Scanner scn=new Scanner(System.in);

		while(true) {
			System.out.println("1.저장 2.조회 3.종료");
			System.out.println("선택>>>");
			int menu=scn.nextInt();
			if(menu==1) {
				System.out.println("학생이름입력>>>");
				String name=scn.nextLine();
				scn.next();
				System.out.println("학생점수입력>>>");
				int score=scn.nextInt();
				students.put(new Student(name,score), score);
				
			}else if(menu==2){
				System.out.println("조회할 학생이름입력>>");
				String searchName=scn.nextLine();
				scn.next();
				System.out.println("점수: "+students.get(searchName));
			}else if(menu==3) {
				System.out.println("프로그램을 종료하겠습니다.");
				break;
			}
			System.out.println("프로그램 종료.");
		}
	}
}
