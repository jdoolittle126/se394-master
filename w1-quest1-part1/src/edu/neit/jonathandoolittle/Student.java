package edu.neit.jonathandoolittle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Represents a student, who can have grades and courses
 * 
 * <pre> 
 *    Student sam = new Student("Sam Smith");
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Jul 23, 2021
 *
 */

public class Student {

	// ******************************
	// Variables
	// ******************************

	String studentName;
	LinkedList<Course> courses;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new student
	 * @param studentName The student's name
	 * @param courses Optional courses to be included on creation
	 */
	public Student(String studentName, Course... courses) {
		this.studentName = studentName;
		this.courses = new LinkedList<>();
		addCourses(courses);
	}

	// ******************************
	// Public methods
	// ******************************

	/**
	 * Adds new courses for this student
	 * @param courses The courses to add
	 */
	public void addCourses(Course... courses) {
		this.courses.addAll(Arrays.asList(courses));
	}

	/**
	 * @return The name of this student
	 */
	public String getName() {
		return studentName;
	}
	
	/**
	 * @return A list of all courses for this student
	 */
	public List<Course> getCourses() {
		return courses;
	}
}
