package pp2013.gruppe07.server.engine.special_attacks;


import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.server.engine.threads_and_KI.RespawnTimer;

import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.Inhibitor;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.Nexus;
import pp2013.gruppe07.shared.entity.SpaceHolder;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.IncreaseXPEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.Mana_and_Life_UpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.PureLifeUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.SpecialAttackUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ValuesUpdateEvent;

/**Implementiert die SpezialAttacke "Erdbeben": Schaedigt Gegner Umkreis
 * @author Steven
 *
 */

public class Rundumschlag extends SpecialAttack {
	boolean enoughMana = false;
	public Rundumschlag(GameLogic administration,Hero hero) {
		super(administration,100,hero,true);		
	}

	
	 /**
		 * @autor Steven
		 * wird beim Aufrufen der Spezialattacke ausgefuehrt
		 *
		 */
	@Override
	public void execute() {
		//noetig, weil vent linkedlist der betroffenen figuren braucht
		LinkedList<UUID> h = new LinkedList<UUID>();
		if(hero.getAkt_mana()>=100)
			enoughMana = true;
			if (enoughMana == true){
		 //ziehe manakosten fuer die spezialattacke ab
		hero.change_Akt_mana(-COST);
		 //mache die spezialattacke sichtbar
		hero.setAbilitiesaktivated(true, 2);
		


		
		//Schicke inkrementelles Update an die CLients
		int[] values={0,0,0,0,0,0,0,0};
		
		for(int j = 0 ; j < Waiter.getClients().size();j++){
			Communication.newClientMessage(new SpecialAttackUpdateEvent(Waiter.getClients().get(j).getId(),hero.getID(), COST,2));	
		}

			
		//allen aus der linkedlist leben abziehen und anderen servern melden
		List<InteraktiveEntity> heldenUmgebung = getHerosInVisibillityRange();
		while(!heldenUmgebung.isEmpty()){
			
			InteraktiveEntity erg= heldenUmgebung.remove(0);
		
			erg.change_Akt_Life(-100);
			
			// Entferne den Gegner je nachdem aus dem Spiel
			if (erg.get_Akt_Life() == 0) {
				erg.kill();
				int x = erg.getPosition()[0];
				int y = erg.getPosition()[1];
				administration.get_map()[x][y].setobject(new SpaceHolder(x, y));
				
				// Erhoehe die Erfahrungspunkte des Helden
					
				boolean levelUp = hero.increase_Akt_XP(erg.getGIVE_XP());

				// Wenn ein Levelup erfolgt ist...
				if (levelUp) {
					// ...dann erhoehe die Werte und setze Leben und
					// Mana auf maximale Punkte
					// Schicke anschliessen die entsprechenden Events an
					// die Clients
					int[] newValues = { 10, 5, 5, 0, 0, 5, 150, 150 };
					for (int i = 0; i < 8; i++) {
						hero.increaseValue(i, newValues[i]);
					}
					hero.change_Akt_Life(hero.getvalue(6));
					hero.change_Akt_mana(hero.getvalue(7));
					}
				
				

					// Regele den Respawn des Helden
					if (erg instanceof Hero) {
						administration.getThreadPool().execute(
								new RespawnTimer(administration, (Hero) erg));
					}
	
					// Oder entferne den Gegner aus der Liste
					else {
						administration.get_entities().remove(erg.getID());					
					}
				}
			
			h.add(erg.getID());		
			}
		}
			
		
		for(int j = 0 ; j < Waiter.getClients().size();j++){			
			Communication.newClientMessage(new PureLifeUpdateEvent(Waiter.getClients().get(j).getId(), -100,  h,hero.getID()));
			
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


