package pp2013.gruppe07.shared.item;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;

import pp2013.gruppe07.shared.item.Item;


/**
 * 
 * @author Daniel
 *Ist ein Schuh.
 */
public class Shoe  extends SteadyItem {
	
	private final static int cost = 50;
	private static final int[] effects={0,0,0,0,10,0,0,0};
	
	public Shoe(){
		super(cost,effects);
		

	}

	
}
