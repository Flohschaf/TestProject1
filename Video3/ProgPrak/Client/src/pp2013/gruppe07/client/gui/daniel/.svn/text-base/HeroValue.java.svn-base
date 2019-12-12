package pp2013.gruppe07.client.gui.daniel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.World;
import pp2013.gruppe07.shared.entity.Hero;

/**
 * 
 * @author Daniel Diese Klasse erstellt die Anzeige der Werte des Heldens
 */

public class HeroValue extends JPanel {

	private World world;

	public HeroValue(World world) {
		super.setSize(40, 40);
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
		this.world = world;

	}

	/**
	 * 
	 * @author Daniel Diese Methode malt das Anzeige Bild der Werte und setzt
	 *         diese dahinter
	 */
	public void paint(Graphics g) {

		Image image;

		image = Toolkit.getDefaultToolkit().getImage("Images/Values.gif");

		g.drawImage(image, 5, 2, this);

		g.setColor(Color.black);
		g.drawString(
				": "
						+ ((Hero) world.getEntities().get(
								world.getClientAdmin().getClientHero().getID()))
								.getvalue()[0], 25, 14);
		g.drawString(
				": "
						+ ((Hero) world.getEntities().get(
								world.getClientAdmin().getClientHero().getID()))
								.getvalue()[1], 25, 30);
		g.drawString(
				": "
						+ ((Hero) world.getEntities().get(
								world.getClientAdmin().getClientHero().getID()))
								.getvalue()[2], 25, 46);
		g.drawString(
				": "
						+ ((Hero) world.getEntities().get(
								world.getClientAdmin().getClientHero().getID()))
								.getvalue()[3], 25, 62);
		g.drawString(
				": "
						+ ((Hero) world.getEntities().get(
								world.getClientAdmin().getClientHero().getID()))
								.getvalue()[4], 25, 78);
		g.drawString(
				": "
						+ ((Hero) world.getEntities().get(
								world.getClientAdmin().getClientHero().getID()))
								.getvalue()[5], 25, 94);

	}

}
