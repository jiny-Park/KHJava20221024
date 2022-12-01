package day23Practice;

import lombok.Data;

@Data
// 학생(Student) 클래스 : 이름, 생년월
public class StudentPT {
	private String name;
	private String birthday;
	
	public StudentPT(String name, String birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	
	public StudentPT(StudentPT std) {
		this.name = std.name;
		this.birthday = std.birthday;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", birthday=" + birthday + "]";
	}
	
	
	

}
