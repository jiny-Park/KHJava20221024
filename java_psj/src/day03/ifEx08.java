package day03;

import java.util.Scanner;

public class ifEx08 {

	public static void main(String[] args) {
		/* 점수를 정수로 입력받아 입력받은 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		 * A : 90~100
		 * B : 80~89
		 * C : 70~79
		 * D : 60~69
		 * F : 0~59
		 * 잘못된 성적 : 그 외
		 */
		// 서진 풀이
		// 변수 선언과 Scanner을 통한 입력 받기
		int score;
		Scanner scan = new Scanner(System.in);
		System.out.print("성적 점수를 입력하세요(정수로 입력) : ");
		score = scan.nextInt();

		// 입력 받은 정수가 90~100이라면 A를 출력하고, 
		if(90 <= score && score <= 100) {
			System.out.println(score + "점은 A학점 입니다.");
		}// 입력 받은 정수가 80~89이라면 B를 출력하고, 
		else if(80 <= score && score <= 89) {
			System.out.println(score + "점은 B학점 입니다.");
		}// 입력 받은 정수가 70~79이라면 C를 출력하고, 
		else if(70 <= score && score <= 79) {
			System.out.println(score + "점은 C학점 입니다.");
		}// 입력 받은 정수가 60~69이라면 D를 출력하고, 
		else if(60 <= score && score <= 69) {
			System.out.println(score + "점은 D학점 입니다.");
		}// 입력 받은 정수가 0~59이라면 F를 출력하고, 
		else if(0 <= score && score <= 59) {
			System.out.println(score + "점은 F학점 입니다.");
		} else {
			System.out.println(score + "점은 잘못된 성적 점수입니다.");
		}
		// 잘못된 성적이라면 잘못 입력했음을 출력
		scan.close();
		
		
		// 강사님 답안 -> 서진 풀이와 같음.
		// 정수를 받아 score에 저장
		
		// score가 90보다 크거나 같고 score가 100보다 작거나 같으면 A라고 출력,
		// score가 80보다 크거나 같고 score가 89보다 작거나 같으면 A라고 출력,
		// score가 70보다 크거나 같고 score가 79보다 작거나 같으면 A라고 출력,
		// score가 60보다 크거나 같고 score가 69보다 작거나 같으면 A라고 출력,
		// score가 0보다 크거나 같고 score가 59보다 작거나 같으면 A라고 출력,
		// score가 위의 조건을 만족하지 않으면 잘못된 점수라고 출력
		
		// 위의 조건식을 응용해서 변형
		if(score < 0 || 100 < score) {
			System.out.println(score + "점은 잘못된 성적 점수입니다.");
		}else if(score >= 90) {
			System.out.println(score + "점은 A학점 입니다.");
		}else if(score >= 80) {
			System.out.println(score + "점은 B학점 입니다.");
		}else if(score >= 70) {
			System.out.println(score + "점은 C학점 입니다.");
		}else if(score >= 60) {
			System.out.println(score + "점은 D학점 입니다.");
		}else {
			System.out.println(score + "점은 F학점 입니다.");
		} 
		
		
	}

}
