package edu.neit.jonathandoolittle.game;

/**
 * 
 * A Character is a simple entity that contains a name, a health value,
 * and an asset. Characters are rendered to the screen in the @link{ListRenderer} 
 * component.
 *
 * <pre>
 *  Character character = new Character("Steve", 100, "player");
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 4, 2021
 *
 */
public class Character {

	// ******************************
	// Variables
	// ******************************

	private String name;
	private int health;
	private String asset;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new Character instance
	 * @param name The character's rendered name
	 * @param health The health value of this character
	 * @param asset The ID of the asset to render for this character
	 */
	public Character(String name, int health, String asset) {
		this.name = name;
		this.health = health;
		this.asset = asset;
	}

	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * @return This Character's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The new name for this Character
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return This Character's health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health The new health for this Character
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return This Character's asset
	 */
	public String getAsset() {
		return asset;
	}

	/**
	 * @param asset The new asset for this Character
	 */
	public void setAsset(String asset) {
		this.asset = asset;
	}
}
