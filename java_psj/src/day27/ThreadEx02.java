package day27;

public class ThreadEx02 {

	public static void main(String[] args) {
		Runnable runnable = new NewThread2();
		Thread t = new Thread(runnable); //Thread t = new Thread(new NewThread2());
		
		t.start();
		Thread thisThread = Thread.currentThread();
		for(int i = 0; i < 20; i++) {
			System.out.println(thisThread.getName()+" 쓰레드 실행");
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	// 해당쓰레드를 1초를 멈춰줌.
		}
	}

}

class NewThread2 implements Runnable {		// 오로지 run이라는 메소드명 밖에 없기데 this.getName()을 사용 못함
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("쓰레드 실행");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	// 해당쓰레드를 1초를 멈춰줌.	
		}
	}
}
