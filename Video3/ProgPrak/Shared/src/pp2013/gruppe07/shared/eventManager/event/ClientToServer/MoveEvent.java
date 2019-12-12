package pp2013.gruppe07.shared.eventManager.event.ClientToServer;

import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * Event fuer Bewegungen
 * @author Felix
 *
 */
public class MoveEvent extends Event{


	int [] position;
	
	public MoveEvent(int id , int[]position) {
		super(id,Event.Type.MOVE_EVENT);

		this.position = position;
	}



	public int[] getPosition() {
		return position;
	}
	

}
