package com.student.models;

import java.util.ArrayList;

public class SeventhSemester extends RootSemester {
	
	public SeventhSemester() {
		
		initAll();
	}

    public SeventhSemester(ArrayList<String> gradesList) {
    	
    	this.initAll();
    	this.gradesList = gradesList;
    }

	@Override
	public void initAll() {
		
		this.subjectNameList = new ArrayList<>();
    	this.subjectCodeList = new ArrayList<>();
    	
    	this.subjectNameList.add("Computer Networking");
    	this.subjectNameList.add("Computer Networking Practical");
    	this.subjectNameList.add("A.I. and Neural Network");
    	this.subjectNameList.add("Parallel and Distributed Processing");
    	this.subjectNameList.add("Peripheral and Interfacing");
    	this.subjectNameList.add("Peripheral and Interfacing Practical");
    	this.subjectNameList.add("Digital Signal Processing");
    	
    	this.subjectCodeList.add("411");
    	this.subjectCodeList.add("412");
    	this.subjectCodeList.add("413");
    	this.subjectCodeList.add("414");
    	this.subjectCodeList.add("415");
    	this.subjectCodeList.add("416");
    	this.subjectCodeList.add("417");
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
