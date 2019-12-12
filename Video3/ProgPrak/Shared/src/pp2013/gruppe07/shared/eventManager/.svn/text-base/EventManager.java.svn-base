package pp2013.gruppe07.shared.eventManager;



import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import pp2013.gruppe07.shared.eventManager.event.Event;


/**
 * Verwaltet alle eingetroffenen Events und arbeitet diese der Reihe nach ab.
 * @author Felix
 *
 */
public class EventManager {

	private static Lock lock=new ReentrantLock(true);
	
	private static Queue<Event> eventQueue;
	private static HashMap<Event.Type, HashSet<EventListener>> registeredListener;

	
	/**
	 * Initialisiert den EventManager indem jedem Eventtypen ein Hashset zugeordnet wird.
	 * In den Hashsets werden die registrierten Listener gespeichert.
	 */
	public static void init(){
		registeredListener = new HashMap<Event.Type,HashSet<EventListener>>();
		for(Event.Type type : Event.Type.values()){
			registeredListener.put(type,new HashSet<EventListener>());
		}
		eventQueue = new LinkedList<Event>();
	}
	
	
	/**
	 * Arbeitet alle Events ab.
	 */
	public static void handleEvents(){
		
		
		Event evt;
		while ((eventQueue.peek())!= null){
			lock.lock();
			evt=eventQueue.poll();
			
			for(EventListener listener : registeredListener.get(evt.getType())){
				if(evt.getType().equals(Event.Type.STAT_SEND_EVENT)){
					System.out.println(listener.toString()+"ZU OFT!!!!!!!!!!!!");
					
				}
				listener.onEvent(evt);
			}
			lock.unlock();
		}
	}
	
	/**
	 * Erzeugt ein neues Event. Jeder darauf registrierte EventListener wird auf diese Event reagieren.
	 * @param evt
	 */
	public static void callEvent(Event evt){
		lock.lock();
		eventQueue.add(evt);
		lock.unlock();
		
	}
	
	/**
	 * Registriert einen Listener damit dieser auf ein bestimmtes Event reagiert.
	 * @param listener
	 * @param type
	 */
	public static void registerListener(EventListener listener , Event.Type type){
		//System.out.println(type.toString());
		registeredListener.get(type).add(listener);
	}
	
	/**
	 * Entfernt den EventListener. Der Listener reagiert dann nichmehr auf ein Event.
	 * @param listener
	 * @param type
	 */
	public static void unregisterListener(EventListener listener , Event.Type type){
		registeredListener.get(type).remove(listener);
	}
	
	
}
