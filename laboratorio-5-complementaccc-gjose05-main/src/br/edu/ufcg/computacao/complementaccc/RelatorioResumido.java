package br.edu.ufcg.computacao.complementaccc;

import java.util.HashMap;

public class RelatorioResumido extends RelatorioAbstract {
	
	/**
	 * cria o relatorio 
	 * @param nome nome do estudante
	 * @param cpf cpf do estudante
	 * @param matricula matricula do estudante
	 * @param atividades atividades do estudante
	 */
	public RelatorioResumido(String nome, String cpf, String matricula, HashMap<String,AtividadeComplementarAbstract> atividades) {
		super(nome,cpf,matricula,atividades);
	}
	
	/**
	 * pega o relatorio resumido 
	 * @return relatorio resumido 
	 */
	public String getRelatorioResumido() {
		String tudo = super.toString() + "\n";
		double creditosEstagio = 0;
		int creditosPermitidosEstagio = 0;
		for (AtividadeComplementarAbstract atvd : super.getAtividades().values()) {
			if (atvd.getTipo().equals("ESTAGIO")) {
				creditosPermitidosEstagio = atvd.maximoCreditos();
				creditosEstagio += atvd.getCreditos();
				}
			}
		if (creditosEstagio < creditosPermitidosEstagio && creditosPermitidosEstagio != 0 ) {
			tudo +=  "ESTAGIO" + " " + creditosEstagio + " " + creditosPermitidosEstagio + "\n";

		}
		else if (creditosPermitidosEstagio != 0) {
			tudo +=  "ESTAGIO" + " " + creditosPermitidosEstagio + " " + creditosPermitidosEstagio + "\n";
		}
		int creditosMonitoria = 0;
		int creditosPermitidosMonitoria = 0;
		for (AtividadeComplementarAbstract atvd : super.getAtividades().values()) {
			if (atvd.getTipo().equals("MONITORIA")) {
					creditosPermitidosMonitoria = atvd.maximoCreditos();
					creditosMonitoria += atvd.getCreditos();
			}
		}
		if (creditosMonitoria < creditosPermitidosMonitoria && creditosPermitidosMonitoria != 0) {
			tudo += "MONITORIA" + " " + creditosMonitoria + " " + creditosPermitidosMonitoria + "\n";
		}
		else if(creditosPermitidosMonitoria != 0) {
			tudo += "MONITORIA" + " " + creditosPermitidosMonitoria + " " + creditosPermitidosMonitoria + "\n";
		}
		double creditosPesquisaExtensao = 0;
		int creditosPermitidosPesquisaExtensao = 0;
		for (AtividadeComplementarAbstract atvd : super.getAtividades().values()) {
			if (atvd.getTipo().equals("PESQUISA_EXTENSAO")) {
				creditosPermitidosPesquisaExtensao = atvd.maximoCreditos();
				creditosPesquisaExtensao = atvd.getCreditos();
			}
		}
		if (creditosPesquisaExtensao < creditosPermitidosPesquisaExtensao && creditosPermitidosPesquisaExtensao!= 0 ) {
			tudo += "PESQUISA_EXTENSAO" + " " + creditosPesquisaExtensao + " " + creditosPermitidosPesquisaExtensao + "\n";
		}
		else if(creditosPermitidosPesquisaExtensao!= 0) {
			tudo += "PESQUISA_EXTENSAO" + " " + creditosPermitidosPesquisaExtensao + " " + creditosPermitidosPesquisaExtensao + "\n";
		}
		double creditosPublicacao = 0;
		int creditosPermitidosPublicacao = 0;
		for (AtividadeComplementarAbstract atvd : super.getAtividades().values()) {
			if (atvd.getTipo().equals("PERIÓDICO")||atvd.getTipo().equals("CONFERÊNCIA")) {
				creditosPublicacao = atvd.getCreditos();
				creditosPermitidosPublicacao = atvd.maximoCreditos();
			}
		}
		if (creditosPublicacao < creditosPermitidosPublicacao && creditosPermitidosPublicacao != 0) {
			tudo += "PUBLICACAO" + " " + creditosPublicacao + " " + creditosPermitidosPublicacao + "\n";
		}
		else if (creditosPermitidosPublicacao != 0) {
			tudo += "PUBLICACAO" + " " + creditosPermitidosPublicacao + " " + creditosPermitidosPublicacao + "\n";
		}
		return tudo;
	}
}
