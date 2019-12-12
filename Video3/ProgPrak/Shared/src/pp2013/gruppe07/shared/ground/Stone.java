package pp2013.gruppe07.shared.ground;


import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JComponent;

import pp2013.gruppe07.shared.ground.Ground.Groundtype;
/**
 * 
 * @author Daniel
 *Ist Untergrund Stein.
 */
public class Stone extends Ground{
	
	public Stone(int x , int y){
		super(x,y,Groundtype.STONE);
//		IMAGE = Toolkit.getDefaultToolkit().getImage( "Images/stonenew.gif" );
//		IMAGE2 = Toolkit.getDefaultToolkit().getImage( "Images/steinnebel.png" );
		
		
	}
	
	

}
