package example.Shopping;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class SalesServiceImp implements SalesService{

	@Override
	public Sales inputSales(String saleType) {
		Scanner scan = new Scanner(System.in);
		// 입력 받는 정보
		System.out.print("일 시(0000-00-00) : ");
		String date = scan.nextLine();
		System.out.print("분 류 : ");
		String type = scan.nextLine();
		System.out.print("제품명 : ");
		String title = scan.nextLine();
		System.out.print("수 량 : ");
		int amount = scan.nextInt();
		//예외 처리 : 구매를 0개나 -로 할 수 없기에.
		if(amount <= 0)
			return null;
		// 제품 정보가 필요하기 때문에, Product product 객체 생성하여 제품정보를 저장
		Product product = new Product(type, title, 0, 0); //(분류명, 제품명, 구매가, 판매가) 
// Sales sales 객체 생성 : 제품 정보, 수량, 총금액은 아직 모르니 0으로, date 일시, 타입은 매개변수로 입력받은 문자열을 열거형으로 바꿔주는 코드 
		Sales sales = new Sales(product, amount, 0, date, SalesType.valueOf(saleType));
		
		return sales;
	}

	@Override
	// 비슷한 기능의 메소드라면 형태가 똑같을 수 있도록 만들어 주는 것이 좋다. 
	public void printByYear(List<Sales> salesList) {
		Scanner scan = new Scanner(System.in);
		System.out.print("연도 : ");
		String year = scan.nextLine(); // 입력받은 연도 year에 저
		String date = year;	// year의 값을 date에 저장
		printSales(salesList, s->{	//년도, 월, 일을 다 동일하게 받아야 되니 메소드 생성하여 간결하게 함
			String salesDate = s.getDateStr().substring(0,date.length());
							 						//0번지부터 date.length의 길이만큼 s.getDateStr의 값을 가져온다.
			return salesDate.equals(date); // 위에서 s.getDateStr()가져온 값을 salesDate에 저장하였고, 
										   // salesDate의 저장한 값이 equals(date->입력받은)와 같으면 리턴
		});	
	}

	@Override
	public void printByMonth(List<Sales> salesList) {
		Scanner scan = new Scanner(System.in);
		System.out.print("연도 : ");
		String year = scan.nextLine();
		System.out.print("월 : ");
		String month = scan.nextLine();
		//2022-01 -> (month.length()<2?"0"+month:month) 월이 한 자리일경우 01처럼 0을 붙여주기 위해서.
		String date = year + "-" + (month.length()<2?"0"+month:month);
		printSales(salesList, s->{
			String salesDate = s.getDateStr().substring(0,date.length());
			return salesDate.equals(date);
		});		
	}

	@Override
	public void printByDay(List<Sales> salesList) {
		Scanner scan = new Scanner(System.in);
		System.out.print("연도 : ");
		String year = scan.nextLine();
		System.out.print("월 : ");
		String month = scan.nextLine();
		System.out.print("일 : ");
		String day = scan.nextLine();
		//2022-01-01
		String date = year + "-" + (month.length()<2?"0"+month:month) + "-" + (day.length()<2?"0"+day:day);
		printSales(salesList, s->{
			String salesDate = s.getDateStr().substring(0,date.length());
			return salesDate.equals(date);
		});		
	}
	
	@Override
	// 
	public void printSales(List<Sales> salesList, Predicate<Sales> p) {	
//Predicate란?
		// 예외 처리
		if(salesList == null || salesList.size() == 0) {
			System.out.println("결과 없습니다.");
			return;
		}
		int count = 0;
		// 총구매금액과 총판매금액 
		int buyPrice = 0;
		int sellPrice = 0;
		for(Sales sales : salesList) {	// 
			if(p.test(sales)) {	
				System.out.println(sales);	// true면 
				count++;
				if(sales.getType() == SalesType.구매) // sales.getType()이 SalesType.구매와 같으면
					buyPrice += sales.getPrice();
				else	// sales.getType()이 SalesType.구매와 같지 않다면(곧 판매라면)
					sellPrice += sales.getPrice();
			}
		}
		if(count == 0) {
			System.out.println("결과 없습니다.");
		}else {
			System.out.println("구매 금액 : " + buyPrice);
			System.out.println("판매 금액 : " + sellPrice);
			System.out.println("매출 정산 : " + (sellPrice - buyPrice));
		}		
	}
	

	
	
}
