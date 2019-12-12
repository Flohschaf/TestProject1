package pp2013.gruppe07.server.engine.general;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.Hero.Heronames;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.LobbyTeamListEvent;
/*
 * @autor Steven
 * @autor pivo
 */
public class Lobby {

	// Chat lobbyChat = new Chat();

	// LinkedList<Heronames> teamBLUE = new LinkedList<Heronames>();
	// LinkedList<Heronames> teamRED = new LinkedList<Heronames>();
	LinkedList<LobbyHero> teamBLUEext = new LinkedList<LobbyHero>();
	LinkedList<LobbyHero> teamREDext = new LinkedList<LobbyHero>();
	private static Lock lock = new ReentrantLock(true);
	int player = 0;

	public boolean timeLeft = true;

	public static void main(String args[]) {
		Lobby test = new Lobby();
		test.CountDown();
	}

	public void init() {
		lock.lock();
		LinkedList<Heronames> teamBLUE = new LinkedList<Heronames>();
		LinkedList<Heronames> teamRED = new LinkedList<Heronames>();

		for (int i = 0; i < 8; i += 2) {
			teamBLUEext.add(new LobbyHero(i, Heronames.EMPTY));
			teamREDext.add(new LobbyHero(i + 1, Heronames.EMPTY));

		}
		for (int i = 0; i < 4; i++) {
			teamBLUE.add(teamBLUEext.get(i).getHero());
			teamRED.add(teamREDext.get(i).getHero());

		}
		System.out.println( teamBLUEext.size()+" " +  teamREDext.size());
		
		lock.unlock();
	}

	public void playerAdder(int id, Heronames hero, Team team) {
		lock.lock();
		
	
		
		
		if (team.equals(Team.BLUE)) {
			
			boolean contains = false;
			for (int i = 0 ; i < teamBLUEext.size();i++) {
				
				LobbyHero heroTemp = teamBLUEext.get(i);
				if (heroTemp.getId() == id) {
					heroTemp.setHero(hero);
					contains = true;
					break;
				}
				
			}
			if (!contains) {
				
				for (int i = 0 ; i < teamBLUEext.size();i++ ) {
					
					LobbyHero heroTemp = teamBLUEext.get(i);
					if (heroTemp.getHero().equals(Heronames.EMPTY)) {

						for (int j = 0 ; j < teamREDext.size();j++) {
							
							LobbyHero heroSearch = teamREDext.get(j);
							if (heroSearch.getId() == id) {
								
								teamBLUEext.addFirst(heroSearch);
								teamREDext.remove(heroSearch);
								teamREDext.addFirst(heroTemp);
								teamBLUEext.remove(heroTemp);
								break;
							}
							

						}
						break;
					}
					
				}
			}

		}
		if (team.equals(Team.RED)) {
			
			boolean contains = false;
			for (int i = 0 ; i < teamREDext.size();i++) {
				
				LobbyHero heroTemp = teamREDext.get(i);
				if (heroTemp.getId() == id) {
					heroTemp.setHero(hero);
					contains = true;
					
					break;
				}
				
			}
			
			if (!contains) {
				
				for (int i = 0 ; i < teamREDext.size();i++) {
					
					
					LobbyHero heroTemp = teamREDext.get(i);
					if (heroTemp.getHero().equals(Heronames.EMPTY)) {
						System.out.println("empty at: "+i);
						for (int j = 0 ; j < teamBLUEext.size();j++) {
						
							LobbyHero heroSearch = teamBLUEext.get(j);
							if (heroSearch.getId() == id) {
								
								teamREDext.addFirst(heroSearch);
								teamBLUEext.remove(heroSearch);
								teamBLUEext.addFirst(heroTemp);
								teamREDext.remove(heroTemp);
								break;
							}

						}
						break;
					}
				}
				
				// Communication.newClientMessage(new LobbyTeamListEvent(id,
				// teamRED, teamBLUE));

			}
			
		}
		LinkedList<Heronames> teamBLUE = new LinkedList<Heronames>();
		LinkedList<Heronames> teamRED = new LinkedList<Heronames>();
		
		for (int i = 0; i < 4; i++) {
			teamBLUE.add(teamBLUEext.get(i).getHero());
			teamRED.add(teamREDext.get(i).getHero());

		}
		
		for(int i = 0 ; i < Waiter.getClients().size() ;i ++){
			Communication.newClientMessage(new LobbyTeamListEvent(Waiter.getClients().get(i).getId(), teamRED,
					teamBLUE));
		}
		
	
		
		
	lock.unlock();
	}

	
	
	public LinkedList<Heronames>getRed(){
		
		
		LinkedList<Heronames> teamRED = new LinkedList<Heronames>();
		
		for (int i = 0; i < 4; i++) {
			
			teamRED.add(teamREDext.get(i).getHero());

		}
		 return teamRED;
	}
	

	public LinkedList<Heronames>getBLUE(){
		
		
		LinkedList<Heronames> teamBLUE = new LinkedList<Heronames>();
		
		for (int i = 0; i < 4; i++) {
			
			teamBLUE.add(teamBLUEext.get(i).getHero());

		}
		 return teamBLUE;
	}
	
	

	public void lobbyWaiter() {
		lock.lock();
		CountDown();
		lock.unlock();
	}

	public void CountDown() {
		lock.lock();
		System.out.println("erferfgerf");
		int timer = 20;
		while (timer >= 0) {
			try {
				Thread.sleep(1000);
				timer--;
				System.out.println(timer);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} finally {
				timeLeft = false;
			}
		}
		lock.unlock();
	}
}
