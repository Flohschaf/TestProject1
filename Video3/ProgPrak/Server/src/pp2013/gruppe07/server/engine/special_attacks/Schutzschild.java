package pp2013.gruppe07.server.engine.special_attacks;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.ChangeValuesEvent;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.SpecialAttackUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ValuesUpdateEvent;

/**
 * Implementiert die SpezialAttacke "Schutzschild"
 * 
 * @author Sven
 * 
 */
public class Schutzschild extends SpecialAttack {
	boolean enoughMana = false;
	public Schutzschild(GameLogic administration, Hero hero) {
		super(administration,100,hero,true);

	}

	// Ist die Ausfuehrung dieser Attacke. Zieht Mana ab. Erhoeht die Werte.
	@Override
	public void execute() {
		if(hero.getAkt_mana()>=100)
			enoughMana = true;
			if (enoughMana == true){
		hero.increaseValue(1, 40);
		hero.change_Akt_mana(-COST);
		hero.setAbilitiesaktivated(true, 0);

		// Schicke inkrementelles Update an die CLients
		int[] values = { 0, 40, 0, 0, 0, 0, 0, 0 };

		for (int j = 0; j < Waiter.getClients().size(); j++) {
			Communication.newClientMessage(new SpecialAttackUpdateEvent(Waiter
					.getClients().get(j).getId(), hero.getID(), COST, 0));
			Communication.newClientMessage(new ValuesUpdateEvent(Waiter
					.getClients().get(j).getId(), hero.getID(), values));
		}

	}}

	// Setzt die Werte nach 5 Sekunden zuerueck.
	@Override
	public void run() {
		if (enoughMana == true){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int[] values = { 0, -40, 0, 0, 0, 0, 0, 0 };
		hero.setAbilitiesaktivated(false, 0);
		administration.get_eventManager().addEvent(
				new ChangeValuesEvent(administration, hero, values));

	}
	}
}
