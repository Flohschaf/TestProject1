package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import java.util.UUID;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Wird vom Server zum Client geschickt, um die Position einer Figur zu aendern.
 * Um die Figur zu identifizieren reicht die alte Position aus, da dieses Event
 * nur von dem EventManager geschickt werden kann. Deshalb muss die Figur beim
 * Eintreffen des Events auf dem Client auf der alten Position stehen.
 * 
 * @author Sven
 * 
 */
public class MoveUpdateEvent extends Event {

	private final UUID ID;
	private final int[] NEWPOSITION;
	private final int NEWDIRECTION;

	/**
	 * @param clientid
	 * @param id
	 * @param newPosition
	 * @param newDirection
	 * @author Sven
	 */
	public MoveUpdateEvent(int clientid, UUID id, int[] newPosition,
			int newDirection) {
		super(clientid, Type.MOVE_UPDATE_EVENT);
		this.ID = id;
		this.NEWPOSITION = newPosition;
		this.NEWDIRECTION = newDirection;

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
	public int getNEWDIRECTION() {
		return NEWDIRECTION;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public int[] getNEWPOSITION() {
		return NEWPOSITION;
	}

	/**
	 * @param id
	 * @author Sven
	 */
	public void setClientId(int id) {
		clientID = id;
	}

}
