package day17;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data

public class BoardT {
	// 게시글 번호를 위한 클래스 변수
	private static int count = 0;
	// 게시글에 필요한 정보
	private String title, content, writer;
	private int views, num;
	private Date date;
	
	// 아래의 생성자를 통해서만 count가 증가하도록 하여 num에 저장
	public BoardT(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		date = new Date();
		++count;
		num = count; // 번호가 여기서 추가가 됨.
	}
	
	public BoardT(int num) {
		this.num = num;
	}

	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		return format.format(date);
	}

	public String print() {
		return "---------------------\n" 
				+"제 목: "+ title + "\n"
				+"내 용: " + content +"\n"
				+"작성자: " + writer + "\n"
				+"조회수: " + views + "\n"
				+"작성일: " + getDate() + "\n"
				+ "------------------";
	}
	
	@Override
	public String toString() {
		return num + "\t"+ "제목:" + title + "  " +"작성자:"+ writer + "  "+ "조회수:" + views + "  " + getDate(); 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			// obj가 Integer로 클래스 변환이 가능하면 게시글 번호와 obj를 비교
			if(obj instanceof Integer) {
				if(num == (Integer)obj) {
					return true;
				}
			}
			// Integer, BoardT 클래스가 아니거나 게시글 번호가 다른 경우
			return false;
		}
			
		
		
		BoardT other = (BoardT) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public void updateViews() {
		views++;
		
	}
	
	
	
	

	
	
}
