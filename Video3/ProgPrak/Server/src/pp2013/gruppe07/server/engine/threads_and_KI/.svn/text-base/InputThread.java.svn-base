package pp2013.gruppe07.server.engine.threads_and_KI;

import java.util.LinkedList;
import java.util.UUID;

import pp2013.gruppe07.server.comm.ClientSocket;
import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.database.dbase;
import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.ConsumePotionEvent;
import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.ShopEvent;
import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.SpecialHeroAttackEvent;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.server.engine.general.ID_Generator;
import pp2013.gruppe07.server.engine.general.Lobby;
import pp2013.gruppe07.shared.ClientAdmin;
import pp2013.gruppe07.shared.entity.CaptainObvious;
import pp2013.gruppe07.shared.entity.ClitComander;
import pp2013.gruppe07.shared.entity.DangerDan;
import pp2013.gruppe07.shared.entity.FamousFlorian;
import pp2013.gruppe07.shared.entity.FederalFelix;
import pp2013.gruppe07.shared.entity.GeneralHate;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.Hero.Heronames;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.SafetySteven;
import pp2013.gruppe07.shared.entity.SeriousSven;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.AttackEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.BuyEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.ChatEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.ChooseHeroEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.ClientCloseEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.CreateAccountEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.LobbyEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.LogInEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.MoveEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.PotionEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.SpecialAttackEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.StatRequestEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.LobbyTeamListEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.Mana_and_Life_UpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.MoneyUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.StatSendEvent;

/**
 * Liest regelmaessig die Empfangsliste aus und reagiert dementsprechend
 * 
 * @author Sven
 * @author Steven
 * 
 */
public class InputThread implements Runnable {

	private GameLogic administration;
	private Lobby lobby;
	private dbase database;

	/**
	 * Speichert die Move- und Attackthreads der einzelnen Helden um sie ggf.
	 * vorzeitig beenden zu koennen
	 * 
	 * @author Sven
	 */
	private MoveThread_Normal[] movers = new MoveThread_Normal[8];
	private AttackThread_Hero[] fighters = new AttackThread_Hero[8];

	/**
	 * @param administration
	 * @author Sven
	 */
	public InputThread(GameLogic administration) {
		this.administration = administration;
		database = new dbase();
		lobby = new Lobby();
		lobby.init();
	}

	/**
	 * Erstelle zu den gegebenen Werten einen Helden.
	 * 
	 * @param name
	 * @param team
	 * @param isHuman
	 * @return
	 * @author Sven
	 */
	public Hero createHero(Heronames name, Team team, boolean isHuman) {
		Hero hero = null;
		switch (name) {
		case CAPTAIN_OBVIOUS: {
			hero = new CaptainObvious(ID_Generator.getID(), 1, 1, team, isHuman);
			break;
		}
		case CLIT_COMANDER: {
			hero = new ClitComander(ID_Generator.getID(), 1, 1, team, isHuman);
			break;
		}
		case DANGER_DAN: {
			hero = new DangerDan(ID_Generator.getID(), 1, 1, team, isHuman);
			break;
		}
		case FAMOUS_FLORIAN: {
			hero = new FamousFlorian(ID_Generator.getID(), 1, 1, team, isHuman);
			break;
		}
		case FEDERAL_FELIX: {
			hero = new FederalFelix(ID_Generator.getID(), 1, 1, team, isHuman);
			break;
		}
		case GENERAL_HATE: {
			hero = new GeneralHate(ID_Generator.getID(), 1, 1, team, isHuman);
			break;
		}
		case SAFETY_STEVEN: {
			hero = new SafetySteven(ID_Generator.getID(), 1, 1, team, isHuman);
			break;
		}
		case SERIOUS_SVEN: {
			hero = new SeriousSven(ID_Generator.getID(), 1, 1, team, isHuman);
			break;
		}

		}
		return hero;
	}

