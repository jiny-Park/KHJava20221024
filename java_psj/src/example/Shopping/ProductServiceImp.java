package example.Shopping;

import java.util.List;
import java.util.Scanner;


public class ProductServiceImp implements ProductService{
	// implements란?
	// interface ProductService가 선언(정의)부라면 ProductServiceImp implements ProductService는
	// 선언한 Method를 @Override하여 다시 재정의하며 구현하는 것이라고 할 수 있다.
	
	@Override
	public boolean insertProduct(List<Product> productList, Product product) {
		// 매개변수 예외 체크 : 프로덕트리스트와 프로덕트가 널이면 리턴 false
		if(productList == null ||  product == null)
			return false;
		// 이미 등록된 제품인지 확인
		// contains을 이용하여 productList에 product(분류와 제품명)가 있는지 없는지 확인해서 있으면 false, 없다면 productList에 product를 추가
		if(productList.contains(product)) 
			return false;
		// 제품 등록 
		productList.add(product);
		return true;
	}

	@Override
	public boolean updateProduct(List<Product> productList, int index, Product product) {
		// 예외 처리 
		if(productList == null || productList.size() == 0 || index < 0 || product == null)
			return false;
		// 예외가 아니라면 수정 : index 위치의 값을 저장한 product의 값으로 변경
		productList.set(index, product);
		return true;
	}

	@Override
	public boolean deleteProduct(List<Product> productList, Product product) {
		//매개변수 예외 체크 -> 항상 체크를 해줘야 함!!!
		if(productList == null || productList.size() == 0 || product == null) 
			return false;
		return productList.remove(product);	//productList안에 product의 저장된 동일한 값을 삭제함. 
			// 매개변수로 전달된 값을 ArrayList에서 찾아서, 첫번째로 발견한 값만(index 순서대로 찾음) 삭제
	}

	@Override
	public Product getProduct(List<Product> productList, int index) {
		// 매개변수 예외 체크
		if(productList == null || index < 0 || productList.size() <= index) 
			return null;
		// 예외가 아니라면 index에 있는 정보를 가져오게 한다. 
		return productList.get(index);	
	}

	@Override
	public boolean productStock(Product product, int amount) {
		// 판매시, 판매 수량은 재고량보다 클 수 없다
		if(amount < 0 && product.getAmount() < -amount) {
			System.out.println("재고량이 부족합니다.");
			return false;
		}
		product.addAmount(amount);
		return true;
	}

	@Override
	public Product inputProduct() {
		Scanner scan = new Scanner(System.in);
		System.out.print("분 류 : ");
		String type = scan.nextLine();
		System.out.print("제품명 : ");
		String title = scan.nextLine();
		System.out.print("구매가 : ");
		int buyPrice = scan.nextInt();
		System.out.print("판매가 : ");
		int sellPrice = scan.nextInt();
		// 예외처리 : 구매가가 판매가보다 높아선 안 되기 때문에. 구매가가 판매가보다 높게 되면 마진이기 때문에. 굳이 행사가가 아니라면.
		if(buyPrice > sellPrice)
			return null;
		// 예외처리에 해당되지 않는다면 입력 받은 정보를 Product 객체에 저장
		return new Product(type, title, buyPrice, sellPrice);
	}

	@Override
	public Product getProduct(List<Product> productList, Product product) {
		int index = productList.indexOf(product); //indexOf를 통해 분류명과 제품명만 있는 product에 있는 값이 productList에서 찾아서 index에 저장
		if(index < 0)
			return null;
		return productList.get(index); // productList에 있는 index의 값을 가져온다.
	}

	
	
}
