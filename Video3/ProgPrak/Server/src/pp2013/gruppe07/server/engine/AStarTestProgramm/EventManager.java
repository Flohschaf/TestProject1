package pp2013.gruppe07.server.engine.AStarTestProgramm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class EventManager {

	private Queue<GameEvent> eventQueue;

	private Lock queueLock = new ReentrantLock(true);

	public EventManager() {
		this.eventQueue = new LinkedList<GameEvent>();
	}

	void addEvent(GameEvent event) {
		queueLock.lock();
		eventQueue.add(event);
		queueLock.unlock();
	}

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
