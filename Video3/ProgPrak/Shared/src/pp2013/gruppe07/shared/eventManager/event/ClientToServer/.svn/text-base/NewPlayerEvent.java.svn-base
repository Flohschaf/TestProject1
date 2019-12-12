package pp2013.gruppe07.shared.eventManager.event.ClientToServer;

import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * Event wenn sich ein neuer Spieler anmeldet.
 * @author Felix
 *
 */
public class NewPlayerEvent extends Event{

	
	Hero hero;
	String name;
	
	

	public NewPlayerEvent(int id,Hero hero , String name){
		super(id,Event.Type.NEW_PLAYER_EVENT);
		this.hero=hero;
		this.name=name;
	}
	
	public Hero getHero() {
		return hero;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	
}
