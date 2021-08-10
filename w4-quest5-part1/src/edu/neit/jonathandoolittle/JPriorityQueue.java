package edu.neit.jonathandoolittle;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * A first-in, first-out data structure used to hold items
 * for processing, with priority. Elements are inserted in the tail of the
 * queue, and move forward until they hit an item of a higher priority. items
 * are dequeued from the front. New queues are created empty.
 *
 * <pre>
 *  JPriorityQueue<String, Integer> myQueue = new JPriorityQueue<>();
 *  myQueue.enqueue("low priority", 5);
 *  myQueue.enqueue("no priority #1");
 *  myQueue.enqueue("no priority #2");
 *  myQueue.enqueue("high priority", 100);
 *  
 *  myQueue.dequeue(); ~ "high priority"
 *  myQueue.dequeue(); ~ "low priority"
 *  myQueue.dequeue(); ~ "no priority #1"
 *  myQueue.dequeue(); ~ "no priority #2"
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 10, 2021
 * @see JPriorityWrapper
 */
public class JPriorityQueue<T, S extends Comparable<S>> {

	// ******************************
	// Variables
	// ******************************
	protected LinkedList<JPriorityWrapper<T, S>> list;
	
	// ******************************
	// Constructors
	// ******************************

	public JPriorityQueue() {
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
		return list.getFirst().unwrap();
	}
	
	/**
	 * Retrieves the top element in the queue, and removes it
	 * @return The highest queued element in the queue
	 * @throws NoSuchElementException If this queue is empty
	 */
	public T dequeue() {
		return list.removeFirst().unwrap();
	}
	
	/**
	 * Adds an item to the back of this queue
	 * @param item The item to add
	 */
	public void enqueue(T item) {
		list.addLast(new JPriorityWrapper<>(item, null));
	}

	/**
	 * Adds an item to this queue based on priority
	 * @param item The item to add
	 * @param priority The priority of the item to add
	 */
	public void enqueue(T item, S priority) {
		int i;
		for(i = list.size(); i > 0; i--) {
			S prevPriority = list.get(i-1).getPriority();
		    if(prevPriority != null && prevPriority.compareTo(priority) >= 0) {
		    	break;
		    }
		}
		list.add(i, new JPriorityWrapper<>(item, priority));
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		return list.toString();
	}

	
}
