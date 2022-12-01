package day25;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {
	
	/* 정수를 5번 입력하여, 배열(또는 리스트)에 저장하는 코드를 작성
	 * 정수가 홀수이면 그대로 저장, 정수가 짝수이면 -를 붙여서 저장
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int size = 5;
		// 배열 이용
		// 배열 생성
		//int [] arr = new int[size];
		
		// 리스트 이용
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// 1. 정수 입력 안내문
		// 2. 정수 5번 입력
		for(int i = 0; i < size; i++) {
			System.out.print("정수 입력 : ");
			int num = scan.nextInt();
			// 3. 정수가 홀수이면 그대로 저장
			if(num % 2 != 0) {	// 음수도 홀짝을 구분하려면 != 으로 처리해야 함.
				//arr[i] = num;
				list.add(num);
			// 4. 정수가 짝수이면 -를 붙여서 저장
			} else {
				//arr[i] = -num;
				list.add(-num);
			}
		}
		
//		for(int num : arr) {
//			System.out.println(num + " ");
//		}
		for(int num : list) {
			System.out.println(num + " ");
		}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
