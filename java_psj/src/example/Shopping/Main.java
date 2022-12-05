package example.Shopping;

import java.util.Scanner;

public class Main {
	/* 제품을 관리하는 프로그램 작성
	 * - 기능
	 * 		*구매가격, 판매가격은 변동이 없음 
	 * 	1. 제품 등록(분류(과자/학용품), 제품명, 수량, 구매가격, 판매가격)
	 *  2. 제품 수정
	 *  3. 제품 삭제
	 *  4. 제품 구매(관리자가 구매)
	 *  5. 제품 판매
	 *  6. 매출액 확인
	 *  	-연별
	 *  		-제품별
	 *  		-전체
	 *  	-월별
	 *  		-제품별
	 *  		-전체
	 *  	-일별
	 *  		-제품별
	 *  		-전체
	 *  7. 종 료 
	 *  분류 : 식품
	 *  제품명 : 진라면
	 *  수량 : 0
	 *  구매가격 : 4000원
	 *  판매가격 : 5000원
	 *  진라면 100개 구매 => 진라면 수량 100개
	 *  진라면 10개 판매(날짜) => 진라면 수량 90개
	 */

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		ShoppingProgram shoppingProgram = new ShoppingProgram();
		shoppingProgram.run();
	}	
	
}
