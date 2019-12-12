package pp2013.gruppe07.client.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import pp2013.gruppe07.shared.eventManager.EventListener;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;

/**
 * Der Frame in dem das gesamte Spiel lauft.
 * @author Felix
 * 
 */
public class Frame extends JFrame implements KeyListener, EventListener {

	JFrame frame;
	GlobalBackGround gBg;
	int clientID;
	String accountName;

	public Frame() {
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setFocusable(true);
		this.addKeyListener(this);
		EventManager.registerListener(this, Event.Type.CLIENT_ID_EVENT);

		frame = this;
		gBg = new GlobalBackGround(this);

		this.setContentPane(gBg);
	}

	public GlobalBackGround getGlobalBackground() {
		return this.gBg;
	}

	public int getClientID() {
		return this.clientID;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setKeylistener(KeyListener KL) {
		this.addKeyListener(KL);
	}

	
	/**
	 * rekursive Methode um alle Componenten zu deaktivieren. Zum Beispiel fuer einen Ladebildschirm.
	 * @param component
	 * @param enabled
	 */
	public static void setDeepEnabled(Component component, boolean enabled) {
		component.setEnabled(enabled);
		if (component instanceof Container) {
			Container container = (Container) component;
			for (int i = 0; i < container.getComponentCount(); i++) {
				setDeepEnabled(container.getComponent(i), enabled);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		

	}

	@Override
	public void keyTyped(KeyEvent e) {
		

	}

	@Override
	public void onEvent(Event evt) {
		this.clientID = evt.getCLIENTID();
		EventManager.unregisterListener(this, Event.Type.CLIENT_ID_EVENT);
		
	}
}
