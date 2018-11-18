package edu.ifpb.sensor;

import java.util.Random;

/**
 * Um sensor que retorna valores aleatórios, pode ser utilizado em testes.
 * @author eduardo
 *
 * @param <T>
 */
public class AleatorioAdapter<T> implements Sensor<T> {

	private final T[] valores;

	private final double[] confiancas;

	public AleatorioAdapter(T[] valores, double[] confiancas) {
		super();
		this.valores = valores;
		this.confiancas = confiancas;
	}

	public T[] getValores() {
		return valores;
	}

	public double[] getConfiancas() {
		return confiancas;
	}
	
	public Medicao<T> realizaMedicao() {

		int rnd = new Random().nextInt(valores.length);
		T valorAleatorio = valores[rnd];

		rnd = new Random().nextInt(confiancas.length);
		double confiancaAleatoria = confiancas[rnd];

		return new Medicao<T>(valorAleatorio, confiancaAleatoria);
	}


}
