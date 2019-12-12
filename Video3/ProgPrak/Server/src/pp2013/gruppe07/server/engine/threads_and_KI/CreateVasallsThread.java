package pp2013.gruppe07.server.engine.threads_and_KI;

import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.CreateVasallEvent;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.Vasall.Type;

/**
 * Laeuft das ganze Spiel ueber und erstellt regelmaessig neue
 * CreateVasallEvents zur Erzeugeung neuer Vasallen
 * 
 * @author Sven
 */
public class CreateVasallsThread implements Runnable {

	private GameLogic administration;

	/**
	 * @param administration
	 * @author Sven
	 */
	public CreateVasallsThread(GameLogic administration) {
		this.administration = administration;
	}

	/**
	 * Regelt das regelmaessige Erzeugen der Vasallen
	 * 
	 * @author Sven
	 */
	@Override
	public void run() {

		// Warte 5 Sekunden ab, bis die Vasallen starten
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {

		}

		// Sollange das Spiel laeuft
		while (administration.isRunning()) {
			// Erzeuge auf jeder Lane je Team 6 Vasallen, wobei die ersten 3
			// Pinguine und die naechsten 3
			// Eichhoernchen sind. Wenn der Inhibitor des Gegeners zerstoert
			// ist, ist der 6. Vasall ein Baer.
			for (int k = 1; k <= 1; k++) {//df2015
				for (int team = 1; team <= 2; team++) {
					for (int lane = 1; lane <= 3; lane++) {
						Type type;
						Team teamType;
						if (k < 4) {
							type = Type.PINGUIN;
						} else {
							if (k == 6) {
								if ((!administration.isInhibitorAliveBlue() && team == 1)
										|| (!administration
												.isInhibitorAliveRed() && team == 2)) {
									type = Type.SUPER_VASALL;
								} else {
									type = Type.SQUIRREL;
								}
							} else {
								type = Type.SQUIRREL;
							}
						}
						if (team == 1) {
							teamType = Team.RED;
						} else {
							teamType = Team.BLUE;
						}

						// Erzeuge den Vasallen
						administration.get_eventManager().addEvent(
								new CreateVasallEvent(administration, lane,
										teamType, type));
					}
				}

				// Lasse Abstand zwischen den Vasallen, damit sich die bereits
				// erzeugten schonmal wegbewegen
				// koennen.

				if (administration.selfmadeSleeper())
					administration.sleeper(500);
				else {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {

					}
				}
			}

			// Alle 45 Sekunden werden neue Vasallen erzeugt.
			try {
				Thread.sleep(45000);
			} catch (InterruptedException e) {

			}
		}
	}

}
