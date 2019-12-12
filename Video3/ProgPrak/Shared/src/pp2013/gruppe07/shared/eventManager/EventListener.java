package pp2013.gruppe07.shared.eventManager;

import pp2013.gruppe07.shared.eventManager.event.Event;



/**
 * Interface dass von Klassen implementiert werden kann die auf Events reagieren sollen.
 * @author Felix
 *
 */
public interface EventListener {
	
	
	
	public void onEvent(Event evt);
}
