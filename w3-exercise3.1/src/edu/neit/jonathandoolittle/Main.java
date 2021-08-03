package edu.neit.jonathandoolittle;

/**
 * 
 * 
 * Driver class for exercise 3.1, manually adding linked nodes
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 2, 2021
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Connecting Integer Nodes");
		
		SingleLinkedNode<Integer> node = new SingleLinkedNode<Integer>(10);
		System.out.println(node.data);
		
		node.next = new SingleLinkedNode<Integer>(8);
		System.out.println(node.next.data);
		
		node.next.next = new SingleLinkedNode<Integer>(50);
		System.out.println(node.next.next.data);
		
		node.next.next.next = new SingleLinkedNode<Integer>(13);
		System.out.println(node.next.next.next.data);
		
		node.next.next.next.next = new SingleLinkedNode<Integer>(-12);
		System.out.println(node.next.next.next.next.data);
		
		System.out.println();
		
		node.next.next = node.next.next.next;
		
		System.out.println(node.data);
		System.out.println(node.next.data);
		System.out.println(node.next.next.data);
		System.out.println(node.next.next.next.data);
		
		
	}
}
