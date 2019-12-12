package pp2013.gruppe07.client.gui.daniel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pp2013.gruppe07.client.comm.Communication;
import pp2013.gruppe07.client.gui.Frame;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.StatRequestEvent;

/**
 * 
 * @author Daniel Diese Klasse erstellt die buttons im logoutframe
 */

public class LogoutPanel extends JPanel implements MouseListener,
		MouseMotionListener, ActionListener, KeyListener {

	private final JButton STATISTICSBAR;
	private final JButton STATSALLTIMEBAR;
	private final JButton LOGOUTBAR;
	private final JButton CLOSEBAR;

	private Image image;
	private Graphics g;
	private final LogoutFrame Log;
	private final StatisticsPanel SP;
	private final Statisticsalltime SAP;
	private Frame frame;

	public LogoutPanel(Frame frame, LogoutFrame Log, StatisticsPanel Sp,
			Statisticsalltime SAP) {
		System.out.println("LOGOUTPANEL IST DA!!!");
		super.setSize(100, 400);
		super.addMouseListener(this);
		this.frame = frame;
		this.addMouseMotionListener(this);
		this.SP = Sp;
		super.addKeyListener(this);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.setLayout(new BorderLayout());
		this.Log = Log;
		this.SAP = SAP;

		STATISTICSBAR = new JButton("Statistics");
		STATISTICSBAR.addActionListener(this);

		STATSALLTIMEBAR = new JButton("History Statistics");
		STATSALLTIMEBAR.addActionListener(this);

		LOGOUTBAR = new JButton("Logout");
		LOGOUTBAR.addActionListener(this);

		CLOSEBAR = new JButton("Close");
		CLOSEBAR.addActionListener(this);

		JPanel Buttonrow = new JPanel();
		Buttonrow.setBackground(Color.cyan);
		Buttonrow.setLayout(new GridBagLayout());
		Buttonrow.setBackground(Color.black);
		GridBagConstraints Buttons = new GridBagConstraints();
		Buttons.insets = new Insets(1, 1, 1, 1);
		Buttons.gridx = 0;
		Buttons.gridy = 0;
		Buttonrow.add(STATISTICSBAR, Buttons);
		Buttons.gridy = 1;
		Buttonrow.add(STATSALLTIMEBAR, Buttons);
		Buttons.gridy = 2;
		Buttonrow.add(LOGOUTBAR, Buttons);
		Buttons.gridy = 3;
		Buttonrow.add(CLOSEBAR, Buttons);

		this.add(Buttonrow, BorderLayout.CENTER);

	}

	public void paint(Graphics g, int x, int y) {
		this.paintComponent(g);

	}

	// ----------------------Mouselistener

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
	/**
	 * 
	 * @author Daniel Dieser Listener hoert auf die gedrueckten knoepfe und
	 *         oeffnet dementsprechende panels
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == STATISTICSBAR) {

			SP.setVisible(true);
			SAP.setVisible(false);
		}

		if (e.getSource() == STATSALLTIMEBAR) {
			Communication.newServerMessage(new StatRequestEvent(frame
					.getClientID(), frame.getAccountName()));
			SP.setVisible(false);
			SAP.setVisible(true);

		}
		if (e.getSource() == LOGOUTBAR) {

		}
		if (e.getSource() == CLOSEBAR) {

			Log.setVisible(false);
			Log.dispose();
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
