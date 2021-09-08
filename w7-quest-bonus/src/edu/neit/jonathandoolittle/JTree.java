package edu.neit.jonathandoolittle;

import java.util.function.Function;

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
 * @version 0.4 - Sep 3, 2021
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
	 * Find an item in the tree, and delete it's node
	 * @param item The item to remove
	 */
	public void findAndDeleteByMerging(T item) {
		JLeaf<T> current = root;
		JLeaf<T> previous = null;
				
		while(current != null && current.key != item) {
			previous = current;
			if(current.key.compareTo(item) < 0) {
				current = current.right;
			} else {
				current = current.left;
			}
		}
		
		if(current != null && current.key == item) {
			deleteByMerging(current, previous);
		} else if(root != null) {
			System.out.println(item + " is not in tree!");
		} else {
			System.out.println("Tree is empty");
		}
		
		
	}
	
	/**
	 * Deletes a node by merging it's children onto the tree
	 * @param removing The node to remove
	 * @param parent The node to remove's parent
	 */
	public void deleteByMerging(JLeaf<T> removing, JLeaf<T> parent) {	
		// Keep a copy of the node for later
		JLeaf<T> node = removing;
		
		if(node.right == null) {
			node = node.left;
		} else if (node.left == null) {
			node = node.right;
		} else {
			JLeaf<T> temp = node.left;
			while(temp.right != null) {
				temp = temp.right;
			}
			
			temp.right = node.right;
			node = node.left;
		}	
		
		// Clean Up
		if(removing == root) {
			root = node;
		} else if(parent.left == removing) {
			parent.left = node;
		} else {
			parent.right = node;
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
	 * Prints the nodes of this tree in order
	 */
	public String inOrder() {
		StringBuilder sb = new StringBuilder();
		inOrder(sb, root);
		return sb.toString(); 
	}
	
	/**
	 * Prints the nodes in order
	 * @param node The next node
	 */
	protected void inOrder(StringBuilder sb, JLeaf<T> node) {
		
		if(node != null) {
			inOrder(sb, node.left);
			visit(sb, node);
			inOrder(sb, node.right);
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
	 * Searches this tree for an item where the function returns 0, starting at the root leaf
	 * @param search The function that should match a compareTo function
	 * @return The node containing this item
	 */
	public JLeaf<T> search(Function<T, Integer> search) {
		return search(this.root, search);
	}
	
	/**
	 * Searches this tree for an item where the function returns 0, starting at the root leaf
	 * @param start The node to start at
	 * @param search The function that should match a compareTo function
	 * @return The node containing this item
	 */
	public JLeaf<T> search(JLeaf<T> start, Function<T, Integer> search) {
		
		while(start != null) {
			if(search.apply(start.key) == 0) {
				return start;
			} else if(search.apply(start.key) < 0) {
				start = start.right;
			} else {
				start = start.left;
			}
		}
		
		return null;	
	}
	
	/**
	 * Searches this tree for the given item
	 * @param start The node to start at
	 * @param item The item to search for
	 * @return The node containing this item
	 */
	public JLeaf<T> search(JLeaf<T> start, T item) {
		while(start != null) {
			if(start.key.compareTo(item) == 0) {
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
	public String breadthFirst() {
		StringBuilder sb = new StringBuilder();
		JLeaf<T> current = root;
		JQueue<JLeaf<T>> queue = new JQueue<>();
		
		if(current != null) {
			queue.enqueue(current);
			while(!queue.isEmpty()) {
				current = queue.dequeue();
				visit(sb, current);
				if(current.left != null) {
					queue.enqueue(current.left);
				}
				if(current.right != null) {
					queue.enqueue(current.right);
				}	
			}
		}
		return sb.toString();
	}

	// ******************************
	// Protected methods
	// ******************************
	
	/**
	 * Prints out the item at the given destination
	 * @param destination The node to print
	 */
	protected void visit(StringBuilder sb, JLeaf<T> destination) {
		sb.append(destination);
		sb.append(", ");
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		return (root == null) ? "" : root.toTreeString();
	}
}
