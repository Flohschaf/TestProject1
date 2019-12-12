package pp2013.gruppe07.shared.eventManager.event.ClientToServer;

import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * Event das die Lobby updated.
 * @author Felix
 *
 */
public class LobbyEvent extends Event{
	 Hero.Heronames hero;
	 InteraktiveEntity.Team team;
	
	
	public LobbyEvent(int clientid, Hero.Heronames hero , InteraktiveEntity.Team team) {
		super(clientid, Event.Type.LOBBY_EVENT);
		this.hero = hero;
		this.team = team;
	}
	
	public Hero.Heronames getHero(){
		return this.hero;
	}
	public InteraktiveEntity.Team getTeam(){
		return this.team;
	}
	
	

}
