package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Dient als Traeger mehrere Events, um nicht fuer jeden Event eine eigene
 * Message verschicken zu muessen
 * 
 * @author Sven
 * 
 */
public class CarryUpdateEvent extends Event {

	private Event[] events;

	/**
	 * @param clientid
	 * @param events
	 * @author Sven
	 */
	public CarryUpdateEvent(int clientid, Event[] events) {
		super(clientid, Type.CARRY_UPDATE_EVENT);
		this.events = events;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public Event[] getEvents() {
		return events;
	}

	/**
	 * @param id
	 * @author Sven
	 */
	public void setClientId(int id) {
		clientID = id;
	}

}
