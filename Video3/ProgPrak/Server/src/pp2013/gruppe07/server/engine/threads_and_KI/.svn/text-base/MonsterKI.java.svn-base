package pp2013.gruppe07.server.engine.threads_and_KI;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Entity;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.Monster;

/**
 * Regelt das komplette Leben eines Monsters
 * 
 * @author Sven
 * 
 */
public class MonsterKI implements Runnable {

	private Monster monster;
	private GameLogic administration;
	private InteraktiveEntity enemy = null;
	private final int[] STARTPOSITION;
	private AttackThread_Normal fighter;
	private MoveThread_Normal mover;
	private boolean found;

	/**
	 * Dient der Synchronisation mit einem erzeugten HitEvent
	 * 
	 * @author Sven
	 */
	private Lock hitLock = new ReentrantLock();
	private Condition hitCondition = hitLock.newCondition();

	/**
	 * @param administration
	 * @param monster
	 * @author Sven
	 */
	public MonsterKI(GameLogic administration, Monster monster) {
		this.monster = monster;
		STARTPOSITION = monster.getPosition();
		this.administration = administration;
	}

	/**
	 * Entspricht im Groben der Methode aus der VasallKI. Es wird nach einem
	 * Gegner im Bereich des Monsters gesucht. Dabei ist der Bereich ein fester
	 * Bereich, um eine Startposition
	 * 
	 * @return
	 * @author Sven
	 */
	private InteraktiveEntity attackObjektInVisibillityRange() {
		found = false;
		// Initialisiere die benoetigten Variablen
		InteraktiveEntity erg = null;
		int radius = monster.getVisibilityRange();

		// Das Monster soll nicht ausserhalb der Karte suchen
		int i_min = Math.max(20, (STARTPOSITION[0] - radius));
		int i_max = Math.min(119, (STARTPOSITION[0] + radius));

		// Gehe alle Kacheln im kleinsten Quadrat um das Sichtfeld durch
		for (int i = i_min; i <= i_max; i++) {
			int j_min = Math.max(20, (STARTPOSITION[1] - radius));
			int j_max = Math.min(119, (STARTPOSITION[1] + radius));
			for (int j = j_min; j <= j_max; j++) {
				Entity object = administration.get_map()[i][j].getobject();

				// Wenn auf der Kachel ein angreifbares Objekt ist, dann gebe
				// dieses zurueck
				if (object instanceof Figure && !object.equals(monster)
						&& !found) {
					InteraktiveEntity objectcast = (InteraktiveEntity) object;
					{
						erg = objectcast;
						found = true;
					}
				}
			}
		}
		return erg;
	}

	/**
	 * @return
	 * @author Sven
	 */
	Condition getHitCondition() {
		return hitCondition;
	}

	/**
	 * @return
	 * @author Sven
	 */
	Lock getHitLock() {
		return hitLock;
	}

	/**
	 * Stellt das komplette Leben eines Monsters in Form eines deterministischen
	 * endlichen Automatens dar.
	 * 
	 * @author Sven
	 */
	@Override
	public void run() {

		// Solange das Monster noch lebt und das Spiel laeuft
		while (monster.isAlive() && administration.isRunning()) {
			// Suche Gegner im Sichtfeld
			enemy = attackObjektInVisibillityRange();

			// Wenn einer gefunden wurde
			if (enemy != null) {
				// Starte einen Kampf
				fighter = new AttackThread_Normal(administration, monster,
						enemy);
				fighter.getKILock().lock();				

				// Warte auf das Ende des Angriffsthreads
				try {
					if(!administration.getThreadPool().isShutdown())
						{administration.getThreadPool().execute(fighter);
						fighter.getKICondition().await();
						}
				} catch (Exception e) {

				}
				fighter.getKILock().unlock();

				// Gehe wieder zurueck zur Startposition
				mover = new MoveThread_Normal(administration, monster,
						STARTPOSITION[0], STARTPOSITION[1]);
				mover.getKILock().lock();
				administration.getThreadPool().execute(mover);

				// Warte auf Ende des Bewegungsthreads
				try {
					mover.getKICondition().await();
				} catch (InterruptedException e) {

				}
				mover.getKILock().unlock();

			}
			// Wenn kein Gegner gefunden wurde, dann warte kurz ab
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
