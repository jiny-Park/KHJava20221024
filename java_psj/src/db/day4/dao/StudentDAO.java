package db.day4.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.day4.vo.CourseVO;
import db.day4.vo.StudentVO;

public interface StudentDAO {
	
	ArrayList<StudentDAO> selectAllStudent();
	// 매개변수가 두 개인 경우에는 @Param을 꼭 붙여줘야 함!
	int insertStudent(@Param("std")StudentVO std);
	void insertCourse(CourseVO co);
}
