package pp2013.gruppe07.shared.eventManager.event.ClientToServer;

import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * 
 * @author Felix
 *
 */
public class InfoEvent extends Event{

	String info;
	
	public InfoEvent(int id , String info) {
		super(id,Event.Type.INFO_EVENT);
		this.info = info;
		
	}
	
	public String getInfo(){
		return this.info;
	}

}
