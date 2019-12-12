package pp2013.gruppe07.shared.communication;

import java.util.LinkedList;

import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * 
 * @author Felix
 *
 */
class InternalSocket {
	
	
	public static void handleInput(){
		
		LinkedList<Event>messages = Communication.getClientMessage();
		
		for(Event message : messages){
			EventManager.callEvent(message);
			
		}
		
	}
}
