package day21PhoneManager;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class PhoneListMainTeacher {
	
	static Scanner scan = new Scanner(System.in);
// 프로그램 화면을 떠올리면서, 단계별로 생각하며 진행해야 한다!
// 기능을 분활해서 사용성이 좋도록 한다.
// 재사용이 가능한 것은 그것대로 묶어준다.
// try catch 문을 어디에 감싸느냐에 따라서 결과가 달라지니 고민하며 설정하는 것이 중요!
// 프로그래밍은 결국엔 작성한 순서대로 컴퓨터가 읽고 실행하는 것에 불과하다. 
// 결국엔 예를 들어 여행 계획 리스트를 순서대로 짜고 그대로 움직이는 것처럼, 
// 컴퓨터가 여행가서 순서대로 움직일 수 있도록 계획을 짜주는 것에 불과하다!!!
	public static void main(String[] args) {
		/* 전화번호를 관리하는 프로그램을 작성
		 * 1. 전화번호 추가(성, 이름, 직장, 전화번호들(집/회사/등 : 전화번호)
		 * 2. 전화번호 수정
		 * 	2-1. 이름으로 검색(성+이름)
		 *  2-2. 검색된 사람들 중에서 선택
		 *  	2-2-1. 성, 이름을 수정할건지
		 * 		2-2-2. 기존 등록된 전화번호를 수정할건지
		 * 		2-2-3. 새 전화번호를 등록할건지를 선택하여 동작
		 * 3. 전화번호 삭제
		 * 	3-1. 이름으로 검색
		 * 	3-2. 검색된 사람들 중에서 선택
		 * 	3-3. 선택된 사람의 연락처를 삭제
		 * 4. 전화번호 조회
		 * 	4-1. 이름으로 검색
		 * 	4-2. 검색된 사람들 중에서 선택
		 * 	4-3. 선택된 사람의 연락처를 출력
		 */
	
		// 반복
		int menu = -1;
		ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
		
		do {		// do while 문을 줄거야. 그러니 너는 순서대로 진행하되 do while문을 만나면 최소 한 번은 실행시켜주고 
					// 조건이 맞지 않으면 그만 멈춰졌으면 좋겠어!
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			try {
			menu = scan.nextInt();
			System.out.println("------------------------------");
			// 선택한 메뉴에 대한 기능 실행
			runMenu(menu, list);
			}catch(RuntimeException e) {
				System.out.println(e.getMessage());
				System.out.println("-----------------------");
			}	
		}while(menu != 5); // true때 실행, false때 종료 
	}

	//▼▼▼▼▼▼▼▼▼▼▼▼▼ M e t h o d ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	
	private static void runMenu(int menu, ArrayList<PhoneBook> list) {

		switch(menu) {
		case 1:
			if(insertPhoneBook(list)) {	// if를 넣음으로 boolean으로 진행할 것임. 이유는 잘못 입력할 경우를 대비해서.
				System.out.println("전화번호를 추가했습니다!");
			}else {
				System.out.println("전화번호를 추가하지 못했습니다!");
			}
			
			break;
			
		case 2:
			// 2. 전화번호 수정
			if(updatePhoneBook(list)) {
				System.out.println("전화번호를 수정했습니다!");
				System.out.println("=================");
			}else {
				System.out.println("전화번호를 수정하지 못했습니다!");
				System.out.println("======================");
			}
					
			break;
			
		case 3:
			// 3. 전화번호 삭제
			if(deletePhoneBook(list)) {
				System.out.println("전화번호를 삭제했습니다!");
				System.out.println("------------------------------");
			}else {
				System.out.println("전화번호를 삭제하지 못했습니다!");
				System.out.println("------------------------------");
			}
			
			break;
			
		case 4:
			// 4. 전화번호 조회
			printSearchNumber(list);
					// 2-1. 이름을 입력
					
					// 2-2. 이름이 포함된 전화번호부를 검색하여 출력(번호와 함께 => 선택하기 위해서 필요)
				
					// 2-3. 조회할 전화번호 선택을 하고 
				
					
					// 2-4. 전화번호 조회
			break;
			
		case 5:
			System.out.println(" † Good bye. I will be back † ");
			System.out.println("------------------------------");
			// 5. 프로그램 종료
			break;
			
		default:
			System.out.println("※경고 : 잘 못 선 택※");
			System.out.println("-----------------");
		}
			
	}
	
	private static boolean updatePhoneBook(ArrayList<PhoneBook> list) {
		//전화번호 수정
		// 2-1. 이름을 입력
		scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		// 2-2. 이름이 포함된 전화번호부를 검색하여 출력(번호와 함께 => 선택하기 위해서 필요)
		ArrayList<Integer> indexs = searchPhoneBook(list,p->p.getName().contains(name));
		
		printIndexNumber(list, indexs);
		
		// 2-3. 수정할 전화번호 선택을 하고 
		System.out.print("수정할 번호 선택 : ");
		int selectIndex = scan.nextInt() -1;
		if(selectIndex < 0 || selectIndex >= indexs.size()) {
			throw new RuntimeException("잘못 선택했습니다!");
		}
		
		// 2-4. 서브 메뉴 출력
		printSubMenu();	// 한 군데서만 쓰는 메뉴이기 때문에, 매개변수를 넘겨줄 필요가 없다. 만약에 다른 곳에서도 사용을 해야 한다면 매개변수로 요청을 해야함. 

		// 2-5. 서브 메뉴 선택
		int subMenu = scan.nextInt();
	
		// 2-6. 서브 메뉴 실행
		int index = indexs.get(selectIndex);
		return runSunMenu(subMenu, list.get(index));
	}

	private static boolean runSunMenu(int subMenu, PhoneBook pb) {
		if(pb == null) {
			return false;
		}
		//서브 메뉴 실행
		switch(subMenu) {
		case 1:
			// 2-6-1. 이름, 직장 수정
			// 2-6-1-1. 이름, 직장 입력
			scan.nextLine(); // 공백 처리(메뉴 입력 후 남은 엔터)
			System.out.print("성명 : ");
			String name = scan.nextLine();
			System.out.print("직장 : ");
			String company = scan.nextLine();
			
			// 2-6-1-2. 이름, 직장을 수정
			pb.update(name, company);
			break;
			
		case 2:
			// 2-6-2. 기존 전화번호 수정
			// 2-6-2-1. 기존 전화번호들을 출력
			pb.printPhoneNumber();
			
			// 2-6-2-2. 수정할 전화번호를 선택
			System.out.print("번호 입력 : ");
			int index = scan.nextInt() -1;
			
			// 2-6-2-3. 이름, 번호를 입력
			scan.nextLine();
			System.out.print("이름(폰/집/직장 등) : ");
			String pName = scan.nextLine();
			System.out.print("번호(예:010-0000-0000) : ");
			String number = scan.nextLine();
			
			// 2-6-2-4. 선택한 전화번호 이름, 번호를 수정
			pb.getPnList().get(index).update(pName, number);

			break;
			
		case 3:
			// 2-6-3. 새 전화번호 추가
			// 2-6-3-1. 이름, 번호를 입력
			scan.nextLine();
			ArrayList<PhoneNumber> pnList = inputPhoneNumbers();
			
			// 2-6-3-2. 새 전화번호를 추가
			pb.getPnList().addAll(pnList);
			break;
			
		default:
			System.out.println("잘못된 메뉴입니다!");
			System.out.println("=============");
			return false;
		}
	
		return true;
	}

	private static void printSubMenu() {
		// 2-4-1. 이름, 직장 수정
		// 2-4-2. 기존 전화번호 수정
		// 2-4-3. 새 전화번호 추가
		System.out.println(" 수 정 메 뉴 ");
		System.out.println("1. 이름과 직장 수정");
		System.out.println("2. 기존 전화번호 수정");
		System.out.println("3. 새 전화번호 추가");
		System.out.print("메뉴 선택 : ");
	}

	private static void printIndexNumber(ArrayList<PhoneBook> list, ArrayList<Integer> indexs) {
		if(indexs == null || indexs.size() == 0 || list == null || list.size() == 0) {
			throw new RuntimeException("검색 결과가 없습니다!");
		} 
		
		for(int i = 0; i < indexs.size(); i++) {
			int index = indexs.get(i);
			System.out.println(i+1 +". " + list.get(index));
		}
	}
	
	private static void printSearchNumber(ArrayList<PhoneBook> list) {
		// 4. 전화번호 조회
			// 4-1. 이름을 입력
		scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
			
			// 4-2. 이름이 포함된 전화번호부를 검색하여 출력(번호와 함께 => 선택하기 위해서 필요)
		ArrayList<Integer> indexs = searchPhoneBook(list,p->p.getName().contains(name));
		printIndexNumber(list, indexs);
		
			// 4-3. 조회할 전화번호 선택을 하고 
		System.out.print("조회할 번호 선택 : ");
		int selectIndex = scan.nextInt() -1;
		if(selectIndex < 0 || selectIndex >= indexs.size()) {
			return;
		}
		list.get(selectIndex).print();
			// 4-4. 전화번호 조회
	}

	private static boolean deletePhoneBook(ArrayList<PhoneBook> list) {
		scan.nextLine(); // 엔터 처리
		// 3. 전화번호 삭제
		// 3-1. 이름을 입력
		System.out.print("이름 : ");
		String name = scan.nextLine();

		// 3-2. 이름이 포함된 전화번호부를 검색하여 출력(번호와 함께 => 선택하기 위해서 필요)				
		ArrayList<Integer> indexs = searchPhoneBook(list,p->p.getName().contains(name));

		// 확인된 번지에 있는 번호들을 출력(번호와 함께)
		printIndexNumber(list, indexs);
		
		// 3-3. 삭제할 전화번호 선택을 하고 
		System.out.print("삭제할 번호 선택 : ");
		int selectIndex = scan.nextInt() -1;
		if(selectIndex < 0 || selectIndex >= indexs.size()) {
			return false;
		}
		int deleteIndex = indexs.get(selectIndex);
		// 3-4. 전화번호를 삭제
		
		return list.remove(deleteIndex) != null; // 삭제한 객체
	}

	private static ArrayList<Integer> searchPhoneBook(ArrayList<PhoneBook> list, Predicate<PhoneBook> p) {
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++) {
			if(p.test(list.get(i)))	// 참일시 indexs에 추가
					indexs.add(i);
		}
		return indexs;
	}

	private static PhoneNumber inputPhoneNumber() {
		// 1-2. 전화번호 추가(이름(폰/집/직장/학교 : 번호) => PhoneNumber
		System.out.print("이름(폰/집/직장 등) : ");
		String pName = scan.nextLine();
		System.out.print("번호(예:010-0000-0000) : ");
		String number = scan.nextLine();
		return new PhoneNumber(pName, number);
	}

	private static ArrayList<PhoneNumber> inputPhoneNumbers() {
		ArrayList<PhoneNumber> pnList = new ArrayList<PhoneNumber>();
		do {
		// 1-2. 전화번호 추가(이름(폰/집/직장/학교 : 번호) => PhoneNumber
		// 입력 받은 이름, 번호를 이용하여 PhoneNumber 객체를 만들고,
			PhoneNumber pn = inputPhoneNumber();
		// 만들어진 PhoneNumber 객체를 PhoneNumber 리스트에 추가
			pnList.add(pn);			//윗줄 포함해서 한 줄로 생성시 -> pnList.add(inputPhoneNumber);	

			// 1-3. 전화번호를 더 입력할건지 물어봄
			System.out.print("더 입력하겠습니까?(y/n) : ");
		}while(scan.nextLine().charAt(0) != 'n');
		
		return pnList;
	}

	private static boolean insertPhoneBook(ArrayList<PhoneBook> list) {
		// 1. 전화번호 추가
		// 1-1. 성명, 직장 입력
		scan.nextLine(); // 공백 처리(메뉴 입력 후 남은 엔터)
		System.out.print("성명 : ");
		String name = scan.nextLine();
		System.out.print("직장 : ");
		String company = scan.nextLine();
		
		// 1-2~3 반복 
		ArrayList<PhoneNumber> pnList;
		try {
			pnList = inputPhoneNumbers();
		}catch(RuntimeException e) {
			return false;
		}
		// 1-4. 전화번호부에 추가 => PhoneBook 개체를 생성
		PhoneBook pb = new PhoneBook(name, company, pnList);
		
		// 성명, 직장, 전화번호들(PhoneNumber 리스트)을 이용하여 PhoneBook 객체를 생성

		// list에 PhoneBook 객체를 추가 
		list.add(pb);

		return true;
	}

	private static void printMenu() {
		System.out.println(" ☎ 메 뉴 ☎ ");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.println("5. 프로그램 종료");
		System.out.print("메 뉴 선 택 ☞ ");		
	}

}
