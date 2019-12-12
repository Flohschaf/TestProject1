package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * @autor Steven
 */
public class ClientLogInEvent extends Event {
	private boolean hasLoggedIn;
	private String message;

	public ClientLogInEvent(int clientid, boolean hasLoggedIn, String message) {
		super(clientid, Event.Type.CLIEN_LOG_IN_EVENT);
		this.hasLoggedIn = hasLoggedIn;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public boolean hasLoggedIn() {
		return hasLoggedIn;
	}

}
