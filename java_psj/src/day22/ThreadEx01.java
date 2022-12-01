package day22;

public class ThreadEx01 {

	public static void main(String[] args) {
		// 동시에 여러가지 작업을 해야하는 경우 Thread를 사용한다. 
		
				// Thread는 static class임
		Thread t = Thread.currentThread();
		System.out.println("현재 쓰레드명 : " + t.getName());
		
		Thread01 t1 = new Thread01();
		t1.start();
		for(int i = 0 ; i < 10000; i++) {
			System.out.print("|");
		}
	}

}

// 기본적으로 Thread안에 run은 비어있음.
class Thread01 extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.println("-");
		}
	}
	
}