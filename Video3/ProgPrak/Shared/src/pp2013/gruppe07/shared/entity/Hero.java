package pp2013.gruppe07.shared.entity;


import java.awt.Image;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import pp2013.gruppe07.shared.item.Elixir;
import pp2013.gruppe07.shared.item.Item;
import pp2013.gruppe07.shared.item.Manapotion;
import pp2013.gruppe07.shared.item.SpaceHolderItem;
import pp2013.gruppe07.shared.item.SteadyItem;
import pp2013.gruppe07.shared.item.Potion;


/**Enthalet die Oberklasse fuer Helden und die dafuer benoetigten Attribute
 * @author Daniel,Sven
 *  @author Felix, Steven
 * 
 */
public abstract class Hero extends Figure {

	protected final boolean IS_HUMAN;
	protected int next_Level_XP=50;
	protected int Kills=0;
	protected int Deaths=0;
	protected int Lasthits=0;
	protected int money;
	protected int akt_mana;
	protected int akt_XP;
	protected int level=1;
	protected boolean[] AbilitiesAktivated={false,false,false,false};
	protected boolean visibility = true;
	//daniel: das ist wichtig um zu wissen wann welche spezialattacke eingesetzt. fur paint, sven muss das setzten
	//darf nicht mit attack boolen aus klasse figure aktiviert sein, und immer nur eine true

	protected String heroname;
	protected String[] skillNames={"Strong Strike","Executor","Fister","Roter Panzer"};	
	protected String[] valueNames = {"Strength","Magic","Swifftness","Agility","Armor","Magic Res.","Life","Mana" };
	private Item[] items;
	
	/**Dient zur Unterscheidung der Heros beim Zeichnen der Bilder
	 * @author sven
	 */
	protected final Heronames TYPE;
	
	
	/**Dient zur Unterscheidung der Heros beim Zeichnen der Bilder
	 * @author sven
	 */
	public static enum Heronames
		{CAPTAIN_OBVIOUS,CLIT_COMANDER,DANGER_DAN,EMPTY,FAMOUS_FLORIAN,FEDERAL_FELIX,
		GENERAL_HATE,SAFETY_STEVEN,SERIOUS_SVEN}
	
	/** Wird fuer das ShopEvent und das Inventar benoetigt
	 * @author Sven
	 */
	private int numberOfItems=0;
	
	/**
	 * @param id
	 * @param x
	 * @param y
	 * @param team
	 * @param isHuman
	 * @param heroname
	 * @param attackRange
	 * @param giveXP
	 * @author Sven
	 */
	public Hero(UUID id,int x, int y,  Team team,boolean isHuman,Heronames heroname,int attackRange,int giveXP) {
		super(id,x, y, 8, team,attackRange,giveXP);
		money = 400;
		this.IS_HUMAN=isHuman;
		initItems();
		
		this.TYPE=heroname;
		
	}	
	
	
	/**
	 * daniel, setzt items auf leeres item
	 */
	public void initItems(){
		items = new Item[6];
		
		for(int  i =0 ;i < 6 ; i++ ){
			items [i]=new SpaceHolderItem();
		}
	}
	
	/**
	 * @return
	 * @author Sven
	 */
	public Item[] getItems() {
		return items;
	}
	
		

	/**
	 * @return
	 * @author Sven
	 */
	public int getLevel() {
		return level;
	}


	/**
	 * @author Sven
	 */
	public void levelUp() {
		this.level++;
	}


	/**Gibt zurueck, ob ein Held von einem Spieler oder einer KI gesteuert wird
	 * @return
	 * @author Sven
	 */
	public boolean isHuman() {
		return IS_HUMAN;
	}


	/**
	 * 
	 * @author Steven
	 * 
	 */
	
	public void setVisibility(boolean visible){
		this.visibility = visible;
	}
	
	public boolean getVisibility(){
		return visibility;
	}
	
	
	/**Reanimiert einen Helden wieder
	 * @author Sven
	 */
	public void reanimate()
		{isAlive=true;}
	
	public Heronames getType() {
		return TYPE;
	}

