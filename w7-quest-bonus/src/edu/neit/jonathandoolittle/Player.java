package edu.neit.jonathandoolittle;

/**
 * 
 * A player in our mock game
 * 
 * @author Jonathan Doolittle
 * @version 0.1 - Sep 4, 2021
 *
 */
public class Player implements Comparable<Player> {

	// ******************************
	// Variables
	// ******************************
	
	String name;
	Level level;

	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new Player instance
	 * @param name The name of this player
	 */
	public Player(String name) {
		this(name, 1);
	}
	
	/**
	 * Creates a new Player instance
	 * @param name The name of this player
	 * @param level The starting level of this player
	 */
	public Player(String name, int level) {
		this.name = name;
		this.level = new Level(level);
	}

	// ******************************
	// Public methods
	// ******************************

	/**
	 * @return The player's name and title
	 */
	public String getName() {
		return name + " " + Level.getTitle(level);
	}
	
	/**
	 * @return The player's current level
	 */
	public int getLevel() {
		return level.currentLevel;
	}
	
	/**
	 * @return The player's chat name
	 */
	public String getDisplay() {
		return "|LVL " + getLevel() + "| " + getName() + ": ";
	}
	
	/**
	 * @return The player's current XP
	 */
	public int getXp() {
		return level.xp;
	}
	
	/**
	 * @param xp The XP to add
	 */
	public void addXp(int xp) {
		level.addXp(xp);
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public int compareTo(Player other) {
		return level.compareTo(other.level);
	}

	@Override
	public String toString() {
		return getName() + " (LVL " + getLevel() + ")";
	}
}
