package edu.neit.jonathandoolittle;

/**
 * 
 * JNode provides a singly-linked node for a {@link JList}, a custom
 * linked list. JNodes hold generic data, with a link to the next node
 *
 * @author Jonathan Doolittle
 * @version 0.2 - Aug 3, 2021
 *
 */
public class JNode<N> {

	// ******************************
	// Variables
	// ******************************

	protected N data;
	protected JNode<N> next;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new start or end node
	 * @param data The generic data this node holds
	 */
	public JNode(N data) {
		this.data = data;
		this.next = null;
	}
	
	/**
	 * Creates a node that has an element following it
	 * @param data The generic data this node holds
	 * @param next The node that follows this node
	 */
	public JNode(N data, JNode<N> next) {
		this.data = data;
		this.next = next;
	}
	
}
