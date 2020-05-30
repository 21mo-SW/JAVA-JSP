package com.student.model;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.student.util.StudentUtil;

public class StudentModel {
	
	public String calculatorScore(int score) {
		if (score >= 90) {
			return "A";
		} else if (score >= 80) {
			return "B";
		} else if (score >= 70) {
			return "C";
		} else if (score >= 60) {
			return "D";
		} else {
			return "F";
		}
	}
	
	public int checkStuNum(List<HashMap> scoreList,String stuNum) {
		int result = 0;
		for (int i = 0; i < scoreList.size(); i++) {
			if (scoreList.get(i).get("stuNum").equals(stuNum)){
				result = (i+1);
			}
		}
		return result;
	}
	
	public List<HashMap> executeSort(List<HashMap> scoreList,String sortType) {
		
		if (sortType.equals(StudentUtil.SORT_SCORE))
			return scoreList = scoreList.stream().sorted((o1,o2) -> o1.get("score").toString().compareTo(o2.get("score").toString())).collect(Collectors.toList());
		else if (sortType.equals(StudentUtil.SORT_STUNUM)) {
			return scoreList = scoreList.stream().sorted((o1,o2) -> o1.get("stuNum").toString().compareTo(o2.get("stuNum").toString())).collect(Collectors.toList());
		} else {
			return scoreList = scoreList.stream().sorted((o1,o2) -> o1.get("name").toString().compareTo(o2.get("name").toString())).collect(Collectors.toList());
		}
	}
	
	
	
}
