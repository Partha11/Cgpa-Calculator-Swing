package com.student.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.student.models.StudentInfo;
import com.student.statics.CaseConversion;
import com.student.statics.FramePosition;
import com.student.storage.FileOperation;
import java.awt.event.ActionListener;

public class MainMenu {

	private JFrame frame;
	private JLabel nameLabel;
	private JLabel batchLabel;
	private JLabel regNoLabel;
	private JLabel sessionLabel;
	
	private FileOperation fileOperation;
	
	private JButton btnResults;
	
	private final Action resultAction = new ResultsButtonListener();
	private final Action exitAction = new ExitButtonListener();

	public MainMenu() {
		
		fileOperation = new FileOperation();
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					initialize();
					frame.setVisible(true);
					
					SwingUtilities.invokeLater(new Runnable() {
						
						@Override
						public void run() {
							
							frame.addComponentListener(new ComponentAdapter() {
								
								@Override
								public void componentMoved(ComponentEvent componentEvent) {
									
									FramePosition.frameX = componentEvent.getComponent().getX();
									FramePosition.frameY = componentEvent.getComponent().getY();
									
									System.out.println(componentEvent.getComponent().getInputContext().toString());
								}
							});
						}
					});
					
					if (checkFile()) {
						
						StudentInfo studentInfo = fileOperation.readFile();
						String fullNameCamelCase = CaseConversion.getSmallName(studentInfo.getStudentName());
						
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		if (FramePosition.frameX != 0 && FramePosition.frameY != 0)
			
			frame.setLocation(FramePosition.frameX, FramePosition.frameY);
		
		frame.getContentPane().setBackground(new Color(249, 249, 249));
		frame.setSize(502, 327);
		
		btnResults = new JButton("Results");
		btnResults.setAction(resultAction);
		btnResults.setFont(SplashScreen.CambriaBold);
		btnResults.setBounds(53, 99, 93, 30);
		frame.getContentPane().add(btnResults);
		
		JButton btnSubjects = new JButton("Subjects");
		btnSubjects.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new SelectSemester();
				return;
			}
		});
		btnSubjects.setBounds(53, 135, 93, 30);
		btnSubjects.setFont(SplashScreen.CambriaBold);
		frame.getContentPane().add(btnSubjects);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setBounds(53, 171, 93, 30);
		btnCredits.setFont(SplashScreen.CambriaBold);
		frame.getContentPane().add(btnCredits);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setAction(exitAction);
		btnQuit.setBounds(53, 207, 93, 30);
		btnQuit.setFont(SplashScreen.CambriaBold);
		frame.getContentPane().add(btnQuit);
		
		SplashScreen.CambriaBold = SplashScreen.CambriaBold.deriveFont(21f);
		JLabel lblStudentsHub = new JLabel("Students Hub");
		lblStudentsHub.setForeground(new Color(138, 43, 226));
		lblStudentsHub.setBackground(Color.LIGHT_GRAY);
		lblStudentsHub.setFont(SplashScreen.CambriaBold);
		lblStudentsHub.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentsHub.setBounds(151, 11, 157, 55);
		frame.getContentPane().add(lblStudentsHub);
		SplashScreen.CambriaBold = SplashScreen.CambriaBold.deriveFont(15f);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(193, 96, 272, 143);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(12, 22, 44, 19);
		lblName.setFont(SplashScreen.CambriaBold);
		panel.add(lblName);
		
		JLabel lblBatch = new JLabel("Batch:");
		lblBatch.setBounds(12, 49, 67, 19);
		lblBatch.setFont(SplashScreen.CambriaBold);
		panel.add(lblBatch);
		
		JLabel lblRegistrationNo = new JLabel("Reg No:");
		lblRegistrationNo.setBounds(12, 76, 67, 19);
		lblRegistrationNo.setFont(SplashScreen.CambriaBold);
		panel.add(lblRegistrationNo);
		
		JLabel lblSession = new JLabel("Session:");
		lblSession.setBounds(12, 103, 67, 19);
		lblSession.setFont(SplashScreen.CambriaBold);
		panel.add(lblSession);
		
		nameLabel = new JLabel("Not Set");
		nameLabel.setBounds(80, 22, 181, 19);
		nameLabel.setFont(SplashScreen.Cambria);
		panel.add(nameLabel);
		
		batchLabel = new JLabel("Not Set");
		batchLabel.setBounds(80, 49, 152, 19);
		batchLabel.setFont(SplashScreen.Cambria);
		panel.add(batchLabel);
		
		regNoLabel = new JLabel("Not Set");
		regNoLabel.setBounds(80, 76, 152, 19);
		regNoLabel.setFont(SplashScreen.Cambria);
		panel.add(regNoLabel);
		
		sessionLabel = new JLabel("Not Set");
		sessionLabel.setBounds(80, 103, 152, 19);
		sessionLabel.setFont(SplashScreen.Cambria);
		panel.add(sessionLabel);
	}
	
	private class ResultsButtonListener extends AbstractAction {
		
		private static final long serialVersionUID = 1L;

		public ResultsButtonListener() {
			
			putValue(NAME, "Results");
		}
		
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			new SelectResultMethod();
			return;
		}
	}
	
	private class ExitButtonListener extends AbstractAction {
		
		private static final long serialVersionUID = 1L;

		public ExitButtonListener() {
			
			putValue(NAME, "Quit");
		}
		
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			return;
		}
	}
}
