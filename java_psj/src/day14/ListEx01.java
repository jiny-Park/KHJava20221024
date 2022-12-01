package day14;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx01 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(0,10);
		list.remove(1);
		list.remove((Integer)10);	// 10이라는 숫자를 지워주세요. (Integer)를 쓰지 않으면 10번지를 애기하게 됨.
		
		
		System.out.println(list);
		System.out.println("1이 있나요? " + list.contains(1));
		System.out.println("1이 어디에 있나요? " + list.indexOf(1) + "번지");
		System.out.println("1번지에 있는 값: " + list.get(1));

		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		for(Integer tmp : list) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		Iterator<Integer> it = list.iterator();	// map에서는 for문으로 사용할 수 없기 때문에, map에서 사용할 수 밖에 없는 코드로 이해하면 좋다.
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		
		
	}

}
