package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Signalisiert dem Client, dass das Spiel zu Ende ist und gibt an, wer das
 * Spiel gewonnen hat, wenn es nicht vorzeitig beendet wurde.
 * 
 * @author Sven
 * 
 */
public class EndGameUpdateEvent extends Event {

	private final Team WON_TEAM;

	/**
	 * @param clientid
	 * @author Sven
	 */
	public EndGameUpdateEvent(int clientid, Team wonTeam) {
		super(clientid, Type.END_GAME_UPDATE_EVENT);
		this.WON_TEAM = wonTeam;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public Team getWON_TEAM() {
		return WON_TEAM;
	}

}
