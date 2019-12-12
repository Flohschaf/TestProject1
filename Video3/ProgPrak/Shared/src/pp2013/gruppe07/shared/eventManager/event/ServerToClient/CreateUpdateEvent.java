package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Sagt dem Client, dass eine Figur erzeugt wurde und uebergibt diese. Die
 * Psotion auf der diese erzeugt wurde ist frei, da das Erschaffen ueber den
 * EventManager gelaufen ist.
 * 
 * @author Sven
 * 
 */
public class CreateUpdateEvent extends Event {

	private Figure figure;

	/**
	 * @param clientid
	 * @param figure
	 * @author Sven
	 */
	public CreateUpdateEvent(int clientid, Figure figure) {
		super(clientid, Type.CREATE_UPDATE_EVENT);
		this.figure = figure;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public Figure getFigure() {
		return figure;
	}

	/**
	 * @param id
	 * @author Sven
	 */
	public void setClientId(int id) {
		clientID = id;
	}

}
