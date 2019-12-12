package pp2013.gruppe07.server.engine.threads_and_KI;

import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.HitEvent;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.values;

/**
 * 
 * Regelt nur das Angriffsverhalten von Figuren, die keine Helden sind.
 * 
 * @author Sven
 */
public class AttackThread_Normal extends AttackThread implements Runnable {

	private Figure figure;

	/**
	 * @param administration
	 * @param figure
	 * @param enemy
	 * @author Sven
	 */
	public AttackThread_Normal(GameLogic administration, Figure figure,
			InteraktiveEntity enemy) {
		super(administration, enemy);
		this.figure = figure;
	}

	@Override
	public Figure get_figure() {
		return figure;
	}

	@Override
	public boolean near_enough() {
		int x1 = figure.getPosition()[0];
		int y1 = figure.getPosition()[1];
		int x2 = enemy.getPosition()[0];
		int y2 = enemy.getPosition()[1];
		return (Math.pow(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2), 0.5) <= Math
				.max(figure.getATTACKRANGE(), Math.pow(2, 0.5)));
	}

	/**
	 * Stellt die Angriffsroutine dar.
	 * 
	 * @author Sven
	 */
	@Override
	public void run() {
		isAttacking = true;

		// Solange der Gegner noch lebt und der Angriff nicht abgebrochen wurde.
		while (isAttacking && enemy.isAlive() && figure.isAlive()
				&& administration.isRunning()) {
			// Pruefe ob der Angreifer neben dem Gegner steht.
			if (!near_enough()) {// Gehe zum Gegner hin.
				mover = new MoveThread_Fight(administration, this);

				// Warte bis der Weg gegangen wurde
				mover.getAttackLock().lock();				
				try {
					if(!administration.getThreadPool().isShutdown())
						{administration.getThreadPool().execute(mover);
						mover.getAttackCondition().await();
						}
				} catch (Exception e) {

				}
				mover.getAttackLock().unlock();
			}

			// Lege HitEvent auf EventQueue

			hitLock.lock();
			administration.get_eventManager().addEvent(
					new HitEvent(administration, this));
			// Warte bis der Schlag ausgefuehrt wurde
			try {
				hitCondition.await();
			} catch (InterruptedException e1) {

			}
			hitLock.unlock();

			// Der Thread schlaeft in Abhaengigkeit der Angriffgeschwindigkeit
			// der Figur, aber nur wenn
			// ein Schlag ausgefuehrt wurde
			if (hitDone) {
				if (administration.selfmadeSleeper())
					administration.sleeper(figure.getvalue(values.ATTACKSPEED
							.ordinal()));
				else {
					try {
						Thread.sleep(figure.getvalue(values.ATTACKSPEED
								.ordinal()));
					} catch (InterruptedException e) {

					}
				}
			}
		}

		// Beende Kampfanimationen
		figure.setattack(false);

		// Gib der KI ein Signal, dass der Angriff ausgefuehrt wurde
		kiLock.lock();
		kiCondition.signal();
		kiLock.unlock();

		// Reduziere die Anzahl der Angreifer des Gegners
		enemy.setAttackingEnemies(enemy.getAttackingEnemies() - 1);

	}

}
