package com.student.storage;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.fabric.xmlrpc.base.Array;
import com.student.models.*;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Database {

	private Connection connection;
	
	private FileOperation fileOperation;
	
	public static final String STUDENTINFO = "StudentInfo";
	public static final String STUDENTBATCH = "batch";
	public static final String STUDENTREGNO = "reg_no";
	public static final String STUDENTROLLNO = "roll_no";
	
	public Database() {
		
		fileOperation = new FileOperation();
	}

    public boolean insert(StudentInfo studentInfo) {

        boolean isSuccessful;

        if (initDatabase())

            isSuccessful = insertStudentData(studentInfo);

        else

            isSuccessful = false;

        return isSuccessful;
    }
    
    public StudentInfo getSingleStudent(String regNo) {
    	
    	if (initDatabase())
    		
    		return getStudentData(regNo);
    	
    	else
    		
    		return null;
    }

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
    
    public void updateStudentBatch(StudentInfo studentInfo) {
    	
    	if (initDatabase()) {
    	
    		try {

    			String query = "UPDATE " + STUDENTINFO + " SET " + STUDENTBATCH + " = ? " + 
    					"WHERE " + STUDENTREGNO + " = ?";

    			PreparedStatement preparedStatement = connection.prepareStatement(query);

    			preparedStatement.setString(1, studentInfo.getStudentBatch());
    			preparedStatement.setString(2, studentInfo.getStudentRegNo());
    			int rowChanged = preparedStatement.executeUpdate();

    			System.err.println(String.valueOf(rowChanged));
    		}

    		catch (SQLException e) {

    			e.printStackTrace();
    		}
    	}
    }

    private boolean insertStudentData(StudentInfo studentInfo) {

        boolean isInserted;

        try {

            String query = "INSERT INTO " + STUDENTINFO + "(reg_no, roll_no, name, batch)" + " values(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, studentInfo.getStudentRegNo());
            preparedStatement.setString(2, studentInfo.getStudentRoll());
            preparedStatement.setString(3, studentInfo.getStudentName());
            preparedStatement.setString(4, studentInfo.getStudentBatch());

            isInserted = preparedStatement.execute();
            connection.close();
        }

        catch (SQLException e) {

            System.out.println(e);
            isInserted = false;
        }

        return isInserted;
    }
    
    private StudentInfo getStudentData(String regNo) {
    	
    	StudentInfo studentInfo = null;
    	
    	try {

            String query = "SELECT * FROM " + STUDENTINFO + " WHERE reg_no = " + regNo;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                
                String reg_no = resultSet.getString("reg_no");
                String roll_no = resultSet.getString("roll");
                String batch = resultSet.getString("session");
                String name = resultSet.getString("name");
                
                studentInfo = new StudentInfo(reg_no, roll_no, name, batch);
            }

            connection.close();
        }
    	
    	catch (SQLException e) {

            e.printStackTrace();
            
            studentInfo = null;
        }
    	
    	return studentInfo;
    }

    public FirstSemester getFirstSemesterData(String regNo) {

        FirstSemester firstSemester = null;
        
        if (initDatabase()) {

        	try {

        		String query = "SELECT * FROM FirstSemester WHERE reg_no = " + regNo;

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);

        		while (resultSet.next()) {
        			
        			ArrayList<String> gradesList = new ArrayList<String>();
        			
        			String reg_no = resultSet.getString("reg_no");
        			gradesList.add(resultSet.getString("111"));
        			gradesList.add(resultSet.getString("112"));
        			gradesList.add(resultSet.getString("113"));
        			gradesList.add(resultSet.getString("114"));
        			gradesList.add(resultSet.getString("115"));
        			gradesList.add(resultSet.getString("116"));

        			firstSemester = new FirstSemester(gradesList);
        		}

        		connection.close();
        	}

        	catch (SQLException e) {

        		e.printStackTrace();
        	}
        }

        return firstSemester;
    }
    
    public SecondSemester getSecondSemesterData(String regNo) {

        SecondSemester secondSemester = null;
        
        if (initDatabase()) {

        	try {

        		String query = "SELECT * FROM SecondSemester WHERE reg_no = " + regNo;

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);

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

        			secondSemester = new SecondSemester(gradesList);
        		}

        		connection.close();
        	}

        	catch (SQLException e) {

        		e.printStackTrace();
        	}
        }

        return secondSemester;
    }
    
    public ThirdSemester getThirdSemesterData(String regNo) {

        ThirdSemester thirdSemester = null;
        
        if (initDatabase()) {

        	try {

        		String query = "SELECT * FROM ThirdSemester WHERE reg_no = " + regNo;

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);

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

        			thirdSemester = new ThirdSemester(gradesList);
        		}

        		connection.close();
        	}

        	catch (SQLException e) {

        		e.printStackTrace();
        	}
        }

        return thirdSemester;
    }
}
