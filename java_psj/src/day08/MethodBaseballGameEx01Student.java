package day08;

import java.util.Scanner;

public class MethodBaseballGameEx01Student {

	public static void main(String[] args) {
		/* 1~9 사이의 중복되지 않은 3개의 숫자가 랜덤으로 생성이 되고, 생성된 숫자를 맞추는 게임
		 * 규칙 : 
		 * 		- 숫자가 같은 자리에 있으면 Strike
		 * 		- 숫자가 있지만 다른 자리에 있으면 Ball
		 * 		- 일치하는 숫자가 하나도 없으면 Out
		 * 예시(랜덤 숫자 : 5 9 8)
		 * 입력 : 1 2 3
		 * Out
		 * 입력 : 4 5 6
		 * 1B
		 * 입력 : 7 8 9
		 * 2B
		 * 입력 : 7 9 8
		 * 2S
		 * 입력 : 7 9 5
		 * 1S1B
		 * 입력 : 5 9 8
		 * 3S
		 * 게임 종료
		 */
		
/* 랜덤값이 3개가 중복이 되지 않게 출력이 되야함. 
 * 출력된 랜덤값이 배열에 저장이 되야함. 
 * 콘솔에 입력값 3개가 있어야 함.
 * 콘솔에 입력한 값이 배열에 저장이 되야함.
 * 랜덤값이랑 콘솔에 입력한 값을 비교해야함.
 * 비교시 같은 숫자인지 그리고 같은 자리에 있는지까지 비교해야함.
 * [0] == [0] -> Strike, [0] == [1] -> Ball, [0] == [2] -> Ball,   [0] != [0], [1], [2] -> Out
 * [1] == [0] -> Ball,   [1] == [1] -> Strike, [1] == [2] -> Ball, [1] != [0], [1], [2] -> Out
 * [2] == [0] -> Ball,   [2] == [1] -> Ball, [2] == [2] -> Strike, [2] != [0], [1], [2] -> Out
 * 
 * 숫자가 같은 자리에 있으면 Strike
 * 숫자가 있지만 다른 자리에 있으면 Ball
 * 일치하는 숫자가 하나도 없으면 Out
 */
		int min = 1, max = 9, size = 3;
		int arr[] = new int[size];
		printArray(createRandomArray(min, max, size));
		System.out.println();
			
		int []user = new int[size];
		System.out.print("정수 입력(예) 1 2 3) : ");
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < user.length; i++) {
			user[i] = scan.nextInt();
		}
		// 랜덤수와 콘솔에 입력한 수 배열에 저장까지 완료
		
		
	
		
	}
//	
//	public static int count(int []arr1, int []user) {
//		if(arr1 == null || user == null) {
//			return 0;
//			int count = 0;
//			for(int tmp : arr1) {
//				if(contains(user, tmp)) {
//					count++;
//				}
//			}
//			return count;
//		}
//	}
//	

	public static void printArray(int arr[]) { 
		if(arr == null) {	
			return;
		}
		for(int i= 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			max = min;
			min = tmp;
		}
		return (int)(Math.random() * (max - min + 1) + 1);
	}
	
	public static int [] createRandomArray(int min, int max, int size) {	
		if(max - min + 1 <= size) {	
			return null;
		}
		int arr[] = new int[size];
		for(int i = 0; i < arr.length; ) {
			int r = random(min, max);
			if(!contains(arr, r)) {		
				arr[i] = r;		
				i++;			
			}
		}
		return arr;
	}

	public static boolean contains(int []arr, int num) {	
		if(arr == null || arr.length == 0) {	
			return false;
		}
		for(int tmp : arr) {
			if(num == tmp) {
				return true;
			}
		}
		return false;
	}
	
}
		