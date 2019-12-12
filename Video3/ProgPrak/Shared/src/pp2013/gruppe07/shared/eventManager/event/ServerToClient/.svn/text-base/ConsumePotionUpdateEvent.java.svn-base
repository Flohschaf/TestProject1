package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import java.util.UUID;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Uebermittelt die Daten zum Gebrauch eines Trankes
 * 
 * @author Sven
 * 
 */
public class ConsumePotionUpdateEvent extends Event {

	private final boolean IS_ELIXIR;
	private final UUID ID;
	private final int INCREASE;

	/**
	 * @param clientid
	 * @param Id
	 * @param isElixir
	 * @param increase
	 * @author Sven
	 */
	public ConsumePotionUpdateEvent(int clientid, UUID Id, boolean isElixir,
			int increase) {
		super(clientid, Type.CONSUME_POTION_UPDATE_EVENT);
		this.IS_ELIXIR = isElixir;
		this.ID = Id;
		this.INCREASE = increase;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public UUID getID() {
		return ID;
	}

	public int getINCREASE() {
		return INCREASE;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public boolean IS_ELIXIR() {
		return IS_ELIXIR;
	}

}
