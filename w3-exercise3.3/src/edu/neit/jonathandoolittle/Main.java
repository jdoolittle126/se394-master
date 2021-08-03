package edu.neit.jonathandoolittle;

/**
 * 
 * Driver class for exercise 3.3, manually adding linked nodes
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 2, 2021
 *
 */
public class Main {

	public static void main(String[] args) {
		
		SingleLinkedList<Integer> sll = new SingleLinkedList<Integer>();
		
		sll.add(8);
		sll.add(7);
		sll.add(20);
		sll.add(-12);
		
		System.out.println("Find the index of 7");
		System.out.println(sll.indexOf(7));
		System.out.println("What element is at index 1?");
		System.out.println(sll.at(1));
		
		System.out.println("List all of the values:");
		System.out.println(sll.toString());

		
	}
}
