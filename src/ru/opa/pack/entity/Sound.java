package ru.opa.pack.entity;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound implements Runnable {
	private String path;

	public Sound(String path) {
		this.path = path;
	}

	@Override
	public void run() {
		File soundFile = null;
		URL url = this.getClass().getClassLoader().getResource(path);

		try (Clip clip = AudioSystem.getClip()) {
			soundFile = new File(url.toURI());
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);

			clip.open(ais);
			clip.setFramePosition(0);
			clip.start();

			Thread.sleep(clip.getMicrosecondLength() / 1000);
			clip.stop();
		} catch (IOException | UnsupportedAudioFileException
				| LineUnavailableException | URISyntaxException exc) {
			System.out.println("Ошибка воспроизведения звука '" + path
					+ "' (по пути '" + soundFile.getAbsolutePath() + "')");
			System.out.println(exc);
		} catch (InterruptedException exc) {
		}
	}
}
