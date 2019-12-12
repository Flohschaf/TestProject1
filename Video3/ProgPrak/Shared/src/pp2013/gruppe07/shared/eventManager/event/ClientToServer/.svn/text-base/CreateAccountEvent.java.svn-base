package pp2013.gruppe07.shared.eventManager.event.ClientToServer;

import pp2013.gruppe07.shared.eventManager.event.Event;
/**
 * 
 * @author Felix
 *
 */
public class CreateAccountEvent extends Event{
	

	private String username;
	private String password;
	
	public CreateAccountEvent(int id, String username, String password) {
		super(id,Event.Type.CREATE_ACCOUNT_EVENT);
		this.username=username;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}


}
