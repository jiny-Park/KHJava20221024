package day28Practice;

import java.util.Date;
import lombok.Data;

@Data
public class BoardPt {
	private String title, contents, writer, category;
	private Date regDate, upDate;
	private int views, num;
	private static int count = 0;
	
	
}
