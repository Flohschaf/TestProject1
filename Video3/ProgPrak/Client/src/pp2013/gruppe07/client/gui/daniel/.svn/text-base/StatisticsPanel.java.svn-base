package pp2013.gruppe07.client.gui.daniel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.UUID;

import javax.swing.JLabel;
import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.World;
import pp2013.gruppe07.shared.entity.DangerDan;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.eventManager.EventListener;
import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * 
 * @author Daniel Diese Klasse erstellt Statistiken nach dem spiel, eigentliche
 *         eine reine Anzeige Klasse.
 */

public class StatisticsPanel extends JPanel implements EventListener {

	private HeroImage HeroImage;
	private HeroValue HEROVALUE;
	private KillStatistic Killstat;
	private HeroItem Items;

	private Hero Default = new DangerDan(UUID.randomUUID(), 1, 1, Team.NEUTRAL,
			true);
	private HeroImage HeroImagePlayer1;
	private HeroValue HeroValuePlayer1;
	private Killstatothers KillStatPlayer1;
	private HeroItem ItemPlayer1;

	private HeroImage HeroImagePlayer2;
	private HeroValue HeroValuePlayer2;
	private Killstatothers KillStatPlayer2;
	private HeroItem ItemPlayer2;

	private HeroImage HeroImagePlayer3;
	private HeroValue HeroValuePlayer3;
	private Killstatothers KillStatPlayer3;
	private HeroItem ItemPlayer3;

	private HeroImage HeroImagePlayer4;
	private HeroValue HeroValuePlayer4;
	private Killstatothers KillStatPlayer4;
	private HeroItem ItemPlayer4;

	private HeroImage HeroImagePlayer5;
	private HeroValue HeroValuePlayer5;
	private Killstatothers KillStatPlayer5;
	private HeroItem ItemPlayer5;

	private HeroImage HeroImagePlayer6;
	private HeroValue HeroValuePlayer6;
	private Killstatothers KillStatPlayer6;
	private HeroItem ItemPlayer6;

	private HeroImage HeroImagePlayer7;
	private HeroValue HeroValuePlayer7;
	private Killstatothers KillStatPlayer7;
	private HeroItem ItemPlayer7;

	private HeroImage HeroImagePlayer8;
	private HeroValue HeroValuePlayer8;
	private Killstatothers KillStatPlayer8;
	private HeroItem ItemPlayer8;
	private UUID[] Heroes = new UUID[8];

	private World world;

