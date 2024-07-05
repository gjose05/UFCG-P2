package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.HashMap;

public class RelatorioController {
	
	private ArrayList<String> relatorios;
	
	/**
	 * cria o array de relatorios
	 */
	public RelatorioController() {
		relatorios = new ArrayList<>();
	}
	
	/**
	 * cria o relatorio completo 
	 * @param atividades as atividades do estudante
	 * @param estudante estudante
	 * @return posicao do relatorio no array
	 */
	public int criaRelatorioCompleto(HashMap<String,AtividadeComplementarAbstract> atividades, Estudante estudante) {
		RelatorioCompleto relatorioCompleto = new RelatorioCompleto(estudante.getNome(),estudante.getcpf(),estudante.getMatricula(),atividades);
		relatorios.add(relatorioCompleto.getRelatorioCompleto());
		return relatorios.size()-1;
	}
	/**
	 * cria o relatorio resumido
	 * @param atividades as atividades do estudante
	 * @param estudante estudante
	 * @return posicao do relatorio no array
	 */
	public int criaRelatorioResumido(HashMap<String,AtividadeComplementarAbstract> atividades, Estudante estudante) {
		RelatorioResumido relatorioResumido = new RelatorioResumido(estudante.getNome(),estudante.getcpf(),estudante.getMatricula(),atividades);
		relatorios.add(relatorioResumido.getRelatorioResumido());
		return relatorios.size()-1;
	}
	
	/**
	  * cria o relatorio resumido
	 * @param atividades as atividades do estudante
	 * @param estudante estudante
	 * @param tipoAtvd tipo de atvd
	 * @return posicao do relatorio no array
	 */
	public int criaRelatorioAtvd(HashMap<String,AtividadeComplementarAbstract> atividades, Estudante estudante, String tipoAtvd) {
		RelatorioResumidoAtv relatorioResumido = new RelatorioResumidoAtv(estudante.getNome(),estudante.getcpf(),estudante.getMatricula(),atividades,tipoAtvd);
		relatorios.add(relatorioResumido.getRelatorioResumidoAtvd());
		return relatorios.size()-1;
	}
	
	/**
	 * exibe o relatorio
	 * @param estudante estudante
	 * @param index posicao 
	 * @return retorna o relatorio 
	 */
	public String exibeRelatorio(int index) {
		if (index > relatorios.size()){
			return "";
		}
		else{
			return relatorios.get(index);
		}
		
	}
	
	
}

