package pp2013.gruppe07.server.engine.special_attacks;

import java.util.LinkedList;
import java.util.List;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.ChangeValuesEvent;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.SpecialAttackUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ValuesUpdateEvent;
/**
 * @autor Steven
 * *Implementiert die SpezialAttacke "Kugelhagel": verringert ruestung der gegner im umkreis dauerhaft
 *
 */
public class Kugelhagel extends SpecialAttack {

	
	boolean enoughMana = false;
	public Kugelhagel(GameLogic administration,Hero hero) {
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
		hero.setAbilitiesaktivated(true, 0);
		

		//Schicke inkrementelles Update an die CLients
	
		for(int j = 0 ; j < Waiter.getClients().size();j++){
			Communication.newClientMessage(new SpecialAttackUpdateEvent(Waiter.getClients().get(j).getId(),hero.getID(), COST,0));	
		}

		int[] values={0,-20,0,0,0,0,0,0};	
		
		//zu veraendernder wert wird an alle clients uebergenen
		List<InteraktiveEntity> heroesInSouround = getHerosInVisibillityRange();
		if(!heroesInSouround.isEmpty()){
	
		for(InteraktiveEntity ob: heroesInSouround){
			this.heroesInSouroundCopy.add(ob);
		}}
				
		while(!heroesInSouround.isEmpty()){
			InteraktiveEntity erg= heroesInSouround.remove(0);
			erg.increaseValue(1, -20);
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
			
		
		hero.setAbilitiesaktivated(false, 0);
		
	}}
		
	}