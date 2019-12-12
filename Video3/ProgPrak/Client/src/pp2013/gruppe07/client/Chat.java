package pp2013.gruppe07.client;

import java.util.ArrayList;

import pp2013.gruppe07.shared.eventManager.EventListener;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.ChatEvent;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.InfoEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ToClientChatEvent;

/**
 * Speichert den gesamten Chat und SystemInfos in einer ArrayList.
 * @author Felix
 * 
 */
public class Chat implements EventListener {

	ArrayList<String> chat;

	public Chat() {
		chat = new ArrayList<String>();
		
		EventManager.registerListener(this, Event.Type.INFO_EVENT);
		EventManager.registerListener(this, Event.Type.CHAT_EVENT);
			}

	@Override
	public void onEvent(Event evt) {

		switch (evt.getType()) {
		

		case INFO_EVENT: {
			chat.add(((InfoEvent) evt).getInfo());
			break;
		}
		case CHAT_EVENT: {
			
			chat.add(((ChatEvent) evt).getMessage());
			break;
		}
		}

	}
	
	public ArrayList<String> getChat() {
		return this.chat;
	}

}
