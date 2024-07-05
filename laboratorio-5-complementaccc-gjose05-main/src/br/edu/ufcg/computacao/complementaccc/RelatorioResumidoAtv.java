package br.edu.ufcg.computacao.complementaccc;

import java.util.HashMap;

public class RelatorioResumidoAtv extends RelatorioAbstract{
	
	private String tipoAtvd;
	
	/**
	 * cria o relatorio resumido por atvd
	 * @param nome nome do estudante
	 * @param cpf cpf do estudante
	 * @param matricula matricula do estudante
	 * @param atividades atividades do estudante
	 * @param tipoAtvd tipo da atv
	 */
	public RelatorioResumidoAtv(String nome, String cpf, String matricula, HashMap<String,AtividadeComplementarAbstract> atividades, String tipoAtvd) {
		super(nome,cpf,matricula,atividades);
		this.tipoAtvd = tipoAtvd;
	}
	
	/**
	 * pega o relatorio 
	 * @return relatorio 
	 */
	public String getRelatorioResumidoAtvd() {
		String tudo = super.toString() + "\n";
		double creditos = 0;
		int creditosPermitidos = 0;
		for (AtividadeComplementarAbstract atvd : super.getAtividades().values()) {
			if (atvd.getTipo().equals(tipoAtvd)) {
				creditosPermitidos = atvd.maximoCreditos();
				creditos += atvd.getCreditos();
			}
		}
		if ( creditos < creditosPermitidos) {
		return tudo + tipoAtvd + " " + creditos + " " + creditosPermitidos;
		}
		else {
			return tudo + tipoAtvd + " " + creditosPermitidos + " " + creditosPermitidos;
		}
	}
}
