package day15;

// 메소드, 클래스를 쓰는 것보다 먼저 중요한 것은 먼저는 결과물이 나오게끔 하는 것이다.
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ListEx01Teacher {

	public static void main(String[] args) {
		/* 리스트를 이용하여 다음 기능을 갖는 ㅇ늘의 할일 프로그램을 작성하세요.
		 * 
		 * 메뉴
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 할일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 
		 * 
		 * 메뉴 선택 : 1
		 * --------------------
		 * 할일 입력 : 오후 수업 참여
		 * 
		 * 메뉴 
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 종료
		 * 메뉴 선택 : 
		 * 
		 * 메뉴 선택 : 1
		 * 할일 입력 : 저녁
		 * 
		 * 메뉴 
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 종료
		 * 메뉴 선택 : 
		 * 
		 * 메뉴 선택 : 2
		 * 1. 오후 수업 참여
		 * 2. 저녁
		 * 
		 * 메뉴
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 종료
		 * 메뉴 선택 : 
		 * 
		 * 메뉴 
		 * 1. 할 일 추가
		 * 2. 할 일 확인
		 * 3. 할 일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 3 
		 * 등록한 할 일 List
		 * 삭제할 할 일 번호 선택 : 1
		 * 메뉴 선택 : 3
		 * 프로그램 종료
		 * 
		 */
		ArrayList<String> todoList = new ArrayList<String>();
		int menu = -1;
		Scanner scan  = new Scanner(System.in);
		
		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			
			try {
				menu = scan.nextInt();
				// 선택한 메뉴 실행
				
				runMenu(menu, todoList);
			}catch(InputMismatchException e) {
				System.out.println("----------------");
				System.out.println("예외 발생 : 정수를 입력하세요!");
				System.out.println("----------------");
				scan.nextLine();	
			}catch(Exception e) {
				System.out.println("----------------");
				System.out.println(e.getMessage());
				System.out.println("----------------");
			}
			
		}while(menu != 4);

		scan.close();
	}
	
//-------------------------------------------------------------
	
	private static void runMenu(int menu, ArrayList<String> todoList) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		switch(menu) {
		case 1:
			// 할 일을 입력(공백 포함해서 입력)
			System.out.print("할 일 입력 : ");
			String todo = scan.nextLine();
			// 리스트에 입력된 할일을 추가
			todoList.add(todo);

			break;
		case 2:
			printTodoList(todoList);

			break;
			// 할 일 삭제
			// 1. 먼저 리스트를 출력
			// 2. 삭제할 할 일 번호(정수)를 입력 받아 리스트 번호에 있는 저장된 값을 삭제.
		case 3: 
			printTodoList(todoList);
			
//			deletTodoList(todoList);
			System.out.print("삭제할 번호 선택 : ");
			int index = scan.nextInt() -1;	// list는 0번지부터 시작하기 때문에.
			if(index < 0 || index >= todoList.size()) {
				throw new Exception("예외 발생 : 삭제할 번호를 잘못 입력했습니다.");
			}
			todoList.remove(index);
			

			break;
		case 4:
			System.out.println("프로그램 종료!");
			break;
		default:
			throw new Exception("예외 발생 : 잘못 입력하였습니다! 재입력 부탁 드립니다!");
		}
	}
	
	private static void printTodoList(ArrayList<String> todoList) {
		if(todoList == null || todoList.size() == 0) {
			System.out.println("------------------");
			System.out.println("저장된 할 일이 없습니다.");
			System.out.println("------------------");
			return;
		}
		System.out.println("------------------");
		for(int i = 0; i < todoList.size(); i++) {
			System.out.println(i + 1 + ". " + todoList.get(i));
		}
		System.out.println("------------------");
	}

	private static void printMenu() {
		System.out.println("-----메뉴 출력-----");
		System.out.println("1. 할 일 추가");
		System.out.println("2. 할 일 목록");
		System.out.println("3. 할 일 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택: ");	
	}


	
}
