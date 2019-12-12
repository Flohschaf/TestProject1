package pp2013.gruppe07.shared.eventManager.event.ClientToServer;

import java.util.UUID;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Wird an den Server geschickt, wenn ein Trank konsumiert werden soll
 * 
 * @author Sven
 * 
 */
public class PotionEvent extends Event {

	/**
	 * Gibt an, ob es sich um einen Heiltrank (Elixir) oder um einen Mana Trank
	 * handelt
	 * 
	 * @author Sven
	 */
	private final boolean IS_ELIXIR;


	public PotionEvent(int clientid, boolean isElixir) {
		super(clientid, Type.POTION_EVENT);
		this.IS_ELIXIR = isElixir;

	}

	public boolean IS_ELIXIR() {
		return IS_ELIXIR;
	}

	
	

}
