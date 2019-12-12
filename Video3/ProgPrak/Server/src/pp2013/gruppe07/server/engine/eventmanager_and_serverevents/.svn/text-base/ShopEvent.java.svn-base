package pp2013.gruppe07.server.engine.eventmanager_and_serverevents;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ItemUpdateEvent;
import pp2013.gruppe07.shared.item.Item;

/**
 * Fuehrt den Kauf eines Items durch einen Client durch.
 * 
 * @author Sven
 */
public class ShopEvent extends GameEvent {

	private int client;
	private Item item;

	/**
	 * @param administration
	 * @param client
	 * @param item
	 * @author Sven
	 */
	public ShopEvent(GameLogic administration, int client, Item item) {
		super(administration);
		this.client = client;
		this.item = item;
	}

	@Override
	public void execute() {
		Hero hero = administration.getClientAdmin()[client].getClientHero();
		if (hero.getMoney() >= item.getCost()) {
			// Versuche Item hinzuzufuegen.
			boolean add = hero.addItem(item);

			// Wenn das Item hinzugefuegt wurde, ziehe dem Hero Geld ab.
			if (add) {
				hero.changeMoney(-item.getCost());

				// Sende inkrementelle Updates an die Clients
				for (int j = 0; j < Waiter.getClients().size(); j++) {
					Communication.newClientMessage(new ItemUpdateEvent(Waiter
							.getClients().get(j).getId(), hero.getID(), item));
				}
			}
		}
	}

}
