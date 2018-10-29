package com.student.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import com.student.statics.FramePosition;

public class LoadingScreen {

	private JFrame frame;

	public LoadingScreen() {
		
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Loading");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.setSize(345, 139);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(SplashScreen.class.getResource("/com/student/animations/loading_mini_2.gif")));
		label.setBounds(92, 31, 50, 50);
		panel.add(label);
		
		JLabel lblPleaseWait = new JLabel("Please Wait...");
		lblPleaseWait.setBounds(151, 30, 114, 51);
		panel.add(lblPleaseWait);
	}
	
	public void stopAnimation() {
		
		frame.dispose();
	}
}
