package pp2013.gruppe07.server.engine.eventmanager_and_serverevents;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.MoneyUpdateEvent;

/**
 * Erhoeht das Geld eines Spielers/Helden
 * 
 * @author Sven
 * 
 */
public class IncreaseMoneyEvent extends GameEvent {

	int increase;

	/**
	 * @param administration
	 * @param increase
	 * @author Sven
	 */
	public IncreaseMoneyEvent(GameLogic administration, int increase) {
		super(administration);
		this.increase = increase;
	}

	@Override
	void execute() {

		// Erhoehe Geld aller Helden
		for (int i = 0; i < 8; i++) {
			if (administration.getClientAdmin()[i] != null) {
				administration.getClientAdmin()[i].getClientHero().changeMoney(
						increase);

			}
		}

		// Sende die Events an die Clients
		for (int j = 0; j < Waiter.getClients().size(); j++) {
			Communication.newClientMessage(new MoneyUpdateEvent(Waiter
					.getClients().get(j).getId(), increase));
		}

	}

}
