package com.student.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.student.models.EighthSemester;
import com.student.models.FifthSemester;
import com.student.models.FirstSemester;
import com.student.models.FourthSemester;
import com.student.models.SecondSemester;
import com.student.models.SeventhSemester;
import com.student.models.SixthSemester;
import com.student.models.StudentInfo;
import com.student.models.ThirdSemester;

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

            connection = DriverManager.getConnection("jdbc:mysql://server71.greenweb.com.bd/student_db?useSSL=false", "Partha11",
            		"Opal1011##");
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
            preparedStatement.setString(2, studentInfo.getStudentSession());
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
                String session = resultSet.getString("session");
                String name = resultSet.getString("name");
                
                studentInfo = new StudentInfo(reg_no, name, session);
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

        		boolean isEmpty = true;
        		String query = "SELECT * FROM FirstSemester WHERE reg_no = " + regNo;

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);
        		
        		if (resultSet.next()) {
        			
        			isEmpty = false;

					do {

						ArrayList<String> gradesList = new ArrayList<String>();

						String reg_no = resultSet.getString("reg_no");
						gradesList.add(resultSet.getString("111"));
						gradesList.add(resultSet.getString("112"));
						gradesList.add(resultSet.getString("113"));
						gradesList.add(resultSet.getString("114"));
						gradesList.add(resultSet.getString("115"));
						gradesList.add(resultSet.getString("116"));

						firstSemester = new FirstSemester(gradesList);
					} while (resultSet.next());
        		}
        		
        		if (isEmpty)
        			
        			return null;

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
        boolean isEmpty = true;
        
        if (initDatabase()) {

        	try {

        		String query = "SELECT * FROM SecondSemester WHERE reg_no = " + regNo;

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);

        		if (resultSet.next()) {

        			isEmpty = false;
        			
        			do {

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
					} while (resultSet.next());
        		}
        		
        		if (isEmpty)
        			
        			return null;

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
        		boolean isEmpty = true;

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);

        		if (resultSet.next()) {
        			
        			isEmpty = false;

        			do {

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
						System.out.println(gradesList.toString());
					} while (resultSet.next());
        		}
        		
        		if (isEmpty)
        			
        			return null;

        		connection.close();
        	}

        	catch (SQLException e) {

        		e.printStackTrace();
        	}
        }

        return thirdSemester;
    }
    
    public FourthSemester getFourthSemesterData(String regNo) {

        FourthSemester fourthSemester = null;
        
        if (initDatabase()) {

        	try {

        		String query = "SELECT * FROM FourthSemester WHERE reg_no = " + regNo;
        		boolean isEmpty = true;

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);

        		if (resultSet.next()) {
        			
        			isEmpty = false;
        			
					do {

						ArrayList<String> gradesList = new ArrayList<String>();

						String reg_no = resultSet.getString("reg_no");
						gradesList.add(resultSet.getString("221"));
						gradesList.add(resultSet.getString("222"));
						gradesList.add(resultSet.getString("223"));
						gradesList.add(resultSet.getString("224"));
						gradesList.add(resultSet.getString("225"));
						gradesList.add(resultSet.getString("226"));
						gradesList.add(resultSet.getString("227"));

						fourthSemester = new FourthSemester(gradesList);
					} while (resultSet.next());
        		}
        		
        		if (isEmpty)
        			
        			return null;

        		connection.close();
        	}

        	catch (SQLException e) {

        		e.printStackTrace();
        	}
        }

        return fourthSemester;
    }
    
    public FifthSemester getFifthSemesterData(String regNo) {

        FifthSemester fifthSemester = null;
        
        if (initDatabase()) {

        	try {

        		String query = "SELECT * FROM FifthSemester WHERE reg_no = " + regNo;
        		boolean isEmpty = true;

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);

        		if (resultSet.next()) {
        			
        			isEmpty = false;
        			
					do {

						ArrayList<String> gradesList = new ArrayList<String>();

						String reg_no = resultSet.getString("reg_no");
						gradesList.add(resultSet.getString("311"));
						gradesList.add(resultSet.getString("312"));
						gradesList.add(resultSet.getString("313"));
						gradesList.add(resultSet.getString("314"));
						gradesList.add(resultSet.getString("315"));
						gradesList.add(resultSet.getString("316"));

						fifthSemester = new FifthSemester(gradesList);
					} while (resultSet.next());
        		}
        		
        		if (isEmpty)
        			
        			return null;

        		connection.close();
        	}

        	catch (SQLException e) {

        		e.printStackTrace();
        	}
        }

        return fifthSemester;
    }
    
    public SixthSemester getSixthSemesterData(String regNo) {

        SixthSemester sixthSemester = null;
        
        if (initDatabase()) {

        	try {

        		String query = "SELECT * FROM SixthSemester WHERE reg_no = " + regNo;
        		boolean isEmpty = true;

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);

        		if (resultSet.next()) {
        			
        			isEmpty = false;
        			
					do {

						ArrayList<String> gradesList = new ArrayList<String>();

						String reg_no = resultSet.getString("reg_no");
						gradesList.add(resultSet.getString("321"));
						gradesList.add(resultSet.getString("322"));
						gradesList.add(resultSet.getString("323"));
						gradesList.add(resultSet.getString("324"));
						gradesList.add(resultSet.getString("325"));
						gradesList.add(resultSet.getString("326"));
						gradesList.add(resultSet.getString("327"));

						sixthSemester = new SixthSemester(gradesList);
					} while (resultSet.next());
        		}
        		
        		if (isEmpty)
        			
        			return null;

        		connection.close();
        	}

        	catch (SQLException e) {

        		e.printStackTrace();
        	}
        }

        return sixthSemester;
    }
    
    public SeventhSemester getSeventhSemesterData(String regNo) {

        SeventhSemester seventhSemester = null;
        
        if (initDatabase()) {

        	try {

        		String query = "SELECT * FROM SeventhSemester WHERE reg_no = " + regNo;
        		boolean isEmpty = true;

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);

        		if (resultSet.next()) {

        			isEmpty = false;
        			
        			do {

						ArrayList<String> gradesList = new ArrayList<String>();

						String reg_no = resultSet.getString("reg_no");
						gradesList.add(resultSet.getString("411"));
						gradesList.add(resultSet.getString("412"));
						gradesList.add(resultSet.getString("413"));
						gradesList.add(resultSet.getString("414"));
						gradesList.add(resultSet.getString("415"));
						gradesList.add(resultSet.getString("416"));
						gradesList.add(resultSet.getString("417"));

						seventhSemester = new SeventhSemester(gradesList);
					} while (resultSet.next());
        		}
        		
        		if (isEmpty)
        			
        			return null;

        		connection.close();
        	}

        	catch (SQLException e) {

        		e.printStackTrace();
        	}
        }

        return seventhSemester;
    }
    
    public EighthSemester getEighthSemesterData(String regNo) {

        EighthSemester eighthSemester = null;
        
        if (initDatabase()) {

        	try {

        		String query = "SELECT * FROM EighthSemester WHERE reg_no = " + regNo;
        		boolean isEmpty = true;

        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(query);

        		if (resultSet.next()) {
        			
        			isEmpty = false;

        			do {

						ArrayList<String> gradesList = new ArrayList<String>();

						String reg_no = resultSet.getString("reg_no");
						gradesList.add(resultSet.getString("421"));
						gradesList.add(resultSet.getString("422"));
						gradesList.add(resultSet.getString("423"));
						gradesList.add(resultSet.getString("42x"));
						gradesList.add(resultSet.getString("429"));

						eighthSemester = new EighthSemester(gradesList);
					} while (resultSet.next());
        		}
        		
        		if (isEmpty)
        			
        			return null;

        		connection.close();
        	}

        	catch (SQLException e) {

        		e.printStackTrace();
        	}
        }

        return eighthSemester;
    }
}
