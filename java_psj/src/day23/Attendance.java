package day23;

import java.util.ArrayList;

import lombok.Data;

@Data
// 출석부 클래스(Attendance) : 학생들, 일지들
public class Attendance {
	private ArrayList<Student> stds = new ArrayList<Student>();
	private ArrayList<Log> logs = new ArrayList<Log>();
	

	
}
