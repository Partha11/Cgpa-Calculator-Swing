package com.student.models;

import java.util.ArrayList;

public class FifthSemester extends RootSemester {

	public FifthSemester() {
		
		initAll();
	}
	
	public FifthSemester(ArrayList<String> gradesList) {
		
		this.initAll();
		this.gradesList = gradesList;
	}

	@Override
	public void initAll() {
		
		this.subjectCodeList = new ArrayList<>();
		this.subjectNameList = new ArrayList<>();

		this.subjectNameList.add("Theory Of Computation");
    	this.subjectNameList.add("Microprocessor and Assembly Language");
    	this.subjectNameList.add("Assembly Language Practical");
    	this.subjectNameList.add("Engineering Mathematics");
    	this.subjectNameList.add("Sociology");
    	this.subjectNameList.add("Technical Writing and Communication");
    	
    	this.subjectCodeList.add("311");
    	this.subjectCodeList.add("312");
    	this.subjectCodeList.add("313");
    	this.subjectCodeList.add("314");
    	this.subjectCodeList.add("315");
    	this.subjectCodeList.add("316");
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
