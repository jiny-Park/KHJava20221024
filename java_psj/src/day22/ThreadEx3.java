package day22;

public class ThreadEx3 {

	public static void main(String[] args) {
		// 동시에 여러가지 작업을 해야하는 경우 Thread를 사용한다. 
		
				// Thread는 static class임
		Thread t = Thread.currentThread();
		System.out.println("현재 쓰레드명 : " + t.getName());
		
					// class Thread01 extends Thread 와 아래의 implements Runnable의 차이는 new Thread를 가져와서 하는것이 있다.
					// 람다식 응용
		Thread t3 = new Thread(()->{
			for(int i = 0; i < 10000; i++) 
				System.out.println("-");
		});
				
		t3.start();
		for(int i = 0 ; i < 10000; i++) {
			System.out.print("|");
		}
	}

}

// 
//class Thread03 implements Runnable {
//	
//	@Override
//	public void run() {
//		for(int i = 0; i < 10000; i++) {
//			System.out.println("-");
//		}
//	}
//	
//}