package pp2013.gruppe07.server.engine.general;

import java.util.UUID;

/**
 * Generiert eindeutige IDs, um Objekte (Figuren, Gebaeude) nach dem verschicken
 * schnell identifizieren zu koennen bzw. um die Clients zu numerieren.
 * 
 * @author Sven
 * 
 */
public class ID_Generator {

	public static int inkrement = -1;

	/**
	 * Numeriert die Clients
	 * 
	 * @return
	 * @author Sven
	 */
	public static int getClientID() {
		inkrement++;
		return inkrement;
	}

	/**
	 * Numeriert die Objekte
	 * 
	 * @return
	 * @author Sven
	 */
	public static UUID getID() {
		return UUID.randomUUID();
	}
}
