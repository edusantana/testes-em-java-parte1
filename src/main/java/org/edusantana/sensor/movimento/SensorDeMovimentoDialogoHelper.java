package org.edusantana.sensor.movimento;

import java.util.LinkedHashMap;
import java.util.Map;

import edu.ifpb.sensor.MapDialogoAdapter;

public class SensorDeMovimentoDialogoHelper extends MapDialogoAdapter<Boolean> {

	public SensorDeMovimentoDialogoHelper() {
		Map<String, Boolean> mapa = new LinkedHashMap<String, Boolean>();

		mapa.put("MOVIMENTO DETECTADO", true);
		mapa.put("SEM MOVIMENTO", false);

		this.setMapaDeConversaoDeMedicao(mapa);

	}

}
