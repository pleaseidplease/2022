package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


//ObjectOutputStream 은 Serializable 을 구현하는 클래스이여만 한다.
class Emp implements Serializable{
	int id;
	String name;
	String dept;

	public Emp(int id, String name, String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "사원id: " + id + ", 이름: " + name + ", 부서: " + dept;
	}
}

public class ObjectExample {
	public static void main(String[] args) {
		try (FileInputStream fis=new FileInputStream("C:/Temp/emp.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);){
			try {
				ArrayList<Emp>list=(ArrayList<Emp>) ois.readObject();
				for(Emp emp:list) {
					System.out.println(emp.toString());
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("complete");
	}
		
		
	public static void writeObj(){
		// 입출력 스트림 -> Class 인스턴스 생성 -> 파일입출력.
				// ObjectInputStream, ObjectOutputStream : Object기반.
				ArrayList<Emp> empList = new ArrayList<>();
				empList.add(new Emp(100, "홍길동", "인사"));
				empList.add(new Emp(200, "김민식", "개발"));
				empList.add(new Emp(300, "이유진", "총무"));

				try (FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
						ObjectOutputStream oos = new ObjectOutputStream(fos);) {
					oos.writeObject(empList);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("completed");

			}
	}

