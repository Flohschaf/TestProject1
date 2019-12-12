package pp2013.gruppe07.server.engine.threads_and_KI;

import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Building;
import pp2013.gruppe07.shared.entity.Entity;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.Nexus;
import pp2013.gruppe07.shared.entity.Shop;
import pp2013.gruppe07.shared.entity.Vasall;

/**
 * Regelt die komplette Steuerung eines Vasalls
 * 
 * @author Sven
 */
public class VasallKI implements Runnable {

	private Vasall vasall;
	private MoveThread_Normal mover;
	private AttackThread_Normal fighter;
	private final int[] first_dest_position;
	private GameLogic administration;
	private final Team OTHERTEAM;
	private boolean reachedFirstDestPosition = false;
	private boolean reachedNexus = false;

	/**
	 * @param vasall
	 * @param first_dest_position
	 * @param administration
	 * @author Sven
	 */
	public VasallKI(Vasall vasall, int[] first_dest_position,
			GameLogic administration) {
		this.vasall = vasall;
		this.first_dest_position = first_dest_position;
		this.administration = administration;
		if (vasall.getTeam().equals(Team.RED))
			OTHERTEAM = Team.BLUE;
		else
			OTHERTEAM = Team.RED;
	}

	/**
	 * Gibt ein moegliches Angriffsziel im Sichtfeld zurueck. Dabei werden
	 * Gegner mit wenigen Angreifern bevorzugt, um ein gleichmaessiges
	 * Angriffsverhalten zu generieren
	 * 
	 * @return
	 * @author Sven
	 */
	private InteraktiveEntity attackObjektInVisibillityRange() {
		// Initialisiere die noetigen Varaiblen
		InteraktiveEntity erg = null;
		int min_AttackingEnemies = Integer.MAX_VALUE;
		int radius = vasall.getVisibilityRange();

		// Suche nur innerhalb der Karte
		int i_min = Math.max(20, (vasall.getPosition()[0] - radius));
		int i_max = Math.min(119, (vasall.getPosition()[0] + radius));

		// Suche im kleinsten Quadrat, welches das Sichtfeld enthaelt
		for (int i = i_min; i <= i_max; i++) {
			int j_min = Math.max(20, (vasall.getPosition()[1] - radius));
			int j_max = Math.min(119, (vasall.getPosition()[1] + radius));
			for (int j = j_min; j <= j_max; j++) {
				// Wenn die Kachel im Sichtfeld ist
				if (euclid_dist(vasall.getPosition()[0],
						vasall.getPosition()[1], i, j) <= radius) {
					Entity object = administration.get_map()[i][j].getobject();

					// ueberpruefe, ob das Objekt angreifbar ist
					if (object instanceof Figure
							|| (object instanceof Building && !(object instanceof Shop))) {
						InteraktiveEntity objectcast = (InteraktiveEntity) object;

						// ueberpruefe, ob das Objekt zum Gegnerischen Team
						// gehoert und ob seine
						// Gegnerzahl geringer als die des aktuellen Ziels ist
						if ((objectcast.getTeam().equals(OTHERTEAM))
								&& objectcast.getAttackingEnemies() < min_AttackingEnemies) {
							erg = objectcast;
							min_AttackingEnemies = objectcast
									.getAttackingEnemies();
						}
					}
				}
			}
		}
		return erg;
	}

	/**
	 * Kontrolliert beim Bewegen laufen das Sichtfeld nach gegnerischen
	 * Einheiten und greift ggf. an
	 * 
	 * @author Sven
	 */
	private void controlVisibilityRange() {
		boolean startfight = false;
		while (!startfight && mover.isRunning() && administration.isRunning()) {
			// Suche nach Gegner im Sichtfeld
			InteraktiveEntity enemy = attackObjektInVisibillityRange();

			// Wenn ein Gegner gefunden wurde
			if (enemy != null) {
				// dann breche die Bewegung ab und starte einen Angriffsthread
				mover.abort();
				startfight = true;
				fighter = new AttackThread_Normal(administration, vasall, enemy);
				fighter.getKILock().lock();
				

				// Warte bis der Angriff vorbei ist und der Angriffsthread das
				// Signal gibt
				try {
					if(!administration.getThreadPool().isShutdown())
						{administration.getThreadPool().execute(fighter);
						fighter.getKICondition().await();
						}
				} catch (Exception e) {

				}
				fighter.getKILock().unlock();
			}

			// Warte kurz ab damit die Schleife nicht durchlaeuft
			if (administration.selfmadeSleeper())
				administration.sleeper(200);
			else {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {

				}
			}
		}
	}

	/**
	 * Bestimmt den euklidischen Abstand zwischen 2 Punkten
	 * 
	 * @author Sven
	 */
	private double euclid_dist(int x1, int y1, int x2, int y2) {
		return Math.pow((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)), 0.5);
	}

	/**
	 * Stellt das komplette Leben eines Vasalls in Form eines deterministischen
	 * endlichen Automatens dar.
	 * 
	 * @author Sven
	 **/
	@Override
	public void run() {
		// Solange der Vasall die Ecke seiner Lane nicht erreicht hat
		while (!reachedFirstDestPosition && vasall.isAlive()
				&& administration.isRunning()) {
			// bewege ihn dorthin
			mover = new MoveThread_Normal(administration, vasall,
					first_dest_position[0], first_dest_position[1]);
			administration.getThreadPool().execute(mover);

			// und kontrolliere dabei sein Sichtfeld in der KI
			controlVisibilityRange();

			// Wenn ein Umkreis der Ecke erreicht wurde, beende diese Schleife
			if (euclid_dist(vasall.getPosition()[0], vasall.getPosition()[1],
					first_dest_position[0], first_dest_position[1]) <= 10) {
				reachedFirstDestPosition = true;
			}

			// beende die aktuelle Bewegung
			mover.abort();
		}

		// Bewegt den Vasall zum gegnerischen Nexus

		int[] nexusPosition = administration.getNexusPosition(OTHERTEAM);
		Nexus enemiesNexus = (Nexus) administration.get_map()[nexusPosition[0]][nexusPosition[1]]
				.getobject();

		nexusPosition[0]--;
		nexusPosition[1]--;

		// Solange der Vasall nicht beim gegnerischen Nexus ist
		while (!reachedNexus && vasall.isAlive() && administration.isRunning()) {
			// bewege ihn dorthin
			mover = new MoveThread_Normal(administration, vasall,
					nexusPosition[0], nexusPosition[1]);
			administration.getThreadPool().execute(mover);

			// und kontrolliere dabei sein Sichtfeld in der KI
			controlVisibilityRange();

			// Wenn der Nexus erreicht wurde, dann breche diese Schleife ab
			if (euclid_dist(vasall.getPosition()[0], vasall.getPosition()[1],
					nexusPosition[0], nexusPosition[1]) <= 10) {
				reachedNexus = true;
			}
			mover.abort();
		}

		// Wenn der Vasall am gegnerischen Nexus ist, dann greife ihn an.
		if(!administration.getThreadPool().isShutdown())
			{fighter = new AttackThread_Normal(administration, vasall, enemiesNexus);
			administration.getThreadPool().execute(fighter);
			}
	}

}
