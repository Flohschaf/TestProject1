package pp2013.gruppe07.shared.eventManager.event.ClientToServer;

import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * @author Felix
 */
public class ChatEvent extends Event{
	

	String message;
	
	public ChatEvent(int id, String message) {
		super(id,Event.Type.CHAT_EVENT);

		this.message = message;
	}
	
	




	public String getMessage(){
		return this.message;
	}

}
