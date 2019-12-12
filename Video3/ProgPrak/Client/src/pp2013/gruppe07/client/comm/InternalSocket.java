package pp2013.gruppe07.client.comm;

import java.util.LinkedList;

import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Ein lokaler Socket der verwendet wird um alle in die Communication-Klasse
 * geschriebenen Nachrichtgen zu verarbeiten.
 * 
 * @author Felix
 * 
 */
public class InternalSocket {

	/**
	 * Alle Nachrichten werden durchgegangen und der Eventmanager
	 * benachrichtigt.
	 */
	public static void handleInput() {

		LinkedList<Event> messages = Communication.getClientMessage();
		for (Event message : messages) {
			EventManager.callEvent(message);

		}

	}
}
