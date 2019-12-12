package pp2013.gruppe07.server.engine.special_attacks;

import java.util.LinkedList;
import java.util.List;

import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Entity;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;

/**
 * Erzeugt eine Oberklasse fuer die Spezialattacken.
 * 
 * @author Sven,Steven
 * 
 */
public abstract class SpecialAttack implements Runnable {

	protected final int COST;
	protected Hero hero;
	protected final boolean RUNNABLE;
	protected GameLogic administration;

	public SpecialAttack(GameLogic administration, int cost, Hero hero,
			boolean runnable) {
		this.administration = administration;
		this.COST = cost;
		this.hero = hero;
		this.RUNNABLE = runnable;
	}

	/**
	 * Stellt die Ausfuehrung der Spezialattacke dar
	 * 
	 * @author Sven
	 */
	public abstract void execute();

	public int getCost() {
		return COST;
	}

	public Hero getHero() {
		return hero;
	}

	/**
	 * gibt die (gegnerischen) Helden in der Umgebung zurueck. Wichtig fuer
	 * viele Spezialattacken
	 * 
	 * @author Steven
	 */

	protected List<InteraktiveEntity> getHerosInVisibillityRange() {
		final Team OTHERTEAM;
		// Erdbeben soll nur Heros aus anderen Team treffen
		if (hero.getTeam().equals(Team.RED))
			OTHERTEAM = Team.BLUE;
		else
			OTHERTEAM = Team.RED;
		// alle Helden in Umgebung soll in Liste gespeichert werden um sie
		// nachher bearbeiten zu koennen
		List<InteraktiveEntity> heroesInSouround = new LinkedList<InteraktiveEntity>();
		InteraktiveEntity erg = null;

		int radius = hero.getVisibilityRange() + 3;
		int i_min = Math.max(20, (hero.getPosition()[0] - radius));
		int i_max = Math.min(119, (hero.getPosition()[0] + radius));
		for (int i = i_min; i <= i_max; i++) {
			int j_min = Math.max(20, (hero.getPosition()[1] - radius));
			int j_max = Math.min(119, (hero.getPosition()[1] + radius));
			for (int j = j_min; j <= j_max; j++) {
				Entity object = administration.get_map()[i][j].getobject();
				if (object instanceof Figure) {
					InteraktiveEntity objectcast = (InteraktiveEntity) object;
					if ((objectcast.getTeam().equals(OTHERTEAM))) {
						erg = objectcast;
						heroesInSouround.add(erg);
					}

				}
			}
		}
		return heroesInSouround;
	}

	/**
	 * gibt die (gleichen) Helden in der Umgebung zurueck. Wichtig fuer viele
	 * Spezialattacken
	 * 
	 * @author Steven
	 */

	protected List<InteraktiveEntity> getHerosInVisibillityRangeSameTeam() {
		final Team SAMETEAM;
		// Erdbeben soll nur Heros aus anderen Team treffen
		if (hero.getTeam().equals(Team.RED))
			SAMETEAM = Team.RED;
		else
			SAMETEAM = Team.BLUE;
		// alle Helden in Umgebung soll in Liste gespeichert werden um sie
		// nachher bearbeiten zu koennen
		List<InteraktiveEntity> heroesInSouround = new LinkedList<InteraktiveEntity>();
		InteraktiveEntity erg = null;

		int radius = hero.getVisibilityRange();
		int i_min = Math.max(20, (hero.getPosition()[0] - radius));
		int i_max = Math.min(119, (hero.getPosition()[0] + radius));
		for (int i = i_min; i <= i_max; i++) {
			int j_min = Math.max(20, (hero.getPosition()[1] - radius));
			int j_max = Math.min(119, (hero.getPosition()[1] + radius));
			for (int j = j_min; j <= j_max; j++) {
				Entity object = administration.get_map()[i][j].getobject();
				if (object instanceof Figure) {
					InteraktiveEntity objectcast = (InteraktiveEntity) object;
					if ((objectcast.getTeam().equals(SAMETEAM))) {
						erg = objectcast;
						heroesInSouround.add(erg);
					}

				}
			}
		}
		return heroesInSouround;
	}

	public boolean isRunnbale() {
		return RUNNABLE;
	}

	/**
	 * Gibt dem Event die Moeglichkeit nach einer gewissen Zeit den Effect zu
	 * beenden
	 * 
	 * @author Sven
	 */
	@Override
	public abstract void run();

}
