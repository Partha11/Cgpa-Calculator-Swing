package com.student.gui;

import java.awt.EventQueue;

import com.student.models.StudentInfo;
import com.student.storage.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JPanel;

public class MainMenu {

	private JFrame frame;
	private JLabel nameLabel;
	private JLabel batchLabel;
	private JLabel regNoLabel;
	private JLabel sessionLabel;
	
	private FileOperation fileOperation;
	
	private JButton btnResults;
	
	private final Action action = new SwingAction();
	private final Action exitAction = new ExitAction();

	public MainMenu() {
		
		fileOperation = new FileOperation();
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					initialize();
					frame.setVisible(true);
					
					if (checkFile()) {
						
						StudentInfo studentInfo = fileOperation.readFile();
						StringBuilder fullName = new StringBuilder();
						String fullNameCamelCase;
						boolean isSpace = true;
						
						for (Character ch : studentInfo.getStudentName().toCharArray()) {
							
							if (Character.isWhitespace(ch)) {
								
								isSpace = true;
								fullName.append(" ");
								continue;
							}
							
							if (isSpace) {
								
								ch = Character.toUpperCase(ch);
								isSpace = false;
							}
							
							else
								
								ch = Character.toLowerCase(ch);
							
							fullName.append(ch);
						}
						
						fullNameCamelCase = fullName.toString();
						
						if (fullNameCamelCase.length() > 20) {
							
							String name[] = fullNameCamelCase.split(" ");
							nameLabel.setText(name[0] + " " + name[name.length - 1]);
						}
						
						else
							
							nameLabel.setText(fullNameCamelCase);
						
						batchLabel.setText(studentInfo.getStudentBatch());
						regNoLabel.setText(studentInfo.getStudentRegNo());
						sessionLabel.setText(studentInfo.getStudentSession());
					}
				} 
				
				catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}
	
	private boolean checkFile() {
		
		return fileOperation.isFileAvailable();
	}

	private void initialize() {
		
		frame = new JFrame("Home");
		frame.setBounds(100, 100, 502, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnResults = new JButton("Results");
		btnResults.setAction(action);
		btnResults.setFont(new Font("Cambria", Font.BOLD, 15));
		btnResults.setBounds(53, 99, 83, 25);
		frame.getContentPane().add(btnResults);
		
		JButton btnSubjects = new JButton("Subjects");
		btnSubjects.setBounds(41, 135, 115, 25);
		btnSubjects.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(btnSubjects);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setBounds(53, 171, 83, 25);
		btnCredits.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(btnCredits);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setAction(exitAction);
		btnQuit.setBounds(53, 207, 83, 25);
		btnQuit.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(btnQuit);
		
		JLabel lblStudentsHub = new JLabel("Students Hub");
		lblStudentsHub.setForeground(new Color(0, 206, 209));
		lblStudentsHub.setBackground(Color.LIGHT_GRAY);
		lblStudentsHub.setFont(new Font("Cambria", Font.BOLD, 18));
		lblStudentsHub.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentsHub.setBounds(98, 12, 230, 55);
		frame.getContentPane().add(lblStudentsHub);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(193, 96, 286, 143);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(12, 22, 44, 15);
		lblName.setFont(new Font("Cambria", Font.BOLD, 15));
		panel.add(lblName);
		
		JLabel lblBatch = new JLabel("Batch:");
		lblBatch.setBounds(12, 49, 67, 15);
		lblBatch.setFont(new Font("Cambria", Font.BOLD, 15));
		panel.add(lblBatch);
		
		JLabel lblRegistrationNo = new JLabel("Reg No:");
		lblRegistrationNo.setBounds(12, 76, 67, 15);
		lblRegistrationNo.setFont(new Font("Cambria", Font.BOLD, 15));
		panel.add(lblRegistrationNo);
		
		JLabel lblSession = new JLabel("Session:");
		lblSession.setBounds(12, 103, 67, 15);
		lblSession.setFont(new Font("Cambria", Font.BOLD, 15));
		panel.add(lblSession);
		
		nameLabel = new JLabel("Not Set");
		nameLabel.setBounds(80, 22, 206, 15);
		nameLabel.setFont(new Font("Cambria", Font.PLAIN, 15));
		panel.add(nameLabel);
		
		batchLabel = new JLabel("Not Set");
		batchLabel.setBounds(80, 49, 152, 15);
		batchLabel.setFont(new Font("Cambria", Font.PLAIN, 15));
		panel.add(batchLabel);
		
		regNoLabel = new JLabel("Not Set");
		regNoLabel.setBounds(80, 76, 152, 15);
		regNoLabel.setFont(new Font("Cambria", Font.PLAIN, 15));
		panel.add(regNoLabel);
		
		sessionLabel = new JLabel("Not Set");
		sessionLabel.setBounds(80, 103, 152, 15);
		sessionLabel.setFont(new Font("Cambria", Font.PLAIN, 15));
		panel.add(sessionLabel);
	}
	
	private class SwingAction extends AbstractAction {
		
		private static final long serialVersionUID = 1L;

		public SwingAction() {
			
			putValue(NAME, "Results");
		}
		
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			new SelectResultMethod();
			return;
		}
	}
	
	private class ExitAction extends AbstractAction {
		
		public ExitAction() {
			
			putValue(NAME, "Quit");
		}
		
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			return;
		}
	}
}
