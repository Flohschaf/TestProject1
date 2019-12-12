package pp2013.gruppe07.shared.communication;

import java.io.Serializable;

import pp2013.gruppe07.shared.Tile;
import pp2013.gruppe07.shared.entity.Vasall;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.WorldCreateEvent;


/**
 * In den Messages werden lediglich Events verschickt.
 * @author Felix
 *
 */
public class DMessage implements Serializable{
	
	public static final long serialVersionUID = 1;
	private String message;


	
	Event event;;
	 
	public DMessage(Event event){
		this.event = event;					
	}
	
	public Event getEvent(){		
		return this.event;
	}
	
}
