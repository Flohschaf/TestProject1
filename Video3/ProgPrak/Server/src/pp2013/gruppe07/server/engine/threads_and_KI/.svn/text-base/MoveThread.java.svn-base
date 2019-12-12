package pp2013.gruppe07.server.engine.threads_and_KI;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.Tile;
import pp2013.gruppe07.shared.entity.Figure;

/**
 * Regelt den kompletten Bewegungsablauf einer Figur zu einer Zielposition.
 * Beinhaltet den A*.
 * 
 * @author Sven
 */

public abstract class MoveThread {

	/**
	 * Repraesentiert die Knoten im A*. Ein TileNode repraesentiert eine Kachel
	 * der Map. Die Bezeichner f und g sind benannt nach dem Pseudocode von
	 * Wikipedia.
	 * 
	 * @author Sven
	 */
	class TileNode implements Comparable<TileNode> {
		private int position_x;
		private int position_y;
		private TileNode father;
		private double f = 0;
		private double g = 0;

		/**
		 * @param position_x
		 * @param position_y
		 * @param f
		 * @param father
		 * @author Sven
		 */
		public TileNode(int position_x, int position_y, double f,
				TileNode father) {
			this.position_x = position_x;
			this.position_y = position_y;
			this.f = f;
			this.father = father;
		}

		/**
		 * Knoten sollen nach ihrem f-Wert vergleichbar sein
		 * 
		 * @author Sven
		 */
		@Override
		public int compareTo(TileNode o) {
			if (this.get_f() < o.get_f())
				return -1;
			else {
				if (this.get_f() == o.get_f())
					return 0;
				else
					return 1;
			}
		}

		/**
		 * Knoten sollen nur nach Position unterschieden werden
		 * 
		 * @author Sven
		 */
		@Override
		public boolean equals(Object o) {
			if (this.position_x == ((TileNode) o).get_pos_x()
					&& this.position_y == ((TileNode) o).get_pos_y())
				return true;
			else
				return false;
		}

		/**
		 * @return
		 * @author Sven
		 */
		double get_f() {
			return f;
		}

		/**
		 * @return
		 * @author Sven
		 */
		TileNode get_father() {
			return father;
		}

		/**
		 * @return
		 * @author Sven
		 */
		double get_g() {
			return g;
		}

		/**
		 * @return
		 * @author Sven
		 */
		int get_pos_x() {
			return position_x;
		}

		/**
		 * @return
		 * @author Sven
		 */
		int get_pos_y() {
			return position_y;
		}

		/**
		 * @param value
		 * @author Sven
		 */
		void set_f(double value) {
			f = value;
		}

		/**
		 * @param father
		 * @author Sven
		 */
		void set_father(TileNode father) {
			this.father = father;
		}

		/**
		 * @param value
		 * @author Sven
		 */
		void set_g(double value) {
			g = value;
		}

		/**
		 * @param value
		 * @author Sven
		 */
		void set_pos_x(int value) {
			position_x = value;
		}

		/**
		 * @param value
		 * @author Sven
		 */
		void set_pos_y(int value) {
			position_y = value;
		}

	}

	protected GameLogic administration;

	protected Figure figure;
	/**
	 * Synchronisation mit einem StepEvent.
	 * 
	 * @author Sven
	 */
	protected Lock stepLock = new ReentrantLock();

	protected Condition stepCondition = stepLock.newCondition();
	protected boolean stepDone;

	protected boolean running = true;
	private final int UP = 1;
	private final int UPRIGHT = 5;
	private final int RIGHT = 2;
	private final int DOWNRIGHT = 6;
	private final int DOWN = 3;
	private final int DOWNLEFT = 7;
	private final int LEFT = 4;

	private final int UPLEFT = 8;
	// Gehoert zur Implementierung des A*
	PriorityQueue<TileNode> openlist = new PriorityQueue<TileNode>();
	LinkedList<TileNode> closelist = new LinkedList<TileNode>();
	LinkedList<TileNode> shortestPath = new LinkedList<TileNode>();

	private boolean pathFound;

	/**
	 * @param administration
	 * @param figure
	 * @author Sven
	 */
	public MoveThread(GameLogic administration, Figure figure) {
		this.administration = administration;
		this.figure = figure;
	}

