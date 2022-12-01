package day10;

import java.util.Scanner;

import day08.MethodBaseballGameEx01Teacher;

// day09일차는 스스로 만들어 보는 것이였고, 10일차에선 강사님이 만드신 것을 알려주심.
// 큰 틀 -> 세세하게
// 연습할때는 익숙한 것으로 하되, 도움 없이 프로그램을 만들 수 있는 수준이 되도록.
public class BaseballManagerTeacher {

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
		
		//메뉴 출력
			//1. 최소 1회는 무조건 메뉴 출력은 되야 함.
		// 가변인자를 통해 만들어보기
		int menu;
		Record [] records = new Record[5];
		do {
		printMenu(
				"-------------",
				"메뉴",
				"1. 플레이",
				"2. 기록확인",
				"3. 종료",
				"-------------",
				"메뉴 선택 : "
				);

		//메뉴 선택
		menu = selectMenu();
	
		
		//선택한 메뉴에 따른 기능 실행
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
		runMenu(menu, records);
		}while(menu != 3);

	}
	//-----------------------------------------
	/**
	 * 주어진 메뉴의 맞는 기능을 실행하는 메소드
	 * @param menu실행할 번호
	 */
	private static void runMenu(int menu, Record[] records) {
		switch(menu) {
		case 1: 
			//1. 플레이
			//1-1. 컴퓨터가 랜덤으로 숫자 생성
			int []com = MethodBaseballGameEx01Teacher.createRandomArray(1, 9, 3);		// 랜덤값 생성
			MethodBaseballGameEx01Teacher.printArray(com); //테스트용 - 랜덤값 화면에 출력
			System.out.println();	// 줄바꿈
			BaseballGame bg = new BaseballGame(com);//판별하기 위한 객체
			
			//1-2. 사용자가 숫자 입력
			int tryCount = 0;
			do {
				int []user = MethodBaseballGameEx01Teacher.scanArray(new Scanner(System.in), 3);
				bg.setUser(user);
			//1-3. 판별(결과 출력)
			//1-4. 3S면 종료
				 bg.printResult();
				 tryCount++;
			}while(bg.getStrike() != 3);
			
			
			
			//1-5. [new] 횟수를 기록(최대 5등), 5등 기준으로 횟수가 동일한 경우 먼저 플레이한 사람의 기록을 유지해야함.
			//기록의 최대 횟수(꼴등) 찾음.
			//Count는 기록을 냈을때 기록낸 횟수가 기록안에서 넣을 수 있는지 찾는 코드소스임.
			int maxRecordCount = getMaxRecordCount(records);
			
			//기록된 수를 찾음(꼴찌 순위)
			//Rank가 기록을 먼저 찾는 코드소스임
			int maxRecordRank = getMaxRecordRank(records);
			
			
			
			//기록된 최대 횟수가 내 횟수보다 크거나 기록된 수가 5보다 작으면 기록
			if(maxRecordCount > tryCount || maxRecordRank < 5) {
				addRecord(records, tryCount);
			}
			break;	
		case 2: 
			//2. 기록확인
			//2-1. 등록된 5위까지의 기록을 확인
			printRecords(records);
			//2-2. 
			
			
			break;
		case 3: 
			//3. 종료
			System.out.println("프로그램 종료합니다!");
			break;
		case 4: 
			break;
		default: 
		}
	}
	
	private static void printRecords(Record[] records) {
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
		System.out.print("이름 입력(예 : PSJ) : ");
		String name = scan.next();
		Record r = new Record(tryCount, name);
		// index는 몇번째에 껴넣어야 될지 찾는 역할
		int index = 0;
		for(Record record : records) {
			if(record != null && record.getCount() <= tryCount) {
				index++;
			} 
		}
		// 아래의 코드는 기록을 냈을때 그 아래의 순위를 아래의 순위로 밀어주는 역할을 한다
		for(int i = records.length-1; i > index; i--) {
			records[i] = records[i - 1];
		}
		records[index] = r;
	}
	
	private static int getMaxRecordRank(Record[] records) {
		int rank = 9999999;
		for(Record record : records) {
			if(record != null) {
				rank++;
			}
		}
		return rank;
	}
	
	private static int getMaxRecordCount(Record[] records) {
		int count = 9999999;
		for(Record record : records) {
			if(record != null) {
				count = record.getCount();
			}
		}
		return count;
	}
	
	/**
	 * 메뉴를 콘솔에서 입력받아 돌려주는 메소드
	 * @return 입력받은 메소드
	 */
	private static int selectMenu() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	/**
	 * 메뉴를 출력하는 메소드로, 마지막 메뉴는 엔터가 안 됨
	 * @param strs 콘솔에 출력한 메뉴들
	 */								// 가변인자로 사용해봄.
	private static void printMenu(String ... strs) {	
		
		for(int i = 0; i < strs.length; i++) {
//			System.out.print(strs[i]);
//			if(i == strs.length-1) {	// strs가 마지막이 아니라면 아래의 엔터(줄바꿈)를 실행
//				System.out.println();
//			}
			System.out.print(strs[i] + (i != strs.length-1? "\n":""));	// 삼항 연산자를 통하면 좀 더 코드를 간결하게 표현할 수 있다.
		}
	}

}
