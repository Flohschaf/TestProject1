package pp2013.gruppe07.shared.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.UUID;

import javax.swing.JComponent;

import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;

/**
 * @author Daniel
 *
 */
public class Squirrel extends Vasall {


//fernkampf
	public Squirrel(UUID id,int x, int y,int lane,Team team) {
		super(id,x, y,7,lane ,team,Vasall.Type.SQUIRREL,4,10);
		fightart="arrow";
//		IMAGE = Toolkit.getDefaultToolkit().getImage( "Images/Eichhornblue.png" );
//		IMAGE2 = Toolkit.getDefaultToolkit().getImage( "Images/Eichhornred.png" );
//		IMAGE3 = Toolkit.getDefaultToolkit().getImage( "Images/Eichhornblueklein.png" );
//		IMAGE4 = Toolkit.getDefaultToolkit().getImage( "Images/Eichhornredklein.png" );
		
		default_values[0]=30;
		default_values[1]=10;
		default_values[2]=20;
		default_values[3]=1000;
		default_values[4]=300;
		default_values[5]=10;
		default_values[6]=300;
		default_values[7]=0;
		akt_life=default_values[6];
		
		position_values[0]=-15;
		position_values[1]=-20;
		position_values[2]=-15;
		position_values[3]=-20;
		position_values[4]=-40;
		position_values[5]=-35;
		position_values[6]=15;
		position_values[7]=20;
		position_values[8]=0;
		position_values[9]=0;
		position_values[10]=0;
		position_values[11]=0;
		position_values[12]=0;
		position_values[13]=0;
		position_values[14]=0;
		position_values[15]=0;
		position_values[16]=0;
		position_values[17]=0;
		position_values[18]=0;
		position_values[19]=0;
		position_values[20]=0;
		position_values[21]=0;
		position_values[22]=0;
		position_values[23]=0;


	}
	
	
	

}
