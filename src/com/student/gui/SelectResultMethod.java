package com.student.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.KeyStore.PrivateKeyEntry;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.student.models.FirstSemester;
import com.student.models.StudentInfo;
import com.student.storage.Database;
import com.student.storage.FileOperation;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.JDesktopPane;
import javax.swing.Action;
import javax.swing.ComboBoxEditor;

import java.awt.Button;

public class SelectResultMethod {
	
	private Database database;

	private JFrame frame;
	private JComboBox comboBox;
	private JButton btnNext;
	private JPanel selectionRegPanel;
	private JTextField txtRegistrationNumber;
	private final Action action = new HomeButtonClicked();
	private final Action action_1 = new NextButtonClicked();
	
	public static int semester;

	public SelectResultMethod() {
		
/*		try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
         Turn off metal's use of bold fonts 
        UIManager.put("swing.boldMetal", Boolean.FALSE);*/
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
			
				try {
					
					database = new Database();
				
					initialize();
				}
				
				catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(32, 12, 382, 251);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Automatic", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(75, 84, 85, 15);
		panel.add(lblSemester);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
		comboBox.setBounds(169, 79, 85, 24);
		panel.add(comboBox);
		
		btnNext = new JButton("Next");
		btnNext.setAction(action_1);
		btnNext.setBounds(282, 168, 73, 25);
		panel.add(btnNext);
		
		JButton btnHome = new JButton("Home");
		btnHome.setAction(action);
		btnHome.setBounds(198, 168, 73, 25);
		panel.add(btnHome);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Manual", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblPanel_1 = new JLabel("Panel 2");
		lblPanel_1.setBounds(67, 77, 51, 15);
		panel_1.add(lblPanel_1);
		frame.setVisible(true);
	}
	
	private class HomeButtonClicked extends AbstractAction {
		
		public HomeButtonClicked() {
			
			putValue(NAME, "Home");
		}
		
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			new MainMenu();
			return;
		}
	}
	private class NextButtonClicked extends AbstractAction {
		
		public NextButtonClicked() {
			
			putValue(NAME, "Next");
		}
		
		public void actionPerformed(ActionEvent e) {
			
			switch (comboBox.getSelectedIndex()) {
			
				case 0:
					
					semester = 1;
					break;
					
				case 1:
					
					semester = 2;
					break;
					
				case 2:
					
					semester = 3;
					break;
					
				case 3:
					
					semester = 4;
					break;
					
				case 4:
					
					semester = 5;
					break;
					
				case 5:
					
					semester = 6;
					break;
					
				case 6:
					
					semester = 7;
					break;
					
				case 7:
					
					semester = 8;
					break;
			}
			
			frame.dispose();
			new ShowResult();
			return;
		}
	}
}
