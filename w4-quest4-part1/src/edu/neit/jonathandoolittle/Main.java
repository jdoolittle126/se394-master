package edu.neit.jonathandoolittle;

import edu.neit.jonathandoolittle.sound.Sound;

/**
 * 
 * Driver class for quest 4, where we create a stack
 * to manage sound objects
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 10, 2021
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Let's create a stack!");
		
		JStack<Sound> stack = new JStack<>();
		stack.push(new Sound("Cows mooing", 80));
		stack.push(new Sound("Cows singing", 145));
		stack.push(new Sound("Cows playing tic-tac-toe", 60));
		
		System.out.println(stack.toString());
		System.out.println("Pop the top element: " + stack.pop());
		
		
		
	}
}
