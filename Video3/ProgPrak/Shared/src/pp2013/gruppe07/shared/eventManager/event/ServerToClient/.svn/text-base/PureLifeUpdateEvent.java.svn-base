package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import java.util.LinkedList;
import java.util.UUID;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Sagt den Clients, dass sie das Leben eines InteraktiveEntity um den
 * angegebenen Wert ehoehen sollen
 * 
 * @author Steven
 * 
 */
public class PureLifeUpdateEvent extends Event {

	private final int LIFE_INCREASE;
	private LinkedList<UUID> heroes = new LinkedList<UUID>();
	private final UUID HERO;

	/**
	 * @param clientid
	 * @param life_increase
	 * @param heroes
	 * @author Steven
	 */
	public PureLifeUpdateEvent(int clientid, int life_increase,
			LinkedList<UUID> heroes,UUID hero) {
		super(clientid, Type.PURE_LIFE_UPDATE_EVENT);
		this.LIFE_INCREASE = life_increase;
		this.heroes = heroes;
		this.HERO=hero;
	}

	/**
	 * @return
	 * @author Steven
	 */
	public LinkedList<UUID> getHeroes() {
		return heroes;
	}
	
	

	/**
	 * @return
	 * @author Sven
	 */
	public UUID getHERO() {
		return HERO;
	}

	/**
	 * @return
	 * @author Steven
	 */
	public int getLIFE_INCREASE() {
		return LIFE_INCREASE;
	}

}