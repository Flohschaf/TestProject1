package pp2013.gruppe07.shared.eventManager.event.ClientToServer;

import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.Hero.Heronames;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * 
 * @author Felix
 *
 */
public class ChooseHeroEvent extends Event{

	Heronames type;
	Team team;
	
	public ChooseHeroEvent(int id , Heronames hero, Team team) {
		super(id,Event.Type.CHOOSE_HERO_EVENT);
		this.type = hero;
		this.team = team;
		
	}
		


	public Heronames getHero(){
		return this.type;
	}
	public Team getTeam(){
		return this.team;
	}
}
