package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
			//key:Integer, val:String
			//key값은 중복될 수 없다. 동일한 value가 들어오면 기존의 value를 삭제시킨다.
			Map<Integer,String> map=new HashMap<Integer,String>();	
			map.put(100, "홍길동");
			map.put(200, "김가영");
			map.put(300, "박문식");
			map.put(300, "윤문식");
			
			//제거
			map.remove(300);
			
			System.out.println("Map 컬렉션 size: "+map.size());
			System.out.println("300key의 Value: "+map.get(300));
			
			//반복자 생성.
			Set<Integer> keySet=map.keySet();//key 값만 새로운 Set컬랙션에 저장.
			for(Integer key:keySet) {
				System.out.println("키: "+key+", 값: "+map.get(key));
			}
			
			//Set<Entry<key,value>> : Map의 key와 value 둘다 가져올때 사용.
			Set<Entry<Integer,String>> entSet=map.entrySet();
			for(Entry<Integer,String> ent:entSet) {
				System.out.println("키: "+ent.getKey()+" value의 값은 "+ent.getValue());
			}
	}
}
