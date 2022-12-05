package example.Shopping;

import java.util.List;
import java.util.Scanner;

public class SalesController {
	private List<Sales> salesList;
	private List<Product> productList;
	private ProductService ps;
	private SalesService ss;
	
	public SalesController(List<Sales> salesList, List<Product> productList) {
		this.salesList = salesList;
		this.productList = productList;
		ps = new ProductServiceImp();
		ss = new SalesServiceImp();
	}

	public void sales(String type) {
		// 구매할 제품 정보 입력(타입, 제품명, 수량)
		Sales sales = ss.inputSales(type);
//		sales.setType(SalesType.valueOf("구매")); // 윗 방법으로도 가능.
		// 입력한 제품 정보를 가져옴
		Product product = ps.getProduct(productList, sales.getProduct());
		
		if(product == null) {
			System.out.println(type + " 정보를 잘못 입력했습니다.");
			return;
		}
		sales.setProduct(new Product(product)); 
		int amount = sales.getAmount();
		amount = type.equals("구매") ? amount : -amount;

		ps.productStock(product, amount);
		
		// 매출 금액을 계산
		sales.calculate(type);
		
		// 전체 매출에 현재 매출 정보를 추가
		salesList.add(sales);
		System.out.println("제품 [" + type + "]이 완료 됐습니다.");
	}

	public void print() {
		Scanner scan = new Scanner(System.in);
		int submenu = -1;
		final int exit = 4;
		do {
			printSubmenu();
			submenu = scan.nextInt();
			System.out.println("====================");
			scan.nextLine();
			exePrintMenu(submenu);
		}while(submenu != exit);
		
	}

	private void printSubmenu() {
		System.out.println("매출확인 메뉴");
		System.out.println("1. 년별");
		System.out.println("2. 월별");
		System.out.println("3. 일별");
		System.out.println("4. 이전");
		System.out.print("메뉴 선택 : ");
	}
	
	private void exePrintMenu(int submenu) {
		switch(submenu) {
		case 1:
			ss.printByYear(salesList);
			break;
		case 2:
			ss.printByMonth(salesList);
			break;
		case 3:
			ss.printByDay(salesList);
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			System.out.println("====================");
			break;
		default: 
			System.out.println("메뉴를 잘못 선택했습니다.");
		}
		
	}
	
	
	
	

}
