package pp2013.gruppe07.server.engine.AStarTestProgramm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Erzeugt eine GUI fuer den Korrektheitsbeweis. Quelle: Diese Klasse ist stark
 * abgeleitet aus der TestGUI des A* aus der Vorlesung: Informatik II WS 2012/13
 * bei Prof. Speckenmeyer , Blatt 6
 * 
 * @author Sven
 * 
 */
class A_Star_TestGUI extends JFrame {

	/**
	 * Ist das eigentliche Panel und faerbt eine Kachel je nach Status ein.
	 * 
	 * @author Sven
	 * 
	 */
	class Display extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			int height = this.getHeight();
			int width = this.getWidth();
			g.setColor(Color.white);
			g.fillRect(0, 0, width, height);
			for (int i = 0; i < 30; i++) {
				for (int j = 0; j < 30; j++) {
					switch (administration.get_map()[i][j].getState()) {
					case 0:
						g.setColor(Color.gray);
						break;
					case 1:
						g.setColor(Color.GREEN);
						break;
					case 2:
						g.setColor(Color.BLUE);
						break;
					case 3:
						g.setColor(Color.YELLOW);
						break;
					case 4:
						g.setColor(Color.RED);
						break;
					case 5:
						g.setColor(Color.MAGENTA);
						break;
					case 6:
						g.setColor(Color.BLACK);
						break;
					case 7:
						g.setColor(Color.ORANGE);
						break;
					}
					g.fillRect(i * 15, j * 15, 15, 15);
					g.setColor(Color.BLACK);
					g.drawRect(i * 15, j * 15, 15, 15);
				}
			}
		}
	}

	private Display myDisplay;
	private JPanel panelMain;

	GameLogic administration;

	/**
	 * Initialisert die Panels und legt die Rahmenbedingungen fest
	 * 
	 * @author Sven
	 * @param administration
	 */
	public A_Star_TestGUI(GameLogic administration) {
		this.administration = administration;
		myDisplay = new Display();
		panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.add(myDisplay, BorderLayout.CENTER);
		this.setContentPane(panelMain);

		this.setSize(30 * 15 + 20, 30 * 15 + 20);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		update();
	}

	/**
	 * Dient dem Veraendern des Staus einer Kachel
	 * 
	 * @param x
	 * @param y
	 * @param value
	 * @author Sven
	 */
	public void setState(int x, int y, int value) {
		administration.get_map()[x][y].setState(value);
		update();
	}

	/**
	 * Zeichnet neu, nachdem ein Zustand veraendert wurde
	 * 
	 * @author Sven
	 */
	public void update() {
		this.paint(this.getGraphics());
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
