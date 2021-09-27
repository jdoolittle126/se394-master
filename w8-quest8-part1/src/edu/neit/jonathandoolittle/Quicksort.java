package edu.neit.jonathandoolittle;

/**
 * A simple quick sort implementation.
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Sep 12, 2021
 *
 */
public class Quicksort {

	// ******************************
	// Public methods
	// ******************************

	/**
	 * Uses quick sort to sort the given data, in ascending order
	 * @param <T> The data type to sort
	 * @param data The data to sort
	 */
	public static <T extends Comparable<T>> void sort(T[] data) {
		if(data.length < 2) {
			return;
		}
		
		int max = 0;
		for(int i = 0; i < data.length; i++) {
			if(data[max].compareTo(data[i]) < 0) {
				max = i;
			}
		}
		swap(data, data.length - 1, max);
		sort(data, 0, data.length-2);
	}
	
	/**
	 * Quick sorts a segment of the data
	 * @param <T> The data type to sort
	 * @param data The data to sort
	 * @param first The index to start at
	 * @param last The index to end at
	 */
	public static <T extends Comparable<T>> void sort(T[] data, int first, int last) {
		int lower = first + 1;
		int upper = last;
		T bound = data[first];
		
		while(lower <= upper) {
			while(bound.compareTo(data[lower]) > 0) {
				lower++;
			}
			while(bound.compareTo(data[upper]) < 0) {
				upper--;
			}
			
			if(lower < upper) {
				swap(data, lower++, upper--);
			} else {
				lower++;
			}
		}
		
		swap(data, upper, first);
		
		if(first < upper - 1) {
			sort(data, first, upper-1);
		}
		
		if(upper + 1 < last) {
			sort(data, upper+1, last);
		}
		
	}
	
	/**
	 * Swaps two items in an array
	 * @param <T> The data type to sort
	 * @param data The array to swap from
	 * @param first The index of the first item
	 * @param second The index of the second item
	 */
	public static <T extends Comparable<T>> void swap(T[] data, int first, int second) {
		T temp = data[first];
		data[first] = data[second];
		data[second] = temp;
	}
		
}
