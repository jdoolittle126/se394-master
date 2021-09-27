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
	 * Creates a simple hash of the given key
	 * @param key The key to hash
	 * @return The resulting hash
	 */
	public int divideMethod(String search) {
		int len = search.length();
		int sum = 0;
		for(int i = 0; i < len; i++) {
			int decValue = search.charAt(i);
			sum += decValue;
		}
		return sum % 10;
	}
	
	String[][] datahashed = new String[10][4];
	
	public int hash(String search) {
		System.out.println("Searching for " + search + " using hash method.");
		int foundAtIndex = divideMethod(search);
		
		System.out.println("Key " + search + " found at index " + foundAtIndex);
		System.out.println("after 1 read");
		
		return foundAtIndex;
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
			System.out.println(search.data[i][0] + " = " + search.divideMethod(search.data[i][0]));
			
			int generatedHashIndex = search.divideMethod(search.data[i][0]);
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
