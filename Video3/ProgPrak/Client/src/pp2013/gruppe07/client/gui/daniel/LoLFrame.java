package pp2013.gruppe07.client.gui.daniel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import pp2013.gruppe07.client.comm.Communication;
import pp2013.gruppe07.client.gui.Frame;
import pp2013.gruppe07.client.gui.World;
import pp2013.gruppe07.shared.Tile;
import pp2013.gruppe07.shared.entity.Building;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.Shop;
import pp2013.gruppe07.shared.entity.SpaceHolder;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.AttackEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.ChatEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.InfoEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.MoveEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.PotionEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.SpecialAttackEvent;
import pp2013.gruppe07.shared.ground.Sand;
import pp2013.gruppe07.shared.item.Item;
import pp2013.gruppe07.shared.item.SpaceHolderItem;

/**
 * 
 * @author Daniel In dieser Klasse wird das panel erzeugt in dem das
 *         tataeschliche Spiel stattfindet
 */

public class LoLFrame extends JPanel implements MouseListener,
		MouseMotionListener, ActionListener, KeyListener {

	private Frame frame;
	private JButton AreaDamage;
	private boolean Moveable = false;
	private final JButton FOLLOWHEROAKTIATEDEACTIVATE;
	private int gametime = 0;
	private int FSATime = 0;
	private int SSATime = 0;
	private int TSATime = 0;
	private InGameStatistic InGameStat;
	private boolean statisticshown = false;

	private final HeroImage HEROVIEW;

	private int Moveviewy = 0;
	private int Moveviewx = 0;
	private int Endx = Moveviewx + 23;
	private int Endy = Moveviewy + 10;

	private MoneyPanel MoneyP;
	public int[][] TotalFog = new int[140][140];
	public int[][] SemiFog = new int[140][140];

	private int Herox, Heroy;
	static final JPanel MAPAREA = new JPanel();
	private final JPanel HEROIMAGE;
	private LoLminimap MiniMap;
	final LoLMap TrueMap;
	private final JButton MENUBAR;
	private final JButton FOLLOWHEROAKTIVATE;
	private Timer t;
	private Tile[][] Mapview = new Tile[23][11];
	private Menu MenuFrame;
	private HeroLife Life;
	static HeroItem Item;
	private HeroValue Value;
	private Item[][] Items = new Item[2][3];
	static Shop_GUI Shopframe;
	private boolean FirstTimeShop = true;
	private int SCREENHEIGHT;
	private int SCREENWIDTH;
	private final int TILEHEIGHT = 80;
	private Sound sound = new Sound();
	private JTextField TextArea;
	private final JButton STRONGSTRIKE;
	private final JButton Shop;
	private String Chat;
	private World world;
	private ButtonInfoFrame Info;
	private boolean Infoshown = false;
	private JButton MagicStrike;
	private final Hero HERO;
	private String UseSystem;

	public LoLFrame(Frame frame, World world) {

		super.addMouseListener(this);

		this.frame = frame;

		this.frame = frame;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.world = world;

		this.addMouseMotionListener(this);
		super.addKeyListener(this);
		frame.addKeyListener(this);
		frame.setKeylistener(this);
		t = new Timer(10, (ActionListener) this);
		HEROVIEW = new HeroImage((world.getClientAdmin().getClientHero()));

		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		MoneyP = new MoneyPanel(world);

		for (int i = 0; i < 140; i++) {
			for (int j = 0; j < 140; j++) {
				SemiFog[i][j] = 0;

			}
		}

		HERO = (world.getClientAdmin().getClientHero());

		/**
		 * 
		 * @author Daniel Abfrage ob es sich um ein Windows oder linux System
		 *         handelt. Dementsprechende Bildschirmanpassungen.
		 * */
		if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
			GraphicsDevice gd = GraphicsEnvironment
					.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			UseSystem = "Windows";
			SCREENWIDTH = gd.getDisplayMode().getWidth();
			SCREENHEIGHT = gd.getDisplayMode().getHeight();
		} else if (System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0) {
			System.out.println("linux");
			UseSystem = "Linux";
			SCREENWIDTH = 1280;
			SCREENHEIGHT = 1024;

		}

		Herox = (world.getClientAdmin().getClientHero()).getPosition()[0];
		Heroy = (world.getClientAdmin().getClientHero()).getPosition()[1];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				Items[i][j] = new SpaceHolderItem();
			}
		}

		for (int i = 0; i < 23; i++) {
			for (int j = 0; j < 11; j++) {
				Mapview[i][j] = new Tile(new SpaceHolder(1, 1), new Sand(1, 1),
						1, 1);
			}
		}

		setfog();
		this.TotalFog = getfog();

		for (int i = 0; i < 8; i++) {

			if (Herox - i >= 20 && Herox + i <= 120)
				Moveviewx = Herox - i;
		}
		for (int i = 0; i < 6; i++) {
			if (Heroy - i >= 20 && Heroy + i <= 120)
				Moveviewy = Heroy - i;
		}
		/**
		 * 
		 * @author Daniel Die folgendene Listener dienen nur der Erstellung der
		 *         Infoframes.
		 */
		// Knopf damit das Bild dem Helden folgt
		FOLLOWHEROAKTIVATE = new JButton("FA");
		FOLLOWHEROAKTIVATE.setFocusable(false);
		FOLLOWHEROAKTIVATE.addActionListener(this);
		FOLLOWHEROAKTIVATE.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Info = new ButtonInfoFrame(
							"Die Karte soll dem Helden folgen",
							SCREENWIDTH - 350, SCREENHEIGHT - 80);
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
		// Knopf zur deaktivierung des oberen
		FOLLOWHEROAKTIATEDEACTIVATE = new JButton("FD");
		FOLLOWHEROAKTIATEDEACTIVATE.setFocusable(false);
		FOLLOWHEROAKTIATEDEACTIVATE.addActionListener(this);
		FOLLOWHEROAKTIATEDEACTIVATE.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Info = new ButtonInfoFrame("Dem Helden nicht folgen",
							SCREENWIDTH - 350, SCREENHEIGHT - 80);
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

		JButton ShowBase = new JButton("SB");
		ShowBase.setFocusable(false);

		JButton ShowFriend = new JButton("SF");
		ShowFriend.setFocusable(false);
		// Button 1. Spezialattacke
		ImageIcon SSIcon = new ImageIcon("Images/Armor.gif");
		STRONGSTRIKE = new JButton("SS");
		STRONGSTRIKE.setFocusable(false);
		STRONGSTRIKE.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Info = new ButtonInfoFrame(HERO.getSkillNames()[0],
							SCREENWIDTH - 500, SCREENHEIGHT - 80);
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
		// Button 2. Spezialattacke
		ImageIcon MSIcon = new ImageIcon("Images/Armor.gif");
		MagicStrike = new JButton("MS");
		MagicStrike.setFocusable(false);
		MagicStrike.addActionListener(this);
		MagicStrike.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Info = new ButtonInfoFrame(HERO.getSkillNames()[1],
							SCREENWIDTH - 500, SCREENHEIGHT - 80);
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
		// Button 3. Spezialattacke
		ImageIcon ADIcon = new ImageIcon("Images/Armor.gif");
		AreaDamage = new JButton("AD");
		AreaDamage.setFocusable(false);
		AreaDamage.addActionListener(this);
		AreaDamage.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Info = new ButtonInfoFrame(HERO.getSkillNames()[2],
							SCREENWIDTH - 500, SCREENHEIGHT - 80);
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
		// Button Shop
		ImageIcon ShopIcon = new ImageIcon("Images/Shopblue.png");
		Shop = new JButton(ShopIcon);
		Shop.setFocusable(false);
		Shop.addActionListener(this);
		Shop.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!Infoshown) {
					Info = new ButtonInfoFrame("Shop", SCREENWIDTH - 500,
							SCREENHEIGHT - 80);
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
		// Button der ein Menu aufruft
		MENUBAR = new JButton("Menu");
		MENUBAR.setFocusable(false);
		MENUBAR.addActionListener(this);

		JLabel statusbar = new JLabel();

		// Panel in dem die tatsaechliche map zu sehen ist
		MAPAREA.setBackground(Color.black);
		this.add(MAPAREA, BorderLayout.CENTER);
		MAPAREA.setLayout(new BorderLayout());

		// konstruiere map
		// Bestimmung der Ansicht
		int x = moveviewxvalue(), y = moveviewyvalue();
		for (int i = 0; i < 23; i++) {
			for (int j = 0; j < 11; j++) {
				Mapview[i][j] = new Tile(new SpaceHolder(1, 1), new Sand(1, 1),
						1, 1);
				Mapview[i][j] = world.getMap()[x][y];
				y++;
			}
			y = moveviewyvalue();
			x++;
		}
		TrueMap = new LoLMap(Mapview, this.world, frame);
		TrueMap.setFocusable(true);
		TrueMap.setBackground(Color.black);
		MAPAREA.add(TrueMap, BorderLayout.CENTER);

		// Panel im oberen Bildschirmrand mit Menuknopf und Geldanzeige
		JPanel MenuBarPanel = new JPanel();
		MenuBarPanel.setBackground(Color.DARK_GRAY);
		this.add(MenuBarPanel, BorderLayout.NORTH);
		MenuBarPanel.setLayout(new BorderLayout());
		JPanel MenuBarArea = new JPanel();
		MenuBarArea.setBackground(Color.DARK_GRAY);
		MenuBarPanel.add(MenuBarArea, BorderLayout.WEST);
		// MONEY
		JPanel MPanel = new JPanel();
		MPanel.setLayout(new BorderLayout());
		MenuBarPanel.add(MPanel, BorderLayout.CENTER);

		MPanel.add(MoneyP, BorderLayout.CENTER);
		MenuBarArea.setLayout(new GridBagLayout());
		GridBagConstraints MenuButton = new GridBagConstraints();
		MenuButton.insets = new Insets(2, 2, 2, 2);
		MenuButton.gridx = 0;
		MenuButton.gridy = 0;
		MenuBarArea.add(MENUBAR, MenuButton);
		MenuBarPanel.add(statusbar, BorderLayout.EAST);

		// Unterer Tei der UI, in dem Leben, minimapp etc zu sehen sind
		JPanel LegendArea = new JPanel();
		LegendArea.setBackground(Color.DARK_GRAY);
		this.add(LegendArea, BorderLayout.SOUTH);
		LegendArea.setLayout(new BorderLayout());
		LegendArea.setBackground(Color.black);
		// bereich in dem minimap ist
		JPanel MiniMapArea = new JPanel();
		MiniMapArea.setBackground(Color.yellow);
		LegendArea.add(MiniMapArea, BorderLayout.EAST);
		MiniMapArea.setLayout(new BorderLayout());
		MiniMapArea.setBackground(Color.black);
		// Buttons neben der Minimap
		JPanel Buttonrow = new JPanel();
		Buttonrow.setBackground(Color.cyan);
		MiniMapArea.add(Buttonrow, BorderLayout.WEST);
		Buttonrow.setLayout(new GridBagLayout());
		Buttonrow.setBackground(Color.black);
		GridBagConstraints Buttons = new GridBagConstraints();
		Buttons.insets = new Insets(1, 1, 1, 1);
		Buttons.gridx = 0;
		Buttons.gridy = 0;
		Buttonrow.add(ShowFriend, Buttons);
		Buttons.gridy = 1;
		Buttonrow.add(FOLLOWHEROAKTIATEDEACTIVATE, Buttons);
		Buttons.gridy = 2;
		Buttonrow.add(FOLLOWHEROAKTIVATE, Buttons);
		Buttons.gridy = 3;
		Buttonrow.add(ShowBase, Buttons);
		// setzen der Minimap
		JPanel Map = new JPanel();
		MiniMapArea.add(Map, BorderLayout.CENTER);
		Map.setLayout(new BorderLayout());
		// konstruiere minimap
		MiniMap = new LoLminimap(world.getMap(), !Moveable, frame, world);
		MiniMap.setFocusable(true);
		MiniMap.setPreferredSize(new Dimension(100, 100));
		Map.add(MiniMap, BorderLayout.CENTER);
		JLabel SizeHelp = new JLabel(" Mini Map View ");
		SizeHelp.setFont(new Font("Arial", 0, 9));
		SizeHelp.setBackground(Color.black);
		Map.add(SizeHelp, BorderLayout.NORTH);

		MiniMap.setFocusable(false);
		// Panel in dem Leben und value und items und bilddes helden, Caht und
		// buttons fuer attacken
		JPanel HeroStuff = new JPanel();
		HeroStuff.setLayout(new BorderLayout());
		LegendArea.add(HeroStuff, BorderLayout.CENTER);
		JPanel StrikeButtonRow = new JPanel();
		// Panel fuer StrikeButtons und Chat
		JPanel MiddelPanel = new JPanel();
		MiddelPanel.setLayout(new BorderLayout());
		HeroStuff.add(MiddelPanel, BorderLayout.CENTER);
		MiddelPanel.add(StrikeButtonRow, BorderLayout.CENTER);
		// Chat
		JPanel ChatPanel = new JPanel();
		ChatPanel.setLayout(new BorderLayout());
		MiddelPanel.add(ChatPanel, BorderLayout.NORTH);
		TextArea = new JTextField(1);
		TextArea.setBackground(Color.GRAY);
		TextArea.setVisible(true);
		TextArea.addKeyListener(this);
		ChatPanel.add(TextArea, BorderLayout.SOUTH);
		// Strikebuttons
		StrikeButtonRow.setLayout(null);
		StrikeButtonRow.setBackground(Color.BLACK);
		STRONGSTRIKE.setBounds(60, 30, 60, 40);
		StrikeButtonRow.add(STRONGSTRIKE);
		STRONGSTRIKE.addActionListener(this);
		MagicStrike.setBounds(150, 30, 60, 40);
		StrikeButtonRow.add(MagicStrike);
		AreaDamage.setBounds(230, 30, 60, 40);
		StrikeButtonRow.add(AreaDamage);
		Shop.setBounds(350, 10, 80, 80);
		StrikeButtonRow.add(Shop);
		// Panel fuer Leben Items
		JPanel HeroLiveandItem = new JPanel();
		HeroLiveandItem.setLayout(new BorderLayout());
		HeroLiveandItem.setBackground(Color.DARK_GRAY);
		HeroStuff.add(HeroLiveandItem, BorderLayout.WEST);
		// PPanel fuer leben und mana und item
		JPanel HeroLiveandMana = new JPanel();
		HeroLiveandMana.setLayout(new BorderLayout());
		HeroLiveandMana.setBackground(Color.GRAY);
		HeroLiveandItem.add(HeroLiveandMana, BorderLayout.WEST);

		JPanel HeroLive = new JPanel();
		JPanel HeroItems = new JPanel();
		HeroLive.setBackground(Color.GRAY);
		HeroItems.setBackground(Color.LIGHT_GRAY);
		HeroLive.setLayout(new BorderLayout());
		HeroItems.setLayout(new BorderLayout());
		JLabel HeaderLive = new JLabel(" Leben und Mana ");
		JLabel HeaderItems = new JLabel(" gekaufte Items ");
		HeroItems.add(HeaderItems, BorderLayout.NORTH);
		JPanel HeroValues = new JPanel();
		HeroValues.setLayout(new BorderLayout());
		HeroValues.setBackground(Color.LIGHT_GRAY);
		JLabel HeaderValues = new JLabel(" Helden Werte ");
		HeroValues.add(HeaderValues, BorderLayout.NORTH);

		JPanel HeroLiveandValue = new JPanel();
		HeroLiveandValue.setLayout(new BorderLayout());
		HeroLiveandValue.setBackground(Color.black);

		HeroLive.add(HeaderLive, BorderLayout.NORTH);

		HeroLiveandMana.add(HeroLiveandValue, BorderLayout.WEST);
		HeroLiveandValue.add(HeroLive, BorderLayout.EAST);
		HeroLiveandValue.add(HeroValues, BorderLayout.WEST);

		HeroLiveandItem.add(HeroItems, BorderLayout.EAST);
		// Herolive und heroitems klassen adden
		Life = new HeroLife(world);
		HeroLive.add(Life, BorderLayout.CENTER);
		Item = new HeroItem(world, world.getClientAdmin().getClientHero(), true);
		Item.setBackground(Color.LIGHT_GRAY);
		HeroItems.add(Item, BorderLayout.CENTER);
		Value = new HeroValue(world);
		HeroValues.add(Value, BorderLayout.CENTER);
		// Panel fuer HeldenBild
		HEROIMAGE = new JPanel();
		LegendArea.add(HEROIMAGE, BorderLayout.WEST);
		HEROIMAGE.setBackground(Color.red);
		HEROIMAGE.setLayout(new BorderLayout());
		JLabel HeroimageTitel = new JLabel(" Hero: "
				+ ((world.getClientAdmin().getClientHero()).getHeroName())
				+ " ");
		HEROIMAGE.add(HeroimageTitel, BorderLayout.NORTH);
		HEROIMAGE.add(HEROVIEW, BorderLayout.CENTER);
		t.start();
		/**
		 * 
		 * @author Daniel Timer und Listener, die die Zeit zusammen mit dem
		 *         MoneyPanel bestimmt.
		 */
		Timer gametimer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				gametime++;
				MoneyP.counttime();

				if (FSATime + 10 <= gametime)
					STRONGSTRIKE.setEnabled(true);
				if (SSATime + 10 <= gametime)
					MagicStrike.setEnabled(true);
				if (TSATime + 10 <= gametime)
					AreaDamage.setEnabled(true);
			}
		});
		gametimer.start();

		HEROVIEW.setworld(world);
		sound.play(1);

	}

	private Graphics g;

	public void paint(Graphics g, int x, int y) {
		Graphics surfacMiniMap = MiniMap.getGraphics();

		Graphics surfaceMap = TrueMap.getGraphics();

	}

	/**
	 * 
	 * @author Daniel Diese Klasse updatet regelmaessig die Karte, die Ansicht,
	 *         etc..
	 */
	public void updatemap() {

		Herox = world.getEntities()
				.get(world.getClientAdmin().getClientHero().getID())
				.getPosition()[0];
		Heroy = world.getEntities()
				.get(world.getClientAdmin().getClientHero().getID())
				.getPosition()[1];
		Item.setItems();
		if (!Moveable) {
			for (int i = 0; i < 8; i++) {

				if (Herox - i >= 20 && Herox + i <= 120)
					Moveviewx = Herox - i;
			}
			for (int i = 0; i < 6; i++) {
				if (Heroy - i >= 20 && Heroy + i <= 120)
					Moveviewy = Heroy - i;
			}
		}
		int x, y;
		x = moveviewxvalue();
		y = moveviewyvalue();
		for (int i = 0; i < 23; i++) {
			for (int j = 0; j < 11; j++) {
				Mapview[i][j] = new Tile(new SpaceHolder(1, 1), new Sand(1, 1),
						1, 1);
				Mapview[i][j] = world.getMap()[x][y];
				y++;
			}
			y = moveviewyvalue();
			x++;
		}
		setfog();

	}

	/**
	 * 
	 * @author Daniel Diese Klasse bestimmt wo der Nebel gesetzt wird.
	 * */
	public void setfog() {

		int[][] Fog = new int[140][140];

		for (int i = 0; i < 140; i++) {
			for (int j = 0; j < 140; j++) {
				Fog[i][j] = 0;

			}
		}
		for (int i = 0; i < 140; i++) {
			for (int j = 0; j < 140; j++) {
				if ((world.getMap()[i][j].getobject() instanceof Figure || world
						.getMap()[i][j].getobject() instanceof Building)) {
					InteraktiveEntity object = (InteraktiveEntity) world
							.getMap()[i][j].getobject();
					if (object.getTeam().equals(
							world.getClientAdmin().getTeam()))
						Fog[i][j] = 1;
				}
			}
		}
		for (int i = 20; i < 120; i++) {
			for (int j = 20; j < 120; j++) {
				if (Fog[i][j] == 1
						&& (world.getMap()[i][j].getobject() instanceof Figure || world
								.getMap()[i][j].getobject() instanceof Building)) {
					InteraktiveEntity object = (InteraktiveEntity) world
							.getMap()[i][j].getobject();
					for (int k = -object.getVisibilityRange(); k < object
							.getVisibilityRange(); k++) {
						for (int l = -object.getVisibilityRange(); l < object
								.getVisibilityRange(); l++) {
							if (i + k >= 0 && j + l >= 0 && i + k < 140
									&& j + l < 140)
								if (k * k + l * l <= object
										.getVisibilityRange()
										* object.getVisibilityRange())
									Fog[i + k][j + l] = 2;

						}
					}
				}
			}
		}
		for (int i = 0; i < 140; i++) {
			for (int j = 0; j < 140; j++) {
				if (Fog[i][j] == 2)
					SemiFog[i][j] = 3;
			}
		}
		TotalFog = Fog;
		repaint();
	}

	public int[][] getfog() {
		return TotalFog;
	}

	public int[][] getsemifog() {
		return SemiFog;
	}

	public int moveviewxvalue() {
		// Moveviewx ist die position an der die view anfaengt horizontal
		return Moveviewx;
	}

	public int moveviewyvalue() {
		// Moveviewy ist die position an der die view anfaengt vertikal
		return Moveviewy;
	}

	/**
	 * 
	 * @author Daniel Diese Methode schließt den Ingame Frame
	 * */
	public void closeframe() {
		frame.setVisible(false);
		frame.dispose();
	}

	// ----------------------Mouselistener

	@Override
	public void mouseClicked(MouseEvent e) {

		System.out.println("x:" + e.getY() + "y:" + e.getY());
		System.out.println(SCREENHEIGHT);
		System.out.println(this.getHeight());

		int MiniMapStarty = SCREENHEIGHT - 100;
		int MiniMapStartx = SCREENWIDTH - 100;
		if (UseSystem == "Linux") {
			MiniMapStarty = this.getHeight() - 100;
			MiniMapStartx = SCREENWIDTH - 100;
		}

		TrueMap.clearChat();
		// lscht den Inhalt des jtextfield
		/**
		 * 
		 * @author Daniel Hier gehen wir in den Teil des Listeners der fuer die
		 *         Klickbare MiniMap zustaendig ist
		 * */
		if (e.getX() > MiniMapStartx && e.getY() > MiniMapStarty) {
			System.out.println("Minima");
			if (Moveable) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					int MiniMapTilex, MiniMapTiley;
					MiniMapTilex = 100 + (e.getX() - SCREENWIDTH);
					MiniMapTiley = 100 + (e.getY() - SCREENHEIGHT);
					if (UseSystem == "Linux")
						MiniMapTiley = 100 + (e.getY() - this.getHeight());

					Moveviewx = MiniMapTilex + 20;
					Moveviewy = MiniMapTiley + 20;
					if (Moveviewx > 100)
						Moveviewx = 99;
					if (Moveviewy > 110)
						Moveviewy = 111;
					int x = moveviewxvalue(), y = moveviewyvalue();

					for (int i = 0; i < 23; i++) {
						for (int j = 0; j < 11; j++) {

							Mapview[i][j] = world.getMap()[x][y];
							y++;

						}
						y = moveviewyvalue();
						x++;
					}
				}

			}
			if (e.getButton() == MouseEvent.BUTTON3) {
				int Tilex, Tiley;
				;
				Tilex = 100 + (e.getX() - SCREENWIDTH) + 20;

				Tiley = 100 + (e.getY() - SCREENHEIGHT) + 20;
				if (UseSystem == "Linux")
					Tiley = 100 + (e.getY() - this.getHeight()) + 20;

				int tile[] = { Tilex, Tiley };

				Klickinfoframe Klick;

				EventManager.callEvent(new MoveEvent((world.getClientAdmin()
						.getClientNr()), tile));

			}
			setfog();
		}
		// Kachel bestimmen auf die gedrckt wurde
		/**
		 * 
		 * @author Daniel Hier gehen wir in den Teil des Listeners der fuer die
		 *         SpielANsicht zustaendig ist
		 * */
		if (!(e.getX() > MiniMapStartx && e.getY() > MiniMapStarty)) {
			// Kachel bestimmen auf die gedrckt wurde
			int Tilex, Tiley;
			String Mouse = "";
			Tilex = 0;
			Tiley = 0;
			for (int i = 0; i < 25; i++) {
				if (e.getX() >= (i) * 80 && e.getX() < (i + 1) * 80)
					Tilex = i;
				if (e.getY() - 30 >= (i) * 80 && e.getY() - 30 < (i + 1) * 80)
					Tiley = i;
			}

			int tile[] = { Tilex + moveviewxvalue(), Tiley + moveviewyvalue() };
			int Tiley1 = (e.getY() - 30) / 80;
			int Tilex1 = e.getX() / 80;
			int tile2[] = { Tilex1, Tiley1 };

			TrueMap.setMove(tile2);
			if (e.getButton() == MouseEvent.BUTTON1)
				Mouse = "left";
			if (e.getButton() == MouseEvent.BUTTON3)
				Mouse = "right";

			if (!world.getMap()[Tilex + moveviewxvalue()][Tiley
					+ moveviewyvalue()].isBlocked()) {
				EventManager.callEvent(new MoveEvent((world.getClientAdmin()
						.getClientNr()), tile));
			}
			if (world.getMap()[Tilex + moveviewxvalue()][Tiley
					+ moveviewyvalue()].getobject() instanceof InteraktiveEntity
					&& !(world.getMap()[Tilex + moveviewxvalue()][Tiley
							+ moveviewyvalue()].getobject() instanceof Shop)
					&& !((InteraktiveEntity) world.getMap()[Tilex
							+ moveviewxvalue()][Tiley + moveviewyvalue()]
							.getobject()).getTeam().equals(
							world.getClientAdmin().getClientHero().getTeam())) {
				InteraktiveEntity entity = (InteraktiveEntity) world.getMap()[Tilex
						+ moveviewxvalue()][Tiley + moveviewyvalue()]
						.getobject();
				Communication.newServerMessage(new AttackEvent((world
						.getClientAdmin().getClientNr()), entity.getID()));
			}

			// Kommunikation mit client engine

		}
		setfog();
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent f) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	// ---------------------------------------Keylistener
	public void keyPressed(KeyEvent f) {
		int key = f.getKeyCode();
		/**
		 * 
		 * @author Daniel Hier gehen wir in den Teil des Listeners der fuer den
		 *         Chat verantwortlich ist
		 * */
		if (f.getSource() == TextArea) {
			// aktionene im CHat

			if (key == KeyEvent.VK_ENTER) {
			if(!TextArea.getText().equals("sicht")&&!TextArea.getText().equals("klaresicht")&&!TextArea.getText().equals("nebel"))

				Communication.newServerMessage(new ChatEvent(world.getClientAdmin().getClientNr(), TextArea.getText()));
				// cheats-----------------
				if (TextArea.getText().equals("sicht")) {
					TrueMap.setfog(false);
				}
				if (TextArea.getText().equals("klaresicht")) {
					TrueMap.setfog(false);
					MiniMap.setfog(false);
				}
				if (TextArea.getText().equals("nebel")) {
					TrueMap.setfog(true);
					MiniMap.setfog(true);
				}
				if (TextArea.getText().equals("DanielderReiche")) {
					world.getClientAdmin().getClientHero().changeMoney(1000);
				}
				if (TextArea.getText().equals("DanielderGesunde")) {
					world.getClientAdmin().getClientHero().change_Akt_Life(100);
				}
				if (TextArea.getText().equals("DanielderStarke")) {
					world.getClientAdmin().getClientHero().increaseValue(1, 20);
				}
				// -------------------------
				TextArea.setText("");
				TrueMap.setChat(Chat);

			}

		}
		/**
		 * 
		 * @author Daniel Hier gehen wir in den Teil des Listeners der fuer die
		 *         Spielsteuerung verantwortlich ist.
		 * */
		if (f.getSource() != TextArea) {
			// Aktionen ausserhalb des chat

			// Spezialattacke 1
			if (f.getKeyCode() == KeyEvent.VK_Q) {
				EventManager.callEvent(new SpecialAttackEvent(world
						.getClientAdmin().getClientNr(), World.spezAttacks
						.get(world.getClientAdmin().getClientHero()
								.getSkillNames()[0])));
				repaint();
				FSATime = gametime;
				STRONGSTRIKE.setEnabled(false);
			}
			// Spezialattacke 2
			if (f.getKeyCode() == KeyEvent.VK_W) {

				EventManager.callEvent(new SpecialAttackEvent(world
						.getClientAdmin().getClientNr(), World.spezAttacks
						.get(world.getClientAdmin().getClientHero()
								.getSkillNames()[1])));
				repaint();
				SSATime = gametime;
				MagicStrike.setEnabled(false);
			}
			// Spezialattacke 3
			if (f.getKeyCode() == KeyEvent.VK_E) {

				EventManager.callEvent(new SpecialAttackEvent(world
						.getClientAdmin().getClientNr(), World.spezAttacks
						.get(world.getClientAdmin().getClientHero()
								.getSkillNames()[2])));
				repaint();
				TSATime = gametime;
				AreaDamage.setEnabled(false);
			}
			// InGame Statistik loeschen
			if (f.getKeyCode() == KeyEvent.VK_5) {
				HeroItem ITEM1 = new HeroItem(world, world.getClientAdmin()
						.getClientHero(), true);

				InGameStat = new InGameStatistic(world, ITEM1);

			}
			if (f.getKeyCode() == KeyEvent.VK_1) {
				// itmes 1 events
				EventManager.callEvent(new PotionEvent(world.getClientAdmin()
						.getClientNr(), true));

				repaint();
			}
			if (f.getKeyCode() == KeyEvent.VK_2) {
				EventManager.callEvent(new PotionEvent(world.getClientAdmin()
						.getClientNr(), false));
				// itmes 1 events
				repaint();
			}
			if (f.getKeyCode() == KeyEvent.VK_Z) {
				(world.getClientAdmin().getClientHero()).setattack(true);
				repaint();
			}
			// bewegung per pfeiltasten
			/**
			 * Hier kann man den Helden per Pfeiltasten bewegen, allerdings
			 * momentan nicht einkommentiert
			 * 
			 * 
			 * */
			// if (f.getKeyCode() == KeyEvent.VK_RIGHT ) {
			// int []
			// target={(world.getClientAdmin().getClientHero()).getPosition()[0]+5,(world.getClientAdmin().getClientHero()).getPosition()[1]};
			// ((Figure)
			// world.getClientAdmin().getClientHero()).settarget(target);
			// (world.getClientAdmin().getClientHero()).setdirection(2);
			// (world.getClientAdmin().getClientHero()).setAttackdirection(2);
			//
			// int[]targethit={(world.getClientAdmin().getClientHero()).getPosition()[0]+10,
			// (world.getClientAdmin().getClientHero()).getPosition()[1]};
			// world.getClientAdmin().getClientHero().settarget(targethit);
			//
			// repaint();
			//
			// }
			//
			// if (f.getKeyCode() == KeyEvent.VK_DOWN ) {
			// int []
			// target={(world.getClientAdmin().getClientHero()).getPosition()[0],(world.getClientAdmin().getClientHero()).getPosition()[1]+5};
			// ((Figure)
			// world.getClientAdmin().getClientHero()).settarget(target);
			//
			// (world.getClientAdmin().getClientHero()).setAttackdirection(4);
			//
			// int[]targethit={(world.getClientAdmin().getClientHero()).getPosition()[0],
			// (world.getClientAdmin().getClientHero()).getPosition()[1]+10};
			// world.getClientAdmin().getClientHero().settarget(targethit);
			//
			//
			// repaint();
			// }
			// if (f.getKeyCode() == KeyEvent.VK_LEFT ){
			// int []
			// target={(world.getClientAdmin().getClientHero()).getPosition()[0]-5,(world.getClientAdmin().getClientHero()).getPosition()[1]};
			// ((Figure)
			// world.getClientAdmin().getClientHero()).settarget(target);
			//
			// (world.getClientAdmin().getClientHero()).setdirection(1);
			// (world.getClientAdmin().getClientHero()).setAttackdirection(1);
			//
			// int[]targethit={(world.getClientAdmin().getClientHero()).getPosition()[0]-10,
			// (world.getClientAdmin().getClientHero()).getPosition()[1]};
			// world.getClientAdmin().getClientHero().settarget(targethit);
			//
			//
			// }
			// if (f.getKeyCode() == KeyEvent.VK_UP ){
			// int []
			// target={(world.getClientAdmin().getClientHero()).getPosition()[0],(world.getClientAdmin().getClientHero()).getPosition()[1]-5};
			// ((Figure)
			// world.getClientAdmin().getClientHero()).settarget(target);
			//
			// (world.getClientAdmin().getClientHero()).setAttackdirection(3);
			//
			// int[]targethit={(world.getClientAdmin().getClientHero()).getPosition()[0],
			// (world.getClientAdmin().getClientHero()).getPosition()[1]-10};
			// world.getClientAdmin().getClientHero().settarget(targethit);
			//
			//
			//
			// repaint();
			// }
			/**
			 * Hier kann man das Ziel der Angriffe per Tasen setzen. Allerdings
			 * nur ein Ueberbleibsel aus der Testzeit dass nicht geloescht
			 * wurde.
			 * 
			 * 
			 * */
			if (f.getKeyCode() == KeyEvent.VK_I) {
				// obenrechts
				int[] targethit = {
						(world.getClientAdmin().getClientHero()).getPosition()[0] - 10,
						(world.getClientAdmin().getClientHero()).getPosition()[1] - 10 };
				world.getClientAdmin().getClientHero().settarget(targethit);

				repaint();
			}
			if (f.getKeyCode() == KeyEvent.VK_K) {
				// untenlinks
				int[] targethit = {
						(world.getClientAdmin().getClientHero()).getPosition()[0] - 10,
						(world.getClientAdmin().getClientHero()).getPosition()[1] + 10 };
				world.getClientAdmin().getClientHero().settarget(targethit);

				repaint();
			}
			if (f.getKeyCode() == KeyEvent.VK_O) {
				// obenlinks
				int[] targethit = {
						(world.getClientAdmin().getClientHero()).getPosition()[0] + 10,
						(world.getClientAdmin().getClientHero()).getPosition()[1] - 10 };
				world.getClientAdmin().getClientHero().settarget(targethit);

				repaint();
			}
			if (f.getKeyCode() == KeyEvent.VK_L) {
				// untenlinks
				int[] targethit = {
						(world.getClientAdmin().getClientHero()).getPosition()[0] + 10,
						(world.getClientAdmin().getClientHero()).getPosition()[1] + 10 };
				world.getClientAdmin().getClientHero().settarget(targethit);

				repaint();
			}
		}
		setfog();
		repaint();
		/**
		 * 
		 * Hier findet das Scrollen der Ansciht mit den Pfeiltasten statt.
		 * 
		 * */
		if (Moveable) {
			if (f.getKeyCode() == KeyEvent.VK_LEFT && moveviewxvalue() >= 20) {

				Moveviewx--;
				Endx--;

				int x = moveviewxvalue(), y = moveviewyvalue();
				for (int i = 0; i < 23; i++) {
					for (int j = 0; j < 11; j++) {
						Mapview[i][j] = world.getMap()[x][y];
						y++;
					}
					y = moveviewyvalue();
					x++;
				}
				repaint();
			}
			if (f.getKeyCode() == KeyEvent.VK_UP && moveviewyvalue() >= 20) {

				Moveviewy--;
				Endy--;
				int x = moveviewxvalue(), y = moveviewyvalue();
				for (int i = 0; i < 23; i++) {
					for (int j = 0; j < 11; j++) {
						Mapview[i][j] = world.getMap()[x][y];
						y++;
					}
					y = moveviewyvalue();
					x++;
				}

				repaint();
			}
			if (f.getKeyCode() == KeyEvent.VK_DOWN && Endy < 120
					&& Moveviewy < 110) {

				Moveviewy++;
				Endy++;
				int x = moveviewxvalue(), y = moveviewyvalue();
				for (int i = 0; i < 23; i++) {
					for (int j = 0; j < 11; j++) {
						Mapview[i][j] = world.getMap()[x][y];
						y++;
					}
					y = moveviewyvalue();
					x++;
				}
				repaint();
			}
			if (f.getKeyCode() == KeyEvent.VK_RIGHT && Endx < 120
					&& Moveviewx < 110) {

				Moveviewx++;

				Endx++;
				int x = moveviewxvalue(), y = moveviewyvalue();
				for (int i = 0; i < 23; i++) {
					for (int j = 0; j < 11; j++) {
						Mapview[i][j] = world.getMap()[x][y];
						y++;
					}
					y = moveviewyvalue();
					x++;
				}
				repaint();
			}

		}
		setfog();
	}

	@Override
	public void keyReleased(KeyEvent f) {

	}

	@Override
	public void keyTyped(KeyEvent f) {

	}

	// --------ActionListener

	@Override
	public void actionPerformed(ActionEvent e) {
		updatemap();

		setfog();
		if (!Moveable) {
			for (int i = 0; i < 8; i++) {

				if (Herox - i >= 20 && Herox - i <= 101)
					Moveviewx = Herox - i;
			}
			for (int i = 0; i < 6; i++) {
				if (Heroy - i >= 20 && Heroy - i <= 111)
					Moveviewy = Heroy - i;
			}
			int x = moveviewxvalue(), y = moveviewyvalue();

			for (int i = 0; i < 23; i++) {
				for (int j = 0; j < 11; j++) {

					Mapview[i][j] = world.getMap()[x][y];
					y++;
					//
				}
				y = moveviewyvalue();
				x++;

			}
		}
		// menuframeerzeugen
		if (e.getSource() == MENUBAR)
			MenuFrame = new Menu(frame, world, this, Item);
		// oeffnen des Shop
		if (e.getSource() == Shop) {

			if (world.getClientAdmin().getClientHero().getTeam()
					.equals(Team.RED)) {
				if (Herox >= 100 && Heroy <= 40) {
					if (FirstTimeShop) {
						Shopframe = new Shop_GUI(world.getClientAdmin()
								.getClientNr());
						FirstTimeShop = false;
					} else
						Shopframe.setVisible(true);
					Item.setItems();
				} else {
					EventManager.callEvent(new InfoEvent(world.getClientAdmin()
							.getClientNr(), "Shop nicht in Reichweite!"));
				}
			}
			if (world.getClientAdmin().getClientHero().getTeam()
					.equals(Team.BLUE)) {
				if (Heroy >= 100 && Herox <= 40) {
					if (FirstTimeShop) {
						Shopframe = new Shop_GUI(world.getClientAdmin()
								.getClientNr());
						FirstTimeShop = false;
					} else
						Shopframe.setVisible(true);
					Item.setItems();
				}

				else {
					EventManager.callEvent(new InfoEvent(world.getClientAdmin()
							.getClientNr(), "Shop nicht in Reichweite!"));
				}

			}

		}// spezialattacke 1
		if (e.getSource() == STRONGSTRIKE) {
			sound.play(1);
			EventManager.callEvent(new SpecialAttackEvent(world
					.getClientAdmin().getClientNr(),
					World.spezAttacks.get(world.getClientAdmin()
							.getClientHero().getSkillNames()[0])));
			repaint();
			FSATime = gametime;
			STRONGSTRIKE.setEnabled(false);
		}
		// spezialattacke 2
		if (e.getSource() == MagicStrike) {

			EventManager.callEvent(new SpecialAttackEvent(world
					.getClientAdmin().getClientNr(),
					World.spezAttacks.get(world.getClientAdmin()
							.getClientHero().getSkillNames()[1])));
			repaint();
			SSATime = gametime;
			MagicStrike.setEnabled(false);
		}
		// spezialattacke 3
		if (e.getSource() == AreaDamage) {

			EventManager.callEvent(new SpecialAttackEvent(world
					.getClientAdmin().getClientNr(),
					World.spezAttacks.get(world.getClientAdmin()
							.getClientHero().getSkillNames()[2])));
			repaint();
			TSATime = gametime;
			AreaDamage.setEnabled(false);
		}
		// reaktion auf button fa
		if (e.getSource() == FOLLOWHEROAKTIVATE) {

			System.out.println("hier sollte es hingehen die view:"
					+ world.getClientAdmin().getClientHero().getPosition()[0]
					+ "hiiieerr y"
					+ world.getClientAdmin().getClientHero().getPosition()[1]);
			EventManager.callEvent(new InfoEvent(world.getClientAdmin()
					.getClientNr(), "Dem Helden wird gefolgt!"));

			for (int i = 0; i < 8; i++) {

				if (Herox - i >= 20 && Herox + i <= 120)
					Moveviewx = Herox - i;
			}
			for (int i = 0; i < 6; i++) {

				if (Heroy - i >= 20 && Heroy + i <= 120)
					Moveviewy = Heroy - i;
				repaint();
			}

			MiniMap.setfollowhero(true);
			Moveable = false;
			int x = moveviewxvalue();
			int y = moveviewyvalue();
			for (int i = 0; i < 23; i++) {
				for (int j = 0; j < 11; j++) {
					Mapview[i][j] = world.getMap()[x][y];
					y++;
				}
				y = moveviewyvalue();
				x++;
			}

			repaint();

		}
		// reaktion auf button fd
		if (e.getSource() == FOLLOWHEROAKTIATEDEACTIVATE) {

			EventManager.callEvent(new InfoEvent(world.getClientAdmin()
					.getClientNr(), "Dem Helden wird nicht mehr gefolgt!"));

			Moveable = true;
			int x = moveviewxvalue();
			int y = moveviewyvalue();
			for (int i = 0; i < 23; i++) {
				for (int j = 0; j < 11; j++) {

					Mapview[i][j] = world.getMap()[x][y];
					y++;
				}
				y = moveviewyvalue();
				x++;
			}

			MiniMap.setfollowhero(false);
			repaint();

		}
		setfog();
		repaint();

	}

	// ----------MouseMotion
	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void mouseMoved(MouseEvent m) {

		// Mapview mit maus an den Rand bewegen, wenn nicht followhero
		// aktiviert, leider nur noch unter Windows total funktionstuechtig
		if (Moveable) {
			if (m.getX() == 0 && moveviewxvalue() >= 20) {

				Moveviewx--;
				Endx--;

				int x = moveviewxvalue(), y = moveviewyvalue();
				for (int i = 0; i < 23; i++) {
					for (int j = 0; j < 11; j++) {
						Mapview[i][j] = world.getMap()[x][y];
						y++;
					}
					y = moveviewyvalue();
					x++;
				}
				repaint();
			}
			if (m.getY() == 0 && moveviewyvalue() >= 20) {

				Moveviewy--;
				Endy--;
				int x = moveviewxvalue(), y = moveviewyvalue();
				for (int i = 0; i < 23; i++) {
					for (int j = 0; j < 11; j++) {
						Mapview[i][j] = world.getMap()[x][y];
						y++;
					}
					y = moveviewyvalue();
					x++;
				}

				repaint();
			}
			if (m.getY() == SCREENHEIGHT - 1 && Endy < 120 && Moveviewy < 110) {

				Moveviewy++;
				Endy++;
				int x = moveviewxvalue(), y = moveviewyvalue();
				for (int i = 0; i < 23; i++) {
					for (int j = 0; j < 11; j++) {
						Mapview[i][j] = world.getMap()[x][y];
						y++;
					}
					y = moveviewyvalue();
					x++;
				}
				repaint();
			}
			if (m.getX() == SCREENWIDTH - 1 && Endx < 120 && Moveviewx < 100) {

				Moveviewx++;

				Endx++;
				int x = moveviewxvalue(), y = moveviewyvalue();
				for (int i = 0; i < 23; i++) {
					for (int j = 0; j < 11; j++) {
						Mapview[i][j] = world.getMap()[x][y];
						y++;
					}
					y = moveviewyvalue();
					x++;
				}
				repaint();
			}
		}

	}

}
