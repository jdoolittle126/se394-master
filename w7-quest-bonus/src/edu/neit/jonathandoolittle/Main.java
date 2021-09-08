package edu.neit.jonathandoolittle;

import java.util.Random;
import java.util.function.Function;

/**
 * Driver for the bonus quest
 *
 * @author Jonathan Doolittle
 * @version 0.4 - Sep 3, 2021
 *
 */
public class Main {

	private static Random random = new Random();
	
	public static void main(String[] args) {
		
		// Part A
		System.out.println("(A.) Creating players...\n");
		Player one = new Player("Player One", 13);
		Player two = new Player("Player Two", 10);
		Player three = new Player("Player Three", 2);
		Player four = new Player("Player Four", 12);
		Player five = new Player("Player Five", 25);
		Player six = new Player("Player Six", 20);
		Player seven = new Player("Player Seven", 31);
		Player eight = new Player("Player Eight", 29);
		
		// Part B
		System.out.println("(B.) Inserting players into tree...\n");
		JTree<Player> playerTree = new JTree<>();
		playerTree.insert(one, two, three, four, five, six, seven, eight);

		// Part C
		System.out.println("(C.) Here is the tree of players\n");
		System.out.println(playerTree);
	
		System.out.println("(C.) Here are the players, from lowest level to highest");
		System.out.println(playerTree.inOrder() + "\n");
		
		// Part D
		System.out.println("(D.) Searching for the first player with a level of 25");
		
		// Can't use predicates because comparison is needed, so I decided on a function that acts as a 'compareTo' method
		Function<Player, Integer> search = p -> { 
			return p.level.compareTo(new Level(25)); 
		};
		
		System.out.println(playerTree.search(search).key.getDisplay() + " You found me!\n");
		
		//Part E
		System.out.println("(E.) Here are the players, from top to bottom, left to right\n");
		
		System.out.println(playerTree.breadthFirst() + "\n");
		
		// Part F
		System.out.println("(F.) Here are the players, before removing Player Five (LVL 25) \n");
		
		System.out.println(playerTree);
		
		playerTree.findAndDeleteByMerging(five);
		
		System.out.println("(F.) Here are the players, after removing Player Five \n");
		
		System.out.println(playerTree);
		
		// Adding some more players, for fun!
		
		Player jon = new Player("JonnyBoy");
		Player george = new Player("DrSaban7", 50);
		Player jason = new Player("JSON", 3);
		Player tim = new Player("TallTim3");
		
		System.out.println("Our Gameplay Dialog\n");
		
		randomQuest(jon, "cleaning the dishwasher");
		randomQuest(jon, "mowing the lawn");
		randomQuest(george, "defeating some weird dragon");
		randomQuest(jon, "milking a coconut");
		randomQuest(jason, "seperating the m's and the w's in the m&m jar");
		randomQuest(george, "finding the missing socks from yesterday's laundry");
		randomQuest(jon, "trying to pronouce wor.. werster...wERRs.. cestershire sauce");
		randomQuest(tim, "trying to dearm a man on a spork rampage");
		randomQuest(jason, "opening an extra-tight jar of pickles");
		randomQuest(tim, "asking the moon to stop moving all the water");
		randomQuest(jason, "trying to find a single working McDonald's icecream machine");
		
		
		playerTree.insert(jon, george, jason, tim);
		
		System.out.println();
		System.out.println(playerTree);
		System.out.println("Added ourselves in the game! Now lets see the order:");
		System.out.println("\n\t"+playerTree.inOrder().replace(", ", "\n\t"));
		
	}
	
	public static void randomQuest(Player player, String questName) {
		
		System.out.println(player.getDisplay() + "I am taking on the quest of " + questName);
		
		int questXp = random.nextInt(1000) * random.nextInt(25 + player.getLevel());
		boolean success = random.nextInt(player.getLevel()) + 
				(Level.HIGHEST_LEVEL_SO_FAR - player.getLevel()) >= 
				random.nextInt(Level.HIGHEST_LEVEL_SO_FAR * 2);
		
		if(success) {
			player.addXp(questXp);
			System.out.println(player.getDisplay() + "I have finished the quest! [XP EARNED: " + questXp + "]");
		} else {
			System.out.println(player.getName() + " was unable to complete the quest, and missed out on " + questXp + " XP");
		}
		
	}
	

}
