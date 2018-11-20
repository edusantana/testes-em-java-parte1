package funcional.movimento;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.edusantana.automacao.DetectetorDeMovimentoDispositivo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.ifpb.automacao.Medicao;
import edu.ifpb.automacao.Sensor;
import edu.ifpb.automacao.Sirene;

/**
 * Ajuda sobre juni5:
 * 
 * - https://dzone.com/articles/junit-5-annotations-with-examples-1 -
 * http://www.javaguides.net/2018/07/junit-5-assertions-with-examples.html -
 * https://junit.org/junit5/docs/current/user-guide/
 * 
 * @author eduardo
 *
 */
class DetectorDeMovimentoTest {

	final double LIMITE_DE_CONFIANCA = 0.8;
	DetectetorDeMovimentoDispositivo dispositivo;

	@BeforeEach
	void setup() {
		this.dispositivo = DetectetorDeMovimentoDispositivo.cria(LIMITE_DE_CONFIANCA);
	}

	@Test
	@DisplayName("Toca sirene quando detecta movimento dentro do limite configurado")
	void tocaSireneQuandoDetectaMovimento() {

		supoeDetectacaoDeMovimentoNoLimiteDeConfianca();

		verificaQueSireneFoiTocada();

	}

	@Test
	@DisplayName("Sirene não toca quando detecta movimento abaixo limite configurado")
	void naoTocaSireneQuandoDetectaMovimentoAbaixoDoLimite() {

		supoeDetectacaoDeMovimentoAbaixoDoLimiteDeConfianca();

		verificaQueSireneNaoFoiTocada();

	}

	private void verificaQueSireneNaoFoiTocada() {
		verify(dispositivo.getSirene(), never()).toca();
	}

	private void verificaQueSireneFoiTocada() {
		verify(dispositivo.getSirene()).toca();
	}

	private void mockSirene() {
		Sirene sirene = mock(Sirene.class);
		dispositivo.setSirene(sirene);
	}

	private void mockSensor() {
		Sensor<Boolean> sensor = mock(Sensor.class);
		dispositivo.setSensor(sensor);
	}

	private void supoeDetectacaoDeMovimentoAbaixoDoLimiteDeConfianca() {

		mockSirene();
		mockSensor();

		Medicao<Boolean> medicaoSuposta = new Medicao<Boolean>(true, LIMITE_DE_CONFIANCA - 0.1);

		when(dispositivo.getSensor().realizaMedicao()).thenReturn(medicaoSuposta);

		dispositivo.realizaLeitura();

	}

	private void supoeDetectacaoDeMovimentoNoLimiteDeConfianca() {

		mockSirene();
		mockSensor();

		Medicao<Boolean> medicaoSuposta = new Medicao<Boolean>(true, LIMITE_DE_CONFIANCA);

		when(dispositivo.getSensor().realizaMedicao()).thenReturn(medicaoSuposta);

		dispositivo.realizaLeitura();

	}

}
