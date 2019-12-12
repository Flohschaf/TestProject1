package pp2013.gruppe07.server.engine.special_attacks;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.ChangeValuesEvent;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.SpecialAttackUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ValuesUpdateEvent;

/**
 * @author Steven
 * Implementiert die SpezialAttacke "Clitisieren": erhoeht die eigene bewegungsgeschwindigkeit kurzzeitig
 */
public class Clitisieren extends SpecialAttack {
	boolean enoughMana = false;
	public Clitisieren(GameLogic administration,Hero hero) {
		super(administration,50,hero,true);
		
	}
	/**
	 * @autor Steven
	 * wird beim Aufrufen der Spezialattacke ausgefuehrt
	 *
	 */
	public void execute() {		
		if(hero.getAkt_mana()>=100)
			enoughMana = true;
			if (enoughMana == true){
		//veringert wert von values
		hero.increaseValue(4, -100);
		 //ziehe manakosten fuer die spezialattacke ab
		hero.change_Akt_mana(-COST);
		 //mache die spezialattacke sichtbar
		hero.setAbilitiesaktivated(true, 2);	
		

		//Schicke inkrementelles Update an die CLients
		int[] values={0,0,0,0,-100,0,0,0};
		
		for(int j = 0 ; j < Waiter.getClients().size();j++){
			Communication.newClientMessage(new SpecialAttackUpdateEvent(Waiter.getClients().get(j).getId(),hero.getID(), COST,2));
			Communication.newClientMessage(new ValuesUpdateEvent(Waiter.getClients().get(j).getId(),hero.getID(),values ));
		}		
			}
		}


	/**
	 * @autor Steven
	 * wird ausgefuehrt um gesetzte werte nach einer gewissen zeit zurueckzusetzten
	 *
	 */
	@Override
	public void run() {
		if (enoughMana == true){
		try {
			Thread.sleep(10000);
			} 
		catch (InterruptedException e) {			
			e.printStackTrace();
			}
		int[] values={0,0,0,0,100,0,0,0};
		hero.setAbilitiesaktivated(false, 2);
		administration.get_eventManager().addEvent(new ChangeValuesEvent(administration,hero,values));
		
	}

}}

