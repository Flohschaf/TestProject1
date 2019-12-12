package pp2013.gruppe07.server.engine.threads_and_KI;

import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.RespawnHeroEvent;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Hero;

/**
 * Ist ein Timer der nach einer gewissen Zeit den Hero wiederbelebt
 * 
 * @author Sven
 */
public class RespawnTimer implements Runnable {

	private Hero hero;
	private GameLogic administration;

	/**
	 * @param administration
	 * @param hero
	 * @author Sven
	 */
	public RespawnTimer(GameLogic administration, Hero hero) {
		this.administration = administration;
		this.hero = hero;
	}

	/**
	 * Schlafe 5 Sekunden und belebe dann den Helden durch das entsprechende
	 * Event wieder
	 * 
	 * @author Sven
	 */
	@Override
	public void run() {
		if (administration.selfmadeSleeper()) {
			administration.sleeper(5000);
		} else {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}
		}
		administration.get_eventManager().addEvent(
				new RespawnHeroEvent(administration, hero));

	}

}
