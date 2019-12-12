package pp2013.gruppe07.server.engine.eventmanager_and_serverevents;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.values;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.RespawnUpdateEvent;

/**
 * Setzt den Hero wieder auf eine Startposition und belebt ihn wieder
 * 
 * @author Sven
 * 
 */
public class RespawnHeroEvent extends GameEvent {

	private Hero hero;

	/**
	 * @param administration
	 * @param hero
	 * @author Sven
	 */
	public RespawnHeroEvent(GameLogic administration, Hero hero) {
		super(administration);
		this.hero = hero;

	}

	@Override
	void execute() {

		// Bestimme Startposition des Helden
		int[] startPosition = new int[2];
		if (hero.getTeam().equals(Team.RED)) {
			startPosition[0] = 115;
			startPosition[1] = 23;

			// Wenn die Standardposition besetzt ist, gehe die erste Lane
			// entlang, bis eine Kachel frei ist.
			while (administration.get_map()[startPosition[0]][startPosition[1]]
					.isCurrentlyBlocked()) {
				startPosition[0]--;
			}
		} else {
			startPosition[0] = 23;
			startPosition[1] = 115;

			// Wenn die Standardposition besetzt ist, gehe die dritte Lane
			// entlang, bis eine Kachel frei ist.
			while (administration.get_map()[startPosition[0]][startPosition[1]]
					.isCurrentlyBlocked()) {
				startPosition[0]++;
			}
		}

		// Setze den Helden wieder auf die Karte in die Naehe des Shops, belebe
		// ihn wieder und setze sein
		// Leben auf maximale Punktzahl
		administration.get_map()[startPosition[0]][startPosition[1]]
				.setobject(hero);
		hero.setPosition(startPosition[0], startPosition[1]);
		hero.change_Akt_Life(hero.getvalue()[values.LIFE.ordinal()]);
		hero.reanimate();

		// Sende Nachricht an die Clients
		for (int j = 0; j < Waiter.getClients().size(); j++) {
			Communication.newClientMessage(new RespawnUpdateEvent(Waiter
					.getClients().get(j).getId(), hero.getID(), startPosition));
		}

	}

}
