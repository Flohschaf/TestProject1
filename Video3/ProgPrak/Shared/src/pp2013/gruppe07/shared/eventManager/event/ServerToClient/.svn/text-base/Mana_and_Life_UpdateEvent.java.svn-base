package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import java.util.LinkedList;
import java.util.UUID;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Sagt den Clients, dass sie das Mana und Leben eines Helden um den angegebenen
 * Wert ehoehen sollen
 * 
 * @author Sven
 * 
 */
public class Mana_and_Life_UpdateEvent extends Event {

	private final int MANA_INCREASE;
	private final int LIFE_INCREASE;
	private LinkedList<UUID> heroes = new LinkedList<UUID>();

	/**
	 * @param clientid
	 * @param life_increase
	 * @param mana_increase
	 * @param heroes
	 * @author Sven
	 */
	public Mana_and_Life_UpdateEvent(int clientid, int life_increase,
			int mana_increase, LinkedList<UUID> heroes) {
		super(clientid, Type.MANA_AND_LIFE_UPDATE_EVENT);
		this.MANA_INCREASE = mana_increase;
		this.LIFE_INCREASE = life_increase;
		this.heroes = heroes;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public LinkedList<UUID> getHeroes() {
		return heroes;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public int getLIFE_INCREASE() {
		return LIFE_INCREASE;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public int getMANA_INCREASE() {
		return MANA_INCREASE;
	}

}
