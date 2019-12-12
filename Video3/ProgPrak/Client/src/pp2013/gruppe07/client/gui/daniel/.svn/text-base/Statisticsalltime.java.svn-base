package pp2013.gruppe07.client.gui.daniel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.World;
import pp2013.gruppe07.shared.eventManager.EventListener;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.StatSendEvent;

/**
 * Diese Klasse erstellt die Anzeige der Statistiken aller Helden
 * fuer den jeweiligen Account.
 * @author Flo
 * @author Felix 
 */

public class Statisticsalltime extends JPanel implements EventListener {

	private String playername = "Flo";
	final int MAXENTRIES = 7;
	Font font = new Font("Arial", Font.BOLD, 20);
	private String stats[][];

	JPanel[][] statsPanel;
	JLabel[][] statsLabel;

	private World world;

	Image image, image1, image2, image3, image4, image5, image6, image7,
			image8;

	public Statisticsalltime() {
		statsLabel = new JLabel[9][3];
		statsPanel = new JPanel[9][4];
		// super.setSize(40, 40);
		stats = new String[8][4];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				stats[i][j] = "---";
			}

		}

		EventManager.registerListener(this, Event.Type.STAT_SEND_EVENT);

		this.setBackground(Color.BLUE);
		this.setVisible(false);
		this.setLayout(new BorderLayout());
		//this.setPreferredSize(new Dimension(800, 1000));

		image = Toolkit.getDefaultToolkit().getImage("Images/color-wave.png");
		image1 = Toolkit.getDefaultToolkit().getImage("Images/Flomini.png");
		image2 = Toolkit.getDefaultToolkit().getImage("Images/Captainmini.png");
		image3 = Toolkit.getDefaultToolkit().getImage(
				"Images/Dangerdanmini.png");
		image4 = Toolkit.getDefaultToolkit().getImage("Images/Felixmini.png");
		image5 = Toolkit.getDefaultToolkit().getImage("Images/Generalmini.png");
		image6 = Toolkit.getDefaultToolkit().getImage("Images/Stevenmini.png");
		image7 = Toolkit.getDefaultToolkit().getImage("Images/Svenmini.png");
		image8 = Toolkit.getDefaultToolkit().getImage("Images/Jaymini.png");

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		int SCREENWIDTH = gd.getDisplayMode().getWidth();
		int SCREENHEIGHT = gd.getDisplayMode().getHeight();

		JPanel panel = new JPanel();
		//panel.setPreferredSize(new Dimension(100, 100));
		//panel.setLocation(80, 110);
		panel.setLayout(new GridLayout(9, 4));
		panel.setOpaque(false);

		
		// Das Bild wird in Panel unterteilt um eine harmonsiche Anzeige zu
		// erzeugen
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 4; j++) {
				statsPanel[i][j] = new JPanel();

				if (j != 0) {
					statsLabel[i][j - 1] = new JLabel("---");
					statsLabel[i][j - 1].setFont(font);
					statsLabel[i][j - 1].setForeground(Color.GREEN);
					statsPanel[i][j].add(statsLabel[i][j - 1]);
					
				}
				
				statsPanel[i][j].setOpaque(false);
				panel.add(statsPanel[i][j]);
			}
			System.out.println("");
		}
		
		JLabel hero = new JLabel("Hero");
		hero.setFont(font);
		hero.setForeground(Color.GREEN);
		statsPanel[0][0].add(hero);
		// statsLabel[0][0].setText("Hero") ;
		statsLabel[0][0].setText("Total Kills");
		statsLabel[0][1].setText("Total Deaths");
		statsLabel[0][2].setText("Total LastHits");

		panel.setBorder(BorderFactory.createLineBorder(Color.GREEN));

		this.add(panel);
	}

	public void paint(Graphics g) {

		g.drawImage(image, 0, 0, this);

		//
		// g.setColor(Color.GREEN);
		// g.fillRect(80,110,620,2);
		// g.fillRect(80,110,2,590);
		// g.fillRect(700,110,2,592);
		// g.fillRect(80,700,620,2);
		// g.setFont((new Font("Arial",Font.BOLD,20)));
		// g.drawString("Hero",110,100);
		// g.drawString("Total Kills",210,100);
		// g.drawString("Total Deaths",360,100);
		// g.drawString("Total LastHits",540,100);
		// g.drawString(playername+"'s History",this.getCenter(800,playername),
		// 20);

		

		this.paintComponents(g);

		//
		// for (int i=0;i<MAXENTRIES;i++){
		// if(stats[0][i].equals("FamousFlorian")){
		// g.drawImage(image1,110,130+80*i,this);
		// g.drawString(stats[1][i],260,170+80*i);
		// g.drawString(stats[2][i],410,170+80*i);
		// g.drawString(stats[3][i],590,170+80*i);
		//
		// }
		// if(stats[0][i].equals("DangerDan")){
		// g.drawImage(image3,110,130+80*i,this);
		// g.drawString(stats[1][i],260,170+80*i);
		// g.drawString(stats[2][i],410,170+80*i);
		// g.drawString(stats[3][i],590,170+80*i);
		// }
		// if(stats[0][i].equals("SeriousSven")){
		// g.drawImage(image7,110,130+80*i,this);
		// g.drawString(stats[1][i],260,170+80*i);
		// g.drawString(stats[2][i],410,170+80*i);
		// g.drawString(stats[3][i],590,170+80*i);
		// }
		// if(stats[0][i].equals("FederalFelix")){
		// g.drawImage(image4,110,130+80*i,this);
		// g.drawString(stats[1][i],260,170+80*i);
		// g.drawString(stats[2][i],410,170+80*i);
		// g.drawString(stats[3][i],590,170+80*i);
		// }
		// if(stats[0][i].equals("ClitCommander")){
		// g.drawImage(image8,110,130+80*i,this);
		// g.drawString(stats[1][i],260,170+80*i);
		// g.drawString(stats[2][i],410,170+80*i);
		// g.drawString(stats[3][i],590,170+80*i);
		// }
		// if(stats[0][i].equals("GeneralHate")){
		// g.drawImage(image5,110,130+80*i,this);
		// g.drawString(stats[1][i],260,170+80*i);
		// g.drawString(stats[2][i],410,170+80*i);
		// g.drawString(stats[3][i],590,170+80*i);
		// }
		// if(stats[0][i].equals("SafteySteven")){
		// g.drawImage(image6,110,130+80*i,this);
		// g.drawString(stats[1][i],260,170+80*i);
		// g.drawString(stats[2][i],410,170+80*i);
		// g.drawString(stats[3][i],590,170+80*i);
		// }
		// if(stats[0][i].equals("CaptainObvious")){
		// g.drawImage(image2,110,130+80*i,this);
		// g.drawString(stats[1][i],260,170+80*i);
		// g.drawString(stats[2][i],410,170+80*i);
		// g.drawString(stats[3][i],590,170+80*i);
		// }
		// }

	}

	public int getCenter(int sizeX, String playername) {
		int x;
		x = (int) (sizeX / 2 - playername.length() / 2 * 20);
		return x;
	}

	/**
	 * Beim oeffnen der Statistik wird ein request an den Server gesendet.
	 * Dieser schickt daraufhin die Statistik zurueck. Die onEvent() Methode
	 * reagiert darauf.
	 */
	@Override
	public void onEvent(Event evt) {
		StatSendEvent event = (StatSendEvent) evt;
		this.stats = event.getStat();
		this.repaint();

		for (int i = 0; i < event.getStat().length; i++) {
			for (int j = 0; j < 3; j++) {
				statsLabel[i + 1][j].setText(stats[i][j + 1]);

			}

		}
		
		for (int i = 1; i < 9; i++) {

			if (stats[i - 1][0].equals("CAPTAIN_OBVIOUS")) {
				statsPanel[i][0].add(new Minibild(image2, "Captain Obvious",font));
			}

			if (stats[i - 1][0].equals("CLIT_COMANDER")) {
				statsPanel[i][0].add(new Minibild(image8, "Clit Comander",font));
				
			}
			if (stats[i - 1][0].equals("DANGER_DAN")) {
				statsPanel[i][0].add(new Minibild(image3, "Danger Dan",font));
				
			}
			if (stats[i - 1][0].equals("FAMOUS_FLORIAN")) {
				statsPanel[i][0].add(new Minibild(image1, "Famous Florian",font));
				
			}
			if (stats[i - 1][0].equals("FEDERAL_FELIX")) {
				statsPanel[i][0].add(new Minibild(image4, "Federal Felix",font));
				
			}
			if (stats[i - 1][0].equals("GENERAL_HATE")) {
				statsPanel[i][0].add(new Minibild(image5, "General Hate",font));
				
			}
			if (stats[i - 1][0].equals("SAFETY_STEVEN")) {
				statsPanel[i][0].add(new Minibild(image6, "Safety Steven",font));
				
			}
			if (stats[i - 1][0].equals("SERIOUS_SVEN")) {
				statsPanel[i][0].add(new Minibild(image7, "Serious Sven",font));
				
			}

		}
		

	}

}
