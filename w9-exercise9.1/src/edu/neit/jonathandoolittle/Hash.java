package edu.neit.jonathandoolittle;

/**
 * 
 * A very simple hashing procedure
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Sep 17, 2021
 *
 */
public class Hash {

	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Creates a simple hash of the given key
	 * @param key The key to hash
	 * @return The resulting hash
	 */
	public int simple(String key) {
		System.out.println("The key is = " + key);
		int len = key.length();
		int sum = 0;
		for(int i = 0; i < len; i++) {
			int decValue = key.charAt(i);
			sum += decValue;
			System.out.println("Character " + (char)decValue + " = " + decValue);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Hash hash = new Hash();
		int index = hash.simple("1007");
		System.out.println("Hash generated from key = " + index);
		
		index = hash.simple("John Doe");
		System.out.println("Hash generated from key = " + index);
		
	}
}
