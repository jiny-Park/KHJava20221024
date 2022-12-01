package day02;

public class OperatorEx06 {
	public static void main(String[] args) {
		/* 논리 연산자
		 * &&(~이고, ~라고) : 둘다 참이면 참, 나머진 거짓
		 * ||(~이거나) : 둘다 거짓이면 거짓, 나머진 참
		 * ! (반대, ~가 아닌) : Not 연산자
		 */
		
		int score = 85;
		// score가 80점 이상이다. 그리고 score가 90점 미만이다. 
		// 코드를 작성하기 전에 글로 적어보고 그 글을 코드로 옮겨보는 연습을 하는것이 좋다.
		// boolean isB = score가 80점 이상이고 score가 90점 미만이다;
		// boolean isB = score가 80점 이상이다 && score가 90점 미만이다;
		// boolean isB = score가 80보다 크거나 같다 && score가 90보다 작다;
		// boolean isB = score >= 80 && score < 90;
		boolean isB = 80 <= score && score < 90;
		System.out.println(score + "점수 B학점인가요? "+ isB);
		
	}

}
