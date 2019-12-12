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
 *Implementiert die SpezialAttacke "Starker Schlag": Setzt Angrifsstarke fuer kurze Zeit hinauf
 */
public class HinterhaltsSchlag extends SpecialAttack {
	boolean enoughMana = false;	
	public HinterhaltsSchlag(GameLogic administration,Hero hero) {
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
	//veraendert wert bei hero
		hero.increaseValue(0, 400);
		//ziehe manakosten fuer die spezialattacke ab
		hero.change_Akt_mana(-COST);
		 //mache die spezialattacke sichtbar
		hero.setAbilitiesaktivated(true, 1);
		
		
		

		
		int[] values={400,0,0,0,0,0,0,0};
		//Schicke inkrementelles Update an die CLients
		for(int j = 0 ; j < Waiter.getClients().size();j++){
			 //zu veraendernder wert wird an alle clients uebergenen
			Communication.newClientMessage(new SpecialAttackUpdateEvent(Waiter.getClients().get(j).getId(),hero.getID(), COST,1));
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
			Thread.sleep(8000);
			} 
		catch (InterruptedException e) {			
			e.printStackTrace();
			}
		hero.setAbilitiesaktivated(false, 1);
		int[] values={-400,0,0,0,0,0,0,0};
		administration.get_eventManager().addEvent(new ChangeValuesEvent(administration,hero,values));
	}
	}


}
