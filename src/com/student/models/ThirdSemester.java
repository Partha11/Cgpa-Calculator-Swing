package com.student.models;

import java.util.ArrayList;

public class ThirdSemester {
	
	private ArrayList<String> gradesList;
	private ArrayList<String> subjectNameList;
	private ArrayList<String> subjectCodeList;

    private String cse211;
    private String cse212;
    private String cse213;
    private String cse214;
    private String cse215;
    private String cse216;
    private String cse217;
    private String cse218;

    public ThirdSemester(ArrayList<String> gradesList) {

this.gradesList = gradesList;
    	
    	subjectNameList = new ArrayList<>();
    	subjectCodeList = new ArrayList<>();
    	
    	subjectNameList.add("Object Oriented Programming");
    	subjectNameList.add("Object Oriented Programming Practical");
    	subjectNameList.add("Operating System");
    	subjectNameList.add("Digital Logic Design");
    	subjectNameList.add("Digital Logic Design Practical");
    	subjectNameList.add("Mathematics For CSE");
    	subjectNameList.add("Electronic Device And Circuits");
    	subjectNameList.add("Electronic Device And Circuits Practical");
    	subjectNameList.add("Basic Accounting");
    	
    	subjectCodeList.add("211");
    	subjectCodeList.add("212");
    	subjectCodeList.add("213");
    	subjectCodeList.add("214");
    	subjectCodeList.add("215");
    	subjectCodeList.add("216");
    	subjectCodeList.add("217");
    	subjectCodeList.add("218");
    	subjectCodeList.add("219");
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