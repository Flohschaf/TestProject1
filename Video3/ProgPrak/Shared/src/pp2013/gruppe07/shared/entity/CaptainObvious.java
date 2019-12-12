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
 *  herl captainobvious
 *
 */
public class CaptainObvious extends Hero{

	//fernkampf
	//first skill schutzschild, erhoeht die verteidigung
	//second skill schiesst und verlangsamt damit die gegener wenn er trifft
	//third skill schiesstbetaeubenden pfeil
	public CaptainObvious(UUID id,int x, int y,Team team,boolean isHuman) {
		super(id,x, y,team,isHuman,Heronames.CAPTAIN_OBVIOUS,3,50);
		heroname="CaptainObvious";
		fightart="arrow";

		
		 skillNames[0]="Schutz Schild(armor)";
		 skillNames[1]= "Eis Pfeil(Slow)";
		 skillNames[2]="Frost Pfeil(Stun)";
		 skillNames[3]="Ultimate";	
			
		

		
		default_values[0]=100;
		default_values[1]=10;
		default_values[2]=20;
		default_values[3]=1000;
		default_values[4]=300;
		default_values[5]=10;
		default_values[6]=800;
		default_values[7]=150;
		akt_life=default_values[6];
		akt_mana=default_values[7];
		

		position_values[0]=-15;
		position_values[1]=-20;
		position_values[2]=-15;
		position_values[3]=-20;
		position_values[4]=-40;
		position_values[5]=-35;
		position_values[6]=-15;
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
