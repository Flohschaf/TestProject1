package pp2013.gruppe07.shared.ground;


import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JComponent;

import pp2013.gruppe07.shared.ground.Ground.Groundtype;
/**
 * 
 * @author Daniel
 *Ist Wasser.
 */
public class Water extends Ground{
	
	public Water(int x , int y){
		super(x,y,Groundtype.WATER);
//		IMAGE = Toolkit.getDefaultToolkit().getImage("Images/water.gif");
//		IMAGE2 = Toolkit.getDefaultToolkit().getImage("Images/wassernebel.png");
		
		
	}
	
	

}
