package pp2013.gruppe07.client.gui.Lobby;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.Frame;
import pp2013.gruppe07.shared.entity.Hero.Heronames;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.InternalCLient.InternalSelectHeroEvent;
//import pp2013.gruppe07.shared.entity.MadnessMarc;
//import pp2013.gruppe07.shared.entity.OverpoweredOnur;

/**
 * Auf diesem Panel befinden sich Knoepfe zum auswaehlen der Helden.
 * 
 * @author Felix,Flo
 * 
 */
public class HeroPanel extends JPanel {
	private int width;
	private int heigth;
	private HeroSelectionPanel panel;
	private Frame frame;

	public HeroPanel(Frame frame, HeroSelectionPanel panel) {
		this.panel = panel;
		this.frame = frame;
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		width = (int) (gd.getDisplayMode().getWidth() * 0.4);
		heigth = (int) (gd.getDisplayMode().getHeight() * 0.4);

		this.setPreferredSize(new Dimension(heigth, width));

		ArrayList<JButton> buttons = createButtons();

		for (JButton jbut : buttons) {
			this.add(jbut);
		}

		this.setLayout(new GridLayout(buttons.size(), 1));

	}

	/**
	 * Erzeugt Knoepfe fuer alle Helden.
	 * 
	 * @return
	 */
	public ArrayList<JButton> createButtons() {
		ArrayList<JButton> heroes = new ArrayList<JButton>();

		JButton captainObvious = new JButton("Captain Obvious");

		ActionListener captainObviousAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				EventManager.callEvent(new InternalSelectHeroEvent(frame
						.getClientID(), Heronames.CAPTAIN_OBVIOUS));
				frame.repaint();
			}

		};

		captainObvious.addActionListener(captainObviousAct);

		JButton clitComander = new JButton("Clit Comander");

		ActionListener clitComanderAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventManager.callEvent(new InternalSelectHeroEvent(frame
						.getClientID(), Heronames.CLIT_COMANDER));
				frame.repaint();
			}

		};

		clitComander.addActionListener(clitComanderAct);

		JButton dangerDan = new JButton("Danger Dan");

		ActionListener startGameAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventManager.callEvent(new InternalSelectHeroEvent(frame
						.getClientID(), Heronames.DANGER_DAN));
				frame.repaint();
			}

		};

		dangerDan.addActionListener(startGameAct);

		JButton famousFlorian = new JButton("Famous Florian");

		ActionListener famousFlorianAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventManager.callEvent(new InternalSelectHeroEvent(frame
						.getClientID(), Heronames.FAMOUS_FLORIAN));
				frame.repaint();
			}

		};

		famousFlorian.addActionListener(famousFlorianAct);

		JButton federalFelix = new JButton("Federal Felix");

		ActionListener federalFelixAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventManager.callEvent(new InternalSelectHeroEvent(frame
						.getClientID(), Heronames.FEDERAL_FELIX));
				frame.repaint();
			}

		};

		federalFelix.addActionListener(federalFelixAct);

		JButton generalHate = new JButton("General Hate");

		ActionListener generalHateAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventManager.callEvent(new InternalSelectHeroEvent(frame
						.getClientID(), Heronames.GENERAL_HATE));
				frame.repaint();
			}

		};

		generalHate.addActionListener(generalHateAct);

		JButton safetySteven = new JButton("Safety Steven");

		ActionListener safetyStevenAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventManager.callEvent(new InternalSelectHeroEvent(frame
						.getClientID(), Heronames.SAFETY_STEVEN));
				frame.repaint();
			}

		};

		safetySteven.addActionListener(safetyStevenAct);

		JButton seriousSven = new JButton("Serious Sven");

		ActionListener seriousSvenAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventManager.callEvent(new InternalSelectHeroEvent(frame
						.getClientID(), Heronames.SERIOUS_SVEN));
				frame.repaint();

			}

		};

		seriousSven.addActionListener(seriousSvenAct);

		heroes.add(captainObvious);
		heroes.add(clitComander);
		heroes.add(dangerDan);
		heroes.add(famousFlorian);
		heroes.add(federalFelix);
		heroes.add(generalHate);
		heroes.add(safetySteven);
		heroes.add(seriousSven);

		return heroes;
	}
}
