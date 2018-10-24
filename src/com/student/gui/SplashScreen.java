package com.student.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.student.storage.FileOperation;

public class SplashScreen {

	private JFrame frame;
	private JProgressBar progressBar;
	private Timer timer;

	/**
	 * @wbp.parser.entryPoint
	 */
	public SplashScreen() {

		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					try {
	                    
						UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	                } 
					
					catch (ClassNotFoundException ex) {
	                } 
					
					catch (InstantiationException ex) {
	                } 
					
					catch (IllegalAccessException ex) {
	                } 
					
					catch (UnsupportedLookAndFeelException ex) {
	                }
					
					initialize();
					frame.setVisible(true);
					
					ActionListener updateProgress = new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent actionEvent) {
							
							int val = progressBar.getValue();
							
							if (val >= 100) {
								
								timer.stop();
								frame.dispose();
								
								FileOperation fileOperation = new FileOperation();
								
								if (fileOperation.isFileAvailable())
									
									new MainMenu();
								
								else
									
									new InsertStudentInfo();
									
								return;
							}
							
							progressBar.setValue(++val);
						}
					};
					
					timer = new Timer(30, updateProgress);
					timer.start();
				} 
				
				catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setValue(30);
		progressBar.setBounds(147, 233, 148, 14);
		progressBar.setMinimum(30);
		panel.add(progressBar);
	}
}
