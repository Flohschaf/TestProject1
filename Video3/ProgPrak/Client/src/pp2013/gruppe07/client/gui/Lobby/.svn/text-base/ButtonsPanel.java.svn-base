package pp2013.gruppe07.client.gui.Lobby;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pp2013.gruppe07.client.comm.Communication;
import pp2013.gruppe07.client.gui.Frame;
import pp2013.gruppe07.client.gui.daniel.LoLFrame;
import pp2013.gruppe07.shared.ClientAdmin;
import pp2013.gruppe07.shared.Tile;
import pp2013.gruppe07.shared.entity.Hero.Heronames;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.eventManager.EventListener;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.ChooseHeroEvent;
import pp2013.gruppe07.shared.eventManager.event.InternalCLient.InternalSelectHeroEvent;
import pp2013.gruppe07.shared.eventManager.event.InternalCLient.InternalSelectTeamEvent;
import pp2013.gruppe07.shared.eventManager.event.InternalCLient.InternalStartGameEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ClientAdminUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.WorldCreateEvent;

/**
 * Zeigt den StartGame Knopf in der Lobby an und regelt die reaktion darauf.
 * 
 * @author Felix,Flo
 * 
 */
public class ButtonsPanel extends JPanel implements EventListener {

	private final int WIDTH = 100;
	private final int HEIGTH = 300;
	public static LoLFrame lolFrame;
	Frame frame;

	private boolean playerOk;
	private boolean mapOk;
	private boolean started;

	private Tile[][] map;
	private ClientAdmin clientAdmin;
	private Heronames hero;
	private Team team;

	public ButtonsPanel(final Frame frame) {

		hero = Heronames.CAPTAIN_OBVIOUS;
		team = Team.BLUE;
		this.frame = frame;
		this.setPreferredSize(new Dimension(HEIGTH, WIDTH));
		this.setLayout(new GridBagLayout());
		this.setLocation(500, 800);
		this.setBackground(Color.GRAY);

		playerOk = false;
		mapOk = false;
		started = false;
		EventManager.registerListener(this,
				Event.Type.INTERNAL_SELECT_HERO_EVENT);
		EventManager.registerListener(this,
				Event.Type.CLIENT_ADMIN_UPDATE_EVENT);
		EventManager.registerListener(this, Event.Type.WORLD_CREATE_EVENT);
		EventManager.registerListener(this,
				Event.Type.INTERNAL_SELECT_TEAM_EVENT);

		final JButton startGame = new JButton("Start Game");
		this.setOpaque(false);

		startGame.setBackground(Color.RED);
		startGame.setPreferredSize(new Dimension(100, 100));

		/**
		 * Teilt dem StartGame Button einen AcrtionListener zu. Dieser
		 * Informiert den Server sobald der Client das Spiel gestartet hat.
		 */
		ActionListener startGameAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Communication.newServerMessage(new ChooseHeroEvent(frame
						.getClientID(), hero, team));
				startGame.setEnabled(false);

			}

		};

		startGame.addActionListener(startGameAct);

		this.add(startGame);

	}

	@Override
	public void onEvent(Event evt) {

		switch (evt.getType()) {

		// Startet das Spiel
		case CLIENT_ADMIN_UPDATE_EVENT: {
			this.clientAdmin = ((ClientAdminUpdateEvent) evt).getAdmin();
			playerOk = true;

			System.out.println(clientAdmin + " " + map + " " + started);

			if (clientAdmin != null && map != null && !started) {

				newGame();

			}
			break;
		}
		// Der Spieler hat einen anderen Helden gewaehlt
		case INTERNAL_SELECT_HERO_EVENT: {
			this.hero = ((InternalSelectHeroEvent) evt).getHero();
			break;
		}
		// Der Spieler hat ein anderes Team gewaehlt
		case INTERNAL_SELECT_TEAM_EVENT: {

			InternalSelectTeamEvent event = (InternalSelectTeamEvent) evt;

			this.team = event.getTeam();
			break;
		}

		// Erzeugt eine neue Welt
		case WORLD_CREATE_EVENT: {
			this.map = ((WorldCreateEvent) evt).getWorld();
			mapOk = true;
			break;
		}

		}

	}

	/**
	 * Startet das Spiel un meldet die EventListener ab.
	 */
	public void newGame() {

		started = true;

		EventManager.unregisterListener(this,
				Event.Type.CLIENT_ADMIN_UPDATE_EVENT);
		EventManager.unregisterListener(this, Event.Type.WORLD_CREATE_EVENT);
		EventManager.unregisterListener(this,
				Event.Type.INTERNAL_SELECT_HERO_EVENT);
		EventManager.unregisterListener(this,
				Event.Type.INTERNAL_SELECT_TEAM_EVENT);

		EventManager.callEvent(new InternalStartGameEvent(frame.getClientID(),
				map, clientAdmin));

	}

}
