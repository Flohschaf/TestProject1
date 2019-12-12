package pp2013.gruppe07.shared.item;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;

import pp2013.gruppe07.shared.item.Item;


/**
 * 
 * @author Flo
 *Ist ein Schuh.
 */
public class Trouser  extends SteadyItem {
	
	private final static int cost = 50;
	private static final int[] effects={0,2,0,0,8,0,0,0};
	
	public Trouser(){
		super(cost,effects);
		

	}

	
}
