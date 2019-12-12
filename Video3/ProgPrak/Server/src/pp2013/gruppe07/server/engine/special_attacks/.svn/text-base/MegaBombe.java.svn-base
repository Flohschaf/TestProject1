package pp2013.gruppe07.server.engine.special_attacks;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.Mana_and_Life_UpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.MoneyUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.PureLifeUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.SpecialAttackUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ValuesUpdateEvent;

/**
 * @author Steven
 *Implementiert die SpezialAttacke "MegaBombe": Zieht gegnerischen Helden in Umgebung Geld ab 
 *
 */

public class MegaBombe extends SpecialAttack {
	boolean enoughMana = false;
	public MegaBombe(GameLogic administration,Hero hero) {
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
		hero.setAbilitiesaktivated(true, 2);
		

		LinkedList<UUID> h = new LinkedList<UUID>();

		
		//Schicke inkrementelles Update an die CLients
		int[] values={0,0,0,0,0,0,0,0};
		//Schicke inkrementelles Update an die CLients
		
			for(int j = 0 ; j < Waiter.getClients().size();j++){
				Communication.newClientMessage(new SpecialAttackUpdateEvent(Waiter.getClients().get(j).getId(),hero.getID(), COST,0));	
			}

			
			//zu veraendernder wert wird an alle clients uebergenen
			List<InteraktiveEntity> heroesInSouround = getHerosInVisibillityRange();
			if(!heroesInSouround.isEmpty()){
		
			while(!heroesInSouround.isEmpty()){
				InteraktiveEntity erg= heroesInSouround.remove(0);
				if(erg instanceof Hero)
					((Hero) erg).changeMoney(-200);
					for(int i=0; i<8; i++){
					if(administration.getClientAdmin()[i]!= null){
						if(administration.getClientAdmin()[i].getClientHero().getID().equals(erg.getID())){
							Communication.newClientMessage(new MoneyUpdateEvent(administration.getClientAdmin()[i].getClientNr(), -200));
						
					}}}
					
			
				
			}}
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
		hero.setAbilitiesaktivated(false, 2);
		
	}
	}
	}
