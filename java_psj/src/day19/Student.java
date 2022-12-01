package day19;

import lombok.Data;

@Data
public class Student {
	private int grade, classNum, num, kor, eng, math;
	private String name;
	
	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}

	public Student(int grade, int classNum, int num, String name, int kor, int eng, int math) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	



	
	
	
	
	
	
	
}
