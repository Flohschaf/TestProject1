package pp2013.gruppe07.client.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.Lobby.LobbyPanel;
import pp2013.gruppe07.client.gui.LogIn.LogInBackgroundPanel;
import pp2013.gruppe07.client.gui.daniel.LoLFrame;
import pp2013.gruppe07.shared.Tile;
import pp2013.gruppe07.shared.eventManager.EventListener;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.Event.Type;
import pp2013.gruppe07.shared.eventManager.event.InternalCLient.InternalStartGameEvent;

/**
 * Panel auf dem alle anderen gezeichnet werden. Ueber das CardLayout kann
 * zwischen verschiedenen Panels gewechselt werden.
 * 
 * @author Felix
 * 
 */
public class GlobalBackGround extends JPanel implements EventListener {

	LogInBackgroundPanel logInBackgroundPanel;
	LobbyPanel lobbyPanel;
	public LoLFrame lolFrame;

	World world;
	Tile[][] map;
	JPanel screens;
	Frame frame;
	Dimension dimension;

	public GlobalBackGround(Frame frame) {

		EventManager.registerListener(this, Event.Type.LOCK_IN_EVENT);
		EventManager.registerListener(this, Event.Type.WORLD_CREATE_EVENT);
		EventManager.registerListener(this, Type.INTERNAL_START_GAME_EVENT);

		this.setLayout(new BorderLayout());
		this.frame = frame;
		this.setFocusable(true);
		
		this.setBackground(Color.BLACK);

		logInBackgroundPanel = new LogInBackgroundPanel(frame);

		screens = new JPanel(new CardLayout());
		screens.setFocusable(true);
		int screenWidth = 800;
		int screenHeight = 600;
		
		
		//Je nach OS wird das Bild angepasst.
		if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
			GraphicsDevice gd = GraphicsEnvironment
					.getLocalGraphicsEnvironment().getDefaultScreenDevice();

			screenWidth = gd.getDisplayMode().getWidth();
			screenHeight = gd.getDisplayMode().getHeight();

		}

		if (System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0) {

			screenWidth = 1280;
			screenHeight = 1024;
		}
		dimension = new Dimension(screenWidth, screenHeight);

		screens.setPreferredSize(new Dimension(screenWidth, screenHeight));

		try {
			screens.add(logInBackgroundPanel);
			
		} catch (Exception e) {
		}
		this.add(screens);
	}

	public LogInBackgroundPanel getLogInBackground() {
		return this.logInBackgroundPanel;
	}

	public void setLobby() {
		lobbyPanel = new LobbyPanel(this.frame);
		screens.add(lobbyPanel);
	}

	public LobbyPanel getLobby() {
		return this.lobbyPanel;
	}

	public void setLoLFrame() {
		lolFrame = new LoLFrame(frame, world);
		screens.add(lolFrame);

	}

	public LoLFrame getLoLFrame() {
		return this.lolFrame;
	}

	public Dimension getSize() {
		return dimension;
	}

	public JPanel getScreens() {
		return this.screens;
	}

	@Override
	public void onEvent(Event evt) {

		
		
		switch (evt.getType()){
		case LOCK_IN_EVENT:{
			setLobby();
			CardLayout cl = (CardLayout) screens.getLayout();
			cl.next(frame.getGlobalBackground().getLobby().getParent());
			break;
		}
		
		case INTERNAL_START_GAME_EVENT:{
			world = new World(((InternalStartGameEvent) evt).getMap());
			world.setClientAdmin(((InternalStartGameEvent) evt).getAdmin());

			
			setLoLFrame();

			CardLayout cl = (CardLayout) screens.getLayout();
			cl.next(frame.getGlobalBackground().getLoLFrame().getParent());
			frame.repaint();
			EventManager.unregisterListener(this,
					Type.CLIENT_ADMIN_UPDATE_EVENT);
			break;

		}
		}
		
	}

}
