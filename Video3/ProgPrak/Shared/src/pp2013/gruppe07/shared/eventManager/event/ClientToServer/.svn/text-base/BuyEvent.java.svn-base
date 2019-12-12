package pp2013.gruppe07.shared.eventManager.event.ClientToServer;

import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.item.Item;


/**
 * Event falls der Spieler ein Item kauft
 * @author Felix
 *
 */
public class BuyEvent extends Event{
	

	Item item;
	
	public BuyEvent(int id,Item item) {
		super(id,Event.Type.BUY_EVENT);

		this.item=item;
		
	}
	
	



	/**
	 * 
	 * @return Menge Geld
	 */
	public Item getItem(){
		return this.item;
	}

}



