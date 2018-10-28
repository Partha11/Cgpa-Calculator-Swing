package com.student.models;

import java.util.ArrayList;

public abstract class RootSemester {

	protected ArrayList<String> gradesList;
	protected ArrayList<String> subjectNameList;
	protected ArrayList<String> subjectCodeList;
	
    public abstract ArrayList<String> getGradesList();
    public abstract ArrayList<String> getSubjectCodeList();
    public abstract ArrayList<String> getSubjectNameList();
    public abstract void initAll();
}
