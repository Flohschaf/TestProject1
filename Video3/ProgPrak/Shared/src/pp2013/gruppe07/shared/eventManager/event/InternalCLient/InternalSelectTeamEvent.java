package pp2013.gruppe07.shared.eventManager.event.InternalCLient;

import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * Teilt dem Client intern mit welches Team ausgewaehlt wurde.
 * @author Felix
 *
 */
public class InternalSelectTeamEvent extends Event{
	
	Team team;
	
	public InternalSelectTeamEvent(int clientid,Team team) {
		super(clientid, Event.Type.INTERNAL_SELECT_TEAM_EVENT);
		this.team = team;
	}
	
	public Team getTeam(){
		return this.team;
	}

}
