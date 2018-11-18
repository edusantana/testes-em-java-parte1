package org.edusantana.sensor.movimento;

import edu.ifpb.sensor.AbstractSensor;
import edu.ifpb.sensor.Medicao;
import edu.ifpb.sensor.Sensor;

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
