package example.ShoppingPr;

import java.util.List;

public class ProductControllerPr {
	private ProductServicePr ps = new ProductServicePrImp();
	private List<ProductPr> productList;

	public ProductControllerPr(List<ProductPr> productList) {
		this.productList = productList;
	}

	public void insertProduct() {
		ProductPr product = ps.inputProduct();
		if(ps.insertProduct(productList, product)) {
			System.out.println("새 제품 등록 완료");
		}else {
			System.out.println("제품 등록 실패");
		}	
	}

}
