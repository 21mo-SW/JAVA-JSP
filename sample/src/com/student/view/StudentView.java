package com.student.view;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StudentView {
	private Scanner scan = null;
	public static void printTitle() {
		System.out.println("실행 할 메뉴를 선택하세요 : 1.입력 2.전체 출력 3.수정 4.삭제 5.성적순 정렬 6.학번순 정렬 7.이름순 정렬 8.검색 9.종료");
	}
	
	public StudentView() {
		scan = new Scanner (System.in);
	}
	
	public int selectMenu() {
		return scan.nextInt();
	}
	
	public int inputScore() {
		System.out.println("점수를 입력하세요 : ");
		return scan.nextInt();
	}
	
	public String inputStuNum() {
		System.out.println("학번을 입력하세요 : ");
		return scan.next();
	}
	
	public String inputName() {
		System.out.println("이름을 입력하세요 : ");
		return scan.next();
	}
	
	public void printInfo(List<HashMap> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("=================");
			System.out.println("학번 : "+ list.get(i).get("stuNum"));
			System.out.println("이름 : " + list.get(i).get("name"));
			System.out.println("성적 : " + list.get(i).get("score"));
			System.out.println("=================");
		}
		
	}
	
	public void getStudentInfo(List<HashMap> list,int index) {
		System.out.println("=================");
		System.out.println("학번 : "+ list.get(index-1).get("stuNum"));
		System.out.println("이름 : " + list.get(index-1).get("name"));
		System.out.println("성적 : " + list.get(index-1).get("score"));
		System.out.println("=================");
	}
}
