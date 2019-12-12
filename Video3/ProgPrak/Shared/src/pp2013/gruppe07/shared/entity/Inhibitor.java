package pp2013.gruppe07.shared.entity;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.UUID;

import javax.swing.JComponent;


/**
 * 
 * @author Daniel
 *  
 *
 */
public class Inhibitor  extends Building {
	
	public Inhibitor(UUID id,int x , int y,Team team){
		super(id,x,y,10,team,Type.INHIBITOR,100);
//		IMAGE = Toolkit.getDefaultToolkit().getImage( "Images/Inhibblue.png" );
//		IMAGE2= Toolkit.getDefaultToolkit().getImage( "Images/Inhibred.png" );
		default_values[6]=3000;
		default_values[7]=150;
		akt_life=default_values[6];
	}

	
}