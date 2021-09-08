package edu.neit.jonathandoolittle;

import java.util.Objects;

/**
 * 
 * Handles leveling for our mock game.
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Sep 4, 2021
 *
 */
public class Level implements Comparable<Level> {

	// ******************************
	// Variables
	// ******************************

	static int HIGHEST_LEVEL_SO_FAR = 1;
	int currentLevel;
	int xp;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new Level instance
	 */
	public Level() {
		currentLevel = 1;
		xp = 0;
	}
	
	/**
	 * Creates a new Level instance
	 * @param level The level to start at
	 */
	public Level(int level) {
		this();
		currentLevel = level;
		if(currentLevel > HIGHEST_LEVEL_SO_FAR) {
			HIGHEST_LEVEL_SO_FAR = currentLevel;
		}
	}

	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Gets the title for a player of this level
	 * @param level The level of the player
	 * @return The title
	 */
	public static String getTitle(Level level) {
		return getTitle(level.currentLevel);
	}
	
	/**
	 * Gets the title for a player of this level
	 * @param level The level of the player
	 * @return The title
	 */
	public static String getTitle(int level) {
		
		if(level < 5) {
			return "the scavenger";
		} else if(level < 15) {
			return "the savage";
		} else if(level < 23) {
			return "the warrior";
		} else if(level < 32) {
			return "the champion";
		} else if(level < 45) {
			return "the dictator";
		} else if(level < 55) {
			return "the strongman";
		} else if(level < 62) {
			return "the caudillo";
		} else if(level < 100) {
			return "the warlord";
		} else {
			return "the deity";
		}	
	}
	
	/**
	 * Adds the xp to this level, and levels up if requirements are met
	 * @param gainedXp The xp gained
	 */
	public void addXp(int gainedXp) {
		int xpRequired = xpRequiredForLevel(currentLevel + 1);
		this.xp += gainedXp;
		
		if(xp >= xpRequired) {
			currentLevel++;
			xp -= xpRequired;
			if(currentLevel > HIGHEST_LEVEL_SO_FAR) {
				HIGHEST_LEVEL_SO_FAR = currentLevel;
			}
			addXp(0);
		}
	}

	// ******************************
	// Private methods
	// ******************************
	
	/**
	 * Leveling is meant to be progressively harder, so the XP required to
	 * achieve level x from level x - 1 is defined as: x ^ (log10(x)) * 100.
	 * This value is then floored to the nearest whole number.
	 * @param level The level desired
	 * @return The XP required when at level - 1 to achieve level
	 */
	private static int xpRequiredForLevel(int level) {
		return (int) (Math.pow(level, Math.log10(level)) * 100);
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public int compareTo(Level o) {
	
		if(o.currentLevel == currentLevel) {
			return Integer.compare(xp, o.xp);
		} else {
			return Integer.compare(currentLevel, o.currentLevel);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj instanceof Level) {
			Level l = (Level)obj;
			return l.currentLevel == currentLevel && l.xp == xp;	
		}
		return false;
	}

	@Override
	public int hashCode() {
        return Objects.hash(xp, currentLevel);
	}

}
