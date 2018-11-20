package org.edusantana.automacao;

import edu.ifpb.automacao.Medicao;
import edu.ifpb.automacao.Sensor;
import edu.ifpb.automacao.Sirene;

public class DetectetorDeMovimentoDispositivo {

	private Sirene sirene;
	private double limiteDeConfianca;
	private Sensor<Boolean> sensor;

	public static DetectetorDeMovimentoDispositivo cria(double limiteDeConfianca) {

		DetectetorDeMovimentoDispositivo dispositivo = new DetectetorDeMovimentoDispositivo();
		dispositivo.setLimiteDeConfianca(limiteDeConfianca);

		return dispositivo;

	}

	private void setLimiteDeConfianca(double limiteDeConfianca) {
		this.limiteDeConfianca = limiteDeConfianca;
	}


	public void realizaLeitura() {
		medicaoRealizada(this.sensor.realizaMedicao());
	}

	
	private void medicaoRealizada(Medicao<Boolean> medicao) {
		if (medicao.getConfiancaDaMedicao() >= limiteDeConfianca) {
			getSirene().toca();			
		}
	}

	public void setSirene(Sirene sirene) {
		this.sirene = sirene;
	}

	public Sirene getSirene() {
		return sirene;
	}

	public void setSensor(Sensor<Boolean> sensor) {
		this.sensor = sensor;	
	}

	public double getLimiteDeConfianca() {
		return limiteDeConfianca;
	}

	public Sensor<Boolean> getSensor() {
		return sensor;
	}


}
