package pp2013.gruppe07.client;

import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import pp2013.gruppe07.client.comm.Communication;
import pp2013.gruppe07.client.comm.InternalSocket;
import pp2013.gruppe07.client.gui.AttackImages;
import pp2013.gruppe07.client.gui.Frame;
import pp2013.gruppe07.client.gui.Images;
import pp2013.gruppe07.shared.eventManager.EventManager;


/**
 * Ueber das erstellen des Client wird das Spiel auf der Clientseite gestartet.
 * @author Felix
 * 
 */
public class Client {
	Frame frame;
	private Thread renderThread = new Thread(new UpdateTask());
	private Thread connecter = new Thread(new Connecter());

	/**
	 * Dient dem schnellen Umschalten zwischen lokaler Ausfuehrung des Servers
	 * und der Ausfuehrung ueber den Progprak Server
	 * 
	 * @author Sven
	 */
	private final boolean LOCAL = true;
	private final String ADDRESS;

	boolean running = true;

	boolean sleeper = true;

	ObjectOutputStream oos;
	private Socket server;

	ServerSocket serverSocket;

	public Client() {
		if (LOCAL) {
			ADDRESS = "localhost";
		} else {
			ADDRESS = "proglab.informatik.uni-koeln.de";
		}
	}

	public static void main(String args[]) {
		Client main = new Client();
		Images.init();
		AttackImages.init();
		getOS();

		main.init();

		
	}

	public static String getOS() {

		return System.getProperty("os.name").toLowerCase();
	}

	int mouseX;
	/**
	 * Bereitet das das Spiel vor.
	 */
	public void init() {
		Communication.init();
		EventManager.init();

		frame = new Frame();

		frame.setVisible(true);

		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(java.awt.event.WindowEvent e) {
				System.out.println("kill");
				frame.setVisible(false);
				frame.dispose();

				// Thread.currentThread().stop();
				renderThread.stop();

			};
		});
		{

		}
		renderThread.setDaemon(true);
		connecter.start();
		renderThread.start();
	}
/**
 * In der Update Task laeuft der Thread in dem das Spiel ablaeuft.
 * Das geschieht ueber das behandeln der internen Events ueber den Eventmenager und der vom Server empfangenen.
 * @author Felix
 *
 */
	private class UpdateTask implements Runnable {

		public UpdateTask() {

		}

		@Override
		public void run() {

			try {
				while (running) {
					
					
					
					frame.repaint();
					//Hier schlaegt das Herz!
					EventManager.handleEvents();
					InternalSocket.handleInput();

					if (sleeper) {
						try {

							Thread.sleep(33);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
					}

				}
			} catch (ThreadDeath td) {
				throw td;
			}

		}

	}
/**
 * Versucht sich zum Server zu verbinden und erstellt bei erfolgreicher Verbindung ein Socketobjekt.
 * @author Felix
 *
 */
	private class Connecter implements Runnable {

		@Override
		public void run() {

			try {

				server = null;
				String message = "" + System.currentTimeMillis();

				try {

					String serverHostename = ADDRESS;
					InetAddress serverIP = InetAddress
							.getByName(serverHostename);

					server = new Socket(serverIP.getHostAddress(), 6007);

					serverSocket = new ServerSocket(server);

					oos = null;

				} catch (UnknownHostException excp) {
					System.err.println(excp.getMessage());

				} catch (IOException excp) {
					System.err.println(excp.getMessage());

				}

				finally {
					
				}

			} catch (ThreadDeath td) {
				throw td;
			}

		}

	}

}
