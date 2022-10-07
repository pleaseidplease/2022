package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Book{
	String bookCode;
	String author;
	String publish;
	
	//생성자 함수 this를 이용.
	public Book(String bookCode,String author,String publish) {
		this.bookCode=bookCode;
		this.author=author;
		this.publish=publish;
	}
	
	//Override: 상위에서 예를 들어 hashCode라는 기능이 있더라도 나만의 기능으로 쓰겠다는 의미.
	@Override
	public int hashCode() {
		return Objects.hash(author, bookCode, publish);
	}

	//instanceof : 상속을 받는다는게 true라면 실행하게 된다.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(bookCode, other.bookCode)
				&& Objects.equals(publish, other.publish);
	}
	
	
}

public class MapExample2 {
	public static void main(String[] args) {
		Map<Book,Integer> map=new HashMap<>();
		map.put(new Book("239208","홍길동","순수출판사"), 2000);
		map.put(new Book("wewew8","김민수","좋은출판사"), 3000);
		map.put(new Book("abcdef","홍성은","우리출판사"), 4000);
		
		Integer val=map.get(new Book("239208","홍길동","순수출판사"));
		System.out.println("값은 "+val);
	}
}
