package com.student.models;

public class StudentInfo {

	private String studentRegNo;
    private String studentSession;
    private String studentName;
    private String studentBatch;
    
    public StudentInfo(String studentRegNo, String studentName, String studentSession) {

        this.studentRegNo = studentRegNo;
        this.studentName = studentName;
        this.studentSession = studentSession;
    }

    public StudentInfo(String studentRegNo, String studentSession, String studentName, String studentBatch) {

        this.studentRegNo = studentRegNo;
        this.studentSession = studentSession;
        this.studentName = studentName;
        this.studentBatch = studentBatch;
    }

    public String getStudentRegNo() {

        return studentRegNo;
    }

    public String getStudentSession() {

        return studentSession;
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
