package com.student.models;

import java.util.ArrayList;

public class SecondSemester {
	
	private ArrayList<String> gradesList;
	private ArrayList<String> subjectNameList;
	private ArrayList<String> subjectCodeList;

    public SecondSemester(ArrayList<String> gradesList) {

this.gradesList = gradesList;
    	
    	subjectNameList = new ArrayList<>();
    	subjectCodeList = new ArrayList<>();
    	
    	subjectNameList.add("Data Structure");
    	subjectNameList.add("Data Structure Practical");
    	subjectNameList.add("Introduction to Electrical Engineering");
    	subjectNameList.add("Introduction to Electrical Engineering Practical");
    	subjectNameList.add("Integral Calculus And Differential Equation");
    	subjectNameList.add("Statistics And Probability");
    	subjectNameList.add("Discrete Mathematics");
    	
    	subjectCodeList.add("121");
    	subjectCodeList.add("122");
    	subjectCodeList.add("123");
    	subjectCodeList.add("124");
    	subjectCodeList.add("125");
    	subjectCodeList.add("126");
    	subjectCodeList.add("127");
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