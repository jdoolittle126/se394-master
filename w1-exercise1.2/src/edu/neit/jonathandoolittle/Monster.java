package edu.neit.jonathandoolittle;

/**
 * 
 * A simple monster class for Week 1's 1.2 exercise. Demonstrates the basic structure of a Java Object
 * 
 * <pre> 
 *    Monster monster = new Monster();
 *    monster.getName();
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Jul 20, 2021
 *
 */

public class Monster {

	// ******************************
	// Variables
	// ******************************

	String name;
	int age;

	// ******************************
	// Public methods
	// ******************************

	/**
	 * @return The monster's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set this Monster's name
	 * @param name The Monster's new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The Monster's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Set this Monster's age (years)
	 * @param age The Monster's new age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		return String.format("Your monster's name is %s, and it is %d years old!", getName(), getAge());
	}
	
}
