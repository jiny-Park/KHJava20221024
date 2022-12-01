package day23;

import lombok.Data;

@Data
// 학생(Student) 클래스 : 이름, 생년월일
public class Student {
	private String name;
	private String birthday;
	
	public Student(String name, String birthday) {
		this.name = name;
		this.birthday = birthday;
	}

	public Student(Student std) {
		this.name = std.name;
		this.birthday = std.birthday;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", birthday=" + birthday + "]";
	}
	
	
	
}
