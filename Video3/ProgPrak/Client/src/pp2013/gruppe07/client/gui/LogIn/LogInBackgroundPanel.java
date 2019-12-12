package pp2013.gruppe07.client.gui.LogIn;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.Frame;

/**
 * Panel das den LogIn und das Accounterstellen beinhaltet.
 * 
 * @author Felix
 * 
 */
public class LogInBackgroundPanel extends JComponent {

	private String username;
	private String password;
	private JPanel lockInPanel;
	private JPanel newAccountPanel;
	JFrame frame;
	private JPanel screens;
	private Image background;

	public LogInBackgroundPanel(Frame frame) {
		this.setLayout(new BorderLayout());
		this.frame = frame;
		this.setFocusable(true);
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.BLACK);

		if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
			background = Toolkit.getDefaultToolkit().getImage(
					"Images/Zeichnungklein.png");
		}

		if (System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0) {

			background = Toolkit.getDefaultToolkit().getImage(
					"Images/ZeichnungkleinLinux.png");
		}

		lockInPanel = new LogInPanel(frame);
		newAccountPanel = new CreateAccountPanel(frame);

		newAccountPanel.setVisible(false);

		screens = new JPanel(new CardLayout());

		try {
			screens.add(lockInPanel);
			screens.add(newAccountPanel);
		} catch (Exception e) {
		}
		this.add(screens);

		this.setBackground(new Color(128, 0, 0));
	}

	public JPanel getLockIn() {
		return this.lockInPanel;
	}

	public JPanel getNewAccount() {
		return this.newAccountPanel;
	}

	public JPanel getScreens() {
		return this.screens;
	}

	@Override
	protected void paintComponent(Graphics g) {

		g.drawImage(background, 0, 0, this);
	}
}
