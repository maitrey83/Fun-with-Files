/*
 * File: MagneticPoetry.java
 * ================================================================
 * A program that simulates magnetic poetry.
 */
import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MagneticPoetry extends GraphicsProgram {
	/* Size the window to be appropriately large. */
	public static final int APPLICATION_WIDTH = 1000;
	public static final int APPLICATION_HEIGHT = 600;
	
	/* Where we should get our words from. */
	private static final String WORDS_FILE = "karel-words.txt";
	
	/* Sets up the world and initializes mouse listeners. */
	public void run() {
		addMagneticWords();
		addMouseListeners();
	}
	
	/**
	 * Loads the magnetic words from the words file.
	 */
	private void addMagneticWords() {
		try {
			/* Open the file for reading. */
			BufferedReader br = new BufferedReader(new FileReader(WORDS_FILE));
			
			/* Continuously read words until we've read all words. */
			while (true) {
				String word = br.readLine();
				if (word == null) break;
				
				addWord(word);
			}
			br.close();
		} catch (IOException e) {
			// Do nothing. :-(
		}
	}
	
	/**
	 * Creates and adds a magnet for the given word.
	 *
	 * @param word The text of the magnet.
	 */
	private void addWord(String word) {
		/* Create the magnet and set the color and font. */
		GLabel magnet = new GLabel(word);
		magnet.setColor(Color.BLUE);
		magnet.setFont("DejaVuSerif-18-BOLD");
		
		/* Choose a random position for the magnet. */
		RandomGenerator rgen = RandomGenerator.getInstance();
		double x = rgen.nextDouble(0, getWidth() - magnet.getWidth());
		double y = rgen.nextDouble(magnet.getAscent(), getHeight());
		
		/* Add the magnet. */
		magnet.setLocation(x, y);
		add(magnet);
	}
	
	/* The currently-selected object, or null if nothing is
	 * selected.
	 */
	private GObject selected = null;
	
	/* The X and Y coordinates of where the mouse last was. */
	private double lastX;
	private double lastY;
	
	/**
	 * When the mouse is pressed, select the appropriate object.
	 */
	public void mousePressed(MouseEvent e) {
		/* See what we hit. */
		selected = getElementAt(e.getX(), e.getY());
		if (selected != null) {
			selected.setColor(Color.RED);
			
			/* Track the X and Y coordinates of the mouse. */
			lastX = e.getX();
			lastY = e.getY();
		}
	}
	
	/**
	 * When the mouse is released, deselect the current object.
	 */
	public void mouseReleased(MouseEvent e) {		
		if (selected != null) {
			selected.setColor(Color.BLUE);
			selected = null;
		}
	}
	
	/**
	 * When the mouse is dragged, move the selected object along
	 * with the mouse.
	 */
	public void mouseDragged(MouseEvent e) {
		if (selected != null) {
			/* See how much the mouse moved. */
			double dx = e.getX() - lastX;
			double dy = e.getY() - lastY;
			
			/* Update the position of the selected object. */
			selected.move(dx, dy);
			
			/* Update the X and Y coordinate for the mouse. */
			lastX = e.getX();
			lastY = e.getY();
		}
	}
}
