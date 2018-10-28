package com.student.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.Timer;

import org.omg.CORBA.WCharSeqHolder;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.student.calculator.Calculator;
import com.student.models.EighthSemester;
import com.student.models.FifthSemester;
import com.student.models.FirstSemester;
import com.student.models.FourthSemester;
import com.student.models.RootSemester;
import com.student.models.SecondSemester;
import com.student.models.SeventhSemester;
import com.student.models.SixthSemester;
import com.student.models.ThirdSemester;
import com.student.statics.FramePosition;

import javax.swing.JButton;

public class ShowSubject {

	private JFrame frame;
	private JPanel panel;
	
	private int subject;
	
	private String sequence;
	
	private ArrayList<Integer> practicalIndexList;
	
	private Calculator calculator;
	private RootSemester rootSemester;
	
	private int x = 20;
	private int x1 = 340;
	private int y = 100;
	private int y1 = 100;
	private JButton btnHome;

	public ShowSubject() {
		
		EventQueue.invokeLater(new Runnable() {
		
			public void run() {
			
				try {
					
					calculator = new Calculator(SelectSemester.semester);
					subject = calculator.toSubject(SelectSemester.semester);
					practicalIndexList = calculator.getIndexList();
					
					sequence = (SelectSemester.semester == 1) ? "st" : (SelectSemester.semester == 2) ? "nd" : (SelectSemester.semester == 3) ? "rd" :
						"th";
					
					switch (SelectSemester.semester) {
					
						case 1:
						
							rootSemester = new FirstSemester();
							break;
							
						case 2:
							
							rootSemester = new SecondSemester();
							break;
							
						case 3:
							
							rootSemester = new ThirdSemester();
							break;
							
						case 4:
							
							rootSemester = new FourthSemester();
							break;
							
						case 5:
							
							rootSemester = new FifthSemester();
							break;
							
						case 6:
							
							rootSemester = new SixthSemester();
							break;
							
						case 7:
							
							rootSemester = new SeventhSemester();
							break;
							
						case 8:
							
							rootSemester = new EighthSemester();
							break;
					}
				
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
		frame.getContentPane().setBackground(new Color(249, 249, 249));
		frame.setSize(624, 440);
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
		
		panel = new JPanel();
		panel.setBounds(12, 12, 600, 388);
		panel.setBackground(new Color(249, 249, 249));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSemester = new JLabel(SelectSemester.semester + sequence + " Semester");
		lblSemester.setFont(new Font("Cambria", Font.BOLD, 21));
		lblSemester.setBounds(230, 12, 140, 50);
		panel.add(lblSemester);
		
		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new MainMenu();
				return;
			}
		});
		btnHome.setFont(new Font("Cambria", Font.BOLD, 15));
		btnHome.setBounds(260, 329, 80, 30);
		panel.add(btnHome);
		
		for (int i = 0; i < subject; i++) {
			
			JLabel label = new JLabel(rootSemester.getSubjectNameList().get(i));
			label.setFont(new Font("Cambria", Font.BOLD, 15));
			label.setSize(label.getPreferredSize().width, 20);
			
			if (practicalIndexList.contains(i)) {
				
				label.setLocation(x1, y1);
				y1 += 30;
			}
			
			else {
				
				label.setLocation(x, y);
				y += 30;
			}
			
			panel.add(label);
		}
		
/*		JLabel lblNewLabel = new JLabel("Subject Name");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel.setBounds(31, 291, 205, 19);
		panel.add(lblNewLabel);*/
	}
}
