//package day22;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.function.Predicate;
//
//public class AttendanceMain {
//	
//	static Scanner scan = new Scanner(System.in);
//	
//	public static void main(String[] args) {
//		// 출석부 관리 프로그램
//		// 1. 학생 등록
//		//	- 이름과 생년월일
//		// 2. 학생 수정
//		//	- 이름과 생년월일을 검색해서 이름과 생년월일 수정
//		// 3. 학생 삭제
//		//	- 이름과 생년월일을 검색해서 삭제
//		// 4. 학생 출결 확인
//		//	- 이름과 생년월일을 검색해서 해당 학생의 모든 출결을 확인
//		// ex) 2022-11-22 : O(출석 확인)
//		// 5. 출석 확인 
//		//	- 날짜 입력 : ex) 2022-11-22
//		//	- 출석 : O, 지각 : /, 조회 : \, 결석 : X
//		//  
//		// 예) 홍길동 출석 현황 : X
//		// 	  고길동 출석 현황 : O
//		//		...
//		//	
//		// 6. 출석 수정
//		//	- 날짜 입력
//		//	- 수정할 학생의 이름과 생년월일 입력
//		// 7. 출석 삭제
//		//	- 날짜 입력하여 해당 날짜 출석 삭제
//		// 8. 날짜별 출석 확인
//		//	- 날짜 입력하여 해당 날짜의 모든 학생의 출석 여부를 확인
//		// 9. 프로그램 종료
//		
//		
//		int menu = -1;
//		ArrayList<StudentBook> list = new ArrayList<StudentBook>();
//		
//		do {
//		// 메뉴 출력
//			printMenu();
//		// 메뉴 선택
//			menu = scan.nextInt();
//			
//		// 선택한 메뉴에 대한 기능 실행
//			runMenu(menu, list);
//		
//		}while(menu != 9);
//		
//
//	}
//
//	private static void runMenu(int menu, ArrayList<StudentBook> list) {
//		String name, dOb;
//		int count = 0;
//		int num = 0;
//		int selectIndex = 0;
//		switch(menu) {
//		case 1: 
//			// 1. 학생 등록 
//			// 	1-1. 이름과 생년월일을 입력 받음
//			System.out.print("이름 : ");
//			name = scan.next();
//			scan.nextLine();
//			System.out.print("생년월일(0000-00-00) : ");
//			dOb = scan.nextLine();
//			
//			//  1-2. 이름하고 생년월일이 같은지 확인 메소드가 필요. 
//			//  1-3. 이름하고 생년월일이 같지 않다면 리스트에 추가
//			StudentBook sdBook = new StudentBook(name, dOb);
//				
//			if(list.contains(sdBook)) {
//				System.out.println("이미 등록된 학생입니다!");
//				System.out.println("----------------");
//				return;
//			}else {
//				System.out.println("학생 등록을 완료 했습니다!");	
//			}
//			
//			list.add(sdBook);
//			
//			break;
//		case 2: 
//			// 2. 학생 수정
//			//	2-1. 검색할 이름과 생년월일 입력 받음
//			System.out.print("이름 : ");
//			name = scan.next();
//			scan.nextLine();
//			System.out.print("생년월일(0000-00-00) : ");
//			dOb = scan.nextLine();
//			//	2-2. 입력 받은 동일한 학생 리스트만 출력
//			ArrayList<Integer> indexs = searchStudentBook(list, s->s.getName().contains(name));
//			printIndexStudent(list, indexs);
//			//	2-3. 수정할 번호를 선택하여 수정
//			System.out.print("수정할 번호 선택 : ");
//			selectIndex = scan.nextInt() -1;
//			if(selectIndex < 0 || selectIndex >= indexs.size()) {
//				throw new RuntimeException("잘못 선택했습니다!");
//			}
//			
//			//  2-4. 수정할 이름과 생년월일을 입력받아 리스트 수정
//			scan.nextLine();
//			System.out.print("이름 : ");
//			String name1 = scan.next();
//			scan.nextLine();
//			System.out.print("생년월일(0000-00-00) : ");
//			dOb = scan.nextLine();
//			
//			int index = indexs.get(selectIndex);
//	
//			list.get(index).setDOb(dOb);
//			list.get(index).setName(name1);
//			break;
//			
//		case 3: 
//			System.out.println(" 학생 삭제 예정");
//			// 3. 학생 삭제
//			//	3-1. 검색할 이름과 생년월일 입력 받음
//			System.out.print("이름 : ");
//			name = scan.next();
//			scan.nextLine();
//			System.out.print("생년월일(0000-00-00) : ");
//			dOb = scan.nextLine();
//			//	3-2. 입력 받은 동일한 학생 리스트만 출력
//			ArrayList<Integer> indexs = searchStudentBook(list, s->s.getName().contains(name));
//			printIndexStudent(list, indexs);
//			//	3-3. 삭제할 번호를 선택하여 삭제
//			System.out.print("수정할 번호 선택 : ");
//			selectIndex = scan.nextInt() -1;
//			if(selectIndex < 0 || selectIndex >= indexs.size()) {
//				throw new RuntimeException("잘못 선택했습니다!");
//			}
//			int deleteIndex = indexs.get(selectIndex);
//			
//			list.remove(deleteIndex);
//			break;
//			
//		case 4: 
//			System.out.println(" 학생 출결 확인 예정");
//			// 4. 학샐 출결 확인
//			//	4-1. 검색할 이름과 생년월일 입력 받음
//			//	4-2. 입력 받은 해당학생의 출결을 입력(PhoneListMain 예제 참고)
//			//	4-3. 날짜 입력과 출결 입력
//			break;
//		case 5: 
//			System.out.println(" 출석 확인 예정");
//			// 5. 출석 확인
//			//	5-1. 날짜 입력(0000-00-00) 
//			//	출석 : O, 지각 : /, 조회 : \, 결석 : X
//			//	5-2. 입력한 날짜의 모든 현황리스트 출력
//			break;
//		case 6: 
//			System.out.println(" 출석 수정 예정");
//			// 6. 출석 수정
//			//	6-1. 날짜 입력 받아
//			//	6-2. 입력 받은 날짜에 대한 리스트 출력
//			//	6-3. 수정할 학생의 이름과 생년월일 입력
//			//	6-4. 출석 수정한 후에 저장
//			break;
//		case 7: 
//			System.out.println(" 출석 삭제 예정");
//			// 7. 출석 삭제
//			//	7-1. 삭제할 날짜 입력 받기
//			//	7-2. 입력 받은 날짜에 대한 리스트 출력
//			// 	7-3. 삭제를 입력 받아 삭제
//			break;
//		case 8: 
//			System.out.println(" 날짜별 출석 조회 예정");
//			// 8. 날짜별 출석 확인
//			//	8-1. 날짜 입력
//			// 	8-2. 입력받은 날짜의 모든 학생의 출석 여부 리트스 출력
//			break;
//		case 9: 
//			System.out.println(" 프 로 그 램 종 료");
//			break;
//		default:
//			System.out.println("잘못된 메뉴입니다!");
//		
//		}	
//	}
//
//	private static void printIndexStudent(ArrayList<StudentBook> list, ArrayList<Integer> indexs) {
//		if(indexs == null || indexs.size() == 0 || list == null || list.size() == 0) {
//			throw new RuntimeException("검색 결과가 없습니다!");
//		}
//		for(int i = 0; i < indexs.size(); i++) {
//			int index = indexs.get(i);
//			System.out.println(i+1 + ". " + list.get(index));
//		}
//	}
//
//	private static ArrayList<Integer> searchStudentBook(ArrayList<StudentBook> list, Predicate<StudentBook> s) {
//		ArrayList<Integer> indexs = new ArrayList<Integer>();
//		for(int i = 0; i < list.size(); i++) {
//			if(s.test(list.get(i)))
//				indexs.add(i);
//		}
//		return indexs;
//	}
//
//	private static void printMenu() {
//		System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
//		System.out.println("▤ 출 석 부 메 뉴 ▤");
//		System.out.println("1. 학생 등록");
//		System.out.println("2. 학생 수정");
//		System.out.println("3. 학생 삭제");
//		System.out.println("4. 학생 출결 등록");
//		System.out.println("5. 출석 확인");
//		System.out.println("6. 출석 수정");
//		System.out.println("7. 출석 삭제");
//		System.out.println("8. 날짜별 출석 확인");
//		System.out.println("9. 프로그램 종료");
//		System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
//		System.out.print(" 메 뉴 선 택 : ");
//		
//		
//	}
//
//}
