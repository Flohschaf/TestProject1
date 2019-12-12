package pp2013.gruppe07.server.engine.special_attacks;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.SpecialAttackUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ValuesUpdateEvent;
/**
 * @author Steven
 * Implementiert die SpezialAttacke "Unsichtbar": macht den helden fuer eine kurze zeit unsichtbar
 */
public class Unsichtbar extends SpecialAttack{
	boolean enoughMana = false;
	public Unsichtbar(GameLogic administration,Hero hero) {
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
	hero.setAbilitiesaktivated(true, 1);
	
	//Schicke inkrementelles Update an die CLients

	for(int j = 0 ; j < Waiter.getClients().size();j++){
		Communication.newClientMessage(new SpecialAttackUpdateEvent(Waiter.getClients().get(j).getId(),hero.getID(), COST,1));
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
			Thread.sleep(6000);
			} 
		catch (InterruptedException e) {			
			e.printStackTrace();
			}
		hero.setAbilitiesaktivated(false, 1);
	}}
	
	
	
	

}
