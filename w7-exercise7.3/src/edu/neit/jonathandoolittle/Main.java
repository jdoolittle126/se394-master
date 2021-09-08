package edu.neit.jonathandoolittle;

/**
 * Driver for exercise 7.3
 *
 * @author Jonathan Doolittle
 * @version 0.3 - Sep 3, 2021
 *
 */
public class Main {


	public static void main(String[] args) {
		JTree<Integer> tree = new JTree<>();
		tree.insert(13, 10, 2, 12, 25, 20, 31, 29);
		System.out.println(tree);
		
		tree.inOrder();

	}

}
