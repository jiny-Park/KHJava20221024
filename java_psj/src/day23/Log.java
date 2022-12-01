package day23;

import java.util.ArrayList;

import lombok.Data;

@Data
// 일지 클래스(Log) : 날짜, 학생일지(이름, 생년월일, 출결)
public class Log {
	private ArrayList<StudentLog> slogs = new ArrayList<StudentLog>();
	private String date;
	
	public Log(ArrayList<StudentLog> stdLogs, String date) {
		this.date = date;
		this.slogs = stdLogs;	// 원래는 깊은 복사를 해야 하는데, 간단하게 얉은 복사를 이용
	}

	@Override
	public String toString() {
		return "date : " + date + ", slogs : " + slogs + "]\n";
	}
	
	
	
}
