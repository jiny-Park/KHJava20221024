package day25;

import java.util.ArrayList;
import java.util.Random;

public class Ex03 {

	/* 1에서 9사이의 숫자를 랜덤하게 9번 뽑아서 일렬로 출력하는 코드를 작성하세요.
	 * 
	 */
	
	public static void main(String[] args) {
		
//		int min = 1, max = 9;
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		
//		for(int i = 0; i < 9; i++) {
//			int randomNumber = (int)(Math.random() * (max - min + 1) + min);
//			list.add(randomNumber);		
//		}
//
//		Collections.sort(list);
//		
//		System.out.print(list);
		
		// 강사님의 방법
		ArrayList<Integer> list = new ArrayList<Integer>();	
		ArrayList<Integer> res = new ArrayList<Integer>();	// list의 값을 하나씩 빼서 res에 담을 예정
		
		int min = 1, max = 9;
		
		for(int i = min; i <= max; i++) {
			list.add(i); // 1, 2, 3, 4, 5, 6, 7, 8, 9가 순차적으로 저장됨
		}
		System.out.println(list);
		while(list.size() != 0) {
			int r = random(0, list.size()-1);
			Integer num = list.remove(r);
			res.add(num);
			System.out.println(res);
		}
		System.out.println(res);
		
		System.out.println(list);

	}
	//▼▼▼▼▼▼▼ M e t h o d ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	public static int random(int min, int max) {
		if(max < min) {
			int tmp = min;
			min = max;
			max = min;
		}
		Random r = new Random();
		// nextInt(정수) : 0이상 정수미만의 랜덤한 정수를 알려줌
		return r.nextInt(max - min + 1) + min;
	}

}
