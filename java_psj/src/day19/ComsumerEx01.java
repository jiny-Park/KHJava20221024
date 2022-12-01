package day19;

import java.util.ArrayList;
import java.util.function.Consumer;



public class ComsumerEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 1, "홍길동"));
		list.add(new Student(1, 1, 1, "이몽룡"));
		list.add(new Student(3, 2, 2, "춘향이"));
		list.add(new Student(4, 2, 3, "임꺽정"));
		
		print(list, (a) -> System.out.println(a));
		
		print(list, (a) -> {
			System.out.println("-------------------------");
			System.out.println("학년 : " + a.getGrade());
			System.out.println("반 : " + a.getClassNum());
			System.out.println("번호 : " + a.getNum());
			System.out.println("이름 : " + a.getName());
			System.out.println("-------------------------");
		});
		
	}
	
	
	public static void print(ArrayList<Student> list, Consumer<Student> con) {
		for(Student tmp : list) {
			con.accept(tmp);
		}
	}

}


