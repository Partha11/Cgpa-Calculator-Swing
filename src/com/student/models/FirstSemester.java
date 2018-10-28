package com.student.models;

import java.util.ArrayList;

public class FirstSemester extends RootSemester {
	
	public FirstSemester() {
		
		initAll();
	}

    public FirstSemester(ArrayList<String> gradesList) {
    	
    	this.gradesList = gradesList;
    	this.initAll();
    }
    
    @Override
    public void initAll() {
    	
    	this.subjectNameList = new ArrayList<>();
    	this.subjectCodeList = new ArrayList<>();
    	
    	this.subjectNameList.add("Introduction To Computer System");
    	this.subjectNameList.add("Programming Language");
    	this.subjectNameList.add("Programming Language Practical");
    	this.subjectNameList.add("Physics");
    	this.subjectNameList.add("Differential Calculus And Geometry");
    	this.subjectNameList.add("English");
    	
    	this.subjectCodeList.add("111");
    	this.subjectCodeList.add("112");
    	this.subjectCodeList.add("113");
    	this.subjectCodeList.add("114");
    	this.subjectCodeList.add("115");
    	this.subjectCodeList.add("116");
    }
    
	@Override
	public ArrayList<String> getGradesList() {
		
		return gradesList;
	}

	@Override
	public ArrayList<String> getSubjectCodeList() {
		
		return subjectCodeList;
	}

	@Override
	public ArrayList<String> getSubjectNameList() {
		
		return subjectNameList;
	}
}