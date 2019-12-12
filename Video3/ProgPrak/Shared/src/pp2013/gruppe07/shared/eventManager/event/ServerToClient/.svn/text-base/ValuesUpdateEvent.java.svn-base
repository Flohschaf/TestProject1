package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import java.util.UUID;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Erneuert die Standardwerte einer Figur oder eines Gebaeudes
 * 
 * @author Sven
 * 
 */
public class ValuesUpdateEvent extends Event {

	private final int[] INCREASE_VALUES;
	private final UUID ID;

	/**
	 * @param clientid
	 * @param id
	 * @param newValues
	 * @author Sven
	 */
	public ValuesUpdateEvent(int clientid, UUID id, int[] newValues) {
		super(clientid, Type.VALUES_UPDATE_EVENT);
		this.INCREASE_VALUES = newValues;
		this.ID = id;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public UUID getID() {
		return ID;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public int[] getINCREASE_VALUES() {
		return INCREASE_VALUES;
	}

	/**
	 * @param id
	 * @author Sven
	 */
	public void setClientId(int id) {
		clientID = id;
	}

}
