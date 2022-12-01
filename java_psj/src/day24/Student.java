package day24;

import java.io.Serializable;

import lombok.Data;

@Data
public class Student implements Serializable{

	private static final long serialVersionUID = 7626388030029414034L;
	
	private int grade, classNum, number;
	private String name;
	
	public Student(int grade, int classNum, int number, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.number = number;
		this.name = name;
	}
	
	public String toString() {
		return grade + "학년  |  " + classNum + "반  |  " + number + "번  |  " + name;	
	}
	

}
