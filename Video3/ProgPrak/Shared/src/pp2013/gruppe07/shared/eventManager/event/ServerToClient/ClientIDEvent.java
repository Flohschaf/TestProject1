package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * Schickt die IDzum Client.
 * @author Felix
 *
 */
public class ClientIDEvent extends Event {

	public ClientIDEvent(int clientid) {
		super(clientid, Event.Type.CLIENT_ID_EVENT);

	}

}
