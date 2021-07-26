package edu.neit.jonathandoolittle;

public class ReportCard {

	/**
	 * Prints a student's report card to the console
	 * @param student The student to generate a report card for
	 */
	public static void printReport(Student student) {
		StringBuilder builder = new StringBuilder();
		
		// Header with student's name
		builder.append(String.format("STUDENT: %s%n%n", student.getName()));
		
		// Go through each course, and print the name of the course, final grade, as well as some statistics
		for(Course course : student.getCourses()) {
			builder.append(String.format(" COURSE: %-35s FINAL GRADE: %.2f%%%n", course.getName(), course.getWeightedAverage()*100f));
			builder.append(String.format("  TOTAL ASSIGNMENTS: %d%n", course.getTotalAssignments()));
			builder.append(String.format("  AVERAGE ASSIGNMENT GRADE: %.2f%%%n%n", course.getAverage()*100f));
		}
		
		// Message for students with no courses
		if(student.getCourses().isEmpty()) {
			builder.append(" NO GRADES!");
		}
		
		// Print
		System.out.println(builder.toString());		
	}
	
}
