package co.edu.project;

import java.util.Scanner;

public class ProjectApp {
	public static void main(String[] args) {
		ProjectExe pexe = new ProjectExe();
		Scanner scn = new Scanner(System.in);
		boolean check = true;
		
		while (true) {
			if (check != false) {
				System.out.println("=============================================================================================");
				System.out.println("로그인 아이디를 입력해주세요");
				System.out.println("=============================================================================================");
				System.out.println(">>> ");
				String id = scn.nextLine();
				System.out.println("=============================================================================================");
				System.out.println("비밀번호를 입력해주세요.");
				System.out.println("=============================================================================================");
				System.out.println(">>> ");
				String pw = scn.nextLine();
				check = pexe.check(id, pw);
			} else {
				while (true) {
					System.out.println("=============================================================================================");
					System.out.println("1.직원관리 2.연차관리 3.근태관리 4.제출용파일만들기 5.종료");
					System.out.println("=============================================================================================");
					System.out.println(">>> ");
					int menu = scn.nextInt();
					if (menu == 1) {
						while (true) {
							System.out.println("=============================================================================================");
							System.out.println("1. 직원등록 2.직원수정 3.직원삭제 4.직원목록 5.상세조회 9.메인메뉴");
							System.out.println("=============================================================================================");
							System.out.println(">>>");
							int submenu = scn.nextInt();
							if (submenu == 1) {
								System.out.println("사번을 입력하세요.");
								System.out.println(">>>");
								int empid = scn.nextInt();
								scn.nextLine();
								System.out.println("직원의 이름을 입력하세요.");
								System.out.println(">>>");
								String name = scn.nextLine();
								System.out.println("직원의 나이를 입력하세요.");
								System.out.println(">>>");
								int age = scn.nextInt();
								scn.nextLine();
								System.out.println("직원의 직책을 입력하세요.");
								System.out.println(">>>");
								String rank = scn.nextLine();
								System.out.println("직원의 부서를 입력하세요.");
								System.out.println(">>>");
								String jobid = scn.nextLine();
								pexe.insert(empid, name, age, rank, jobid);
							} else if (submenu == 2) {
								System.out.println("수정할 사번을 입력하세요.");
								System.out.println(">>>");
								int empid = scn.nextInt();
								scn.nextLine();
								System.out.println("수정할 직원의 이름을 입력하세요.");
								System.out.println(">>>");
								String name = scn.nextLine();
								System.out.println("수정할 직원의 나이를 입력하세요.");
								System.out.println(">>>");
								int age = scn.nextInt();
								scn.nextLine();
								System.out.println("수정할 직원의 직책을 입력하세요.");
								System.out.println(">>>");
								String rank = scn.nextLine();
								System.out.println("수정할 직원의 부서를 입력하세요.");
								System.out.println(">>>");
								String jobid = scn.nextLine();
								pexe.modify(empid, name, age, rank, jobid);
							} else if (submenu == 3) {
								System.out.println("삭제할 사번을 입력해주세요.");
								System.out.println(">>> ");
								int userid = scn.nextInt();
								pexe.delete(userid);
							} else if (submenu == 4) {
								for (Project pj : pexe.search()) {
									System.out.println(pj);
								}
							} else if (submenu == 5) {
								System.out.println("상세조회할 사번을 입력해주세요.");
								System.out.println(">>> ");
								int userid = scn.nextInt();
								for (Project pj : pexe.subsearch(userid)) {
									System.out.println(pj);
								}
							} else if (submenu == 9) {
								scn.nextLine();
								break;
							} else {
								System.out.println("잘못된 메뉴를 선택하였습니다.");
								continue;
							}

						}
					} else if (menu == 2) {
						while (true) {
							System.out.println("=============================================================================================");
							System.out.println("1.연차등록 2.연차조회 3.연차상세조회 4.연차사용 5.메인메뉴");
							System.out.println("=============================================================================================");
							System.out.println(">>> ");
							int submenu = scn.nextInt();
							if (submenu == 1) {
								System.out.println("등록할 사번을 입력해주세요.");
								System.out.println(">>> ");
								int userid = scn.nextInt();
								scn.nextLine();
								System.out.println("등록할 이름을 입력해주세요.");
								System.out.println(">>> ");
								String name = scn.nextLine();
								System.out.println("입사 날짜를 입력해주세요 ex)22/10/18");
								System.out.println(">>> ");
								String hiredate = scn.nextLine();
								pexe.insert(userid, name, hiredate);
							} else if (submenu == 2) {
								for (UserFree pj2 : pexe.search2()) {
									System.out.println(pj2);
								}
							} else if (submenu == 3) {
								System.out.println("상세조회할 사번을 입력하세요.");
								System.out.println(">>> ");
								int userid = scn.nextInt();
								for (UserFree pj : pexe.subsearch2(userid)) {
									System.out.println(pj);
								}
							} else if (submenu == 4) {
								System.out.println("연차를 사용한 사번을 입력해주세요.");
								System.out.println(">>> ");
								int userid = scn.nextInt();
								pexe.use(userid);
							} else if (submenu == 5) {
								scn.nextLine();
								break;
							} else {
								System.out.println("잘못된 메뉴를 선택하였습니다.");
								continue;
							}
						}
					} else if (menu == 3) {
						while (true) {
							System.out.println("=============================================================================================");
							System.out.println("1.직원등록 2.금일근태관리 3.총근무시간조회 4.월초근무시간초기화 5.메인메뉴");
							System.out.println("=============================================================================================");
							System.out.println(">>> ");
							int submenu = scn.nextInt();
							scn.nextLine();
							if (submenu == 1) {
								System.out.println("사번을 입력하세요.");
								System.out.println(">>> ");
								int userid = scn.nextInt();
								scn.nextLine();
								System.out.println("이름을 입력하세요.");
								System.out.println(">>> ");
								String name = scn.nextLine();
								pexe.winsert(userid, name);
							} else if (submenu == 2) {
								System.out.println("전원 출근하였습니까? Y/N");
								System.out.println(">>>");
								String answer = scn.nextLine();
								if (answer.equals("Y")) {
									pexe.worktimeupdate();
								} else if (answer.equals("N")) {
									System.out.println("미출근 인원의 사번을 입력해주세요.");
									System.out.println(">>> ");
									int userid = scn.nextInt();
									pexe.worktimeupdate2(userid);
								} else {
									System.out.println("잘못된 데이터를 입력하였습니다.");
								}
							} else if (submenu == 3) {
								for (WorkTime wt : pexe.worksearch()) {
									System.out.println(wt);
								}
							} else if (submenu == 4) {
								System.out.println("월초근무시간을 초기화하겠습니까? Y/N");
								System.out.println(">>> ");
								String answer = scn.nextLine();
								if (answer.equals("Y")) {
									pexe.reset();
								} else if (answer.equals("N")) {
									continue;
								} else {
									System.out.println("잘못입력하였습니다.");
									continue;
								}
							} else if (submenu == 5) {
								break;
							} else {
								System.out.println("잘못된 메뉴를 선택하였습니다.");
								continue;
							}
						}
					} else if (menu == 4) {
						while (true) {
							System.out.println("=============================================================================================");
							System.out.println("1.직원목록 2.연차목록 3.근무목록 4.메인메뉴");
							System.out.println("=============================================================================================");
							System.out.println("제출할 목록을 선택해주세요 >>> ");
							int number = scn.nextInt();
							if (number == 1 || number == 2 || number == 3) {
								pexe.file(number);
								continue;
							} else if (number == 4) {
								scn.nextLine();
								break;
							} else {
								System.out.println("잘못된 메뉴를 선택하였습니다.");
								continue;
							}
						}
					} else if (menu == 5) {
						System.out.println("프로그램을 종료하겠습니다.");
						scn.nextLine();
						break;
					} else {
						System.out.println("잘못된 메뉴를 선택하였습니다.");
						continue;
					}
				}
				break;
			}
		}
	}
}