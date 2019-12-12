package pp2013.gruppe07.client.gui.daniel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.Frame;
import pp2013.gruppe07.client.gui.World;

/**
 * 
 * @author Daniel Diese Klasse erstellt den Menu Frame
 */

public class Menu extends JFrame implements MouseListener, MouseMotionListener,
		ActionListener, KeyListener {

	private final JButton EXITBAR;
	private final JButton CLOSEBAR;

	private Graphics G;

	private final LoLFrame FRAME;

	private HeroItem Heroitem;
	private World world;
	private Frame frame;

	public Menu(Frame frame, World world, LoLFrame lolFrame, HeroItem Heroitem) {
		super("Menu");
		super.setSize(120, 400);
		super.addMouseListener(this);
		this.frame = frame;
		this.addMouseMotionListener(this);
		this.setUndecorated(true);
		super.addKeyListener(this);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.setLayout(new BorderLayout());
		this.world = world;

		this.FRAME = lolFrame;
		this.Heroitem = Heroitem;

		EXITBAR = new JButton("Exit Game");
		EXITBAR.addActionListener(this);

		CLOSEBAR = new JButton("Close");
		CLOSEBAR.addActionListener(this);
		JLabel Header = new JLabel("Menu");
		JPanel HeaderBG = new JPanel();
		HeaderBG.setBounds(10, 10, 70, 30);
		HeaderBG.setLayout(null);
		HeaderBG.add(Header);
		HeaderBG.setBackground(Color.white);

		Header.setBackground(Color.white);
		JPanel Buttonrow = new JPanel();

		Buttonrow.add(HeaderBG);
		Buttonrow.setLayout(null);
		Header.setBounds(5, 0, 60, 40);

		EXITBAR.setBounds(10, 230, 100, 40);

		CLOSEBAR.setBounds(10, 310, 80, 40);

		Buttonrow.setBackground(Color.black);
		Buttonrow.add(CLOSEBAR);
		Buttonrow.add(EXITBAR);

		this.add(Buttonrow, BorderLayout.CENTER);

	}

	public void paint(Graphics g, int x, int y) {

	}

	// ----------------------Mouselistener

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
	/**
	 * 
	 * @author Daniel Dieser Listener hoert auf die gedrueckten knoepfe und
	 *         schliesst entweder das Menu oder das Spiel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == EXITBAR) {

			FRAME.closeframe();

			this.setVisible(false);
			this.setVisible(false);
			this.dispose();
			LogoutFrame LF = new LogoutFrame(frame, world, Heroitem);
		}
		if (e.getSource() == CLOSEBAR) {

			this.setVisible(false);
			this.dispose();
		}

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
