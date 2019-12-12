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
 * @author Steven
 *Implementiert die SpezialAttacke "Eispfeil": verlangsamt angriffsgeschwindigkeit der gegner im umkreis kurzzeitig
 */
public class Eispfeil extends SpecialAttack {
	boolean enoughMana = false;	
	
	public Eispfeil(GameLogic administration,Hero hero) {
		super(administration,100,hero,true);		
	}
	
	private List<InteraktiveEntity> heroesInSouroundCopy = new LinkedList<InteraktiveEntity>();;
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

		int[] values={0,0,0,-20,0,0,0,0};	
		
		//hole alle helden aus der umgebung
		List<InteraktiveEntity> heroesInSouround = getHerosInVisibillityRange();
		if(!heroesInSouround.isEmpty()){
	//copie um spaeter wieder zurueckzusetzen
		for(InteraktiveEntity ob: heroesInSouround){
			this.heroesInSouroundCopy.add(ob);
		}}
				//gehe alle elemente durch und erniedrige
		while(!heroesInSouround.isEmpty()){
			InteraktiveEntity erg= heroesInSouround.remove(0);
			erg.increaseValue(3, -20);
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
		
		//alle werte wieder durchgehen und zuruecksetzten
int[] values={0,0,0,20,0,0,0,0};	

		while(!heroesInSouroundCopy.isEmpty()){

			InteraktiveEntity erg= heroesInSouroundCopy.remove(0);
			erg.increaseValue(3, 20);
			for(int j = 0 ; j < Waiter.getClients().size();j++){
				Communication.newClientMessage(new ValuesUpdateEvent(Waiter.getClients().get(j).getId(),erg.getID(),values));
				
			}
			
	
		}
		
		
		hero.setAbilitiesaktivated(false, 1);
		
	}}
		
	}