package edu.neit.jonathandoolittle;

/**
 * 
 * 
 * Driver class for exercise 3.2, manually adding linked nodes
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 2, 2021
 *
 */
public class Main {

	public static void main(String[] args) {
		
		SingleLinkedList<Integer> sll = new SingleLinkedList<Integer>();
		
		
		sll.addToHead(8);
		sll.addToHead(7);
		sll.addToTail(20);
		sll.addToTail(-12);
		
		if(sll.contains(2333)) {
			System.out.println("meep");
		}

		System.out.println(sll.toString());


		
	}
}
