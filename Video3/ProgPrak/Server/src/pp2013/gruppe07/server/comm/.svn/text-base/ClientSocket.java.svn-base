package pp2013.gruppe07.server.comm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;

import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.server.engine.general.ID_Generator;
import pp2013.gruppe07.shared.communication.DMessage;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.ClientCloseEvent;
import pp2013.gruppe07.shared.eventManager.event.Event.Type;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.CarryUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ClientIDEvent;
/**
 * Scoekt der fuer jeden angemeldeten Client erstellt wird.
 * @author Felix
 *
 */
public class ClientSocket {

	private GameLogic administration;
	
	Socket client;

	
	boolean isReady;
	
	private Thread reciever = new Thread(new Reciever());
	private Thread sender = new Thread(new Sender()); 
	
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	private boolean runningSender;
	private boolean runningReciever;
	private boolean sleeper;
	private String accountName;
	private int id;

	private ArrayList<DMessage> messages;
	private ClientSocket socket;
	
	public ClientSocket(Socket client,GameLogic administration) {
		socket = this;
		
		this.accountName=""+id;
		this.administration=administration;
		this.client = client;
		this.sleeper = true;
		this.id = ID_Generator.getClientID();
		this.isReady=false;
		messages = new ArrayList<DMessage>();
		
		sender.setDaemon(true);
		reciever.setDaemon(true);
		
		administration.getThreadPool().execute(sender);
		administration.getThreadPool().execute(reciever);
		Communication.newClientMessage(new ClientIDEvent(id));
		
	}
	
	public void setAccountName(String name){
		this.accountName=name;
	}
	
	public String getAccountName(){
		return this.accountName;
	}
	
	
	public int getId(){
		return this.id;
	}
	
	public boolean isReady(){
		return this.isReady;
	}
	
	public void setReady(boolean ready){
		this.isReady=ready;
	}
	
	public void handleInput(){
		
	}
	
	
	public Socket getSocket(){
		return this.client;
	}
	
/**
 * Sende Thread zum senden von Daten an den Client.
 * @author Felix
 *
 */
	private class Sender implements Runnable {

		public void sendMessage() {

			try {
				oos.writeObject(new Event(1,Event.Type.CHAT_EVENT));
				oos.flush();
			} catch (IOException excp) {
				System.err.println(excp.toString());
			}
		}

		@Override
		public void run() {
			try {
				Thread.currentThread().setPriority(10);
				String message = "Der Server sended";

				try {

					oos = null;

					try {
						oos = new ObjectOutputStream(client.getOutputStream());
						
						runningSender = true;
						
						while (!client.isClosed()) {
							
							try {
								LinkedList<Event> list= Communication.getClientMessage(id);
								
								Event[] events= new Event[list.size()];	
								
									for(int i=0;i<events.length;i++)											
												
								{
									
												
												events[i]=list.get(i);
//												
												
											
											}									
											
										oos.writeObject(new DMessage(new CarryUpdateEvent(id,events)));
										oos.flush();
										
								
									
								
								
								

							} catch (IOException excp) {
								System.err.println(excp.toString());
								
								break;
							}
							
							//Sorgt dafuer, dass nur alle 100ms ein grosses Paket mit Events geschickt
							//wird.
							if(administration.selfmadeSleeper())
								{administration.sleeper(100);}
							else
								{try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									return;
									
								}}
						
						
							
							}
					}

					catch (IOException excp) {
						System.err.println("Sender: "+excp.toString());

						return;
						
					}

					//System.out.println(message);

				}

				finally {
					if (client != null) {
						try {
							
							client.close();
							Communication.newServerMessage(new ClientCloseEvent(id));
						} catch (IOException e) {
							
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
	 * Empfangs Thread zum empfangen von Daten vom Client.
	 * @author Felix
	 *
	 */
	private class Reciever implements Runnable {

		public Reciever() {

		}

		@Override
		public void run() {

			try {
				Thread.currentThread().setPriority(10);
				ois = null;
				
				try {
					
					try {
						ois = new ObjectInputStream(new BufferedInputStream(
								client.getInputStream()));

					} catch (StreamCorruptedException excp) {
						System.err.println("Stream is currupted: "
								+ excp.getMessage());
					} catch (OptionalDataException excp) {
						System.err.println("Optional Data: "
								+ excp.getMessage());
					} catch (IOException excp) {
						System.err.println("I/O Exception: "
								+ excp.getMessage());
					}

					System.out.println("Inputstream: " + ois);

					
					DMessage message = null;

					runningReciever = true;

					while (!client.isClosed()) {						
						
						
						try {
							
							
								message = (DMessage) ois.readObject();								
								Communication.newServerMessage(message.getEvent());					

							
								
							

						} catch (EOFException excp) {
							System.err.println("EOF-Exception: "
									+ excp.getMessage());
							break;
						} catch (ClassNotFoundException excp) {
							System.err.println("Class not found: "
									+ excp.getMessage());
							break;
						} catch (OptionalDataException excp) {
							System.err.println("Optional Data: "
									+ excp.getMessage());
						} catch (IOException excp) {
							System.err.println("Empfanger: I/O Exception: "
									+ excp.getMessage());

							break;
						}
						

						if (sleeper) {
							if(administration.selfmadeSleeper())
								administration.sleeper(33);
							else
								{try {
									Thread.sleep(33);
								} catch (InterruptedException e) {
								
									return;
									
								}
								}				

						}

					}
				}

				finally {
					if (client != null) {

						try {
							client.close();
							Communication.newServerMessage(new ClientCloseEvent(id));
						} catch (IOException excp) {
							System.err.println(excp.getMessage());
						}
					}
				}

			} catch (ThreadDeath td) {
				throw td;
			}

		}

	}

}
