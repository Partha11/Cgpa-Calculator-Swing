package com.student.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.student.calculator.Calculator;
import com.student.models.EighthSemester;
import com.student.models.FifthSemester;
import com.student.models.FirstSemester;
import com.student.models.FourthSemester;
import com.student.models.SecondSemester;
import com.student.models.SeventhSemester;
import com.student.models.SixthSemester;
import com.student.models.StudentInfo;
import com.student.models.ThirdSemester;
import com.student.statics.FramePosition;
import com.student.storage.Database;
import com.student.storage.FileOperation;

public class ShowResult {

	private JFrame frame;
	
	private DefaultTableModel tableModel;
	private JTable table;
	
	private FirstSemester firstSemester;
	private SecondSemester secondSemester;
	private ThirdSemester thirdSemester;
	private FourthSemester fourthSemester;
	private FifthSemester fifthSemester;
	private SixthSemester sixthSemester;
	private SeventhSemester seventhSemester;
	private EighthSemester eighthSemester;
	
	private StudentInfo studentInfo;
	
	private Calculator calculator;
	
	private String [] header = {"Name", "Code", "Grade"};
	private String [][] data = {};
	private String regNo;
	
	private double resultCgpa;
	private double totalMarks;
	
	private LoadingScreen loadingScreen;
	
	private ArrayList<String> gradesList;
	private ArrayList<String> subjectList;
	private ArrayList<String> codesList;
	
	private final Action backButtonAction = new BackButtonListener();
	private final Action homeButtonAction = new HomeButtonListener();
	private final Action homeBtnBasicAction = new HomeButtonListenerMod();
	
	private static JDialog dialog;

	public ShowResult() {
		
		loadingScreen = new LoadingScreen();
		
		new Thread(new Runnable() {
			
			public void run() {
				
				try {
					
					gradesList = null;
					codesList = null;
					subjectList = null;
					
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
								
								firstSemester = database.getFirstSemesterData(regNo);
								
								if (firstSemester != null) {
									
									gradesList = firstSemester.getGradesList();
									codesList = firstSemester.getSubjectCodeList();
									subjectList = firstSemester.getSubjectNameList();
								}
								
								break;
								
							case 2:
								
								secondSemester = database.getSecondSemesterData(regNo);
								
								if (secondSemester != null) {
								
									gradesList = secondSemester.getGradesList();
									codesList = secondSemester.getSubjectCodeList();
									subjectList = secondSemester.getSubjectNameList();
								}
								
								break;
								
							case 3:
								
								thirdSemester = database.getThirdSemesterData(regNo);
								
								if (thirdSemester != null) {
								
									gradesList = thirdSemester.getGradesList();
									codesList = thirdSemester.getSubjectCodeList();
									subjectList = thirdSemester.getSubjectNameList();
								}
								
								break;
								
							case 4:
								
								fourthSemester = database.getFourthSemesterData(regNo);
								
								if (fourthSemester != null) {
								
									gradesList = fourthSemester.getGradesList();
									codesList = fourthSemester.getSubjectCodeList();
									subjectList = fourthSemester.getSubjectNameList();
								}
								
								break;
								
							case 5:
								
								fifthSemester = database.getFifthSemesterData(regNo);
								
								if (fifthSemester != null) {
								
									gradesList = fifthSemester.getGradesList();
									codesList = fifthSemester.getSubjectCodeList();
									subjectList = fifthSemester.getSubjectNameList();
								}
								
								break;
								
							case 6:
								
								sixthSemester = database.getSixthSemesterData(regNo);
								
								if (sixthSemester != null) {
								
									gradesList = sixthSemester.getGradesList();
									codesList = sixthSemester.getSubjectCodeList();
									subjectList = sixthSemester.getSubjectNameList();
								}
									
								break;
								
							case 7:
								
								seventhSemester = database.getSeventhSemesterData(regNo);
								
								if (seventhSemester != null) {
								
									gradesList = seventhSemester.getGradesList();
									codesList = seventhSemester.getSubjectCodeList();
									subjectList = seventhSemester.getSubjectNameList();
								}
								
								break;
								
							case 8:
								
								eighthSemester = database.getEighthSemesterData(regNo);
								
								if (eighthSemester != null) {
								
									gradesList = eighthSemester.getGradesList();
									codesList = eighthSemester.getSubjectCodeList();
									subjectList = eighthSemester.getSubjectNameList();
								}
								
								break;
						}
					}

					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {

							loadingScreen.stopAnimation();

							if (gradesList == null) {

								JButton button = new JButton("Close");
								button.addActionListener(homeBtnBasicAction);

								JOptionPane optionPane = new JOptionPane();
								optionPane.setMessage("No Data Found!");
								optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
								optionPane.setOptions(new Object[] { button });

								dialog = optionPane.createDialog("Error");
								dialog.setVisible(true);
								return;
							}

							calculator = new Calculator(gradesList, SelectResultMethod.semester);
							totalMarks = calculator.calculate();
							resultCgpa = calculator.calculateCgpa(totalMarks);

							initialize();
							frame.setVisible(true);

							for (int i = 0; i < gradesList.size(); i++) {

								Object[] rows = { subjectList.get(i), codesList.get(i), gradesList.get(i) };
								tableModel.addRow(rows);
							}
						}
					});
				}
				
				catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}).start();
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
            
			private static final long serialVersionUID = 1L;

			@Override
            public DefaultTableCellRenderer getTableCellRendererComponent(JTable table, Object value,
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(622, 355);
		frame.setLocationRelativeTo(null);
		frame.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentMoved(ComponentEvent componentEvent) {

				FramePosition.frameX = componentEvent.getComponent().getX();
				FramePosition.frameY = componentEvent.getComponent().getY();
			}
		});

		if (FramePosition.frameX == 0 || FramePosition.frameY == 0) {

			frame.setLocationRelativeTo(null);
		}

		else

			frame.setLocation(FramePosition.frameX, FramePosition.frameY);
		
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
		lblTotal.setFont(new Font("Cambria", Font.BOLD, 15));
		lblTotal.setForeground(new Color(0, 102, 255));
		lblTotal.setText("Total: " + String.valueOf(totalMarks));
		lblTotal.setBounds(406, 155, 103, 19);
		frame.getContentPane().add(lblTotal);
		
		JLabel lblNewLabel = new JLabel("CGPA : ");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(0, 102, 255));
		lblNewLabel.setText("CGPA : " + String.valueOf(resultCgpa));
		lblNewLabel.setBounds(406, 176, 103, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		nameLabel.setBounds(406, 54, 204, 19);
		frame.getContentPane().add(nameLabel);
		
		JLabel regNoLabel = new JLabel("Registration No");
		regNoLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		regNoLabel.setBounds(406, 81, 204, 19);
		frame.getContentPane().add(regNoLabel);
		
		JLabel batchLabel = new JLabel("Batch");
		batchLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		batchLabel.setBounds(406, 108, 154, 19);
		frame.getContentPane().add(batchLabel);
		
		nameLabel.setText(studentInfo.getStudentName());
		regNoLabel.setText(studentInfo.getStudentRegNo());
		batchLabel.setText(studentInfo.getStudentBatch());
		
		JButton btnBack = new JButton("Back");
		btnBack.setAction(backButtonAction);
		btnBack.setFont(new Font("Cambria", Font.BOLD, 15));
		btnBack.setBounds(407, 248, 74, 30);
		frame.getContentPane().add(btnBack);
		
		JButton btnHome = new JButton("Home");
		btnHome.setAction(homeButtonAction);
		btnHome.setFont(new Font("Cambria", Font.BOLD, 15));
		btnHome.setBounds(493, 248, 74, 30);
		frame.getContentPane().add(btnHome);
	}
	
	private class BackButtonListener extends AbstractAction {
		
		private static final long serialVersionUID = 1L;

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
		
		private static final long serialVersionUID = 1L;

		public HomeButtonListener() {
			
			putValue(NAME, "Home");
		}
		
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			new MainMenu();
			return;
		}
	}
	
	private class HomeButtonListenerMod extends AbstractAction {

		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {

			dialog.dispose();
			new MainMenu();
			return;
		}
	}
}