package com.student.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import com.student.models.StudentInfo;
import com.student.statics.CaseConversion;
import com.student.storage.Database;
import com.student.storage.FileOperation;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Action;
import java.awt.Font;
import java.awt.Color;

public class InsertStudentInfo {

	private JFrame frame;
	private JTextField textField;
	private JComboBox comboBox;
	private DefaultComboBoxModel<String> comboBoxModel;
	
	private String[] batchList = {"17", "18", "19", "20", "21", "22", "23"};
	private JPanel panel;
	private JButton btnSave;
	private final Action action = new SwingAction();

	public InsertStudentInfo() {
	
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
		
		comboBoxModel = new DefaultComboBoxModel<>(batchList);
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(249, 249, 249));
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Student Information");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(249, 249, 249));
		panel.setBounds(64, 29, 297, 175);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration No:");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 25, 124, 19);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Cambria", Font.PLAIN, 15));
		textField.setBounds(154, 20, 124, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblBatch = new JLabel("Batch:");
		lblBatch.setFont(new Font("Cambria", Font.BOLD, 15));
		lblBatch.setBounds(12, 56, 67, 19);
		panel.add(lblBatch);
		
		comboBox = new JComboBox(comboBoxModel);
		comboBox.setFont(new Font("Cambria", Font.BOLD, 15));
		comboBox.setBounds(154, 53, 124, 25);
		panel.add(comboBox);
		
		btnSave = new JButton("Save");
		btnSave.setAction(action);
		btnSave.setBounds(94, 123, 92, 30);
		btnSave.setFont(new Font("Cambria", Font.BOLD, 15));
		panel.add(btnSave);
	}
	
	private class SwingAction extends AbstractAction {
		
		public SwingAction() {
			
			putValue(NAME, "Save");
		}
		
		public void actionPerformed(ActionEvent e) {
			
			String regNo = textField.getText().toString();
			String batch = comboBox.getSelectedItem().toString();
			
			if (batch == null)
				
				batch = comboBox.getItemAt(0).toString();
			
			if (regNo == null || regNo.isEmpty())
				
				JOptionPane.showMessageDialog(frame, "Registration number can't be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
			
			else if (regNo.length() != 11)
				
				JOptionPane.showMessageDialog(frame, "Invalid registration number!", "Warning", JOptionPane.WARNING_MESSAGE);
			
			else {
				
				Database database = new Database();
				FileOperation fileOperation = new FileOperation();
				StudentInfo studentInfo = database.getSingleStudent(regNo);
				
				if (studentInfo != null) {
					
					studentInfo.setStudentName(CaseConversion.toCamelCase(studentInfo.getStudentName()));
					studentInfo.setStudentBatch(batch + "th");
					fileOperation.writeFile(studentInfo);
					
					frame.dispose();
					new MainMenu();
					return;
				}
			}
		}
	}
}
