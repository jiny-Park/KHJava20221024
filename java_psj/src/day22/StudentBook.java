package day22;

import java.util.ArrayList;

import lombok.Data;

@Data
public class StudentBook {
	private String name, dOb;
	ArrayList<StudentBook> list;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentBook other = (StudentBook) obj;
		if (dOb == null) {
			if (other.dOb != null)
				return false;
		} else if (!dOb.equals(other.dOb))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dOb == null) ? 0 : dOb.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public StudentBook(String name, String dOb) {
		this.name = name;
		this.dOb = dOb;
	}

	@Override
	public String toString() {
		return "StudentBook [name=" + name + ", dOb=" + dOb + "]";
	}
	
	public void printStudent() {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + ". " + list.get(i).toString());
		}
	}

	public void update(String name, String dOb) {
		this.name = name;
		this.dOb = dOb;
		
	}
	

	
	
}
