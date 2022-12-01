package day06;

import java.util.Arrays;
import java.util.Collections;

public class ArraySortEx01 {

	public static void main(String[] args) {
		// 버블 정렬을 이용한 배열 정렬
		// 배열 정렬에 따라서 프로그램의 속도가 달라진다. 
		// 
		int arr[] = {9, 8, 7, 6, 5, 4, 3, 1};
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length -1 -i; j++) {	// 일을 조금이라도 줄이기 위해 -i를 함.
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];	// 두 변수의 값을 바꾸기 위해 임시의 변수 tmp를 선언하여 하나의 값을 임시로 저장해둠.
					arr[j] = arr[j+1]; 
					arr[j+1] = tmp;
				}
			}
			for(int tmp : arr) {
				System.out.print(tmp + " ");
			}
			System.out.println();
		}
		
		System.out.println("-----------------------");
		int arr2[] = {9, 8, 7, 6, 5, 4, 3, 1};
		Arrays.sort(arr2);
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
		
		System.out.println();
		System.out.println("----------------------");
		Integer arr3[] = {9, 8, 7, 6, 5, 4, 3, 1};
		Arrays.sort(arr3, Collections.reverseOrder());
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
		
	}

}
