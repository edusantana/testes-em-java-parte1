package edu.ifpb.automacao;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Toca um arquivo audio padrão.
 * 
 * @author eduardo
 *
 */
public class SireneAudioPadrao implements Sirene {

	/**
	 * Arquivo de áudio que será tocado. Ele está dentro de resources, dessa forma
	 * vai junto com a aplicação, dentro do JAR.
	 */
	private static final String ARQUIVO_DE_AUDIO_PADRAO = "audio/alarme.wav";


	public void toca() {

		
		InputStream in = getClass().getClassLoader().getResourceAsStream(ARQUIVO_DE_AUDIO_PADRAO);
		
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(in));

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}


}