	/**
	 * Implementiert den A*. Der Variable exactSearch gibt an, ob bewegliche
	 * Hindernisse uebersehen werden, oder ob die Suche exact ablaeuft. Die
	 * Methode implementiert den Pseudocode von http://de.wikipedia.org/wiki/A*
	 * und orientiert sich an der Musterloesung aus der Vorlesung Informatik II
	 * 2012/2013 Blatt 6 bei Herrn Prof. Speckenmeyer.
	 * 
	 * @author Sven
	 * @param dest_x
	 * @param dest_y
	 * @param exactSearch
	 * */
	void a_star(int dest_x, int dest_y, boolean exactSearch) {
		// Initialisiere die Listen und Variablen
		openlist = new PriorityQueue<TileNode>();
		closelist = new LinkedList<TileNode>();
		pathFound = false;

		// Fuege Startknoten hinzu
		openlist.add(new TileNode(figure.getPosition()[0],
				figure.getPosition()[1], 0, null));
		TileNode current;

		// Solange die Openlist nicht leer ist und der Weg nicht gefunden wurde
		while (!openlist.isEmpty() && !pathFound) {// Hole neuen Knoten
			current = openlist.poll();

			// Beende die Suche, wenn Ziel erreicht ist
			if (current.get_pos_x() == dest_x && current.get_pos_y() == dest_y) {
				closelist.addLast(current);
				pathFound = true;
			}

			// Betrachte die Nachbarknoten
			else {
				expandNode(current, dest_x, dest_y, exactSearch);
				closelist.add(current);
			}
		}

		// Erzeuge den kuerzesten Pfad, wenn der Algorithmus beendet ist
		if (pathFound) {
			current = closelist.getLast();
			while (current.get_father() != null) {
				shortestPath.addFirst(current);
				current = current.get_father();
			}
		}

		// Gib Speicherplatz frei.
		openlist.clear();
		closelist.clear();
	}

	/**
	 * Ermoeglicht das Beenden des Threads insbesonderen von aussen
	 * 
	 * @author Sven
	 */
	public void abort() {
		running = false;
	}

	/**
	 * Bestimmt den euklidischen Abstand zwischen 2 Punkten
	 * 
	 * @author Sven
	 */
	protected double euclid_dist(int x1, int y1, int x2, int y2) {
		return Math.pow((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)), 0.5);
	}

	/**
	 * Die Methode behandelt die Nachbarn des aktuellen Knotens. Die Methode
	 * implementiert den Pseudocode von http://de.wikipedia.org/wiki/A*, nur das
	 * auf den continue Befehl verzichtet wird.
	 * 
	 * @author Sven
	 * @param current
	 * @param dest_x
	 * @param dest_y
	 * @param exactSearch
	 */
	private void expandNode(TileNode current, int dest_x, int dest_y,
			boolean exactSearch) {
		int x;
		int y;

		// Betrachte nacheinander alle 8 Nachbarknoten
		for (int i = 1; i <= 8; i++) {
			switch (i) {
			case UP: {
				x = current.get_pos_x();
				y = current.get_pos_y() - 1;
				break;
			}
			case UPRIGHT: {
				x = current.get_pos_x() + 1;
				y = current.get_pos_y() - 1;
				break;
			}
			case RIGHT: {
				x = current.get_pos_x() + 1;
				y = current.get_pos_y();
				break;
			}
			case DOWNRIGHT: {
				x = current.get_pos_x() + 1;
				y = current.get_pos_y() + 1;
				break;
			}
			case DOWN: {
				x = current.get_pos_x();
				y = current.get_pos_y() + 1;
				break;
			}
			case DOWNLEFT: {
				x = current.get_pos_x() - 1;
				y = current.get_pos_y() + 1;
				break;
			}
			case LEFT: {
				x = current.get_pos_x() - 1;
				y = current.get_pos_y();
				break;
			}
			case UPLEFT: {
				x = current.get_pos_x() - 1;
				y = current.get_pos_y() - 1;
				break;
			}
			default: {
				x = y = 0;
			}
			}

			// Erzeuge neuen Knoten und hole die zugehoerige Kachel aus der Map.
			final TileNode neighbor = new TileNode(x, y, Integer.MAX_VALUE,
					current);
			Tile neighborTile = administration.get_map()[x][y];

			// Wenn der Knoten noch nicht fertig betrachtet wurde und nicht
			// blockiert ist
			if (!closelist.contains(neighbor) && !neighborTile.isBlocked()
					&& (!exactSearch || !neighborTile.isCurrentlyBlocked())) {
				// Bestimme die Kosten fuer den Schritt (diagonale Schritte
				// haben Kosten wurzel(2), sonst 1)
				double stepcost = 1;
				if (i > 4) {
					stepcost *= Math.sqrt(2);
				}

				// Setze Werte des Nachbarn
				neighbor.set_g(current.get_g() + stepcost);
				neighbor.set_f(neighbor.get_g()
						+ euclid_dist(x, y, dest_x, dest_y));
				neighbor.set_father(current);

				// Wenn der Nachbar bereits betrachtet wird
				if (openlist.contains(neighbor)) {

					// Dann suche ihn und aktualisiere ggf. seine Werte und
					// loesche den vorherigen Eintrag
					final Iterator<TileNode> it = openlist.iterator();
					boolean found = false;
					while (it.hasNext() && !found) {
						final TileNode node = it.next();
						if (node.equals(neighbor)
								&& node.get_f() > neighbor.get_f()) {
							openlist.remove(node);
							openlist.add(neighbor);
							found = true;
						}
					}
				}

				// Wenn der Nachbar noch nicht in der Openlist ist
				else {// fuege Nachbarn hinzu
					openlist.add(neighbor);
				}

			}
		}
	}

	/**
	 * @return
	 * @author Sven
	 */
	public Figure get_figure() {
		return figure;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public Condition getStepCondition() {
		return stepCondition;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public Lock getStepLock() {
		return stepLock;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Gibt an, ob ein Schritt erfolgreich war.
	 * 
	 * @author Sven
	 */
	public void stepDone() {
		stepDone = true;
	}

}
