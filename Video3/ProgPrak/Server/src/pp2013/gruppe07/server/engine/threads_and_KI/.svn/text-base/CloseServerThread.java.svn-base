package pp2013.gruppe07.server.engine.threads_and_KI;

import pp2013.gruppe07.server.engine.general.GameLogic;

/**Wird nur einmal benoetigt, um den Threadpool von aussen zu schliessen
 * @author Sven
 *
 */
public class CloseServerThread extends Thread{

	private GameLogic administration;
	
	/**
	 * @param administration
	 * @author Sven
	 */
	public CloseServerThread(GameLogic administration)
		{this.administration=administration;}
	
	/** Schliesst den Server, wobei dieser Thread nicht ueber den Pool laueft
	 * @author Sven
	 */
	public void run()
		{administration.closeServer();		
		}
}
