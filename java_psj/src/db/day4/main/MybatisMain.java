package db.day4.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.day4.dao.StudentDAO;
import db.day4.vo.CourseVO;
import db.day4.vo.StudentVO;

public class MybatisMain {

	public static void main(String[] args) {
		String resource = "db/day4/main/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			try (SqlSession session = sqlSessionFactory.openSession()) {
				 StudentDAO studentDAO = session.getMapper(StudentDAO.class);
				 ArrayList<StudentDAO> list = studentDAO.selectAllStudent();
				 System.out.println(list);
				 //StudentVO std = new StudentVO("2022123002", "콩콩", 2, "재학", "2022160001");
				 //studentDAO.insertStudent(std);
				 
				 CourseVO co = new CourseVO("2022123001", 1, "학점");
				 studentDAO.insertStudent(co);
				 
				 session.commit();
				
				}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
