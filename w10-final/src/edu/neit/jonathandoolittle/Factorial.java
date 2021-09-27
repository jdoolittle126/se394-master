package edu.neit.jonathandoolittle;

/**
 * 
 * Factorial contains methods to calculate the factorial
 * of a value. Factorial is calculated by multiplying all 
 * integer values from 1 to n, and is denoted as n! For example
 * 5! would become 5 x 4 x 3 x 2 x 1 = 120
 * 
 * Factorial for 1, 0 are always 1, and when n is negative,
 * n! would be imaginary. This functionality is not included in
 * this software.
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Sep 20, 2021
 *
 */
public class Factorial {

	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Calculates the factorial of a given value by means of iteration
	 * @param value The value to calculate the factorial of ( value! )
	 * @return The factorial of value
	 * @throws IllegalArgumentException When the value is not positive
	 */
	public int byIteration(int value) {
		assertPositive(value);
		
		int result = 1;
		
		// Calculate factorial by multiplying the value by everything 
		// below it, until we hit 1
		for(int i = value; i > 1; i--) {
			result *= i;
		}
		
		return result;
	}
	
	/**
	 * Calculates the factorial of a given value by means of recursion
	 * @param value The value to calculate the factorial of ( value! )
	 * @return The factorial of value
	 * @throws IllegalArgumentException When the value is not positive
	 */
	public int byRecursion(int value) {
		if(value < 2) {
			// Factorial of 1, 0 = 1
			assertPositive(value);
			return 1;
		} 
		return byRecursion(value - 1) * value;
	}
	
	// ******************************
	// Private methods
	// ******************************
	
	/**
	 * Asserts the number is positive (> or = 0), as negative factorial cannot be calculated
	 * @param value The number to assert as positive
	 * @throws IllegalArgumentException When the value is not positive
	 */
	private void assertPositive(int value) {
		if(value < 0) {
			throw new IllegalArgumentException("Cannot calculate the factorial of a negative number!");
		}
	}
	
	// ******************************
	// Test Suite
	// ******************************
	
	
	public static void main(String[] args) {
		
		// Create a new factorial to use for testing
		Factorial f = new Factorial();
		
		recursiveFactorialTestSuite(f);
		iterativeFactorialTestSuite(f);
	}
	
	/**
	 * Tests factorial cases for the recursive function
	 * from -1 to 6, based on known values
	 * @param f The factorial object to test on
	 */
	public static void recursiveFactorialTestSuite(Factorial f) {
		System.out.println("Testing the recursive factorial method: ");
		assertEquals("n = 0 Test", 1, f.byRecursion(0));
		assertEquals("n = 1 Test", 1, f.byRecursion(1));
		assertEquals("n = 2 Test", 2, f.byRecursion(2));
		assertEquals("n = 3 Test", 6, f.byRecursion(3));
		assertEquals("n = 4 Test", 24, f.byRecursion(4));
		assertEquals("n = 5 Test", 120, f.byRecursion(5));
		assertEquals("n = 6 Test", 720, f.byRecursion(6));
		
		// Make sure bad input throws an error
		try {
			assertEquals("n = -1 Test", 1, f.byRecursion(-1));
			System.err.println("n = -1 Test failed!");
		} catch(IllegalArgumentException e) {
			System.out.println("n = -1 Test passed! (Exception was thrown: " + e.getMessage() + ")");
		}
		
	}
	
	/**
	 * Tests factorial cases for the iterative function
	 * from -1 to 6, based on known values
	 * @param f The factorial object to test on
	 */
	public static void iterativeFactorialTestSuite(Factorial f) {
		System.out.println("Testing the iterative factorial method: ");	
		assertEquals("n = 0 Test", 1, f.byIteration(0));
		assertEquals("n = 1 Test", 1, f.byIteration(1));
		assertEquals("n = 2 Test", 2, f.byIteration(2));
		assertEquals("n = 3 Test", 6, f.byIteration(3));
		assertEquals("n = 4 Test", 24, f.byIteration(4));
		assertEquals("n = 5 Test", 120, f.byIteration(5));
		assertEquals("n = 6 Test", 720, f.byIteration(6));
		
		// Make sure bad input throws an error
		try {
			assertEquals("n = -1 Test", 1, f.byIteration(-1));
			System.err.println("n = -1 Test failed!");
		} catch(IllegalArgumentException e) {
			System.out.println("n = -1 Test passed! (Exception was thrown: " + e.getMessage() + ")");
		}
	}
	
	/**
	 * Helper function for testing
	 * @param test The name of the test. Tests will be displayed as "Test Name passed!" or "Test Name failed! (Explanation)"
	 * @param expected The value that is known, and expected as a result
	 * @param actual The value received from computation
	 */
	public static void assertEquals(String test, int expected, int actual) {
		if(expected == actual) {
			System.out.println(test + " passed! (Result is " + actual + ")");
		} else {
			System.err.println(test + " failed! (Expected " + expected + " but received " + actual + ")");
		}	
	}
}
