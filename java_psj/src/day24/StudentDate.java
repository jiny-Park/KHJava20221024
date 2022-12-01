package day24;

import lombok.Data;

@Data
public class StudentDate {
	private String name;
	private int grade, classNumber, number;

	public StudentDate(String name, int grade, int classNumber, int number) {
		this.name = name;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "StudentDate [name=" + name + ", grade=" + grade + ", classNumber=" + classNumber + ", number=" + number
				+ "]";
	}
	
	
	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getGrade() {
//		return grade;
//	}
//	public void setGrade(int grade) {
//		this.grade = grade;
//	}
//	public int getClassNumber() {
//		return classNumber;
//	}
//	public void setClassNumber(int classNumber) {
//		this.classNumber = classNumber;
//	}
//	public int getNumber() {
//		return number;
//	}
//	public void setNumber(int number) {
//		this.number = number;
//	}
	
	
}
