package day02;

import java.util.Scanner;

public class OperatorEx07 {

	public static void main(String[] args) {
		/* 조건선택 연산자 
		 * - 조건식 ? 참일때 : 거짓일때
		 */
		
		// 예제) 주어진 성적이 60점 이상이면 Pass, 아니면 Fail이 출력되도록 코드를 작성

//		int score = 50;
		// String result = 조건식 ? 참일때 : 거짓일때;
		// String result = 성적이 60점 이상이면? Pass : Fail;
		// String result = 성적이 60보다 크거나 같다 ? "Pass" : "Fail";
//		String result = score >= 60 ? "Pass" : "Fail";
//		System.out.println(score + "점은 " + result);
		

		// 실수인 성적 점수를 콘솔에 입력받아, 60점 이상이면 Pass, 아니면 Fail이 출력되도록 코드를 작성
		// 1.변수 지정
		double score;
		String result;
		
		// 2.Scanner로 콘솔에 입력 받기
		Scanner scan = new Scanner(System.in);
		System.out.print("성적 점수를 입력하세요(실수로 입력) : ");
		score = scan.nextDouble();
		
		// 조건식
		result = 60 <= score ? "Pass" : "Fail";
		
		// 출력
		System.out.println(score + "점은 " + result + " 입니다.");
		
		scan.close();
	}

}
