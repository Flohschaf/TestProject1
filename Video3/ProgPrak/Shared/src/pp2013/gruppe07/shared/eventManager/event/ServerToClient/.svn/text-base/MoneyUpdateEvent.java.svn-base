package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Erhoeht das Geld der Clients
 * 
 * @author Sven
 * 
 */
public class MoneyUpdateEvent extends Event {

	private final int INCREASE;

	/**
	 * @param clientid
	 * @param increase
	 * @author Sven
	 */
	public MoneyUpdateEvent(int clientid, int increase) {
		super(clientid, Type.MONEY_UPDATE_EVENT);
		this.INCREASE = increase;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public int getINCREASE() {
		return INCREASE;
	}

	/**
	 * @param id
	 * @author Sven
	 */
	public void setClientId(int id) {
		clientID = id;
	}
}
