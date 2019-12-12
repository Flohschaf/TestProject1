package pp2013.gruppe07.client.gui.daniel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.World;
import pp2013.gruppe07.shared.entity.Hero;

/**
 * 
 * @author Daniel Diese Klasse erstellt die GeldAnzeige und die Spieldauer
 */

public class MoneyPanel extends JPanel {

	private int Money;
	private final int SCREENWIDTH;
	private Hero HERO;
	private int time = 0;
	private int minutes = 0;
	private int seconds = 0;

	private World world;

	public MoneyPanel(World world) {
		super.setSize(40, 40);
		this.setBackground(Color.DARK_GRAY);
		this.setVisible(true);
		Money = world.getClientAdmin().getClientHero().getMoney();

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		SCREENWIDTH = gd.getDisplayMode().getWidth();
		this.world = world;
	}

	/**
	 * 
	 * @author Daniel Diese Methode bestimmt die Zeit, wobei dabei elementar
	 *         ist, wo sie aufgerufen wird.
	 * */
	public void counttime() {

		time++;

		seconds = time % 60;
		if (seconds == 0)
			minutes++;

	}

	/**
	 * 
	 * @author Daniel Diese Methode malt die Zeit und die GeldAnzeige
	 * */
	public void paint(Graphics g) {

		Image image;

		image = Toolkit.getDefaultToolkit().getImage("Images/geld1.gif");

		g.drawImage(image, SCREENWIDTH - 222, 0, this);

		//
		g.setColor(Color.white);
		g.drawString("Money: "
				+ world.getClientAdmin().getClientHero().getMoney(),
				SCREENWIDTH - 160, 20);

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		int SCREENHEIGHT = gd.getDisplayMode().getHeight();

		g.setColor(Color.black);

		g.setColor(Color.white);
		g.setFont((new Font("Arial", Font.BOLD, 16)));

		g.drawString(minutes + ":" + seconds, SCREENWIDTH - 260, 20);

	}

}
