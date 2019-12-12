package pp2013.gruppe07.shared.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.JComponent;
/**Diese Klasse ist die Oberklasse fuer alle Klassen dieses Packages und enthaelt grundlegende Attribute
 * @author Felix,Sven,Daniel
 *
 */
public abstract class Entity  implements Serializable{

	protected int Position[];
	boolean attack=false;	


	/**
	 * @param x
	 * @param y
	 * @author Sven
	 */
	public Entity(int x, int y) {
		this.Position = new int[2];
		this.Position[0] = x;
		this.Position[1] = y;



	}

	/**
	 * Soll Figuren das Aendern ihrer Position erlauben. Wird in einzelnen Ausnahmen auch ausserhalb
	 * von Bewegungen verwendet.
	 * @author Sven
	 * @param x
	 * @param y	
	 */
	public void setPosition(int x, int y) {
		Position[0] = x;
		Position[1] = y;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public int[] getPosition() {
		return this.Position;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public boolean getattack(){
		return attack;
	}	

	


	/**
	 * Zeichnet das Bild des Objektes auf der Compnente jComp an der Position
	 * (position[0],position[1])
	 * 
	 * @param g
	 * @param jComp
	 * @param position
	 */
	

}
