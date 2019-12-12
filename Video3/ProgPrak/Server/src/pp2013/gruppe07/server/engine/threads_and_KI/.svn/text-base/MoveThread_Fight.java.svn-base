package pp2013.gruppe07.server.engine.threads_and_KI;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.StepEvent;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.Tile;
import pp2013.gruppe07.shared.entity.Building;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.values;
import pp2013.gruppe07.shared.entity.Nexus;

/**
 * Enthaelt den Bewegungsablauf fuer eine Bewegung waehrend eines Angriffes
 * 
 * @author Sven
 * 
 */
public class MoveThread_Fight extends MoveThread implements Runnable {

	/**
	 * Synchronisation mit dem AttackThread
	 * 
	 * @author Sven
	 */
	private Lock attackLock = new ReentrantLock();
	private Condition attackCondition = attackLock.newCondition();
	private InteraktiveEntity enemy;
	private AttackThread fighter;
	private int dest_position_x = 0;
	private int dest_position_y = 0;

	/**
	 * Ermittle insbesondere auch die tatsaechliche Zielkachel
	 * 
	 * @param administration
	 * @param fighter
	 * @author Sven
	 */
	public MoveThread_Fight(GameLogic administration, AttackThread fighter) {
		super(administration, fighter.get_figure());
		this.fighter = fighter;
		this.enemy = fighter.get_enemy();
		int add_x = 0;
		int add_y = 0;

		// Passe Werte fuer Gebauede mit Flaeche groesser als einer Kachel an
		if (enemy instanceof Building) {
			if (enemy instanceof Nexus) {
				add_x += 2;
				add_y += 1;
			}
		}

		// Die Figur soll nur soweit gehen, dass sie angreifen kann.
		// Insbesondere soll sie nicht auf
		// das Feld des Gegners gehen bei Nahkaempfen. Ermittle deswegen die
		// Angriffskachel,
		// die frei ist und am naechsten an der Figur dran ist.
		double min_dist = Integer.MAX_VALUE;
		int range = figure.getATTACKRANGE();
		int x1 = figure.getPosition()[0];
		int y1 = figure.getPosition()[1];

		// Scueh im kleinsten Quadrat, welches den Angriffradius enthaelt
		for (int i = enemy.getPosition()[0] - range; i <= enemy.getPosition()[0]
				+ range + add_x; i++) {
			for (int j = enemy.getPosition()[1] - range; j <= enemy
					.getPosition()[1] + range + add_y; j++) {
				// Wenn die Kachel im Angriffsradius ist
				if (min_dist > euclid_dist(x1, y1, i, j)
						&& !administration.get_map()[i][j].isBlocked()
						&& !administration.get_map()[i][j].isCurrentlyBlocked()) {
					this.dest_position_x = i;
					this.dest_position_y = j;
					min_dist = euclid_dist(x1, y1, i, j);
				}
			}
		}

		// Wenn keine freie Stelle gefunden wurde, dann breche den
		// Angriff ab.
		if (dest_position_x == 0 && dest_position_y == 0) {
			fighter.abort();
		}
	}

	/**
	 * @return
	 * @author Sven
	 */
	public Condition getAttackCondition() {
		return attackCondition;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public Lock getAttackLock() {
		return attackLock;
	}

	/**
	 * Ueberprueft, ob der Gegner direkt neben der Figur steht
	 * 
	 * @return
	 * @author Sven
	 */
	boolean near_enough() {
		int x1 = figure.getPosition()[0];
		int y1 = figure.getPosition()[1];
		int x2 = enemy.getPosition()[0];
		int y2 = enemy.getPosition()[1];
		return (Math.pow((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)), 0.5) <= Math
				.pow(2, 0.5));
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

		// Solange das Ziel nicht erreicht wurde und die Bewegung noch aktuell
		// ist
		while (!shortestPath.isEmpty() && running && figure.isAlive()
				&& enemy.isAlive() && !near_enough()
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
				// Wenn der Letzte Schritt nicht mehr moeglich ist, dann suche
				// neuen Gegner, der womoegliche
				// leichter zu erreichen ist.
				if (shortestPath.size() == 0) {
					fighter.abort();
				} else {
					int deleteNodes = Math.min(shortestPath.size(), 11);

					// Loesche die naechsten (max.10) Knoten auf dem Weg
					for (int i = 1; i < deleteNodes; i++) {
						shortestPath.removeFirst();
					}

					// Berechne neuen Weg auch um Figuren herum
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

		// Breche Bewegung ab und informiere den Angriffsthread ueber das Ende
		// der Bewegung
		abort();
		attackLock.lock();
		attackCondition.signal();
		attackLock.unlock();
	}

}