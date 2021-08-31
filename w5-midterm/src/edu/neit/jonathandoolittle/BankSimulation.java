package edu.neit.jonathandoolittle;

import java.util.Random;

/**
 * 
 * Driver Class for Midterm
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 16, 2021
 *
 */
public class BankSimulation {
	
	static double linePercentGlobal = 0.0;
	static double waitTimeGlobal = 0.0;
	static int runs = 0;
	
	
	static Random rd = new Random();
	
	static int Option(int percents[]) {
		int i = 0, perc, choice = Math.abs(rd.nextInt()) % 100 + 1;
		for(perc = percents[0]; perc < choice; perc += percents[i+1], i++);
		return i;
	}

	/**
	 * Runs a trial of Bank One simulation with the given number of clerks
	 * @param numOfClerks The number of clerks
	 */
	public static void runTrial(int numOfClerks) {
		int[] arrivals = {15,20,25,10,30};
		int[] service = {0,0,0,10,5,10,10,0,15,25,10,15};
		
		int[] clerks = new int[numOfClerks];
		
		int clerksSize = clerks.length;
		int customers, t, i, numOfMinutes = 100, x = 0;
		double maxWait = 0.0, thereIsLine = 0.0, currWait = 0.0;
		
		Queue simulQ = new Queue();
		
		for(t = 1; t <= numOfMinutes; t++) {
			System.out.print(" t = " + t);
			for (i = 0; i < clerksSize; i++) {
				if(clerks[i] < 60)
					clerks[i] = 0;
				else 
					clerks[i] -= 60;
			}
			
			customers = Option(arrivals);
			
			for (i = 0; i < customers; i++) {
				x = Option(service) * 10;
				simulQ.enqueue(new Integer(x));
				currWait += x;
			}
			
			for (i = 0; i < clerksSize && !simulQ.isEmpty();) 
				if(clerks[i] < 60) {
					x = ((Integer) simulQ.dequeue()).intValue();
					clerks[i] += x;
					currWait -= x;
				} else {
					i++;
				}
				
			if(!simulQ.isEmpty()) {
				thereIsLine++;
				System.out.print(" wait = " + ((long)(currWait/6.0)) / 10.0);
				if(maxWait < currWait)
					maxWait = currWait;
			}
			else System.out.print(" wait = 0");
			
		}
		
		System.out.println("\nFor " + clerksSize + " clerks, there was a line " + 
							thereIsLine/numOfMinutes*100.0 + 
							"% of the time;\nmaximum wait time was "
							+ maxWait/60.0 + "min.");
		
		waitTimeGlobal += maxWait/60.0;
		linePercentGlobal += thereIsLine/numOfMinutes*100.0;
		runs++;
		
	}
	
	
	
	public static void main(String[] args) {
		
		// Based on research, 5-10min wait in line is the
		// maximum before sales are lost
		
		for(int i = 0; i < 100; i++) {
			runTrial(4);
		}
		
		System.out.println("Average wait time: " + waitTimeGlobal / runs + "mins");
		System.out.println("Average line percentage: " + linePercentGlobal / runs + "%");
		
	}
}
