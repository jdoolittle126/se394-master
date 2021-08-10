package edu.neit.jonathandoolittle;

/**
 * 
 * Driver class for exercise 4.1, stacks
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 10, 2021
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Let's create a stack!");
		
		LLStack<Integer> stack = new LLStack<>();
		stack.push(10);
		stack.push(5);
		stack.push(7);
		stack.push(11);
		stack.push(11);
		
		System.out.println(stack.toString());
		System.out.println("Pop the top element: " + stack.pop());
		
	}
}
