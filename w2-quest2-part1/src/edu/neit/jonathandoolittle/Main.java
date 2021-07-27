package edu.neit.jonathandoolittle;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javafx.util.Pair;

/**
 * 
 * Gem hunt for Quest 2. Provides algorithms create a random gem hunt on a 2d array,
 * display the array, and find the gems.
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Jul 27, 2021
 *
 */

public class Main {

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		
		int[][] test = new int[8][8];
		
		// 8x8 grid, 10% fill density, minimum of 2 gems
		generateGemHunt(test, 1, 5, 2);
		displayGemHunt(test, 1);
		displayGemHuntResults(findGems(test, 1));

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Total execution time: " + elapsedTime / 1000000 + "ms");
        
	}
	
	/**
	 * Displays a gem hunt visually in the console
	 * @param array The array that contains the hunt
	 * @param gem The integer that represents a gem
	 */
	public static void displayGemHunt(int[][] array, int gem) {
		
		// The characters that show spaces and gems
		char gemChar = 'J';
		char spaceChar = 'X';
		
		// Generate headers, then display them vertical
		String[] headers = new String[array.length];
		
		for(int x = 0; x < array.length; x++) {
			headers[x] = String.format("COL %03d-", x);
		}
		
		// Print them out as vertical labels
		for(int i = 0; i < headers[0].length(); i++) {
			System.out.print("          ");
			for(int x = 0; x < array.length; x++) {
				System.out.print(headers[x].substring(i, i+1) + " ");
			}
			System.out.println();
		}
		
		for(int y = 0; y < array[0].length; y++) {
			// Print row labels
			System.out.print(String.format("ROW %03d | ", y));
			
			// Display the grid
			for(int x = 0; x < array.length; x++) {
				if(array[x][y] == gem) {
					System.out.print(gemChar);
				} else {
					System.out.print(spaceChar);
				}	
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Prints the list of results as a readable list
	 * @param input The results list
	 */
	public static void displayGemHuntResults(List<Pair<Integer, Integer>> input) {
		input.forEach(p -> {
			System.out.println("Gem found at row " + p.getKey() + ", col " + p.getValue());
		});
		
		System.out.println("A total of " + input.size() + " gems were found!");
	}
	
	/**
	 * Generates a random gem hunt for testing
	 * @param array The array to populate
	 * @param gem An integer that represents a gem
	 * @param density The density of gem distribution, where 100 is a full grid and 0 is empty
	 * @param minimum The minimum number of gems this puzzle should contain
	 */
	public static void generateGemHunt(int[][] array, int gem, int density, int minimum) {
		
		// Prevent heap exhaustion from invalid input
		if(density == 0 && minimum > 0) {
			return;
		}
		
		// Track fires to determine if minimum requirement is met
		int fires = 0;
		Random random = new Random();
		
		for(int x = 0; x < array.length; x++) {
			for(int y = 0; y < array[0].length; y++) {
				if(random.nextInt(100) < density && array[x][y] != gem) {
					fires++;
					array[x][y] = gem;
				}
			}
		}
		
		// Recurse and run with adjusted minimum if value is not met
		if(fires < minimum) {
			generateGemHunt(array, gem, density, minimum - fires);
		}
	}
	
	/**
	 * Finds gems within the given puzzle
	 * @param array The array to search
	 * @param gem An integer that represents a gem
	 * @return A List of coordinate pairs, where the pair key is the row and the value is the column
	 */
	public static List<Pair<Integer, Integer>> findGems(int[][] array, int gem) {
		
		int height = array.length;
		int width = array[0].length;
		
		List<Pair<Integer, Integer>> result = new LinkedList<>();
		
		for(int i = 0; i < height*width ; i++) {
			if(array[i/width][i%width] == gem) {
				// Type Safety
				result.add(new Pair<>(Integer.valueOf(i%width), Integer.valueOf(i/width)));
			}
		}
		
		return result;
		
	}
	
}
