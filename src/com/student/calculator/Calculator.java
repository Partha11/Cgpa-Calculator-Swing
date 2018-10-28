package com.student.calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Calculator {

	private ArrayList<String> gradesList;
	private ArrayList<Integer> indexList;
	
	private DecimalFormat decimalFormat = new DecimalFormat(".##");
	
	private int semester;
	
	private double credit;
	
	private HashMap<String, Double> gradeMap;
	
	public Calculator(int semester) {
		
		this.semester = semester;
		
		initIndex();
	}
	
	public Calculator(ArrayList<String> gradesList, int semester) {
		
		this.gradesList = gradesList;
		this.semester = semester;
		
		initMap();
		initIndex();
		initCredits();
	}
	
	public ArrayList<Integer> getIndexList() {
		
		return indexList;
	}

	public int toSubject(int semester) {
		
		int subject = 0;
		
		switch (semester) {
		
			case 1:
				
				subject = 6;
				break;
				
			case 2:
				
				subject = 7;
				break;
				
			case 3:
				
				subject = 9;
				break;
				
			case 4:
				
				subject = 7;
				break;
				
			case 5:
				
				subject = 6;
				break;
				
			case 6:
				
				subject = 7;
				break;
				
			case 7:
				
				subject = 7;
				break;
				
			case 8:
				
				subject = 5;
				break;
		}
		
		return subject;
	}
	
	private void initMap() {
		
		gradeMap = new HashMap<>();
		
		gradeMap.put("A+", 4.00);
		gradeMap.put("A", 3.75);
		gradeMap.put("A-", 3.50);
		gradeMap.put("B+", 3.25);
		gradeMap.put("B", 3.00);
		gradeMap.put("B-", 2.75);
		gradeMap.put("C+", 2.50);
		gradeMap.put("C", 2.25);
		gradeMap.put("D", 2.00);
		gradeMap.put("F", 0.00);
	}
	
	private void initIndex() {
		
		indexList = new ArrayList<>();
		
		switch (semester) {
		
			case 1:
			
				indexList.add(2);
				break;
				
			case 2:
				
				indexList.add(1);
				indexList.add(3);
				break;
				
			case 3:
				
				indexList.add(1);
				indexList.add(4);
				indexList.add(7);
				break;
		}
	}
	
	private void initCredits() {
		
		switch (semester) {
		
			case 1:
		
				credit = 16.5;
				break;
			
			case 2:
			
				credit = 18;
				break;
			
			case 3:
			
				credit = 22.5;
				break;
				
			case 4:
				
				credit = 18;
				break;
				
			case 5:
				
				credit = 16.5;
				break;
				
			case 6:
				
				credit = 19.5;
				break;
				
			case 7:
				
				credit = 18;
				break;
				
			case 8:
				
				credit = 13.5;
				break;
		}
	}
	
	public double calculate() {
		
		double result = 0.0;
		int j = 0;
		
		for (int i = 0; i < gradesList.size(); i++) {
			
			double multiplier;
			
			if (j < indexList.size() && indexList.get(j) == i) {
				
				multiplier = 1.5;
				j++;
			}
			
			else
				
				multiplier = 3;
			
			result += gradeMap.get(gradesList.get(i)) * multiplier;
		}
		
		return result;
	}
	
	public double calculateCgpa(double total) {
		
		double result = Double.parseDouble(decimalFormat.format(total / credit));
		
		return result;
	}
}
