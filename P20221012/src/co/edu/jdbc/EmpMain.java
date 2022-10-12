package co.edu.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class EmpMain {
	public static void main(String[] args) {
	
		EmployeeDAO empDao = new EmployeeDAO();
		Scanner scn = new Scanner(System.in);

	
		
		
		while (true) {
			// 메뉴=>1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 6.일괄등록 9.종료
			System.out.println("메뉴=>1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 6.종료");
			int menu = scn.nextInt();
			// int employeeId, String lastName, String email, String hireDate, String jobId
			if (menu == 1) {
				System.out.println("사원번호를 입력하세요");
				int employeeId = scn.nextInt();
				scn.nextLine();
				System.out.println("이름을 입력하세요");
				String lastName = scn.nextLine();
				System.out.println("이메일을 입력하세요");
				String email = scn.nextLine();
				System.out.println("입사일을 입력하세요");
				String hireDate = scn.nextLine();
				System.out.println("부서명으 입력하세요");
				String jobId = scn.nextLine();
				Employee emp1 = new Employee(employeeId, lastName, email, hireDate, jobId);

				empDao.insert(emp1);
				System.out.println("등록이 완료되었습니다.");
			} else if (menu == 2) {
				System.out.println("조회할 사원번호를 입력하세요.");
				int num = scn.nextInt();
				empDao.getEmp(num);
			} else if (menu == 3) {
				System.out.println("수정할 사원번호를 입력하세요");
				int employeeId = scn.nextInt();
				scn.nextLine();
				System.out.println("수정할 이름을 입력하세요");
				String lastName = scn.nextLine();
				System.out.println("수정할 이메일을 입력하세요");
				String email = scn.nextLine();
				System.out.println("수정할 입사일을 입력하세요");
				String hireDate = scn.nextLine();
				System.out.println("수정할 부서명으 입력하세요");
				String jobId = scn.nextLine();
				Employee emp1 = new Employee(employeeId, lastName, email, hireDate, jobId);
				empDao.update(emp1);
			} else if (menu == 4) {
				System.out.println("삭제할 사원번호를 입력하세요");
				int employeeId = scn.nextInt();
				empDao.delete(employeeId);
				
			} else if (menu == 5) {
				List<Employee> employee=empDao.search();
				for(Employee emp:employee) {
					System.out.println(emp);
				}
			} else if (menu == 6) {
				System.out.println();
				break;
			} else {
				System.out.println("잘못된 메뉴를 입력하였습니다.");
			}

		}

	}
	}
