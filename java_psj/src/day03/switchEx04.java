package day03;

import java.util.Scanner;

public class switchEx04 {

	public static void main(String[] args) {
		/* 월을 입력받아 해당하는 월의 마지막 일을 출력하는 코드를 작성하세요.
		 * 31 : 1, 3, 5, 7, 8, 10, 12
		 * 30 : 4, 6, 9, 11
		 * 28 : 2
		 * 월을 입력하세요 : 1
		 * 1월은 31일까지 있습니다.
		 */
		
		// 서진 풀이
		// 안내 메시지 출력
		System.out.print("월을 입력하세요 : ");
		// Scanner와 변수를 통해 값을 저장
		Scanner scan = new Scanner(System.in);
		int month = scan.nextInt();
		
		// switch문으로 출력
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12 :
			System.out.println(month + "월은 31일까지 있습니다.");
			break;
		case 4, 6, 9, 11 : // 또는 이렇게도 작성 가능 -> case 4: case 6: case 9: case 11:
			System.out.println(month + "월은 30일까지 있습니다.");
			break;
		case 2 :
			System.out.println(month + "월은 28일까지 있습니다.");
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
		}
		
		// 강사님 풀이 -> 서진과 비슷
		scan.close();

	}
}
