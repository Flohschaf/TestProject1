package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import pp2013.gruppe07.shared.Tile;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Wird einmal am Anfang des Spiels geschickt, um die Map zu uebergeben
 * 
 * @author Felix,Sven
 * 
 */
public class WorldCreateEvent extends Event {

	Tile[][] world;

	/**
	 * @param id
	 * @param world
	 * @author Sven,Felix
	 */
	public WorldCreateEvent(int id, Tile[][] world) {
		super(id, Event.Type.WORLD_CREATE_EVENT);
		this.world = world;
	}

	/**
	 * @return
	 * @author Sven,Felix
	 */
	public Tile[][] getWorld() {
		return this.world;
	}

	/**
	 * @param id
	 * @author Sven,Felix
	 */
	public void setClientId(int id) {
		clientID = id;
	}
}
