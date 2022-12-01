package day25;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex04Teacher {
	/* 컴퓨터와 가위, 바위, 보를 하는 프로그램을 작성
	 * 예)
	 * 사용자 : 가위
	 * 컴퓨터 : 보
	 * 사용자가 이겼습니다. 더 하겠습니까? (y/n) : y
	 * 사용자 : 가위
	 * 컴퓨터 : 주먹
	 * 컴퓨터가 이겼습니다. 더 하겠습니까? (y/n) : n
	 * 
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
			
		do {
		System.out.print("사용자 : ");
		String user = scan.next();
		
		String com = randomRPS();
		System.out.println("컴퓨터 : " + com);
		
		int res = compare(user, com);	// 1:사용자 승,	 0:비김, 	-1:컴 승
		printResult(res);
		
		System.out.print("더 하시겠습니까?(y/n) : ");
		
		}while(!scan.next().equals("n"));
	}
	
	//▼▼▼▼▼▼▼ M e t h o d ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼

	private static void printResult(int res) {
		switch(res) {
		case 1:
			System.out.println("사용자가 이겼습니다!");
			break;
		case -1:
			System.out.println("컴퓨터가 이겼습니다!");
			break;
		default:
		}
		
	}

	private static int compare(String a, String b) {
		if(a.equals(b)) {
			System.out.println("비겼습니다!");
			return 0;
		}
		
		// a가 이기면 1, 지면 -1 리턴
		switch(a) {
		case "가위":
			return b.equals("보") ? 1 : -1;
		case "바위":
			return b.equals("가위") ? 1 : -1;
		default:
			return b.equals("바위") ? 1 : -1;
		}	
	}

	private static String randomRPS() {
		List<String> list = Arrays.asList("가위", "바위", "보");
		int r = (int)(Math.random() * 3);

		return list.get(r);
	}
	
	
}