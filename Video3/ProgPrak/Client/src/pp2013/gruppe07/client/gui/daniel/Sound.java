package pp2013.gruppe07.client.gui.daniel;

import java.applet.Applet;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 * 
 * @author Daniel Diese Klasse erzeugt und Spielt Sounds ab.
 * */
public class Sound extends Applet implements Runnable {

	private Clip clip, clip2;

	public Sound() {

	}

	/**
	 * 
	 * @author Daniel Diese Methode initialisiert den clip und spielt ihn ab.
	 * */
	public void play(int sound) {
		if (sound == 1) {
			try {
				AudioInputStream Input = AudioSystem
						.getAudioInputStream(new File("sounds/dangerdan.wav"));
				AudioFormat Format = Input.getFormat();
				int size = (int) (Format.getFrameSize() * Input
						.getFrameLength());
				byte[] audio = new byte[size];
				DataLine.Info info = new DataLine.Info(Clip.class, Format, size);
				Input.read(audio, 0, size);

				clip = (Clip) AudioSystem.getLine(info);
				clip.open(Format, audio, 0, size);
				// clip=getAudioClip(getCodeBase(),"sounds/dangerdan.wav");
			} catch (Exception e) {
			}
		} else {
			if (sound == 2) {
				try {
					AudioInputStream Input2s = AudioSystem
							.getAudioInputStream(new File("sounds/Song.wav"));
					AudioFormat Format = Input2s.getFormat();
					int size = (int) (Format.getFrameSize() * Input2s
							.getFrameLength());
					byte[] audio = new byte[size];
					DataLine.Info info = new DataLine.Info(Clip.class, Format,
							size);
					Input2s.read(audio, 0, size);

					clip = (Clip) AudioSystem.getLine(info);
					clip.open(Format, audio, 0, size);
					// clip=getAudioClip(getCodeBase(),"sounds/dangerdan.wav");
				} catch (Exception e) {
				}
			}
		}
		try {
			new Thread() {
				public void run() {
					clip.start();
					// clip.loop(Clip.LOOP_CONTINUOUSLY);
				}
			}.start();
		} catch (Exception e) {

		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
