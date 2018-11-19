package org.edusantana.automacao;

import edu.ifpb.automacao.Medicao;
import edu.ifpb.automacao.Sirene;

public class DetectetorDeMovimentoDispositivo {

	private Sirene sirene;

	public static DetectetorDeMovimentoDispositivo cria(double limiteDeConfianca) {

		DetectetorDeMovimentoDispositivo dispositivo = new DetectetorDeMovimentoDispositivo();

		// dispositivo.setLimiteDeConfianca(limiteDeConfianca);

		return dispositivo;

	}

	public void supoeMedicao(Medicao<Boolean> medicao) {

		medicaoRealizada(medicao);

	}

	private void medicaoRealizada(Medicao<Boolean> medicao) {
		getSirene().toca();

	}

	public void setSirene(Sirene sirene) {
		this.sirene = sirene;
	}

	public Sirene getSirene() {
		return sirene;
	}

}
