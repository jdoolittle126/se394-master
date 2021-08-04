package edu.neit.jonathandoolittle.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import edu.neit.jonathandoolittle.list.JList;

/**
 * 
 * A ListRender is a JPanel that renders {@link Character}s on the screen
 * from a {@link JList}. 
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 4, 2021
 *
 */
public class ListRenderer extends JPanel {

	// ******************************
	// Variables
	// ******************************
	
	private static final long serialVersionUID = 1L;
	private File path = new File("assets\\");
	private transient JList<Character> characterList;
	private transient HashMap<String, BufferedImage> imageCache;
	private boolean isCached;

	// ******************************
	// Constructors
	// ******************************
	
	/**
	 * Creates a new ListRenderer instance
	 */
	public ListRenderer() {
		isCached = loadImageCache();
		characterList = new JList<>();
	}
	
	// ******************************
	// Public methods
	// ******************************

	/**
	 * Adds a new character to the root list for rendering
	 * @param character The character to add
	 */
	public void addCharacter(Character character) {
		characterList.add(character);
	}
	
	/**
	 * Removes the last character in the list
	 */
	public void popCharacter() {
		characterList.pop();
	}
	
	// ******************************
	// Private methods
	// ******************************
	
	/**
	 * Preloads all of the assets in a HashMap so they can be rendered
	 * @return True, if loading was successful
	 */
	private boolean loadImageCache() {
		imageCache = new HashMap<>();
		
		try {
			imageCache.put("b-left", ImageIO.read(new File(path, "b-left.png")));
			imageCache.put("b-right", ImageIO.read(new File(path, "b-right.png")));
			imageCache.put("player", ImageIO.read(new File(path, "player.png")));
			imageCache.put("farmer", ImageIO.read(new File(path, "farmer.png")));
			imageCache.put("doctor", ImageIO.read(new File(path, "doctor.png")));
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
		
		if(isCached) {
			// The front '['
			arg0.drawImage(imageCache.get("b-left"), 20, 20, this);
			
			// Each image is 64x64, so I hard coded some values here for simplicity.
			// They don't scale to window or anything, but for this assignment that is unnecessary
			for(int i =0; i < characterList.getLength(); i++) {
				int xLoc = (i*64)+84;
				Character character = characterList.at(i);
				
				if(imageCache.containsKey(character.getAsset())) {
					arg0.drawImage(imageCache.get(character.getAsset()), xLoc, 20, this);
				}
				arg0.drawString(character.getName(), xLoc, 100);
				arg0.drawString("HP: " + character.getHealth(), xLoc, 120);
			}
			
			// The closing ']'
			arg0.drawImage(imageCache.get("b-right"), 20+(characterList.getLength()*64)+64, 20, this);
			
		}
		
		
	}
	
	
}
