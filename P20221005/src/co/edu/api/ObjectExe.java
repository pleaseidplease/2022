package co.edu.api;

import java.util.Set;

class Student{
	String name;
	int age;
	
//	Set 컬렉션: 동일한 인스턴스는 담아주지않는 컬렉션.
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "학생의 이름은" +name+",나이는"+age+"입니다.";
	}
	@Override//자식클래스가 기능을 재정의.
	public boolean equals(Object obj) {
		if(!(obj instanceof Student)) {
			return false;
		}
		
//		return super.equals(obj);
		Student str=(Student)obj;
		if(this.name.equals(str.name)&&this.age==str.age) {
			return true;
		}
		
		return false;
		}
	}
}
//모든 클래스의 최상위 Object
public class ObjectExe {
	public static void main(String[] args) {
		Object obj=new Object();
		Object obj2=new Object();
		
		System.out.println(obj.equals(obj2));//obj==obj2
		Student s1=new Student();
		s1.name="Hong";
		s1.age=10;
		Student s2=new Student();
		s2.name="Hong";
		s2.age=11;
		String s3="Hong";
		System.out.println(s1.hashCode());
		
		//Set컬렉션:인터페이스-> 구현클래스 통해서 인스턴스 생성.
		Set<Integer> set=new HashSet<Integer>();
		set.add(new Integer(100));
		//Set 컬렉션에 Student 인스턴스 저장.
		Set<Student> students=new HashSet<Integer>();
		}
}
