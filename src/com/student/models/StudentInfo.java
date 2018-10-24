package com.student.models;

public class StudentInfo {

	private String studentRegNo;
    private String studentRoll;
    private String studentName;
    private String studentBatch;

    public StudentInfo(String studentRegNo, String studentRoll, String studentName, String studentBatch) {

        this.studentRegNo = studentRegNo;
        this.studentRoll = studentRoll;
        this.studentName = studentName;
        this.studentBatch = studentBatch;
    }

    public String getStudentRegNo() {

        return studentRegNo;
    }

    public String getStudentRoll() {

        return studentRoll;
    }

    public String getStudentName() {

        return studentName;
    }

    public String getStudentBatch() {

        return studentBatch;
    }
    
    public void setStudentBatch(String studentBatch) {
		
    	this.studentBatch = studentBatch;
	}
}
