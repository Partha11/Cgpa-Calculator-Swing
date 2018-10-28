package com.student.models;

import java.util.ArrayList;

public class ThirdSemester extends RootSemester {
	
	public ThirdSemester() {
		
		initAll();
	}
	
    public ThirdSemester(ArrayList<String> gradesList) {

    	this.initAll();
		this.gradesList = gradesList;
    }

	@Override
	public void initAll() {
		
		this.subjectNameList = new ArrayList<>();
		this.subjectCodeList = new ArrayList<>();
    	
		this.subjectNameList.add("Object Oriented Programming");
		this.subjectNameList.add("OOP Practical");
		this.subjectNameList.add("Operating System");
		this.subjectNameList.add("Digital Logic Design");
		this.subjectNameList.add("DLD Practical");
		this.subjectNameList.add("Mathematics For CSE");
		this.subjectNameList.add("Electronic Device And Circuits");
		this.subjectNameList.add("EDC Practical");
		this.subjectNameList.add("Basic Accounting");
    	
		this.subjectCodeList.add("211");
		this.subjectCodeList.add("212");
		this.subjectCodeList.add("213");
		this.subjectCodeList.add("214");
		this.subjectCodeList.add("215");
		this.subjectCodeList.add("216");
		this.subjectCodeList.add("217");
		this.subjectCodeList.add("218");
		this.subjectCodeList.add("219");
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