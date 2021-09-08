package edu.neit.jonathandoolittle;

/**
 * 
 * A binary search tree comprised of {@link JLeaf leaves}
 * that can be traversed. Data entered to this collection is 
 * sorted on entry.
 *
 * <pre>
 * 		JTree<Integer> tree = new JTree<>();
 * 		tree.insert(13, 10, 2, 12, 25, 20, 31, 29);
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.2 - Sep 3, 2021
 *
 */
public class JTree<T extends Comparable<T>> {

	// ******************************
	// Variables
	// ******************************
	
	protected JLeaf<T> root;

	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new JTree instance
	 */
	public JTree() {
		root = null;
	}

	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Inserts item in the order given, one at a time
	 * @param items The items to insert
	 */
	@SuppressWarnings("unchecked")
	public void insert(T ... items) {
		for(T item : items) {
			insert(item);
		}
	}
	
	/**
	 * Inserts an item into this tree
	 * @param item The item to insert
	 */
	public void insert(T item) {
		JLeaf<T> current = root;
		JLeaf<T> previous = null;
		
		while(current != null) {
			previous = current;
			if(current.key.compareTo(item) < 0) {
				current = current.right;
			} else {
				current = current.left;
			}
		}
		
		if(root == null) {
			root = new JLeaf<>(item);
		} else if(previous.key.compareTo(item) < 0) {
			previous.right = new JLeaf<>(item);
		} else {
			previous.left = new JLeaf<>(item);
		}
		
	}
	
	/**
	 * Searches this tree for the given item, starting at the root leaf
	 * @param item The item to search for
	 * @return The node containing this item
	 */
	public JLeaf<T> search(T item) {
		return search(this.root, item);
	}
	
	/**
	 * Searches this tree for the given item
	 * @param start The node to start at
	 * @param item The item to search for
	 * @return The node containing this item
	 */
	public JLeaf<T> search(JLeaf<T> start, T item) {
		while(start != null) {
			if(start.key == item) {
				return start;
			} else if(start.key.compareTo(item) < 0) {
				start = start.right;
			} else {
				start = start.left;
			}
		}
		
		return null;	
	}
	
	/**
	 * Prints this tree breadth first
	 */
	public void breadthFirst() {
		JLeaf<T> current = root;
		JQueue<JLeaf<T>> queue = new JQueue<>();
		
		if(current != null) {
			queue.enqueue(current);
			while(!queue.isEmpty()) {
				current = queue.dequeue();
				visit(current);
				if(current.left != null) {
					queue.enqueue(current.left);
				}
				if(current.right != null) {
					queue.enqueue(current.right);
				}	
			}
		}
	}

	// ******************************
	// Protected methods
	// ******************************
	
	/**
	 * Prints out the item at the given destination
	 * @param destination The node to print
	 */
	protected void visit(JLeaf<T> destination) {
		System.out.print(destination + " ");
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		return (root == null) ? "" : root.toTreeString();
	}
}
