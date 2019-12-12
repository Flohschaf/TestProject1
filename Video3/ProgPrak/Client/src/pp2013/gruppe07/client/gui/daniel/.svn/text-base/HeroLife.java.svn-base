package pp2013.gruppe07.client.gui.daniel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.World;
import pp2013.gruppe07.shared.entity.Hero;

/**
 * 
 * @author Daniel Diese Klasse erstellt die Lebens und Mana Leiste des Helden
 */

public class HeroLife extends JPanel {
	private int Ep;
	private int Life;
	private int Mana;
	private int MaxLife;
	private int MaxMana;

	private World world;

	public HeroLife(World world) {
		super.setSize(40, 40);
		this.setBackground(Color.GRAY);
		this.setVisible(true);
		this.world = world;
		Ep = world.getClientAdmin().getClientHero().getAkt_XP();
		MaxLife = world.getClientAdmin().getClientHero().getvalue()[6];
		Life = world.getClientAdmin().getClientHero().get_Akt_Life();
		MaxMana = world.getClientAdmin().getClientHero().getvalue()[7];
		Mana = world.getClientAdmin().getClientHero().getAkt_mana();

	}

	/**
	 * 
	 * @author Daniel Diese Methode malt das Leben, das Mana und die Erfahrung
	 *         des Helden
	 */
	public void paint(Graphics g) {

		g.setColor(Color.black);
		g.drawString("Leben:", 1, 10);
		g.setColor(Color.black);
		g.fillRect(0, 14, 101, 12);
		g.setColor(Color.green);
		if (((Hero) world.getEntities().get(
				world.getClientAdmin().getClientHero().getID())).get_Akt_Life() >= 0)
			g.fillRect(
					1,
					15,
					(((Hero) world.getEntities().get(
							world.getClientAdmin().getClientHero().getID()))
							.get_Akt_Life() * 100 / ((Hero) world
							.getEntities()
							.get(world.getClientAdmin().getClientHero().getID()))
							.getvalue(6)), 10);
		else
			g.fillRect(
					1,
					15,
					(((Hero) world.getEntities().get(
							world.getClientAdmin().getClientHero().getID()))
							.get_Akt_Life() * 100 / ((Hero) world
							.getEntities()
							.get(world.getClientAdmin().getClientHero().getID()))
							.getvalue(6)), 10);
		g.setColor(Color.DARK_GRAY);
		if (((Hero) world.getEntities().get(
				world.getClientAdmin().getClientHero().getID())).get_Akt_Life() >= 0)
			g.drawString(
					((Hero) world.getEntities().get(
							world.getClientAdmin().getClientHero().getID()))
							.get_Akt_Life()
							+ "/"
							+ ((Hero) world.getEntities().get(
									world.getClientAdmin().getClientHero()
											.getID())).getvalue(6), 10, 25);
		else
			g.drawString(
					0
							+ "/"
							+ ((Hero) world.getEntities().get(
									world.getClientAdmin().getClientHero()
											.getID())).getvalue(6), 10, 25);

		g.setColor(Color.black);
		g.drawString("Mana:", 1, 40);
		g.setColor(Color.black);
		g.fillRect(0, 44, 101, 12);
		g.setColor(Color.blue);
		if (((Hero) world.getEntities().get(
				world.getClientAdmin().getClientHero().getID())).getAkt_mana() >= 0)
			g.fillRect(
					1,
					45,
					(((Hero) world.getEntities().get(
							world.getClientAdmin().getClientHero().getID()))
							.getAkt_mana() * 100 / ((Hero) world
							.getEntities()
							.get(world.getClientAdmin().getClientHero().getID()))
							.getvalue(7)), 10);
		else
			g.fillRect(
					1,
					45,
					(0 * 100 / ((Hero) world.getEntities().get(
							world.getClientAdmin().getClientHero().getID()))
							.getvalue(5)), 10);
		g.setColor(Color.DARK_GRAY);
		if (((Hero) world.getEntities().get(
				world.getClientAdmin().getClientHero().getID())).getAkt_mana() >= 0)
			g.drawString(
					((Hero) world.getEntities().get(
							world.getClientAdmin().getClientHero().getID()))
							.getAkt_mana()
							+ "/"
							+ ((Hero) world.getEntities().get(
									world.getClientAdmin().getClientHero()
											.getID())).getvalue(7), 10, 55);
		else
			g.drawString(
					0
							+ "/"
							+ ((Hero) world.getEntities().get(
									world.getClientAdmin().getClientHero()
											.getID())).getvalue(7), 10, 55);

		g.setColor(Color.black);
		g.drawString("Erfahrung:", 1, 70);
		g.setColor(Color.black);
		g.fillRect(0, 74, 101, 12);
		g.setColor(Color.yellow);
		g.fillRect(
				1,
				75,
				100*((Hero) world.getEntities().get(
						world.getClientAdmin().getClientHero().getID()))
						.getAkt_XP() / ((Hero) world.getEntities().get(
						world.getClientAdmin().getClientHero().getID()))
						.getNext_Level_XP() , 10);
		g.setColor(Color.DARK_GRAY);
		g.drawString(
				((Hero) world.getEntities().get(
						world.getClientAdmin().getClientHero().getID()))
						.getAkt_XP()
						+ "/"
						+ ((Hero) world.getEntities().get(
								world.getClientAdmin().getClientHero().getID()))
								.getNext_Level_XP(), 10, 85);

	}

}
