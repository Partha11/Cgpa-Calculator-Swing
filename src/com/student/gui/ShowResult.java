package com.student.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.*;
import java.awt.*;

import com.student.calculator.Calculator;
import com.student.models.FirstSemester;
import com.student.models.SecondSemester;
import com.student.models.StudentInfo;
import com.student.models.ThirdSemester;
import com.student.storage.Database;
import com.student.storage.FileOperation;

import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class ShowResult {

	private JFrame frame;
	
	private DefaultTableModel tableModel;
	private JTable table;
	
	private FirstSemester firstSemester;
	private SecondSemester secondSemester;
	private ThirdSemester thirdSemester;
	
	private Calculator calculator;
	
	private String [] header = {"Name", "Code", "Grade"};
	private String [][] data = {};
	
	private double resultCgpa;
	private double totalMarks;
	
	private ArrayList<String> gradesList;
	private ArrayList<String> subjectList;
	private ArrayList<String> codesList;

	public ShowResult() {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					gradesList = new ArrayList<>();
					codesList = new ArrayList<>();
					subjectList = new ArrayList<>();
					
					FileOperation fileOperation = new FileOperation();
					StudentInfo studentInfo = fileOperation.readFile();
					
					Database database = new Database();
					
					if (database.initDatabase()) {
						
						switch (SelectResultMethod.semester) {
						
							case 1:
								
								clearList();
								
								firstSemester = database.getFirstSemesterData(studentInfo.getStudentRegNo());
								gradesList = firstSemester.getGradesList();
								codesList = firstSemester.getSubjectCodeList();
								subjectList = firstSemester.getSubjectNameList();
								break;
								
							case 2:
								
								clearList();
								
								secondSemester = database.getSecondSemesterData(studentInfo.getStudentRegNo());
								gradesList = secondSemester.getGradesList();
								codesList = secondSemester.getSubjectCodeList();
								subjectList = secondSemester.getSubjectNameList();
								break;
								
							case 3:
								
								clearList();
								
								thirdSemester = database.getThirdSemesterData(studentInfo.getStudentRegNo());
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
		
		frame = new JFrame();
		frame.setBounds(100, 100, 609, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(12, 12, 357, 290);
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
		panel.add(scrollPane);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setFont(new Font("Serif", Font.BOLD, 12));
		lblTotal.setForeground(Color.GREEN);
		lblTotal.setText("Total: " + String.valueOf(totalMarks));
		lblTotal.setBounds(406, 54, 103, 15);
		frame.getContentPane().add(lblTotal);
		
		JLabel lblNewLabel = new JLabel("CGPA : ");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setText("CGPA : " + String.valueOf(resultCgpa));
		lblNewLabel.setBounds(406, 89, 70, 15);
		frame.getContentPane().add(lblNewLabel);
	}
}
