package edu.neit.jonathandoolittle;

/**
 * 
 * Demonstration of a non-recursive POW function
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 23, 2021
 *
 */
public class NonRecursiveFunction {

	public static void main(String[] args) {
		
		System.out.println(power(5.6, 2));

	}
	
	/**
	 * Raises a number to the given power
	 * @param value The value to use
	 * @param power The power to raise
	 * @return The result
	 */
	static double power(double value, int power) {
		double result = 1;
		if(power > 0) {
			for(result = value; power > 1; --power) {
				result *= value;
			}
		}
		return result;
	}


}
