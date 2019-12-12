package pp2013.gruppe07.server.engine.threads_and_KI;

import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.IncreaseMoneyEvent;
import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.Mana_and_Life_IncreaseEvent;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.server.statistic.statistics;

/**
 * Erhoeht regelmaessig das Gold und das Mana der Helden
 * 
 * @author Sven
 * @author Steven
 */
public class Taxometer_and_IncreaseThread implements Runnable {

	private GameLogic administration;
	int increase = 100;
	private statistics stat;

	/**
	 * @param administration
	 * @author Sven
	 */
	public Taxometer_and_IncreaseThread(GameLogic administration) {
		this.administration = administration;
		this.stat = new statistics(administration);
	}

	/**
	 * Erhoehe regelmaessig die Lebensenergie, das Mana und das Geld der Helden.
	 * 
	 * @author Sven
	 */
	@Override
	public void run() {
		int counter = 0;
		while (administration.isRunning()) {
			try {
				Thread.sleep(1000);
				counter++;
				administration.get_eventManager()
						.addEvent(
								new Mana_and_Life_IncreaseEvent(administration,
										10, 10));

				// Erhoehe alle 15 Sekunden das Geld der Helden
				if (counter % 15 == 0) {
					administration.get_eventManager().addEvent(
							new IncreaseMoneyEvent(administration, increase));
					counter = 0;

				}
			}

			catch (InterruptedException e) {

			}
		}
	}

}
