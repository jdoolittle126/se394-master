package edu.neit.jonathandoolittle;

/**
 * 
 * Drive for Quest 3
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 3, 2021
 *
 */
public class Main {

	public static void main(String[] args) {
		 
		JList<Integer> jList = new JList<>();
		
		// Add some elements
		jList.add(5);
		jList.add(4);
		jList.add(5);
		jList.add(2);
		jList.add(2);
		jList.add(6);

		System.out.println("Find the index of 3 (Not in list)");
		System.out.println(jList.indexOf(3));
		
		System.out.println("\nDisplay the list");
		System.out.println(jList.toString());
		
		System.out.println("\nReplace the last element with 3000, and show what is being replaced");
		System.out.println(jList.set(jList.getLength()-1, 3000));
		System.out.println(jList.toString());
		
		System.out.println("\nPop the last element, and display what was popped");
		System.out.println(jList.pop());
		System.out.println(jList.toString());
		
		System.out.println("\nRemove the number 2, and show the success");
		System.out.println(jList.remove(2));
		System.out.println(jList.toString());
	}
}
