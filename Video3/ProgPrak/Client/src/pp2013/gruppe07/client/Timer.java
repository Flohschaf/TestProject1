package pp2013.gruppe07.client;

import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.InternalCLient.TimerEvent;

/**
 * Ein Timer der fuer alle Zwecke verwendet werden kann.
 * 
 * @author Felix
 * 
 */
public class Timer implements Runnable {

	int duration;// Laufzeit in millisec
	int startTime;

	public Timer(int duration) {
		this.duration = duration;

	}



	public int getTime() {
		int time = (int) (System.currentTimeMillis() - startTime);

		return time;
	}

	@Override
	public void run() {
		int sec = 0;
		this.startTime = (int) System.currentTimeMillis();
		while (getTime() < duration) {

			if (sec == (int) getTime() / 1000) {
				System.out.println(sec + 1);

				sec++;

			}
		}
		EventManager.callEvent(new TimerEvent(1));

	}

}
