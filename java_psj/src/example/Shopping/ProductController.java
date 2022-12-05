package example.Shopping;

import java.util.List;

public class ProductController {
	
	private ProductService ps = new ProductServiceImp();
	private List<Product> productList;
	
	public ProductController(List<Product> prductList) {
		this.productList = prductList;
	}

	public void insertProduct() {
		// 새 제품 정보를 입력
		Product product = ps.inputProduct();			
		// 제품 리스트에 새 제품을 추가
		if(ps.insertProduct(productList, product)) {
			System.out.println("새 제품 등록 완료");
		}else {
			System.out.println("제품 등록 실패");
		}	
	}

	public void updateProduct() {
		// 수정할 제품 내용을 입력
		Product newProduct = ps.inputProduct();
		// 기존 제품 정보를 가져옴
		int index = productList.indexOf(newProduct);
		// 제품 정보 수정
		if(ps.updateProduct(productList, index, newProduct)) {
			System.out.println("제품 정보 수정 완료");
		}else {
			System.out.println("제품 정보 수정 실패");
		}
	}

	public void deleteProduct() {
		// 삭제할 제품 정보 입력(판매가, 구매가 0으로 입력)
		Product deleteProduct = ps.inputProduct();		
		// 삭제할 제품 정보를 가져옴
		int index = productList.indexOf(deleteProduct);
		Product product = ps.getProduct(productList, index);		
		// 제품을 리스트에서 삭제
		if(ps.deleteProduct(productList, product)) {
			System.out.println("제품 삭제 완료");
		}else {
			System.out.println("제품 삭제 실패");
		}
	}

	
	
	
	
		
}
