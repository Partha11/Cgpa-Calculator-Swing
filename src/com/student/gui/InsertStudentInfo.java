package com.student.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import com.student.models.StudentInfo;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(86, 59, 297, 145);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration No:");
		lblNewLabel.setBounds(12, 12, 124, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(154, 10, 124, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblBatch = new JLabel("Batch:");
		lblBatch.setBounds(12, 39, 67, 15);
		panel.add(lblBatch);
		
		comboBox = new JComboBox(comboBoxModel);
		comboBox.setBounds(154, 37, 124, 19);
		panel.add(comboBox);
		
		btnSave = new JButton("Save");
		btnSave.setAction(action);
		btnSave.setBounds(94, 93, 92, 25);
		panel.add(btnSave);
	}
	
	private class SwingAction extends AbstractAction {
		
		public SwingAction() {
			
			putValue(NAME, "Save");
		}
		
		public void actionPerformed(ActionEvent e) {
			
			String regNo = textField.getText().toString();
			String batch = comboBox.getSelectedItem().toString() + "th";
			
			if (batch == null)
				
				batch = comboBox.getItemAt(0).toString() + "th";
			
			if (regNo == null || regNo.isEmpty())
				
				JOptionPane.showMessageDialog(frame, "Registration number can't be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
			
			else if (regNo.length() != 11)
				
				JOptionPane.showMessageDialog(frame, "Invalid registration number!", "Warning", JOptionPane.WARNING_MESSAGE);
			
			else {
				
				Database database = new Database();
				FileOperation fileOperation = new FileOperation();
				StudentInfo studentInfo = database.getSingleStudent(regNo);
				
				if (studentInfo != null) {
					
					if (studentInfo.getStudentBatch() != null) {
					
						fileOperation.writeFile(studentInfo);
					}
					
					else {
						
						studentInfo.setStudentBatch(batch);
						database.updateStudentBatch(studentInfo);
						fileOperation.writeFile(studentInfo);
					}
					
					frame.dispose();
					new MainMenu();
					return;
				}
			}
		}
	}
}
