package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import java.util.UUID;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Erhoeht Erfharungspunkte
 * 
 * @author Sven
 * 
 */
public class IncreaseXPEvent extends Event {

	private final UUID HERO_ID;
	private final int INCREASE;

	/**
	 * @param clientid
	 * @param hero_ID
	 * @param increase
	 * @author Sven
	 */
	public IncreaseXPEvent(int clientid, UUID hero_ID, int increase) {
		super(clientid, Type.INCREASE_XP_EVENT);
		this.HERO_ID = hero_ID;
		this.INCREASE = increase;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public UUID getHERO_ID() {
		return HERO_ID;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public int getINCREASE() {
		return INCREASE;
	}

}
