package day20Practice;

import lombok.Data;

@Data
public class BookPt {
	private String title, author, publisher, genre, isbn;
	private int price;
	
	public BookPt(String title, String author, String publisher, String genre, String isbn, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
		this.isbn = isbn;
		this.price = price;
	}

	@Override
	public String toString() {
		return "[ISBN: " + isbn +"|  도서명: " + title + "|  저자명: " + author + "|  출판사: " + publisher + "|  장르: " + genre
				+ "|  가겨: " + price + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookPt other = (BookPt) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
	


}
