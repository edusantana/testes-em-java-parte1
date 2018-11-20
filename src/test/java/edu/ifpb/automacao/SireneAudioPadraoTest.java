package edu.ifpb.automacao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

class SireneAudioPadraoTest {

	/* Esse teste não funciona no travis, pq não toca som lá.
	 * Foi necessário desativar esse teste lá.
	 * https://junit.org/junit5/docs/current/user-guide/ 
	 * https://docs.travis-ci.com/user/environment-variables/#default-environment-variables
	 */
	@DisabledIfEnvironmentVariable(named = "TRAVIS", matches = "true")
	@Tag("integração")
	@Test
	void testToca() {
		Sirene sirene = new SireneAudioPadrao();
		sirene.toca();
	}
	

}
