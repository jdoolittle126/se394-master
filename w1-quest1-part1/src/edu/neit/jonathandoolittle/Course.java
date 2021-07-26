package edu.neit.jonathandoolittle;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 
 * Represents a course for a single {@link Student}
 * 
 * <pre> 
 *    Course history = new Course("History");
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Jul 23, 2021
 *
 */

public class Course {

	// ******************************
	// Variables
	// ******************************

	private String courseName;
	private LinkedList<Grade> grades;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new course
	 * @param courseName The name of this course
	 * @param grades Optional grades to be included on creation
	 */
	public Course(String courseName, Grade... grades) {
		this.courseName = courseName;
		this.grades = new LinkedList<>();
		addGrades(grades);
	}

	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Creates a new grade and appends it to this course
	 * @param assignmentName The name of the assignment
	 * @param assignmentMaxValue The maximum possible grade that could be earned
	 * @param assingmentEarnedValue The grade received on the assignment
	 */
	public void addGrade(String assignmentName,
			float assignmentMaxValue,
			float assingmentEarnedValue) {
		grades.add(new Grade(assignmentName, assignmentMaxValue, assingmentEarnedValue));
	}
	
	/**
	 * Adds a collection of grades to this course
	 * @param grades The grades to add
	 */
	public void addGrades(Grade... grades) {
		this.grades.addAll(Arrays.asList(grades));
	}
	
	/**
	 * @return The name of this course
	 */
	public String getName() {
		return this.courseName;
	}
	
	/**
	 * @return The total number of assignments
	 */
	public int getTotalAssignments() {
		return grades.size();
	}
	
	/**
	 * @return The un-weighted average per assignment (returns 1.0f if no assignments exist)
	 */
	public float getAverage() {
		
		if(getTotalAssignments() <= 0) {
			return 1.0f;
		}
		
		float total = 0.0f;
		
		for(Grade g : grades) {
			total += g.getPercentValue();
		}
		
		return total / getTotalAssignments();
		
	}
	
	/**
	 * @return The weighted average of all assignments (returns 1.0f if no assignments exist)
	 */
	public float getWeightedAverage() {
		
		float earnedPoints = 0.0f;
		float totalPoints = 0.0f;
		
		for(Grade g : grades) {
			earnedPoints += g.getAssignmentEarnedValue();
			totalPoints += g.getAssignmentMaxValue();
		}
		
		if(totalPoints <= 0) {
			return 1.0f;
		}
		
		return earnedPoints / totalPoints;
		
	}

}
