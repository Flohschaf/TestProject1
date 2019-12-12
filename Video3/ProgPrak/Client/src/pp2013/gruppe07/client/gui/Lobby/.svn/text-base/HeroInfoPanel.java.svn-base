package pp2013.gruppe07.client.gui.Lobby;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import pp2013.gruppe07.client.comm.Communication;
import pp2013.gruppe07.client.gui.Frame;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.Hero.Heronames;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.eventManager.EventListener;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.Event.Type;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.LobbyEvent;
import pp2013.gruppe07.shared.eventManager.event.InternalCLient.InternalSelectHeroEvent;
import pp2013.gruppe07.shared.eventManager.event.InternalCLient.InternalSelectTeamEvent;

/**
 * Panel auf dem alle Informationen zum aktuell gewaehlten Helden angezeigt
 * werden. Hier kann auch der Held und das Team gewechselt werden.
 * 
 * @author Felix,Flo
 * 
 */
public class HeroInfoPanel extends JPanel implements EventListener {

	HeroImagePanel picture;
	SkillPanel skill;
	ValuePanel value;
	Frame frame;
	Hero.Heronames hero;
	Team team;

	public HeroInfoPanel(final Frame frame) {
		this.frame = frame;

		this.setBorder(new EtchedBorder());

		if (frame.getClientID() % 2 == 0) {
			team = Team.BLUE;
		} else {

			team = Team.RED;
		}
		EventManager.callEvent(new InternalSelectTeamEvent(frame.getClientID(),
				team));

		EventManager.registerListener(this, Type.INTERNAL_SELECT_HERO_EVENT);

		picture = new HeroImagePanel();

		this.setLayout(new GridLayout(2, 1));

		hero = Heronames.CAPTAIN_OBVIOUS;

		skill = new SkillPanel();

		value = new ValuePanel();

		JPanel north = new JPanel();
		JPanel chooseTeamPanel = new JPanel();
		JPanel showHero = new JPanel();

		chooseTeamPanel.setLayout(new BorderLayout());
		chooseTeamPanel.setBorder(new EtchedBorder());

		final JButton redTeam = new JButton("Red Team");
		final JButton blueTeam = new JButton("Blue Team");

		ActionListener redTeamAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// blueTeam.setSelected(false);
				team = Team.RED;

				frame.repaint();
				EventManager.callEvent(new InternalSelectTeamEvent(frame
						.getClientID(), Team.RED));
				Communication.newServerMessage(new LobbyEvent(frame
						.getClientID(), hero, InteraktiveEntity.Team.RED));
			}

		};

		ActionListener blueTeamAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// redTeam.setSelected(false);
				team = Team.BLUE;
				frame.repaint();
				EventManager.callEvent(new InternalSelectTeamEvent(frame
						.getClientID(), Team.BLUE));
				Communication.newServerMessage(new LobbyEvent(frame
						.getClientID(), hero, InteraktiveEntity.Team.BLUE));
			}

		};

		redTeam.addActionListener(redTeamAct);
		blueTeam.addActionListener(blueTeamAct);

		redTeam.setBackground(Color.RED);
		blueTeam.setBackground(Color.BLUE);

		chooseTeamPanel.add(redTeam, BorderLayout.NORTH);
		chooseTeamPanel.add(blueTeam, BorderLayout.SOUTH);

		showHero.setLayout(new BorderLayout());
		showHero.add(picture, BorderLayout.WEST);
		showHero.add(value, BorderLayout.EAST);

		north.add(chooseTeamPanel, BorderLayout.NORTH);
		north.add(showHero, BorderLayout.SOUTH);

		this.add(north, BorderLayout.NORTH);

		this.add(skill, BorderLayout.SOUTH);

		this.setVisible(true);

	}

	@Override
	public void onEvent(Event evt) {
		InternalSelectHeroEvent event = (InternalSelectHeroEvent) evt;
		this.hero = event.getHero();

		Communication.newServerMessage(new LobbyEvent(frame.getClientID(),
				hero, team));
	}

}
