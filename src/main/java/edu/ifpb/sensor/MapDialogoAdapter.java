package edu.ifpb.sensor;

import java.util.Map;

import javax.swing.JOptionPane;

/**
 * Sensor que solicita ao usuário, através de um diálogo, qual o valor da medição.
 * @author eduardo
 *
 */
public class MapDialogoAdapter<T> implements Sensor<T> {
	
	
	private Map<String, T> mapaDeConversaoDeMedicao;

	public MapDialogoAdapter() {		
	}
	
	public MapDialogoAdapter(Map<String, T> mapaDeConversaoDeMedicao) {
		super();
		this.mapaDeConversaoDeMedicao = mapaDeConversaoDeMedicao;
	}
	
	public Medicao<T> realizaMedicao() {

		String leitura = (String) JOptionPane.showInputDialog(null,
				"Selecione o valor da leitura", "Leitura", JOptionPane.PLAIN_MESSAGE, null,
				mapaDeConversaoDeMedicao.keySet().toArray(), "ham");

		String[] nivel_de_confianca = { "0.95", "0.85",  "0.70",  "0.60", "0.50"};

		String confiancaSelecionada = (String) JOptionPane.showInputDialog(null,
				"Selecione o nível de confiança da leitura", "Confiança", JOptionPane.PLAIN_MESSAGE, null,
				nivel_de_confianca, "ham");

		T valorDaMedicao = mapaDeConversaoDeMedicao.get(leitura);
		double confianca = Double.valueOf(confiancaSelecionada);

		return new Medicao<T>(valorDaMedicao, confianca);

	}

	public Map<String, T> getMapaDeConversaoDeMedicao() {
		return mapaDeConversaoDeMedicao;
	}

	public void setMapaDeConversaoDeMedicao(Map<String, T> mapaDeConversaoDeMedicao) {
		this.mapaDeConversaoDeMedicao = mapaDeConversaoDeMedicao;
	}




}
