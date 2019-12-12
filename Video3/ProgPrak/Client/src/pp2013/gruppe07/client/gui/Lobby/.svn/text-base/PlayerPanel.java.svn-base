package pp2013.gruppe07.client.gui.Lobby;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import pp2013.gruppe07.client.gui.Images;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.Hero.Heronames;

/**
 * Zeigt ein Bild des Helden.
 * 
 * @author Felix,Flo
 * 
 */
public class PlayerPanel extends JPanel {

	private final int WIDTH = 119;
	private final int HEIGTH = 139;

	Hero.Heronames hero;
	String player;
	int[] position = { 0, 0 };

	public PlayerPanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGTH));

		this.setBorder(new EtchedBorder());

		setHero(Heronames.DANGER_DAN, "Danger Dan");

	}

	public void setHero(Hero.Heronames hero, String player) {
		this.hero = hero;
		this.player = player;
		this.repaint();
	}

	/**
	 * Abfrage ob der Held schon gesetzt wurde.
	 * 
	 * @return boolean
	 */
	public boolean hasHero() {
		if (hero == null) {
			return false;
		}

		else {
			return true;
		}
	}

	public void paint(Graphics g) {

		if (hero != null) {

			g.drawImage(Images.heroes.get(hero)[1], position[0], position[1],
					this);
			g.setColor(Color.RED);
			g.drawString(player, 0, this.getHeight());
		}
	}

}
