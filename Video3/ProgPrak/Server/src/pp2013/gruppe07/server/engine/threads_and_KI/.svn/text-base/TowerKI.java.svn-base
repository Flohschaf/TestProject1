package pp2013.gruppe07.server.engine.threads_and_KI;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.HitEvent_Tower;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Entity;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.values;
import pp2013.gruppe07.shared.entity.Tower;

/**
 * Regelt das Handeln eines Turmes inklusive Angriffsverhalten
 * 
 * @author Sven
 */
public class TowerKI implements Runnable {

	private GameLogic administration;
	private Tower tower;
	private InteraktiveEntity enemy = null;
	private final Team OTHERTEAM;

	/**
	 * Dient der Synchronisation mit einem erzeugten HitEvent
	 * 
	 * @author Sven
	 */
	private Lock hitLock = new ReentrantLock();
	private Condition hitCondition = hitLock.newCondition();

	/**
	 * @param administration
	 * @param tower
	 * @author Sven
	 */
	public TowerKI(GameLogic administration, Tower tower) {
		this.administration = administration;
		this.tower = tower;
		if (tower.getTeam().equals(Team.RED))
			OTHERTEAM = Team.BLUE;
		else
			OTHERTEAM = Team.RED;
	}

	/**
	 * Entspricht der Methode aus der VasallKI. Es wird nach einem Gegner im
	 * Sichtfeld gesucht. Dabei wird der Gegener bevorzugt, den am wenigsten
	 * gegnerische Einheiten angreifen.
	 * 
	 * @return
	 * @author Sven
	 */
	private InteraktiveEntity attackObjektInVisibillityRange() {
		// Initailisiere die noetigen Variablen
		InteraktiveEntity erg = null;
		int min_AttackingEnemies = Integer.MAX_VALUE;
		int radius = tower.getVisibilityRange();

		// Suche nur auf der eigentliche Karte
		int i_min = Math.max(20, (tower.getPosition()[0] - radius));
		int i_max = Math.min(119, (tower.getPosition()[0] + radius));

		// Suche im kleinsten Quadrat, dass das Sichtfeld enthaelt
		for (int i = i_min; i <= i_max; i++) {
			int j_min = Math.max(20, (tower.getPosition()[1] - radius));
			int j_max = Math.min(119, (tower.getPosition()[1] + radius));
			for (int j = j_min; j <= j_max; j++)

			// Wenn die Kachel im Sichtfeld liegt
			{
				if (euclid_dist(tower.getPosition()[0], tower.getPosition()[1],
						i, j) <= radius) {
					Entity object = administration.get_map()[i][j].getobject();

					// ueberpruefe, ob auf der Kachel eine Figur ist
					if (object instanceof Figure) {
						InteraktiveEntity objectcast = (InteraktiveEntity) object;

						// ueberpruefe, ob die Figur vom anderen Team ist und
						// weniger Angreifer als
						// das aktuelle Ziel besitzt.
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

	private double euclid_dist(int x1, int y1, int x2, int y2) {
		return Math.pow((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)), 0.5);
	}

	/**
	 * @return
	 * @author Sven
	 */
	public Condition getHitCondition() {
		return hitCondition;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public Lock getHitLock() {
		return hitLock;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public Tower getTower() {
		return tower;
	}

	/**
	 * Ueberprueft, ob der Gegner in Reichweite ist
	 * 
	 * @author Sven
	 * @return
	 */
	public boolean nearEnough() {
		if (enemy == null) {
			return false;
		} else {
			int x1 = tower.getPosition()[0];
			int x2 = enemy.getPosition()[0];
			int y1 = tower.getPosition()[1];
			int y2 = enemy.getPosition()[1];
			return euclid_dist(x1, y1, x2, y2) <= tower.getVisibilityRange();
		}
	}

	/**
	 * Regelt das komplette Leben eines Turms in Form eines deterministischen
	 * endlichen Automatens.
	 * 
	 * @author Sven
	 */
	@Override
	public void run() {

		// Solange das Spiel laueft und der Turm lebt
		while (administration.isRunning() && tower.isAlive()) {
			// Suche nach Gegner im Sichtfeld
			enemy = attackObjektInVisibillityRange();

			// Wenn ein Gegner gefunden wurde
			if (enemy != null) {
				// Solange der Gegner noch lebt und der Turm noch steht
				while (enemy.isAlive() && tower.isAlive() && nearEnough()) {
					// Aktiviere Kampfanimation
					tower.setattack(true);
					tower.settarget(enemy.getPosition());

					// Lege HitEvent auf EventQueue
					hitLock.lock();
					administration.get_eventManager().addEvent(
							new HitEvent_Tower(administration, this, enemy));

					// Warte bis der Schlag ausgefuehrt wurde
					try {
						hitCondition.await();
					} catch (InterruptedException e1) {

					}
					hitLock.unlock();

					// Schlafe nach Schuss
					if (administration.selfmadeSleeper())
						administration.sleeper(tower
								.getvalue(values.ATTACKSPEED.ordinal()));
					else {
						try {
							Thread.sleep(tower.getvalue(values.ATTACKSPEED
									.ordinal()));
						} catch (InterruptedException e) {

						}
					}
				}

				// beende Kampfanimation
				tower.setattack(false);
			}

			// Schlafe, damit die Schleife nicht durchlaeuft
			else {
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

	}

}
