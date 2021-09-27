package edu.neit.jonathandoolittle;

/**
 * 
 * Some methods to search records
 *
 * @author Jonathan Doolittle
 * @version 0.3 - Sep 17, 2021
 *
 */
public class Search {

	// ******************************
	// Variables
	// ******************************

	String[][] data = {
			{"K0", "Abby Linc", 	"18", "al@ch.org"},
			{"K1", "John Doe", 		"23", "jd@abc.com"},
			{"K2", "Janet Basco", 	"39", "jb@ids.com"},
			{"K3", "Charles River", "64", "cr@neit.edu"},
			{"K4", "Barak Obama", 	"50", "bo@democrat.gov"},
			{"K5", "Sarah Palin", 	"44", "sp@republican.gov"},
			{"K6", "John McCain", 	"72", "jm@it.com"},
			{"K7", "George Bush", 	"54", "gb@white.com"},
			{"K8", "Al Gore", 		"56", "ag@vp.edu"},
			{"K9", "Dick Cheney", 	"60", "dc@vp.gov"}
	};
	
	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Sequentially searches the data
	 * @param search The key to search for
	 * @return The index of the record
	 */
	public int sequential(String search) {
		System.out.println("Searching for " + search + " using seqential method.");
		int i;
		for(i = 0; i < data.length; i++) {
			System.out.println("Read " + i + ", key = " + data[i][0]);
			if(search.equalsIgnoreCase(data[i][0])) {
				break;
			}
		}
		
		if(i >= data.length) {
			i = -1;
			System.out.println("Key " + search + " not found!");
		} else {
			System.out.println("Key " + search + " found at index " + i);
			System.out.println("after " + (i+1) + " reads");
		}
		
		return i;
	}
	
	public int binary(String search) {
		System.out.println("Searching for " + search + " using binary method.");
		int len = data.length;
		int index = 0;
		int tries = 0;
		int upper = len;
		int foundAtIndex = -1;
		int previous = 0;
		
		index = len / 2;
		
		do {
			System.out.println("Read " + index + ", key = " + data[index][0]);
			tries++;
			if(search.equalsIgnoreCase(data[index][0])) {
				foundAtIndex = index;
				break;
			} else {
				// In order to fix the bug, without overhauling the code,
				// I made a function to strip indexes into numeric components.
				// This involves leaving out all non-numeric characters, so if in the 
				// future the letter component is significant in searching, this will
				// need to be updated
				if(asNumeric(search) > asNumeric(data[index][0])) {
					index = (index + upper) / 2;
					if(index == previous) index++;
				} else {
					upper = index;
					index = index / 2;
					if(index == previous) index--;
				}
				previous = index;
			}
		} while(index >= 0 && index < len);
		
		if(foundAtIndex == -1) {
			System.out.println("Key " + search + " not found!");
		} else {
			System.out.println("Key " + search + " found at index " + foundAtIndex);
			System.out.println("after " + tries + " reads");
		}
		
		
		return foundAtIndex;
	}
	
	/**
	 * Creates a simple hash of the given key
	 * @param key The key to hash
	 * @return The resulting hash
	 */
	public int hashRoutine(String search) {
		int len = search.length();
		int sum = 0;
		for(int i = 0; i < len; i++) {
			int decValue = search.charAt(i);
			sum += decValue;
		}
		return sum;
	}
	
	String[][] datahashed = new String[135][4];
	
	public int hash(String search) {
		System.out.println("Searching for " + search + " using hash method.");
		int foundAtIndex = hashRoutine(search);
		
		System.out.println("Key " + search + " found at index " + foundAtIndex);
		System.out.println("after 1 read");
		
		return foundAtIndex;
	}
	
	/**
	 * Strings all non-numeric characters and returns the int that remains
	 * @param key The key to convert
	 * @return The numeric value
	 */
	private int asNumeric(String key) {
		int value = -1;
		try {
			value = Integer.parseInt(key.replaceAll("\\D+", ""));
		} catch(NumberFormatException e) {
			System.out.println("An error occured while searching.");
		}
		
		return value;
	}
	
	/**
	 * Creates a string version of the record
	 * @param index The index to fetch
	 * @return The string
	 */
	public String displayRecord(int index) {
		if(index > -1 && index < data.length) {
			return "Record = " 
					+ data[index][0] + ", "
					+ data[index][1] + ", "
					+ data[index][2] + ", "
					+ data[index][3];
		}
		return "No such record!";
	}
	
	/**
	 * Creates a string version of the record
	 * @param index The index to fetch
	 * @return The string
	 */
	public String displayRecordFromHash(int index) {
		if(index > -1 && index < datahashed.length) {
			return "Record = " 
					+ datahashed[index][0] + ", "
					+ datahashed[index][1] + ", "
					+ datahashed[index][2] + ", "
					+ datahashed[index][3];
		}
		return "No such record!";
	}
	
	public static void main(String[] args) {
		Search search = new Search();
		
		for(int i = 0; i < search.data.length; i++) {
			int generatedHashIndex = search.hashRoutine(search.data[i][0]);
			search.datahashed[generatedHashIndex][0] = search.data[i][0];
			search.datahashed[generatedHashIndex][1] = search.data[i][1];
			search.datahashed[generatedHashIndex][2] = search.data[i][2];
			search.datahashed[generatedHashIndex][3] = search.data[i][3];
		}
		
		for(int i = 0; i < 10; i++) {
			int row = search.hash("K" + i);
			String result = search.displayRecordFromHash(row);
			System.out.println(result);
		}
	
		
	}

}
