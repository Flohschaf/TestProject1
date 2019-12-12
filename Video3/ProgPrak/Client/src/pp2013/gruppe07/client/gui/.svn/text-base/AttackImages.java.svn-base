package pp2013.gruppe07.client.gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

import pp2013.gruppe07.shared.entity.Figure;

/**
 * 
 * @author Felix
 * 
 */
public class AttackImages {
	public static HashMap<Figure.direction, Image[]> attacks;

	public static void init() {

		attacks = new HashMap<Figure.direction, Image[]>();

		Image[] links = {
				Toolkit.getDefaultToolkit()
						.getImage("Images/schwert1links.png"),
				Toolkit.getDefaultToolkit()
						.getImage("Images/Schwert2links.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Bogen1links.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Bogen2links.png") };

		Image[] rechts = {
				Toolkit.getDefaultToolkit().getImage("Images/schwert1.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Schwert2.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Bogen1.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Bogen2.png") };

		Image[] oben = {
				Toolkit.getDefaultToolkit().getImage("Images/schwert1oben.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Schwert2oben.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Bogen1oben.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Bogen2oben.png") };

		Image[] unten = {
				Toolkit.getDefaultToolkit()
						.getImage("Images/schwert1unten.png"),
				Toolkit.getDefaultToolkit()
						.getImage("Images/Schwert2unten.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Bogen1unten.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Bogen2unten.png") };

		attacks.put(Figure.direction.left, links);
		attacks.put(Figure.direction.right, rechts);
		attacks.put(Figure.direction.up, oben);
		attacks.put(Figure.direction.down, unten);

	}
}
