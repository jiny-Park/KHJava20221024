package day09;

import java.util.Scanner;

import day08.MethodBaseballGameEx01Teacher;

public class BaseballManager {

	public static void main(String[] args) {
		/* 숫자 야구게임을 플레이 한 후, 기록을 저장하는 프로그램을 작성
		 * 메뉴 : 
		 *  1. 플레이
		 *  2. 기록확인
		 *  3. 종료
		 *  
		 *  기록환인 메뉴선택 : 2
		 *  1. 홍길동 2회
		 *  2. 임꺽정 3회
		 *  3. 이몽룡 3회
		 *  4. 춘향이 4회 
		 */
		
		
		
		int menu;
		int count = 0;
		
		do {
		//메뉴 출력
			//1. 최소 1회는 무조건 메뉴 출력은 되야 함.
			printMenu();
		//메뉴 선택
			menu = selectMenu();
		
		//선택한 메뉴에 따른 기능 실행
			count = runMenu(menu, count);
			//1. 플레이
				//1-1. 컴퓨터가 랜덤으로 숫자 생성
		
				//1-2. 사용자가 숫자 입력
		
				//1-3. 판별
		
				//1-4. 3S면 종료
		
				//1-5. [new] 횟수를 기록(최대 5등), 5등 기준으로 횟수가 동일한 경우 먼저 플레이한 사람의 기록을 유지해야함.
		
		
			//2. 기록확인
				//2-1. 등록된 5위까지의 기록을 확인
				
				//2-2. 
		
		
			//3. 종료
		}while(menu != 3);
	}
	
	/**
	 *  메뉴를 출력하는 메소드, 
	 *  리턴타입 : 없음 -> void
	 */
	public static void printMenu() {
		System.out.println("*******메뉴*******");
		System.out.println("1. 플레이 Game Go!");
		System.out.println("2. 기록 확인");
		System.out.println("3. Game 종료");
		System.out.println("*****************");
		System.out.println("메뉴 선택 : ");
	}
	
	/**
	 *  메뉴를 콘솔에서 입력받은 정수(메뉴)를 알려주는 메소드
	 *  @return 입력받은 정수(메뉴)
	 */
	public static int selectMenu() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
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
	                                
	/**
	 * 메뉴에 맞는 기능을 실행하는 메소드
	 * @param menu 선택한 메뉴
	 * @param Game 플레이와 기록 정보가 들어 있음
	 * @return 저장된 기록과 기록확인
	 */
	public static int runMenu(int menu, int count) {
		
		Scanner scan = new Scanner(System.in);
		
		switch(menu) {
		//선택한 메뉴에 따른 기능 실행
		case 1:
		//1. 플레이
			//1-1. 컴퓨터가 랜덤으로 숫자 생성
			int min = 1, max = 9, size = 3;
			int []com = createRandomArray(min, max, size);
			printArray(com);
			System.out.println();
			// 2.사용자가 숫자를 선택
		
			
			// 3.판별
			int strike =0, ball;
			do {
				System.out.print("입력 : ");
				int []user = scanArray(scan, size);
				

			// => 스트라이크를 판별하는 기능 구현
			// => countLotto를 이용하여 일치하는 개수 - 스트라이크 개수
			// => countLotto를 이용하여 일치하는 개수 - 스트라이크 개수 = 볼의 개수가 됨.
				strike = getStrike(com, user);
				ball = getBall(com, user);
				System.out.println(strike + "," + ball);	// 테스트
				
				printGame(strike, ball);
			// 2~3을 반복(3S가 될때까지)
			}while(strike < 3 );
			System.out.println("게임 종료");
			scan.close();
	
			//1-2. 사용자가 숫자 입력
	
			//1-3. 판별
	
			//1-4. 3S면 종료
	
			//1-5. [new] 횟수를 기록(최대 5등), 5등 기준으로 횟수가 동일한 경우 먼저 플레이한 사람의 기록을 유지해야함.
			break;
		case 2:
		//2. 기록확인
			//2-1. 등록된 5위까지의 기록을 확인
			
			
			//2-2. 
			break;
		case 3:
		//3. 종료
			System.out.println("프로그램을 종료합니다!");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		return count;
	}
}
