package com.student.models;

import java.util.ArrayList;

public class FourthSemester extends RootSemester {
	
	public FourthSemester() {
		
		initAll();
	}

	public FourthSemester(ArrayList<String> gradesList) {
		
		this.gradesList = gradesList; 
		this.initAll();
	}

	@Override
	public void initAll() {

		this.subjectCodeList = new ArrayList<>();
		this.subjectNameList = new ArrayList<>();
		
		this.subjectNameList.add("Algorithm Design");
    	this.subjectNameList.add("Algorithm Design Practical");
    	this.subjectNameList.add("Database Management System");
    	this.subjectNameList.add("DBMS Practical");
    	this.subjectNameList.add("Computer Organization and Architecture");
    	this.subjectNameList.add("Data Communication");
    	this.subjectNameList.add("Economics");
    	
    	this.subjectCodeList.add("221");
    	this.subjectCodeList.add("222");
    	this.subjectCodeList.add("223");
    	this.subjectCodeList.add("224");
    	this.subjectCodeList.add("225");
    	this.subjectCodeList.add("226");
    	this.subjectCodeList.add("227");
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
