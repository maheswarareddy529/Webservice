package com.nt.test;

public class StringTrimTest {

	public static void main(String[] args) {
		
		//String is a group of characters
		String person_names=" ravi sankar jagadesh ";
		
		//String length
		System.out.println(person_names.length());
		
		// trim 
		String tr=person_names.trim();
		System.out.println(tr);
		
		// after trim, spaces removed
		System.out.println(tr.length());

	}

}
