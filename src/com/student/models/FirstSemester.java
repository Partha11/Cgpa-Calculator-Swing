package com.student.models;

import java.util.ArrayList;

public class FirstSemester {
	
	private ArrayList<String> gradesList;
	private ArrayList<String> subjectNameList;
	private ArrayList<String> subjectCodeList;

    public FirstSemester(ArrayList<String> gradesList) {
    	
    	this.gradesList = gradesList;
    	
    	subjectNameList = new ArrayList<>();
    	subjectCodeList = new ArrayList<>();
    	
    	subjectNameList.add("Introduction To Computer System");
    	subjectNameList.add("Programming Language");
    	subjectNameList.add("Programming Language Practical");
    	subjectNameList.add("Physics");
    	subjectNameList.add("Differential Calculus And Geometry");
    	subjectNameList.add("English");
    	
    	subjectCodeList.add("111");
    	subjectCodeList.add("112");
    	subjectCodeList.add("113");
    	subjectCodeList.add("114");
    	subjectCodeList.add("115");
    	subjectCodeList.add("116");
    }
    
    public ArrayList<String> getGradesList() {
		
    	return gradesList;
	}
    
    public ArrayList<String> getSubjectCodeList() {
		
    	return subjectCodeList;
	}
    
    public ArrayList<String> getSubjectNameList() {
		
    	return subjectNameList;
	}
}