	public StatisticsPanel(World world, HeroItem items) {
		super.setSize(40, 40);
		this.world = world;
		this.setBackground(Color.BLUE);
		this.setVisible(false);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1000, 1000));

		for (int i = 0; i <= 7; i++) {
			{

				Heroes[i] = null;

			}
		}

		int m = 0;
		for (int i = 20; i <= 120; i++) {
			for (int j = 20; j <= 120; j++) {
				if (world.getMap()[i][j].getobject() instanceof Hero) {
					Heroes[m] = ((InteraktiveEntity) world.getMap()[i][j]
							.getobject()).getID();
					m++;

				}
			}
		}

		HeroImage = new HeroImage((world.getClientAdmin().getClientHero()));
		HeroImage.setPreferredSize(new Dimension(100, 100));
		HEROVALUE = new HeroValue(world);
		HEROVALUE.setPreferredSize(new Dimension(100, 100));
		Killstat = new KillStatistic(
				(pp2013.gruppe07.shared.entity.Hero) (world.getClientAdmin()
						.getClientHero()));
		Killstat.setPreferredSize(new Dimension(400, 100));
		Items = items;
		Items.setPreferredSize(new Dimension(100, 100));

		if (Heroes[0] != null) {
			HeroImagePlayer1 = new HeroImage((Hero) world.getEntities().get(
					Heroes[0]));
			HeroImagePlayer1.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer1 = new HeroValue(world);
			HeroValuePlayer1.setPreferredSize(new Dimension(100, 100));
			ItemPlayer1 = new HeroItem(world, (Hero) world.getEntities().get(
					Heroes[0]), false);
			ItemPlayer1.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer1 = new Killstatothers((Hero) world.getEntities()
					.get(Heroes[0]));
			KillStatPlayer1.setPreferredSize(new Dimension(100, 100));

		} else {

			HeroImagePlayer1 = new HeroImage(Default);
			HeroImagePlayer1.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer1 = new HeroValue(world);
			HeroValuePlayer1.setPreferredSize(new Dimension(100, 100));
			ItemPlayer1 = new HeroItem(world, Default, false);
			ItemPlayer1.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer1 = new Killstatothers(
					(pp2013.gruppe07.shared.entity.Hero) Default);
			KillStatPlayer1.setPreferredSize(new Dimension(100, 100));

		}

		if (Heroes[1] != null) {
			HeroImagePlayer2 = new HeroImage((Hero) world.getEntities().get(
					Heroes[1]));
			HeroImagePlayer2.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer2 = new HeroValue(world);
			HeroValuePlayer2.setPreferredSize(new Dimension(100, 100));
			ItemPlayer2 = new HeroItem(world, (Hero) world.getEntities().get(
					Heroes[1]), false);
			ItemPlayer2.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer2 = new Killstatothers((Hero) world.getEntities()
					.get(Heroes[1]));
			KillStatPlayer2.setPreferredSize(new Dimension(100, 100));
		} else {
			HeroImagePlayer2 = new HeroImage(Default);
			HeroImagePlayer2.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer2 = new HeroValue(world);
			HeroValuePlayer2.setPreferredSize(new Dimension(100, 100));
			ItemPlayer2 = new HeroItem(world, Default, false);
			ItemPlayer2.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer2 = new Killstatothers(
					(pp2013.gruppe07.shared.entity.Hero) Default);
			KillStatPlayer2.setPreferredSize(new Dimension(100, 100));

		}
		if (Heroes[2] != null) {
			HeroImagePlayer3 = new HeroImage((Hero) world.getEntities().get(
					Heroes[2]));
			HeroImagePlayer3.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer3 = new HeroValue(world);
			HeroValuePlayer3.setPreferredSize(new Dimension(100, 100));
			ItemPlayer3 = new HeroItem(world, (Hero) world.getEntities().get(
					Heroes[2]), false);
			ItemPlayer3.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer3 = new Killstatothers((Hero) world.getEntities()
					.get(Heroes[2]));
			KillStatPlayer3.setPreferredSize(new Dimension(100, 100));
		} else {
			HeroImagePlayer3 = new HeroImage(Default);
			HeroImagePlayer3.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer3 = new HeroValue(world);
			HeroValuePlayer3.setPreferredSize(new Dimension(100, 100));
			ItemPlayer3 = new HeroItem(world, Default, false);
			ItemPlayer3.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer3 = new Killstatothers(
					(pp2013.gruppe07.shared.entity.Hero) Default);
			KillStatPlayer3.setPreferredSize(new Dimension(100, 100));

		}
		if (Heroes[3] != null) {
			HeroImagePlayer4 = new HeroImage((Hero) world.getEntities().get(
					Heroes[3]));
			HeroImagePlayer4.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer4 = new HeroValue(world);
			HeroValuePlayer4.setPreferredSize(new Dimension(100, 100));
			ItemPlayer4 = new HeroItem(world, (Hero) world.getEntities().get(
					Heroes[3]), false);
			ItemPlayer4.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer4 = new Killstatothers((Hero) world.getEntities()
					.get(Heroes[3]));
			KillStatPlayer4.setPreferredSize(new Dimension(100, 100));
		} else {
			HeroImagePlayer4 = new HeroImage(Default);
			HeroImagePlayer4.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer4 = new HeroValue(world);
			HeroValuePlayer4.setPreferredSize(new Dimension(100, 100));
			ItemPlayer4 = new HeroItem(world, Default, false);
			ItemPlayer4.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer4 = new Killstatothers(
					(pp2013.gruppe07.shared.entity.Hero) Default);
			KillStatPlayer4.setPreferredSize(new Dimension(100, 100));
		}
		if (Heroes[4] != null) {
			HeroImagePlayer5 = new HeroImage((Hero) world.getEntities().get(
					Heroes[4]));
			HeroImagePlayer5.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer5 = new HeroValue(world);
			HeroValuePlayer5.setPreferredSize(new Dimension(100, 100));
			ItemPlayer5 = new HeroItem(world, (Hero) world.getEntities().get(
					Heroes[4]), false);
			ItemPlayer5.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer5 = new Killstatothers((Hero) world.getEntities()
					.get(Heroes[4]));
			KillStatPlayer5.setPreferredSize(new Dimension(100, 100));
		} else {
			HeroImagePlayer5 = new HeroImage(Default);
			HeroImagePlayer5.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer5 = new HeroValue(world);
			HeroValuePlayer5.setPreferredSize(new Dimension(100, 100));
			ItemPlayer5 = new HeroItem(world, Default, false);
			ItemPlayer5.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer5 = new Killstatothers(
					(pp2013.gruppe07.shared.entity.Hero) Default);
			KillStatPlayer5.setPreferredSize(new Dimension(100, 100));

		}
		if (Heroes[5] != null) {
			HeroImagePlayer6 = new HeroImage((Hero) world.getEntities().get(
					Heroes[5]));
			HeroImagePlayer6.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer6 = new HeroValue(world);
			HeroValuePlayer6.setPreferredSize(new Dimension(100, 100));
			ItemPlayer6 = new HeroItem(world, (Hero) world.getEntities().get(
					Heroes[5]), false);
			ItemPlayer6.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer6 = new Killstatothers((Hero) world.getEntities()
					.get(Heroes[5]));
			KillStatPlayer6.setPreferredSize(new Dimension(100, 100));
		} else {
			HeroImagePlayer6 = new HeroImage(Default);
			HeroImagePlayer6.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer6 = new HeroValue(world);
			HeroValuePlayer6.setPreferredSize(new Dimension(100, 100));
			ItemPlayer6 = new HeroItem(world, Default, false);
			ItemPlayer6.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer6 = new Killstatothers(
					(pp2013.gruppe07.shared.entity.Hero) Default);
			KillStatPlayer6.setPreferredSize(new Dimension(100, 100));
		}
		if (Heroes[6] != null) {
			HeroImagePlayer7 = new HeroImage((Hero) world.getEntities().get(
					Heroes[6]));
			HeroImagePlayer7.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer7 = new HeroValue(world);
			HeroValuePlayer7.setPreferredSize(new Dimension(100, 100));
			ItemPlayer7 = new HeroItem(world, (Hero) world.getEntities().get(
					Heroes[6]), false);
			ItemPlayer7.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer7 = new Killstatothers((Hero) world.getEntities()
					.get(Heroes[6]));
			KillStatPlayer7.setPreferredSize(new Dimension(100, 100));
		} else {
			HeroImagePlayer7 = new HeroImage(Default);
			HeroImagePlayer7.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer7 = new HeroValue(world);
			HeroValuePlayer7.setPreferredSize(new Dimension(100, 100));
			ItemPlayer7 = new HeroItem(world, Default, false);
			ItemPlayer7.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer7 = new Killstatothers(
					(pp2013.gruppe07.shared.entity.Hero) Default);
			KillStatPlayer7.setPreferredSize(new Dimension(100, 100));

		}
		if (Heroes[7] != null) {
			HeroImagePlayer8 = new HeroImage((Hero) world.getEntities().get(
					Heroes[7]));
			HeroImagePlayer8.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer8 = new HeroValue(world);
			HeroValuePlayer8.setPreferredSize(new Dimension(100, 100));
			ItemPlayer8 = new HeroItem(world, (Hero) world.getEntities().get(
					Heroes[7]), false);
			ItemPlayer8.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer8 = new Killstatothers((Hero) world.getEntities()
					.get(Heroes[7]));
			KillStatPlayer8.setPreferredSize(new Dimension(100, 100));
		} else {
			HeroImagePlayer8 = new HeroImage(Default);
			HeroImagePlayer8.setPreferredSize(new Dimension(100, 100));
			HeroValuePlayer8 = new HeroValue(world);
			HeroValuePlayer8.setPreferredSize(new Dimension(100, 100));
			ItemPlayer8 = new HeroItem(world, Default, false);
			ItemPlayer8.setPreferredSize(new Dimension(100, 100));
			KillStatPlayer8 = new Killstatothers(
					(pp2013.gruppe07.shared.entity.Hero) Default);
			KillStatPlayer8.setPreferredSize(new Dimension(100, 100));

		}

		JPanel Statistic = new JPanel();
		this.add(Statistic, BorderLayout.CENTER);
		Statistic.setLayout(new BorderLayout());
		Statistic.setBackground(Color.LIGHT_GRAY);

		JPanel HeroValues = new JPanel();
		HeroValues.setLayout(new BorderLayout());
		Statistic.add(HeroValues, BorderLayout.NORTH);
		HeroValues.setBackground(Color.LIGHT_GRAY);

		JPanel HeroImages = new JPanel();
		HeroImages.setLayout(new BorderLayout());
		HeroValues.add(HeroImages, BorderLayout.WEST);
		HeroImages.setBackground(Color.LIGHT_GRAY);

		
		JLabel Heroname = new JLabel(
				((Hero) world.getEntities().get(
						Heroes[0])).getHeroName());
		HeroImages.add(Heroname, BorderLayout.NORTH);
		HeroImages.add(HeroImage, BorderLayout.WEST);
		HeroImages.add(HEROVALUE, BorderLayout.EAST);

		HeroValues.add(Killstat, BorderLayout.CENTER);
		JPanel ItemPanel = new JPanel();
		ItemPanel.setLayout(new BorderLayout());
		JLabel Header2 = new JLabel("gekaufte Items");
		HeroValues.add(ItemPanel, BorderLayout.EAST);

		ItemPanel.add(Header2, BorderLayout.NORTH);
		ItemPanel.add(Items, BorderLayout.CENTER);

		JPanel OtherPlayers = new JPanel();
		OtherPlayers.setLayout(new BorderLayout());
		OtherPlayers.setBackground(Color.DARK_GRAY);
		OtherPlayers.setPreferredSize(new Dimension(100, 470));

		Statistic.add(OtherPlayers, BorderLayout.CENTER);
		JPanel PlayersPanel = new JPanel();
		PlayersPanel.setLayout(new BorderLayout());
		PlayersPanel.setBackground(Color.DARK_GRAY);
		OtherPlayers.add(PlayersPanel, BorderLayout.CENTER);

		JPanel Row1 = new JPanel();
		Row1.setLayout(new BorderLayout());
		Row1.setBackground(Color.DARK_GRAY);
		Row1.setPreferredSize(new Dimension(100, 120));

		JPanel Row2 = new JPanel();
		Row2.setLayout(new BorderLayout());
		Row2.setBackground(Color.DARK_GRAY);
		Row2.setPreferredSize(new Dimension(100, 120));

		JPanel UpperRow3 = new JPanel();
		UpperRow3.setLayout(new BorderLayout());
		UpperRow3.setBackground(Color.DARK_GRAY);
		UpperRow3.setPreferredSize(new Dimension(100, 200));

		JPanel Row4 = new JPanel();
		Row4.setLayout(new BorderLayout());
		Row4.setBackground(Color.DARK_GRAY);
		Row4.setPreferredSize(new Dimension(100, 120));

		JPanel Row5 = new JPanel();
		Row5.setLayout(new BorderLayout());
		Row5.setBackground(Color.DARK_GRAY);
		Row5.setPreferredSize(new Dimension(100, 120));
		UpperRow3.add(Row4, BorderLayout.NORTH);
		UpperRow3.add(Row5, BorderLayout.CENTER);

		JPanel Upperrow1 = new JPanel();
		Upperrow1.setLayout(new BorderLayout());
		Upperrow1.add(Row1, BorderLayout.NORTH);
		Upperrow1.add(Row2, BorderLayout.SOUTH);

		PlayersPanel.add(Upperrow1, BorderLayout.NORTH);

		PlayersPanel.add(UpperRow3, BorderLayout.CENTER);

		// Row1 west

		JPanel HeroValues2 = new JPanel();
		HeroValues2.setLayout(new BorderLayout());

		HeroValues2.setBackground(Color.LIGHT_GRAY);

		JPanel HeroImages2 = new JPanel();
		HeroImages2.setLayout(new BorderLayout());
		HeroValues2.add(HeroImages2, BorderLayout.WEST);
		HeroImages2.setBackground(Color.LIGHT_GRAY);

		JLabel Heroname2 = new JLabel(
				((Hero) world.getEntities().get(
						Heroes[0])).getHeroName());
		HeroImages2.add(Heroname2, BorderLayout.NORTH);
		HeroImages2.add(HeroImagePlayer1, BorderLayout.WEST);
		HeroImages2.add(HeroValuePlayer1, BorderLayout.EAST);

		HeroValues2.add(KillStatPlayer1, BorderLayout.CENTER);
		JPanel ItemPanel2 = new JPanel();
		ItemPanel2.setLayout(new BorderLayout());
		JLabel Header22 = new JLabel("gekaufte Items");
		HeroValues2.add(ItemPanel2, BorderLayout.EAST);

		ItemPanel2.add(Header22, BorderLayout.NORTH);
		ItemPanel2.add(ItemPlayer1, BorderLayout.CENTER);
		Row1.add(HeroValues2, BorderLayout.CENTER);

		// Row1 east

		JPanel HeroValues3 = new JPanel();
		HeroValues3.setLayout(new BorderLayout());

		HeroValues3.setBackground(Color.LIGHT_GRAY);

		JPanel HeroImages3 = new JPanel();
		HeroImages3.setLayout(new BorderLayout());
		HeroValues3.add(HeroImages3, BorderLayout.WEST);
		HeroImages3.setBackground(Color.LIGHT_GRAY);

		JLabel Heroname3 = new JLabel(
				((Hero) world.getEntities().get(
						Heroes[1])).getHeroName());
		HeroImages3.add(Heroname3, BorderLayout.NORTH);
		HeroImages3.add(HeroImagePlayer2, BorderLayout.WEST);
		HeroImages3.add(HeroValuePlayer2, BorderLayout.EAST);

		HeroValues3.add(KillStatPlayer2, BorderLayout.CENTER);
		JPanel ItemPanel3 = new JPanel();
		ItemPanel3.setLayout(new BorderLayout());
		JLabel Header23 = new JLabel("gekaufte Items");
		HeroValues3.add(ItemPanel3, BorderLayout.EAST);

		ItemPanel3.add(Header23, BorderLayout.NORTH);
		ItemPanel3.add(ItemPlayer2, BorderLayout.CENTER);
		Row1.add(HeroValues3, BorderLayout.EAST);

		// Row2 west

		JPanel HeroValues4 = new JPanel();
		HeroValues4.setLayout(new BorderLayout());

		HeroValues4.setBackground(Color.LIGHT_GRAY);

		JPanel HeroImages4 = new JPanel();
		HeroImages4.setLayout(new BorderLayout());
		HeroValues4.add(HeroImages4, BorderLayout.WEST);
		HeroImages4.setBackground(Color.LIGHT_GRAY);

		JLabel Heroname4 = new JLabel(
				((Hero) world.getEntities().get(
						Heroes[2])).getHeroName());
		HeroImages4.add(Heroname4, BorderLayout.NORTH);
		HeroImages4.add(HeroImagePlayer3, BorderLayout.WEST);
		HeroImages4.add(HeroValuePlayer3, BorderLayout.EAST);

		HeroValues4.add(KillStatPlayer3, BorderLayout.CENTER);
		JPanel ItemPanel4 = new JPanel();
		ItemPanel4.setLayout(new BorderLayout());
		JLabel Header24 = new JLabel("gekaufte Items");
		HeroValues4.add(ItemPanel4, BorderLayout.EAST);

		ItemPanel4.add(Header24, BorderLayout.NORTH);
		ItemPanel4.add(ItemPlayer3, BorderLayout.CENTER);
		Row2.add(HeroValues4, BorderLayout.CENTER);

		// Row2 east

		JPanel HeroValues5 = new JPanel();
		HeroValues5.setLayout(new BorderLayout());

		HeroValues5.setBackground(Color.LIGHT_GRAY);

		JPanel HeroImages5 = new JPanel();
		HeroImages5.setLayout(new BorderLayout());
		HeroValues5.add(HeroImages5, BorderLayout.WEST);
		HeroImages5.setBackground(Color.LIGHT_GRAY);

		JLabel Heroname5 = new JLabel(
				((Hero) world.getEntities().get(
						Heroes[3])).getHeroName());
		HeroImages5.add(Heroname5, BorderLayout.NORTH);
		HeroImages5.add(HeroImagePlayer4, BorderLayout.WEST);
		HeroImages5.add(HeroValuePlayer4, BorderLayout.EAST);

		HeroValues5.add(KillStatPlayer4, BorderLayout.CENTER);
		JPanel ItemPanel5 = new JPanel();
		ItemPanel5.setLayout(new BorderLayout());
		JLabel Header25 = new JLabel("gekaufte Items");
		HeroValues5.add(ItemPanel5, BorderLayout.EAST);

		ItemPanel5.add(Header25, BorderLayout.NORTH);
		ItemPanel5.add(ItemPlayer4, BorderLayout.CENTER);
		Row2.add(HeroValues5, BorderLayout.EAST);

		// Row3 west

		JPanel HeroValues6 = new JPanel();
		HeroValues6.setLayout(new BorderLayout());

		HeroValues6.setBackground(Color.LIGHT_GRAY);

		JPanel HeroImages6 = new JPanel();
		HeroImages6.setLayout(new BorderLayout());
		HeroValues6.add(HeroImages6, BorderLayout.WEST);
		HeroImages6.setBackground(Color.LIGHT_GRAY);

		JLabel Heroname6 = new JLabel(
				((Hero) world.getEntities().get(
						Heroes[4])).getHeroName());
		HeroImages6.add(Heroname6, BorderLayout.NORTH);
		HeroImages6.add(HeroImagePlayer5, BorderLayout.WEST);
		HeroImages6.add(HeroValuePlayer5, BorderLayout.EAST);

		HeroValues6.add(KillStatPlayer5, BorderLayout.CENTER);
		JPanel ItemPanel6 = new JPanel();
		ItemPanel6.setLayout(new BorderLayout());
		JLabel Header26 = new JLabel("gekaufte Items");
		HeroValues6.add(ItemPanel6, BorderLayout.EAST);

		ItemPanel6.add(Header26, BorderLayout.NORTH);
		ItemPanel6.add(ItemPlayer5, BorderLayout.CENTER);
		Row4.add(HeroValues6, BorderLayout.CENTER);

		// Row3 east

		JPanel HeroValues7 = new JPanel();
		HeroValues7.setLayout(new BorderLayout());

		HeroValues7.setBackground(Color.LIGHT_GRAY);

		JPanel HeroImages7 = new JPanel();
		HeroImages7.setLayout(new BorderLayout());
		HeroValues7.add(HeroImages7, BorderLayout.WEST);
		HeroImages7.setBackground(Color.LIGHT_GRAY);

		JLabel Heroname7 = new JLabel(
				((Hero) world.getEntities().get(
						Heroes[5])).getHeroName());
		HeroImages7.add(Heroname7, BorderLayout.NORTH);
		HeroImages7.add(HeroImagePlayer6, BorderLayout.WEST);
		HeroImages7.add(HeroValuePlayer6, BorderLayout.EAST);

		HeroValues7.add(KillStatPlayer6, BorderLayout.CENTER);
		JPanel ItemPanel7 = new JPanel();
		ItemPanel7.setLayout(new BorderLayout());
		JLabel Header27 = new JLabel("gekaufte Items");
		HeroValues7.add(ItemPanel7, BorderLayout.EAST);

		ItemPanel7.add(Header27, BorderLayout.NORTH);
		ItemPanel7.add(ItemPlayer6, BorderLayout.CENTER);
		Row4.add(HeroValues7, BorderLayout.EAST);

		// Row4 west

		JPanel HeroValues8 = new JPanel();
		HeroValues8.setLayout(new BorderLayout());

		HeroValues8.setBackground(Color.LIGHT_GRAY);

		JPanel HeroImages8 = new JPanel();
		HeroImages8.setLayout(new BorderLayout());
		HeroValues8.add(HeroImages8, BorderLayout.WEST);
		HeroImages8.setBackground(Color.LIGHT_GRAY);

		JLabel Heroname8 = new JLabel(
				((Hero) world.getEntities().get(
						Heroes[6])).getHeroName());
		HeroImages8.add(Heroname8, BorderLayout.NORTH);
		HeroImages8.add(HeroImagePlayer7, BorderLayout.WEST);
		HeroImages8.add(HeroValuePlayer7, BorderLayout.EAST);

		HeroValues8.add(KillStatPlayer7, BorderLayout.CENTER);
		JPanel ItemPanel8 = new JPanel();
		ItemPanel8.setLayout(new BorderLayout());
		JLabel Header28 = new JLabel("gekaufte Items");
		HeroValues8.add(ItemPanel8, BorderLayout.EAST);

		ItemPanel8.add(Header28, BorderLayout.NORTH);
		ItemPanel8.add(ItemPlayer7, BorderLayout.CENTER);
		Row5.add(HeroValues8, BorderLayout.CENTER);

		// Row4 east

		JPanel HeroValues9 = new JPanel();
		HeroValues9.setLayout(new BorderLayout());

		HeroValues9.setBackground(Color.LIGHT_GRAY);

		JPanel HeroImages9 = new JPanel();
		HeroImages9.setLayout(new BorderLayout());
		HeroValues9.add(HeroImages9, BorderLayout.WEST);
		HeroImages9.setBackground(Color.LIGHT_GRAY);
		
		JLabel Heroname9 ;
		if(Heroes[7]!=null)
		 Heroname9 = new JLabel(
				((Hero) world.getEntities().get(
						Heroes[7])).getHeroName());
		else
			 Heroname9 = new JLabel(
					"");
		HeroImages9.add(Heroname9, BorderLayout.NORTH);
		HeroImages9.add(HeroImagePlayer8, BorderLayout.WEST);
		HeroImages9.add(HeroValuePlayer8, BorderLayout.EAST);

		HeroValues9.add(KillStatPlayer8, BorderLayout.CENTER);
		JPanel ItemPanel9 = new JPanel();
		ItemPanel9.setLayout(new BorderLayout());
		JLabel Header29 = new JLabel("gekaufte Items");
		HeroValues9.add(ItemPanel9, BorderLayout.EAST);

		ItemPanel9.add(Header29, BorderLayout.NORTH);
		ItemPanel9.add(ItemPlayer8, BorderLayout.CENTER);
		Row5.add(HeroValues9, BorderLayout.EAST);

	}

	@Override
	public void onEvent(Event evt) {
		// TODO Auto-generated method stub

	}

}
