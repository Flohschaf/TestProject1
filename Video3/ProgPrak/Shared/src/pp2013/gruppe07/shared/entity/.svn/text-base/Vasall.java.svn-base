package pp2013.gruppe07.shared.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.UUID;


import javax.swing.JComponent;



/**Eine Oberklasse fuer die Vasallen geschrieben, um die KI zu uebertragen
 * @author sven
 *
 */
public abstract class Vasall extends Figure {
	private final int LANE;

	private Type type;
	
	/**
	 * @param id
	 * @param x
	 * @param y
	 * @param visibillityrange
	 * @param lane
	 * @param team
	 * @param type
	 * @param attackRange
	 * @param giveXP
	 * @author Sven
	 */
	public Vasall(UUID id,int x, int y,int visibillityrange,int lane,Team team,Type type,int attackRange,int giveXP) {
		super(id,x, y,visibillityrange ,team,attackRange,giveXP);
		this.LANE=lane;
		this.type=type;
		
	}
	
	
	/**Gibt den Typ des Vasallen an
	 * @author Sven
	 */
	public static enum Type{
		PINGUIN,SQUIRREL,SUPER_VASALL
	}
	
	/**
	 * @return
	 * @author Sven
	 */
	public Type getType(){
		return this.type;
	}
	
	/**
	 * @param g
	 * @param jComp
	 * @param position
	 * @author Daniel
	 */
	public void paintHeroImageMini(Graphics g, JComponent jComp, int[] position) {
		if(TEAM.equals(Team.BLUE))
		g.setColor(Color.blue);
		if(TEAM.equals(Team.RED))
			g.setColor(Color.red);
		g.fillOval(position[0], position[1],2, 2);
		
	}	

	
	/**
	 * @return
	 * @author Sven
	 */
	public int getLane()
		{return LANE;}


	
	//Test
	

}
