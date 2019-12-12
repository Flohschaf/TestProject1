package pp2013.gruppe07.server.engine.general;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.EventManager;
import pp2013.gruppe07.server.engine.threads_and_KI.CreateVasallsThread;
import pp2013.gruppe07.server.engine.threads_and_KI.HeroKI;
import pp2013.gruppe07.server.engine.threads_and_KI.InputThread;
import pp2013.gruppe07.server.engine.threads_and_KI.MonsterKI;
import pp2013.gruppe07.server.engine.threads_and_KI.Taxometer_and_IncreaseThread;
import pp2013.gruppe07.server.engine.threads_and_KI.TowerKI;
import pp2013.gruppe07.server.map.Map_Gen;
import pp2013.gruppe07.server.statistic.statistics;
import pp2013.gruppe07.shared.ClientAdmin;
import pp2013.gruppe07.shared.Tile;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.Monster;
import pp2013.gruppe07.shared.entity.SafetySteven;
import pp2013.gruppe07.shared.entity.Tower;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ClientAdminUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.EndGameUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.WorldCreateEvent;

/**Ist die zentrale Administrationsklasse und beinhaltet die grundlegende Verwaltung des Spielablaufs,
 * sowie grundlegende Objekte (Map, ThreadPool, Instanz des Eventmangers). 
 * @author Sven
 *
 */
/**
 * @author Sven
 * @author Steven
 * 
 */
public class GameLogic {

	
	private Waiter waiter;
	private Team wonGame;

	private boolean inhibitorAliveRed = true;
	private boolean inhibitorAliveBlue = true;

	private boolean isRunning = false;
	private boolean serverClose = false;

	private boolean selfmadeSleeper = false;
	statistics stat;

	/**
	 * Beeinhaltet alle interagierenden Objekte auf der Map, gespeichert nach
	 * ihrer UUID.
	 * 
	 * @author Sven
	 */
	private HashMap<UUID, InteraktiveEntity> entities = new HashMap<UUID, InteraktiveEntity>();

	/**
	 * Ist die einzige Instanz des Event Mangers.
	 * 
	 * @author Sven
	 */
	private EventManager eventManager;

	/**
	 * Haelt die Map
	 * 
	 * @author Sven
	 */
	private Tile[][] map;

	/**
	 * Ist die einzige Instanz des MapGenerators und dient als Schnittstelle
	 * zwischen diesem
	 * 
	 * @author Sven
	 */
	private Map_Gen mapping;

	/**
	 * Haelt alle Clientadministrationsklassen.
	 * 
	 * @author Sven
	 */
	private ClientAdmin[] clientAdmin = new ClientAdmin[8];

	/**
	 * ThreadPool fuer alle Threads der ServerEngine
	 * 
	 * @author Sven
	 * @author Steven
	 */
	private ExecutorService threadPool = Executors.newCachedThreadPool();

	/**
	 * Startet den EventManger die Kommunikation.
	 * 
	 * @author Sven
	 */
	public GameLogic() {
		stat = new statistics(this);
		eventManager = new EventManager();
		waiter=new Waiter(this);
		threadPool.execute(waiter);
		threadPool.execute((new InputThread(this)));
		
		
	}

