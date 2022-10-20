package co.edu.nested;

//익명 구현객체.
//추상메소드 하나만 존재하는 인터페이스 => Functional 인터페이스.
interface MyInterface {

	void run();

}

interface Myinterface2 {
	void run(String kind);
}

interface Myinterface3 {
	int sum(int num1, int num2);
}

public class AnonymousExample3 {
	public static void main(String[] args) {
		//람다표현식
		MyInterface intf = () -> System.out.println("Myinterface Run");
		intf.run();
		
		Myinterface2 intf2=(String kind)->System.out.println(kind+" Run.");
		intf2.run("농구 종목");
		
		
		Myinterface3 intf3=(int num1, int num2)-> {
				// TODO Auto-generated method stub
				return num1*2+num2;
		};
		System.out.println(intf3.sum(2, 5));
		
		
		intf3=(int num1, int num2)->{			
			return num1*3+num2;
		};
		System.out.println(intf3.sum(5, 4));
		
		
	}
}
