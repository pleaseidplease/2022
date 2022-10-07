package co.edu.collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Employee {
	int empId;
	String name;
	int salary;

	public Employee(int empId, String name, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	@Override
	// hashCode()의 값을 가져와서 동일한 값이 있으면 중복해서 저장해주지 않는다.
	public int hashCode() {
		return empId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			Employee target = (Employee) obj; // casting.
			return (this.empId == target.empId && this.name.equals(target.name) && this.salary == target.salary); 
		} else
			return false;
	}

}

public class SetExample {
	public static void main(String[] args) {
		Set<Employee> employees = new HashSet<Employee>();
		employees.add(new Employee(100, "홍길동", 1000));
		employees.add(new Employee(200, "박유식", 2000));
		employees.add(new Employee(300, "최윤기", 3000));

		// Set 컬렉션 : 데이터를 중복해서 저장해주지 않는다.
		employees.add(new Employee(200, "김길동", 1000));

		// Set 제거
		employees.remove(new Employee(100, "박길동", 1000));

		System.out.println(employees.size());

		Iterator<Employee> iter = employees.iterator();
		while (iter.hasNext()) {
			Employee emp = iter.next();
			System.out.printf("사번은 %d, 이름은 %s, 급여는 %d\n", emp.empId, emp.name, emp.salary);
		}
		
		Set<Integer> set=new HashSet<Integer>();
		while(set.size()<8) {
			set.add((int)(Math.random()*45)+1);
		}
		for(int n :set) {
			System.out.println(n);
		}
		
		// 중복저장 불가.
//		int[] lotto = new int[7];
//		for (int i = 0; i < lotto.length; i++) {
//			// Math.random():0이상 1미만 난수.
//			int temp = (int) (Math.random() * 7) + 1;
//
//			// 현재 인덱스 값보다 적은 위치에 temp와 같은 값이 있는지 체크.
//			boolean exists = false;
//			for (int j = 0; j < i; j++) {
//				exists = true;
//			}
//			if (exists)
//				continue; 
//			//continue: 실행이되면 다음번의 반복문 순서로 넘어가게된다.
//			lotto[i] = temp;
//		}
//		for (int n : lotto) {
//			System.out.printf("%d\t", n);
//		}

	}
}
