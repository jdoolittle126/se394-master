package edu.neit.jonathandoolittle;

import java.util.LinkedList;

/**
 * 
 * Queue for Midterm
 * 
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 16, 2021
 *
 */
public class Queue {

	// ******************************
	// Variables
	// ******************************

	private LinkedList<Object> queue = new LinkedList<>();
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new Queue instance
	 */
	public Queue() {
		queue.clear();	
	}

	// ******************************
	// Public methods
	// ******************************

	/**
	 * @return True, if this queue is empty
	 */
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	/**
	 * @return The first element of this array
	 */
	public Object firstEl() {
		return queue.getFirst();
	}
	
	/**
	 * Removes and returns the top element in the queue
	 * @return The item removed from the top of the queue
	 */
	public Object dequeue() {
		return queue.removeFirst();
	}
	
	/**
	 * Adds the following item to the end of the queue
	 * @param el The element to add to the queue
	 */
	public void enqueue(Object el) {
		queue.addLast(el);
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		return queue.toString();
	}
	
}
