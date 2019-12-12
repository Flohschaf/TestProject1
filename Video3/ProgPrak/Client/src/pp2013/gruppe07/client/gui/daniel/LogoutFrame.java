package pp2013.gruppe07.client.gui.daniel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import pp2013.gruppe07.client.gui.Frame;
import pp2013.gruppe07.client.gui.World;

/**
 * 
 * @author Daniel Diese Klasse erstellt den frame auf dem man sich ausloggt
 */

public class LogoutFrame extends JFrame implements MouseListener,
		MouseMotionListener, ActionListener, KeyListener {

	private Image image;
	private Graphics g;
	private final LogoutPanel LP;
	private final StatisticsPanel SP;
	private final Statisticsalltime SAP;
	private World world;
	private Frame frame;

	public LogoutFrame(Frame frame, World world, HeroItem Heroitems) {
		super("Logoutframe");
		super.setSize(100, 400);
		super.addMouseListener(this);
		this.world = world;
		this.frame = frame;

		this.addMouseMotionListener(this);
		this.setUndecorated(true);
		super.addKeyListener(this);
		this.setLayout(new BorderLayout());

		this.setVisible(true);
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.setLayout(new BorderLayout());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		SP = new StatisticsPanel(world, Heroitems);
		SAP = new Statisticsalltime();
		LP = new LogoutPanel(frame, this, SP, SAP);

		this.add(LP, BorderLayout.CENTER);
		this.add(SP, BorderLayout.EAST);
		this.add(SAP, BorderLayout.WEST);

	}

	public void paint(Graphics g, int x, int y) {

	}

	// ----------------------Mouselistener

	/**
	 * 
	 * @author Daniel Die Listener sind leer, da sie auf den Panels gefuellt
	 *         werden
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		//
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	// ---------------------------------------Keylistener
	public void keyPressed(KeyEvent f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent f) {
		// TODO Auto-generated method stub

	}

	// --------ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	// ----------MouseMotion
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent m) {

	}

}
