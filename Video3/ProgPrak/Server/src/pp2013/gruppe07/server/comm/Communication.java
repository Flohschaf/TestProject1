package pp2013.gruppe07.server.comm;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Beeinhaltet die Listen, die das Bindeglied zwischen der Kommunikation und den
 * Engines darstellen
 * 
 * @author Sven,Felix
 * 
 */
public class Communication {

	/**
	 * Stellt sicher, dass die Listen bei gleichzeitigen Zugriffen geschuetzt
	 * sind
	 * 
	 * @author Sven
	 */
	private static Lock lock = new ReentrantLock(true);

	private static LinkedList<Event> serverMessages;
	private static LinkedList<Event> clientMessages;

	/**
	 * @author Felix
	 * @return Liste fuer MEssages die vom Client geschickt wurden
	 */

	public static LinkedList<Event> getClientMessage(int id) {
		lock.lock();
		LinkedList<Event> indivList = new LinkedList<Event>();
		

		for (int i = 0; i < clientMessages.size(); i++) {
			if (clientMessages.get(i).getCLIENTID() == id) {

				Event evt = clientMessages.get(i);
				if (evt.getType().equals(Event.Type.STAT_SEND_EVENT)) {
					System.out.println("Sende stats");
				}
				indivList.addLast(evt);

			}
		}

		for (Event evt : indivList) {
			clientMessages.remove(evt);
		}

		// clientMessages.clear();
		lock.unlock();
		return indivList;

	}

	/**
	 * @author Sven,Felix
	 * @return Liste fuer MEssages die vom Server geschickt wurden
	 */

	public static LinkedList<Event> getServerMessage() {
		lock.lock();

		LinkedList<Event> erg = (LinkedList<Event>) serverMessages.clone();
		serverMessages.clear();
		lock.unlock();
		return erg;

	}

	public static void init() {
		lock.lock();
		serverMessages = new LinkedList<Event>();
		clientMessages = new LinkedList<Event>();
		lock.unlock();
	}

	/**
	 * @author Sven,Felix erzeugt eine Message die an den Client geschickt werden
	 *         soll
	 * @param message
	 */
	public static void newClientMessage(Event message) {
		lock.lock();
		clientMessages.add(message);
		
		lock.unlock();
		
	}

	/**
	 * @author Sven,Felix erzeugt eine Message die an den Server geschickt werden
	 *         soll
	 * @param message
	 */
	public static void newServerMessage(Event message) {
		lock.lock();
		serverMessages.add(message);
		lock.unlock();
		
	}

}
