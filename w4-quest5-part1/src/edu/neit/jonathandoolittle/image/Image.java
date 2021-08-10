package edu.neit.jonathandoolittle.image;

/**
 * 
 * Represents a generic image
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 10, 2021
 *
 */
public class Image {

	// ******************************
	// Variables
	// ******************************

	private String name;
	private int width;
	private int height;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new Image instance
	 * @param name The name of this image
	 * @param width The width, in pixels, of this image
	 * @param height The height, in pixels, of this image
	 */
	public Image(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}

	// ******************************
	// Public methods
	// ******************************

	/**
	 * @return This Image's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name The new name for this Image
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return This Image's width in pixels
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @param width The new width for this Image in pixels
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * @return This Image's height in pixels
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @param height The new height for this Image in pixels
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		return String.format("Image: %s %dx%d", name, width, height);
	}
	
}
