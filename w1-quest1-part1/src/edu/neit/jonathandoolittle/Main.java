package edu.neit.jonathandoolittle;


/**
 * 
 * Driver class for Week 1's Quest
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Jul 20, 2021
 *
 */

public class Main {

	public static void main(String[] args) {

		Course ela = new Course("Language Arts");
		Course spanish = new Course("Spanish");
		Course math = new Course("Calculus 1");
		Course history = new Course("American History");
		
		ela.addGrade("Homework 1", 100, 90);
		ela.addGrade("Homework 2", 100, 88);
		ela.addGrade("Homework 3", 100, 70);
		ela.addGrade("Homework 4", 100, 100);
		ela.addGrade("Paper", 500, 400);
		
		spanish.addGrade("Spanish Greetings", 10, 10);
		spanish.addGrade("Spanish Vocab", 10, 7);
		spanish.addGrade("Spanish Quiz", 30, 29);
		
		math.addGrade("Intergration Quiz", 100, 100);
		math.addGrade("Homework", 50, 40);
		
		history.addGrade("Civil War Study Guide", 100, 90);
		history.addGrade("Homework", 10, 7);
		history.addGrade("Test", 200, 199);
		history.addGrade("Reading Quiz", 50, 100);
		
		Student jonathan = new Student("Jonathan", ela, spanish, math, history);
		
		Student kyle = new Student("Kyle", history, history);
		
		ReportCard.printReport(kyle);
		
		ReportCard.printReport(jonathan);
		
		
		
		
	}
	
}
