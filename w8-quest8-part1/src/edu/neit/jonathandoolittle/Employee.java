package edu.neit.jonathandoolittle;

/**
 * A simple employee, with a name and an age
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Sep 12, 2021
 *
 */
public class Employee implements Comparable<Employee> {

	// ******************************
	// Variables
	// ******************************

	// If true, compare by age, otherwise compare by name
	static boolean compareByAge = false;
	
	String name;
	int age;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new Employee instance
	 */
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// ******************************
	// Accessors & Mutators
	// ******************************

	/**
	 * @return This Employee's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The new name for this Employee
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return This Employee's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age The new age for this Employee
	 */
	public void setAge(int age) {
		this.age = age;
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public int compareTo(Employee o) {
		if(compareByAge) {
			return Integer.compare(age, o.getAge());
		} else {
			return name.compareTo(o.getName());
		}
	}

	@Override
	public String toString() {
		return String.format("%s - %d", name, age);
	}
}
