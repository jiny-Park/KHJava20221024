package example.ShoppingPr;

public class ProductPr {
	private String type, title;
	private int amount;
	private final int buyPrice;
	private final int sellPrice;

	public ProductPr(String type, String title, int buyPrice, int sellPrice) {
		this.type = type;
		this.title = title;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}

}
