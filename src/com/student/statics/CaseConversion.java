package com.student.statics;

public class CaseConversion {

	public static String toCamelCase(String text) {
		
		StringBuilder camelCase = new StringBuilder();
		boolean isSpace = true;
		
		for (char ch : text.toCharArray() ) {
			
			if (Character.isWhitespace(ch)) {
				
				camelCase.append(" ");
				isSpace = true;
				continue;
			}
			
			if (isSpace) {
				
				isSpace = false;
				ch = Character.toUpperCase(ch);
			}
			
			else {
				
				ch = Character.toLowerCase(ch);
			}
			
			camelCase.append(ch);
		}
		
		return camelCase.toString();
	}
	
	public static String getSmallName(String text) {
		
		if (text.length() > 20) {
			
			StringBuilder smallName = new StringBuilder();
			String[] partName = text.split(" ");
			
			smallName.append(partName[0]);
			smallName.append(" ");
			smallName.append(partName[partName.length - 1]);
			
			return smallName.toString();
		}
		
		else
			
			return text;
	}
}
