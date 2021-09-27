package edu.neit.jonathandoolittle;

/**
 * 
 * Driver for quest 8
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Sep 12, 2021
 *
 */
public class Main {

	
	public static void main(String[] args) {
		
		System.out.println("Sorting employees by name");
		Employee.compareByAge = false;
		timeSort();
		
		System.out.println("Sorting employees by age");
		Employee.compareByAge = true;
		timeSort();
		
	}
	
	public static void timeSort() {
		
		Employee[] employees = {
				new Employee("Martha", 34),
				new Employee("Sam", 54),
				new Employee("Kyle", 62),
				new Employee("Sally", 22),
				new Employee("Mark", 46),
				new Employee("Gary", 44),
				new Employee("Abby", 26),
				new Employee("Kayla", 19),
				new Employee("Steff", 47),
				new Employee("Steven", 22)
		};
		
		long start = System.nanoTime();
		Quicksort.sort(employees);
		long end = System.nanoTime();
		System.out.println("Elapsed time: " + (end - start) / 1000000.0 + "ms");
		for(Employee e : employees) {
			System.out.println(e);
		}
	}
	
}
