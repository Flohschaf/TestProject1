package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * 
 * @author Felix, Steven
 * Das Event teilt mit dass ein Account erstellt wurde
 * 
 */
public class AccountCreatedEvent extends Event {

	boolean created;
	String message;

	public AccountCreatedEvent(int clientid, boolean created, String message) {
		super(clientid, Event.Type.ACOOUNT_CREATED_EVENT);
		this.created = created;
		this.message = message;

	}

	public String getMessage() {
		return this.message;
	}

	public boolean wasCreated() {
		return this.created;
	}

}
