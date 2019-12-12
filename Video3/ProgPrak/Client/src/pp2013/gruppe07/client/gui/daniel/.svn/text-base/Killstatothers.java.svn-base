package pp2013.gruppe07.client.gui.daniel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import pp2013.gruppe07.shared.entity.Entity;
import pp2013.gruppe07.shared.entity.Hero;

/**
 * 
 * @author Daniel Diese Klasse erstellt die Anzeige der Statisitken der anderen
 *         spieler
 */

public class Killstatothers extends JPanel {
	private final Entity HERO;
	private int Kills;
	private int Lasthits;
	private int Deaths;
	private int Life;
	private int Mana;
	private int MaxLife;
	private int MaxMana;

	public Killstatothers(Hero hero) {
		super.setSize(120, 400);
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);

		Kills = hero.getKills();
		Lasthits = hero.getLasthits();
		Deaths = hero.getDeaths();
		HERO = hero;

		MaxLife = ((Hero) hero).getvalue()[6];
		Life = ((Hero) hero).get_Akt_Life();
		MaxMana = ((Hero) hero).getvalue()[7];
		Mana = ((Hero) hero).getAkt_mana();

	}

	/**
	 * 
	 * @author Daniel Diese Methode schreibt die Anzahl der Kills etc. ins das
	 *         gegebene Panel
	 */
	public void paint(Graphics g) {

		Font Letter = new Font("Arial", Font.BOLD, 14);

		g.setFont(Letter);
		g.setColor(Color.black);
		g.drawString("Kills: " + Kills, 10, 70);

		g.drawString("Lasthits: " + Lasthits, 10, 90);
		g.drawString("Deaths: " + Deaths, 10, 110);
		g.setColor(Color.black);
		g.drawString("Leben:", 1, 10);
		g.setColor(Color.black);
		g.fillRect(0, 14, 102, 12);
		g.setColor(Color.green);
		if (((Hero) HERO).get_Akt_Life() >= 0)
			g.fillRect(1, 15, (((Hero) HERO).get_Akt_Life() * 100 / MaxLife),
					10);
		else
			g.fillRect(1, 15, (((Hero) HERO).get_Akt_Life() * 100 / MaxLife),
					10);
		g.setColor(Color.DARK_GRAY);
		if (((Hero) HERO).get_Akt_Life() >= 0)
			g.drawString(((Hero) HERO).get_Akt_Life() + "/" + MaxLife, 10, 25);
		else
			g.drawString(0 + "/" + MaxLife, 10, 25);

		g.setColor(Color.black);
		g.drawString("Mana:", 1, 40);
		g.setColor(Color.black);
		g.fillRect(0, 44, 102, 12);
		g.setColor(Color.blue);
		if (((Hero) HERO).getAkt_mana() >= 0)
			g.fillRect(1, 45, (((Hero) HERO).getAkt_mana() * 100 / MaxMana), 10);
		else
			g.fillRect(1, 45, (0 * 100 / MaxMana), 10);
		g.setColor(Color.DARK_GRAY);
		if (((Hero) HERO).getAkt_mana() >= 0)
			g.drawString(((Hero) HERO).getAkt_mana() + "/" + MaxMana, 10, 55);
		else
			g.drawString(0 + "/" + MaxMana, 10, 55);

	}

}
