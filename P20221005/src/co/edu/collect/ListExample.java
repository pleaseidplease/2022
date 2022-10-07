package co.edu.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListExample {
	public static void main(String[] args) {
		ArrayList<String> strs=new ArrayList<String>();
		//추가
		strs.add("홍길동");
		strs.add("김연아");
		strs.add("박지성");
		strs.add("손연재");
		
		//제거
		strs.remove(0);
		strs.remove("박지성");
		
		//특정위치에 추가
		strs.add(0,"손흥민");
		
		
		//출력
		System.out.println("strs의 size: "+strs.size());
		
		for(int i=0;i<strs.size();i++) {
			System.out.println(i+1+"번째의 strs은 "+strs.get(i));	
		}
		
		for(String str:strs){
			System.out.println(str);
		}
		
		
		//반복자를 생성. Iterator:컬렉션을 읽어들이는데 사용하는 도구.
		//hasNext:읽어들일 데이터가 있으면 true, 없으면 false;
		//next():읽어들일 데이터를 출력.
		Iterator<String> itr=strs.iterator();
		while(itr.hasNext()) {
			String result=itr.next();
			System.out.println(result);
		}
		
		
		//example: 100만건.
		//Integer:32비트 데이터속에서 최적의 속도를 낸다.
		//nanoTime():cpu 특정시간을 사용하여 시간을 측정해준다.
		ArrayList<Integer> inAry=new ArrayList<Integer>();
		long start=System.nanoTime();
		for(int i=0;i<100000;i++) {
			inAry.add(0,i);
		}
		long end=System.nanoTime();
		System.out.println("ary :"+(end-start));
		
		LinkedList<Integer> lnAry=new LinkedList<Integer>();
		start=System.nanoTime();
		for(int i=0;i<100000;i++) {
			lnAry.add(0,i);
		}
		end=System.nanoTime();
		System.out.println("link :"+(end-start));
		
	}
}
