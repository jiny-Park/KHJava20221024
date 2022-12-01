package day19;

import lombok.Data;

@Data
public class BookInfor {
	// 도서정보 리스트를 담을 BookInfor 클래스 생성 -> ISBN, 도서명, 저자(여러명, 엮은이, 옮긴이 다포함), 가격, 출판사, 분류
	private int ISBN, price;
	private String bookName, writer, publisherConpany, type;
	
	public BookInfor(String bookName, String writer, int price, String publisherConpany, String type) {
		this.price = price;
		this.bookName = bookName;
		this.writer = writer;
		this.publisherConpany = publisherConpany;
		this.type = type;
	}

	public BookInfor(String bookName) {
		this.bookName = bookName;
	}
	
	
	
	
	

}
