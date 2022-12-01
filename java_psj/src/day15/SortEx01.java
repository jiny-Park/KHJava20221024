package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortEx01 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(50);
		list.add(33);
		list.add(4);
		list.add(-1);
		System.out.println(list);
		Collections.sort(list);	// 오름차순
		System.out.println(list);
		
		// Comparator 인터페이스를 구현한 구현 클래스가 필요
		Collections.sort(list, new Comparator<Integer>() {	// 내림 차순
															// 매개변수의 다형성을 이용한 것
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		System.out.println(list);
		
		
		
	}

}


