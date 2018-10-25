package com.student.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class LoadingScreen {

	private JFrame frame;

	public LoadingScreen() {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					initialize();
					frame.setVisible(true);
				} 
				
				catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 563, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(249, 249, 249));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 255, 255));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(SplashScreen.class.getResource("/com/student/animations/loading_5.gif")));
		label.setBounds(124, 32, 308, 271);
		panel.add(label);
	}
	
	public void stopAnimation() {
		
		frame.dispose();
	}
}
