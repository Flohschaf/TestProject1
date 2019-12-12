package pp2013.gruppe07.client.gui.Lobby;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pp2013.gruppe07.client.comm.Communication;
import pp2013.gruppe07.client.gui.Frame;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.ChatEvent;

/**
 * Auf diesem Panel wird der Chat in der Lobby angezeigt.
 * 
 * @author Felix,Flo
 * 
 */
public class ChatPanel extends JPanel {

	private int width;
	private int heigth;
	private Frame frame;

	public ChatPanel(final Frame frame) {

		this.frame = frame;

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		width = (int) (gd.getDisplayMode().getWidth() * 0.2);
		heigth = (int) (gd.getDisplayMode().getHeight() * 0.2);
		this.setOpaque(false);

		// chatArea.setEditable(false);

		final JTextField chatField = new JTextField();
		chatField.setPreferredSize(new Dimension(width, 20));

		KeyListener chatAct = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println(arg0.getKeyCode());
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					Communication.newServerMessage(new ChatEvent(frame
							.getClientID(), chatField.getText()));
					chatField.setText("");
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {

			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

		};

		chatField.addKeyListener(chatAct);

		ScrollChatArea textArea = new ScrollChatArea();

		JButton sendButton = new JButton("send");

		/**
		 * ActionListener zum Abschicken der Nachrichten.
		 */
		ActionListener sendAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Communication.newServerMessage(new ChatEvent(frame
						.getClientID(), chatField.getText()));
				chatField.setText("");

			}

		};

		sendButton.addActionListener(sendAct);

		this.add(textArea, BorderLayout.NORTH);

		this.add(chatField, BorderLayout.SOUTH);
		this.add(sendButton, BorderLayout.SOUTH);

	}
}
