package co.edu.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpFileToJDBC {
	public static void main(String[] args) {
		String[] emps=null;
		EmployeeDAO empDao = new EmployeeDAO();
		Scanner scn = new Scanner(System.in);
		Employee employee=null;
		
		try {
			FileReader fr=new FileReader("c:/Temp/emplist.txt");
			BufferedReader br=new BufferedReader(fr);
			while(true) {
				String emp;
				try {
					emp = br.readLine();
					if(emp==null) {
						break;
					}
					emps=emp.split(" ");
					employee=new Employee(Integer.parseInt(emps[0]),emps[1],emps[2],emps[3],emps[4]);
					empDao.insert(employee);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
