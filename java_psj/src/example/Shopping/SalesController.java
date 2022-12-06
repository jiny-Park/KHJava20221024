package example.Shopping;

import java.util.List;
import java.util.Scanner;

public class SalesController {
	// 필드 생성
	private List<Sales> salesList;	// 매출액 관리 리스트 
	private List<Product> productList;	// 제품 정보 리스트 - 구매, 판매때 사용해야 함
	private ProductService ps;	// ProductService 사용하기 위해서. -> 곧, 일을 시키기 위해서!
	private SalesService ss;	// SalesService 필요함. -> 일을 시키기 위해서.
	
	// 생성자 생성
	public SalesController(List<Sales> salesList, List<Product> productList) {
		this.salesList = salesList;
		this.productList = productList;
		ps = new ProductServiceImp();	// 이건 무슨 역할일까??
		ss = new SalesServiceImp();
	}

	public void sales(String type) {
		// 구매할 제품 정보 입력(타입, 제품명, 수량)
		Sales sales = ss.inputSales(type);	// 구매는 구매정보를, 판매는 판매정보를 입력
//		sales.setType(SalesType.valueOf("구매")); // 윗 방법으로도 가능.
		// 입력한 제품 정보를 가져옴 - 왜냐하면 구매가를 알아야 함. 
		Product product = ps.getProduct(productList, sales.getProduct()); // 제품 정보를 가져오는 것이기에 ps.getProduct
										// sales.getProduct() 애가 몇번지에 있는지 리스트에서 찾아야 함. 그래서 메소드 ps.getProduct 만듬
		
		if(product == null) { // 예외 처리 : 없는 제품을 구매하려고 했을 때 
			System.out.println(type + " 정보를 잘못 입력했습니다.");
			return;
		}
		sales.setProduct(new Product(product)); // 복사(깊은)생성자를 이용해서 새로운 객체를 만들어서 설정해준다. 이렇게 함으로 판매가와 구매가도 설정이 됨.
		int amount = sales.getAmount(); // 
		amount = type.equals("구매") ? amount : -amount; // type이 equals의 "구매"와 같다면 +를, 아니라면(판매일 경우) -를 되게끔 삼항 연산자를 이용

		// 판매시, 판매 수량은 재고량보다 클 수 없다 -> 메소드화 ps.productStock(product, amount);
		ps.productStock(product, amount);
		
		// 매출 금액을 계산
		sales.calculate(type);
		
		// 전체 매출에 현재 매출 정보를 추가
		salesList.add(sales);	// salesList에 위 코드의 sales를 추가
		System.out.println("제품 [" + type + "]이 완료 됐습니다.");
	}

	public void print() {
		Scanner scan = new Scanner(System.in);
		int submenu = -1;
		final int exit = 4;
		do {	// "이전"으로 선택하기 전까지 계속 반복되도록 do while문(다른 반복문으로도 가능) 이용.
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
