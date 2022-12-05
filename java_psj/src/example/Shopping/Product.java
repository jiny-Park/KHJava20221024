package example.Shopping;

import lombok.Data;

@Data
public class Product {
	private String type;
	private String title;
	private int amount;
	private final int buyPrice;
	private final int sellPrice;
	
	public Product(String type, String title, int buyPrice, int sellPrice) {
		this.type = type;
		this.title = title;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		//어마운트는 제품을 등록하는거니깐, 아직 구매를 하지 않았기 때문에 추가하지 않음. 
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
	
	public Product(Product p) {
		this.type = p.type;
		this.title = p.title;
		this.amount = p.amount;
		this.buyPrice = p.buyPrice;
		this.sellPrice = p.sellPrice;
	}
	
	
	
	
	
	
}
