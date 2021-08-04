package edu.neit.jonathandoolittle.list;

/**
 * 
 * A JList is a singly-linked list without a defined tail node.
 * This linked list can hold generic objects, and by default adds
 * and pops items from the end of the list. This behavior can be modified
 * if overridden.
 *
 * <pre>
 *  JList<Integer> jList = new JList<>();
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.2 - Aug 4, 2021
 *
 */
public class JList<N> {

	// ******************************
	// Variables
	// ******************************

	private int length;
	protected JNode<N> head;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new SingleLinkedList
	 */
	public JList() {
		length = 0;
		head = null;
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
	 * @return The length of this list
	 */
	public int getLength() {
		return this.length;
	}
	
	/**
	 * Gets the element at the given index
	 * @param index The index to get
	 * @return The data at the index
	 * @throws IndexOutOfBoundsException if index < 0 or larger than the list
	 */
	public N at(int index) {
		return getNodeAt(index).data;
	}
	
	/**
	 * Replace the element at the provided index
	 * @param index The index to change
	 * @param data The new element
	 * @return The previous element at the given index
	 * @throws IndexOutOfBoundsException if index < 0 or larger than the list
	 */
	public N set(int index, N data) {
		JNode<N> node = getNodeAt(index);
		N old = node.data;
		node.data = data;
		return old;	
	}
	
	/**
	 * Adds the given element to the back of the list
	 * @param data The element to add
	 */
	public void add(N data) {
		addToTail(data);
	}
	
	/**
	 * Removes the last item from this list
	 * @return The value of the item removed from the list
	 */
	public N pop() {
		if(length != 0) {
			return deleteFromTail();
		}
		return null;
	}
	
	/**
	 * Returns the index of the given data
	 * @param data The data to find
	 * @return The index, or -1 if the data is not present in this list
	 */
	public int indexOf(N data) {
		JNode<N> tmp;
		int i;
		for(i = 0, tmp = head; tmp.next != null; tmp = tmp.next, i++) {
			if(tmp.data == data) {
				return i;
			}		
		}
		return -1;
	}
	
	/**
	 * Searches this list for the particular data point
	 * @param data The data to find
	 * @return True, if this list contains the given data
	 */
	public boolean contains(N data) {
		JNode<N> tmp;
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
		
		if(head.next == null && data == head.data) {
			head = null;	
		} else if(data == head.data) {
			head = head.next;
		} else {
			JNode<N> tmp; 
			JNode<N> prev;
			for(prev = head, tmp = head.next; 
					tmp != null && tmp.data != data; 
					prev = prev.next, tmp = tmp.next);
			if(tmp == null) {
				return false;
			}
			
			prev.next = tmp.next;
			
		}
		
		length--;
		return true;
		
	}
	
	// ******************************
	// Private Methods
	// ******************************
	
	/**
	 * Returns the node at the given index
	 * @param index The index to get
	 * @return The node at the given index
	 * @throws IndexOutOfBoundsException if index < 0 or larger than the list
	 */
	private JNode<N> getNodeAt(int index) {
		checkBounds(index);
		JNode<N> tmp = head;
		for(int i = 0; i < index; i++,tmp = tmp.next);
		return tmp;
	}
	
	
	/**
	 * Throws out of bounds if index is not in range
	 * @param index The index to check
	 * @throws IndexOutOfBoundsException if index < 0 or larger than the list
	 */
	private void checkBounds(int index) {
		if(index < 0 || index >= length) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of range. List size is " + length);
		}
	}
	
	/**
	 * Adds a value to the head of this list
	 * @param data The value to append
	 */
	private void addToHead(N data) {
		length++;
		head = new JNode<>(data, head);
	}
	
	/**
	 * Adds a value to the tail of this list
	 * @param data The value to append
	 */
	private void addToTail(N data) {
		length++;
		if(isEmpty()) {
			head = new JNode<>(data);
		} else {
			JNode<N> tmp, prev;
			for(prev = head, tmp = head.next; 
					tmp != null; 
					prev = prev.next, tmp = tmp.next);
			prev.next = new JNode<>(data); 
		}
	}
	
	/**
	 * Removes the head node of this list
	 * @return The value of the head node being removed
	 */
	private N deleteFromHead() {
		length--;
		N data = null;
		if(head != null) {
			data = head.data;
			head = head.next;
		}
		return data;
	}
	
	/**
	 * Removes the tail node of this list
	 * @return The value of the tail node being removed
	 */
	private N deleteFromTail() {
		JNode<N> tmp, prev;
		for(prev = head, tmp = head.next; 
				tmp != null && tmp.next != null; 
				prev = prev.next, tmp = tmp.next);
		
		length--;
		N data;
		if(tmp == null) {
			data = head.data;
			head = null;
		} else {
			data = tmp.data;
			prev.next = null;
		}
		
		return data;
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		// Display our results as '[5, 3, 2]'
		stringBuilder.append("[");
		
		JNode<N> tmp;
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
