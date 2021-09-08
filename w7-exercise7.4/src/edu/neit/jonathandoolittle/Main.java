package edu.neit.jonathandoolittle;

/**
 * Driver for exercise 7.4
 *
 * @author Jonathan Doolittle
 * @version 0.4 - Sep 3, 2021
 *
 */
public class Main {


	public static void main(String[] args) {
		runTreeDeleteTest(29);
		runTreeDeleteTest(31);
		runTreeDeleteTest(13);

	}
	
	public static void runTreeDeleteTest(int node) {
		JTree<Integer> tree = new JTree<>();
		tree.insert(13, 10, 2, 12, 25, 20, 31, 29);
		System.out.println("Before Deleting " + node);
		
		System.out.println(tree);
		
		tree.findAndDeleteByMerging(node);
		
		System.out.println("After Deleting " + node);
		System.out.println(tree);
	}

}
