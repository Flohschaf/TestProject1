package pp2013.gruppe07.client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Ladebildschirm der ueber den aktuellen drueber gelegt wird.
 * @author Felix
 *
 */
public class Loading extends JPanel {
	
	public Loading(Frame frame, String message) {

		this.setBackground(Color.BLACK);

		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f));
		this.setOpaque(true);
		this.setLayout(new GridBagLayout());
		JLabel info = new JLabel(message);
		this.add(info);
		int screenWidth = 800;
		int screenHeight = 600;
		if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
			GraphicsDevice gd = GraphicsEnvironment
					.getLocalGraphicsEnvironment().getDefaultScreenDevice();

			screenWidth = gd.getDisplayMode().getWidth();
			screenHeight = gd.getDisplayMode().getHeight();

		}

		if (System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0) {

			screenWidth = 1280;
			screenHeight = 1024;
		}
		Dimension dimension = new Dimension(screenWidth, screenHeight);
		this.setSize(dimension);

	}

}
