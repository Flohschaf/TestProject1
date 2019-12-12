package pp2013.gruppe07.shared.eventManager.event.InternalCLient;

import pp2013.gruppe07.shared.ClientAdmin;
import pp2013.gruppe07.shared.Tile;
import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * Teilt dem Client intern mit, dass das Spiel gestartet wurde.
 * @author Felix
 *
 */
public class InternalStartGameEvent extends Event{

	Tile[][] map;
	ClientAdmin admin;
	
	public InternalStartGameEvent(int clientid,Tile[][]map,ClientAdmin admin) {
		super(clientid,Event.Type.INTERNAL_START_GAME_EVENT);
		this.map = map;
		this.admin = admin;
	}
	
	public ClientAdmin getAdmin(){
		return this.admin;
	}
	
	public Tile[][] getMap(){
		return this.map;
	}

}
