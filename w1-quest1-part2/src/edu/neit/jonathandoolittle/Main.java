package edu.neit.jonathandoolittle;

/**
 * 
 * Sorting algorithm for 3 values
 * 
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Jul 25, 2021
 *
 */

public class Main {

	public static void main(String[] args) {
		sortThreeValues(55.5f, 0.40f, -100f);
		sortThreeValues(0.5f, 0.111111f, -100f);
		sortThreeValues(0f, 0f, 1f);
		sortThreeValues(-2.2222f, -2.222f, -2f);
	}
	
	
	/**
	 * Returns the smaller value
	 * @param a The first float to test
	 * @param b The second float to test
	 * @return The smaller float
	 */
	private static float min(float a, float b) {
		return (a > b) ? b : a;
	}
	
	/**
	 * Returns the index of a value after exhaustive search
	 * @param array The array to search
	 * @param value The value to find
	 * @return The index, or -1 if not found
	 */
	private static int indexOf(float[] array, float value) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value) return i;
		}
		return -1;
	}
	
	/**
	 * Swaps two elements in an array by value
	 * @param array The array to manipulate
	 * @param a The first value
	 * @param b The second value
	 */
	private static void arrSwap(float[] array, float a, float b) {
		
        int indexA = indexOf(array, a);
        int indexB = indexOf(array, b);
        
        float temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
        
       
	}
	
	/**
	 * Sorts the three values given from least to greatest!
	 * @param a Any float
	 * @param b Any float
	 * @param c Any float
	 */
	public static void sortThreeValues(float a, float b, float c) {	
		float[] order = {a, b, c};
		
		arrSwap(order, order[0], min(order[0], min(order[1], order[2])));
		arrSwap(order, order[1], min(order[1], order[2]));
		
		System.out.println(String.format("Values: %1$s, %2$s, %3$s | Sorted: %4$s, %5$s, %6$s", a, b, c, order[0], order[1], order[2]));
	}
	

	
}
