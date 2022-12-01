package day10;

import java.util.Scanner;

// 상황에 맞게끔 코드를 작성!
// 기능하나 구현하고 테스트하고 기능 구현하고 테스트하는 습관을 들이자!
public class UpDownGameManagerTeacher {

	public static void main(String[] args) {
		// UpDown 게임 코드 작성
		// 1. 플레이
		// 2. 기록확인
		// 3. 종료
		
		//반복
		int menu;
		Record [] records = new Record[5];
		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			menu = insertInt();
			// 메뉴에 따른 기능 실행 : 선택한 메뉴, 기록정보(->밖에서 넘겨줘야 기록정보가 초기화가 되지 않는다)
				// 1.플레이
					// 랜덤수 생성	
					
					// 반복
						// 사용자 입력
			
						// UpDown 판별
		
					// 기존 기록보다 좋으면 기록을 추가
		
				// 2.기록확인
					// 기록된 순위를 출력
		
				// 3.종료
			runMenu(menu, records);
		}while(menu != 3);//종료 조건이 아니라 실행조건임.
	}
	
//------------------------------------------------------------------------------------------------
	
	/**
	 * 고정된 메뉴를 출력하는 메소드 (예)고정된 메뉴 : 일을 시킨사람이 일을 시킨대로 일하는 사람이 일을 하지 않는다. 
	 */
	// static 메인에서 사용하기 위해선 메소드에서도 static을 붙여줘야 main에서도 사용을 할 수 있다. 그렇지 않으면 객체를 생성하여 사용을 해야되는 두번의 일을 하게 된다.
	public static void printMenu() {
		System.out.println("-*-*-*-*-*-*-");
		System.out.println("1. 플레이");
		System.out.println("2. 기록확인");
		System.out.println("3. 종료");
		System.out.println("-*-*-*-*-*-*-");
		System.out.print("메뉴 선택 : ");
	}
	
	/**
	 * 콘솔에서 정수를 입력받아 입력받은 정수를 알려주는 메소드
	 * @return 입력 받은 정수, 메뉴
	 */
	public static int insertInt() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	/**
	 * 주어진 기록 정보를 인용하여 메뉴에 따른 기능을 실행하는 메소드.
	 * @param records 기록 정보들
	 * @param menu 선택한 메뉴
	 */
	public static void runMenu(int menu, Record[] records) {
		switch(menu) {
		case 1: 
//			System.out.println("업다운 게임 구현해야 합니다!");	-> 기능 구현전에 미리 설계를 어떻게 해야할 것인지 써놓은 것(예)설계도). 그리고 기능이 구현이 되는지 테스트 확인!
			// 1.플레이
			int tryCount = playGame(); // -> 플레이를 하고 나면 몇번만에 맞췄는지 알아야 함.(랜덤수 생성부터 updown판별까지 하나의 메소드로 생성)
			// 랜덤수 생성	
			// 반복
				// 사용자 입력
				// UpDown 판별

			// 기존 기록보다 좋으면 기록을 추가
			writeRecord(records, tryCount);
			break;
		
		case 2:
			// 2.기록확인
			// 기록된 순위를 출력
//			System.out.println("기록확인 기능 구현해야합니다!");
			printRecords(records);
			break;
			
		case 3:
			// 3.종료
			System.out.println("프로그램 종료!");
			break;
		
		default:
			System.out.println("잘못된 메뉴입니다!");
		
		}
	}

	public static int random(int min, int max) {
		return(int)(Math.random()*(max - min + 1) + min);
	}

	public static int playGame() {
		// 랜덤수 생성	
		int num = random(1, 100);
		System.out.println(num);	// 랜덤수 테스트 확인용
		int tryCount = 0;
		int user;
			// 반복
		do {
				// 사용자 입력
			System.out.print("정수 입력 : ");
			user = insertInt();

				// UpDown 판별
			if(user > num) {
				System.out.println("DOWN");
			} else if(user < num) {
				System.out.println("UP");
			} else {
				System.out.println("정답!");
			}
			tryCount++;
		}while(num != user);	// num과 user가 같지 않으면 코드 반복
		return tryCount;
	}
	
	/**
	 * 기록 정보보다 사용자 기록이 좋으면 사용자 기록을 추가하는 메소드
	 * @param 기록 정보 records
	 * @param 사용자 기록 tryCount
	 */
	private static void writeRecord(Record[] records, int tryCount) {
		int index = 0;	// 기록을 몇번지에 넣을건지 확인
		for(int i = 0; i < records.length; i++) {
			//1등부터 비교하여 나보다 기록이 좋으면 내 순위가 밀림
			if(records[i] != null && tryCount > records[i].getCount()) {	// 값이 없으면 참이 되어 아래 실행문 실행
				index++;
			//기록이 없는 처음 순위를 내 기록으로 하기위해 i를 index에 저장하고 반복문 종료
			}else if(records == null){	// 값이 없는 경우가 index의 i번째에 저장하는 경우가 됨.
				index = i;
				break;
			//비교 순위보다 내가 기록이 좋으면 반복문 종료
			}else {
				index = i;
				break;
			}
		}
		// 순위 안에 못들으면
		if(index == 5) {
			return;
		}
		System.arraycopy(records, index, records, index+1, records.length - index -1);
		System.out.print("이름 입력(예: ABC) : ");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		records[index] = new Record(tryCount, name);
	}
	
	private static void printRecords(Record[] records) {
		for(int i = 0; i < records.length; i++) {
			System.out.println(i+1 + "위 ");
			if(records[i] != null) {
			records[i].print();
			}else {
				System.out.println();
			}
				
		}
		
	}
	

}
