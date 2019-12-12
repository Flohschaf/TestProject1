package pp2013.gruppe07.server.engine.threads_and_KI;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.StepEvent;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.Tile;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.values;
import pp2013.gruppe07.shared.entity.Monster;

/**
 * Enthaelt den Bewegungsablauf fuer eine Bewegung ausserhalb eines Angriffes
 * 
 * @author Sven
 * 
 */
public class MoveThread_Normal extends MoveThread implements Runnable {

	private final int dest_position_x;
	private final int dest_position_y;

	/**
	 * Synchronisation mit einer moeglichen KI
	 * 
	 * @author Sven
	 */
	private Lock kiLock = new ReentrantLock();
	private Condition kiCondition = kiLock.newCondition();

	/**
	 * @param administration
	 * @param figure
	 * @param dest_position_x
	 * @param dest_position_y
	 * @author Sven
	 */
	public MoveThread_Normal(GameLogic administration, Figure figure,
			int dest_position_x, int dest_position_y) {
		super(administration, figure);
		this.dest_position_x = dest_position_x;
		this.dest_position_y = dest_position_y;
	}

	/**
	 * @return
	 * @author Sven
	 */
	Condition getKICondition() {
		return kiCondition;
	}

	/**
	 * @return
	 * @author Sven
	 */
	Lock getKILock() {
		return kiLock;
	}

	/**
	 * Berechnet zunaechst den globalen Weg um die festen Hindernisse. Dann wird
	 * fuer jeden Schritt ein Event erstellt. Der Thread wartet bis das Event
	 * abgearbeitet wurde und bekommt eine Rueckmeldung, ob der Schritt getan
	 * werden konnte oder nicht. Wenn nicht, dann stand ein bewegliches Objekt
	 * im Weg und es wird ein neuer Weg fuer die naechsten 10 Schritte
	 * berechnet; diesmal auch um bewegliche Objekte herum. Nach einem Schritt
	 * wird der Thread um die Schrittgeschwindigkeit pausiert.
	 * 
	 * @author Sven
	 */
	@Override
	public void run() {
		// Berechne den Weg um alle unbeweglichen Hindernisse.
		a_star(dest_position_x, dest_position_y, false);

		// Solange der Weg noch nicht abgearbeitet wurde, oder die Bewegung
		// abbrechen soll
		while (!shortestPath.isEmpty() && running && figure.isAlive()
				&& administration.isRunning()) {
			// Hole naechsten Knoten
			TileNode next = shortestPath.removeFirst();

			// Hole zugehoerige Kachel
			stepDone = false;
			Tile destTile = administration.get_map()[next.get_pos_x()][next
					.get_pos_y()];

			// Lasse den Thread warten bis der Step aus der EventQueue
			// abgearbeitet wurde
			stepLock.lock();
			administration.get_eventManager().addEvent(
					new StepEvent(administration, destTile, this));
			try {
				stepCondition.await();
			} catch (InterruptedException e1) {

			}
			stepLock.unlock();

			// Wenn der Schritt nicht ausgefuehrt werden konnte, weil eine Figur
			// den weg versperrt
			if (!stepDone) {
				// Breche ab wenn der letzte Schritt versperrt ist
				if (shortestPath.size() == 0) {
					abort();
				} else {
					int deleteNodes = Math.min(shortestPath.size(), 11);

					// Loesche die naechsten (max.10) Knoten auf dem Weg
					for (int i = 1; i < deleteNodes; i++) {
						shortestPath.removeFirst();
					}

					// Und berechne den Weg bis zum 11. Schritt neu.
					// Beruecksichtige dabei auch Figuren
					a_star(shortestPath.getFirst().get_pos_x(), shortestPath
							.removeFirst().get_pos_y(), true);
				}
			}

			// Warte nach gegangenem Schritt
			else {
				if (administration.selfmadeSleeper())
					administration.sleeper(figure.getvalue(values.MOVESPEED
							.ordinal()));
				else {
					try {
						Thread.sleep(figure.getvalue(values.MOVESPEED.ordinal()));
					} catch (InterruptedException e) {

					}
				}
			}
		}

		// Benachrichtige die MonsterKI
		if (figure instanceof Monster) {
			kiLock.lock();
			kiCondition.signal();
			kiLock.unlock();
		}

		// breche die Bewegung ab
		abort();

	}
}
