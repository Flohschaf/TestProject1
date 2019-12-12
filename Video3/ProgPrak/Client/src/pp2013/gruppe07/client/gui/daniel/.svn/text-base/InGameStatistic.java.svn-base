package pp2013.gruppe07.client.gui.daniel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import pp2013.gruppe07.client.gui.World;

/**
 * 
 * @author Daniel Diese Klasse erstellt die InGame Statistik
 */

public class InGameStatistic extends JFrame implements KeyListener {

	private World world;
	private StatisticsPanel STPanel;

	public InGameStatistic(World world, HeroItem Heroitems) {
		super("League of Legends-SHp");
		super.setSize(100, 400);

		this.world = world;
		// this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

		this.setUndecorated(true);
		this.addKeyListener(this);
		this.setLayout(new BorderLayout());
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.setLayout(new BorderLayout());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		STPanel = new StatisticsPanel(world, Heroitems);

		this.add(STPanel, BorderLayout.CENTER);
		STPanel.setVisible(true);

	}

	/**
	 * 
	 * @author Daniel Diese Methode ist ein Keylistener der dazu dient den frame
	 *         wieder zu schliessen
	 */
	@Override
	public void keyPressed(KeyEvent f) {
		// TODO Auto-generated method stub
		if (f.getKeyCode() == KeyEvent.VK_5) {

			this.setVisible(false);
			this.dispose();
			//

		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
