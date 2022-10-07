package co.edu.api;

public class MorningExe {
	public static void main(String[] args) {
		int result = 0;
		for (int i = 1; i < 5; i++) {
			
			for (int j = 1; j < 5; j++) {
				
				if(i==j) {
					result++;
				}
				else if(j==1) {
					result++;
				}else if(i>j) {
					result++;
				}else if(i<j) {
					break;
				}
				System.out.printf("%3d",result);
			}
			
			System.out.println();
		}
		
		int result2=0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(i==j) {
					
				}
				System.out.printf("%3d",result);
			}
			System.out.println();
		}
	}
}

// 1 
// 2 3 
// 4 5 6 
// 7 8 9 10 -34