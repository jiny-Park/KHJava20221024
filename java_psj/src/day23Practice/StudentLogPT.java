package day23Practice;

import day23.Student;
import lombok.Data;

@Data
// 학생 일지 클래스(StudentLog) : 이름, 생년월일, 출결
public class StudentLogPT {
	private StudentPT std;
	private String state;
	
	public StudentLogPT(String name, String birthday, String state) {
		std = new StudentPT(name, birthday);
		this.state = state;
	}

	public StudentLogPT(StudentPT std, String state) {
		this.std = new StudentPT(std);
		this.state = state;
	}


	@Override
	public String toString() {
		return "StudentLog [std=" + std + ", state=" + state + "]";
	}



	
	
}
