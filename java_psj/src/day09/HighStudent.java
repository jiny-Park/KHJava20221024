package day09;

public class HighStudent {
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
		public HighStudent() {
			this(1, 1, 1, "");
		}
			// 위 아래의 코드는 오버라이딩을 통해 만들어진 생성자
		public HighStudent(int grade1, int classNum1, int num1, String name1) {
			super();
			grade = grade1;
			classNum = classNum1;
			num = num1;
			name = name1;
		}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

