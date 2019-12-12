package pp2013.gruppe07.server.engine.special_attacks;

import java.util.LinkedList;
import java.util.UUID;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.ChangeValuesEvent;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.Mana_and_Life_UpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.SpecialAttackUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ValuesUpdateEvent;

/**
 * @author Steven
 **Implementiert die SpezialAttacke "Supersayajin": Erhoeht alle Heldenwerte fuer kurze Zeit
 */
public class Supersayajin extends SpecialAttack {
	boolean enoughMana = false;
	
	public Supersayajin (GameLogic administration,Hero hero) {
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
		//veranedert werte des clients
		hero.increaseValue(0, 100);
		hero.increaseValue(1, 50);
		hero.increaseValue(2, 50);
		hero.increaseValue(4, 60);
		hero.increaseValue(5, 50);
		hero.change_Akt_Life(50);
		 //ziehe manakosten fuer die spezialattacke ab
		hero.change_Akt_mana(-COST);
		
		// mache die spezialattacke sichtbar
		hero.setAbilitiesaktivated(true, 1);
	
		//liste, welche Mana_and_Life_UpdateEvent braucht
		LinkedList<UUID> h = new LinkedList<UUID>();
		h.add(hero.getID());
				
		//Schicke inkrementelles Update an die CLients
		int[] values={100,50,50,0,60,50,0,0};
		for(int j = 0 ; j < Waiter.getClients().size();j++){
			//muss in jedes specialevent, auch fuer die animation. ziffer am ende steht fuer id der specialattacke
			Communication.newClientMessage(new SpecialAttackUpdateEvent(Waiter.getClients().get(j).getId(),hero.getID(), COST,1));
			Communication.newClientMessage(new ValuesUpdateEvent(Waiter.getClients().get(j).getId(),hero.getID(),values ));
			Communication.newClientMessage(new Mana_and_Life_UpdateEvent(Waiter.getClients().get(j).getId(), 200, 50, h));
		}
			}
//	

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
		int[] values={-100,-50,-50,0,-60,-50,0,0};
		administration.get_eventManager().addEvent(new ChangeValuesEvent(administration,hero,values));
		
		LinkedList<UUID> h = new LinkedList<UUID>();
		h.add(hero.getID());
	
		//Schicke inkrementelles Update an die CLients
				
				for(int j = 0 ; j < Waiter.getClients().size();j++){					
					Communication.newClientMessage(new Mana_and_Life_UpdateEvent(Waiter.getClients().get(j).getId(), 200, 50, h));
				}
	
		}
	
	}
	



}
