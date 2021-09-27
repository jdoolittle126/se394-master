package edu.neit.jonathandoolittle;

/**
 * 
 * Hashes a 2D String array in order to 
 * be able to access data at O(1)
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Sep 20, 2021
 *
 */
public class Hashing {

	// ******************************
	// Variables
	// ******************************
	
	String[][] data;
	private int maxSize;

	// ******************************
	// Constructors
	// ******************************
	
	/**
	 * Creates a new Hashing instance
	 * @param input The array to hash
	 * @param keyIndex The index of this array that should be used a primary key
	 * @param maxHashArraySize The size of the hashing array
	 */
	public Hashing(String[][] input, int keyIndex, int maxHashArraySize) {
		
		// Handle bad input
		if(keyIndex < 0 || keyIndex > input[0].length) {
			throw new IllegalArgumentException("Cannot specify a key index that does not exist! Index must be within the array!");
		}
		
		if(maxHashArraySize < 1) {
			throw new IllegalArgumentException("Max Hash Array Size must be a positive, non-zero integer!");
		}
		
		// Make our hash table
		data = new String[maxHashArraySize][input[0].length];
		maxSize = maxHashArraySize;
		
		for(int i = 0; i < input.length; i++) {
			// Hash the primary key
			int hash = hash(input[i][keyIndex]);
			
			// Since we don't handle collisions, warn the user
			if(data[hash][0] != null) {
				System.out.println("Warning, a collision occured! "
						+ "You may want to consider using a larger hash table!");
			}
			
			// Copy over to our new hashed table
			for(int j = 0; j < input[0].length; j++) {
				data[hash][j] = input[i][j];
			}	
		}
	}

	// ******************************
	// Accessors
	// ******************************
	
	/**
	 * Gets a record from the hash table by primary key
	 * @param key The key to access
	 * @return The record array, or a null array of the same size if the record cannot be found
	 */
	public String[] getRecord(String key) {
		int hash = hash(key);
		if(hash > 0 && hash < maxSize) {
			return data[hash];
		}
		// Return an empty array of the same size if nothing is found
		return new String[data[0].length];
	}
	
	/**
	 * Convince function for testing. Gets a record and prints it
	 * @param key The key to search for
	 */
	public void getAndPrintRecord(String key) {
		printRecord(getRecord(key));
	}

	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Hashes a given string. Hashes cannot exceed the maxHashArraySize defined when
	 * this Hashing instance was created
	 * @param value The item to hash
	 * @return The hash value
	 */
	public int hash(String value) {
		char[] characters = value.toCharArray();
		long hash = 0;
		
		/*
		 * After reading about hashing last week, I learned that
		 * an effective way of hashing strings (and the way Java does it)
		 * is to add up the value of each character, and multiply it
		 * by a constant prime raised to the character's index.
		 * For this final, I choose 7, and made my hash a long just
		 * to ensure safety
		 */
		for(int i = 0; i < characters.length; i++) {
			hash += (characters[i] * Math.pow(7, i));
		}
		
		// Limit hashes to the max size specified
		return (int) (hash % maxSize);
	}
	
	/**
	 * Displays the value of the hashed data
	 */
	public void printData() {
		for(int i = 0; i < data.length; i++) {
			System.out.print(i + "\t");
			printRecordAt(i);
		}
	}
	
	/**
	 * Prints a record at a specified index
	 * @param index The index to print
	 */
	public void printRecordAt(int index) {
		for(int j = 0; j < data[0].length; j++) {
			System.out.format("%-25s", data[index][j]);
		}
		System.out.println();
	}
	
	/**
	 * Prints a given record
	 * @param record The record to print
	 */
	public void printRecord(String[] record) {
		for(int j = 0; j < record.length; j++) {
			System.out.format("%-25s", record[j]);
		}
		System.out.println();
	}

	// ******************************
	// Testing
	// ******************************
	
	public static void main(String[] args) {
		
		// Using the data given in the example
		String[][] players = {
				{"Gary Smith", 		"GarySmith@neit.edu", 		"$15.00"},
				{"Laila Kerniech", 	"LailaKerniech@neit.edu", 	"$30.00"},
				{"Shawn Kemp", 		"ShawnKemp@neit.edu", 		"$23.50"},
				{"Sarah Palin", 	"SarahPalin@neit.edu", 		"$110.00"},
				{"Ray Connif", 		"RayConnif@neit.edu", 		"$0.00"},
				{"Edmund Cortis", 	"EdmundCortis@neit.edu", 	"$50.00"},
				{"John Matis", 		"JohnMatis@neit.edu", 		"$15.00"},
		};
		
		// Create a new instance with the given values:
		// Our data, the index of our primary key (0, for player names)
		// and the max size of our hash table (20, as specified)
		Hashing hash = new Hashing(players, 0, 20);
		
		// Display the hash table
		hash.printData();
		
		System.out.println();
		
		// Test some records
		hash.getAndPrintRecord("Gary Smith"); // Exists
		hash.getAndPrintRecord("Sarah Palin"); // Exists
		hash.getAndPrintRecord("John Doe"); // Does not exist
		
		
	}
	
}
