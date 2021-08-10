package edu.neit.jonathandoolittle.sound;

/**
 * Represents a generic sound object, with a duration and
 * a name.
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 10, 2021
 *
 */
public class Sound {

	// ******************************
	// Variables
	// ******************************
	
	private String name;
	private int length;

	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new Sound instance
	 * @param name The name of this sound
	 * @param length The length of this sound, in seconds
	 */
	public Sound(String name, int length) {
		this.name = name;
		this.length = length;
	}

	// ******************************
	// Public methods
	// ******************************

	/**
	 * @return This Sound's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The new name for this Sound
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return This Sound's length in seconds
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length The new length for this Sound, in seconds
	 */
	public void setLength(int length) {
		this.length = length;
	}
	
	
	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		return String.format("Sound: %s | Duration: %d:%02d [%d]", 
							getName(), 
							getLength() / 60,
							getLength() % 60,
							getLength());
	}
	
	
}
