package pp2013.gruppe07.server.engine.eventmanager_and_serverevents;

import java.util.LinkedList;
import java.util.UUID;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.Mana_and_Life_UpdateEvent;

/**
 * Erhoeht das Mana eines Helden
 * 
 * @author Sven
 * 
 */
public class Mana_and_Life_IncreaseEvent extends GameEvent {

	private final int LIFE_INCREASE;
	private final int MANA_INCREASE;

	/**
	 * @param administration
	 * @param life_increase
	 * @param mana_increase
	 * @author Sven
	 */
	public Mana_and_Life_IncreaseEvent(GameLogic administration,
			int life_increase, int mana_increase) {
		super(administration);
		this.MANA_INCREASE = mana_increase;
		this.LIFE_INCREASE = life_increase;
	}

	@Override
	void execute() {
		Hero hero;

		// Erzeuge Liste fuer alle Helden, bei denen die Werte erhoeht werden
		// muessen.
		LinkedList<UUID> heroes = new LinkedList<UUID>();
		for (int i = 0; i < 8; i++)
			if (administration.getClientAdmin()[i] != null) {
				// Erhoehe die Werte und fuege Held in Liste ein.
				hero = administration.getClientAdmin()[i].getClientHero();
				if (hero.isAlive()) {
					hero.change_Akt_Life(LIFE_INCREASE);
					hero.change_Akt_mana(MANA_INCREASE);
					heroes.add(hero.getID());
				}
			}

		// Schicke Events an die Clients
		for (int j = 0; j < Waiter.getClients().size(); j++) {
			Communication.newClientMessage(new Mana_and_Life_UpdateEvent(Waiter
					.getClients().get(j).getId(), LIFE_INCREASE, MANA_INCREASE,
					heroes));
		}

	}

}
