package day28Practice;

import java.util.Date;
import lombok.Data;

@Data
public class BoardPt {
	private String title, contents, writer, category;
	private Date regDate, upDate;
	private int views, num;
	private static int count = 0;
	
	public BoardPt(String title, String contents, String writer, String category) {
		super();
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.category = category;
		
		this.num = ++count;
		this.regDate = new Date();
	}

	public BoardPt(int num) {
		this.num = num;
	}

	public void update(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
	
	
}
