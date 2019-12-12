package pp2013.gruppe07.server.engine.special_attacks;

import java.util.LinkedList;
import java.util.UUID;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.Mana_and_Life_UpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.SpecialAttackUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ValuesUpdateEvent;

/**
 * @author Steven
 * Implementiert die SpezialAttacke "Selbstheilen": heilt den helden komplett
 */

public class SelbstHeilen extends SpecialAttack{
	boolean enoughMana = false;
	public SelbstHeilen(GameLogic administration,Hero hero) {
		super(administration,100,hero,true);		
	}
	 /**
		 * @autor Steven
		 * wird beim Aufrufen der Spezialattacke ausgefuehrt
		 *
		 */
	@Override
	public void execute() {
		if(hero.getAkt_mana()>=100)
			enoughMana = true;
			if (enoughMana == true){
		 //ziehe manakosten fuer die spezialattacke ab
	hero.change_Akt_mana(-COST);
	 //mache die spezialattacke sichtbar
	hero.setAbilitiesaktivated(true, 0);
	int maxLife=hero.getvalue(6);
	int erhoehen = maxLife;
	//veranedert wert bei hero
	hero.change_Akt_Life(erhoehen);
	


	
	//liste, 
	LinkedList<UUID> h = new LinkedList<UUID>();
	h.add(hero.getID());
	//Schicke inkrementelles Update an die CLients
	 //zu veraendernder wert wird an alle clients uebergenen
	for(int j = 0 ; j < Waiter.getClients().size();j++){
		Communication.newClientMessage(new SpecialAttackUpdateEvent(Waiter.getClients().get(j).getId(),hero.getID(), COST,0));
		Communication.newClientMessage(new Mana_and_Life_UpdateEvent(Waiter.getClients().get(j).getId(), erhoehen, 0, h));
	}		
	}}
	/**
	 * @autor Steven
	 * wird ausgefuehrt um gesetzte werte nach einer gewissen zeit zurueckzusetzten
	 *
	 */
	@Override
	public void run() {	
		if (enoughMana == true){
		try {
			Thread.sleep(1000);
			} 
		catch (InterruptedException e) {			
			e.printStackTrace();
			}
		
		hero.setAbilitiesaktivated(false, 0);
	}
	
	
	}
	

}
