package pp2013.gruppe07.server.engine.special_attacks;

import java.util.LinkedList;
import java.util.List;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.SpecialAttackUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ValuesUpdateEvent;
/**
 * @autor Steven
 * Implementiert die SpezialAttacke "HoherTon": gibt Teammitgliedern in Umgebung dauerhaft mehr Magie
 *
 */
public class HoherTon extends SpecialAttack {

	boolean enoughMana = false;
	
	public HoherTon(GameLogic administration,Hero hero) {
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
//zu erhoehender wert
		int[] values={0,0,0,0,0,30,0,0};	
		
		
		List<InteraktiveEntity> heroesInSouround = getHerosInVisibillityRangeSameTeam();
		
				//geht alle helden in umgebung durch und uebernimmt wert
		while(!heroesInSouround.isEmpty()){
			InteraktiveEntity erg= heroesInSouround.remove(0);
			erg.increaseValue(5, 30);
			for(int j = 0 ; j < Waiter.getClients().size();j++){
				Communication.newClientMessage(new ValuesUpdateEvent(Waiter.getClients().get(j).getId(),erg.getID(),values));
				
			}
			
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