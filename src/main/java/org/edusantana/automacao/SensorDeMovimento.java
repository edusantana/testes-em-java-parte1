package org.edusantana.automacao;

import edu.ifpb.automacao.AbstractSensor;
import edu.ifpb.automacao.Medicao;
import edu.ifpb.automacao.Sensor;

public class SensorDeMovimento extends AbstractSensor<Boolean> {

	private Sensor<Boolean> sensorAdapter;

	public SensorDeMovimento(Sensor<Boolean> sensorAdapter) {
		super();
		this.sensorAdapter = sensorAdapter;
	}

	public Medicao<Boolean> realizaMedicao() {
		return sensorAdapter.realizaMedicao();
	}

	public static void main(String[] args) {
		SensorDeMovimento sensor = new SensorDeMovimento(new SensorDeMovimentoDialogoHelper());

		System.out.println(sensor.realizaMedicao());
	}

}
