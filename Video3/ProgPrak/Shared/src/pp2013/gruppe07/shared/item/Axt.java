package pp2013.gruppe07.shared.item;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;

import pp2013.gruppe07.shared.item.Item;



/**
 * 
 * @author Flo
 *Ist ein Axt.
 */
public class Axt  extends SteadyItem {
	
	private static final int[] effects={15,-2,0,0,0,0,0,0};
	private final static int cost = 200;
	
	public Axt(){
		super(cost,effects);
		

	}

}