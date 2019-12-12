package pp2013.gruppe07.client.gui.LogIn;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import pp2013.gruppe07.client.Timer;
import pp2013.gruppe07.client.comm.Communication;
import pp2013.gruppe07.client.gui.Frame;
import pp2013.gruppe07.client.gui.Loading;
import pp2013.gruppe07.shared.eventManager.EventListener;
import pp2013.gruppe07.shared.eventManager.EventManager;
import pp2013.gruppe07.shared.eventManager.event.Event;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.CreateAccountEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.AccountCreatedEvent;

/**
 * Panel in dem ein neuer Account erstellt werden kann.
 * 
 * @author Felix
 * 
 */
public class CreateAccountPanel extends JPanel implements EventListener {

	Frame frame;
	Thread timer;

	Loading loading;
	EventListener thisPanel;

	public CreateAccountPanel(final Frame frame) {
		this.thisPanel = this;
		EventManager.registerListener(this, Event.Type.ACOOUNT_CREATED_EVENT);

		this.setBorder(new TitledBorder("Create Account"));
		this.frame = frame;
		this.setBackground(new Color(255, 178, 85));

		this.setLayout(new GridLayout(8, 0));

		loading = new Loading(frame, "Creating Account ...");

		JTextField newCreateName = new JTextField("Create a new Account:");
		newCreateName.setEditable(false);
		newCreateName.setBackground(new Color(255, 178, 85));

		JTextField newUserName = new JTextField("New Username: ");
		newUserName.setEditable(false);
		newUserName.setBackground(new Color(255, 178, 85));

		final JTextField newUserInput = new JTextField();
		newUserInput.setBackground(new Color(255, 221, 85));

		final JTextField newPassword = new JTextField("Password: ");
		newPassword.setEditable(false);
		newPassword.setBackground(new Color(255, 178, 85));

		final JPasswordField newPasswordInput = new JPasswordField();
		newPasswordInput.setBackground(new Color(255, 221, 85));

		final JTextField repeatPassword = new JTextField("Repeat Password: ");
		repeatPassword.setEditable(false);
		repeatPassword.setBackground(new Color(255, 178, 85));

		final JPasswordField repeatPasswordInput = new JPasswordField();
		repeatPasswordInput.setBackground(new Color(255, 211, 85));

		JButton confirmAccount = new JButton("Confirm");
		confirmAccount.setBackground(new Color(255, 178, 85));

		/**
		 * Beim erstellen eines neuen Accounts wird ein Wartefenster geoeffnet.
		 * Bei antwort des Servers wird darauf entsprechend reagiert.
		 */
		ActionListener confirmAccountAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!newPasswordInput.getText().equals(
						repeatPasswordInput.getText())) {
					repeatPassword
							.setText("Repeat Password: (Input is not consistent)");

				} else {

					Communication.newServerMessage(new CreateAccountEvent(frame
							.getClientID(), newUserInput.getText(),
							repeatPasswordInput.getText()));
					EventManager.registerListener(thisPanel,
							Event.Type.TIMER_EVENT);
					timer = new Thread(new Timer(10000));
					timer.setDaemon(true);
					timer.start();
					loading = new Loading(frame, "Creating Account ...");

					frame.getLayeredPane().add(loading);

					Frame.setDeepEnabled(frame, false);
				}

			}

		};
		confirmAccount.addActionListener(confirmAccountAct);

		JButton getBackButton = new JButton("Cancel");
		getBackButton.setBackground(new Color(255, 178, 85));
		ActionListener getBackAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) frame.getGlobalBackground()
						.getLogInBackground().getScreens().getLayout();
				cl.next(frame.getGlobalBackground().getLogInBackground()
						.getNewAccount().getParent());

			}
		};

		getBackButton.addActionListener(getBackAct);

		this.add(newUserName);
		this.add(newUserInput);
		this.add(newPassword);
		this.add(newPasswordInput);
		this.add(repeatPassword);
		this.add(repeatPasswordInput);
		this.add(confirmAccount);
		this.add(getBackButton);

	}

	@Override
	public void onEvent(Event evt) {

		EventManager.unregisterListener(thisPanel, Event.Type.TIMER_EVENT);
		switch (evt.getType()) {

		// Wenn der Account erfolgreich erstellt wurde.
		case ACOOUNT_CREATED_EVENT: {

			timer.stop();

			String message;
			if (((AccountCreatedEvent) evt).wasCreated()) {
				message = "Account erfolgreich erstellt!";

			} else {
				message = ((AccountCreatedEvent) evt).getMessage();
			}

			JOptionPane.showMessageDialog(this, message, "",
					JOptionPane.INFORMATION_MESSAGE);
			Frame.setDeepEnabled(frame, true);
			frame.toFront();
			loading.setVisible(false);

			break;
		}
		// Wenn der Timer abgelaufen ist ohne, dass zuvor eine Meldung vom
		// Server gekommen ist.
		case TIMER_EVENT: {
			timer.stop();
			JOptionPane.showMessageDialog(this,
					"Es konnte keine Verbindung \nhergestellt werden!", "",
					JOptionPane.INFORMATION_MESSAGE);
			frame.toFront();
			Frame.setDeepEnabled(frame, true);

			loading.setVisible(false);
			break;

		}
		}

	}
}
