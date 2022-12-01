package day14;

import lombok.Data;

@Data
public class Score {
	// 필드 : 과목, 학기, 중간, 기말, 수행평가, 총점
	private String title;
	private int term, midScore, finalScore, perfomance;;
	private double total;
	private double midRate = 0.4, finalRate = 0.5, perfomanceRate = 0.1;
	
	// 메소드 : equals() : 성적 추가시 활용, toString() : 성적 출력시 활용, getter/setter
	@Override
	public String toString() {
		return "[" + term + "학기 " + title +  ", 중간점수 : " + midScore + ", 기말점수 : " + finalScore + ", 수행평가 : " + perfomance + ", 총점 : " + total+ "]" ;
	}
	
	@Override // 성적을 학기와 타이틀을 이용해야 하기 때문에 오버라이딩 해줘야함 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (term != other.term)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + term;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	
	
	
	// 생성자 : 과목, 학기, 중간, 기말, 수행평가가 필요한 생성자
	public Score(String title, int term, int midScore, int finalScore, int perfomance) {
		this.title = title;
		this.term = term;
		this.midScore = midScore;
		this.finalScore = finalScore;
		this.perfomance = perfomance;
		this.total = midRate*midScore + finalScore*finalRate + perfomance*perfomanceRate;
	}
	// 생성자 : 과목, 학기가 필요한 생성자(성적이 같은지 확인할 때)
	public Score(String title, int term) {
		this.title = title;
		this.term = term;
	}
	
	//복사 생성자
	public Score(Score s) {
		this(s.title, s.term, s.midScore, s.finalScore, s.perfomance);

	}

	
}

