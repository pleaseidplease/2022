package co.edu.api;

public class StringExe2 {
	public static void main(String[] args) {
//		System.out.println("abcDEF".toLowerCase());
		while(true) {
			try {
				int bytes=System.in.read();
				if(bytes==122)
					break;
				System.out.println("입력값: "+bytes);
			} catch (Exception e) {
				e.printStackTrace();			
				// TODO: handle exception
			}
		}
	}
//	}
	public static void changeCapital(String msg) {
		//대문자-> 소문자, 소문자->대문자
		//aBcD=>AbCd
		//소문자:97~122, 대문자:65~90
		String a="aBcD";
		if(a)
	}
}

