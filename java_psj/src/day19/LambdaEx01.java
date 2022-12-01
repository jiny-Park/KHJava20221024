package day19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import example.accountbook.Item;

public class LambdaEx01 {

	public static void main(String[] args) {
		/* 람다식을 쓰는 이유
		 * - 코드가 간결해짐(아래 예제 참고)
		 * - 콜렉션에서 필터링이 쉬워짐
		 * 
		 * 람다식은 언제 사용?
		 * - 함수적 인터페이스에 객체가 필요한 경우
		 * 
		 * 함수적 인터페이스란?
		 * - 인터페이스의 추상 메소드가 1개인 인터페이스
		 */

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(777);
		list.add(456);
		list.add(300);
		list.add(-10);
		list.add(2);
		System.out.println(list);
		Collections.sort(list, (a, b) -> a-b); 
//		Collections.sort(list, new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				
//				return o1-o2;
//			}	
//		});
		
		System.out.println(list);
			
			
		
	}

}


