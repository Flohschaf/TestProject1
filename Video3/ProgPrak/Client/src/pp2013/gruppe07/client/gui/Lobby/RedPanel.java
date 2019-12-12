package pp2013.gruppe07.client.gui.Lobby;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.EventListener;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.Event.Type;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.LobbyTeamListEvent;

/**
 * Panel das alle Spieler im roten Team anzeigt.
 * 
 * @author Felix,Flo
 * 
 */
public class RedPanel extends JPanel implements EventListener {

	private int width;
	private int heigth;
	ArrayList<PlayerPanel> playerPanels;

	public RedPanel() {
		EventManager.registerListener(this, Type.NEW_PLAYER_EVENT);
		EventManager.registerListener(this, Type.LOBBY_TEAM_LIST_EVENT);
		playerPanels = new ArrayList<PlayerPanel>();

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		width = gd.getDisplayMode().getWidth() / 3;
		heigth = gd.getDisplayMode().getHeight() / 8;

		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		JPanel playersRed = new JPanel();

		playersRed.setPreferredSize(new Dimension(width, heigth));
		playersRed.setLayout(new GridLayout(1, 4));

		playersRed.setBackground(Color.RED);

		for (int i = 0; i < 4; i++) {
			PlayerPanel pnl = new PlayerPanel();
			playerPanels.add(pnl);
			playersRed.add(pnl);

		}

		this.add(playersRed);
	}

	@Override
	public void onEvent(Event evt) {
		switch (evt.getType()) {
		case LOBBY_TEAM_LIST_EVENT: {
			LobbyTeamListEvent event = (LobbyTeamListEvent) evt;
			LinkedList<Hero.Heronames> heroes = event.getRed();
			int i = 0;
			for (Hero.Heronames name : heroes) {
				playerPanels.get(i).setHero(name, name.toString());
				i++;
				System.out.println(name.toString());
			}
			this.repaint();
			break;
		}

		}
	}
}
