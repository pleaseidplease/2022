package co.edu.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringExe {
	public static void main(String[] args) {
		String fileName = "src/co/edu/api/Birth.txt";
		File file = new File(fileName);
		String searchkey = "자바";
		Scanner scn = null;
		try {
			scn = new Scanner(file);
			while (true) {
				String str = scn.nextLine();
				if (str == null) {
					break;
				}
				if (str.charAt(7)=='1'||str.charAt(7)=='3') {
					System.out.println("남자입니다.");
				}else if(str.charAt(7)=='2'||str.charAt(7)=='4')
					System.out.println("여자입니다.");
				}else {//년도,월,일 정보가 잘못되면 잘못된 번호로 인식.
					
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchElementException e) {

		}
		System.out.println("end of prog");
	}
}
