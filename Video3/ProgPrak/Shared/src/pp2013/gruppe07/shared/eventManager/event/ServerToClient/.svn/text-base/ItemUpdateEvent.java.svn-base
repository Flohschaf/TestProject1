package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import java.util.UUID;

import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.item.Item;

/**
 * Updatet die Werte nach Kauf oder Benutzen eines Items
 * 
 * @author Sven
 * 
 */
public class ItemUpdateEvent extends Event {

	private final Item ITEM;
	private final UUID ID;

	/**
	 * @param clientid
	 * @param id
	 * @param item
	 * @author Sven
	 */
	public ItemUpdateEvent(int clientid, UUID id, Item item) {
		super(clientid, Type.ITEM_UPDATE_EVENT);
		this.ITEM = item;
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
	public Item getITEM() {
		return ITEM;
	}

	/**
	 * @param id
	 * @author Sven
	 */
	public void setClientId(int id) {
		clientID = id;
	}

}
