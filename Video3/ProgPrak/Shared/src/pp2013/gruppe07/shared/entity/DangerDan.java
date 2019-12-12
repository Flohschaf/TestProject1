package pp2013.gruppe07.shared.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JComponent;
import javax.swing.Timer;
/**
 * 
 * @author daniel
 *  held dangerdan
 *
 */

public class DangerDan extends Hero {
//nahkampf
//starker schlag hoher schade
//Supersayajin alle values erhoeht
	//erdbeben, stun auf mehrere und schaden.
	
	public DangerDan(UUID id,int x, int y,Team team,boolean isHuman) {
		super(id,x, y,team,isHuman,Heronames.DANGER_DAN,1,50);
		heroname="DangerDan";
		fightart="sword";
		
		 skillNames[0]="Starker Schlag";
		 skillNames[1]= "SuperSayajin(stronger)";
		 skillNames[2]="Erdbeben";
		 skillNames[3]="Ultimate";	
		
			
		 
		default_values[0]=200;
		default_values[1]=10;
		default_values[2]=20;
		default_values[3]=1000;
		default_values[4]=300;
		default_values[5]=10;
		default_values[6]=1000;
		default_values[7]=150;
		akt_life=default_values[6];
		akt_mana=default_values[7];
		

		position_values[0]=-15;
		position_values[1]=-20;
		position_values[2]=-15;
		position_values[3]=-20;
		position_values[4]=-25;
		position_values[5]=-30;
		position_values[6]=-30;
		position_values[7]=35;
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

//		timer.start();
	}

	

	


	
	
	


}
