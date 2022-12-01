package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import day14.Student;

public class SortEx03 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 3));
		list.add(new Student(3, 22, 4));
		list.add(new Student(4, 1, 5));
		list.add(new Student(2, 1, 6));
		list.add(new Student(5, 1, 2));
		
		System.out.println(list);
		Collections.sort(list, new Comparator<Student>() {

			@Override	// 객체 정렬이 필요할때는 아래의 코드를 이용하여 정렬을 구현할 수 있다!
			public int compare(Student o1, Student o2) {
				if(o1.getGrade() != o2.getGrade()) {
					return o1.getGrade() - o2.getGrade();
				}
				if(o1.getClassNum() != o2.getClassNum()) {
					return o1.getClassNum() - o2.getClassNum();
				}
				return o1.getNum() - o2.getNum();
			}
			
		});
		System.out.println(list);

	}

}
