package day06;

import java.util.Scanner;

public class ArrayRandomEx01 {

	public static void main(String[] args) {
		// 1.랜덤으로 1~9사이에 숫자를 3개 생성하여 배열에 저장하는 코드 작성
		
		// 랜덤숫자 생성위한 변수와 배열 선언
		int min = 1, max = 9;
		int size = 3;
		int ranArr[] = new int[size];
		
		for(int i = 0; i < ranArr.length; i++) {
			// 랜덤 숫자 
			int r = (int)(Math.random() * (max - min + 1) + min);
			ranArr[i] = r;
			System.out.print(ranArr[i] + " ");
		}
		
		System.out.println();
		
		// 강사님 풀이
		int min1 = 1, max1 = 9;
		int arr[] = new int[3];
		
		for(int i = 0; i < 3; i++) {
			arr[i] = (int)(Math.random() * (max1 - min1 + 1) + min1);
			System.out.print(arr[i] + " ");
			
		}
		
		System.out.println();
		
		// 2. 정수를 입력 받아 랜덤한 수에 있는지 없는지 확인해서 알려주는 코드를 작성하세요.
		// scanner 
		// 입력 받은 정수와 랜덤한 수와 비교
		Scanner scan = new Scanner(System.in);
		System.out.print("1~9 사이의 정수 1개 입력 : ");
		int num = scan.nextInt();
		
		for(int i = 0; i < arr.length; i++) {
			if(num == arr[i]) {
				System.out.println(num + "은 있습니다.");
			}else {
				System.out.println(num + "은 없습니다.");
			}
		}
		
		// 강사님 풀이
		// Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력 : ");
		int num1 = scan.nextInt();
		
		boolean isDuplicated = false; // 중복이 안 됨으로 초기화
		
		for(int i = 0; i < arr.length; i++) {
			// i번지에 있는 값과 num가 같으면 
			if(arr[i] == num1) {
				// 중복됐다고 저장함
				isDuplicated = true;
				break;
			}
		}
		// 중복 됐다면 있다고 출력 없다면 없습니다 출력
		if(isDuplicated) {
			System.out.println(num + "가 있습니다.");
		} else {
			System.out.println("없습니다.");
		}

		scan.close();
	}

}
