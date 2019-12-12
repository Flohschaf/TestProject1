package pp2013.gruppe07.client.gui.Lobby;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.Frame;

/**
 * Zeigt die Informationen zum aktuell gewaehlten Helden an
 * 
 * @author Felix,Flo
 * 
 */
public class HeroSelectionPanel extends JPanel {
	private int width;
	private int heigth;
	private Frame frame;

	HeroInfoPanel heroInfoPanel;

	public HeroSelectionPanel(Frame frame) {

		this.frame = frame;

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		width = (int) (gd.getDisplayMode().getWidth() * 0.3);
		heigth = (int) (gd.getDisplayMode().getHeight() * 0.3);

		this.setPreferredSize(new Dimension(heigth, width));
		this.setLayout(new GridLayout(1, 2));

		HeroPanel heroPanel = new HeroPanel(frame, this);
		this.add(heroPanel);

		heroInfoPanel = new HeroInfoPanel(frame);
		this.add(heroInfoPanel);

	}

	public HeroInfoPanel getHeroInfoPanel() {
		return this.heroInfoPanel;
	}
}
