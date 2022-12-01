package day09;

public class ClassEx01 {

	public static void main(String[] args) {
		// 포인터 클래스 사용 안 했을시
		int size = 3;
		int [] x = new int[size];
		int [] y = new int[size];
		for(int i = 0; i < size; i++) {
			x[i] = i;
			y[i] = i;
		}
		
		for(int i = 0 ; i < size; i++) {
			System.out.println(x[i] + " , " + y[i]);
		}
		
		// 포인터 클래스 이용시
		Point [] pts= new Point[size];	// 좌표들을 저장할 배열을 할당
		for(int i = 0; i < size; i++) {
			pts[i] = new Point(i, i); 	// 좌표 하나를 저장할 객체를 생성
		}
		for(Point pt : pts) {
			pt.print();
		}
	}

}

class Point{
	private int x, y;
	
	public Point() {}	// 멤버변수는 초기화가 되기 때문에, 생성자에 다시 초기화를 해줄 필요가 없다. 
	public Point(int x1, int y1) {
		x = x1;
		y = y1;
	}
	public void print() {
		System.out.println(x + " , " + y);
	}
	public void move(int x1, int y1) {
		x = x1;
		y = y1;
	}
	
}
