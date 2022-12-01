package day08;

public class ClassEx01 {

	public static void main(String[] args) {
		//기본 생성자 호출
		Point pt = new Point();
		pt.print();
		pt.move(5, 3);
		pt.print();
		
		//생성자 오버로딩 호출
		Point pt1 = new Point(3,1);
		pt1.print();
		
		//복사 생성자 호출(생성자 오버로딩)
		Point pt2 = new Point(pt1);
		pt2.print();
	}

}

/* 2차원 좌표평면의 점을 나타내는 클래스
 * - 필드 :
 * 		x좌표, y좌표
 * - 메소드(기능)
 * 		좌표 출력 기능 
 * 		좌표 이동 기능
 */

class Point{
	private int x, y; // 필드는 이클립스 에디터에서 파란색으로 표시됨
					  // 필드변수 = 멤버변수 -> class안에 존재
	
	public void print() {
		System.out.println("좌표 : " + x + " , " + y);
	}
	
	public void move(int x1, int y1) {
		// 일반적으로 필드의 값을 바꾸는 경우에는 리턴의 값이 void라고 생각.
		// 지역변수 -> 메소드나 생성자 안에 존재.
		x = x1;
		y = y1;
	}
	
	// 생성자의 역활 : 필드를 초기화!
	public Point() {
		x = 3;
		y = 3;
	}
	public Point(int x1, int y1) {
		x = x1;
		y = y1;
	}
	public Point(Point pt) {
		x = pt.x;
		y = pt.y;
	} 
}
