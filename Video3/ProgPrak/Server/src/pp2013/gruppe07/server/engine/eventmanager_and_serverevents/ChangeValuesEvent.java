package pp2013.gruppe07.server.engine.eventmanager_and_serverevents;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ValuesUpdateEvent;

/**
 * Soll die Werte eines Helden nach einer SpezialAttacke wieder korrigieren
 * 
 * @author Sven
 */
public class ChangeValuesEvent extends GameEvent {

	private Hero hero;
	private int[] valueIncrease = new int[8];

	/**
	 * Bekommt insbesondere sie alten Werte uebergeben
	 * 
	 * @param administration
	 * @param hero
	 * @param valueIncrease
	 * @author Sven
	 */
	public ChangeValuesEvent(GameLogic administration, Hero hero,
			int[] valueIncrease) {
		super(administration);
		this.hero = hero;
		this.valueIncrease = valueIncrease;

	}

	@Override
	void execute() {

		// Setze die Werte auf die uebergebenen zurueck.
		for (int i = 0; i < 8; i++) {
			hero.increaseValue(i, valueIncrease[i]);
		}

		// Sende inkrementelle Updates an Clients

		for (int i = 0; i < Waiter.getClients().size(); i++) {
			Communication.newClientMessage(new ValuesUpdateEvent(Waiter
					.getClients().get(i).getId(), hero.getID(), valueIncrease));
		}
		// Communication.newClientMessage(new
		// ValuesUpdateEvent(-1,hero.getID(),valueIncrease));

	}

}
