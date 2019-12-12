package pp2013.gruppe07.shared.entity;

import java.util.UUID;




/**Reapraesentiert Gebaeude und Figuren, also Entities die interagieren koennen
 * @author Sven
 *
 */
public abstract class InteraktiveEntity extends Entity {
	
	
	/**Regelt die Speicherorte der Werte im Array "default_values".
	 * @author Sven
	 */
	public static enum values
		{ATTACK,ARMOR,MAGICARMOR,ATTACKSPEED,MOVESPEED,MAGIC,LIFE,MANA}
	
	/**Stellt Konstanten fuer Teams bereit
	 * @author Sven
	 */
	public static enum Team {
		RED,BLUE,NEUTRAL
	}

	/**Die Speicherorte der Werte regelt das Enum values. Die Art der Werte sind die Anzeige
	 * der GUI angepasst.
	 * Erklaerung der Zahlenwerte:
	 * Attack: Absoluter Angriffsschaden
	 * Armor: Zieht entsprechende Prozentzahl vom Schaden ab
	 * Magicarmor: leer
	 * Attackspeed: Enthaelt die Angriffsgeschwindigkeit in Millisekunden pro Schlag
	 * Movespeed: Enthaelt die Schrittgeschwindigkeit in Millisekunden pro Schritt
	 * Magic: leer
	 * Life: Enthaelt die maximale Lebensenergie
	 * Mana: Enthaelt das maximale Mana
	 * @author Sven
	 */
	protected int[] default_values = new int[8];

	
	protected int[] position_values=new int[24];	
	
	protected boolean isAlive=true;
	protected final int VISIBILITYRANGE;
	protected final Team TEAM;
	protected int akt_life;
	protected final int GIVE_XP; 
	
	
	/**Stellt eine eindeutige ID fuer alle Objekte die interagieren koennen dar.
	 * @author Sven
	 */
	protected final UUID ID;
	
	/**Gibt Auskunft darueber, wie viele Gegner gerade dieses Entity angreifen
	 * @author Sven
	 */
	protected int attackingEnemies=0;
	

	
	
	/**
	 * @param id
	 * @param x
	 * @param y
	 * @param visibiliytRange
	 * @param team
	 * @param giveXP
	 * @author Sven
	 */
	public InteraktiveEntity(UUID id,int x, int y, int visibiliytRange,Team team, int giveXP) 
		{super(x, y);
		this.VISIBILITYRANGE = visibiliytRange;
		this.TEAM=team;	
		this.GIVE_XP=giveXP;
		this.ID = id;
}
	
	
	/**
	 * @return
	 * @author Sven
	 */
	public UUID getID(){
		return this.ID;
	}
	
	/**
	 * @return
	 * @author Sven
	 */
	public int getGIVE_XP() {
		return GIVE_XP;
	}



	/**
	 * @return
	 * @author Daniel
	 */
	public int[] getPosition_values() {
		return position_values;
	}



	/**
	 * @return
	 * @author Sven
	 */
	public Team getTeam() {
		return TEAM;
	}


	
	/**
	 * @return
	 * @author Sven
	 */
	public int getVisibilityRange() {
		return VISIBILITYRANGE;
	}	
	
	/**
	 * @return
	 * @author Sven
	 */
	public int getAttackingEnemies()
		{return attackingEnemies;}
	
	/**
	 * @param value
	 * @author Sven
	 */
	public void setAttackingEnemies(int value)
		{attackingEnemies=value;}
	
	/**
	 * @param pos
	 * @param increase
	 * @author Sven
	 */
	public void increaseValue(int pos, int increase)
		{	
		default_values[pos] = Math.max(default_values[pos] + increase,0);		
		}

	/**
	 * @return
	 * @author Sven
	 */
	public int[] getvalue()
		{	
		return default_values;		
		}
	

	
	/**Regelt mit Minimums- und Maximumsfunktionen, dass der Wert im Rahmen bleibt
	 * @param change Enthaelt die zu addierende Aenderungsrate
	 * @author Sven
	 */
	public void change_Akt_Life(int change)
		{	
		akt_life = Math.min(Math.max(0, akt_life + change),default_values[values.LIFE.ordinal()]);		
		}

	

	/**
	 * @param i
	 * @return
	 * @author Sven
	 */
	public int getvalue(int i){
		return default_values[i];
	}
	
	/**
	 * @return
	 * @author Sven
	 */
	public int get_Akt_Life()
		{
			return akt_life;
		}
	
	/**Signalisiert allen Threads und Events, dass dieses Gebauede oder diese Figur tot ist
	 * @author Sven
	 */
	public void kill()
		{isAlive=false;}
	
	
	/**Ist die passende Abfrage zur obigen Methode bzw. dem zugehoerigen boolean
	 * @author Sven
	 * @return
	 */
	public boolean isAlive()
		{return isAlive;}


}
