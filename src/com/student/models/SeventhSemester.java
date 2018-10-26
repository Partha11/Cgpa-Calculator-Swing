package com.student.models;

import java.util.ArrayList;

public class SeventhSemester {

	private ArrayList<String> gradesList;
	private ArrayList<String> subjectNameList;
	private ArrayList<String> subjectCodeList;

    public SeventhSemester(ArrayList<String> gradesList) {
    	
    	this.gradesList = gradesList;
    	
    	subjectNameList = new ArrayList<>();
    	subjectCodeList = new ArrayList<>();
    	
    	subjectNameList.add("Computer Networking");
    	subjectNameList.add("Computer Networking Practical");
    	subjectNameList.add("A.I. and Neural Network");
    	subjectNameList.add("Parallel and Distributed Processing");
    	subjectNameList.add("Peripheral and Interfacing");
    	subjectNameList.add("Peripheral and Interfacing Practical");
    	subjectNameList.add("Digital Signal Processing");
    	
    	subjectCodeList.add("411");
    	subjectCodeList.add("412");
    	subjectCodeList.add("413");
    	subjectCodeList.add("414");
    	subjectCodeList.add("415");
    	subjectCodeList.add("416");
    	subjectCodeList.add("417");
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
