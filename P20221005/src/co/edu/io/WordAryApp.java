package co.edu.io;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordAryApp {
	public static void main(String[] args) throws Exception {
		// 임의 단어를 10개씩 출력하고 타이핑해서 맞으면 사라지고
		// 다르면 남아있음.
		Scanner scn = new Scanner(System.in);
		ArrayList<String> words = randomWords(2);
		System.out.println(words.size());
		for (String word : words) {
			System.out.println(word);
		}
		
		boolean key=true;
		while (key) {
			key=false;
			System.out.println("지울 문장을 작성해주세요");
			String del = scn.nextLine();
			for (int i = 0; i < words.size(); i++) {
				if (words.get(i).equals(del)) {
					words.remove(i);
				}
			}
			
			for(String str:words) {
				System.out.println(str);
				key=true;
			}
			
			if(key==false) {
				break;
			}
			
		}
	}

	public static ArrayList<String> randomWords(int times) throws Exception {
		// ArrayList<String> 전체 문장을 담고
		ArrayList<String> words = new ArrayList<String>();
		String path = "src/co/edu/io/wordAry.txt";
		File file = new File(path);
		Scanner scn = new Scanner(file);
		while (scn.hasNext()) {
			String readStr = scn.nextLine();
			readStr = readStr.replaceAll("\"", "").trim();
//			System.out.println(readStr);
			words.add(readStr.substring(0, readStr.indexOf(",")));
		}

		// 임의의 갯수(times)갯수만큼을 반환하도록.

		ArrayList<String> randomWords = new ArrayList<String>();
		// ==>CODE HERE...
		
		
		//중복된 값을 제거하기 위해서 SET 컬렉션을 사용하여 저장.
		Set<Integer> idxSet=new HashSet<>();
		for (int i = 0; i < times; i++) {
			int count = (int) (Math.random() * words.size());

			randomWords.add(words.get(count));
		}

		scn.close();
		return randomWords;
	}

}
