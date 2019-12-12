package pp2013.gruppe07.client.gui.daniel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import pp2013.gruppe07.shared.entity.Hero;

/**
 * 
 * @author Daniel Diese Klasse erstellt die Anzeige der Statistik wie
 *         kills,etc..
 */

public class KillStatistic extends JPanel {

	private int Kills;
	private int Lasthits;
	private int Deaths;
	private Hero Hero;

	private int Life;
	private int Mana;
	private int MaxLife;
	private int MaxMana;

	public KillStatistic(Hero hero) {
		super.setSize(120, 400);
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);

		Kills = hero.getKills();
		Lasthits = hero.getLasthits();
		Deaths = hero.getDeaths();
		this.Hero = hero;
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

		g.setColor(Color.black);
		g.drawString("Leben:", 1, 10);
		g.setColor(Color.black);
		g.fillRect(0, 14, 102, 12);
		g.setColor(Color.green);
		if (Hero.get_Akt_Life() >= 0)
			g.fillRect(1, 15, (MaxLife * 100 / MaxLife), 10);
		else
			g.fillRect(1, 15, (((Hero) Hero).get_Akt_Life() * 100 / MaxLife),
					10);
		g.setColor(Color.DARK_GRAY);

		g.drawString(MaxLife + "/" + MaxLife, 10, 25);

		g.setColor(Color.black);
		g.drawString("Mana:", 150, 10);
		g.setColor(Color.black);
		g.fillRect(150, 14, 102, 12);
		g.setColor(Color.blue);
		if (((Hero) Hero).getAkt_mana() >= 0)
			g.fillRect(151, 15, (((Hero) Hero).getAkt_mana() * 100 / MaxMana),
					10);
		else
			g.fillRect(151, 15, (0 * 100 / MaxMana), 10);
		g.setColor(Color.DARK_GRAY);
		if (((Hero) Hero).getAkt_mana() >= 0)
			g.drawString(((Hero) Hero).getAkt_mana() + "/" + MaxMana, 150, 25);
		else
			g.drawString(0 + "/" + MaxMana, 110, 25);
		Font Letter = new Font("Arial", Font.BOLD, 20);

		g.setFont(Letter);
		g.setColor(Color.black);
		g.drawString("Kills: " + Kills, 40, 70);

		g.drawString("Lasthits: " + Lasthits, 140, 70);
		g.drawString("Deaths: " + Deaths, 260, 70);

	}

}
