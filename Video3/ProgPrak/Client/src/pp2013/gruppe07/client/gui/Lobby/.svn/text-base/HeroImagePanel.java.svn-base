package pp2013.gruppe07.client.gui.Lobby;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import pp2013.gruppe07.client.gui.Images;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.Hero.Heronames;
import pp2013.gruppe07.shared.eventManager.EventListener;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.InternalCLient.InternalSelectHeroEvent;

/**
 * Panel auf dem Heldenbilder angezeigt werden koennen. Zum Beispiel in der
 * Lobby fuer die Anzeige des aktuell gewaehlten Helden.
 * 
 * @author Felix,Flo
 * 
 */
public class HeroImagePanel extends JPanel implements EventListener {

	private final int WIDTH = 119;
	private final int HEIGTH = 139;

	Hero.Heronames hero;

	int[] position = { 0, 0 };

	public HeroImagePanel() {

		EventManager.registerListener(this,
				Event.Type.INTERNAL_SELECT_HERO_EVENT);
		this.setPreferredSize(new Dimension(WIDTH, HEIGTH));

		this.setBorder(new EtchedBorder());
		this.hero = Heronames.CAPTAIN_OBVIOUS;

	}

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
			//
			g.drawImage(Images.heroes.get(hero)[1], position[0], position[1],
					this);
			g.setColor(Color.RED);
			g.drawString(hero.toString(), 0, this.getHeight());
		}
	}

	@Override
	public void onEvent(Event evt) {
		this.hero = ((InternalSelectHeroEvent) evt).getHero();
		this.repaint();

	}

}
