package edu.neit.jonathandoolittle.game;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * Game is a class that creates the swing components for this
 * simple demo. Initializing Game will launch the window.
 *
 * <pre>
 *  Game game = new Game();
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Aug 4, 2021
 *
 */
public class Game {

	// ******************************
	// Variables
	// ******************************

	static final String GAME_NAME = "My Character List!";
	static final String[] RANDOM_NAMES = {"Reggie", "George", "Kyle", "Jess", "Julia", 
										"Rob", "Mark", "Todd","Norm", "Lucy", "Ray", "Sam"};
	private Random random;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new Game instance
	 */
	public Game() {
		random = new Random();
		init();
	}

	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Builds the frames and event listeners for this game. This could be improved upon,
	 * but for the sake of time and the scope of this exercise, I am leaving it like this.
	 */
	public void init() {
		JFrame frame = new JFrame(GAME_NAME);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(600,300);
	    ListRenderer listRenderer = new ListRenderer();
	    JPanel buttonPanel = new JPanel();
	    JButton buttonAddPlayer = new JButton("Add a Player!");
	    JButton buttonAddDoctor = new JButton("Add a Doctor!");
	    JButton buttonAddFarmer = new JButton("Add a Farmer!"); 
	    JButton buttonPop = new JButton("Remove a Character!"); 
	    
	    // Add an event lister to add a character, and then redraw the window
	    buttonAddPlayer.addActionListener(l -> {
	    	listRenderer.addCharacter(makeRandomCharacterOfType("player"));
	    	frame.invalidate();
	    	frame.repaint();
	    });
	    
	    buttonAddDoctor.addActionListener(l -> {
	    	listRenderer.addCharacter(makeRandomCharacterOfType("doctor"));
	    	frame.invalidate();
	    	frame.repaint();
	    });
	    
	    buttonAddFarmer.addActionListener(l -> {
	    	listRenderer.addCharacter(makeRandomCharacterOfType("farmer"));
	    	frame.invalidate();
	    	frame.repaint();
	    });
	    
	    buttonPop.addActionListener(l -> {
	    	listRenderer.popCharacter();
	    	frame.invalidate();
	    	frame.repaint();
	    });
	    
	    
	    buttonPanel.add(buttonAddPlayer);
	    buttonPanel.add(buttonAddFarmer);
	    buttonPanel.add(buttonAddDoctor);
	    buttonPanel.add(buttonPop);
	    frame.setLayout(new GridLayout(2, 1));
	    frame.add(listRenderer);
	    frame.add(buttonPanel);
	    frame.setVisible(true);
	}	
	
	// ******************************
	// Private methods
	// ******************************
	
	/**
	 * Creates a random character!
	 * @param type The type of character
	 * @return The new character
	 */
	private Character makeRandomCharacterOfType(String type) {
		return new Character(RANDOM_NAMES[random.nextInt(RANDOM_NAMES.length)], random.nextInt(99)+1, type);
	}
}
