package pp2013.gruppe07.shared.item;

import java.awt.Graphics;

import java.awt.Toolkit;

import javax.swing.JComponent;



/**
 * 
 * @author Flo
 * Ist die Jacke.
 *
 */
public class Jacket extends SteadyItem {
	
	private final static int cost = 100;
	private static final int[] effects={2,8,0,0,0,0,0,0};
	
	public Jacket(){
		super(cost,effects);
		

	}

	
}