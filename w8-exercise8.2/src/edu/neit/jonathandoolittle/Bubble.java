package edu.neit.jonathandoolittle;

import java.util.LinkedList;

/**
 * A simple bubble sort,
 * for Strings
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Sep 7, 2021
 *
 */
public class Bubble {

	// ******************************
	// Variables
	// ******************************

	String[] data = {"cat", "apple", "apple", "george", "neit"};

	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Sorts the given data
	 * @param data The data to sort
	 * @return The sorted array
	 */
	public String[] sort(String[] data) {
		
		long start, stop, elapsed;
		start = System.currentTimeMillis();
		
		int len = data.length;
		
		for(int pass = 1; pass < len; pass++) {
			System.out.println("Pass = " + pass);
			for(int compares = 0; compares < len - pass; compares++) {
				System.out.print(compares + " ");
				if(data[compares].compareTo(data[compares + 1])< 0) {
					String temp = data[compares];
					data[compares] = data[compares+1];
					data[compares+1] = temp;
				}
			}
			System.out.println();
		}
		
		stop = System.currentTimeMillis();
		elapsed = stop - start;
		System.out.println("Elapsed: " + elapsed);
		
		return data;
	}
	
	/**
	 * Prints the data
	 */
	public void printData() {
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("The unsorted order");
		Bubble bubble = new Bubble();
		bubble.printData();
		bubble.sort(bubble.data);
		
		System.out.println("The sorted order");
		bubble.printData();
		
	}

}
