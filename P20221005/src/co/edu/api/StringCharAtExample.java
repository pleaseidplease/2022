package co.edu.api;

public class StringCharAtExample {
	public static void main(String[] args) {
		String ssn="010624-2230123";
		char sex=ssn.charAt(7);
		switch(sex) {
			case '1':
			case '3':
				System.out.println("남자 입니다");
				break;
			case '2':
			case '4':
				System.err.println("여자 입니다.");
				break;
		}
	}
}