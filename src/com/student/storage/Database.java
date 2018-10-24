package com.student.storage;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.fabric.xmlrpc.base.Array;
import com.student.models.*;

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

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students?useSSL=false", "root", "");
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
                String roll_no = resultSet.getString("roll_no");
                String batch = resultSet.getString("batch");
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
        			gradesList.add(resultSet.getString("cse111"));
        			gradesList.add(resultSet.getString("cse112"));
        			gradesList.add(resultSet.getString("cse113"));
        			gradesList.add(resultSet.getString("cse114"));
        			gradesList.add(resultSet.getString("cse115"));
        			gradesList.add(resultSet.getString("cse116"));

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
        			gradesList.add(resultSet.getString("cse121"));
        			gradesList.add(resultSet.getString("cse122"));
        			gradesList.add(resultSet.getString("cse123"));
        			gradesList.add(resultSet.getString("cse124"));
        			gradesList.add(resultSet.getString("cse125"));
        			gradesList.add(resultSet.getString("cse126"));
        			gradesList.add(resultSet.getString("cse127"));

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
        			gradesList.add(resultSet.getString("cse211"));
        			gradesList.add(resultSet.getString("cse212"));
        			gradesList.add(resultSet.getString("cse213"));
        			gradesList.add(resultSet.getString("cse214"));
        			gradesList.add(resultSet.getString("cse215"));
        			gradesList.add(resultSet.getString("cse216"));
        			gradesList.add(resultSet.getString("cse217"));
        			gradesList.add(resultSet.getString("cse218"));
        			gradesList.add(resultSet.getString("cse219"));

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
