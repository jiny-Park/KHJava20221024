package day15;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.Data;

public final class ListEx01 {
	
	public static void main(String[] args) {
		/* 리스트를 이용하여 다음 기능을 갖는 ㅇ늘의 할일 프로그램을 작성하세요.
		 * 
		 * 메뉴
		 * 1. 할 일 추가
		 * 2. 할 일 확인
		 * 3. 할 일 삭제
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
		 * 메뉴 선택 : 3
		 * 프로그램 종료
		 * 
		 */
		
		//메뉴 출력
		int menu = -1;
		Scanner scan = new Scanner(System.in);
		ArrayList<toDoList> tdl = new ArrayList<toDoList>();
		
		
		do {
			printMenu();
			// 메뉴 선택
			menu = selectMenu();
			
			// 선택한 메뉴에 따른 기능
			runMenu(menu, tdl);
			
			
		} while(menu != 3);
		
		
	}
	
//------------------------------------------------------------------

	private static void runMenu(int menu, ArrayList<toDoList> tdl) {
		Scanner scan = new Scanner(System.in);
		
		switch(menu) {
		case 1:
			if(addList(tdl)) {
				System.out.println("Plan을 추가했습니다!");
			}
			break;
		case 2:
			planlist(tdl);
			break;
		case 3: 
			System.out.println("프로그램 종료!");
			break;
		default:
			System.out.println("잘못 입력하였습니다! 재입력 부탁 드립니다!");
		}
		
	}



	private static void planlist(ArrayList<toDoList> tdl) {
		for(toDoList tmp : tdl) {
			System.out.println(tmp);
		}
	}

	private static boolean addList(ArrayList<toDoList> tdl) {
		Scanner scan = new Scanner(System.in);
		System.out.println("추가할 Plan을 입력해주세요!");
		toDoList tmp = scanPlan();
		
		int index = tdl.indexOf(tmp);
		
		if(index == -1) {
			tdl.add(tmp);
			return true;
		}
		
		
		return false;
	}

	private static toDoList scanPlan() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Plan : ");
		String plan = scan.nextLine();
		return new toDoList(plan);
	}

	public static void printMenu() {
		System.out.println("-----메뉴 출력-----");
		System.out.println("1. Plan 추가");
		System.out.println("2. 기록확인");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택: ");	
	}
	
	public static int selectMenu() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
}

@Data
class toDoList{
	private String plan;
	
	public toDoList(String plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "[Plan=" + plan + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((plan == null) ? 0 : plan.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		toDoList other = (toDoList) obj;
		if (plan == null) {
			if (other.plan != null)
				return false;
		} else if (!plan.equals(other.plan))
			return false;
		return true;
	}



}
