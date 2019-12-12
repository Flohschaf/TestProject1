package pp2013.gruppe07.client.gui.daniel;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import pp2013.gruppe07.shared.entity.Entity;
import pp2013.gruppe07.shared.entity.Hero;

/**
 * @author Daniel Diese Klasse erzeugt ein Fenster, das erscheinen sollte, um
 *         den angegriffenen Character anzuzeigen, wurde allerdings nicht
 *         fertiggestellt
 * 
 */
public class Klickinfoframe extends JFrame {
	private Entity entity;
	private KillStatistic Stat;

	public Klickinfoframe(Entity entity) {
		this.entity = entity;
		this.setSize(200, 200);
		Stat = new KillStatistic((Hero) entity);
		this.setLayout(new BorderLayout());
		this.add(Stat, BorderLayout.CENTER);
	}
}
