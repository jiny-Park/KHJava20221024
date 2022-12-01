package day14;

import java.util.Scanner;

public class ExceptionEx02 {

	public static void main(String[] args) {
		/* Scanner을 통해 정수를 입력 받아 입력받은 정수를 출력하는 코드를 작성
		 * 
		 * 정수대신 문자열을 입력하면 예외가 발생하는데, 이 예외를 처리하는 코드를 작성.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = 0;
		
		try {
			num = scan.nextInt();
			System.out.println("입력하신 정수는 " + num);
		}catch(Exception e) {
			System.out.println("정수를 입력하세요.");
		}
		scan.close();
	}


}





