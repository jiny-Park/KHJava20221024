package day09;

import java.util.Scanner;

public class ClassBaseballGame {
	/**
	 * 기능 : strike와 ball의 개수가 주어지면 콘솔에 결과를 출력하는 메소드
	 * @param strike 스트라이크 개수
	 * @param ball 볼의 개수
	 */
	public static void printGame(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + "S ");
		}
		if(ball != 0) {
			System.out.print(ball + "B ");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("OUT");
		}
		System.out.println();
	}
	
	/** 
	 * 기능 : 두 배열이 주어지면 같은 번지에 이는 수를 비교하여 일치하는 숫자들이 몇개 있는지 알려주는 메소드
	 * @param arr1 int[] : 첫번째 정수 배열
	 * @param arr2 int[] : 두번째 정수 배열
	 * @return 같은 번지에서 일치하는 숫자들의 개수
	 */
	public static int getStrike(int []arr1, int arr2[]) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int strike = 0;
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		for(int i = 0; i < size; i++) {
			if(arr1[i] == arr2[i]) {
				strike++;
			}
		}
		return strike;
	}
	
	/**
	 * 기능 : 두 정수 배열이 주어지면 같은 숫자들 중에서 번지가 서로 다른 숫자들의 개수를 알려주는 메소드
	 * @param arr1 int[] : 첫번째 정수 배열
	 * @param arr2 int[] : 두번째 정수 배열
	 * @return 같은 숫자들 중에서 번지가 서로 다른 숫자들의 개수
	 */
	public static int getBall(int []arr1, int []arr2) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int ball = 0;
		int strike = getStrike(arr1, arr2);
		for(int num : arr1) {
			if(contains(arr2, num)) {
				ball++;
			}
		}
		return ball - strike;
	}
	
	/** 
	 * 기능 : Scanner가 주어지면 정수를 size개만큼 입력받아 배열에 저장하고 		-> 메소드 주석 처리할 때 파란색 주석을 이용하면 용이함.
	 * 		저장된 배열을 돌려주는 메소드
	 * 매개변수 : Scanner, size개 => Scanner scan, int size
	 * 리턴타입 : 정수 배열 => int []
	 * 메소드명 : scanArray
	 *  @param scan Scanner
	 *  @param size 입력받을 정수의 개수
	 *  @return 입력받은 값들이 저장된 배열
	 * */
	public static int[] scanArray(Scanner scan, int size) {
		if(size <= 0) {
			return null;
		}
		int [] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		return arr;
	}
	
	
	public static int countArray(int []arr1, int []arr2) {
		if(arr1 == null || arr2 == null) {	// 예외 처리
			return 0;
		}
		int count = 0;
		for(int tmp : arr1) {
			if(contains(arr2, tmp)) {
				count++;
			}
		}
		return count;
	}
	
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
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max - min + 1) + min);
	}	
	
	public static int [] createRandomArray(int min, int max, int size) {	
		if(max - min + 1 <= size) {	
			return null;
		}
		int arr[] = new int[size];
		for(int i = 0; i < arr.length; ) {
			int r = random(min, max);
			if(!contains(arr, r)) {		// 배열에  r이 있지 않다
				arr[i] = r;		// 배열 i번지에 r을 저장;
				i++;			// i를 1증가
			}
		}
		return arr;
	}

	public static boolean contains(int []arr, int num) {	// 배열에 있는 값이 입력한 값이 같은지 확인하는 함수
		if(arr == null || arr.length == 0) {	// 예외처리
			return false;
		}
		for(int tmp : arr) {
			if(num == tmp) {
				return true;
			}
		}
		return false;
	}

	

	
	
	public static void main(String[] args) {
		
	} 
}