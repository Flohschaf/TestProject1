package pp2013.gruppe07.server.engine.eventmanager_and_serverevents;

import pp2013.gruppe07.server.engine.general.GameLogic;

/**
 * Ist die Oberklasse von der alle ServerEvents erben. *
 * 
 * @author Sven
 */
abstract class GameEvent {

	protected GameLogic administration;

	/**
	 * @param administration
	 * @author Sven
	 */
	public GameEvent(GameLogic administration) {
		this.administration = administration;
	}

	/**
	 * @author Sven Diese Methode stellt die Ausfuehrung des Events dar und wird
	 *         von den Unterklassen ueberschrieben
	 */
	abstract void execute();

}
