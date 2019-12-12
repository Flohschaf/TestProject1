package pp2013.gruppe07.client.comm;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import pp2013.gruppe07.shared.eventManager.event.Event;

public class Communication {

	private static Lock lock = new ReentrantLock(true);

	private static LinkedList<Event> serverMessages;
	private static LinkedList<Event> clientMessages;

	public static void init() {
		lock.lock();
		serverMessages = new LinkedList<Event>();
		clientMessages = new LinkedList<Event>();
		lock.unlock();
	}

	/**
	 * erzeugt eine Message die an den Client geschickt werden soll
	 * 
	 * @param message
	 */
	public static void newClientMessage(Event message) {
		lock.lock();
		clientMessages.add(message);
		lock.unlock();
		// System.out.println("New Message: "+message.getType().toString());
	}

	/**
	 * erzeugt eine Message die an den Server geschickt werden soll
	 * 
	 * @param message
	 */
	public static void newServerMessage(Event message) {
		lock.lock();
		serverMessages.add(message);
		lock.unlock();
		// System.out.println("New ServerMessage: "+message.getType().toString());
	}

	/**
	 * 
	 * @return Liste fuer MEssages die vom Server geschickt wurden
	 */

	public static LinkedList<Event> getServerMessage() {
		lock.lock();

		LinkedList<Event> erg = (LinkedList<Event>) serverMessages.clone();
		serverMessages.clear();
		lock.unlock();
		return erg;

	}

	/**
	 * 
	 * @return Liste fuer MEssages die vom Client geschickt wurden
	 */

	public static LinkedList<Event> getClientMessage() {
		lock.lock();
		LinkedList<Event> erg = (LinkedList<Event>) clientMessages.clone();
		clientMessages.clear();
		lock.unlock();
		return erg;

	}

}
