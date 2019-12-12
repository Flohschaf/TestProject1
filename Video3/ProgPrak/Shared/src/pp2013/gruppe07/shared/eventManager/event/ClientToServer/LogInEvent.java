package pp2013.gruppe07.shared.eventManager.event.ClientToServer;

import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * Event wenn sich ein Spieler anmeldet.
 * @author Felix
 *
 */
public class LogInEvent extends Event{
	

	private String username;
	private String password;
	
	public LogInEvent(int id, String username, String password) {
		super(id,Event.Type.LOCK_IN_EVENT);

		this.username=username;
		this.password = password;
		
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}



}
