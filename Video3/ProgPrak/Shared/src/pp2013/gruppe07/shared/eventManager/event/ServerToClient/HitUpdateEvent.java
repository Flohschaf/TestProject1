package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import java.util.UUID;

import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.Tower;
import pp2013.gruppe07.shared.entity.Vasall;
import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Updatet die Werte nach Ausfuehrung eines Schlages
 * 
 * @author Sven
 * 
 */
public class HitUpdateEvent extends Event {

	private final UUID FIG_ID;
	private final UUID ENE_ID;
	private final int DECREASE;
	private String NAME;

	/**
	 * Ist 0 wenn die Figur ein Tower ist
	 * 
	 * @author Sven
	 */
	private final int ATTACKDIRECTION;

	/**
	 * @param clientid
	 * @param fig_ID
	 * @param ene_ID
	 * @param decrease
	 * @param attackDirection
	 * @param atta
	 * @author Sven
	 */
	public HitUpdateEvent(int clientid, UUID fig_ID, UUID ene_ID, int decrease,
			int attackDirection, InteraktiveEntity atta) {
		super(clientid, Type.HIT_UPDATE_EVENT);
		this.FIG_ID = fig_ID;
		this.ENE_ID = ene_ID;
		this.DECREASE = decrease;
		this.ATTACKDIRECTION = attackDirection;
		if (atta instanceof Vasall) {
			NAME = "Vasall";
		}
		if (atta instanceof Tower) {
			NAME = "Tower";
		}
	}

	/**
	 * @return
	 * @author Sven
	 */
	public int getATTACKDIRECTION() {
		return ATTACKDIRECTION;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public int getDECREASE() {
		return DECREASE;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public UUID getEne_ID() {
		return ENE_ID;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public UUID getFig_ID() {
		return FIG_ID;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public String getNAME() {
		return NAME;
	}

	/**
	 * @param id
	 * @author Sven
	 */
	public void setClientId(int id) {
		clientID = id;
	}

}
