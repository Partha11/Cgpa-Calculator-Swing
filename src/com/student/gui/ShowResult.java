package com.student.gui;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import com.student.calculator.Calculator;
import com.student.gui.SplashScreen;
import com.student.models.FirstSemester;
import com.student.models.SecondSemester;
import com.student.models.StudentInfo;
import com.student.models.ThirdSemester;
import com.student.storage.Database;
import com.student.storage.FileOperation;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class ShowResult {

	private JFrame frame;
	private JFrame animateFrame;
	
	private DefaultTableModel tableModel;
	private JTable table;
	
	private FirstSemester firstSemester;
	private SecondSemester secondSemester;
	private ThirdSemester thirdSemester;
	
	private StudentInfo studentInfo;
	
	private Calculator calculator;
	
	private String [] header = {"Name", "Code", "Grade"};
	private String [][] data = {};
	private String regNo;
	
	private double resultCgpa;
	private double totalMarks;
	
	private ArrayList<String> gradesList;
	private ArrayList<String> subjectList;
	private ArrayList<String> codesList;
	private final Action action = new BackButtonListener();
	private final Action action_1 = new HomeButtonListener();

	public ShowResult() {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					gradesList = new ArrayList<>();
					codesList = new ArrayList<>();
					subjectList = new ArrayList<>();
					
					FileOperation fileOperation = new FileOperation();
					Database database = new Database();
					
					if (SelectResultMethod.registrationNumber == null) {
					
						studentInfo = fileOperation.readFile();
						regNo = studentInfo.getStudentRegNo();
					}
					
					else {
						
						regNo = SelectResultMethod.registrationNumber;
						studentInfo = database.getSingleStudent(regNo);
					}
					
					if (database.initDatabase()) {
						
						switch (SelectResultMethod.semester) {
						
							case 1:
								
								clearList();
								
								firstSemester = database.getFirstSemesterData(regNo);
								gradesList = firstSemester.getGradesList();
								codesList = firstSemester.getSubjectCodeList();
								subjectList = firstSemester.getSubjectNameList();
								break;
								
							case 2:
								
								clearList();
								
								secondSemester = database.getSecondSemesterData(regNo);
								gradesList = secondSemester.getGradesList();
								codesList = secondSemester.getSubjectCodeList();
								subjectList = secondSemester.getSubjectNameList();
								break;
								
							case 3:
								
								clearList();
								
								thirdSemester = database.getThirdSemesterData(regNo);
								gradesList = thirdSemester.getGradesList();
								codesList = thirdSemester.getSubjectCodeList();
								subjectList = thirdSemester.getSubjectNameList();
								break;
						}
					}
					
					calculator = new Calculator(gradesList, SelectResultMethod.semester);
					totalMarks = calculator.calculate();
					resultCgpa = calculator.calculateCgpa(totalMarks);
					
					initialize();
					frame.setVisible(true);
					
					for (int i = 0; i < gradesList.size(); i++) {
						
						Object[] rows = {subjectList.get(i), codesList.get(i), gradesList.get(i)};
						tableModel.addRow(rows);
					}
				}
				
				catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}
	
	private void clearList() {
		
		gradesList.clear();
		subjectList.clear();
		codesList.clear();
	}

	private void initialize() {
		
		tableModel = new DefaultTableModel(data, header) {
        
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int col) {
				
				return false;
            }
		};
		
		DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer() {
            
			@Override
            public Component getTableCellRendererComponent(JTable table, Object value,
            		boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                		hasFocus, row, column);
                
                if (column == 2)
                
                	setForeground(Color.GREEN);
                
                else
                    
                	setForeground(Color.BLACK);
                
                setHorizontalAlignment(JLabel.CENTER);
                setVerticalAlignment(JLabel.CENTER);
                return this;
            }
        };
		
		frame = new JFrame("Result");
		frame.getContentPane().setBackground(new Color(249, 249, 249));
		frame.setBounds(100, 100, 622, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(12, 12, 357, 290);
		panel.setBackground(new Color(249, 249, 249));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable(tableModel);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setFont(new Font("Verdana", Font.PLAIN, 12));
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(0).setCellRenderer(tableRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(tableRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(tableRenderer);
		table.setBounds(12, 12, 294, 266);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 357, 290);
		scrollPane.setBackground(new Color(249, 249, 249));
		panel.add(scrollPane);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setFont(new Font("Serif", Font.BOLD, 12));
		lblTotal.setForeground(Color.GREEN);
		lblTotal.setText("Total: " + String.valueOf(totalMarks));
		lblTotal.setBounds(406, 155, 103, 15);
		frame.getContentPane().add(lblTotal);
		
		JLabel lblNewLabel = new JLabel("CGPA : ");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setText("CGPA : " + String.valueOf(resultCgpa));
		lblNewLabel.setBounds(406, 176, 103, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Serif", Font.BOLD, 12));
		nameLabel.setBounds(406, 54, 204, 15);
		frame.getContentPane().add(nameLabel);
		
		JLabel regNoLabel = new JLabel("Registration No");
		regNoLabel.setFont(new Font("Serif", Font.BOLD, 12));
		regNoLabel.setBounds(406, 81, 204, 15);
		frame.getContentPane().add(regNoLabel);
		
		JLabel batchLabel = new JLabel("Batch");
		batchLabel.setFont(new Font("Serif", Font.BOLD, 12));
		batchLabel.setBounds(406, 108, 154, 15);
		frame.getContentPane().add(batchLabel);
		
		nameLabel.setText(studentInfo.getStudentName());
		regNoLabel.setText(studentInfo.getStudentRegNo());
		batchLabel.setText(studentInfo.getStudentBatch());
		
		JButton btnBack = new JButton("Back");
		btnBack.setAction(action);
		btnBack.setFont(new Font("Serif", Font.BOLD, 12));
		btnBack.setBounds(407, 248, 74, 25);
		frame.getContentPane().add(btnBack);
		
		JButton btnHome = new JButton("Home");
		btnHome.setAction(action_1);
		btnHome.setFont(new Font("Serif", Font.BOLD, 12));
		btnHome.setBounds(493, 248, 74, 25);
		frame.getContentPane().add(btnHome);
	}
	
	private void animate() {
		
		animateFrame = new JFrame("Loading");
		animateFrame.setBounds(100, 100, 563, 394);
		animateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon loading = new ImageIcon("/com/student/animations/loading_5.gif");
	    animateFrame.add(new JLabel("loading... ", loading, JLabel.CENTER));
				
		animateFrame.setVisible(true);
	}
	
	private class BackButtonListener extends AbstractAction {
		
		public BackButtonListener() {
			
			putValue(NAME, "Back");
		}
		
		public void actionPerformed(ActionEvent e) {
		
			frame.dispose();
			new SelectResultMethod();
			return;
		}
	}
	
	private class HomeButtonListener extends AbstractAction {
		
		public HomeButtonListener() {
			
			putValue(NAME, "Home");
		}
		
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			new MainMenu();
			return;
		}
	}
}