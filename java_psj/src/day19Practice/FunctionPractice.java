package day19Practice;

import java.util.ArrayList;
import java.util.function.Function;

public class FunctionPractice {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 2, "박서진", 100, 100, 100));
		list.add(new Student(1, 2, 2, "춘향이", 100, 100, 100));
		list.add(new Student(3, 1, 2, "이몽룡", 100, 100, 100));
		
		print(list, "국어", s->s.getKor());
		print(list, "수학", s->s.getMath());
			

	}

	public static void print(ArrayList<Student> list, String subject, Function<Student, Integer> f ) {
		for(Student tmp : list) {
			System.out.println(subject + " : " + f.apply(tmp));
			
		} 
	}
	
}
