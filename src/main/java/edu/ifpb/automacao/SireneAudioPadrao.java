package edu.ifpb.automacao;

import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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

		InputStream is = getClass().getResourceAsStream(ARQUIVO_DE_AUDIO_PADRAO);
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(is);
			AudioSystem.getClip().open(audioInputStream);

		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
