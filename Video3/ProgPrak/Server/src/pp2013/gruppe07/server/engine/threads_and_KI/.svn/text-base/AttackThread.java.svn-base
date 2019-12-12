package pp2013.gruppe07.server.engine.threads_and_KI;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;

/**
 * Bildet die abstrakte Oberklasse fuer die Threads, die die Angriffe von
 * Figuren regeln. Die Angriffe von Tuerme werden direkt in der TowerKI geregelt
 * behandelt.
 * 
 * @author Sven
 * 
 */
public abstract class AttackThread {

	protected InteraktiveEntity enemy;
	protected boolean isAttacking;
	protected GameLogic administration;
	protected boolean hitDone = false;
	protected MoveThread_Fight mover;

	/**
	 * Synchronisation mit einer moeglichen KI
	 * 
	 * @author Sven
	 */
	protected Lock kiLock = new ReentrantLock();
	protected Condition kiCondition = kiLock.newCondition();

	/**
	 * Dient der Synchronisation mit einem erzeugten HitEvent
	 * 
	 * @author Sven
	 */
	protected Lock hitLock = new ReentrantLock();
	protected Condition hitCondition = hitLock.newCondition();

	/**
	 * @param administration
	 * @param enemy
	 * @author Sven
	 */
	public AttackThread(GameLogic administration, InteraktiveEntity enemy) {
		this.administration = administration;
		this.enemy = enemy;

		// Erhoehe die Anzahl der Angreifer des Gegners
		enemy.setAttackingEnemies(enemy.getAttackingEnemies() + 1);
	}

	/**
	 * Bietet die Moeglichkeit den Angriffsthread insbesondere von aussen zu
	 * beenden.
	 * 
	 * @author Sven
	 */
	void abort() {
		isAttacking = false;
		if (mover != null)
			mover.abort();
	}

	/**
	 * @return
	 * @author Sven
	 */
	public InteraktiveEntity get_enemy() {
		return enemy;
	}

	/**
	 * Muss auch wegen unterschiedlicher Strukturen in den Unterklassen
	 * implementiert werden
	 * 
	 * @author Sven
	 * @return
	 */
	public abstract Figure get_figure();

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
	public Condition getKICondition() {
		return kiCondition;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public Lock getKILock() {
		return kiLock;
	}

	/**
	 * Zeigt an, ob der Schlag erfolgreich ausgefuehrt wurde.
	 * 
	 * @author Sven
	 */
	public void hitDone() {
		hitDone = true;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public boolean isAttacking() {
		return isAttacking;
	}

	/**
	 * Ueberprueft, ob der Gegner direkt neben der Figur steht. Muss wegen
	 * unterschiedlicher Datenstrukturen in den Unterklassen implementiert
	 * werden
	 * 
	 * @return
	 * @author Sven
	 */
	public abstract boolean near_enough();

}
