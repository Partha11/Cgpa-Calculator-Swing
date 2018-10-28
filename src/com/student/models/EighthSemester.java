package com.student.models;

import java.util.ArrayList;

public class EighthSemester extends RootSemester {

	public EighthSemester() {
		
		initAll();
	}

    public EighthSemester(ArrayList<String> gradesList) {
    	
    	this.initAll();
    	this.gradesList = gradesList;
    }

	@Override
	public void initAll() {
		
		this.subjectNameList = new ArrayList<>();
    	this.subjectCodeList = new ArrayList<>();
    	
    	this.subjectNameList.add("Web Engineering");
    	this.subjectNameList.add("Web Engineering Practical");
    	this.subjectNameList.add("Computer Network and Security");
    	this.subjectNameList.add("Elective Course");
    	this.subjectNameList.add("Project");
    	
    	this.subjectCodeList.add("421");
    	this.subjectCodeList.add("422");
    	this.subjectCodeList.add("423");
    	this.subjectCodeList.add("42x");
    	this.subjectCodeList.add("429");
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
