package co.edu.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//int employeeId, String lastName, String email, String hireDate, String jobId

public class EmpDbToFile {
	public static void main(String[] args) {
		EmployeeDAO empDao=new EmployeeDAO();
		try {
			FileWriter fw=new FileWriter("c:/Temp/empFile.txt");
			List<Employee> list=empDao.search(); 
			
			for(Employee emp:list) {
				
				fw.write(emp.getEmployeeId()+","+emp.getLastName()+","+emp.getEmail()+","+emp.getHireDate()+","+emp.getJobId()+"\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("completed");
		
		
	}
}
