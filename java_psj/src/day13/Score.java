package day13;


public class Score {
	// 필드 : 과목, 학기, 중간, 기말, 수행평가, 총점
	private String title;
	private int term, midScore, finalScore, perfomance;
	private double total;
	private double midRate = 0.4, finalRate = 0.5, perfomanceRate = 0.1;
	
	
	// 메소드 : equals() : 성적 추가시 활용, toString() : 성적 출력시 활용, getter/setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public int getMidScore() {
		return midScore;
	}
	public void setMidScore(int midScore) {
		this.midScore = midScore;
	}
	public int getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(int fanalScore) {
		this.finalScore = fanalScore;
	}
	public int getPerfomance() {
		return perfomance;
	}
	public void setPerfomance(int perfomance) {
		this.perfomance = perfomance;
	}
	public double getTatal() {
		return total;
	}
	public void setTatal(double tatal) {
		this.total = tatal;
	}
	
	@Override
	public String toString() {
		return "[" + term + "학기 " + title +  ", 중간점수 : " + midScore + ", 기말점수 : " + finalScore + ", 수행평가 : " + perfomance + ", 총점 : " + total+ "]" ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		if (term != other.term)
			return false;
		return true;
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

