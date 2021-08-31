package edu.neit.jonathandoolittle;

import java.util.Scanner;

/**
 * 
 * Drive for Quest 6 part 2, testing if a word is a palindrome using recursion
 * 
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 23, 2021
 *
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Hi! Wanna know if your word or phrase is a palindrome?");

		do {
			gatherPhrase(scanner);
		} 
		while (shouldRepeat(scanner));
		
		System.out.println("Thank you! Have a nice day!");
		scanner.close();
	}
	
	/**
	 * Gathers a word or phrase from the user and displays if it is, or is not, a palindrome
	 * @param scanner The scanner to collect input from
	 */
	public static void gatherPhrase(Scanner scanner) {
		System.out.print("Please enter your word or phrase > ");
		if(scanner.hasNextLine()) {
			String value = scanner.nextLine();
			
			System.out.print(value + " is ");
			
			if(!isPalindrome(value)) {
				System.out.print("not ");
			}
			
			System.out.print("a palindrome!\n");
		}
	}
	
	/**
	 * Asks the user if they would like to repeat the activity, using y or n
	 * @param scanner The scanner to collect input from
	 * @return True, if the user would like to repeat
	 */
	public static boolean shouldRepeat(Scanner scanner) {
		System.out.print("Would you like to try again? Type (y) to continue or (n) to exit > ");
		return (!scanner.nextLine().trim().equalsIgnoreCase("n"));
	}
	
	/**
	 * Determines if the word or phrase, when stripped of non-alphanumeric characters,
	 * is a palindrome, meaning the sequence of characters is the same both forwards and
	 * backwards
	 * @param s The string to test
	 * @return True, if the string is a palindrome
	 */
	static boolean isPalindrome(String s) {
		s = s.toLowerCase().replaceAll("[^a-z1-9]", "");
		
		if(s.length() <= 1) {
			return true;
		}
		
		if(s.charAt(0) == s.charAt(s.length()-1)) {
			return isPalindrome(s.substring(1, s.length()-1));
		}
			
		return false;
	}
	
}
