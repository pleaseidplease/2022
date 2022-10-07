package co.edu.collect;

import java.util.Scanner;

public class ExcitingGame {
	public static void main(String[] args) {
		long gameStart = System.currentTimeMillis();
		Scanner scn = new Scanner(System.in);
		String target = "Defines the AwT and Swing user interface tool";
		System.out.println(target);
		String[] targetAry = target.split(" ");
		boolean done = false;
		while (true) {

			done = true;
			System.out.println("\n 지우고자 하는 문장을 입력하세요");

			String input = scn.nextLine();

			for (int i = 0; i < targetAry.length; i++) {
				if (targetAry[i] != null && targetAry[i].equals(input)) {
					targetAry[i] = null;

				}

			}

			for (int i = 0; i < targetAry.length; i++) {
				System.out.println("targetAry" + "[" + i + "]" + targetAry[i]);
			}

			for (String str : targetAry) {
				if (str != null) {
					System.out.printf("%s ", str);
					done = false;

				}
			}
			if (done) {
				System.out.println("시스템을 종료하겠습니다.");
				break;
			}
			

		}
		long endStart = System.currentTimeMillis();
		long result=(endStart-gameStart)/60000;
		if(result%2<2) {
		System.out.println("2분안지났습니다");
	}
		else {
			System.out.println("2분지났습니다.");
		}
		

//		if(targetAry[0].equals("Defines")){
//			targetAry[0]=null;
//		}
//		for(String str:targetAry) {
//			if(str!=null) {
//				System.out.printf("%s",str);
//			}
//		}
//		long gameEnd=System.currentTimeMillis();
//		long during=(gameEnd-gameStart); //1*60*1000+30*1000 =63000/60000분, 나머지는=>초
//		System.out.println("2분 22초가 걸렸습니다.");
}}
