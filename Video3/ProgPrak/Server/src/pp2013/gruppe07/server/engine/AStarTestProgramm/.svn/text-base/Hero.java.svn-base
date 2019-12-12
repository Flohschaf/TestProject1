package pp2013.gruppe07.server.engine.AStarTestProgramm;

import java.awt.Image;

abstract class Hero extends Figure {

	int SIZE = 100;
	int PLATTFORMSIZE = SIZE / 5;
	protected int Kills = 0;
	protected int Deaths = 0;
	protected int Lasthits = 0;
	protected int money;
	protected boolean[] AbilitiesAktivated = { false, false, false, false };
	// daniel: das ist wichtig um zu wissen wann welche spezialattacke
	// eingesetzt. fur paint, sven muss das setzten
	// darf nicht mit attack boolen aus klasse figure aktiviert sein, und immer
	// nur eine true
	protected Image FirstSkill1links;
	protected Image SecondSkill1links;
	protected Image FourthSkill1links;
	protected Image ThirdSkill1links;
	protected Image FirstSkill2links;
	protected Image SecondSkill2links;
	protected Image FourthSkill2links;
	protected Image ThirdSkill2links;
	protected Image FirstSkill1rechts;
	protected Image SecondSkill1rechts;
	protected Image FourthSkill1rechts;
	protected Image ThirdSkill1rechts;
	protected Image FirstSkill2rechts;
	protected Image SecondSkill2rechts;
	protected Image FourthSkill2rechts;
	protected Image ThirdSkill2rechts;
	protected Image FirstSkill1oben;
	protected Image SecondSkill1oben;
	protected Image FourthSkill1oben;
	protected Image ThirdSkill1oben;
	protected Image FirstSkill2oben;
	protected Image SecondSkill2oben;
	protected Image FourthSkill2oben;
	protected Image ThirdSkill2oben;
	protected Image FirstSkill1unten;
	protected Image SecondSkill1unten;
	protected Image FourthSkill1unten;
	protected Image ThirdSkill1unten;
	protected Image FirstSkill2unten;
	protected Image SecondSkill2unten;
	protected Image FourthSkill2unten;
	protected Image ThirdSkill2unten;
	protected String HERONAME;
	protected String[] skillNames = { "Strong Strike", "Executor", "Fister",
			"Roter Panzer" };
	protected String[] valueNames = { "Life", "Strength", "Swiftness", "Mana",
			"", "", "Life", "Mana" };

	public Hero(int x, int y, Type type, Team team) {
		super(x, y, 8, type, team);
		money = 400;

	}

	public void changeMoney(int increase) {
		money = money + increase;
	}

	public boolean[] getAbilitiesaktivated() {
		return AbilitiesAktivated;
	}

	public int getDeaths() {
		return Deaths;
	}

	public String getHeroName() {

		return HERONAME;
	}

	public int getKills() {
		return Kills;
	}

	public int getLasthits() {
		return Lasthits;
	}

	public int getMoney() {
		return money;
	}

	public String[] getSkillNames() {
		return this.skillNames;
	}

	public String[] getValueNames() {
		return this.valueNames;
	}

	public void setAbilitiesaktivated(boolean Skillis, int index) {
		AbilitiesAktivated[index] = Skillis;
	}

	public void setDeaths(int increase) {
		Deaths = Deaths + increase;
	}

	public void setKills(int increase) {
		Kills = Kills + increase;
	}

	public void setLasthits(int increase) {
		Lasthits = Lasthits + increase;
	}

}
