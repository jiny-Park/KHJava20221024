package day10;

import java.awt.Container;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class day10homeWork {

	public static void main(String[] args) {
		// 사용자와 컴퓨터가 1부터 시작하여 돌아가면서 연속된 숫자를 부른다. 한 번에 최대 3개까지 부를수 있으며, 31을 부르는 사람이 지는 게임. 
		// 기록은 사용자가 몇번 이기고, 컴퓨터가 몇번 이기는지 기록한다.
		/* 1. 플레이
		 * 		// 컴퓨터가 랜덤 1~3개의 숫자를 부름
		 * 		// 사용자가 몇개의 숫자를 부를지 입력
		 * 2. 기록확인
		 * 3. 종료
		 * 
		 * 예시
		 * 1 2 3 [컴퓨터]
		 * > 2 [사용자 입력]
		 * 4 5 [사용자 입력에 따른 결과]
		 * > 6 [컴퓨터]
		 * > 3 [사용자 입력]
		 * > 7 8 9 [사용자 입력에 따른 결과]
		 * 
		 */
		
		
		int menu;
		Record [] records = new Record[5];
		do {
		// 메뉴 출력
			printMenu();

		// 메뉴 선택
			menu = insertInt();
		// 선택에 따른 메뉴 플레이
			// 1. 플레이
				// 1-1. 컴퓨터가 1, 2, 3개의 수 중에서 입력할 숫자를 하나 뽑는다.
		
				// 1-2. 컴퓨터가 뽑은 입력할 개수에 따라 숫자를 넣는다.(1~31까지 순차적으로)
		
				// 1-3. 사용자가 1, 2, 3 중에서 몇 번 입력할 것인지 선택한다.
		
				// 1-4. 사용자가 입력한 갯수 만큼 숫자를 넣는다.
		
				// 1-5. count를 통해 31을 먼저 외친 사람이 패비
				
				// 1-6. 컴퓨터 승리는 몇 번, 유저 승리 몇 번 인지 기
		
			// 2. 기록확인 
				// 2-1. 기록된 순위를 출력
		
			// 3. 종료
			runMenu(menu, records);
		} while(menu != 3);

	}
	
//=============================================================
	
	/**
	 * 주어진 기록 정보에 따라 메뉴의 기능을 실행하는 메소
	 * @param menu 선택한 메뉴
	 * @param records 기록 정보들
	 */
	private static void runMenu(int menu, Record[] records) {
		switch(menu) {
		case 1:
			// 1. 플레이
//			do {
//			// 1-1. 컴퓨터가 1, 2, 3개의 수 중에서 입력할 숫자를 하나 뽑는다.
//			// 1-2. 컴퓨터가 뽑은 입력할 개수에 따라 숫자를 넣는다.(1~31까지 순차적으로)
//				
//				
//			// 1-3. 사용자가 1, 2, 3 중에서 몇 번 입력할 것인지 선택한다.
//	
//			// 1-4. 사용자가 입력한 갯수 만큼 숫자를 넣는다.
//			
//			// 1-5. count를 통해 31을 먼저 외친 사람이 패비
//			
//			// 1-6. 컴퓨터 승리는 몇 번, 유저 승리 몇 번 인지 기
//	
//			}while(Count == 31);
			break;
			
		case 2:
			// 2. 기록확인 
			// 2-1. 기록된 순위를 출력
			break;
			
		case 3:
			// 3. 종료
			System.out.println("Shutdown! Good bye!");
			break;
		
		default:
			System.out.println("잘 못 입력했습니다!");
		}
		
	}
	
	

	/**
	 * 콘솔에서 정수를 입력받아 입력받은 정수를 알려주는 메소
	 * @return 입력 받은 정수, menu
	 */
	private static int insertInt() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	/**
	 * 고정된 메뉴를 출력하는 메소
	 */

	private static void printMenu() {
		System.out.println("-*-*-*-*-*-*-");
		System.out.println("1. 플레이");
		System.out.println("2. 기록확인");
		System.out.println("3. 종료");
		System.out.println("-*-*-*-*-*-*-");
		System.out.print("메뉴 선택 : ");
	}

	
}
