package day30;
/* 필드 : 댓글번호, 내용, 작성자
 * 메소드 : getter, setter
 * 수정삭제 기능 없으니 equals는 없어도 됨
 * toString()
 * 생성자 : 댓글번호, 내용, 작성자
 */

import lombok.Data;

@Data
public class Comment {
	private int num;
	private String contents, writer;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	
	public Comment(int num, String contents, String writer) {
		this.num = num;
		this.contents = contents;
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return num + "| " + contents + "[" + writer + "]";
	}

}
