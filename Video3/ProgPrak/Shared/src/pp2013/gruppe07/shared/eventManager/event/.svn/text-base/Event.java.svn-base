package pp2013.gruppe07.shared.eventManager.event;

import java.io.Serializable;

/**
 * 
 * @author Felix,Sven
 * 
 */
public class Event implements Comparable<Event>, Serializable {
	/**
	 * Eventprioritaet
	 * 
	 * @author Felix
	 * 
	 */

	private static enum Priority {
		HIGH, MIDDLE, LOW
	}

	/**
	 * Eventtyp
	 * 
	 * @author Felix, Steven, Sven
	 * 
	 */
	public static enum Type {

		ACOOUNT_CREATED_EVENT, ATTACK_EVENT, TO_CLIENT_CHAT_EVENT, BUY_EVENT, CARRY_UPDATE_EVENT, CASH_EVENT, CLIENT_ADMIN_UPDATE_EVENT, CLIENT_CLOSE_EVENT, CLIEN_LOG_IN_EVENT, CHAT_EVENT, CHOOSE_HERO_EVENT, CONSUME_POTION_UPDATE_EVENT, CLIENT_ID_EVENT, CREATE_ACCOUNT_EVENT, CREATE_UPDATE_EVENT, END_GAME_UPDATE_EVENT, HIT_UPDATE_EVENT, INCREASE_XP_EVENT, INFO_EVENT, INTERNAL_SELECT_HERO_EVENT, INTERNAL_SELECT_TEAM_EVENT, INTERNAL_START_GAME_EVENT, ITEM_UPDATE_EVENT, KILL_UPDATE_EVENT, LOBBY_EVENT, LOBBY_TEAM_LIST_EVENT, LOCK_IN_EVENT, MANA_AND_LIFE_UPDATE_EVENT, MOVE_EVENT, MOVE_UPDATE_EVENT, MONEY_UPDATE_EVENT, NEW_PLAYER_EVENT, POTION_EVENT, RESPAWN_UPDATE_EVENT, SPECIAL_ATTACK_EVENT, SPECIAL_ATTACK_UPDATE_EVENT, VALUES_UPDATE_EVENT, WORLD_CREATE_EVENT, TIMER_EVENT, STAT_SEND_EVENT, STAT_REQUEST_EVENT, PURE_LIFE_UPDATE_EVENT;

	}

	private Type type;

	private Priority priority;

	protected int clientID;

	/**
	 * Erzeugt ein Event und speichert den Eventtypen
	 * 
	 * @param type
	 */
	public Event(int clientid, Type type) {
		this.type = type;
		this.priority = Priority.MIDDLE;
		this.clientID = clientid;
	}

	/**
	 * Kann zum Vergleich der Prioritaeten zweier Events genutzt werden.
	 */
	@Override
	public int compareTo(Event evt) {
		return priority.compareTo(evt.getPriority());
	}

	public int getCLIENTID() {
		return clientID;
	}

	/**
	 * 
	 * @return Prioritaet dieses Events
	 */
	public Priority getPriority() {
		return this.priority;
	}

	/**
	 * 
	 * @return Typ dieses Events
	 */
	public Type getType() {
		return this.type;
	}

}
