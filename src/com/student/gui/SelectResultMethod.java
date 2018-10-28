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
import com.student.statics.FramePosition;
import com.student.storage.Database;
import com.student.storage.FileOperation;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.JDesktopPane;
import javax.swing.Action;
import javax.swing.ComboBoxEditor;

import java.awt.Button;
import java.awt.Font;

public class SelectResultMethod {
	
	private Database database;

	private JFrame frame;
	
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	
	private JButton btnNext;
	
	private JPanel selectionRegPanel;
	private JTextField txtRegistrationNumber;
	
	private final Action action = new HomeButtonClicked();
	private final Action action_1 = new NextButtonClicked();
	private final Action action_2 = new ManualNextButtonClicked();
	
	public static int semester;
	public static String registrationNumber;
	
	private JTextField reg_no_manual;

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
		
		frame = new JFrame("Result Method");
		frame.getContentPane().setBackground(new Color(249, 249, 249));
		frame.setBackground(new Color(249, 249, 249));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(448, 303);
		frame.setLocationRelativeTo(null);
		frame.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentMoved(ComponentEvent componentEvent) {

				FramePosition.frameX = componentEvent.getComponent().getX();
				FramePosition.frameY = componentEvent.getComponent().getY();
			}
		});

		if (FramePosition.frameX == 0 || FramePosition.frameY == 0)

			frame.setLocationRelativeTo(null);

		else

			frame.setLocation(FramePosition.frameX, FramePosition.frameY);
		
		System.out.println(FramePosition.frameX + " " + FramePosition.frameY);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(32, 12, 382, 251);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(249, 249, 249));
		tabbedPane.addTab("Automatic", null, panel, null);
		tabbedPane.setFont(new Font("Cambria", Font.BOLD, 15));
		panel.setLayout(null);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Cambria", Font.BOLD, 15));
		lblSemester.setBounds(74, 82, 85, 19);
		panel.add(lblSemester);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
		comboBox.setBounds(169, 79, 85, 24);
		panel.add(comboBox);
		
		btnNext = new JButton("Next");
		btnNext.setAction(action_1);
		btnNext.setBounds(282, 168, 73, 30);
		btnNext.setFont(new Font("Cambria", Font.BOLD, 15));
		panel.add(btnNext);
		
		JButton btnHome = new JButton("Home");
		btnHome.setAction(action);
		btnHome.setBounds(198, 168, 73, 30);
		btnHome.setFont(new Font("Cambria", Font.BOLD, 15));
		panel.add(btnHome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(249, 249, 249));
		tabbedPane.addTab("Manual", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblPanel_1 = new JLabel("Semester");
		lblPanel_1.setFont(new Font("Cambria", Font.BOLD, 15));
		lblPanel_1.setBounds(65, 77, 82, 19);
		panel_1.add(lblPanel_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
		comboBox_1.setBounds(210, 76, 123, 24);
		panel_1.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Registration No");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(65, 42, 111, 19);
		panel_1.add(lblNewLabel);
		
		reg_no_manual = new JTextField();
		reg_no_manual.setFont(new Font("Cambria", Font.PLAIN, 15));
		reg_no_manual.setBounds(210, 38, 123, 24);
		panel_1.add(reg_no_manual);
		reg_no_manual.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setAction(action_2);
		btnSearch.setBounds(197, 140, 92, 30);
		btnSearch.setFont(new Font("Cambria", Font.BOLD, 15));
		panel_1.add(btnSearch);
		
		JButton btnHome_1 = new JButton("Home");
		btnHome_1.setFont(new Font("Cambria", Font.BOLD, 15));
		btnHome_1.setBounds(98, 140, 89, 30);
		btnHome_1.setAction(action);
		panel_1.add(btnHome_1);
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
			
			semester = comboBox.getSelectedIndex() + 1;
			registrationNumber = null;
			
			frame.dispose();
			new ShowResult();
			return;
		}
	}
	
	private class ManualNextButtonClicked extends AbstractAction {
		
		public ManualNextButtonClicked() {
			
			putValue(NAME, "Search");
		}
		
		public void actionPerformed(ActionEvent e) {
			
			semester = comboBox_1.getSelectedIndex() + 1;
			registrationNumber = reg_no_manual.getText();
			
			frame.dispose();
			new ShowResult();
			return;
		}
	}
}
