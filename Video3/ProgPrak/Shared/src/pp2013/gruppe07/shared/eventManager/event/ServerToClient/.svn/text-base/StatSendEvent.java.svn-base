package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * Sendet die Spielerstatistik an den Client.
 * @author Felix
 *
 */
public class StatSendEvent extends Event {

	private int id;

	private String[][] stat;

	public StatSendEvent(int clientid, String[][] stat) {
		super(clientid, Event.Type.STAT_SEND_EVENT);
		this.id = clientid;

		this.stat = stat;
	}


	public String[][] getStat() {
		return stat;
	}

}
