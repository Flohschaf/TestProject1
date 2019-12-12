package pp2013.gruppe07.server.engine.AStarTestProgramm;

class MoveThread_Normal extends MoveThread implements Runnable {

	public MoveThread_Normal(GameLogic administration, Figure figure,
			int dest_position_x, int dest_position_y) {
		super(administration, figure, dest_position_x, dest_position_y);
	}

	@Override
	public void run() {
		// Berechne den Weg um alle unbeweglichen Hindernisse.
		a_star(dest_position_x, dest_position_y, false);

		while (!shortestPath.isEmpty() && running && figure.isAlive()) {
			TileNode next = shortestPath.removeFirst();

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
				e1.printStackTrace();
			}
			stepLock.unlock();

			// Wenn der Schritt nicht ausgefuehrt werden konnte, weil eine Figur
			// den weg versperrt
			if (!stepDone) {
				if (shortestPath.size() == 0) {
					abort();
				} else {
					int deleteNodes = Math.min(shortestPath.size(), 11);
					// Loesche die naechsten (max.10) Knoten auf dem Weg
					for (int i = 1; i < deleteNodes; i++) {
						shortestPath.removeFirst();
					}

					// Test des A*
					for (Tile[] t1 : administration.get_map()) {
						for (Tile t : t1) {
							if (t.getState() == 2 || t.getState() == 3) {
								t.resetState();
							}
						}
					}

					administration.getGUI().setState(figure.getPosition()[0],
							figure.getPosition()[1], 4);

					// Und berechne den Weg bis zum 11. Schritt neu.
					// Beruecksichtige dabei auch Figuren
					a_star(shortestPath.getFirst().get_pos_x(), shortestPath
							.removeFirst().get_pos_y(), true);
				}
			}

			// Warte nach gegangenem Schritt
			else {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		abort();

	}
}
