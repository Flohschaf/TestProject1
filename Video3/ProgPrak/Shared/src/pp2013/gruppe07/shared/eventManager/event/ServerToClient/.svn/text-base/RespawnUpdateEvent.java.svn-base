package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import java.util.UUID;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Reanimiert den Helden
 * 
 * @author Sven
 * 
 */
public class RespawnUpdateEvent extends Event {

	private final UUID ID;
	private final int[] STARTPOSITION;

	/**
	 * @param clientid
	 * @param id
	 * @param position
	 * @author Sven
	 */
	public RespawnUpdateEvent(int clientid, UUID id, int[] position) {
		super(clientid, Type.RESPAWN_UPDATE_EVENT);
		this.ID = id;
		this.STARTPOSITION = position;
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
	public int[] getSTARTPOSITION() {
		return STARTPOSITION;
	}

}
