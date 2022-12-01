package day28;

import java.util.Date;

import lombok.Data;

@Data
public class Board {

	private String title, content, writer, category;
	private Date regDate, upDate;
	
	
}
