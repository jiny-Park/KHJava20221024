package db.day3.service;

import java.util.Scanner;

import db.day3.DBConnector;
import db.day3.dao.*;
import db.day3.vo.LectureVO;

public class CourseServiceImp implements CourseService {

	private Scanner scan = new Scanner(System.in);
	private CourseMapper CourseDao;
	
	public CourseServiceImp(DBConnector dbConnector) {
		CourseDao = new CourseMapper(dbConnector);
	}

	public void insertLecture() {
		System.out.print("강좌명 : ");
		String le_name = scan.nextLine();
		System.out.print("일정 : ");
		String le_schedule = scan.nextLine();
		System.out.print("학점 : ");
		int le_point = scan.nextInt();
		scan.nextLine();
		System.out.print("분반 : ");
		int le_class = scan.nextInt();
		scan.nextLine();
		System.out.print("연도 : ");
		int le_year = scan.nextInt();
		scan.nextLine();
		System.out.print("학기 : ");
		String le_term = scan.nextLine();
		System.out.print("지도교수번호 :");
		String le_pr_um = scan.nextLine();
		LectureVO lecture = new LectureVO(0, le_name, le_schedule, le_point, le_class, le_year, le_term, le_pr_um);
		CourseDao.insertLecture(lecture);
	}
	

	
}
