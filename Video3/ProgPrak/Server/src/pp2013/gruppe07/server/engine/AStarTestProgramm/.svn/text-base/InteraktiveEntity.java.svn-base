package pp2013.gruppe07.server.engine.AStarTestProgramm;

abstract class InteraktiveEntity extends Entity {

	public static enum Team {
		RED, BLUE, NEUTRAL
	}

	public static enum values {
		ATTACK, ARMOR, MAGICARMOR, ATTACKSPEED, MOVESPEED, MAGIC, LIFE, MANA
	}

	protected int[] default_values = new int[8];
	protected boolean isAlive = true;
	protected final int VISIBILITYRANGE;
	protected final Team TEAM;
	protected int akt_life;

	protected int attackingEnemies = 0;

	public InteraktiveEntity(int x, int y, int visibiliytRange,
			Category category, Type type, Team team) {
		super(x, y, type, category);
		this.VISIBILITYRANGE = visibiliytRange;
		this.TEAM = team;
	}

	public int getAttackingEnemies() {
		return attackingEnemies;
	}

	public int getlife()// Methode zum veraendern der Values also sowas wie
	// kraft
	{
		return akt_life;
	}

	public Team getTeam() {
		return TEAM;
	}

	public int[] getvalue()// Methode zum veraendern der Values also sowas wie
	// kraft
	{
		return default_values;
	}

	public int getVisibilityRange() {
		return VISIBILITYRANGE;
	}

	/**
	 * Ist die passende Abfrage zur obigen Methode bzw. dem zugehoerigen boolean
	 * 
	 * @author Sven
	 * @return
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * Signalisiert allen Threads und Events, dass dieses Gebauede oder diese
	 * Figur tot ist
	 * 
	 * @author Sven
	 */
	public void kill() {
		isAlive = false;
	}

	public void setAttackingEnemies(int value) {
		attackingEnemies = value;
	}

	public void setlife(int increase)// Methode zum verendern der Values also
	// sowas wie kraft
	{
		akt_life = Math.max(0, akt_life + increase);
	}

	public void setvalue(int pos, int increase)// Methode zum veraendern der
	// Values also sowas wie kraft
	{
		default_values[pos] = default_values[pos] + increase;
	}

}
