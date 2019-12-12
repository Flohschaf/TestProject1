package pp2013.gruppe07.client.gui.daniel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author Daniel Diese Klasse erstellt den Infoframe fuer die Buttons
 */

public class ButtonInfoFrame extends JFrame {
	private String Information = "";

	public ButtonInfoFrame(String Information, int x, int y) {
		super("Button Info Frame");
		super.setSize(190, 20);
		this.Information = Information;
		this.setUndecorated(true);
		this.setLocation(x, y);
		this.setLayout(new BorderLayout());

		this.setVisible(true);
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.setLayout(new BorderLayout());

		JLabel Info = new JLabel(Information);
		this.add(Info, BorderLayout.CENTER);

	}

	public void paint(Graphics g, int x, int y) {
	}

}
