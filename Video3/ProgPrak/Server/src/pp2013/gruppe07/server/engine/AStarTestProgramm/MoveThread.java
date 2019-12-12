package pp2013.gruppe07.server.engine.AStarTestProgramm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class MoveThread {

	class TileNode implements Comparable<TileNode> {
		private int position_x;
		private int position_y;
		private TileNode father;
		private double f = 0;
		private double g = 0;

		public TileNode(int position_x, int position_y, double f,
				TileNode father) {
			this.position_x = position_x;
			this.position_y = position_y;
			this.f = f;
			this.father = father;
		}

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

		@Override
		public boolean equals(Object o) {
			if (this.position_x == ((TileNode) o).get_pos_x()
					&& this.position_y == ((TileNode) o).get_pos_y())
				return true;
			else
				return false;
		}

		double get_f() {
			return f;
		}

		TileNode get_father() {
			return father;
		}

		double get_g() {
			return g;
		}

		int get_pos_x() {
			return position_x;
		}

		int get_pos_y() {
			return position_y;
		}

		void set_f(double value) {
			f = value;
		}

		void set_father(TileNode father) {
			this.father = father;
		}

		void set_g(double value) {
			g = value;
		}

		void set_pos_x(int value) {
			position_x = value;
		}

		void set_pos_y(int value) {
			position_y = value;
		}

	}

	protected GameLogic administration;

	protected Figure figure;
	protected Lock stepLock = new ReentrantLock();

	protected Condition stepCondition = stepLock.newCondition();
	protected boolean stepDone;

	protected boolean running = true;
	protected final int dest_position_x;

	protected final int dest_position_y;
	private final int UP = 1;
	private final int UPRIGHT = 5;
	private final int RIGHT = 2;
	private final int DOWNRIGHT = 6;
	private final int DOWN = 3;
	private final int DOWNLEFT = 7;
	private final int LEFT = 4;

	private final int UPLEFT = 8;
	PriorityQueue<TileNode> openlist = new PriorityQueue<TileNode>();
	LinkedList<TileNode> closelist = new LinkedList<TileNode>();
	LinkedList<TileNode> shortestPath = new LinkedList<TileNode>();

	private boolean pathFound;

	public MoveThread(GameLogic administration, Figure figure,
			int dest_position_x, int dest_position_y) {
		this.administration = administration;
		this.dest_position_x = dest_position_x;
		this.dest_position_y = dest_position_y;
		this.figure = figure;
	}

	void a_star(int dest_x, int dest_y, boolean exactSearch) {
		openlist = new PriorityQueue<TileNode>();
		closelist = new LinkedList<TileNode>();
		pathFound = false;
		openlist.add(new TileNode(figure.getPosition()[0],
				figure.getPosition()[1], 0, null));
		TileNode current;
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

				// Test des A*
				administration.getGUI().setState(current.get_pos_x(),
						current.get_pos_y(), 3);

				closelist.add(current);
			}
		}
		// Erzeuge den kuerzesten Pfad, wenn der Algo beendet ist
		if (pathFound) {
			current = closelist.getLast();
			while (current.get_father() != null) {
				shortestPath.addFirst(current);

				// Test des A*
				administration.getGUI().setState(current.get_pos_x(),
						current.get_pos_y(), 6);

				current = current.get_father();
			}
		}
		// Gib Speicherplatz frei.
		openlist.clear();
		closelist.clear();
	}

	public void abort() {
		running = false;
	}

	protected double euclid_dist(int x1, int y1, int x2, int y2) {
		return Math.pow((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)), 0.5);
	}

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

				if (openlist.contains(neighbor)) {// Dann suche ihn und
													// aktualisiere ggf. seine
													// Werte
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
				} else {// Fuege Nachbarn hinzu
					openlist.add(neighbor);

					// Test des A*
					administration.getGUI().setState(x, y, 2);

				}

			}
		}
	}

	Figure get_figure() {
		return figure;
	}

	Condition getStepCondition() {
		return stepCondition;
	}

	Lock getStepLock() {
		return stepLock;
	}

	public boolean isRunning() {
		return running;
	}

	void stepDone() {
		stepDone = true;
	}

}