	/**
	 * Ertellt aus einem Client Event die passende Reaktion des Severs in Form
	 * eines Threads oder eines Events
	 * 
	 * @param event
	 * @author Sven
	 */
	void handleIncommingEvents(Event event) {
		// Behandle die Events nach Typ
		switch (event.getType()) {
		case ATTACK_EVENT: {
			// Hole den Helden
			AttackEvent attackEvent = (AttackEvent) event;
			Hero hero = administration.getClientAdmin()[event.getCLIENTID()]
					.getClientHero();

			// Starte Angriffsthread
			AttackThread_Hero fighter = new AttackThread_Hero(administration,
					hero, administration.get_entities().get(
							attackEvent.getEnemy()));

			// Breche ggf. alte Threads ab
			if (fighters[attackEvent.getCLIENTID()] != null) {
				fighters[attackEvent.getCLIENTID()].abort();
			}

			if (movers[attackEvent.getCLIENTID()] != null) {
				movers[attackEvent.getCLIENTID()].abort();
			}

			administration.getThreadPool().execute(fighter);

			// Schreibe den neuen Thread ins Array
			fighters[attackEvent.getCLIENTID()] = fighter;
			break;
		}
		case BUY_EVENT: {
			BuyEvent buyEvent = (BuyEvent) event;

			// Schreibe ein ShopEvent in die Queue
			administration.get_eventManager().addEvent(
					new ShopEvent(administration, buyEvent.getCLIENTID(),
							buyEvent.getItem()));
			break;
		}
		case CHAT_EVENT: {
			
			ChatEvent chatEvent = (ChatEvent) event;
			// cheat: money: erhoeht geld um 1000
			if (chatEvent.getMessage().equals("money")) {
				administration.getClientAdmin()[chatEvent.getCLIENTID()]
						.getClientHero().changeMoney(1000);
				Communication.newClientMessage(new MoneyUpdateEvent(Waiter
						.getClients().get(chatEvent.getCLIENTID()).getId(),
						1000));
			}

			// cheat: life: erhoeht lebensenergie
			if (chatEvent.getMessage().equals("life")) {
				administration.getClientAdmin()[chatEvent.getCLIENTID()]
						.getClientHero().change_Akt_Life(5000);

				LinkedList<UUID> h = new LinkedList<UUID>();
				h.add(administration.getClientAdmin()[chatEvent.getCLIENTID()]
						.getClientHero().getID());
				for (int j = 0; j < Waiter.getClients().size(); j++) {
					Communication
							.newClientMessage(new Mana_and_Life_UpdateEvent(
						
											j, 5000, 0, h));
				}
				
			}
			else{
				for (int j = 0; j < Waiter.getClients().size(); j++) {

				Communication.newClientMessage(new ChatEvent(Waiter
						.getClients().get(j).getId(), Waiter.getClients()
						.get(event.getCLIENTID()).getAccountName()
						+ ": " + chatEvent.getMessage()));

				}
			}

			// administration.getChat().addChatContent("Client: "+chatEvent.getId()+" sagt:");
			// administration.getChat().addChatContent(chatEvent.getMessage());
			break;
		}
		case CHOOSE_HERO_EVENT: {
			ChooseHeroEvent heroEvent = (ChooseHeroEvent) (event);

			database.playerNewHero(0, Waiter.getClient(event.getCLIENTID())
					.getAccountName(), heroEvent.getHero().toString());
			// Erstelle einen passenden Helden und eine Administration zu den
			// Werten des Events
			Hero hero = createHero(heroEvent.getHero(), heroEvent.getTeam(),
					true);
			administration.getClientAdmin()[heroEvent.getCLIENTID()] = new ClientAdmin(
					hero, hero.getTeam(), heroEvent.getCLIENTID());

			// Markiere den Client als Spielbereit
			Waiter.getClients().get(event.getCLIENTID()).setReady(true);

			// Teste ob alle anderen Clients spielbereit sind
			boolean test = true;
			for (ClientSocket socket : Waiter.getClients()) {

				if (!socket.isReady()) {
					test = false;
				}
			}

			// Wenn ja, dann starte das Spiel
			if (test == true) {
				administration.startGame();

			}
			break;
		}
		case CREATE_ACCOUNT_EVENT: {
			CreateAccountEvent cevent = (CreateAccountEvent) event;
			database.insertNewAccount(cevent.getCLIENTID(),
					cevent.getUsername(), cevent.getPassword());

			break;
		}
		case CLIENT_CLOSE_EVENT: {
			ClientCloseEvent clientClose = (ClientCloseEvent) (event);

			// Loesche die entsprechende Administration
			int id = clientClose.getCLIENTID();
			administration.getClientAdmin()[id] = null;

			// Ueberpruefe ob noch Clients aktiv sind
			boolean isClient = false;
			for (int i = 0; i < 8; i++) {
				if (administration.getClientAdmin()[i] != null) {
					isClient = true;
				}
			}
			
			//Wenn kein Client mehr aktiv ist, schliesse den Server. Da der InputThread auch
			//im ThreadPool ausgefuehrt wird, muss das schliessen in einem extra Thread passieren.
			if (!isClient) {
				new CloseServerThread(administration).start();
			}

			break;
		}
		case LOCK_IN_EVENT: {
			LogInEvent logging = (LogInEvent) event;
			database.checkPasswd(logging.getCLIENTID(), logging.getUsername(),
					logging.getPassword());
			Communication.newClientMessage(new LobbyTeamListEvent(event
					.getCLIENTID(), lobby.getRed(), lobby.getBLUE()));

			break;
		}
		case LOBBY_EVENT: {
			LobbyEvent lobevent = (LobbyEvent) event;
			// lobby.playerAdder(lobevent.getCLIENTID(),lobevent.getHero(),lobevent.getTeam());
			lobby.playerAdder(lobevent.getCLIENTID(), lobevent.getHero(),
					lobevent.getTeam());

			break;
		}
		case MOVE_EVENT: {
			MoveEvent moveevent = (MoveEvent) (event);

			// Hole den Helden aus der Administration und starte einen
			// Bewegungsthread
			ClientAdmin client = administration.getClientAdmin()[moveevent
					.getCLIENTID()];
			MoveThread_Normal mover = new MoveThread_Normal(administration,
					client.getClientHero(), moveevent.getPosition()[0],
					moveevent.getPosition()[1]);

			// Breche ggf. alte Threads ab
			if (movers[moveevent.getCLIENTID()] != null) {
				movers[moveevent.getCLIENTID()].abort();
			}

			if (fighters[moveevent.getCLIENTID()] != null) {
				fighters[moveevent.getCLIENTID()].abort();
			}

			administration.getThreadPool().execute(mover);

			// Ersetze den alten Bewegungsthread im Array
			movers[moveevent.getCLIENTID()] = mover;
			break;
		}
		case POTION_EVENT: {
			PotionEvent potevt = (PotionEvent) (event);

			// Erstelle ein Serverevent fuer das Konsumieren eines Trankes
			Hero hero = administration.getClientAdmin()[potevt.getCLIENTID()]
					.getClientHero();
			administration.get_eventManager().addEvent(
					new ConsumePotionEvent(administration, hero, potevt
							.IS_ELIXIR()));

			break;
		}
		case SPECIAL_ATTACK_EVENT: {
			SpecialAttackEvent spcEvent = (SpecialAttackEvent) (event);

			// Erstelle ein Serverevent fuer eine Spezialattacke
			Hero hero = administration.getClientAdmin()[spcEvent.getCLIENTID()]
					.getClientHero();
			administration.get_eventManager().addEvent(
					new SpecialHeroAttackEvent(administration, hero, spcEvent
							.getSpc()));
			break;
		}

		case STAT_REQUEST_EVENT: {
			System.out.println("request");
			StatRequestEvent stat = (StatRequestEvent) (event);
			String[][] statHero = database
					.getAccountHeros(stat.getPlayerName());
			Communication.newClientMessage(new StatSendEvent(event
					.getCLIENTID(), statHero));
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.print(statHero[i][j] + " ");
				}
				System.out.println();
			}
			break;
		}
		}
	}

	/**
	 * Arbeitet kontinuierlich die Empfangsliste ab und erstellt passende
	 * Reaktionen des Servers
	 * 
	 * @author Sven
	 */
	@Override
	public void run() {
		while (!administration.isServerClosed()) {
			for (Event evt : Communication.getServerMessage()) {
				handleIncommingEvents(evt);
			}

			if (administration.selfmadeSleeper())
				administration.sleeper(10);
			else {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {

				}
			}
		}

	}

}
