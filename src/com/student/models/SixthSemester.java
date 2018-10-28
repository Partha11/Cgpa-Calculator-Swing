package com.student.models;

import java.util.ArrayList;

public class SixthSemester extends RootSemester {

	public SixthSemester() {
		
		initAll();
	}
	
	public SixthSemester(ArrayList<String> gradesList) {
		
		this.gradesList = gradesList;
		this.initAll();
	}

	@Override
	public void initAll() {
		
		this.subjectCodeList = new ArrayList<>();
		this.subjectNameList = new ArrayList<>();
		
		this.subjectNameList.add("Software Engineering");
    	this.subjectNameList.add("Software Engineering Practical");
    	this.subjectNameList.add("Numerical Analysis");
    	this.subjectNameList.add("Computer Graphics");
    	this.subjectNameList.add("Computer Graphics Practical");
    	this.subjectNameList.add("Compiler Design");
    	this.subjectNameList.add("Compiler Design Practical");
    	
    	this.subjectCodeList.add("321");
    	this.subjectCodeList.add("322");
    	this.subjectCodeList.add("323");
    	this.subjectCodeList.add("324");
    	this.subjectCodeList.add("325");
    	this.subjectCodeList.add("326");
    	this.subjectCodeList.add("327");
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
