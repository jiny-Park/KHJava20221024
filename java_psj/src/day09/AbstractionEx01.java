package day09;

import java.util.Scanner;

public class AbstractionEx01 {

	public static void main(String[] args) {
		// 클래스를 통해 만든 것은 객체라고 함.
		Student std1 = new Student(1, 1, 1, "박서진");
		std1.print();
		std1.updateKor(50);
		std1.updateEng(50);
		std1.updateMath(100);
		std1.print();
		
		Student std2 = new Student(2, 2, 2, "박서진");
		std2.updateScore(40, 40, 40);
		std2.print();
		
		Student std3 = new Student(3, 3, 3, "홍길동");
		std3.updateScore(100, 100, 100);
		std3.print();
		
	}

}

/* 학생, 성적 관리 프로그램에서 필요한 학생 클래스는 만들어 보세요 */
/* 서진이 생각한 학생 성적 관리 프로그램에 들어가야 될 속성 : 이름, 나이, 성별, 반, 학년, 성적, 등급
 * 강사님 풀이 : 학년, 반, 번호, 이름, 성적을 관리하는데, 성적은 국어, 영어, 수학만 관리. 각 과목은 100점 만점을 기준으로 관리.
 * 어떤 기준을 두고 프로그램을 만드느냐에 따라 추상화가 달라지게 됨.
 * 
 * 기능 : 학생 정보 출력 기능, 
 * 		성적을 수정하는 기능(국어, 영어, 수학 -> 각각 수정 / 국어 - 영어 - 수학 -> 동시에 수정)
 * 		학생 정보의 초기값
 * 			학년 : 1, 반 : 1, 번호 : 1, 이름 : 빈문자열, 성적 : 0
 */
class Student {
	// 필드 생성
	private int grade;
	private int classNum;
	private int num;
	private String name;
	private int kor, eng, math;

	//메소드 생성
	public void print() {
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name);
		System.out.println("국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + math);
	}
	// 국어, 영어, 수학 성적을 각각 입력하는 메소드
	public void updateKor(int kor1) {
		kor = kor1;
	}
	public void updateEng(int eng1) {
		eng = eng1;
	}
	public void updateMath(int math1) {
		math = math1;
	}
	// 국어, 영어, 수학 성적을 동시에 입력할 수 있는 메소드 
	public void updateScore(int kor1, int eng1, int math1) {
		updateKor(kor1);
		updateEng(eng1);
		updateMath(math1);
	}
	
	// 생성자 생성
	public Student() {
		grade = 1;
		classNum = 1;
		num = 1;
		name = "";
	}
		// 위 아래의 코드는 오버라이딩을 통해 만들어진 생성자
	public Student(int grade1, int classNum1, int num1, String name1) {
		super();
		grade = grade1;
		classNum = classNum1;
		num = num1;
		name = name1;
	}
	
}

	

