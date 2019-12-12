package pp2013.gruppe07.shared.ground;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.JComponent;
/**
 * 
 * @author Daniel,Felix
 *Allgemeine Untergrund Klasse.
 */
public abstract class Ground implements Serializable{
	protected int Position[];
//	protected Image IMAGE;
//	protected Image IMAGE2;
	protected final Groundtype TYPE; 
	
	public Ground(int x, int y,Groundtype type2) {

		this.Position = new int[2];
		this.Position[0] = x;
		this.Position[1] = y;
		this.TYPE=type2;
	}

	public static enum Groundtype
		{GRASS,JUNGLEPATH,SAND,STONE,WALLGROUND,WATER}
	
	
	
	
	public Groundtype getTYPE() {
		return TYPE;
	}

	public int[] getPosition() {
		return this.Position;
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
