package day06;

import java.util.Scanner;

public class ArrayScoreEx01 {

	public static void main(String[] args) {
		/* 5명 학생의 국어, 영어, 수학 성적을 저장하기 위한 배열을 만들고,
		 * scanner를 이용하여 입력받아, 국어평균, 영어평균, 수학평균을 구하는 코드를 작성
		 */
		
		// scanner import
		Scanner scan = new Scanner(System.in);
		
		// 5명의 국어, 영어, 수학 배열 크기 생성
//		int kor[]  = new int[5];
//		int eng[]  = new int[5];
//		int math[] = new int[5];
//		
//		// 국어, 영어, 수학점수를 입력 받을 변수 선언
//		int korScore, engScore, mathScore;
//		
//		for(int i = 0; i < kor.length; i++) {
//			System.out.print((i + 1) + "번 학생의 국어성적을 입력 : " );
//			korScore = scan.nextInt();
//			kor[i] = korScore;
//			
//			System.out.print((i + 1) + "번 학생의 영어성적을 입력 : " );
//			engScore = scan.nextInt();
//			eng[i] = engScore;
//			
//			System.out.print((i + 1) + "번 학생의 수학성적을 입력 : " );
//			mathScore = scan.nextInt();
//			math[i] = mathScore;
//		}
//		
//		int korsum = 0, engsum = 0, mathsum = 0;
//		for(int i = 0; i < kor.length; i++) {
//			korsum  += kor[i];
//			engsum  += eng[i];
//			mathsum += math[i];	
//		}
//		
//		double korAvg, engAvg, mathAvg;
//		
//		korAvg  = korsum / (double)kor.length;
//		engAvg  = (double)engsum / eng.length;
//		mathAvg = (double)mathsum / math.length;
//		System.out.println("국어 평균 성적 : " + korAvg);
//		System.out.println("영어 평균 성적 : " + engAvg);
//		System.out.println("수학 평균 성적 : " + mathAvg);
//		
//

		
		
		/* 강사님 풀이
		 * 성적표 기준으로 배열 작성 
		 */
		int stdCount = 5;
		int kor1[] = new int[stdCount];
		int eng1[] = new int[stdCount];
		int math1[] = new int[stdCount];
		
		// 학생별 국어, 영어, 수학 성적을 입력 받기
		// Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < stdCount; i++) {
			System.out.print("학생 " +  (i + 1) + "의 국어, 영어, 수학 성적 입력 : ");
			kor1[i] = scan.nextInt();
			eng1[i] = scan.nextInt();
			math1[i] = scan.nextInt();
		}
		
		// 과목별 합(총점)
		double korSum = 0, engSum = 0, mathSum = 0;
		for(int i = 0; i < stdCount; i++) {
			korSum += kor1[i];
			engSum += eng1[i];
			mathSum += math1[i];
		}
		
		// 과목별 평균
		System.out.println("국어 성적의 평균 : " + korSum / stdCount);
		System.out.println("영어 성적의 평균 : " + engSum / stdCount);
		System.out.println("수학 성적의 평균 : " + mathSum / stdCount);

		// 학생별 평균 - 서진 풀이
		for(int i = 0; i < stdCount; i++) {
			double avg = (kor1[i] + eng1[i] + math1[i]) / (double)3;
			System.out.println((i + 1) + "번 학생의 평균 성적 : " + avg);
		}
		// 학생별 평균 - 강사님 풀이
		for(int i = 0; i < stdCount; i++) {
			double avg = kor1[i] + eng1[i] + math1[i];
			System.out.println((i + 1) + "번 학생의 평균 성적 : " + avg / 3);
		}
			
			
			
		
		scan.close();
	}
}
