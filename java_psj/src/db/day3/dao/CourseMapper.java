package db.day3.dao;

import java.sql.SQLException;

import db.day3.DBConnector;
import db.day3.vo.LectureVO;

public class CourseMapper implements CourseDAO {
	
	private DBConnector dbConnector;
	
	public CourseMapper(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	public void insertLecture(LectureVO lecture) {
String sql = "insert into lecture(le_name, le_schedule, le_point, le_class, le_year, le_tern, le_pr_num) values(?, ?, ?, ?, ?, ?, ?)";

		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setString(1, lecture.getLe_name());
			dbConnector.pstmt.setString(2, lecture.getLe_schedule());
			dbConnector.pstmt.setInt(3, lecture.getLe_point());
			dbConnector.pstmt.setInt(4, lecture.getLe_class());
			dbConnector.pstmt.setInt(5, lecture.getLe_year());
			dbConnector.pstmt.setString(6, lecture.getLe_tern());
			dbConnector.pstmt.setString(7, lecture.getLe_pr_num());
			int count = dbConnector.pstmt.executeUpdate();
			if(count == 0) 
				System.out.println("학생 정보 추가 실패");
			else
				System.out.println("학생 정보 추가 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}
}
