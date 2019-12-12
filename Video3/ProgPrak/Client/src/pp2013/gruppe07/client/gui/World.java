package pp2013.gruppe07.client.gui;

//import pp2013.gruppe07.client.communication.Message;
//import pp2013.gruppe07.client.communication.Server;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;

import pp2013.gruppe07.client.Chat;
import pp2013.gruppe07.client.comm.Communication;
import pp2013.gruppe07.shared.ClientAdmin;
import pp2013.gruppe07.shared.Tile;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.values;
import pp2013.gruppe07.shared.entity.Monster;
import pp2013.gruppe07.shared.entity.SpaceHolder;
import pp2013.gruppe07.shared.entity.Tower;
import pp2013.gruppe07.shared.entity.Vasall;
import pp2013.gruppe07.shared.eventManager.EventListener;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.BuyEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.ChatEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.InfoEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.MoveEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.PotionEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.SpecialAttackEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ClientAdminUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ConsumePotionUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.CreateUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.EndGameUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.HitUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ItemUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.Mana_and_Life_UpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.MoneyUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.MoveUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.PureLifeUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.RespawnUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.SpecialAttackUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ValuesUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.WorldCreateEvent;
import pp2013.gruppe07.shared.item.Elixir;
import pp2013.gruppe07.shared.item.Manapotion;

/**
 * Die World ist das Herz der Clientengine. Sie wird zu Beginn des Spiels
 * erstellt und verarbeitet so gut wie alle Informationen ueber den
 * EventManager. So gut wie jedes Event muss den Umweg uebr die WorldKlasse
 * nehmen um verarbeitet zu werden.
 * 
 * @author Felix
 * 
 */
public class World implements EventListener {
	Tile[][] map;
	ClientAdmin clientAdmin;
	int x;
	int y;
	
	private boolean created = false;
	public Chat chat;
	private boolean gamerunning = true;
	private boolean win=false;
	private HashMap<UUID, InteraktiveEntity> interActiveEntity = new HashMap<UUID, InteraktiveEntity>();

	private LinkedList<InteraktiveEntity> entities = new LinkedList<InteraktiveEntity>();

	public static HashMap<String, SpecialAttackEvent.Attacks> spezAttacks;

	public World(Tile[][] map) {

		initSpezattacks();
		addEntity(map);
		System.out.println("Client: " + interActiveEntity.size());

		chat = new Chat();

		this.map = map;
		this.x = x;
		this.y = y;

		EventManager.registerListener(this,
				Event.Type.CLIENT_ADMIN_UPDATE_EVENT);
		EventManager.registerListener(this, Event.Type.POTION_EVENT);
		EventManager.registerListener(this, Event.Type.MOVE_EVENT);
		EventManager.registerListener(this, Event.Type.CHAT_EVENT);
		EventManager.registerListener(this, Event.Type.WORLD_CREATE_EVENT);
		EventManager.registerListener(this, Event.Type.SPECIAL_ATTACK_EVENT);
		EventManager.registerListener(this, Event.Type.BUY_EVENT);
		EventManager.registerListener(this, Event.Type.CHOOSE_HERO_EVENT);
		EventManager.registerListener(this, Event.Type.MONEY_UPDATE_EVENT);
		EventManager.registerListener(this, Event.Type.MOVE_UPDATE_EVENT);
		EventManager.registerListener(this, Event.Type.HIT_UPDATE_EVENT);
		EventManager.registerListener(this, Event.Type.ITEM_UPDATE_EVENT);
		EventManager.registerListener(this,
				Event.Type.SPECIAL_ATTACK_UPDATE_EVENT);
		EventManager.registerListener(this, Event.Type.CREATE_UPDATE_EVENT);
		EventManager.registerListener(this, Event.Type.VALUES_UPDATE_EVENT);
		EventManager.registerListener(this,
				Event.Type.CONSUME_POTION_UPDATE_EVENT);
		EventManager.registerListener(this, Event.Type.RESPAWN_UPDATE_EVENT);
		EventManager.registerListener(this,
				Event.Type.MANA_AND_LIFE_UPDATE_EVENT);
		EventManager.registerListener(this, Event.Type.END_GAME_UPDATE_EVENT);
		EventManager.registerListener(this, Event.Type.PURE_LIFE_UPDATE_EVENT);

	}

	public HashMap<UUID, InteraktiveEntity> getEntities() {
		return this.interActiveEntity;
	}

