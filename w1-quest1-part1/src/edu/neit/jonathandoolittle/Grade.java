package edu.neit.jonathandoolittle;

/**
 * 
 * Represents a single grade, for a single {@link Student} in a single {@link Course}
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Jul 23, 2021
 *
 */

public class Grade {

	// ******************************
	// Variables
	// ******************************

	private String assignmentName;
	private float assignmentMaxValue;
	private float assignmentEarnedValue;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new grade item
	 * @param assignmentName The name of the assignment
	 * @param assignmentMaxValue The maximum possible grade that could be earned
	 * @param assingmentEarnedValue The grade received on the assignment
	 */
	public Grade(String assignmentName,
				float assignmentMaxValue,
				float assingmentEarnedValue) {
		
		if(assignmentMaxValue <= 0) {
			throw new IllegalArgumentException("assignmentMaxValue must be a positive, non-zero value");
		}
		
		this.assignmentName = assignmentName;
		this.assignmentMaxValue = assignmentMaxValue;
		this.assignmentEarnedValue = assingmentEarnedValue;
	}

	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Returns the floating point percentage grade value. For example, if {@code assignmentMaxValue} is 100
	 * and {@code assingmentEarnedValue} is 70, getPercentValue() would return 0.7f
	 * @return The grade's value as a percent
	 */
	public float getPercentValue() {
		return assignmentEarnedValue / assignmentMaxValue;
	}

	/**
	 * Gets the maximum points that could have been earned
	 * @return The maximum grade for this assignment
	 */
	public float getAssignmentMaxValue() {
		return assignmentMaxValue;
	}

	/**
	 * Gets the points earned
	 * @return The points earned on this assignment
	 */
	public float getAssignmentEarnedValue() {
		return assignmentEarnedValue;
	}
	
}
