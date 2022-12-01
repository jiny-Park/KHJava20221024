package day20;

import lombok.Data;

@Data
public class Book {
	// 필드 => 객체를 나타내는 정보
	private String title, author, publisher, genre, isbn;
	private int price;
	
	 // 생성자 => 필드 초기화
	public Book(String title, String author, String publisher, String genre, String isbn, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
		this.isbn = isbn;
		this.price = price;
	}
	


	
	 // 메소드 => 기능
	 // 			기본적으로 getter, setter => @Data으로 처리(또는 @Getter @Setter로 처리)
	 // 			기본적으로 toString 오버라이드 => 도서 정보를 간단하게 문자열로 만들기 위해 => @Data 또는 @ToString으로 처리 가능
	 // 			기본적으로 equals => 상황에 따라 오버라이딩 하면 된다. => @Data 또는 @EqualsAndHashCode으로 처리 가능
	 //
	
	// 도서명, 저자(여러명, 엮은이, 옮긴이 다포함), 가격, 출판사, 장르, isbn
	

	@Override
	public String toString() {
		return " ISBN: " + isbn + " | "
				+ "도서명: " + title + " | "
				+ "저 자: " + author + " | "
				+ "가 격: " + price + " | "
				+ "출판사: " + publisher + " | "
				+ "장 르: " + genre
				+ "\n";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}
	
	
	
	
	
}
