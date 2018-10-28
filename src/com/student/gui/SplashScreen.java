package com.student.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;

import com.student.statics.FramePosition;
import com.student.storage.FileOperation;

public class SplashScreen {

	private JFrame frame;
	private JProgressBar progressBar;
	private Timer timer;
	
	private int val;

	public SplashScreen() {

		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					try {
	                    
						UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	                } 
					
					catch (Exception ex) {
	                }
					
					initialize();
					frame.setVisible(true);
					
					ActionListener updateProgress = new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent actionEvent) {
							
							val = progressBar.getValue();
							
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
							
							try {
								
								Thread.sleep(50);
							} 
							
							catch (InterruptedException e) {
								
								e.printStackTrace();
							}
						}
					};
					
					timer = new Timer(10, updateProgress);
					timer.start();
				} 
				
				catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		
		frame = new JFrame("Loading");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.setSize(564, 397);
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
		panel.setBackground(new Color(249, 249, 249));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setValue(10);
		progressBar.setBounds(204, 317, 148, 14);
		progressBar.setMinimum(10);
		panel.add(progressBar);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 255, 255));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(SplashScreen.class.getResource("/com/student/animations/loading_4_1.gif")));
		label.setBounds(124, 11, 308, 271);
		panel.add(label);
	}
}
