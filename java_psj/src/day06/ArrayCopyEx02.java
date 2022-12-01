package day06;

import java.util.Arrays;

public class ArrayCopyEx02 {

	public static void main(String[] args) {

		int arr1[] = new int[] {1, 2, 3};
		int arr2[];
		
		
		// 깊은 복사 예제1
		// 예베3을 코드로 풀어쓰면 예제1과 같이 가능
		int tmpArr[] = new int[arr1.length];
		for(int i = 0; i < arr1.length; i++) {
			tmpArr[i] = arr1[i];
		}
		arr2 = tmpArr;
	
//		// 깊은 복사 예제2
//		arr2 = new int[arr1.length];
//		System.arraycopy(arr1, 0, arr2, 0, arr1.length);

		// 깊은 복사 예제3
//		arr2 = Arrays.copyOf(arr1, arr1.length);
		
		// arr1, arr2 값 확인
		for(int i = 0; i < arr1.length; i++) {
			System.out.println("arr1["+i+"] = "  + arr1[i] + ", arr2[" + i +"] = " + arr2[i]);		
		}
		
		arr1[0] = 10; // arr1의 값만 10으로 변경
				 	  // 깊은 복사는 서로 다은 객체를 생성하여 관리하기 때문에, arr2의 값은 변하지 않는다.
		//arr1과 arr2의 값 확인, arr1과 arr2의 값이 모두 10으로 출력됨 확인
		for(int i = 0; i < arr1.length; i++) {
			System.out.println("arr1["+i+"] = "  + arr1[i] + ", arr2[" + i +"] = " + arr2[i]);		
		}

	}

}
