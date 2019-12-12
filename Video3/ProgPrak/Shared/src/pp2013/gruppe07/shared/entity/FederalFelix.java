package pp2013.gruppe07.shared.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.UUID;

import javax.swing.JComponent;
/**
 * 
 * @author daniel
 *  FederalFelix
 *
 */
public class FederalFelix extends Hero{

	
	//nachkampf
	//first skill Kugelhagel schaden in umgebung
	//second skill Motivations ruf
	//third skill mega bombe

	public FederalFelix(UUID id,int x, int y,Team team,boolean isHuman) {
		super(id,x, y,team,isHuman,Heronames.FEDERAL_FELIX,4,50);
		heroname="Faboulix";
		fightart="arrow";
		
		 skillNames[0]="Kugelhagel";
		 skillNames[1]= "Haddle Ruf";
		 skillNames[2]="Mega Bombe";
		 skillNames[3]="Ultimate";
		

		default_values[0]=100;
		default_values[1]=10;
		default_values[2]=20;
		default_values[3]=1000;
		default_values[4]=300;
		default_values[5]=10;
		default_values[6]=80000000;
		default_values[7]=150;
		akt_life=default_values[6];
		akt_mana=default_values[7];

		
		position_values[0]=-15;
		position_values[1]=-20;
		position_values[2]=-15;
		position_values[3]=-20;
		position_values[4]=-30;
		position_values[5]=-25;
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
		
	}

	

	
	
	
	
}
