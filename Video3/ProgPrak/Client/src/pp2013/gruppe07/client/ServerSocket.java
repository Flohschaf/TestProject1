package pp2013.gruppe07.client;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.net.Socket;
import java.util.ArrayList;

import pp2013.gruppe07.client.comm.Communication;
import pp2013.gruppe07.shared.communication.DMessage;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.Event.Type;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.CarryUpdateEvent;

/**
 * Ueber das ClientSocket Objekt wird die Verbindung mit dem Server aufrecht erhalten.
 * Der Socket verfuegt ueber einen Sende und einen empfangs Thread.
 * @author Felix
 * 
 */
public class ServerSocket {

	Socket client;

	private Thread reciever = new Thread(new Reciever());
	private Thread sender = new Thread(new Sender());

	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	private boolean runningSender;
	private boolean runningReciever;
	private boolean sleeper;

	private ArrayList<DMessage> messages;

	public ServerSocket(Socket client) {
		this.client = client;
		this.sleeper = true;
		messages = new ArrayList<DMessage>();

		sender.setDaemon(true);
		reciever.setDaemon(true);

		sender.start();
		reciever.start();

	}
	/**
	 * SendeThread der alle Nachrichten aus der Kommunikation ausliest, verpackt und an den server sendet.
	 * @author Felix
	 *
	 */
	private class Sender implements Runnable {

		@Override
		public void run() {
			try {

				String message = "Der Client sended";

				try {

					oos = null;

					try {
						oos = new ObjectOutputStream(client.getOutputStream());

						runningSender = true;
						while (runningSender) {

							try {
								//Hier wird gesendet.
								for (Event evt : Communication
										.getServerMessage()) {
									oos.writeObject(new DMessage(evt));
								}
								oos.flush();
								

							} catch (IOException excp) {
								System.err.println(excp.toString());
							}
						}

					}

					catch (IOException excp) {
						System.err.println(excp.toString());
					}

					

				}

				finally {
					if (client != null) {
						try {
							client.close();
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
	 * Empfangsthread der NAchrichten vom Server emfangt und die Events an die Client Communiction weiter gibt.
	 * @author Felix
	 *
	 */
	private class Reciever implements Runnable {

		public Reciever() {

		}

		@Override
		public void run() {

			try {

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

					System.out.println("Inputstrem: " + ois);

					DMessage message = null;

					runningReciever = true;

					while (runningReciever) {

						try {
							if (ois != null) {
								message = (DMessage) ois.readObject();
								if (message.getEvent().getType()
										.equals(Type.CARRY_UPDATE_EVENT)) {
									CarryUpdateEvent evt = (CarryUpdateEvent) message
											.getEvent();
									for (int i = 0; i < evt.getEvents().length; i++) {
										if (evt.getEvents()[i] != null) {
											
											//Hier wird die Message ausgelesen und an den eventmanager weitergeleitet.
											Communication.newClientMessage(evt
													.getEvents()[i]);
										}
									}
								} else {
									Communication.newClientMessage(message
											.getEvent());
								}
								
							}

							if (message != null) {
								
							}

						} catch (EOFException excp) {
							System.err.println("EOF-Exception: "
									+ excp.getMessage());
						} catch (ClassNotFoundException excp) {
							System.err.println("Class not found: "
									+ excp.getMessage());
						} catch (OptionalDataException excp) {
							System.err.println("Optional Data: "
									+ excp.getMessage());
						} catch (IOException excp) {
							System.err.println("I/O Exception: "
									+ excp.getMessage());
						}

						if (sleeper) {
							try {

								Thread.sleep(33);
							} catch (InterruptedException e) {

								e.printStackTrace();
							}
						}

					}
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

			} catch (ThreadDeath td) {
				throw td;
			}

		}

	}

}
