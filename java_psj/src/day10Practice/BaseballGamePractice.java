package day10Practice;

import java.util.Scanner;

public class BaseballGamePractice {

	public static void main(String[] args) {
		/* 숫자 야구게임 플레이 한 후 기록을 저장하는 프로그램
		 * 메
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 
		 * 기록확인 메뉴 선택 : 2
		 * 1. 홍길동 1회
		 * 2. 춘향이 2회
		 * 3. 바보온달 3회
		 * 4. 임꺽정 4회
		 * 5. 이몽룡 5회
		 * 
		 */
		
		// 메뉴 출력
			// 1. 최소 1회는 무조건 메뉴 출력은 되야 함 
		int menu;
		RecordPractice [] records = new RecordPractice[3];
		do {
			printMenu();
		// 메뉴 선택
			menu = selectMenu();
		
		// 선택한 메뉴에 따른 기능 실행
			//1. 플레이
				// 1-1. 컴퓨터가 랜덤으로 숫자 생성
			
				// 1-2. 사용자가 숫자 입력
		
				// 1-3. 판별
		
				// 1-4. 3S면 게임 종료
		
				// 1-5. 횟수 기록(최대 3등), 3등 기준으로 횟수가 동일한 경우 먼저 플레이한 유저의 기록을 유지해야 함.
		
			//2. 기록확인
				// 2-1. 등록된 3위까지의 기록 확인
		
			//. 종료
			runMenu(menu, records);
		} while(menu != 3);

	}
	
//===========================================================

	private static void runMenu(int menu, RecordPractice[] records) {
		switch(menu) {
		// 선택한 메뉴에 따른 기능 실행
		case 1:
			//1. 플레이
			// 1-1. 컴퓨터가 랜덤으로 숫자 생성
			int []com = randomMeth.createRandomArray(1, 9, 3);
			randomMeth.printArray(com);
			System.out.println();

			// 1-2. 사용자가 숫자 입력
	
			// 1-3. 판별
	
			// 1-4. 3S면 게임 종료
	
			// 1-5. 횟수 기록(최대 3등), 3등 기준으로 횟수가 동일한 경우 먼저 플레이한 유저의 기록을 유지해야 함.
			break;
		case 2:
			//2. 기록확인
			// 2-1. 등록된 3위까지의 기록 확인
	
		
			break;
		case 3:
			//. 종료
			System.out.println("프로그램을 종료합니다!");
			break;
		default:
			
		}
		
	}

	private static int selectMenu() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	private static void printMenu() {
		System.out.println("=================");
		System.out.println("=====메뉴 선택=====");
		System.out.println("1. 플레이");
		System.out.println("2. 기록확인");
		System.out.println("3. 종료");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
	}

}
