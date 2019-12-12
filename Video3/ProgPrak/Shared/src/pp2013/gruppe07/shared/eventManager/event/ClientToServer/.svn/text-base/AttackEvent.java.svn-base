package pp2013.gruppe07.shared.eventManager.event.ClientToServer;

import java.util.UUID;

import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.eventManager.event.Event;

/**Schickt dem Server einen Auftrag einen Gegner anzugreifen
 * @author Sven
 *
 */
public class AttackEvent extends Event {
	
	private final UUID enemy;

	/**
	 * @param clientid
	 * @param enemy
	 * @author Sven
	 */
	public AttackEvent(int clientid,UUID enemy) {
		super(clientid, Type.ATTACK_EVENT);
		this.enemy=enemy;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public UUID getEnemy() {
		return enemy;
	}
	
	

}
