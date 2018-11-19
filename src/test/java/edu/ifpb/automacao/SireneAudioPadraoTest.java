package edu.ifpb.automacao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SireneAudioPadraoTest {

	@Tag("integração")
	@Test
	void testToca() {
		Sirene sirene = new SireneAudioPadrao();
		sirene.toca();
	}
	

}
