package day07;

import java.util.Scanner;

public class MethodArrayEx03 {

	public static void main(String[] args) {
		// 배열에 정수 num가 있는지 없는지 확인하는 코드를 작성
		// 메소드를 이용할 것
		
		int [] arr = {1, 3, 5, 7, 9};
		int num = 3;
		if(contians(arr, num)) {
			System.out.println(num + "는 배열에 있습니다.");
		} else {
			System.out.println(num + "는 배열에 없습니다.");
		}
		 
//		int min = 1, max = 9;
//		int arr2[] = createRandomArray(min, max, 4);
//		printArray(arr2);
//		
//		System.out.println();
//		Scanner scan = new Scanner(System.in);
//		System.out.print("정수 하나를 입력하여 배열에 같은 값이 있는지 확인 : ");
//		int num = scan.nextInt();
		
		
				

	}
	// 서진풀이.
	/* 기능 : num을 입력했을 때, 배열의 정수중에 같은 값이 있는지 판별
	 * 매개변수 : 최소값, 최대값, 배열 => int min, int max, int arr[]
	 * 리턴타입 : 입력한 num의 값이 배열에 있다면 true, 없다면 false => boolean
	 * 메소드명 : numCheck
	 */
	public static int [] createRandomArray(int min, int max, int size) {
		int arr[] = new int[size];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random(min, max);
		}
		return arr;
	}
	
	public static void printArray(int arr[]) {
		for(int i= 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
		
	public static int random(int min, int max) {
		return (int)(Math.random()*(max - min + 1) + min);
	}
	
	// 강사님 풀이 1.
	/* 기능 : 배열에 정수 num가 있는지 없는지 알려주는 메소드
	 * 매개변수 : 배열, 정수 => int [] arr, int num
	 * 리턴타입 : 있는지 없는지 => boolean
	 * 메소드명 : contains
	 */
	public static boolean contians(int []arr, int num) {
		for(int tmp : arr) {
			if(num == tmp) {
				return true;
			}
		}
		return false;
	}
	
}
