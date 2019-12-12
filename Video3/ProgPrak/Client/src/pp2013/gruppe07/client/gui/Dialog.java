package pp2013.gruppe07.client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;
/**
 * 
 * @author Felix
 *
 */
public class Dialog extends JDialog {

	Frame frame;
	JTextArea dialogField;
	Dialog dialog;
	Image background;

	public Dialog(final Frame frame) {
		dialog = this;
		background = Toolkit.getDefaultToolkit().getImage("Images/error.png");
		this.frame = frame;
		int dialogWidth = 170;
		int dialogHeight = 100;

		this.setSize(new Dimension(dialogWidth, dialogHeight));
		this.setLocation(400, 400);// (int)frame.getGlobalBackground().getSize().getWidth()-dialogWidth/2,(int)frame.getGlobalBackground().getSize().getHeight()-dialogHeight/2);

		this.setUndecorated(true);

		this.setLayout(new GridLayout(2, 1));
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		dialogField = new JTextArea();
		dialogField.setEditable(false);
		// dialogField.setOpaque(false);
		dialogField.setBackground(new Color(0, 0, 0, 0));
		// dialogField.setBackground(new Color(181, 243, 221));
		this.add(dialogField);

		JButton dialogButton = new JButton("close");
		ActionListener dialogListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				frame.setDeepEnabled(frame, true);
				dialog.setVisible(false);

			}
		};
		dialogButton.addActionListener(dialogListener);
		dialogButton.setOpaque(true);
		this.add(dialogButton);
	}

	public JTextArea getDialogField() {
		return this.dialogField;
	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(background, 0, 0, this);
		super.paintComponents(g);
	}

}
