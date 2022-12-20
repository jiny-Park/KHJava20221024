package example.ShoppingPr;

import java.util.List;

public interface ProductServicePr {
	
	/** 새로운 제품 정보를 제품 리스트에 등록 메소드
	 * @param productList 제품 리스트 
	 * @param productPr 새로운 제품 정보 
	 * @return 제품 등록 여부(true/false)
	 * 기능에 따라 return이 있을수도 없을수도 있다. 어떻게 설계하느냐에 따라 다름.
	 */
	boolean insertProduct(List<ProductPr> productList, ProductPr product);
	
	/** 기존 제품 정보를 수정하는 메소드
	 * @param productList 제품 리스트
	 * 	-> Product product에서 productList로 변경된 이유는, 파이널이 붙었기 때문에.
	 * 		파이널 정보는 생성자를 통해서만 수정이 되기 때문.
	 * @param index 수정할 제품의 번지
	 * @param productPr 수정할 제품 정보
	 * @return 수정 여부 -> 수정이 실패할 수도 있기 때문에 boolean으로
	 */
	boolean updateProduct(List<ProductPr> productList, int index, ProductPr product);

	ProductPr inputProduct();


	
	
	
}
