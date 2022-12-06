package example.Shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingProgram {
	// 객체지향이라고 해서 꼭 복잡하게 만드는 것이 객체지향이 아니라 무조건 나누는 것이 답이 아니고 
	// 필요에 의해서 나누어 구조를 짜는 것이 중요하다.
	// 스프링이 이렇게 컨트롤러 서비스 위주로 동작을 하며 작업을 한다. 
	private Scanner scan			  = new Scanner(System.in);
	
	// 쇼핑프로그램이 제품들을 관리함.
	// 외부에서 접근하지 않도록 private
	private List<Product> productList = new ArrayList<Product>();// 제품 리스트
	private List<Sales> salesList 	  = new ArrayList<Sales>();	// 매출액 리스트
	// 컨트롤러 호출하기 위해 컨트롤러 객체 생성.							// ProductController의 매개변수로 productList를 추가
																// 이유는 제품관리는 ProductController가 하기 때문에 연결을 시켜 놓은 것
	private ProductController pc 	  = new ProductController(productList);
	// 컨트롤러 호출하기 위해 컨트롤러 객체 생성. 
	private SalesController sc 		  = new SalesController(salesList, productList);//(salesList, productList) 매개변수 추가 
	
	public void run () {
		// 내가 원하는 조건까지 여러번 프로그램이 실행되도록 do while문을 넣음.
		int menu = -1;
		final int exit = 7;	
		do {
			try {	// 예외처리 : 예외가 발생해도 프로그램이 중단되지 않도록 하기 위해서
				printMenu(); //메뉴를 출력해주는 메소드
				menu = inputInt(); // inputInt 메소드는 정수 num을 입력 받기 위한 메소드. 그리고 menu변수에 저
				exeMenu(menu);	   // menu 변수에 저장한 값을 인자로 exeMenu 메소드의 매개변수로 보냄.
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu != exit);	
	}

	private void printMenu() {
		System.out.println("====================");
		System.out.println(" * 메 뉴 *");
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
		int num = scan.nextInt();	// 콘솔창에 입력 받기 위한 코드. 콘솔창에 입력 받기 위해선 Scanner 클래스를 import 해줘야 함.
		scan.nextLine();	// nextInt로 입력 받은 후에 '엔터'라는 공간이 남기 때문에 이를 처리해주기 위해 scan.nextLine()을 한 줄 넣어줌.
		return num;	// 입력받아 num이라는 변수에 저장한 값을 리턴하여 num의 값을 보내줌.
	}
	
	private void exeMenu(int menu) {
		switch(menu) {	// 입력받은 매개변수 meun의 값을 switch의 조건식에 넣어 준다. 
// switch문은 조건식을 먼저 계산한 다음, 그 결과와 일치하는 case문으로 이동한다. 이동한 case문 아래에 있는 문장들을 수행하며, break문을 만나면 빠져 나간다.
		case 1:
			// 컨트롤러를 통해서 호출할 것임.
			// 제품 등록하는 일은 ProductController에 시킬 것임. 
			pc.insertProduct();
			break;
		case 2:
			pc.updateProduct();
			break;
		case 3:
			pc.deleteProduct();
			break;
		case 4:
			// 매출관리는 생각할게 많음. 나중에 이력을 남겨야 하기 때문에.
			// 구매와 판매를 하기 위해서 salesController과 SalesService와 SalesServiceImp를 만듬 
			sc.sales("구매");
			break;
		case 5:
			sc.sales("판매"); // 주의사항 : 판매는 항상 재고보다 많을 순 없다. 
			break;
		case 6:
			sc.print();
			break;
		case 7:
			System.out.println("프로그램을 종료했습니다.");
			System.out.println("====================");
			break;
		default:
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
