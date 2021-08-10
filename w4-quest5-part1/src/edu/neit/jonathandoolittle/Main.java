package edu.neit.jonathandoolittle;

import edu.neit.jonathandoolittle.image.Image;

/**
 * 
 * Driver class for quest 5, where we create a queue
 * to manage image objects
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 10, 2021
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Let's create a queue!");
		
		JPriorityQueue<Image, Integer> queue = new JPriorityQueue<>();
		queue.enqueue(new Image("milk.jpg", 1920, 1080));
		queue.enqueue(new Image("priority.jpg", 720, 1080), 50); // Priority of 50
		queue.enqueue(new Image("fish.png", 128, 128));
		queue.enqueue(new Image("car.bmp", 500, 500), 50); // Also a priority of 50, but added after, so it should be behind the other 50
		queue.enqueue(new Image("tall_cactus.webp", 100, 4000), 6); // Priority of 6 should be before all non-priority, but behind the others
		
		System.out.println(queue.toString());
		
		System.out.println("These should be our two highest priority items:");
		
		System.out.println(queue.dequeue().toString());
		System.out.println(queue.dequeue().toString());
		
	}
}
