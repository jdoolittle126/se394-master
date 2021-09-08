package edu.neit.jonathandoolittle;

/**
 * Driver for exercise 7.1
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Sep 3, 2021
 *
 */
public class Main {


	public static void main(String[] args) {
		JTree<Integer> tree = new JTree<>();
		tree.insert(13, 10, 2, 12, 25, 20, 31, 29);
		
		System.out.println(tree.search(tree.root, 7));

	}

}
