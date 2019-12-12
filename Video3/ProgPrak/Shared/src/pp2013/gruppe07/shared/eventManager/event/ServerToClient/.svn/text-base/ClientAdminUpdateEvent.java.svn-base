package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import pp2013.gruppe07.shared.ClientAdmin;
import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Wird einmal am Anfang des Spiels geschickt, um die Clientadministration zu
 * schicken
 * 
 * @author Felix,Sven
 * 
 */
public class ClientAdminUpdateEvent extends Event {

	ClientAdmin admin;

	/**
	 * @param id
	 * @param admin
	 * @author Sven,Felix
	 */
	public ClientAdminUpdateEvent(int id, ClientAdmin admin) {
		super(id, Event.Type.CLIENT_ADMIN_UPDATE_EVENT);
		this.admin = admin;
	}

	/**
	 * @return
	 * @author Sven,Felix
	 */
	public ClientAdmin getAdmin() {
		return this.admin;
	}

	/**
	 * @param id
	 * @author Sven,Felix
	 */
	public void setClientId(int id) {
		clientID = id;
	}

}
