package day14;

import java.util.Scanner;

public class ExceptionEx03Teacher {

	public static void main(String[] args) {
		int menu = -1;
		Scanner scan = new Scanner(System.in);
		do {
			printMenu();
			
			try {
			menu = scan.nextInt();
			}catch(Exception e){
				System.out.println("입력을 잘못했습니다. 정수를 입력하세요.");
				scan.nextLine();//잘못된 문자열이 빠져나가지 않았기 때문에, 이것을 통해 잘못 입력한 것을 다 빼내줘야 함.
			}
		}while(menu != 3);
	}

	public static void printMenu() {
		System.out.println("-----메뉴 출력-----");
		System.out.println("1. 플레이");
		System.out.println("2. 기록확인");
		System.out.println("3. 종료");
		System.out.println("메뉴 선택: ");	
	}
}
