package pp2013.gruppe07.client.gui.daniel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.Images;
import pp2013.gruppe07.client.gui.World;
import pp2013.gruppe07.shared.entity.Hero;

/**
 * 
 * @author Daniel Diese Klasse erstellt das grosse Bild des Helden
 */
public class HeroImage extends JPanel {
	private Hero Hero;
	private int Level;
	private World world;

	public HeroImage(Hero HERO) {
		this.Hero = HERO;

		Level = 1;
		this.setVisible(HERO.getVisibility());
	}

	/**
	 * 
	 * @author Daniel Diese Methode setzt die World, da man sie nur braucht wenn
	 *         das Bild des eigenen Helden in der Ingameansicht gemalt wird
	 */
	public void setworld(World world) {
		this.world = world;
	}

	/**
	 * 
	 * @author Daniel Diese Methode malt das Herobild inklusive der Levelanzeige
	 */
	public void paint(Graphics g) {
		int[] position = { 1, 1 };

		g.drawImage(Images.heroes.get(Hero.getType())[1], position[0],
				position[1], this);

		g.setColor(Color.black);
		g.fillRect(0, 74, 52, 14);
		g.setColor(Color.gray);
		g.fillRect(1, 75, 50, 12);
		g.setColor(Color.white);
		if (world != null)
			g.drawString(
					" Level "
							+ ((Hero) world.getEntities().get(
									world.getClientAdmin().getClientHero()
											.getID())).getLevel(), 10, 85);
		else
			g.drawString(" Level " + Hero.getLevel(), 10, 85);

	}
}
