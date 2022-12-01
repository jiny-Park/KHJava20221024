package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortEx02 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("play");
		list.add("hello");
		list.add("banana");
		list.add("tomato");
		System.out.println(list);
		Collections.sort(list);	// 오름차순
		System.out.println(list);
		
		// Comparator 인터페이스를 구현한 구현 클래스가 필요
		Collections.sort(list, new Comparator<String>() {	// 내림 차순
															// 매개변수의 다형성을 이용한 것
			@Override
			public int compare(String o1, String o2) {
				return -o1.compareTo(o2);
			}
		});
		System.out.println(list);
		
		
		
	}

}


