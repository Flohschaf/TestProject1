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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.BuyEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.ChatEvent;
import pp2013.gruppe07.shared.item.Armor;
import pp2013.gruppe07.shared.item.Axt;
import pp2013.gruppe07.shared.item.Elixir;
import pp2013.gruppe07.shared.item.Item;
import pp2013.gruppe07.shared.item.Jacket;
import pp2013.gruppe07.shared.item.Manapotion;
import pp2013.gruppe07.shared.item.Shoe;
import pp2013.gruppe07.shared.item.SpaceHolderItem;
import pp2013.gruppe07.shared.item.Sword;
import pp2013.gruppe07.shared.item.Trouser;

/**
 * 
 * @author Daniel Diese Klasse erstellt den ShopFrame und uebergibt gekaufte
 *         Items an HeroItem
 */

public class Shop_GUI extends JFrame implements MouseListener,
		MouseMotionListener, ActionListener, KeyListener {

	private final JButton SWORDBAR;
	private final JButton JACKETBAR;
	private final JButton TROUSERBAR;
	private final JButton AXTBAR;
	private final JButton SHOEBAR;
	private final JButton ELIXIR;
	private final JButton MANAPOTION;
	private final JButton ARMORBAR;
	private final JButton CLOSEBAR;
	private ButtonInfoFrame Info;
	private boolean Infoshown = false;

	private Image image;
	private Graphics g;
	private Item Items[] = new Item[6];
	private int ItemNr = 0;
	private final int CLIENTID;

	public Shop_GUI(int clientid) {
		super("Shop");
		super.setSize(100, 600);
		super.addMouseListener(this);

		this.addMouseMotionListener(this);
		this.setUndecorated(true);
		super.addKeyListener(this);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.setLayout(new BorderLayout());
		this.CLIENTID = clientid;
		for (int i = 0; i < 6; i++) {
			Items[i] = new SpaceHolderItem();
		}
		/**
		 * 
		 * @author Daniel Die folgenden Listener hoeren auf die gedrueckten
		 *         knoepfe und oeffnet dementsprechende Infoframes
		 */
		ImageIcon SwordIcon = new ImageIcon("Images/Sword.gif");
		SWORDBAR = new JButton(SwordIcon);
		SWORDBAR.addActionListener(this);
		SWORDBAR.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Sword S = new Sword();
					Info = new ButtonInfoFrame("Angriff + 10 Kosten:"
							+ S.getCost(), 40, 140);
					Infoshown = true;
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				Info.dispose();
				Infoshown = false;

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

		});

		ImageIcon JacketIcon = new ImageIcon("Images/Jacke.png");
		JACKETBAR = new JButton(JacketIcon);
		JACKETBAR.addActionListener(this);
		JACKETBAR.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Jacket J = new Jacket();
					Info = new ButtonInfoFrame("Ruestung + 8 Kosten:"
							+ J.getCost(), 40, 140);
					Infoshown = true;
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				Info.dispose();
				Infoshown = false;

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

		});

		ImageIcon TrouserIcon = new ImageIcon("Images/Hose.png");
		TROUSERBAR = new JButton(TrouserIcon);
		TROUSERBAR.addActionListener(this);
		TROUSERBAR.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Trouser T = new Trouser();
					Info = new ButtonInfoFrame("bewegung + 8 Kosten:"
							+ T.getCost(), 40, 140);
					Infoshown = true;
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				Info.dispose();
				Infoshown = false;

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

		});

		ImageIcon AxtIcon = new ImageIcon("Images/Axt.png");
		AXTBAR = new JButton(AxtIcon);
		AXTBAR.addActionListener(this);
		AXTBAR.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Axt A = new Axt();
					Info = new ButtonInfoFrame("Angriff + 10 Kosten:"
							+ A.getCost(), 40, 140);
					Infoshown = true;
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				Info.dispose();
				Infoshown = false;

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

		});

		ImageIcon ElixirIcon = new ImageIcon("Images/Trank.png");
		ELIXIR = new JButton(ElixirIcon);
		ELIXIR.addActionListener(this);
		ELIXIR.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Sword S = new Sword();
					Info = new ButtonInfoFrame("Trank + 10 Kosten:"
							+ S.getCost(), 40, 140);
					Infoshown = true;
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				Info.dispose();
				Infoshown = false;

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

		});
		ImageIcon ManaIcon = new ImageIcon("Images/ManaTrank.png");
		MANAPOTION = new JButton(ManaIcon);
		MANAPOTION.addActionListener(this);
		MANAPOTION.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Sword S = new Sword();
					Info = new ButtonInfoFrame("Mana + 10 Kosten:"
							+ S.getCost(), 40, 140);
					Infoshown = true;
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				Info.dispose();
				Infoshown = false;

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

		});
		ImageIcon ShoeIcon = new ImageIcon("Images/Shoe.gif");
		SHOEBAR = new JButton(ShoeIcon);
		SHOEBAR.addActionListener(this);
		SHOEBAR.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Shoe S = new Shoe();
					Info = new ButtonInfoFrame("Bewegung + 10 Kosten:"
							+ S.getCost(), 40, 160);
					Infoshown = true;
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				Info.dispose();
				Infoshown = false;

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

		});
		ImageIcon ArmorIcon = new ImageIcon("Images/Armor.gif");
		ARMORBAR = new JButton(ArmorIcon);
		ARMORBAR.addActionListener(this);
		ARMORBAR.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Armor A = new Armor();
					Info = new ButtonInfoFrame("Ruestung +10 Kosten:"
							+ A.getCost(), 40, 180);
					Infoshown = true;
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				Info.dispose();
				Infoshown = false;

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

		});
		CLOSEBAR = new JButton("Close");
		CLOSEBAR.addActionListener(this);
		// this.add(MenuBar,BorderLayout.NORTH);
		JLabel Header = new JLabel("Shop");
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
		SWORDBAR.setBounds(10, 60, 30, 27);
		SHOEBAR.setBounds(10, 110, 30, 27);
		ARMORBAR.setBounds(10, 160, 30, 27);
		MANAPOTION.setBounds(10, 210, 30, 27);
		ELIXIR.setBounds(10, 260, 30, 27);
		JACKETBAR.setBounds(10, 310, 30, 27);
		AXTBAR.setBounds(10, 360, 30, 27);
		TROUSERBAR.setBounds(10, 410, 30, 27);
		CLOSEBAR.setBounds(10, 460, 80, 40);

		Buttonrow.setBackground(Color.black);

		Buttonrow.add(SWORDBAR);

		Buttonrow.add(SHOEBAR);

		Buttonrow.add(ARMORBAR);

		Buttonrow.add(MANAPOTION);

		Buttonrow.add(ELIXIR);

		Buttonrow.add(JACKETBAR);

		Buttonrow.add(TROUSERBAR);

		Buttonrow.add(AXTBAR);

		Buttonrow.add(CLOSEBAR);

		this.add(Buttonrow, BorderLayout.CENTER);

	}

	public void paint(Graphics g, int x, int y) {

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

	public Item[] getItem() {
		return Items;
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
	 *         loest entprechende Buyenvents aus.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String Chat = "";
		if (e.getSource() == SWORDBAR && ItemNr < 6) {

			EventManager.callEvent(new BuyEvent(CLIENTID, new Sword()));

		}
		if (e.getSource() == AXTBAR && ItemNr < 6) {

			EventManager.callEvent(new BuyEvent(CLIENTID, new Axt()));

		}
		if (e.getSource() == JACKETBAR && ItemNr < 6) {

			EventManager.callEvent(new BuyEvent(CLIENTID, new Jacket()));

		}
		if (e.getSource() == TROUSERBAR && ItemNr < 6) {

			EventManager.callEvent(new BuyEvent(CLIENTID, new Trouser()));

		}
		if (e.getSource() == SHOEBAR && ItemNr < 6) {
			EventManager.callEvent(new BuyEvent(CLIENTID, new Shoe()));

		}

		if (e.getSource() == ELIXIR && ItemNr < 6) {
			EventManager.callEvent(new BuyEvent(CLIENTID, new Elixir(1)));

		}

		if (e.getSource() == MANAPOTION && ItemNr < 6) {
			EventManager.callEvent(new BuyEvent(CLIENTID, new Manapotion(1)));

		}
		if (e.getSource() == ARMORBAR && ItemNr < 6) {
			EventManager.callEvent(new BuyEvent(CLIENTID, new Armor()));

		}
		EventManager.callEvent(new ChatEvent(CLIENTID, Chat));

		if (e.getSource() == CLOSEBAR) {

			this.setVisible(false);

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
