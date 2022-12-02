package day30;

import java.util.Scanner;

public class KioskMain {
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
	
	/* - 메인 메뉴 출력
	 *  - 등록, 수정, 삭제, 구매, 판매, 확인, 종료
	 * 	- 메인 메뉴 선택 
	 * 	- 선택한 메인 메뉴에 따른 기능 실행
	 * 
	 * 선택한 메인 메뉴별 기능 실행
	 * 1. 제품 등록
	 * 	- 구매한 제품 리스트 보기
	 * 	- 등록할 제품 입력
	 * 		- (분류(과자/학용품), 제품명, 수량, 구매가격, 판매가격)
	 * 		- 등록할 제품 객체 생성
	 * 		- 동일한 제품명이 있는지 체크, 있다면 동일제품 존재 안내
	 * 		- 없다면 제품List에 제품 등록
	 * 		- 제품 객체에 저장(*필요한 클래스 : 제품 클래스)
	 * 	- 이전
	 * 
	 * 2. 제품 수정
	 *	- 수정할 제품 리스트를 제품명으로 검색
	 *	- 검색한 제품이 없다면 동일한 제품이 없다고 안내
	 *	- 동일한 제품이 있다면 수정 입력
	 *	- 수정한 제품 다시 재등록
	 *
	 * 3. 제품 삭제
	 * 	- 삭제할 제품 리스트를 제품명으로 검색
	 * 	- 검색한 제품이 없다면 동일한 제품이 없다고 안내
	 * 	- 동일한 제품이 있다면 삭제
	 * 
	 * 4. 제품 구매(제품명, 수량)
	 * 	- 구매한 제품과 수량 입력
	 * 	- 구매한 제품 저장(*필요한 클래스 : 구매내역 클래스)
	 * 
	 * 5. 제품 판매
	 * 	- 제품명과 수량 입력 
	 *  - 판매 날짜(0000-00-00) 입력
	 * 	- 등록되어 있는 동일한 제품명 검색
	 * 	- 기존의 수량에서 판매된 수량 뺌
	 *  
	 * 6. 매출액 확인
	 * 	6-1. 연별
	 * 		6-1-1.제품별
	 * 		6-1-1.전체
	 * 	6-2. 월별
	 * 		6-2-1.제품별
	 * 		6-2-2.전체
	 * 	6-3. 일별
	 * 		6-3-1.제품별
	 * 		6-3-2.전체
	 */

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int menu = -1;
		
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			printBar();
			runMenu(menu);
		}while(menu != 7);
		
		

	}

	private static void printBar() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
	
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}

	private static void printMenu() {
		System.out.println("*지니-카운트*");
		System.out.println("1. 제품 등록");
		System.out.println("2. 제품 수정");
		System.out.println("3. 제품 삭제");
		System.out.println("4. 제품 구매");
		System.out.println("5. 제품 판매");
		System.out.println("6. 매출액 확인");
		System.out.println("7. 프로그램 종료");
		System.out.print("메뉴선택 : ");	
	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertProduct();
			break;
		case 2: 
			System.out.println("제품 수정");
			break;
		case 3:
			System.out.println("제품 판매");
			break;
		case 4: 
			System.out.println("제품 구매");
			break;
		case 5:
			System.out.println("제품 판매");
			break;
		case 6: 
			System.out.println("매출액 확인");
			break;
		case 7: 
			printStr("프 로 그 램 종 료");
			printBar();
			break;
		default:
			throw new RuntimeException("[잘못된 메뉴 선택]");	
		}
	}
	
}
