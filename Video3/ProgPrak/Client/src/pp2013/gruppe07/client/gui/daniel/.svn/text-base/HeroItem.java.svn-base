package pp2013.gruppe07.client.gui.daniel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.UUID;

import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.World;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.item.Armor;
import pp2013.gruppe07.shared.item.Axt;
import pp2013.gruppe07.shared.item.Elixir;
import pp2013.gruppe07.shared.item.Item;
import pp2013.gruppe07.shared.item.Jacket;
import pp2013.gruppe07.shared.item.Manapotion;
import pp2013.gruppe07.shared.item.Potion;
import pp2013.gruppe07.shared.item.Shoe;
import pp2013.gruppe07.shared.item.SpaceHolderItem;
import pp2013.gruppe07.shared.item.Sword;
import pp2013.gruppe07.shared.item.Trouser;

/**
 * 
 * @author Daniel Diese Klasse erstellt den Item Bereich und zeigt die gekauften
 *         Items
 */

public class HeroItem extends JPanel {
	protected final Image IMAGESPACEHOLDER;
	protected final Image IMAGEARMOR;
	protected final Image IMAGEELIXIR;
	protected final Image IMAGEMANA;
	protected final Image IMAGESHOE;
	protected final Image IMAGESWORD;
	protected final Image IMAGEJACKET;
	protected final Image IMAGETROUSER;
	protected final Image IMAGEAXT;

	private boolean Mana = false;
	private boolean Health = false;
	private Item[][] Items = new Item[2][3];
	private World world;
	private Hero hero;
	private UUID Heroid;
	private boolean ClientHero;

	public HeroItem(World world, Hero hero, boolean ClientHero) {
		this.world = world;
		super.setSize(40, 40);
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
		this.hero = hero;
		IMAGESPACEHOLDER = Toolkit.getDefaultToolkit().getImage(
				"Images/SpaceHolderItem.gif");
		IMAGEARMOR = Toolkit.getDefaultToolkit().getImage("Images/Armor.gif");
		IMAGEELIXIR = Toolkit.getDefaultToolkit().getImage("Images/Trank.png");
		IMAGEMANA = Toolkit.getDefaultToolkit()
				.getImage("Images/ManaTrank.png");
		IMAGESHOE = Toolkit.getDefaultToolkit().getImage("Images/Shoe.gif");
		IMAGESWORD = Toolkit.getDefaultToolkit().getImage("Images/Sword.gif");
		IMAGEAXT = Toolkit.getDefaultToolkit().getImage("Images/Axt.png");
		IMAGETROUSER = Toolkit.getDefaultToolkit().getImage("Images/Hose.png");
		IMAGEJACKET = Toolkit.getDefaultToolkit().getImage("Images/Jacke.png");
		Heroid = hero.getID();
		this.ClientHero = ClientHero;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				Items[i][j] = new SpaceHolderItem();
			}
		}

	}

	public void setItems() {
		/**
		 * 
		 * @author Daniel Diese Methode arbeitet mit dem Shop und aendert die
		 *         Darstellung nach Kauf neuer Items, wurde in der paint methode
		 *         uebernommen
		 */
		// if(Heroid.equals(world.getClientAdmin().getClientHero().getID())){
		// for(int i = 0 ; i < 6 ; i++){
		// Items[i%2][i%3]=
		// world.getClientAdmin().getClientHero().getItems()[i];
		// System.out.println("es geth dooooooooooooooooooooooooooooooooooooooooooooch");
		// }
		// }else
		// if(!Heroid.equals(world.getClientAdmin().getClientHero().getID())){
		// for(int i = 0 ; i < 6 ; i++){
		// Items[i%2][i%3]=hero.getItems()[i];
		// }
		// }

		repaint();

	}

	/**
	 * 
	 * @author Daniel Diese Methode malt die Items oder je nach dem die
	 *         Spaceholderobjekte
	 */
	public void paint(Graphics g) {
		if (ClientHero) {
			for (int i = 0; i < 6; i++) {
				Items[i % 2][i % 3] = ((Hero) world.getEntities().get(
						world.getClientAdmin().getClientHero().getID()))
						.getItems()[i];
				// world.getClientAdmin().getClientHero().getItems()[i];

				// System.out.println("Clientheroerkannt..................");
			}
		} else {
			for (int i = 0; i < 6; i++) {
				Items[i % 2][i % 3] = hero.getItems()[i];
			}
		}
		int[] position = new int[2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				position[0] = 12 + 4 * i + i * 30;
				position[1] = 4 * j + j * 30;

				if (Items[i][j] instanceof SpaceHolderItem)
					g.drawImage(IMAGESPACEHOLDER, position[0], position[1],
							this);
				if (Items[i][j] instanceof Shoe)

					g.drawImage(IMAGESHOE, position[0], position[1], this);
				if (Items[i][j] instanceof Sword) {
					g.drawImage(IMAGESWORD, position[0], position[1], this);
					System.out.println("SChwert ist gesetzzzzzzzzzzzzzzzzzzt");
				}
				if (Items[i][j] instanceof Axt)
					g.drawImage(IMAGEAXT, position[0], position[1], this);
				if (Items[i][j] instanceof Jacket)
					g.drawImage(IMAGEJACKET, position[0], position[1], this);
				if (Items[i][j] instanceof Trouser)
					g.drawImage(IMAGETROUSER, position[0], position[1], this);
				if (Items[i][j] instanceof Armor)
					g.drawImage(IMAGEARMOR, position[0], position[1], this);
				if (Items[i][j] instanceof Manapotion && !Mana) {
					Mana = true;
					g.drawImage(IMAGEMANA, position[0], position[1], this);
					g.setColor(Color.white);
					g.drawString(""
							+ (((Potion) Items[i][j]).getQuantity() + 1),
							position[0], position[1] + 20);
				}
				if (Items[i][j] instanceof Elixir && !Health) {
					Health = true;
					g.drawImage(IMAGEELIXIR, position[0], position[1], this);
					g.setColor(Color.white);
					g.drawString(""
							+ (((Potion) Items[i][j]).getQuantity() + 1),
							position[0], position[1] + 20);
				}

			}
		}

		// 30*27 pixel Groesse Item Bilder

		Mana = false;
		Health = false;
	}

}
