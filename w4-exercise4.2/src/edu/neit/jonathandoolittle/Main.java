package edu.neit.jonathandoolittle;

/**
 * 
 * Driver class for exercise 4.2, queues
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 10, 2021
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Let's create a queue!");
		
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(10);
		queue.enqueue(5);
		queue.enqueue(7);
		queue.enqueue(11);
		queue.enqueue(-3);
		
		System.out.println(queue.toString());
		System.out.println("The first element: " + queue.dequeue());
		
	}
}
