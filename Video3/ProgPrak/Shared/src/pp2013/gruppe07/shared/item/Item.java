package pp2013.gruppe07.shared.item;

import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.JComponent;

/**
 * @author Daniel
 *Oberklasse fuer Items.
 */
public abstract class Item implements Serializable{
	

	
	
	
	/**Gibt an, ob es sich um einen Trank handelt oder um ein dauerhaftes Item
	 * @author Sven	  
	 */

	
	protected int cost;
	
	public Item(int cost){
		this.cost = cost;
		
	}
	
	public int getCost(){
		return this.cost;
	}
	
	
	
	/**
	 * Zeichnet das Bild des Objektes auf der Compnente jComp an der Position (position[0],position[1])
	 * @param g
	 * @param jComp
	 * @param position
	 */
	
}

