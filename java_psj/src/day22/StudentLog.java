package day22;

import lombok.Data;

@Data
// 학생 일지 클래스(StudentLog) : 이름, 생년월일, 출결
public class StudentLog {
	private Student std;
	private String state;
	
	public StudentLog(String name, String birthday, String state) {
		std = new Student(name, birthday);
		this.state = state;
	}
	
	public StudentLog(Student std, String state) {
		this.std = new Student(std);	// 깊은 복사를 하기 위해서, 일반적으로 참조변수는 깊은 복사를 해줘야함.
		this.state = state; // 깊은 복사 하지 않는 이유 -> String의 특징 
	}
	
}
