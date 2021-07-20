package edu.neit.jonathandoolittle;

import javax.swing.JOptionPane;

/**
 * 
 * Driver class for Week 1's Exercise 1.2
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Jul 20, 2021
 *
 */

public class Main {

	public static void main(String[] args) {
		Monster leviathon = new Monster();
		leviathon.setAge(150);
		leviathon.setName("leviathon");
		System.out.println(leviathon.toString());
		
		String myString = JOptionPane.showInputDialog("Enter a number of items: ");
		int myNumber = Integer.parseInt(myString);
		System.out.println(myNumber);
		
	}
	
}
