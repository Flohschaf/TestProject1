package pp2013.gruppe07.client.gui.Lobby;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.Frame;

/**
 * Dieses Panel beherbergt die gesamte Lobby
 * 
 * @author Felix,Flo
 * 
 */
public class LobbyPanel extends JPanel {

	Frame frame;
	int screenWidth = 800;
	int screenHeight = 600;
	Image background;

	public LobbyPanel(Frame frame) {
		this.frame = frame;

		background = Toolkit.getDefaultToolkit().getImage("Images/Lobby.png");

		// Darstellung ist anhaengig vom Betriebssystem.
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

		if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
			background = Toolkit.getDefaultToolkit().getImage(
					"Images/Lobby.png");
		}

		if (System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0) {

			background = Toolkit.getDefaultToolkit().getImage(
					"Images/LobbyLinux.png");
		}

		// Regelt den grundlegenden Aufbau des Panels
		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(screenWidth, screenHeight / 2));
		north.setLayout(new GridLayout(1, 2));
		north.add(new RedPanel());
		north.add(new BluePanel());
		north.setOpaque(false);

		this.add(north, BorderLayout.NORTH);

		JPanel south = new JPanel();

		south.setPreferredSize(new Dimension(screenWidth, screenHeight / 2));

		south.setLayout(new GridLayout(1, 3));
		south.add(new HeroSelectionPanel(frame));
		south.add(new ChatPanel(frame));
		south.add(new ButtonsPanel(frame));
		south.setOpaque(false);
		this.add(south, BorderLayout.SOUTH);

	}

	@Override
	protected void paintComponent(Graphics g) {

		g.drawImage(background, 0, 0, this);
	}

}
