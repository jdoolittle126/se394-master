package edu.neit.jonathandoolittle;

/**
 * 
 * Fibonacci finder, both iterative and recursive
 * 
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 23, 2021
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		for(int i = 0; i < 20; i++ ) {
			System.out.println(String.format("Fibonacci number at index %d is %d (recursive) %d (iterative)", i, getNthFibonacci(i), getNthFibonacciIterative(i)));
		}
	}

	
	/**
	 * Validates Fibonacci index parameters
	 * @param n The parameter to test
	 * @throws IllegalArgumentException if n is < 0
	 */
	public static void validateParameters(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("Index cannot be less than zero");
		}
	}
	
	/**
	 * Returns the Fibonacci number at the given index
	 * @param n The index
	 * @return The Fibonacci number
	 * @throws IllegalArgumentException if n is < 0
	 */
	public static int getNthFibonacci(int n){
		validateParameters(n);
		if(n <= 1) return n;
		return getNthFibonacci(n-1) + getNthFibonacci(n-2);
	}
	
	/**
	 * Returns the Fibonacci number at the given index
	 * @param n The index
	 * @return The Fibonacci number
	 * @throws IllegalArgumentException if n is < 0
	 */
	static int getNthFibonacciIterative(int n) {
		validateParameters(n);
		
		int a = 0; // First Fibonacci Number (Index 0)
		int b = 1; // Second Fibonacci Number (Index 1)
		int c = 0; // Temp 
		
		for(int i = 1; i <= n; i++) {
			c = b; // Store original b value in c
			b = a + b; // New b value is a + original b, where a is eq. to (n-2) and b eq. to (n-1) in past example
			a = c; // a is now original b
		}
		// Return a
		return a;
	}
	
}
