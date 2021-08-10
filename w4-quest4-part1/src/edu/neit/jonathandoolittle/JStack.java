package edu.neit.jonathandoolittle;

/**
 * A last-in, first-out data structure used to hold the
 * chronological order of items as they are added. Contains methods 
 * to pop and push items, as well as ways to peek into the stack without
 * removing an item. New stacks are created empty.
 *
 * <pre>
 *  JStack<String> myStack = new JStack<>();
 *  myStack.push("first");
 *  myStack.push("second");
 *  
 *  myStack.pop(); ~ "second"
 *  myStack.pop(); ~ "first"
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.2 - Aug 10, 2021
 *
 */
public class JStack<T> {

	// ******************************
	// Variables
	// ******************************

	private JList<T> list;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new JStack instance
	 */
	public JStack() {
		list = new JList<>();
	}

	// ******************************
	// Public methods
	// ******************************

	/**
	 * Clears this stack
	 */
	public void clear() {
		list.clear();
	}
	
	/**
	 * @return True, if this stack is empty
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Retrieves the top element in the stack, without removing it
	 * @return The top element in the stack
	 * @throws NoSuchElementException If this stack is empty
	 */
	public T peek() {
		return list.getLast();
	}
	
	/**
	 * Retrieves the top element in the stack, and removes it
	 * @return The top element in the stack
	 * @throws NoSuchElementException If this stack is empty
	 */
	public T pop() {
		return list.pop();
	}
	
	/**
	 * Adds an item to the top of this stack
	 * @param item The item to add
	 */
	public void push(T item) {
		list.add(item);
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		return list.toString();
	}
	
	
}
