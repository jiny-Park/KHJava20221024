package day10;

import java.util.Scanner;

import day08.MethodBaseballGameEx01Teacher;

public class UpDownGameManager {

	public static void main(String[] args) {
		// UpDown 게임을 구현하세요.
		int menu;  
		Record [] records = new Record[3];
		do {
			// *최소 한 번은 진행이 되야함.
			// 		0-0. 메뉴 출력
			printMenu();
		// 		0-1. 메뉴 선택 -> 선택한 메뉴로 이동하여 진행
			menu = selectMenu();
		//	1. 플레이
		// 		1-1. 컴퓨터에서 랜덤수 1개를 뽑아줌	-> 랜던수 클래스 만들었던 패키지에서 불러와서 출력.
			
		// 			- 테스트용 랜덤수를 확인할 수 있는 출력이 필요
		// 		1-2. 유저가 콘솔에 직접 정수 숫자 입력
		// 			- 랜덤수 < 유저수 => Down
		// 			- 랜덤수 > 유저수 => Up
		// 			- 랜덤수 = 유저수 => "정답"
		// 			- 몇 번 만에 맞췄는지 count
		// 			- 기록할 이름 입력과 몇 번만에 맞췄는지 카운트 저장
		// 2. 기록확인
		// 		2-1. 기록한 Rank를 출력
		// 
		// 3. 종료
		// (1)플레이~(3)종료까지 runMenu에 담아준다
			runMenu(menu, records);
		}while(menu != 3);

	}
	
	

	private static void runMenu(int menu, Record[] records) {
		int user;
		Scanner scan = new Scanner(System.in);
		switch(menu) {
		// 1. 플레이
		case 1:
			// 		1-1. 컴퓨터에서 랜덤수 1개를 뽑아줌	-> 랜던수 클래스 만들었던 패키지에서 불러와서 출력.
			int [] comRandom = MethodBaseballGameEx01Teacher.createRandomArray(1, 9, 1);
			// 			- 테스트용 랜덤수를 확인할 수 있는 출력이 필요
			MethodBaseballGameEx01Teacher.printArray(comRandom);	// 테스트용 랜덤 숫자 확인
			System.out.println();
			// 		1-2. 유저가 콘솔에 직접 정수 숫자 입력
			//				- 유저가 직접 맞출때까지 반복, 최소 1회는 실행
			int tryCount = 0;
			do {
				//	comRandom수와 user의 숫자가 일치하는지 확인하는 코드 필요
				// 			- 랜덤수 < 유저수 => Down
				// 			- 랜덤수 > 유저수 => Up
				// 			- 랜덤수 = 유저수 => "정답"
				tryCount++;
				System.out.print("숫자 입력 : ");
				user = scan.nextInt();
				if(user < comRandom[0]) {
					System.out.println("UP");
				} else if(user > comRandom[0]) {
					System.out.println("DOWN");
				} else if(user == comRandom[0]) {
					System.out.println("우왁! 정답스!");
				}
			}while(user != comRandom[0]);
			System.out.println("tryCount" + tryCount); // 테스트용 맞춘 횟수 확인 코드
		
			// 			- 몇 번 만에 맞췄는지 count
							//(기록의 최대 횟수(꼴등) 찾음.
			int maxRecordCount = getMaxRecordCount(records);
			
							//(기록된 수를 찾음(꼴찌 순위)
			int maxRecordRank = getMaxRecordRank(records);
	
			// 			- 기록할 이름 입력과 몇 번만에 맞췄는지 카운트 저장
			if(maxRecordCount > tryCount || maxRecordRank < 5) {
				addRecord(records, tryCount);
			}
			break;
			
		// 2. 기록확인
		case 2:
			// 		2-1. 기록한 Rank를 출력
						// 등록한 3위까지의 기록
			printrecords(records);
			break;
			
		// 3. 종료	
		case 3:
			System.out.println("Shutdown! Good bye!");
			break;
			
		default:
		}
		
	}



	private static void printrecords(Record[] records) {
		for(int i = 0; i < records.length; i++) {
			System.out.println(i+1+"위 ");
			if(records[i] != null) {
				records[i].print();
			}else {
				System.out.println();
			}
		}
		
	}



	private static void addRecord(Record[] records, int tryCount) {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 입력(예 : PSJ) : ");
		String name = scan.next();
		Record r = new Record(tryCount, name);
		// index는 몇번째에 껴넣어야 될지 찾는 역할
		int index = 0;
		for(Record record : records) {
			if(record != null && record.getCount() <= tryCount) {
				index++;
			}
		}
		// 아래의 코드는 기록을 냈을때 그 아래의 순위를 아래의 순위로 밀어주는 역할을 한다.
		for(int i = records.length-1; i > index; i--) {
			records[i] = records[i - 1];
		}
		records[index] = r;
	}



	private static int getMaxRecordRank(Record[] records) {
		int rank = 9999;
		for(Record record : records) {
			if(record != null) {
				rank++;
			}
		}
		return rank;
	}

	private static int getMaxRecordCount(Record[] records) {
		int count = 9999;
		for(Record record : records) {
			if(record != null) {
				count = record.getCount();
			}
		}
		return count;
	}



	private static int selectMenu() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	private static void printMenu() {
		System.out.println("-*-*-*-*-*-*-");
		System.out.println("1. 플레이");
		System.out.println("2. 기록확인");
		System.out.println("3. 종료");
		System.out.println("-*-*-*-*-*-*-");
		System.out.print("메뉴 선택 : ");
	}
	
	

}
