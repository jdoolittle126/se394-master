package edu.neit.jonathandoolittle;

/**
 * 
 * Demonstration of a recursive POW function
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 23, 2021
 *
 */
public class NonRecursiveFunction {

	public static void main(String[] args) {
		
		int count = 10000;
		
		// Stress Test
		try {	
			while(true) {
				power(5.6, count);
				count++;
			}
		} catch(StackOverflowError e) {
			System.out.println(count);
		}
		
		System.out.println(power(5.6, 2));

	}
	
	/**
	 * Raises a number to the given power
	 * @param value The value to use
	 * @param power The power to raise
	 * @return The result
	 */
	static double power(double value, int power) {
		if(power == 0) {
			return 1.0;
		}
		return value * power(value, power-1);
	}


}
