package day02;

import java.util.Scanner;

public class OperatorEx05 {

	public static void main(String[] args) {
		/* 예제 문제)
		 * 박서진 학생의 국어, 영어, 수학 점수를 콘솔에 입력받고,
		 * 박서진 학생 평균 성적은 콘솔에 출력하는 코드를 작성하세요.
		 */
		// 단계별로 세분화하여 이해하는 연습이 매우 필요하다!!!
		// 1. 변수 선언
		String name;
		int Korean, English, Math, total;
		float socoreAverage;
		
		// 2. Scanner를 통해 성적을 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("학생의 이름을 입력하세요 : ");
		name = scan.nextLine();
		System.out.print(name + "학생의 국어 점수를 기록하세요(정수로 입력) : ");
		Korean = scan.nextInt();
		System.out.print(name + "학생의 영어 점수를 기록하세요(정수로 입력) : ");
		English = scan.nextInt();
		System.out.print(name + "학생의 수학 점수를 기록하세요(정수로 입력) : ");
		Math = scan.nextInt();
		
		// 3. 총점을 계산
		total = Korean + English + Math;
		System.out.println(name + "학생의 총합 점수는 " + total + "점 입니다.");
		
		// 4. 평균을 계산 : 나누기는 하면 할수록 정확도가 떨어지기 때문에, 마지막에 해주는 것이 유용하다
		socoreAverage = total / (float)3; // or "socoreAverage = total / 3.0f;" 으로도 작성 가능
	
		// 5. 결과값 출력
		System.out.println(name + "학생의 평균 성적은 " + socoreAverage +"점 입니다.");
		
		System.out.println(name + "학생의 평균 성적은 " + ((Korean+English+Math)/(float)3)+"점 입니다.");
		

		// 통과입니까? true/false
		// 평균이 60점 이상이면 true, 아니면 false
		System.out.println(name +"학생은 통과입니까? : " + (socoreAverage > 60));
		
		// 강사님 답안
		// 통과를 알려주는 변수, 실패를 알려주는 변수
		boolean isPass = socoreAverage >= 60;
		boolean isFail = socoreAverage < 60;	
		System.out.println("통과입니까? : " + isPass);
		System.out.println("통과입니까? : " + !isFail);
		
		scan.close();
	}
}
