package com.student.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.student.models.FirstSemester;
import com.student.models.SecondSemester;
import com.student.models.ThirdSemester;

public class DatabaseList {
	
	private Connection connection;

	public boolean initDatabase() {

        boolean isInitSuccessful;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12253493?useSSL=false", "sql12253493",
            		"513fI2VJpn");
            isInitSuccessful = true;
        }

        catch (Exception e) {

            System.out.println(e);
            isInitSuccessful = false;
        }

        return isInitSuccessful;
    }
	
public ArrayList<FirstSemester> getAllFirstSemesterStudents() {
    	
    	ArrayList<FirstSemester> studentList = null;
    	
    	if (initDatabase()) {
    		
        	try {
        		
        		String query = "SELECT * FROM FirstSemester";

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);
        		studentList = new ArrayList<>();

        		while (resultSet.next()) {
        			
        			ArrayList<String> gradesList = new ArrayList<String>();
        			
        			String reg_no = resultSet.getString("reg_no");
        			gradesList.add(resultSet.getString("111"));
        			gradesList.add(resultSet.getString("112"));
        			gradesList.add(resultSet.getString("113"));
        			gradesList.add(resultSet.getString("114"));
        			gradesList.add(resultSet.getString("115"));
        			gradesList.add(resultSet.getString("116"));

        			studentList.add(new FirstSemester(gradesList));
        		}

        		connection.close();
        	}

        	catch (SQLException e) {

        		e.printStackTrace();
        	}
    	}
    	
    	return studentList;
    }
    
	public ArrayList<SecondSemester> getAllSecondSemesterStudents() {
    	
    	ArrayList<SecondSemester> studentList = null;
    	
    	if (initDatabase()) {
    		
        	try {
        		
        		String query = "SELECT * FROM SecondSemester";

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);
        		studentList = new ArrayList<>();

        		while (resultSet.next()) {
        			
        			ArrayList<String> gradesList = new ArrayList<String>();
        			
        			String reg_no = resultSet.getString("reg_no");
        			gradesList.add(resultSet.getString("121"));
        			gradesList.add(resultSet.getString("122"));
        			gradesList.add(resultSet.getString("123"));
        			gradesList.add(resultSet.getString("124"));
        			gradesList.add(resultSet.getString("125"));
        			gradesList.add(resultSet.getString("126"));
        			gradesList.add(resultSet.getString("127"));

        			studentList.add(new SecondSemester(gradesList));
        		}

        		connection.close();
        	}

        	catch (SQLException e) {

        		e.printStackTrace();
        	}
    	}
    	
    	return studentList;
    }
	
	public ArrayList<ThirdSemester> getAllThirdSemesterStudents() {
    	
    	ArrayList<ThirdSemester> studentList = null;
    	
    	if (initDatabase()) {
    		
        	try {
        		
        		String query = "SELECT * FROM SecondSemester";

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);
        		studentList = new ArrayList<>();

        		while (resultSet.next()) {
        			
        			ArrayList<String> gradesList = new ArrayList<String>();
        			
        			String reg_no = resultSet.getString("reg_no");
        			gradesList.add(resultSet.getString("211"));
        			gradesList.add(resultSet.getString("212"));
        			gradesList.add(resultSet.getString("213"));
        			gradesList.add(resultSet.getString("214"));
        			gradesList.add(resultSet.getString("215"));
        			gradesList.add(resultSet.getString("216"));
        			gradesList.add(resultSet.getString("217"));
        			gradesList.add(resultSet.getString("218"));
        			gradesList.add(resultSet.getString("219"));

        			studentList.add(new ThirdSemester(gradesList));
        		}

        		connection.close();
        	}

        	catch (SQLException e) {

        		e.printStackTrace();
        	}
    	}
    	
    	return studentList;
    }
}
