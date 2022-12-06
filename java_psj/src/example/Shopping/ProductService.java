package example.Shopping;

import java.util.List; // List기능 import

// 제품과 관련된 것들을 먼저 서비스에서 정의함.
public interface ProductService {
	// interface란?
	
	/**	새로운 제품 정보를 제품 리스트에 등록하는 메소드
	 * @param productList 제품 리스트
	 * @param product 새로운 제품 정보
	 * @return 제품 등록 여부(true/false) -> 기능에 따라 return이 있을수도 없을수도 있다. 어떻게 설계하느냐에 따라 달라짐. 
	 */
	boolean insertProduct(List<Product> productList, Product product);
	// boolean 기본 자료형으로 false/true
	// 팀 프로젝트시 하나의 서비스의 기능을 미리 설정해서 각자 맡아서 그 기능을 구현하기 위해 업무를 분담한다. 업무 분담할때 필요하다!
	
	/**	기존 제품 정보를 수정하는 메소드
	 * @param productList 제품 리스트
	 * -> Product product에서 productList로 변경된 이유는, 파이널이 붙었기 대문에. 
	 * 파이널 정보는 생성자를 통해서만 수정이 되기 때문에 
	 * (Product product, int index, Product newProduct) 이러한 형태로는 수정이 불가능
	 * @param index 수정할 제품의 번지
	 * @param product 수정할 제품 정보
	 * @return 수정 여부 -> 수정이 실패할 수도 있기 때문에 boolean으로 
	 */
	boolean updateProduct(List<Product> productList, int index, Product product);
								// 왼쪽 List<Product> productList은 기존 제품 정보를, 
								// 오른쪽 Product Product은 수정할 제품 정보
	/**	기존 제품 정보를 삭제하는 메소드
	 * @param productList 제품 리스트
	 * @param product 삭제할 제품 정보
	 * @return 삭제 여부
	 */
	boolean deleteProduct(List<Product> productList, Product product);
								// 왼쪽 List<Product> productList은 기존 제품 정보를, 
								// 오른쪽 Product Product은 수정할 제품 정보
	
	/**	제품 리스트에서 index 번지에 있는 제품을 가져오는 메소드
	 * @param productList 제품 리스트
	 * @param index 가져올 번지
	 * @return index 번지에 있는 제품 정보, 없으면 null을 반환
	 */
	Product getProduct(List<Product> productList, int index);	// 번지가 주어지면 제품 정보를 가져오는 것
	// index가 음수 -1일 때 null을 반환하기 위해 메소드를 만듬.
	
	/** 
	 * @param productList
	 * @param product
	 * @return
	 */
	Product getProduct(List<Product> productList, Product product); // 제품이 있으면 제품 정보를 가져오는 것
												// 위에 Product product는 분류와 제품명만 들어가 있는 객체임
	/**	제품 수량을 변경하는 메소드
	 * @param product 제품 정보
	 * @param amount 제품 수량(+면 제품 구매, -면 제품 판매)
	 */
	boolean productStock(Product product, int amount);
	// 판매량이 재고량보다 많은 경우를 생각해서 boolean으로 
	
	/** 제품 정보를 입력받아 객체를 반환하는 메소드
	 * @return 입력받은 정보로 만든 제품 객체
	 */
	Product inputProduct();

	

	
	
	
	
	
	
}
