package edu.neit.jonathandoolittle;

import java.util.LinkedList;
import java.util.List;

/**
 * Encapsulates generic type T with a generic comparable item
 * S to create priority collections. Items of type T are bound to
 * a comparable type S, and are given elevated status in priority
 * collections. Items of type T can be unbound from their priority
 * using the unwrap functions.
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 10, 2021
 * @see JPriorityQueue
 *
 */
public class JPriorityWrapper<T, S extends Comparable<S>> {

	// ******************************
	// Variables
	// ******************************
	
	private T item;
	private S priority;

	// ******************************
	// Constructors
	// ******************************

	/**
	 * Encapsulates an item and a priority
	 * @param item The item
	 * @param priority The priority of the item.
	 */
	public JPriorityWrapper(T item, S priority) {
		this.item = item;
		this.priority = priority;
	}

	// ******************************
	// Public methods
	// ******************************
	
	/*
	 * @return The priority of this item
	 */
	public S getPriority() {
		return priority;
	}
	
	/**
	 * @return The item stored
	 */
	public T unwrap() {
		return item;
	}
	
	/**
	 * Takes a List of JPriorityWrapper and unwraps the items, returning a list of the original type (T)
	 * @param <T> The type of data being stored
	 * @param <S> The type that stores priority
	 * @param list The list that needs to unwrapped
	 * @return The unwrapped list
	 */
	protected static <T, S extends Comparable<S>> List<T> unwrapList(List<JPriorityWrapper<T, S>> list) {
		List<T> unwrappedList = new LinkedList<>();
		for(JPriorityWrapper<T, S> j : list) {
			unwrappedList.add(j.unwrap());
		}
		return unwrappedList;
		
	}

	// ******************************
	// Private methods
	// ******************************

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		return item.toString();
	}

	
}
