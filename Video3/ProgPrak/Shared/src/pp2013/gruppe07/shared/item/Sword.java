package pp2013.gruppe07.shared.item;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;

import pp2013.gruppe07.shared.item.Item;



/**
 * 
 * @author Daniel
 *Ist ein Schwert.
 */
public class Sword  extends SteadyItem {
	
	private static final int[] effects={10,0,0,0,0,0,0,0};
	private final static int cost = 200;
	
	public Sword(){
		super(cost,effects);
		

	}

}