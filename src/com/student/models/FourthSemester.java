package com.student.models;

import java.util.ArrayList;

public class FourthSemester {

	private ArrayList<String> gradesList;
	private ArrayList<String> subjectNameList;
	private ArrayList<String> subjectCodeList;
	
	public FourthSemester(ArrayList<String> gradesList) {
		
		this.gradesList = gradesList;
		
		subjectNameList.add("Algorithm Design");
    	subjectNameList.add("Algorithm Design Practical");
    	subjectNameList.add("Database Management System");
    	subjectNameList.add("Database Management System Practical");
    	subjectNameList.add("Computer Organization and Architecture");
    	subjectNameList.add("Data Communication");
    	subjectNameList.add("Economics");
    	
    	subjectCodeList.add("221");
    	subjectCodeList.add("222");
    	subjectCodeList.add("223");
    	subjectCodeList.add("224");
    	subjectCodeList.add("225");
    	subjectCodeList.add("226");
    	subjectCodeList.add("227");    	
	}

	public ArrayList<String> getGradesList() {
		
		return gradesList;
	}

	public ArrayList<String> getSubjectNameList() {
		
		return subjectNameList;
	}

	public ArrayList<String> getSubjectCodeList() {
		
		return subjectCodeList;
	}
}
