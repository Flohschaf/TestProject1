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
 * Implementiert die SpezialAttacke "schoeneslied":erhoeht maximale lebensenergie dauerhaft. so kann der held in der naechsten angriffssituation laenger ueberleben
 */
	public class SchoenesLied extends SpecialAttack {
		boolean enoughMana = false;	
		public SchoenesLied (GameLogic administration,Hero hero) {
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
			//veranedert herowert
			hero.increaseValue(6, 40);
			 //ziehe manakosten fuer die spezialattacke ab
			hero.change_Akt_mana(-COST);
			 //mache die spezialattacke sichtbar
			hero.setAbilitiesaktivated(true, 0);	
			

			//Schicke inkrementelles Update an die CLients
			int[] values={0,0,0,0,0,0,40,0};
			
			for(int j = 0 ; j < Waiter.getClients().size();j++){
				//aktiviert bei allen spezialattacke und wertveraenderung
				Communication.newClientMessage(new SpecialAttackUpdateEvent(Waiter.getClients().get(j).getId(),hero.getID(), COST,0));
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
				Thread.sleep(5000);
				} 
			catch (InterruptedException e) {			
				e.printStackTrace();
				}

			hero.setAbilitiesaktivated(false, 0);
			
		}
		}
	}


