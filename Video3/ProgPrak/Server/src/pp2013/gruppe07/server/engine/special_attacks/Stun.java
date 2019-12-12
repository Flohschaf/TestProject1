package pp2013.gruppe07.server.engine.special_attacks;

import java.util.List;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.ChangeValuesEvent;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.SpecialAttackUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ValuesUpdateEvent;


//laesst gegnerische Einheiten einfrieren (fuer kurze zeit)
public class Stun extends SpecialAttack {

	List<InteraktiveEntity> heldenUmgebungCopy = getHerosInVisibillityRange();
	public Stun(GameLogic administration,Hero hero) {
		super(administration,300,hero,true);		
	}
	
	
	@Override
	public void execute() {
		
		
		
		hero.change_Akt_mana(-COST);
		hero.setAbilitiesaktivated(true, 0);
		
		
		

		//Schicke inkrementelles Update an die CLients
		for(int j = 0 ; j < Waiter.getClients().size();j++){
			Communication.newClientMessage(new SpecialAttackUpdateEvent(Waiter.getClients().get(j).getId(),hero.getID(), COST,0));
			
		}
//		Communication.newClientMessage(new SpecialAttackUpdateEvent(-1, hero.getID(), COST,0));
		
		
		
		
		List<InteraktiveEntity> heldenUmgebung = getHerosInVisibillityRange();
		heldenUmgebungCopy = heldenUmgebung;
		while(!heldenUmgebung.isEmpty()){
			InteraktiveEntity erg= heldenUmgebung.remove(0);
			int k= 4000;	
			
			erg.increaseValue(4, k);
		}
	}

	@Override
	public void run() {
		List<InteraktiveEntity> figuresUmgebung = getHerosInVisibillityRange();
		try {
			Thread.sleep(4000);
			} 
		catch (InterruptedException e) {			
			e.printStackTrace();
			}
		int k = heldenUmgebungCopy.get(0).getvalue(4);
		int[] values={0,0,0,0,k,0,0,0};
		while(!figuresUmgebung.isEmpty()){
			InteraktiveEntity erg= heldenUmgebungCopy.remove(0);		
		administration.get_eventManager().addEvent(new ChangeValuesEvent(administration,(Hero)erg,values));
	}}
	
		
	}


