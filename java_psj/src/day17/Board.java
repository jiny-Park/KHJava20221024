package day17;

import lombok.Data;

@Data
public class Board {
	// 게시글은 번호, 제목, 내용, 작성자, 작성일, 조회수로 구성
	
	private int views;
	private String title, texts, id, day;
	
	
	
	
	
	@Override
	public String toString() {
		return "Board [views=" + views + ", title=" + title + ", texts=" + texts + ", id=" + id
				+ ", day=" + day + "]";
	}


	public Board(String title, String texts, String id, String day) {
		this.title = title;
		this.texts = texts;
		this.id = id;
		this.day = day;
	}


	public Board(String title) {
		this.title = title;
	}
	
	public void update(String title, String texts) {
		this.title = title;
		this.texts = texts;
	}
	
	
	
	
	
	
	

}
