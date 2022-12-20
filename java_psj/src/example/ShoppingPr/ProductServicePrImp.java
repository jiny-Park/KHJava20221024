package example.ShoppingPr;

import java.util.List;
import java.util.Scanner;

public class ProductServicePrImp implements ProductServicePr {

	@Override
	public boolean insertProduct(List<ProductPr> productList, ProductPr product) {
		if(productList == null || product == null)
			return false;
		if(productList.contains(product))
		return false;
		productList.add(product);
		return true;
	}

	@Override
	public boolean updateProduct(List<ProductPr> productList, int index, ProductPr product) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public ProductPr inputProduct() {
		Scanner scan = new Scanner(System.in);
		System.out.print("분 류 : ");
		String type = scan.nextLine();
		System.out.print("제품명 : ");
		String title = scan.nextLine();
		System.out.print("구매가 : ");
		int buyPrice = scan.nextInt();
		System.out.print("판매가 : ");
		int sellPrice = scan.nextInt();
		if(buyPrice > sellPrice)
			return null;
		return new ProductPr(type, title, buyPrice, sellPrice);
	}

}
