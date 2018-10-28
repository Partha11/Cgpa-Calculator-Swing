package com.student.models;

import java.util.ArrayList;

public class SecondSemester extends RootSemester {
	
	public SecondSemester() {
		
		initAll();
	}
	
    public SecondSemester(ArrayList<String> gradesList) {

    	this.initAll();
		this.gradesList = gradesList;
    }

	@Override
	public void initAll() {
		
		this.subjectNameList = new ArrayList<>();
    	this.subjectCodeList = new ArrayList<>();
    	
    	this.subjectNameList.add("Data Structure");
    	this.subjectNameList.add("Data Structure Practical");
    	this.subjectNameList.add("Introduction to Electrical Engineering");
    	this.subjectNameList.add("IEE Practical");
    	this.subjectNameList.add("Integral Calculus And Differential Equation");
    	this.subjectNameList.add("Statistics And Probability");
    	this.subjectNameList.add("Discrete Mathematics");
    	
    	this.subjectCodeList.add("121");
    	this.subjectCodeList.add("122");
    	this.subjectCodeList.add("123");
    	this.subjectCodeList.add("124");
    	this.subjectCodeList.add("125");
    	this.subjectCodeList.add("126");
    	this.subjectCodeList.add("127");
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