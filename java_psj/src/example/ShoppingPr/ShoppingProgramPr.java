package example.ShoppingPr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingProgramPr {

	private Scanner scan = new Scanner(System.in);
	private List<ProductPr> productList = new ArrayList<ProductPr>();
	private List<SalesPr> salesList 	= new ArrayList<SalesPr>();
	private ProductControllerPr pc 		= new ProductControllerPr(productList);
	private SalesControllerPr sc		= new SalesControllerPr(salesList, productList);



	public void run() {
		int menu = -1;
		final int exit = 7;
		do {
			printMenu();
			menu = inputInt();
			exeMenu(menu);
			
		}while(menu != exit);
		
	}

	private void printMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("* 메 뉴");
		System.out.println("1. 제품 등록");
		System.out.println("2. 제품 수정");
		System.out.println("3. 제품 삭제");
		System.out.println("4. 제품 구매");
		System.out.println("5. 제품 판매");
		System.out.println("6. 매출액 확인");
		System.out.println("7. 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	private int inputInt() {
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}

	private void exeMenu(int menu) {
		switch(menu) {
		case 1:
			pc.insertProduct();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			System.out.println("프로그램 종료");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			break;
		default:
		}
		
		
	}
	
}
