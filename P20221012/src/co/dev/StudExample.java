package co.dev;

import java.util.ArrayList;

public class StudExample {
	
	public static void main(String[] args) {
		

		
		ArrayList<Student> studentlist=new ArrayList<Student>();
		studentlist.add(new Student(100,"이재원",100));
		
		for(int i=0;i<studentlist.size();i++) {
			System.out.println(studentlist.get(i).getStudNo());
			System.out.println(studentlist.get(i).getStudName());
			System.out.println(studentlist.get(i).getScore());
		}
		
		//학번기준으로 정렬.
		ArrayList<Student> sortArray=new ArrayList<Student>();
		for(int i=0; i<studentlist.size();i++) {
			
		}
	}
}
