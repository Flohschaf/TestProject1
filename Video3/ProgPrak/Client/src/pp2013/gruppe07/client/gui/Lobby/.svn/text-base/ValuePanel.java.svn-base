package pp2013.gruppe07.client.gui.Lobby;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.UUID;

import javax.swing.JPanel;
import javax.swing.JTextField;

import pp2013.gruppe07.shared.entity.CaptainObvious;
import pp2013.gruppe07.shared.entity.ClitComander;
import pp2013.gruppe07.shared.entity.DangerDan;
import pp2013.gruppe07.shared.entity.FamousFlorian;
import pp2013.gruppe07.shared.entity.FederalFelix;
import pp2013.gruppe07.shared.entity.GeneralHate;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.Hero.Heronames;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.SafetySteven;
import pp2013.gruppe07.shared.entity.SeriousSven;
import pp2013.gruppe07.shared.eventManager.EventListener;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.InternalCLient.InternalSelectHeroEvent;

/**
 * Stellt die Attribute eines Helden dar.
 * 
 * @author Felix,Flo
 * 
 */
public class ValuePanel extends JPanel implements EventListener {
	Hero hero;
	Hero.Heronames heroName;
	JTextField[] values;
	UUID id;

	public ValuePanel() {

		id = UUID.randomUUID();
		EventManager.registerListener(this,
				Event.Type.INTERNAL_SELECT_HERO_EVENT);

		this.setLayout(new GridLayout(8, 1));
		hero = new CaptainObvious(UUID.randomUUID(), 0, 0, Team.BLUE, true);

		values = new JTextField[8];

		Font f = new Font("Dialog", 0, 10);

		for (int i = 0; i < 8; i++) {
			values[i] = new JTextField(hero.getValueNames()[i] + ":\n "
					+ hero.getvalue()[i]);
			values[i].setEditable(false);
			values[i].setFont(f);
			this.add(values[i]);
		}

	}

	@Override
	public void onEvent(Event evt) {
		this.heroName = ((InternalSelectHeroEvent) evt).getHero();
		this.hero = createHero(heroName, Team.NEUTRAL, true);
		for (int i = 0; i < 8; i++) {
			values[i].setText(hero.getValueNames()[i] + ":\n "
					+ hero.getvalue()[i]);
		}

	}

	/**
	 * Erzeugt einen pseudo Helden um auf dessen Faehigkeiten und Attribute
	 * zugreifen zu koennen.
	 * 
	 * @param name
	 * @param team
	 * @param isHuman
	 * @return Hero
	 */
	public Hero createHero(Heronames name, Team team, boolean isHuman) {
		Hero hero = null;
		switch (name) {
		case CAPTAIN_OBVIOUS: {
			hero = new CaptainObvious(id.randomUUID(), 1, 1, team, isHuman);
			break;
		}
		case CLIT_COMANDER: {
			hero = new ClitComander(id.randomUUID(), 1, 1, team, isHuman);
			break;
		}
		case DANGER_DAN: {
			hero = new DangerDan(id.randomUUID(), 1, 1, team, isHuman);
			break;
		}
		case FAMOUS_FLORIAN: {
			hero = new FamousFlorian(id.randomUUID(), 1, 1, team, isHuman);
			break;
		}
		case FEDERAL_FELIX: {
			hero = new FederalFelix(id.randomUUID(), 1, 1, team, isHuman);
			break;
		}
		case GENERAL_HATE: {
			hero = new GeneralHate(id.randomUUID(), 1, 1, team, isHuman);
			break;
		}
		case SAFETY_STEVEN: {
			hero = new SafetySteven(id.randomUUID(), 1, 1, team, isHuman);
			break;
		}
		case SERIOUS_SVEN: {
			hero = new SeriousSven(id.randomUUID(), 1, 1, team, isHuman);
			break;
		}

		}
		return hero;
	}

}