	/**
	 * erzeugt dieHashMap fuer die spezial Attacken
	 */
	public void initSpezattacks() {
		spezAttacks = new HashMap<String, SpecialAttackEvent.Attacks>();

		spezAttacks.put("Schutz Schild(armor)",
				SpecialAttackEvent.Attacks.SCHUTZSCHILD);
		spezAttacks.put("Eis Pfeil(Slow)", SpecialAttackEvent.Attacks.EISPFEIL);
		spezAttacks.put("Frost Pfeil(Stun)",
				SpecialAttackEvent.Attacks.FROSTFEIL);
		spezAttacks.put("Ultimate", SpecialAttackEvent.Attacks.ULTIMATE);
		spezAttacks.put("Aussaugen(Schwaechen)",
				SpecialAttackEvent.Attacks.AUSSAUGEN);
		spezAttacks.put("Hinterhalts Schlag",
				SpecialAttackEvent.Attacks.HINTERHALT);
		spezAttacks.put("Clitisieren", SpecialAttackEvent.Attacks.CLITISIEREN);

		spezAttacks.put("Starker Schlag",
				SpecialAttackEvent.Attacks.STARKERSCHLAG);

		spezAttacks.put("SuperSayajin(stronger)",
				SpecialAttackEvent.Attacks.SUPERSAYAJIN);
		spezAttacks.put("Erdbeben", SpecialAttackEvent.Attacks.ERDBEBEN);

		spezAttacks.put("Schoenes Lied",
				SpecialAttackEvent.Attacks.SCHOENESLIED);
		spezAttacks.put("Auszahlung", SpecialAttackEvent.Attacks.AUSZAHLUNG);
		spezAttacks.put("hoher Ton", SpecialAttackEvent.Attacks.HOHERTON);

		spezAttacks.put("Kugelhagel", SpecialAttackEvent.Attacks.KUGELHAGEL);
		spezAttacks.put("Haddle Ruf", SpecialAttackEvent.Attacks.HADDLERUF);
		spezAttacks.put("Mega Bombe", SpecialAttackEvent.Attacks.MEGABOMBE);

		spezAttacks.put("Heilen", SpecialAttackEvent.Attacks.HEILEN);
		spezAttacks.put("Unsichtbar machen",
				SpecialAttackEvent.Attacks.UNSICHTBAR);
		spezAttacks
				.put("Rundumschlag", SpecialAttackEvent.Attacks.RUNDUMSCHLAG);

	}

	public ArrayList<String> getChat() {

		ArrayList<String> tempChat = this.chat.getChat();

		return tempChat;
	}

	public Tile getTile(int i, int j) {

		Tile tempTile = map[i][j];

		return tempTile;

	}

	public ClientAdmin getClientAdmin() {

		ClientAdmin tempAdmin = this.clientAdmin;

		return tempAdmin;
	}

	public void setClientAdmin(ClientAdmin clientAdmin) {

		this.clientAdmin = clientAdmin;

	}

	public Tile[][] getMap() {

		Tile[][] tempMap = map;

		return tempMap;
	}

	// Liest die Map aus und erzeugt alle Objekte in der Hashmap
	public void addEntity(Tile[][] map) {
		for (int i = 0; i < 140; i++) {
			for (int j = 0; j < 140; j++) {
				if (map[i][j].getobject() instanceof InteraktiveEntity) {
					InteraktiveEntity entity = (InteraktiveEntity) map[i][j]
							.getobject();

					interActiveEntity.put(entity.getID(), entity);
				}
			}
		}
	}

