package day30;

import lombok.Data;

/* 필드 : 게시글 번호, 제목, 내용, 작성자
 * 게시글 번호는 게시글 등록할 때 입력
 * -getter, setter
 * -toString : 번호, 제목, 작성자 순으로 출력
 * -equals, hashCode : 게시글 번호를 이용
 * -print : 게시글 번호, 제목, 작성자, 내용 순으로 콘솔에 출력하는 메소드
 * -생성자
 *		- 생성자(번호) : 번호를 이용하여 게시글 생성
 *		- 생성자(번호, 제목, 내용, 작성자) : 번호, 제목, 내용, 작성자를 이용하여 게시글 객체 생성
 */

@Data
public class Board {
	private int num;
	private String title, contents, writer;
		 
	public int getNumber() {
		return num;
	}
	public void setNumber(int number) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override	// Override를 써야할 때 안 써도 상관 없지맘 가급적 써주는 것이 좋다. 
	public String toString() {
		return  num + ".  |  " + title + "  |  " + writer;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
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
		Board other = (Board) obj;
		if (num != other.num)
			return false;
		return true;
	}
	
	public void print() {
		System.out.println("번 호 : " + num);
		System.out.println("제 목 : " + title);
		System.out.println("내 용 : " + contents);
		System.out.println("작성자 : " + writer);	
	}

	public Board(int number, String title, String contents, String writer) {
		this.num = number;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}

	public Board(int number) {
		this.num = number;
	}
	
	
	
	
	

}
