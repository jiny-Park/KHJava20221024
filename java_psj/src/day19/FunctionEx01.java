package day19;

import java.util.ArrayList;
import java.util.function.Function;

public class FunctionEx01 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 1, "홍길동", 100, 100, 100));
		list.add(new Student(1, 1, 1, "이몽룡", 90, 90, 90));
		list.add(new Student(3, 2, 2, "춘향이", 70, 70, 70));


		
		/* 학생들의 국어 성적만 출력하는 코드 작성
		 * 학생들의 영어 성적만 출력하는 코드 작성
		 * 학생들의 수학 성적만 출력하는 코드 작성
		 * 
		 */
		
//		printKor(list);
//		printEng(list);
//		printMath(list);
		
		print(list, "국어", s->s.getKor());
		print(list, "영어", s->s.getEng());
		print(list, "수학", s->s.getMath());
		print(list, "총합", s->s.getKor()+s.getEng()+s.getMath());
		
	}
	
	public static void print(ArrayList<Student> list, String subject, Function<Student, Integer> f) {
		for(Student tmp : list) {
			System.out.println(subject + " : " + f.apply(tmp));
		}
	}
	
	
	public static void printKor(ArrayList<Student> list) {
		for(Student tmp : list) {
			System.out.println("국어 : " + tmp.getKor());
		}
	}
	
	public static void printEng(ArrayList<Student> list) {
		for(Student tmp : list) {
			System.out.println("영어 : " + tmp.getEng());
		}
	}
	
	public static void printMath(ArrayList<Student> list) {
		for(Student tmp : list) {
			System.out.println("수학 : " + tmp.getMath());
		}
	}
}
