package edu.neit.jonathandoolittle;

/**
 * 
 * A single linked list implementation. 
 * 
 * <pre> 
 *    SingleLinkedList<Integer> sll = new SingleLinkedList<Integer>();
 *    sll.addToHead(8);
 *    sll.addToHead(7);
 *    sll.addToTail(20);
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 2, 2021
 *
 */
public class SingleLinkedList<N> {

	// ******************************
	// Variables
	// ******************************

	protected SingleLinkedNode<N> head;
	protected SingleLinkedNode<N> tail;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new SingleLinkedList
	 */
	public SingleLinkedList() {
		head = tail = null;
	}

	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Checks if this list is empty
	 * @return True, if empty
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * Adds a value to the head of this list
	 * @param data The value to append
	 */
	public void addToHead(N data) {
		head = new SingleLinkedNode<>(data, head);
		if(tail == null) {
			tail = head;
		}
	}
	
	/**
	 * Adds a value to the tail of this list
	 * @param data The value to append
	 */
	public void addToTail(N data) {
		if(isEmpty()) {
			head = tail = new SingleLinkedNode<>(data);
		} else {
			tail.next = new SingleLinkedNode<>(data); 
			tail = tail.next;
		}
	}
	
	/**
	 * Removes the head node of this list
	 * @return The value of the head node being removed
	 */
	public N deleteFromHead() {
		N data = head.data;
		if(head == tail) {
			head = tail = null;
		} else {
			head = head.next;
		}
		return data;
	}
	
	/**
	 * Removes the tail node of this list
	 * @return The value of the tail node being removed
	 */
	public N deleteFromTail() {
		N data = tail.data;
		if(head == tail) {
			head = tail = null;
		} else {
			SingleLinkedNode<N> tmp;
			for(tmp = head; tmp.next != tail; tmp = tmp.next);
			tail = tmp;
			tail.next = null;
		}
		return data;
	}
	
	/**
	 * Searches this list for the particular data point
	 * @param data The data to find
	 * @return True, if this list contains the given data
	 */
	public boolean contains(N data) {
		SingleLinkedNode<N> tmp;
		for(tmp = head; tmp.next != null; tmp = tmp.next) {
			if(tmp.data == data)
				return true;
		}
		return false;
	}
	
	/**
	 * Removes the node containing the provided item, and returns a boolean based on success
	 * @param data The data to be removed
	 * @return True, if the operation successfully removed data, False, if data was not found
	 */
	public boolean remove(N data) {
		if(isEmpty()) {
			return false;
		}
		
		if(head == tail && data == head.data) {
			head = tail = null;	
		} else if(data == head.data) {
			head = head.next;
		} else {
			SingleLinkedNode<N> tmp, prev;
			for(prev = head, tmp = head.next; 
					tmp != null && tmp.data != data; 
					prev = prev.next, tmp = tmp.next);
			if(tmp == null) {
				return false;
			}
			
			prev.next = tmp.next;
			if(tmp == tail) {
				tail = prev;
			}
			
		}
		
		return true;
		
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		// Display our results as '[5, 3, 2]'
		stringBuilder.append("[");
		
		SingleLinkedNode<N> tmp;
		boolean printFirst = false;
		
		// Traverse through links
		for(tmp = head; tmp != null; tmp = tmp.next) {
			if(printFirst) {
				stringBuilder.append(", ");
			} else {
				printFirst = true;
			}
			
			stringBuilder.append(tmp.data);
		}
		
		stringBuilder.append("]");
		
		return stringBuilder.toString();
	}

	
}
