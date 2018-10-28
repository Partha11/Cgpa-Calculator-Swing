package com.student.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;

import com.student.statics.FramePosition;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;

public class SelectSemester {

	private JFrame frame;
	
	public static int semester;

	public SelectSemester() {
		
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
		frame.setSize(450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
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
		panel.setBounds(12, 12, 426, 246);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setFont(new Font("Cambria", Font.BOLD, 15));
		lblSemester.setBounds(102, 79, 70, 19);
		panel.add(lblSemester);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
		comboBox.setFont(new Font("Cambria", Font.BOLD, 15));
		comboBox.setBounds(193, 73, 113, 30);
		panel.add(comboBox);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				semester = comboBox.getSelectedIndex() + 1;
				frame.dispose();
				new ShowSubject();
				return;
			}
		});
		btnCheck.setFont(new Font("Cambria", Font.BOLD, 15));
		btnCheck.setBounds(218, 152, 76, 30);
		panel.add(btnCheck);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new MainMenu();
				return;
			}
		});
		
		btnHome.setFont(new Font("Cambria", Font.BOLD, 15));
		btnHome.setBounds(123, 152, 76, 30);
		panel.add(btnHome);
	}
}
