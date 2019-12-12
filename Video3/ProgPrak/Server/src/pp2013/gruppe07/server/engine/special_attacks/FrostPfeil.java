package pp2013.gruppe07.server.engine.special_attacks;

import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.server.engine.special_attacks.SpecialAttack;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.PureLifeUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.SpecialAttackUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ValuesUpdateEvent;

/**
 * @author Steven
 * Implementiert die SpezialAttacke "FrostPfeil": laesst gegner im umkreis kurzzeitig erstarren
 */

public class FrostPfeil extends SpecialAttack {
	boolean enoughMana = false;
	public FrostPfeil(GameLogic administration,Hero hero) {
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
		hero.setAbilitiesaktivated(true, 2);
		

		//Schicke inkrementelles Update an die CLients
	
		for(int j = 0 ; j < Waiter.getClients().size();j++){
			Communication.newClientMessage(new SpecialAttackUpdateEvent(Waiter.getClients().get(j).getId(),hero.getID(), COST,2));	
		}

		int[] values={0,0,0,0,6000,0,0,0};	
		
		//holt figuren in umgebung und speichert diese
		List<InteraktiveEntity> heroesInSouround = getHerosInVisibillityRange();
		if(!heroesInSouround.isEmpty()){
	//kopieren um spaeter zuruecksetzten zu koennen
		for(InteraktiveEntity ob: heroesInSouround){
			this.heroesInSouroundCopy.add(ob);
		}}
			//eigentliches zurueecksetzen	
		while(!heroesInSouround.isEmpty()){
			InteraktiveEntity erg= heroesInSouround.remove(0);
			erg.increaseValue(4, 6000);
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
//setzt aenderunfen wieder zurueck
		try {
			Thread.sleep(6000);
			} 
		catch (InterruptedException e) {			
			e.printStackTrace();
			}

int[] values={0,0,0,0,-6000,0,0,0};	
		while(!heroesInSouroundCopy.isEmpty()){
			InteraktiveEntity erg= heroesInSouroundCopy.remove(0);
			erg.increaseValue(4, -6000);
			for(int j = 0 ; j < Waiter.getClients().size();j++){
				Communication.newClientMessage(new ValuesUpdateEvent(Waiter.getClients().get(j).getId(),erg.getID(),values));
				
			}}
			
	
		}
		
		
		hero.setAbilitiesaktivated(false, 0);
		
	}
		
	}