package db.day3.dao;

import db.day3.vo.StudentVO;

public interface StudentDAO {
	
	public void insertStudent(StudentVO std);
	public void updateStudent(StudentVO std);
}
