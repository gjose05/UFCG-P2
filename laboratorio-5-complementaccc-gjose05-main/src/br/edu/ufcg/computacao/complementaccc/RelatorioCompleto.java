package br.edu.ufcg.computacao.complementaccc;

import java.util.HashMap;

public class RelatorioCompleto extends RelatorioAbstract {

	/**
	 * cria relatorio completo 
	 * @param nome nome do estudante
	 * @param cpf cpf do estudante 
	 * @param matricula matricula do estudante
	 * @param atividades atividades que ele fez
	 */
	public RelatorioCompleto(String nome, String cpf, String matricula, HashMap<String,AtividadeComplementarAbstract> atividades) {
		super(nome,cpf,matricula,atividades);
	}
	
	/**
	 * retorna o relatorio completo
	 * @return relatoio completo 
	 */
	public String getRelatorioCompleto() {
		String tudo = super.toString() + "\n";
		for (AtividadeComplementarAbstract atvd : super.getAtividades().values()) {
			if (atvd.getTipo().equals("ESTAGIO")) {
				tudo += atvd.toString() + "\n";
			}
		}
		for (AtividadeComplementarAbstract atvd : super.getAtividades().values()) {
			if (atvd.getTipo().equals("MONITORIA")) {
				tudo += atvd.toString() + "\n";
			}
		}
		for (AtividadeComplementarAbstract atvd : super.getAtividades().values()) {
			if (atvd.getTipo().equals("PESQUISA_EXTENSAO")) {
				tudo += atvd.toString() + "\n";
			}
		}
		for (AtividadeComplementarAbstract atvd : super.getAtividades().values()) {
			if (atvd.getTipo().equals("PERIÓDICO")||atvd.getTipo().equals("CONFERÊNCIA")) {
				tudo += atvd.toString() + "\n";
			}
		}
		return tudo;
	}
}
