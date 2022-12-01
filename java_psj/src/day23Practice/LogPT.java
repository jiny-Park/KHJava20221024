package day23Practice;

import java.util.ArrayList;

import lombok.Data;

@Data
// 일지 클래스(Log) : 날짜, 학생일지(이름, 생년월일, 출결)
public class LogPT {
	private ArrayList<StudentLogPT> slogs = new ArrayList<StudentLogPT>();
	private String date;
	
	public LogPT(ArrayList<StudentLogPT> stdLogs, String date) {
		this.date = date;
		this.slogs = stdLogs;
	}

	@Override
	public String toString() {
		return "date : " + date + ", slogs : " + slogs + "]\n";
	}

//	public ArrayList<StudentLog> getSlogs() {
//		return slogs;
//	}
//
//	public void setSlogs(ArrayList<StudentLog> slogs) {
//		this.slogs = slogs;
//	}
//
//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	} 
	

	
}
