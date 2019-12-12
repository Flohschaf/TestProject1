package pp2013.gruppe07.server.engine.eventmanager_and_serverevents;

import java.util.UUID;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.server.engine.general.ID_Generator;
import pp2013.gruppe07.server.engine.threads_and_KI.VasallKI;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.Pinguin;
import pp2013.gruppe07.shared.entity.Squirrel;
import pp2013.gruppe07.shared.entity.SuperVasall;
import pp2013.gruppe07.shared.entity.Vasall;
import pp2013.gruppe07.shared.entity.Vasall.Type;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.CreateUpdateEvent;

/**
 * Erzeugt einen Vasall
 * 
 * @author Sven
 */
public class CreateVasallEvent extends GameEvent {

	private final int LANE;
	private final Team TEAM;
	private int[] first_dest_position = new int[2];
	private int[] startPosition;
	private final Type TYPE;

	/**
	 * Bekommt insbesondere den Type des Vasalls uebergeben
	 * 
	 * @param administration
	 * @param lane
	 * @param team
	 * @param type
	 * @author Sven
	 */
	public CreateVasallEvent(GameLogic administration, int lane, Team team,
			Type type) {
		super(administration);
		this.LANE = lane;
		this.TEAM = team;
		this.TYPE = type;

		this.startPosition = administration.getNexusPosition(team);
	}

	/**
	 * Berechnet die Standardstartposition der Vasallen in Abhaengigkeit der
	 * Lane und des Teams
	 * 
	 * @author Sven
	 */
	void calculatePositions() {
		switch (TEAM) {
		case RED: {
			switch (LANE) {
			case 1: {// 24,24
				startPosition[0]--;
				first_dest_position[0] = 24;
				first_dest_position[1] = 24;
				break;
			}
			case 2: {// 72,70
				startPosition[0]--;
				startPosition[1] += 2;
				first_dest_position[0] = 72;
				first_dest_position[1] = 70;
				break;
			}
			case 3: {// 113,113
				startPosition[1] += 2;
				startPosition[0]++;
				first_dest_position[0] = 113;
				first_dest_position[1] = 113;
				break;
			}
			}

			break;
		}
		case BLUE: {
			switch (LANE) {
			case 1: {// 27,27
				startPosition[1]--;
				first_dest_position[0] = 27;
				first_dest_position[1] = 27;
				break;
			}
			case 2: {// 68,70
				startPosition[0] += 2;
				startPosition[1]--;
				first_dest_position[0] = 68;
				first_dest_position[1] = 70;
				break;
			}
			case 3: {// 116,166
				startPosition[0] += 3;
				startPosition[1] += 2;
				first_dest_position[0] = 116;
				first_dest_position[1] = 116;
				break;
			}
			}
			break;
		}
		}
		while (administration.get_map()[startPosition[0]][startPosition[1]]
				.isCurrentlyBlocked()) {
			searchFreeTile();
		}
	}

	/**
	 * Erzeugt einen Vasall, sobald das Event an der Reihe ist
	 * 
	 * @author Sven
	 */
	@Override
	void execute() {
		// Berechne Startposition
		calculatePositions();
		Vasall newVasall;

		// Besorge dem Vasall eine ID.
		UUID id = ID_Generator.getID();

		// Erzeuge den Vasall entsprechend seines Types
		switch (TYPE) {
		case PINGUIN: {
			newVasall = new Pinguin(id, startPosition[0], startPosition[1],
					LANE, TEAM);
			break;
		}
		case SQUIRREL: {
			newVasall = new Squirrel(id, startPosition[0], startPosition[1],
					LANE, TEAM);
			break;
		}
		case SUPER_VASALL: {
			newVasall = new SuperVasall(id, startPosition[0], startPosition[1],
					LANE, TEAM);
			break;
		}
		default: {
			newVasall = null;
		}
		}

		// Starte eine VasallKI, setze den Vasallen auf die Karte und schreibe
		// ihn auf die HashMap
		administration.getThreadPool().execute(
				new VasallKI(newVasall, first_dest_position, administration));
		administration.get_map()[startPosition[0]][startPosition[1]]
				.setobject(newVasall);
		administration.get_entities().put(id, newVasall);

		// Schicke inkrementelles Update an die CLients
		for (int j = 0; j < Waiter.getClients().size(); j++) {
			Communication.newClientMessage(new CreateUpdateEvent(Waiter
					.getClients().get(j).getId(), newVasall));
		}

	}

	/**
	 * @author Sven Sucht nach einem freien Startplatz, falls der Standardplatz
	 *         belegt ist
	 */
	void searchFreeTile() {
		switch (TEAM) {
		case RED: {
			switch (LANE) {
			case 1: {
				startPosition[0]--;
				break;
			}
			case 2: {
				startPosition[0]--;
				startPosition[1]++;
				break;
			}
			case 3: {
				startPosition[1]++;
				break;
			}
			}

			break;
		}
		case BLUE: {
			switch (LANE) {
			case 1: {
				startPosition[1]--;
				break;
			}
			case 2: {
				startPosition[0]++;
				startPosition[1]--;
				break;
			}
			case 3: {
				startPosition[0]++;
				break;
			}
			}
			break;
		}
		}
	}

}
