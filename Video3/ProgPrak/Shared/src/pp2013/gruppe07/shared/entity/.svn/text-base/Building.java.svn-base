package pp2013.gruppe07.shared.entity;

import java.util.UUID;


/**Enthaelt eine Oberklasse fuer Gebaude
 * @author Sven
 * @author Felix
 *@author Daniel
 */
public abstract class Building extends InteraktiveEntity{
	

	protected final Type TYPE;
	
	/**
	 * @param id
	 * @param x
	 * @param y
	 * @param visibiliytRange
	 * @param team
	 * @param type
	 * @param giveXP
	 * @author Sven
	 */
	public Building(UUID id,int x, int y,int visibiliytRange,Team team, Type type,int giveXP) {
		super(id,x, y, visibiliytRange,team,giveXP);
		this.TYPE=type;
		
	}
	
	/**Enthaelt die Art des Gebaeudes zur Unterscheidung
	 * @author Sven
	 *
	 */
	public static enum Type
		{INHIBITOR,NEXUS,SHOP,TOWER}

	/**
	 * @return
	 * @author Sven
	 */
	public Type getTYPE() {
		return TYPE;
	}
		
	
			

}
