package example.Shopping;

import java.util.List;


public class ProductController {
	// 필드로 ProductService ps를 가짐
	// 컨트롤로가 서비스에게 일을시켜서 관리자가 컨트롤로거 서비스는 분담시키는 것. 작업을 나눠서 작업하는 것
	//*컨트롤러는 분업 해주는 것이다. 일을 효율적으로 시켜서 하게 하는 것. 
	private ProductService ps = new ProductServiceImp();
	// 필드로 ProductList를 추가해줌
	private List<Product> productList;
	
	// 생성자 추가
	public ProductController(List<Product> prductList) {
		this.productList = prductList;
	}

	public void insertProduct() {
		// 새 제품 정보를 입력
		// 수정 메소드, 삭제 메소드에서도 쓸 수 있도록, 서비스에 만듬. 
		Product product = ps.inputProduct();			
		// 서비스가 콘솔에서 입력 받아서 입력 받은 정보로, 객체로 주면 그 객체를 프로덕트에 저장하고 그 다음 제품 리스트에 추가함.
		// 제품 리스트에 새 제품을 추가
	
		if(ps.insertProduct(productList, product)) {	
		// 리턴 타입을 이용하여 if문을 이용하여 안내 메세지까지 추가.
		// Product product = ps.inputProduct();	코드의 정보를 받아서 insertProduct로 가게 됨. 
		// insertProduct로 가고 ProductService선언부를 거쳐 ProductServiceImp로 가서 기능을 구현(실행)

			System.out.println("새 제품 등록 완료");
		}else {
			System.out.println("제품 등록 실패");
		}	
	}

	public void updateProduct() {
		// 수정할 제품 내용을 입력
		Product newProduct = ps.inputProduct();	
		// 기존 제품 정보를 가져옴
		int index = productList.indexOf(newProduct); // indexOf를 이용하여 입력받은 수정할 제품 정보를 저장한 newProduct의 참조변수의 값과 동일한
													 // 정보를 productList에서 찾아와서 index에 저장
		// 제품 정보 수정
		if(ps.updateProduct(productList, index, newProduct)) { // 
		// 	Product newProduct = ps.inputProduct();	코드의 정보를 받아서 updateProduct로 가게 됨. 
		// updateProduct로 가고 ProductService선언부를 거쳐 ProductServiceImp로 가서 기능을 구현(실행)
			System.out.println("제품 정보 수정 완료");
		}else {
			System.out.println("제품 정보 수정 실패");
		}
	}

	public void deleteProduct() {
		// 삭제할 제품 정보 입력(판매가, 구매가 0으로 입력), 삭제할 땐 분류명과 제품명만 있으면 됨. 
		// 하지만 앞에서 만든 inputProduct를 쓰기 위해서 입력할 때 판매가와 구매가는 아무거나 입력해도 상관 없게 할 것임.
		Product deleteProduct = ps.inputProduct();//-> 살제할 제품 정보 입력
		// 삭제할 제품 정보를 가져옴
		int index = productList.indexOf(deleteProduct);	// indexOf를 이용하여 입력받은 수정할 제품 정보를 저장한 deleteProduct의 참조변수의 값과 동일한
		 												// 정보를 productList에서 찾아와서 index에 저장 
		Product product = ps.getProduct(productList, index); // -> index의 값과 동일한 값을 가져와서 product에 저장
		// 제품을 리스트에서 삭제
		if(ps.deleteProduct(productList, product)) { // productList, product 인자를 ps.deleteProduct로 보냄.
		// Product deleteProduct = ps.inputProduct();	코드의 정보를 받아서 deleteProduct로 가게 됨. 
		// deleteProduct로 가고 ProductService선언부를 거쳐 ProductServiceImp로 가서 기능을 구현(실행)
			System.out.println("제품 삭제 완료");
		}else {
			System.out.println("제품 삭제 실패");
		}
	}

	
	
	
	
		
}
