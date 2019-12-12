package pp2013.gruppe07.server.comm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JTextField;

import pp2013.gruppe07.server.engine.general.GameLogic;
/**
 * Wartet auf Clients und erstellt Sockets fuer diese.
 * @author Felix
 *
 */
public class Waiter implements Runnable {

	private static ArrayList<ClientSocket> clients;
	
	
	private GameLogic administration;
	int iDCounter = 0;

	JTextField textBox;
	boolean sleeper = true;

	private ServerSocket serverSocket;
	private Socket client;

	
	private final int TIMEOUT = 6000000;

	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public Waiter(GameLogic administration) {
		this.administration=administration;
		Communication.init();
		clients = new ArrayList<ClientSocket>();
		init();
	}
	
	public static ArrayList<ClientSocket>getClients(){
		return clients;
	}
	
	public static ClientSocket getClient(int id) {
		for(int i = 0 ; i <  clients.size() ;i++ ){
			if (clients.get(i).getId()==id){
				return clients.get(i);
			}
		}
		return null;
	}
	
	
	
	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void init() {

		textBox = new JTextField();
		serverSocket = null;
		client = null;

		try {
			serverSocket = new ServerSocket(6007);

		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			serverSocket.setSoTimeout(TIMEOUT);
		} catch (SocketException e) {
			
			e.printStackTrace();
		}

		

		
	}

	@Override
	public void run() {
		System.out.println("Waiter started");
		try {
			ois = null;
			oos = null;

			Socket client = null;

			try {
				while (!administration.isServerClosed()&&!administration.isRunning()) {					
					if(clients.size()<9){
						client = serverSocket.accept();						
						
						//Wenn Spiel noch nicht gestartet wurde
						if(!administration.isRunning())
							{ClientSocket clientSocket = new ClientSocket(client,administration);
							clients.add(clientSocket);
							iDCounter++;
							System.out.println("New Client" + client);
							}
					}
					
				}
			} catch (IOException e1) {
				
				
					//System.err.println("Timeout nach " + TIMEOUT + " ms.");
					Thread.currentThread().stop();
				
				
			
			}

			finally {
				if (client != null) {

					try {
						client.close();
					} catch (IOException excp) {
						System.err.println(excp.getMessage());
					}
				}
			}
			if (sleeper) {
				try {

					Thread.sleep(33);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}

			

		} catch (ThreadDeath td) {
			throw td;
		}
				
	}

}


