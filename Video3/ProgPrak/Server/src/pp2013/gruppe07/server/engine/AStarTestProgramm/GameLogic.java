package pp2013.gruppe07.server.engine.AStarTestProgramm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class GameLogic {

	private EventManager eventManager;

	private A_Star_TestGUI GUI;

	private Tile[][] map;

	private boolean isRunning = true;

	private ExecutorService threadPool = Executors.newCachedThreadPool();

	public GameLogic() {
		eventManager = new EventManager();
		map = createMap();
		GUI = new A_Star_TestGUI(this);

	}

	/**
	 * Test des A*
	 * 
	 * @author Sven
	 * @return
	 */
	Tile[][] createMap() {
		// Testkarte fuer Bewegungsablaeufe
		Tile[][] map = new Tile[30][30];
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				Entity entity;
				if (i == 0 || i == 29 || j == 0 || j == 29) {
					entity = new Tree(i, j);
				} else {
					entity = new SpaceHolder(i, j);
				}
				if ((i + j == 30) && (i < 25) && i > 5 && j < 25 && j > 5) {
					entity = new Tree(i, j);
				}
				if ((i + j == 31) && (i < 25) && i > 5 && j < 25 && j > 5) {
					entity = new Tree(i, j);
				}
				if (i >= 2 && j == 14 && i <= 8) {
					entity = new SafetySteven(i, j, InteraktiveEntity.Team.RED);
				}
				map[i][j] = new Tile(entity, null, i, j);
			}
		}
		return map;
	}

	// Nur zum Testen benutzt.
	public void gamerunning() {
		// Test des A*
		threadPool.execute(new MoveThread_Normal(this, new DangerDan(4, 5,
				InteraktiveEntity.Team.RED), 20, 22));

		while (isRunning) {
			eventManager.handleEvents();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public EventManager get_eventManager() {
		return eventManager;
	}

	public Tile[][] get_map() {
		return map;
	}

	public A_Star_TestGUI getGUI() {
		return GUI;
	}

	/**
	 * Gibt den ThreadPool zurueck
	 * 
	 * @return
	 * @author Sven
	 */
	public ExecutorService getThreadPool() {
		return threadPool;
	}

	public boolean isRunning() {
		return isRunning;
	}

}