	/*
	 * @autor Felix, sven, steven
	 */
	@Override
	public void onEvent(Event evt) {
		// System.out.println(evt.getType());
		switch (evt.getType()) {

		case WORLD_CREATE_EVENT: {

			this.map = ((WorldCreateEvent) evt).getWorld();
			System.out.println("!!!!!!!!!!!!");

			break;
		}

		case CLIENT_ADMIN_UPDATE_EVENT: {

			this.clientAdmin = ((ClientAdminUpdateEvent) evt).getAdmin();
			System.out.println(clientAdmin == null);

			break;
		}

		case BUY_EVENT: {
			if (clientAdmin.getClientHero().getMoney() >= ((BuyEvent) evt)
					.getItem().getCost()) {
				Communication.newServerMessage(evt);
			} else {
				EventManager.callEvent(new InfoEvent(clientAdmin.getClientNr(),
						"Du bist zu arm!"));
			}
			break;

		}

		case CHAT_EVENT: {
			// Server.newMessage(new Message(evt));
			break;
		}
		case CONSUME_POTION_UPDATE_EVENT: {
			ConsumePotionUpdateEvent event = (ConsumePotionUpdateEvent) evt;

			Hero hero = (Hero) interActiveEntity.get(event.getID());

			if (event.IS_ELIXIR()) {
				hero.change_Akt_Life(event.getINCREASE());
				for (int i = 0; i < 6; i++) {
					if (hero.getItems()[i] instanceof Elixir) {
						((Elixir) hero.getItems()[i])
								.setQuantity(((Elixir) hero.getItems()[i])
										.getQuantity() - 1);
					}
				}
			} else {
				hero.change_Akt_mana(event.getINCREASE());
				for (int i = 0; i < 6; i++) {
					if (hero.getItems()[i] instanceof Manapotion) {
						((Manapotion) hero.getItems()[i])
								.setQuantity(((Manapotion) hero.getItems()[i])
										.getQuantity() - 1);
					}
				}
			}

			break;
		}

		case MANA_AND_LIFE_UPDATE_EVENT: {
			Mana_and_Life_UpdateEvent event = (Mana_and_Life_UpdateEvent) evt;
			for (UUID id : event.getHeroes()) {

				Hero hero = ((Hero) interActiveEntity.get(id));

				hero.change_Akt_Life(event.getLIFE_INCREASE());
				hero.change_Akt_mana(event.getMANA_INCREASE());
			}
			break;

		}
		case PURE_LIFE_UPDATE_EVENT: {
			PureLifeUpdateEvent event = (PureLifeUpdateEvent) evt;
			Hero hero=(Hero)interActiveEntity.get(event.getHERO());
			for (UUID id : event.getHeroes()) {

				InteraktiveEntity erg = interActiveEntity.get(id);

				erg.change_Akt_Life(event.getLIFE_INCREASE());			
				
				//Reaktion auf moeglichen Tod des Gegeners
				if(erg.get_Akt_Life()==0)
					{erg.kill();
					int x = erg.getPosition()[0];
					int y = erg.getPosition()[1];
					map[x][y].setobject(new SpaceHolder(x, y));
					boolean levelUp = hero.increase_Akt_XP(erg.getGIVE_XP());
		
					// Wenn ein Levelup erfolgt ist...
					if (levelUp) {
						// ...dann erhoehe die Werte und setze Leben und
						// Mana auf maximale Punkte
						// Schicke anschliessen die entsprechenden Events an
						// die Clients
						int[] newValues = { 10, 5, 5, 0, 0, 5, 150, 150 };
						for (int i = 0; i < 8; i++) {
							hero.increaseValue(i, newValues[i]);
						}
						hero.change_Akt_Life(hero.getvalue(6));
						hero.change_Akt_mana(hero.getvalue(7));
						}
					}

			}
			break;
		}
		case END_GAME_UPDATE_EVENT: {
			EndGameUpdateEvent event = (EndGameUpdateEvent) evt;
			Team winner =event.getWON_TEAM();
			gamerunning = false;
			if( getClientAdmin().getClientHero().getTeam().equals(winner))
				win=true;
			else 
				if(winner!=null)
					win=false;
			break;
		}
		case MONEY_UPDATE_EVENT: {
			MoneyUpdateEvent mEvt = (MoneyUpdateEvent) evt;
			clientAdmin.getClientHero().changeMoney(mEvt.getINCREASE());
			System.out.println("Money");
			break;
		}

		case MOVE_EVENT: {
			MoveEvent mEvt = (MoveEvent) evt;

			if (!map[mEvt.getPosition()[0]][mEvt.getPosition()[1]]
					.isCurrentlyBlocked()) {
				Communication.newServerMessage(mEvt);
			}

			break;
		}
		case CASH_EVENT:
			break;
		case INFO_EVENT:
			break;
		case SPECIAL_ATTACK_EVENT: {
			System.out.println("SpezialAtackke soll ausgefuehrt werden");
			Communication.newServerMessage(evt);

			break;
		}
		case SPECIAL_ATTACK_UPDATE_EVENT: {
			SpecialAttackUpdateEvent event = (SpecialAttackUpdateEvent) evt;

			Hero hero = (Hero) interActiveEntity.get(event.getID());

			hero.change_Akt_mana(-event.getMANA_COST());
			hero.setAbilitiesaktivated(true, event.getATTACKINDEX());
			break;
		}
		case MOVE_UPDATE_EVENT: {
			MoveUpdateEvent event = (MoveUpdateEvent) evt;

			Figure figure = (Figure) interActiveEntity.get(event.getID());

			map[figure.getPosition()[0]][figure.getPosition()[1]]
					.setobject(new SpaceHolder(figure.getPosition()[0], figure
							.getPosition()[1]));

			figure.setPosition(event.getNEWPOSITION()[0],
					event.getNEWPOSITION()[1]);
			figure.setdirection(event.getNEWDIRECTION());
			map[event.getNEWPOSITION()[0]][event.getNEWPOSITION()[1]]
					.setobject(figure);

			break;
		}
		case HIT_UPDATE_EVENT: {
			HitUpdateEvent event = (HitUpdateEvent) evt;

			InteraktiveEntity attacker = (InteraktiveEntity) interActiveEntity
					.get(event.getFig_ID());
			InteraktiveEntity enemy = interActiveEntity.get(event.getEne_ID());

			if (attacker == null) {
				System.out
						.println("Attacker ist Null; Typ: " + event.getNAME());
			}
			if (enemy == null) {
				System.out.println("Enemy ist Null");
			}
			int[] enemyPos = enemy.getPosition();
			if (attacker instanceof Figure) {
				Figure figure = ((Figure) attacker);
				figure.setAttackdirection(event.getATTACKDIRECTION());
				figure.setattack(true);
				figure.settarget(enemyPos);
			} else {
				Tower tower = (Tower) attacker;
				tower.setattack(true);
				tower.settarget(enemy.getPosition());
			}

			enemy.change_Akt_Life(event.getDECREASE());

			if (enemy.get_Akt_Life() == 0) {// /hier gemacht daniel mist lalala

				map[enemyPos[0]][enemyPos[1]].setobject(new SpaceHolder(
						enemyPos[0], enemyPos[1]));
				enemy.kill();
				if (attacker instanceof Hero) {					
					// Erhoehe die Erfahrungspunkte des Helden
					Hero hero = ((Hero) attacker);
					if(enemy instanceof Vasall||enemy instanceof Monster)
						hero.setLasthits(1);
					if(enemy instanceof Hero)
						hero.setKills(1);
					boolean levelUp = hero.increase_Akt_XP(enemy.getGIVE_XP());

					// Wenn ein Levelup erfolgt ist...
					if (levelUp) {
						System.out.println("LevelUp");
						// ...dann erhoehe die Werte und setze Leben und Mana
						// auf maximale Punkte
						// Schicke anschliessen die entsprechenden Events an die
						// Clients
						int[] newValues = { 10, 5, 5, 0, 0, 5, 150, 150 };
						for (int i = 0; i < 8; i++) {
							hero.increaseValue(i, newValues[i]);
						}
						hero.change_Akt_Life(hero.getvalue(6));
						hero.change_Akt_mana(hero.getvalue(7));
					}

				}
				if (!(enemy instanceof Hero)) {
					// interActiveEntity.remove(enemy.getID());
				}else{
					((Hero) enemy).setDeaths(1);
				}
			}

			break;
		}
		case POTION_EVENT: {
			PotionEvent potevt = (PotionEvent) (evt);
			Communication.newServerMessage(potevt);
			break;
		}

		case RESPAWN_UPDATE_EVENT: {
			RespawnUpdateEvent respawnevt = (RespawnUpdateEvent) evt;
			int[] start = respawnevt.getSTARTPOSITION();

			Hero hero = (Hero) interActiveEntity.get(respawnevt.getID());

			hero.reanimate();
			hero.change_Akt_Life(hero.getvalue(values.LIFE.ordinal()));
			hero.setPosition(start[0], start[1]);
			map[start[0]][start[1]].setobject(hero);
			break;
		}
		case ITEM_UPDATE_EVENT: {
			ItemUpdateEvent event = (ItemUpdateEvent) evt;

			Hero hero = (Hero) interActiveEntity.get(event.getID());
			System.out.println("es wird in der world versucht zu setzen");
			hero.addItem(event.getITEM());
			EventManager.callEvent(new InfoEvent(
					getClientAdmin().getClientNr(), "Item gekauft"));

			break;
		}
		case VALUES_UPDATE_EVENT: {
			ValuesUpdateEvent event = (ValuesUpdateEvent) evt;

			InteraktiveEntity hero = interActiveEntity.get(event.getID());

			for (int i = 0; i < 8; i++) {
				hero.increaseValue(i, event.getINCREASE_VALUES()[i]);
			}

			break;
		}
		case CREATE_UPDATE_EVENT: {
			CreateUpdateEvent event = (CreateUpdateEvent) evt;
			map[event.getFigure().getPosition()[0]][event.getFigure()
					.getPosition()[1]].setobject(event.getFigure());

			interActiveEntity.put(event.getFigure().getID(), event.getFigure());

			break;
		}

		default:
			break;

		}

	}

	public boolean getgamerunning() {
		return gamerunning;
	}
	public boolean getwinning() {
		return win;
	}
}
