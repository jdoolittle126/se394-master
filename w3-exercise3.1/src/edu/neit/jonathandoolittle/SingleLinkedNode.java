package edu.neit.jonathandoolittle;

/**
 * 
 * 
 * A simple generic node for a singly-linked list.
 * 
 * <pre> 
 *    SingleLinkedNode<Integer> node = new SingleLinkedNode<Integer>(10);
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 2, 2021
 *
 */
public class SingleLinkedNode<N> {

	// ******************************
	// Variables
	// ******************************

	public N data;
	public SingleLinkedNode<N> next;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new start or end node
	 * @param data The generic data this node holds
	 */
	public SingleLinkedNode(N data) {
		this.data = data;
		this.next = null;
	}
	
	/**
	 * Creates a node that has an element following it
	 * @param data The generic data this node holds
	 * @param next The node that follows this node
	 */
	public SingleLinkedNode(N data, SingleLinkedNode<N> next) {
		this.data = data;
		this.next = next;
	}
	
}
