package edu.neit.jonathandoolittle;

/**
 * 
 * Represents a node in a {@link JTree}, 
 * which is a type of Binary Search Tree
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Sep 3, 2021
 *
 */
public class JLeaf<T extends Comparable<T>> {

	// ******************************
	// Variables
	// ******************************
	
	protected T key;
	protected JLeaf<T> left;
	protected JLeaf<T> right;

	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new JLeaf instance
	 */
	public JLeaf() {
		left = right = null;
	}
	
	/**
	 * Creates a new JLeaf instance
	 * @param item The item for this node to hold
	 */
	public JLeaf(T item) {
		this(item, null, null);
	}
	
	/**
	 * Creates a new JLeaf instance
	 * @param item The item for this node to hold
	 * @param left The left leaf
	 * @param right The right leaf
	 */
	public JLeaf(T item, JLeaf<T> left, JLeaf<T> right) {
		this.key = item;
		this.left = left;
		this.right = right;
	}
	
	// ******************************
	// Public Methods
	// ******************************
	
	/**
	 * Builds a ASCII visual of the tree
	 * @return The ASCII String
	 */
	public String toTreeString() {
		StringBuilder sb = new StringBuilder();
		toTreeString(sb, "", "");
		return sb.toString();
	}
	
	/**
	 * Recursive call for each node, building a visual of the tree
	 * @param sb The {@link StringBuilder} to use
	 * @param prefix The prefix for this node
	 * @param nextPrefix The prefix for the next node
	 */
	protected void toTreeString(StringBuilder sb, String prefix, String nextPrefix) {
		sb.append(prefix);
		sb.append(this.toString());
		sb.append("\n");
		
		if(left != null) {
			if(right == null) {
				left.toTreeString(sb, nextPrefix + "|_", nextPrefix + "  ");
			} else {
				left.toTreeString(sb, nextPrefix + "|_", nextPrefix + "| ");
			}
		}
		if(right != null) {
			right.toTreeString(sb, nextPrefix + "|_", nextPrefix + "  ");
		}
		
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		return key.toString();
	}
	
	
}
