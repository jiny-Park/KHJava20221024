package example.Shopping;

import lombok.Data;	

@Data	// Data 어노텐션을 import하여 추가
// 제품 클래스 Product
public class Product {
	// 필드 생성
	private String type;
	private String title;
	private int amount;
	// 판매가와 구매가는 한 번 정해지면 안 바뀌는 것으로 설정했기 때문에, final로 해도 상관 없음
	// 다만, 생성자에서만 선택할 수 있고, 생성자를 통해서 초기화할 수 있고 이후에 setter를 통해서도 초기화가 불가능하다.
	private final int buyPrice;
	private final int sellPrice;
	
	// 생성자 생성	(리턴타입이 없다면 생성자, void도 리턴타입에 속하기 때문에 void가 있다면 메소드이다.
	public Product(String type, String title, int buyPrice, int sellPrice) {
		this.type = type;
		this.title = title;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		// 어마운트는 제품을 등록하는거니깐, 아직 구매를 하지 않았기 때문에 추가하지 않음. 
		// 수량은 제품을 구매해야 추가가 되는 것
	}
	
	// 수량 바꿔주는 메소드
	public void addAmount(int amount) {
		this.amount += amount; // 음수면 수량이 빠지고, 양수면 수량이 추가되는 메소드.
	}

	@Override
	public String toString() {
		return "Product [분류:" + type 
					+ "| 제품명:" + title 
					+ "| 수량:" + amount 
					+ "| 구매가:" + buyPrice
					+ "| 판매가:" + sellPrice + "]";
	}

	// 분류명과 제품명이 중복되면 같은 객체로 표현하기 위해서 equals와 hashCode를 추가
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	// 매출 정보가 판매와 구매에 따라서 정보가 달라져야 하기 때문에, 
	// 리스트에 있는 똑같은 객체를 공유하는 것이 아니라, 깊은 복사를 통해서 사용해야 한다. 
	// this에다가 p에 있는 것을 덮어쓰기 하면 됨. 생성자를 통해서.  
	public Product(Product p) {
		this.type = p.type;
		this.title = p.title;
		this.amount = p.amount;
		this.buyPrice = p.buyPrice;
		this.sellPrice = p.sellPrice;
	}
	
	
	
	
	
	
}
