package day10;

import java.util.Arrays;

public class BaseballGame {
	private int [] com;
	private int [] user;
	private int strike;
	private int ball;

	
	// 생성자를 만들시 어떤 변수로 할 것인지 고민.
	public BaseballGame(int []com) {
		this.com = Arrays.copyOf(com, com.length);
	}
	// 입력받은 배열을 넘겨주는 방법과, 스캐너를 자체적으로 만드는 방법으로 두 가지가 있음.
	public void setUser(int []user) {
		this.user = Arrays.copyOf(user, user.length);
		calculateResult();
	}
	// strike와 ball의 계산
	public void calculateResult() {
		calculateStrike();
		calculategetBall();
		
	}
	
	private void calculateStrike() {
		int count = 0;
		int size = com.length < user.length ? com.length : user.length;
		for(int i = 0; i < com.length; i++) {
			if(com[i] == user[i]) {
				count++;
			}
		}
		strike = count;
	}
	
	private void calculategetBall() {
		int count = 0;
		for(int i = 0; i < com.length; i++) {
			for(int j = 0; j < user.length; j++) {
				if(com[i] == user[j] && i != j) {
					count++;
				}
			}
		}
		ball = count;
	}
	
	public void printResult() {
		if(strike != 0) {
			System.out.print(strike + "S ");
		}
		if(ball != 0) {
			System.out.print(ball + "B ");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("OUT");
		}
		System.out.println();
	}
	public int getStrike() {
		return strike;
	}
	
}
