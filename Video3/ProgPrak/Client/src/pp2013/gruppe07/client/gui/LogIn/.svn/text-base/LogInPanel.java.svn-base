package pp2013.gruppe07.client.gui.LogIn;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.LogInEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.ClientLogInEvent;

/**
 * Panel auf dem man sich bei Server anmelden kann.
 * 
 * @author Felix
 * 
 */
public class LogInPanel extends JPanel implements EventListener {

	Frame frame;
	private int logInWidth;
	private int logInHeigth;
	ImageIcon icon;
	private Thread timer;
	private Loading loading;
	private EventListener thisPanel;

	public LogInPanel(final Frame frame) {
		this.frame = frame;
		this.thisPanel = this;
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		logInWidth = gd.getDisplayMode().getWidth() / 3;
		logInHeigth = gd.getDisplayMode().getHeight() / 3;
		this.setPreferredSize(new Dimension(logInWidth, logInHeigth));
		this.setBackground(Color.WHITE);
		this.setBorder(new TitledBorder("Log In"));
		this.setLayout(new GridLayout(7, 0));

		EventManager.registerListener(this, Event.Type.CLIEN_LOG_IN_EVENT);

		JTextField accountName = new JTextField("Accountname:");
		accountName.setEditable(false);
		accountName.setBackground(new Color(255, 178, 85));

		final JTextField logInText = new JTextField();
		ActionListener logInAct;
		logInText.setBackground(new Color(255, 211, 85));

		final JTextField enterPassword = new JTextField("Password: ");
		enterPassword.setEditable(false);
		enterPassword.setBackground(new Color(255, 178, 85));

		final JPasswordField logInPass = new JPasswordField();
		logInPass.setBackground(new Color(255, 211, 85));
		JButton startButton = new JButton("Log In");

		ActionListener startButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Communication.newServerMessage(new LogInEvent(frame
						.getClientID(), logInText.getText(), logInPass
						.getText()));
				frame.setAccountName(logInText.getText());
				EventManager
						.registerListener(thisPanel, Event.Type.TIMER_EVENT);
				timer = new Thread(new Timer(3000));
				timer.setDaemon(true);
				timer.start();
				loading = new Loading(frame, "Logging in ...");

				frame.getLayeredPane().add(loading);

				Frame.setDeepEnabled(frame, false);
			}

		};

		startButton.addActionListener(startButtonListener);
		startButton.setBackground(new Color(255, 178, 85));
		JButton createAccountButton = new JButton("Create new Account");
		createAccountButton.setBackground(new Color(255, 178, 85));
		ActionListener newAccountAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) frame.getGlobalBackground()
						.getLogInBackground().getScreens().getLayout();
				cl.next(frame.getGlobalBackground().getLogInBackground()
						.getNewAccount().getParent());
			}

		};

		createAccountButton.addActionListener(newAccountAct);

		JButton exitButton = new JButton("Exit Game");
		exitButton.setBackground(new Color(255, 178, 85));
		ActionListener exitButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();

			}
		};

		exitButton.addActionListener(exitButtonListener);

		this.add(accountName);
		this.add(logInText);
		this.add(enterPassword);
		this.add(logInPass);
		this.add(startButton);
		this.add(createAccountButton);
		this.add(exitButton);

		this.setBackground(new Color(255, 178, 85));

	}

	@Override
	public void onEvent(Event evt) {
		EventManager.unregisterListener(thisPanel, Event.Type.TIMER_EVENT);

		switch (evt.getType()) {
		
		//Falls der Timer abgelaufen ist bevor der Server geantwortet hat.
		case TIMER_EVENT: {
			timer.stop();

			loading.setVisible(false);

		
			JOptionPane.showMessageDialog(this,
					"Es konnte keine Verbindung \nhergestellt werden!", "",
					JOptionPane.INFORMATION_MESSAGE);
			frame.toFront();
			Frame.setDeepEnabled(frame, true);
			break;

		}
		
		//Falls sich der Server meldet.
		case CLIEN_LOG_IN_EVENT: {
			ClientLogInEvent cEvt = (ClientLogInEvent) evt;

			if (cEvt.hasLoggedIn()) {
				EventManager.callEvent(new LogInEvent(frame.getClientID(), "",
						""));
			}

			else {
				JOptionPane.showMessageDialog(this, cEvt.getMessage(), "",
						JOptionPane.INFORMATION_MESSAGE);
			}

			frame.toFront();
			Frame.setDeepEnabled(frame, true);
			loading.setVisible(false);
			break;
		}

		}

	}

}
