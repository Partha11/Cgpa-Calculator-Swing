package com.student.models;

import java.util.ArrayList;

public class EighthSemester {

	private ArrayList<String> gradesList;
	private ArrayList<String> subjectNameList;
	private ArrayList<String> subjectCodeList;

    public EighthSemester(ArrayList<String> gradesList) {
    	
    	this.gradesList = gradesList;
    	
    	subjectNameList = new ArrayList<>();
    	subjectCodeList = new ArrayList<>();
    	
    	subjectNameList.add("Web Engineering");
    	subjectNameList.add("Web Engineering Practical");
    	subjectNameList.add("Computer Network and Security");
    	subjectNameList.add("Elective Course");
    	subjectNameList.add("Project");
    	
    	subjectCodeList.add("421");
    	subjectCodeList.add("422");
    	subjectCodeList.add("423");
    	subjectCodeList.add("42x");
    	subjectCodeList.add("429");
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
