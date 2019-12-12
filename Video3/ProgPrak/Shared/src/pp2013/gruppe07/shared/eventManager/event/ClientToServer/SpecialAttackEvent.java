package pp2013.gruppe07.shared.eventManager.event.ClientToServer;

import pp2013.gruppe07.shared.eventManager.event.Event;

public class SpecialAttackEvent extends Event {

	Attacks spc;

	public SpecialAttackEvent(int id, Attacks spc) {
		super(id, Event.Type.SPECIAL_ATTACK_EVENT);
		this.spc = spc;

	}

	/**
	 * Enthaelt die Namen aller Spezialattacken aus dem entsprechenden Package
	 * der Serverengine
	 * 
	 * @author Sven
	 */
	public static enum Attacks {
		AUSSAUGEN, AUSZAHLUNG, CLITISIEREN, EISPFEIL, ERDBEBEN, FROSTFEIL, HADDLERUF,HEILEN, HINTERHALT, HOHERTON, KUGELHAGEL, MEGABOMBE,RUNDUMSCHLAG,SCHILDPANZER, SCHOENESLIED, SCHUTZSCHILD, STARKERSCHLAG, SUPERSAYAJIN, ULTIMATE,UNSICHTBAR
	}

	public Attacks getSpc() {
		return spc;
	}
	
	

}
