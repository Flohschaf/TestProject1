package pp2013.gruppe07.shared.item;

import java.awt.Graphics;

import java.awt.Toolkit;

import javax.swing.JComponent;



/**
 * 
 * @author Daniel
 * Ist die Ruestung.
 *
 */
public class Armor extends SteadyItem {
	
	private final static int cost = 100;
	private static final int[] effects={0,10,0,0,0,0,0,0};
	
	public Armor(){
		super(cost,effects);
		

	}

	
}