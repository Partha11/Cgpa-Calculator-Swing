package com.student.models;

import java.util.ArrayList;

public class SixthSemester {

	private ArrayList<String> gradesList;
	private ArrayList<String> subjectNameList;
	private ArrayList<String> subjectCodeList;
	
	public SixthSemester(ArrayList<String> gradesList) {
		
		this.gradesList = gradesList;
		
		subjectNameList.add("Software Engineering");
    	subjectNameList.add("Software Engineering Practical");
    	subjectNameList.add("Numerical Analysis");
    	subjectNameList.add("Computer Graphics");
    	subjectNameList.add("Computer Graphics Practical");
    	subjectNameList.add("Compiler Design");
    	subjectNameList.add("Compiler Design Practical");
    	
    	subjectCodeList.add("321");
    	subjectCodeList.add("322");
    	subjectCodeList.add("323");
    	subjectCodeList.add("324");
    	subjectCodeList.add("325");
    	subjectCodeList.add("326");
    	subjectCodeList.add("327");
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
