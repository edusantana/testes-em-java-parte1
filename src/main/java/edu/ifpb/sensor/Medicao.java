package edu.ifpb.sensor;

/**
 * Essa classe representa uma medição dos sensores.
 * @author eduardo
 *
 * @param <T>
 */
public class Medicao <T> {
	
	private T medicao;
	private double confiancaDaMedicao;
	
	public Medicao(T medicao, double confiancaDaMedicao) {
		this.medicao = medicao;
		this.confiancaDaMedicao = confiancaDaMedicao;
	}
	
	public T getMedicao() {
		return medicao;
	}
	public void setMedicao(T medicao) {
		this.medicao = medicao;
	}
	public double getConfiancaDaMedicao() {
		return confiancaDaMedicao;
	}
	public void setConfiancaDaMedicao(double confiancaDaMedicao) {
		this.confiancaDaMedicao = confiancaDaMedicao;
	}
	
	@Override
		public String toString() {
			return medicao + " (" + confiancaDaMedicao + ")";
		}
	

}