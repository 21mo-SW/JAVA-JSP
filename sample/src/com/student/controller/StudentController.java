package com.student.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.student.model.StudentModel;
import com.student.util.StudentUtil;
import com.student.view.StudentView;

public class StudentController {
	public static void main(String[] args) {
		StudentView view = new StudentView();
		StudentModel model = new StudentModel();
		List<HashMap> scoreList = new ArrayList<HashMap>();
		
		while (true) {
			view.printTitle();
			int select = view.selectMenu();
			if (!String.valueOf(select).equals(StudentUtil.END)) {
				if (String.valueOf(select).equals(StudentUtil.INPUTSCORE)) {
					HashMap map = new HashMap();
					map.put("stuNum", view.inputStuNum());
					map.put("name", view.inputName());
					map.put("score", model.calculatorScore(view.inputScore()));
					scoreList.add(map);
				} else if (String.valueOf(select).equals(StudentUtil.PRINT)) {
					view.printInfo(scoreList);
				} else if (String.valueOf(select).equals(StudentUtil.UPDATE)) {
					String stuNum = view.inputStuNum();
					int result = model.checkStuNum(scoreList, stuNum);
					if (!String.valueOf(result).equals(StudentUtil.CHECK_FAIL)) {
						HashMap map = new HashMap();
						map.put("stuNum", stuNum);
						map.put("name", view.inputName());
						map.put("score", model.calculatorScore(view.inputScore()));
						scoreList.set(result, map);
					} else {
						System.out.println("존재하지 않는 학번입니다.");
					}
				} else if (String.valueOf(select).equals(StudentUtil.DELETE)) {
					String stuNum = view.inputStuNum();
					int result = model.checkStuNum(scoreList, stuNum);
					if (!String.valueOf(result).equals(StudentUtil.CHECK_FAIL)) {
						scoreList.remove(result);
					} else {
						System.out.println("존재하지 않는 학번입니다.");
					}
				} else if (String.valueOf(select).equals(StudentUtil.SORT_SCORE)) {
					view.printInfo(model.executeSort(scoreList,StudentUtil.SORT_SCORE));
				} else if (String.valueOf(select).equals(StudentUtil.SORT_STUNUM)) {
					view.printInfo(model.executeSort(scoreList,StudentUtil.SORT_STUNUM));
				} else if (String.valueOf(select).equals(StudentUtil.SORT_NAME)) {
					view.printInfo(model.executeSort(scoreList, StudentUtil.SORT_NAME));
				} else if (String.valueOf(select).equals(StudentUtil.SEARCH)) {
					String stuNum = view.inputStuNum();
					int result = model.checkStuNum(scoreList, stuNum);
					if (!String.valueOf(result).equals(StudentUtil.CHECK_FAIL)) {
						view.getStudentInfo(scoreList,result);
					} else {
						System.out.println("검색결과가 없습니다.");
					}
				}
			} else {
				System.out.println("종료되었습니다.");
				break;
			}
		}
	}
}
