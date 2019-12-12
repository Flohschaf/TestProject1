package pp2013.gruppe07.server;

import java.util.concurrent.locks.LockSupport;

/**Belegt, dass die Pause bei Thread.sleep() von mindestens 500 ms nichts mit unserer
 * speziefischen Implementierung zu tun hat
 * @author Sven
 *
 */
public class TimerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while(true)
			{long time=(-1)*System.currentTimeMillis();		
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			LockSupport.parkNanos(10000000);
			time+=System.currentTimeMillis();
			System.out.println(time);
			}

	}

}
