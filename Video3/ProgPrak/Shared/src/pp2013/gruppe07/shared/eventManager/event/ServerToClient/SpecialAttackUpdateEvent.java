package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import java.util.UUID;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Sagt dem Client, dass eine Spezialattacke ausgefuerht wurde
 * 
 * @author Sven
 * 
 */
public class SpecialAttackUpdateEvent extends Event {

	private final int MANA_COST;
	private final UUID ID;
	private final int ATTACKINDEX;

	/**
	 * @param clientid
	 * @param Id
	 * @param manacost
	 * @param attackIndex
	 * @author Sven
	 */
	public SpecialAttackUpdateEvent(int clientid, UUID Id, int manacost,
			int attackIndex) {
		super(clientid, Type.SPECIAL_ATTACK_UPDATE_EVENT);
		this.MANA_COST = manacost;
		this.ID = Id;
		this.ATTACKINDEX = attackIndex;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public int getATTACKINDEX() {
		return ATTACKINDEX;
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
	public int getMANA_COST() {
		return MANA_COST;
	}

	/**
	 * @param id
	 * @author Sven
	 */
	public void setClientId(int id) {
		clientID = id;
	}

}
