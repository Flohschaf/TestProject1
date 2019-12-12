package pp2013.gruppe07.server.engine.eventmanager_and_serverevents;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ConsumePotionUpdateEvent;
import pp2013.gruppe07.shared.item.Elixir;
import pp2013.gruppe07.shared.item.Manapotion;

/**
 * Regelt das benutzen eines Trankes
 * 
 * @author Sven
 * 
 */
public class ConsumePotionEvent extends GameEvent {

	private Hero hero;
	private final boolean IS_ELIXIR;

	/**
	 * Bekommt insbesondere eine Nachricht, ob es sich um einen Heiltrank
	 * (Elixir) handelt
	 * 
	 * @param administration
	 * @param hero
	 * @param isElixir
	 * @author Sven
	 */
	public ConsumePotionEvent(GameLogic administration, Hero hero,
			boolean isElixir) {
		super(administration);
		this.hero = hero;
		this.IS_ELIXIR = isElixir;
	}

	@Override
	void execute() {

		// Gehe alle Itemslots durch
		for (int i = 0; i < 6; i++) {
			// Wenn der Slot einen Trank enthaelt und das Item ein Trank ist...
			if (hero.getItems()[i] instanceof Elixir && IS_ELIXIR) {
				Elixir elixir = (Elixir) hero.getItems()[i];

				// Wenn es genug Traenke gibt
				if (elixir.getQuantity() > 0) {
					// Erhoehe aktuelles Leben des Helden und verringere die
					// Anzahl der Traenke
					hero.change_Akt_Life(elixir.getINCREASE_LIFE());
					elixir.setQuantity(elixir.getQuantity() - 1);

					// Gib den Clients bescheid.
					for (int j = 0; j < Waiter.getClients().size(); j++) {
						Communication
								.newClientMessage(new ConsumePotionUpdateEvent(
										Waiter.getClients().get(j).getId(),
										hero.getID(), true, elixir
												.getINCREASE_LIFE()));
					}
				}
			}

			// ...sonst
			else {
				// Wenn der Slot einen Manatrank enthaelt und das Item ein
				// Manatrank ist...
				if (hero.getItems()[i] instanceof Manapotion && !IS_ELIXIR) {
					Manapotion manapotion = (Manapotion) hero.getItems()[i];

					// Wenn es genug Manatraenke gibt
					if (manapotion.getQuantity() > 0) {
						// Erhoehe das Mana und verringere die Anzahl.
						hero.change_Akt_mana(manapotion.getINCREASE_MANA());
						manapotion.setQuantity(manapotion.getQuantity() - 1);

						// Gib den Clients bescheid
						for (int j = 0; j < Waiter.getClients().size(); j++) {
							Communication
									.newClientMessage(new ConsumePotionUpdateEvent(
											Waiter.getClients().get(j).getId(),
											hero.getID(), false, manapotion
													.getINCREASE_MANA()));
						}
					}
				}
			}
		}

	}

}
