package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * @autor Steven
 */
public class ToClientChatEvent extends Event {

	String message;

	public ToClientChatEvent(int clientid, String message) {
		super(clientid, Event.Type.TO_CLIENT_CHAT_EVENT);
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
