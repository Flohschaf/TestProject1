package pp2013.gruppe07.client.gui.Lobby;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pp2013.gruppe07.shared.eventManager.EventListener;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.ChatEvent;

/**
 * Erzeugt das Chatfenster und sorgt dafuer dass der Text im Chatfenster
 * automatisch nach unten Scrollt.
 * 
 * @author Felix,Flo
 * 
 */
public class ScrollChatArea extends JPanel implements EventListener {

	JTextArea txt;
	JScrollPane scrolltxt;

	public ScrollChatArea() {

		EventManager.registerListener(this, Event.Type.CHAT_EVENT);

		this.setLayout(new BorderLayout());
		txt = new JTextArea(6, 20);

		scrolltxt = new JScrollPane(txt);

		this.setPreferredSize(new Dimension(300, 250));
		scrolltxt.setVisible(true);
		this.add(scrolltxt);

	}

	@Override
	public void onEvent(Event evt) {
		txt.append(((ChatEvent) evt).getMessage() + "\n");
		txt.setCaretPosition(txt.getDocument().getLength());
	}

}
