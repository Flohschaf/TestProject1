package pp2013.gruppe07.server.engine.eventmanager_and_serverevents;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Beinhaltet die EventQueue.
 * 
 * @author Sven
 */
public class EventManager {

	private Queue<GameEvent> eventQueue;
	long time;

	/**
	 * Soll die Queue vor Zugriffen mehrerer Threads gleichzeitg schuetzen
	 * 
	 * @author Sven
	 */
	private Lock queueLock = new ReentrantLock(true);

	/**
	 * Erzeugt eine EventQueue.
	 * 
	 * @author Sven
	 */
	public EventManager() {
		this.eventQueue = new LinkedList<GameEvent>();
	}

	/**
	 * Es darf immer nur ein Thread gleichzeitig ein Event in die Queue
	 * einfuegen.
	 * 
	 * @author Sven
	 * @param event
	 */
	public void addEvent(GameEvent event) {
		queueLock.lock();
		eventQueue.add(event);
		queueLock.unlock();
	}

	/**
	 * Ruft die Execute Methode der GameEvents auf, um diese auszufuehren. Dabei
	 * wird duch das Sperren mit dem Lock Objekt verhindert, dass die Queue zu
	 * der Zeit von einem anderen Thread benutzt wird.
	 * 
	 * @author Sven
	 */
	public void handleEvents() {
		GameEvent event;
		while (eventQueue.size() != 0) {
			event = null;
			queueLock.lock();
			event = eventQueue.poll();
			queueLock.unlock();
			if (event != null) {
				event.execute();
			}
		}

	}
}
