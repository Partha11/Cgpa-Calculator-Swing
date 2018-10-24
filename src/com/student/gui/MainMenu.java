package com.student.gui;

import java.awt.EventQueue;

import com.student.models.StudentInfo;
import com.student.storage.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
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
	private JLabel rollNoLabel;
	
	private FileOperation fileOperation;
	
	private JButton btnResults;
	
	private final Action action = new SwingAction();

	public MainMenu() {
		
		fileOperation = new FileOperation();
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					initialize();
					frame.setVisible(true);
					
					if (checkFile()) {
						
						StudentInfo studentInfo = fileOperation.readFile();
						
						nameLabel.setText(studentInfo.getStudentName());
						batchLabel.setText(studentInfo.getStudentBatch());
						regNoLabel.setText(studentInfo.getStudentRegNo());
						rollNoLabel.setText(studentInfo.getStudentRoll());
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
		
		frame = new JFrame();
		frame.setBounds(100, 100, 502, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnResults = new JButton("Results");
		btnResults.setAction(action);
		btnResults.setBounds(41, 99, 115, 25);
		frame.getContentPane().add(btnResults);
		
		JButton btnSubjects = new JButton("Subjects");
		btnSubjects.setBounds(41, 136, 115, 25);
		frame.getContentPane().add(btnSubjects);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setBounds(41, 173, 115, 25);
		frame.getContentPane().add(btnCredits);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(41, 210, 115, 25);
		frame.getContentPane().add(btnQuit);
		
		JLabel lblStudentsHub = new JLabel("Students Hub");
		lblStudentsHub.setForeground(new Color(0, 206, 209));
		lblStudentsHub.setBackground(Color.LIGHT_GRAY);
		lblStudentsHub.setFont(new Font("Dialog", Font.BOLD, 18));
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
		panel.add(lblName);
		
		JLabel lblBatch = new JLabel("Batch:");
		lblBatch.setBounds(12, 49, 67, 15);
		panel.add(lblBatch);
		
		JLabel lblRegistrationNo = new JLabel("Reg No:");
		lblRegistrationNo.setBounds(12, 76, 67, 15);
		panel.add(lblRegistrationNo);
		
		JLabel lblRollNo = new JLabel("Roll No:");
		lblRollNo.setBounds(12, 103, 67, 15);
		panel.add(lblRollNo);
		
		nameLabel = new JLabel("Not Set");
		nameLabel.setBounds(80, 22, 206, 15);
		panel.add(nameLabel);
		
		batchLabel = new JLabel("Not Set");
		batchLabel.setBounds(80, 49, 152, 15);
		panel.add(batchLabel);
		
		regNoLabel = new JLabel("Not Set");
		regNoLabel.setBounds(80, 76, 152, 15);
		panel.add(regNoLabel);
		
		rollNoLabel = new JLabel("Not Set");
		rollNoLabel.setBounds(80, 103, 152, 15);
		panel.add(rollNoLabel);
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
}
