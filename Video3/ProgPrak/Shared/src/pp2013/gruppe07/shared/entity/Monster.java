package pp2013.gruppe07.shared.entity;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.UUID;

import javax.swing.JComponent;


/**Stellt die Oberklasse fuer die Monster im Wald da.
 * @author sven
 *
 */
public abstract class Monster extends Figure {

	private Type type;
	
	/**
	 * @param id
	 * @param x
	 * @param y
	 * @param visibiliytRange
	 * @param type
	 * @param attackRange
	 * @param giveXP
	 * @author Sven
	 */
	public Monster(UUID id,int x, int y, int visibiliytRange,Type type,int attackRange,int giveXP) {
		super(id,x, y, visibiliytRange, Team.NEUTRAL, attackRange,giveXP);
		this.type = type;
		
		default_values[0]=40;
		default_values[1]=10;
		default_values[2]=20;
		default_values[3]=30;
		default_values[4]=0;
		default_values[5]=10;
		default_values[6]=1000;
		default_values[7]=0;
		akt_life=default_values[6];
		
		
		position_values[0]=0;
		position_values[1]=0;
		position_values[2]=0;
		position_values[3]=0;
		position_values[4]=0;
		position_values[5]=0;
		position_values[6]=0;
		position_values[7]=0;
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

	/**Enthaelt den Typ von Monstern
	 * @author Sven
	 *
	 */
	public static enum Type{
		SEBAMSTER,JOSCHIFANT,SUPER_BOSS
	}
	
	/**
	 * @return	 
	 * @author Sven
	 */
	public Type getType(){
		return this.type;
	}
	
	

}
