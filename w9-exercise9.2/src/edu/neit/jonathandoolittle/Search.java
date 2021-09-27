package edu.neit.jonathandoolittle;

/**
 * 
 * A simple linear search of records
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Sep 17, 2021
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
	
	/**
	 * Creates a string version of the record
	 * @param index The index to fetch
	 * @return The string
	 */
	public String displayRecord(int index) {
		return "Record = " 
				+ data[index][0] + ", "
				+ data[index][1] + ", "
				+ data[index][2] + ", "
				+ data[index][3];
	}
	
	public static void main(String[] args) {
		Search search = new Search();
		int row = search.sequential("K9");
		String result = search.displayRecord(row);
		System.out.println(result);
	}

}
