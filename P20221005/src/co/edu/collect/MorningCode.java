package co.edu.collect;

import java.util.ArrayList;
import java.util.Scanner;

class Employi {
	int empId;
	String empName;
	int salary;

	public Employi(int empId, String empName, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	// toString : 컴퓨터 언어로 된것을 우리가 알아볼수있는 글로 변환
	public String toString() {
		return "Employi [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}

}

public class MorningCode {
	public static void main(String[] args) {
		String tok = "Hello World Good Friend";
		Scanner scn = new Scanner(tok);
		Scanner scanner = new Scanner(System.in);

		// scn.next():공백을 기준으로 문장을 하나씩 가져온다.
		// scn.hasNext():다음문장이 있는만큼 가져온다
		// while(scn.hasNext())
		// System.out.println(scn.next());

		// split(): 안의 내용만큼 나눠서 문장을 구현.
//		String[] toks=tok.split(" ");
//		for(String str:toks) {
//			System.out.println(str);
//		}

		while (true) {
			
			System.out.println("입력 >> ex) 100 홍길동 2500");
			String inputVal = scanner.nextLine();
			// 첫번째 값=>empId, 두번째 값=> empName, 세번째 값=>salary
			// Employi 클래스의 인스턴스 생성.
			// Arraylist 에 저장.
			// 종료하고 싶으면 입력값에 -1을 넣으면 종료.

			String quit = "quit";
			if (inputVal.equals(quit)) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
			
			String[] arry = inputVal.split(" ");
			
			if (arry.length != 3) {
				System.out.println("다시 입력하세요");
				continue;
			}
			
			ArrayList<Employi> ary = new ArrayList<>();
			//Integer.parseInt:문자열을 정수형으로 강제로 변경시켜줌. 
			ary.add(new Employi(Integer.parseInt(arry[0]), arry[1], Integer.parseInt(arry[2])));

			for (Employi emp : ary) {
				System.out.println(emp.toString());
			}
		}
	}
}
