package pp2013.gruppe07.shared.eventManager.event.InternalCLient;

import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * Teilt dem Client intern mit welcher Held ausgewaehlt wurde.
 * @author Felix
 *
 */
public class InternalSelectHeroEvent extends Event{

	Hero.Heronames hero;
	
	public InternalSelectHeroEvent(int id,Hero.Heronames hero) {
		super(id,Event.Type.INTERNAL_SELECT_HERO_EVENT);
		
		this.hero=hero;
		// TODO Auto-generated constructor stub
	}

	public Hero.Heronames getHero(){
		return this.hero;
	}
	
}
