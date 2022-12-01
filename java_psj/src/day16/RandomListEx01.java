package day16;

import java.util.ArrayList;
import java.util.HashSet;

public class RandomListEx01 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int maxCount = 3, min = 1, max = 45;
		
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size() < maxCount) {
			int r = (int)(Math.random() * (max - min +1) + min);
			set.add(r);	//set의 특이점 10이하의 숫자로 하면 자체 정렬이 됨.
		}
		list.addAll(set);
		System.out.println(list);
		
		

	}

}
