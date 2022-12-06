package example.Shopping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;


@Data
public class Sales {	// 매출 관리(무엇을 구매했는지, 판매했는지)
	// 제품 정보, 수량, 타입(구매/판매), 총금액, 일시
	// 필드 생성
	private Product product;
	private int amount, price;
	private Date date;	// 날짜 관리 클래스
	private SalesType type;
	
	// 생성자 생성						// Date date 객체를 String date 문자열로 바꿔줌.
	public Sales(Product product, int amount, int price, String date, SalesType type) {
		this.product = product;
		this.amount = amount;
		this.price = price;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.date = f.parse(date);
		} catch (ParseException e) {
			this.date = null;	// 입력을 잘못 했을 경우엔 날짜는 null
		}
		this.type = type;
	}

	public void calculate(String type) { 
		if(product == null)
			return;
		int price = 0; 
		
		if(SalesType.valueOf(type) == SalesType.구매) // 타입이 구매와 같다면
			price = product.getBuyPrice() * amount;	// 구매가 * 수량
		else if(SalesType.valueOf(type) == SalesType.판매) // 타입이 판매와 같다면
			price = product.getSellPrice() * amount;// 판매가 * 수량
		
		this.price = price;
	}

	// 
	public String getDateStr() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		if(date == null)//예외 처리 : 날짜 정보가 없으면 빈 문자열로 리턴.
			return "";
		return f.format(date);
	}
	
	@Override
	public String toString() {
		return 	"분류:" + product.getType() 
			+ "| 제품명:" + product.getTitle() 
			+ "| " + type.toString() + " 수량:" + amount //type.toString()한 이유는 구매수량, 판매수량으로 출력하기 위해서
														// enum SalesType의 판매, 구매를 출력하기 위해서.
			+ "| 가격:" + price
			+ "| 일시:" + getDateStr();// getDate를 또 오버라이딩하여 우리가 원하는 방향대로 출력되도록 만든다. 
	}
	

	
}
// 열거형 enum
enum SalesType{
	판매, 구매;
}
