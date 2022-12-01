package day14;

import java.util.Calendar;

public class CalendarEx01 {

	public static void main(String[] args) {
		/* Calendar 클래스 : 날짜와 관련된 클래스
		 * get()을 통해서 년도, 월, 일, 시, 분, 초등 다양한 정보를 가져옴.
		 */
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		cal.add(Calendar.YEAR, 1);	// 1년 추가한 것, -1 1년 전
		// Date 클래스는 일년 전, 일주일 전 등 출력하는게 어려움.
		// Date의 장점을 출력하기 편하고 Calendar을 특정 위치의 날짜를 추출하기가 편함.
		
		int year = cal.get(Calendar.YEAR);	// 기울어진 -> 클래스, 굵은 글씨 -> 상수
		System.out.println(year + "년도");
		int month = cal.get(Calendar.MONTH)+1; // MONTH는 0월부터 시작하니 +1을 해줘야함.
		System.out.println(month + "월");
		int day = cal.get(Calendar.DATE);
		System.out.println(day + "일");
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour + "시");
		int min = cal.get(Calendar.MINUTE);
		System.out.println(min + "분");
		int sec = cal.get(Calendar.SECOND);
		System.out.println(sec + "초");
		
	}

}
