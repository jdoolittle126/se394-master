package edu.neit.jonathandoolittle;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * A first-in, first-out data structure used to hold items
 * for processing. Elements are inserted in the tail of the
 * queue, and are dequeued from the front. New queues are 
 * created empty.
 *
 * <pre>
 *  JQueue<String> myQueue = new JQueue<>();
 *  myQueue.enqueue("first");
 *  myQueue.enqueue("second");
 *  
 *  myQueue.dequeue(); ~ "first"
 *  myQueue.dequeue(); ~ "second"
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 10, 2021
 *
 */
public class JQueue<T> {

	// ******************************
	// Variables
	// ******************************
	private LinkedList<T> list;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new Queue instance
	 */
	public JQueue() {
		list = new LinkedList<>();
	}

	// ******************************
	// Public methods
	// ******************************

	/**
	 * Clears this queue
	 */
	public void clear() {
		list.clear();
	}
	
	/**
	 * @return True, if this queue is empty
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Retrieves the top element in the queue, without removing it
	 * @return The top element in the queue
	 * @throws NoSuchElementException If this queue is empty
	 */
	public T peek() {
		return list.getFirst();
	}
	
	/**
	 * Retrieves the top element in the queue, and removes it
	 * @return The highest queued element in the queue
	 * @throws NoSuchElementException If this queue is empty
	 */
	public T dequeue() {
		return list.removeFirst();
	}
	
	/**
	 * Adds an item to the back of this queue
	 * @param item The item to add
	 */
	public void enqueue(T item) {
		list.addLast(item);
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		return list.toString();
	}
	
	
}
