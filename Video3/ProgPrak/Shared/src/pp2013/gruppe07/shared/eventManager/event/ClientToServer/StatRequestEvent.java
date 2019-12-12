package pp2013.gruppe07.shared.eventManager.event.ClientToServer;

import pp2013.gruppe07.shared.entity.Hero.Heronames;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * Event wenn die Statistik aufgerufen wird.
 * @author Felix
 *
 */
public class StatRequestEvent extends Event {
int id;
String playerName;

		public StatRequestEvent(int id , String playerName) {
			super(id,Event.Type.STAT_REQUEST_EVENT);
			this.id= id;
			this.playerName = playerName;
			
		}
		
public int getID(){
	return id;
}
public String getPlayerName(){
	return playerName;
}
			
	
			


}
