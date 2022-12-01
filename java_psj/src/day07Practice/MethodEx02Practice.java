package day07Practice;

public class MethodEx02Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		multiplicationTables(5, 1, 5);
	}
	
	// 두 정수의 곱하기 가능 기능 함수
	// 기능 : 단과 시작정수, 끝정수까지 총 3개의 정수를 입력하여 원하는 단과 단수를 출력할 수 있도록
	// 매개변수 : 단, 시작정수, 끝정수 => int num, int start, int end
	// 리턴타입 : 없음 => void
	// 메소드명 : multiplicationTables
	public static void multiplicationTables(int num, int start, int end) {
		for(int i = start; i < end; i++) {
			System.out.println(num + " * " + i + " = " + (num * i));
		}
	}

}
