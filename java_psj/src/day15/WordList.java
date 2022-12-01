package day15;

import lombok.Data;

@Data
public class WordList {
	private String word;
	private String mean;
	
	public WordList(String word, String mean) {
		this.word = word;
		this.mean = mean;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordList other = (WordList) obj;
		if (mean == null) {
			if (other.mean != null)
				return false;
		} else if (!mean.equals(other.mean))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mean == null) ? 0 : mean.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "WordList [단어 : " + word + ", 뜻 : " + mean + "]";
	}

	public WordList(String word) {
		this.word = word;
	}
	
	
	// 생성자는 왜 소스에서 빼지 않아도 될까?????
	

}
