package day19;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateEx01 {

	public static void main(String[] args) {

		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 1, "홍길동", 100, 100, 100));
		list.add(new Student(1, 2, 1, "이몽룡", 90, 90, 90));
		list.add(new Student(2, 2, 2, "춘향이", 70, 70, 70));
		
		/* 1학년 1반 학생들을 출력하는 코드 작성
		 * 1학년 2반 학생들을 출력하는 코드 작성
		 * 1학년 학생들을 출력하는 코드 작성
		 * 
		 */

		print(list, 1, 1);
		print(list, 1, 2);
		
		print(list, 2);
		System.out.println("-----------------");
		
		print2(list, (s)->s.getName().charAt(0) == '홍');

		
		
	}

	public static void print(ArrayList<Student> list, int grade, int classNum) {
		for(Student tmp : list) {
			if(tmp.getGrade() == grade && tmp.getClassNum() == classNum) {
				System.out.println(tmp);
			}
		}
	}
	
	public static void print(ArrayList<Student> list, int grade) {
		for(Student tmp : list) {
			if(tmp.getGrade() == grade) {
				System.out.println(tmp);
			}
		}
	}
	
	public static void print2(ArrayList<Student> list, Predicate<Student> p) {
		for(Student tmp : list) {
			if(p.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}

		
		
	
	
}