	/**
	 * Faehrt alle Threads und somit den kompletten Server direkt herunter
	 * 
	 * @author Sven
	 */
	public void closeServer() {
		serverClose = true;
		
		//Schliesse den Serversocket.
		try {
			waiter.getServerSocket().close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		quitGame();		

		// Gib den Threads Zeit sich zu Beenden oder in einen sleeper zu gehen.
		// Kein Thread soll beim
		// Ausfuehren gestoppt werden
		try {
			Thread.sleep(2000);
			
			// Beende die wartenden und schlafenden Threads
			threadPool.shutdown();
			
			Thread.sleep(2000);
			
			threadPool.shutdownNow();
			
		} catch (Exception e) {
		}
		System.out.println("Der Server ist beendet");

	}

	/**
	 * Gibt Anzahl der am Spiel teilnehmenden Spieler zurueck. Wichtig fuer
	 * Statistik
	 * 
	 * @return
	 * @author Steven
	 */

	public int countPlayer() {
		int count = 0;
		for (int i = 0; i < 8; i++)
			if (clientAdmin[i] != null)
				count++;

		return count;
	}

	/**
	 * Ist die Main-Loop, die kontinuierlich den EventManager abarbeitet.
	 * 
	 * @author Sven
	 */
	public void gamerunning() {
		while (!serverClose) {
			eventManager.handleEvents();
			if (selfmadeSleeper)
				sleeper(10);
			else {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
			}

		}
	}

	/**
	 * Gibt die HashMap zurueck, die alle interagierende Objekte beeinhaltet.
	 * 
	 * @return
	 * @author Sven
	 */
	public HashMap<UUID, InteraktiveEntity> get_entities() {
		return entities;
	}

	/**
	 * Ermoeglicht Zugriff auf den Event Manager.
	 * 
	 * @return
	 */
	public EventManager get_eventManager() {
		return eventManager;
	}

	public Tile[][] get_map() {
		return map;
	}

	/**
	 * Gibt eine CLientadministration zurueck.
	 * 
	 * @return
	 * @author Sven
	 */
	public ClientAdmin[] getClientAdmin() {
		return clientAdmin;
	}

	/**
	 * Gibt die Nexusposition des entsprechenden Teams zurueck.
	 * 
	 * @author Sven
	 * @param team
	 * @return
	 */
	public int[] getNexusPosition(Team team) {
		int[] erg = new int[2];
		erg = mapping.getNexusPosition(team);
		return erg;
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

	/**
	 * @return
	 * @author Sven
	 */
	public Team getWonGame() {
		return wonGame;
	}

	/**
	 * Gibt zurueck, ob der entsprechende Inhibitor noch lebt.
	 * 
	 * @return
	 * @author Sven
	 */
	public boolean isInhibitorAliveBlue() {
		return inhibitorAliveBlue;
	}

	/**
	 * Gibt zurueck, ob der entsprechende Inhibitor noch lebt.
	 * 
	 * @return
	 * @author Sven
	 */
	public boolean isInhibitorAliveRed() {
		return inhibitorAliveRed;
	}

	/**
	 * Zeigt, ob das Spiel noch laeuft.
	 * 
	 * @return
	 * @author Sven
	 */
	public boolean isRunning() {
		return isRunning;
	}

	/**
	 * Zeigt, ob der Server heruntergefahren wurde.
	 * 
	 * @return
	 * @author Sven
	 */
	public boolean isServerClosed() {
		return serverClose;
	}

	/**
	 * Beendet das Spiel und alle Threads die mit dem Spiel an sich verbunden
	 * sind.
	 * 
	 * @author Sven
	 */
	public void quitGame() {
		if(wonGame!= null)
			stat.gameStatinDB(wonGame);
		
		isRunning = false;
		for (int i = 0; i < Waiter.getClients().size(); i++) {
			Communication.newClientMessage(new EndGameUpdateEvent(Waiter
					.getClients().get(i).getId(), wonGame));
		}
	}

	/**
	 * Gibt an, ob die Methode Thread.sleep (bei false) oder der
	 * Selfmade-Sleeper verwendet wird
	 * 
	 * @return
	 * @author Sven
	 */
	public boolean selfmadeSleeper() {
		return selfmadeSleeper;
	}

	/**
	 * Setzt eine Clientadministration.
	 * 
	 * @author Sven
	 * @param id
	 * @param clientAdmin
	 */
	public void setClientAdmin(int id, ClientAdmin clientAdmin) {
		this.clientAdmin[id] = clientAdmin;
	}

	/**
	 * Wird aufgerufen, wenn Inhibitor zerstoert wurde.
	 * 
	 * @param inhibitorAliveRed
	 * @author Sven
	 */
	public void setInhibitorAliveBlue(boolean inhibitorAliveBlue) {
		this.inhibitorAliveBlue = inhibitorAliveBlue;
	}

	/**
	 * Wird aufgerufen, wenn Inhibitor zerstoert wurde.
	 * 
	 * @param inhibitorAliveRed
	 * @author Sven
	 */
	public void setInhibitorAliveRed(boolean inhibitorAliveRed) {
		this.inhibitorAliveRed = inhibitorAliveRed;
	}

	/**
	 * @param wonGame
	 * @author Sven
	 */
	public void setWonGame(Team wonGame) {
		this.wonGame = wonGame;
	}

	/**
	 * Soll die Methode Thread.sleep() ersetzen, da der Server mindestens 500ms
	 * unterbricht.
	 * 
	 * @author Sven
	 * @param time
	 */
	public void sleeper(long time) {
		long timer = System.currentTimeMillis();
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while (System.currentTimeMillis() < timer + time) {
			Thread.yield();
		}
		Thread.currentThread().setPriority(5);
	}

	/**
	 * Wird aufgerufen, wenn die Lobby beendet wird und das Spiel gestartet
	 * werden soll
	 * 
	 * @author Sven
	 */
	public void startGame() {
		isRunning = true;	
		
		// Ordnet die uebergebenen Heros in ein Array ein, welches nach Teams
		// sortiert ist
		// und dann dem Map-Generator uebergeben wird.
		Hero[] heros = new Hero[8];
		LinkedList<Hero> heroes_red = new LinkedList<Hero>();
		LinkedList<Hero> heroes_blue = new LinkedList<Hero>();
		for (int i = 0; i < 8; i++) {
			if (clientAdmin[i] != null) {
				if (clientAdmin[i].getClientHero().getTeam().equals(Team.RED)) {
					heroes_red.add(clientAdmin[i].getClientHero());
				} else {
					heroes_blue.add(clientAdmin[i].getClientHero());
				}
			}
		}

		int counter = 0;
		for (Hero hero : heroes_red) {
			heros[counter] = hero;
			counter++;
		}

		counter = 4;
		for (Hero hero : heroes_blue) {
			heros[counter] = hero;
			counter++;
		}
		
		//Fuelle restliche Plaetze mit Heros des Typs SafetySteven auf,
		//die von einer KI gesteuert werden.
		for (int i=0;i<8;i++)
			{if(heros[i]==null)
				{Team heroteam;
				if(i<4)
					{heroteam=Team.RED;}
				else
					{heroteam=Team.BLUE;}
				//df2015 heros[i]=new SafetySteven(ID_Generator.getID(),1,1,heroteam,false);
				}
			}
		
		
		// Erzeugt die Map.
		mapping = new Map_Gen(heros);
		map = mapping.get_map();

		// Gehe die Map durch um KIs zu starten und um die Objekte in die
		// HashMap einzufuegen.
		for (int i = 20; i < 120; i++) {
			for (int j = 20; j < 120; j++) {
				if (map[i][j].getobject() instanceof InteraktiveEntity) {
					InteraktiveEntity entity = (InteraktiveEntity) map[i][j]
							.getobject();
					entities.put(entity.getID(), entity);
					if (entity instanceof Hero) {
						if (!((Hero) entity).isHuman()) {
							threadPool.execute(new HeroKI(this, (Hero) entity));							
						}
					} else {
						if (entity instanceof Tower) {
							threadPool
									.execute(new TowerKI(this, (Tower) entity));
						} else {
							if (entity instanceof Monster) {
								threadPool.execute(new MonsterKI(this,
										(Monster) entity));
							}
						}
					}
				}
			}
		}

		// Sendet die Map und die Administrationen an die Clients. Reihenfolge
		// ist sehr wichtig
		for (int i = 0; i < Waiter.getClients().size(); i++) {
			Communication.newClientMessage(new WorldCreateEvent(Waiter
					.getClients().get(i).getId(), map));
		}
		for (int i = 0; i < 8; i++) {
			Communication.newClientMessage(new ClientAdminUpdateEvent(i,
					clientAdmin[i]));
		}

		// Warte ein bisschen, damit die Clients ein bisschen Zeit haben die
		// Karte zu erhalten
		// und zu zeichnen
		if (selfmadeSleeper)
			sleeper(500);
		else
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			
			}

		// Starte weitere Threads
		threadPool.execute((new CreateVasallsThread(this)));
		threadPool.execute((new Taxometer_and_IncreaseThread(this)));
	}

}
