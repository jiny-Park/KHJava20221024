package day08;

import java.util.Arrays;
import java.util.Scanner;

public class MethodLottoEx01 {

	public static void main(String[] args) {
		//

		int min = 1, max = 45;
		int size = 6;
		// 로또 번호 생성
		int [] lotto = createRandomArray(min, max, size);
		// 로또 번호 정렬
		Arrays.sort(lotto);
		// 로또 번호 출력
		System.out.print("로또 번호 : " );
		printArray(lotto);
		
//		int bonus = 0;
//		while(true) {
//			int r = (int)(Math.random() * (max - min + 1) + 1);
//			boolean isDuplicated = false;
//			for(int i = 0; i < lotto.length; i++) {
//				if(lotto[i] == r) {
//					isDuplicated = true;
//				}
//			}
//			if(isDuplicated) {
//				continue;
//			}
//			bonus = r;
//			break;
//		}
//		System.out.println();
//		System.out.println("보너스 번호 : " + bonus);
//		
		
		// 보너스 번호 강사님 풀이
		int bonus;
		do {
			bonus = random(min, max);
		}while(contains(lotto, bonus));
		System.out.println();
		System.out.println("보너스 번호 : " + bonus);
		
		// 로또 번호 입력
		int []user = new int[size];
		System.out.print("입력 번호 : ");
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < user.length; i++) {
			user[i] = scan.nextInt();
		}
		scan.close();
		
		System.out.println("맞춘 개수 : " + countLotto(lotto, user));
		
		int rank = getRank(lotto, bonus, user);
		printRank(rank);
		

	}
	/* 기능 : 주어진 두 배열에서 일치하는 숫자의 갯수를 알려주는 메소드
	 * 매개변수 : int 배열, int 배열 
	 * 리턴타입 : 몇 개나 같은지 => 정수 return
	 * 메소드명 : countLotto
	 */
//	public static int countLotto(int []lotto, int []user) {
//		int countLotto = 0;
//		for(int i = 0; i < lotto.length; i++) {
//			if(contians(lotto, user)) {
//				countLotto++;	
//			}
//		}
////		for(int i = 0; i < arr1.length; i++) {
////			for(int j = 0; j < user.length; j++) {
////				if(arr1[i] == user[j]) {
////					countLotto++;
////				}
////			}
////		}
//		return countLotto;
//	}
	
	// 강사님 풀이 
	/*	기능 : 주어진 두 배열에서 일치하는 숫자의 갯수를 알려주는 메소드
	 * 매개변수 : 두 배열 => int []arr1, int []arr2
	 * 리턴타입 : 일치하는 숫자의 개수 => 정수 => int
	 * 메소드명 : countLotto
	 */
	public static int countLotto(int []arr1, int []arr2) {
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
	
	// 기능 : 당첨 등수를 알려주는 코드를 작성, 단 메소드를 이용
	/* 매개변수 : 맞춘 개수를 저장할 변수
	 * 리턴타입 : 등수를 알려줄 정수 => int
	 * 메소드명 : winning
	 */
//	public static int winning(int num) {
//		int count = num;
//	}
	
	// 강사님 풀이 1.
	/* 기능 : 로또 번호(보너스 번호 포함)와 입력번호가 주어지면 등수를 알려주는 메소드
	 * 매개변수 : 로또번호, 입력번호 => int []lotton, int bonus, int[]user
	 * 리턴타입 : 등수 => 정수 => int
	 * 메소드명 : getRank
	 */
	public static int getRank(int []lotto, int bonus, int[]user) {
		int count = countLotto(lotto, user);
		switch(count) {
		case 6: 	return 1;
		case 5: 	return contains(user, bonus)? 2 : 3;
		case 4: 	return 4;
		case 3:		return 5;
		default:	return -1;
		}
	}	
	// 강사님 풀이 2.	// 좋은 메소드는 하나의 기능만 가지고 있는 것이 좋다.
	/* 기능 : 등수가 주어지면 등수를 콘솔에 출력하는 메소드
	 * 매개변수 : 등수 => 정수 => int rank
	 * 리턴타입 : 없음 => void 
	 * 메소드명 : printRank
	 */
	public static void printRank(int rank) { 
		switch(rank) {
		case 1:		System.out.println("1등"); break;
		case 2:		System.out.println("2등"); break;
		case 3:		System.out.println("3등"); break;
		case 4:		System.out.println("4등"); break;
		case 5:		System.out.println("5등"); break;
		default:	System.out.println("꽝");  break;
		}
	}

	public static void printArray(int arr[]) { 	// 배열 출력 함수
		if(arr == null) {	// 참조변수는 배열에 값이 저장되어 있지 않다면 null(값이 없음)으로 나오기 때문에 예외 처리함.
			return;
		}
		for(int i= 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static int random(int min, int max) {			// 랜덤수를 뽑는 함수
		if(min > max) {			// 예외처리 : 입력할 때 잘못된 값으로 입력했을 때를 보완하기 위해 예외처리함.
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max - min + 1) + min);
	}	
	
	public static int [] createRandomArray(int min, int max, int size) {	// 랜덤수를 뽑아서 배열에 저장하는 함수
		if(max - min + 1 <= size) {	// 예외처리 : 입력된 값이랑 배열의 사이즈가 서로 다를 때 (예) 입력된 값은 1~3인데 배열 사이즈가 4일 경우
			return null;
		}
		int arr[] = new int[size];
		// i는 0부터 i가 배열의 크기보다 작을 때까지 1씩 증가
		// => i는 0부터 i가 배열의 크기보다 작을 때까지
		for(int i = 0; i < arr.length; ) {
			// 랜덤한 수를 배열 i번지에 저장
			// =>랜덤한 수를 r에 저장
			int r = random(min, max);
			// 배열에 r이 없으면 [배열 i번지에 r을 저장한 후, i를 1증가]
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
	
	// 기능 : 보너스 번호
	
	
	
	
	
	
	
	
	
	
}
