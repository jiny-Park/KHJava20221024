package day11Practice;

import day03.ifEx01;

public class day11PracticeEx03 {

	public static void main(String[] args) {
		// String 예제 2.
		// 주어진 파일명들 중에서 이미지 파일들을 찾아 파일명을 출력
		// 이미지 파일 확장자는 jpg, png
		
		String [] list = {
				"이미지.jpg", "음악1.mp3", "이미지2.mp4", "이미지3.png", "예제.txt"
		};
		
		for(String tmp : list) {
			// 확장자 추출
			int index = tmp.lastIndexOf(".");
			String extension = tmp.substring(index);
			// 확장자가 이미지 확장자인지 확인하여 맞으면 파일명 출력
			if(extension.equals(".jpg") || extension.equals(".png")) {
				System.out.println(tmp);
			}
		}
	
		for(String mp : list) {
			int index1 = mp.lastIndexOf(".");
			String extension1 = mp.substring(index1);
			if(extension1.equals(".jpg") || extension1.equals(".png")) {
				System.out.println(mp);
			}
		} 
		
		for(String mp2 : list) {
			int index2 = mp2.lastIndexOf(".");
			String extension2 = mp2.substring(index2);
			if(extension2.equals(".jpg") || extension2.equals(".png")) {
				System.out.println(mp2);
			}
		} 
		
		for(String mp3 : list) {
			int index3 = mp3.lastIndexOf(".");
			String extension3 = mp3.substring(index3);
			if(extension3.equals(".jpg") || extension3.equals("png")) {
				System.out.println(mp3);
			}
		} 
		
	}

}
