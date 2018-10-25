package com.student.models;

import java.util.ArrayList;

public class FifthSemester {

	private ArrayList<String> gradesList;
	private ArrayList<String> subjectNameList;
	private ArrayList<String> subjectCodeList;
	
	public FifthSemester(ArrayList<String> gradesList) {
		
		this.gradesList = gradesList;
		
		subjectNameList.add("Theory Of Computation");
    	subjectNameList.add("Microprocessor and Assembly Language");
    	subjectNameList.add("Assembly Language Practical");
    	subjectNameList.add("Engineering Mathematics");
    	subjectNameList.add("Sociology");
    	subjectNameList.add("Technical Writing and Communication");
    	
    	subjectCodeList.add("311");
    	subjectCodeList.add("312");
    	subjectCodeList.add("313");
    	subjectCodeList.add("314");
    	subjectCodeList.add("315");
    	subjectCodeList.add("316");
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
