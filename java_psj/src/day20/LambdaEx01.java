package day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaEx01 {

	public static void main(String[] args) {
		/* 람다식을 이용하여 생성된 것은?
		 * - 객체
		 * 인터페이스를 이용하여 객체를 만들 때 구현 클래스나 익명 클래스가 필요
		 * => 익명 클래스나 구현 클래스 없이 바로 객체를 생성할 수 있게 하는 것이 "람다식"이다.
		 */
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(-1);
		list.add(8);
		list.add(56);
		list.add(3);
		list.add(66);
		list.add(2);
		System.out.println(list);
		
		Comparator<Integer> comparator = (a,b) -> a-b;
		//Comparator 
		// (a,b) -> a-b; -> 객채를 만든 것
		
		Collections.sort(list, comparator);
		System.out.println(list);
		System.out.println(comparator.compare(1, 2));
		
		// 한 번 더 강의를 듣고 이해할 필요가 있음.
		
		
	}

}