	/**Fuege Item hinzu und aktualisiere ggf. die Hero-Werte oder erhoehe die Anzahl der Traenkesorte
	 * oder erstelle neues Feld mit dieser Tranksorte. Wenn das Hinzufuegen geklappt hat gebe true zurueck
	 * @author Sven
	 * @param item
	 */
	public boolean addItem(Item item) {
		//Wenn es ein Trank ist	
		boolean add=false;
		if(item instanceof Potion)
			{
			//Suche ob es bereits einen Trank der Sorte gibt
			boolean found=false;
			for(int i=0;i<6;i++)
				{if((items[i] instanceof Manapotion&&item instanceof Manapotion)||
						(items[i] instanceof Elixir&&item instanceof Elixir))
					{
					//Wenn ja dann erhoehe die Anzahl dieser Traenkesorte
					((Potion)items[i]).setQuantity(((Potion)items[i]).getQuantity()+1);
					add=true;
					found=true;
					}
				}
			//Wenn kein Trank der Sorte gefunden wurde, dann erstelle neues Itemfeld mit dem Trank,wenn
			// es noch einen freien Platz im Inventar gibt
			if(!found&&numberOfItems<6)
				{
					if(items[numberOfItems]instanceof SpaceHolderItem)
						{items[numberOfItems]=item;
						add=true;
						numberOfItems++;}					
					
				}
			}
		
		//Wenn es ein dauerhaftes Item ist
		else
			{
			//Wenn noch ein Platz im Inventar frei ist
			if(numberOfItems<6)
				{if(items[numberOfItems] instanceof SpaceHolderItem)
					{items[numberOfItems]=item;
					numberOfItems++;
					add=true;
					
					//Aktualisiere anschliessend die default_values des Heros
					for(int i=0;i<8;i++)
						{default_values[i]+=((SteadyItem) item).getEffects()[i];}
					}
				}
			}
		return add;	
	}	
	
	/**
	 * @return
	 * @author Sven
	 */
	public int getAkt_XP() {
		return akt_XP;
	}
	
	

	/**
	 * @return
	 * @author Sven
	 */
	public int getNext_Level_XP() {
		return next_Level_XP;
	}


	/** Erhoeht die Xp eines Helden und reagiert auf einen moegliche LevelUp, soweit das im
	 * Shared Projekt moeglich und sinnvoll ist.
	 * @param increase
	 * @return
	 * @author Sven
	 */
	public boolean increase_Akt_XP(int increase) {
		if(akt_XP + increase>=next_Level_XP)
			{levelUp();
			akt_XP=akt_XP + increase-next_Level_XP;
			next_Level_XP+=50;
			return true;}
		else
			{akt_XP+=increase;
			return false;}
	}


	public String[] getSkillNames(){
			return this.skillNames;
	}
	public boolean[] getAbilitiesaktivated(){
		return AbilitiesAktivated;
	}
	public void setAbilitiesaktivated(boolean Skillis,int index){
		AbilitiesAktivated[index]=Skillis;
	}
	
	/**
	 * @param increase
	 * @author Sven
	 */
	public void changeMoney(int increase) {

		money = money + increase;

	}
	
	/**
	 * @return
	 * @author Sven
	 */
	public int getMoney() {		
	
		return money;
	}
	
	/**
	 * @return
	 * @author Sven
	 */
	public int getAkt_mana() {
		return akt_mana;
	}

	/** Regelt mit Minimums- und Maximumsfunktionen, dass der Wert im Rahmen bleibt
	 * @param change
	 * @author Sven
	 */
	public void change_Akt_mana(int change) {
		this.akt_mana =Math.min(Math.max(akt_mana+change, 0),default_values[values.MANA.ordinal()]) ;
	}
	
	public int getKills(){
		return Kills;
	}
	public void setKills(int increase){
		Kills=Kills+increase;
	}
	public int getLasthits(){
		return Lasthits;
	}
	public void setLasthits(int increase){
		Lasthits=Lasthits+increase;
	}
	public int getDeaths(){
		return Deaths;
	}
	public void setDeaths(int increase){
		Deaths=Deaths+increase;
	}
	public String[] getValueNames(){
		return this.valueNames;
	}	


	public String getHeroName() {

		return heroname;
	}




}
