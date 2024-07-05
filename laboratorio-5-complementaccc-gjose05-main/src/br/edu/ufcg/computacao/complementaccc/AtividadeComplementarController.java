package br.edu.ufcg.computacao.complementaccc;

import java.util.HashMap;

public class AtividadeComplementarController {
	
	private HashMap<Estudante, HashMap<String,AtividadeComplementarAbstract>> atividadescomplementares;
	
	/**
	 * cria o controlador
	 */
	public AtividadeComplementarController(){
		atividadescomplementares = new HashMap<>();
	}
	
	/**
	 * adiciona monitoria no hashmap
	 * @param estudante estudante
	 * @param tipo tipo de atvd
	 * @param unidadeAcumulada unidade acumulada da atvd
	 * @param disciplina disciplina da atvd
	 * @return retorna o codigo
	 */
	public String adicionaMonitoria(Estudante estudante, String tipo, int unidadeAcumulada, String disciplina) {
		if (!atividadescomplementares.containsKey(estudante)) {
			atividadescomplementares.put(estudante, new HashMap<>());
			String codigo = estudante.getcpf() + "_1";
			Monitoria monitoria = new Monitoria(tipo,unidadeAcumulada,disciplina);
			atividadescomplementares.get(estudante).put(codigo, monitoria);
			return codigo;
		}
		else {
			String codigo = estudante.getcpf() + "_" + (atividadescomplementares.get(estudante).size()+1);
			Monitoria monitoria = new Monitoria(tipo,unidadeAcumulada,disciplina);
			atividadescomplementares.get(estudante).put(codigo,monitoria);
			return codigo;
		}
	}
	
	/**
	 * altera a descricao da atvd
	 * @param estudante estudante
	 * @param codigo codigo da atvd
	 * @param descricao altera a descricacao 
	 * @return se der certo retorna verdadeiro 
	 */
	public boolean alteraDescricao(Estudante estudante, String codigo, String descricao) {
		if (atividadescomplementares.containsKey(estudante)) {
			if (atividadescomplementares.get(estudante).containsKey(codigo)) {
				atividadescomplementares.get(estudante).get(codigo).adicionaDescricao(descricao);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * altera o link da atvd
	 * @param estudante estudante
	 * @param codigo codigo da atvd
	 * @param link link da atvd
	 * @return caso de certo retorna verdadeiro 
	 */
	public boolean alteraLink(Estudante estudante, String codigo, String link) {
		if (atividadescomplementares.containsKey(estudante)) {
			if (atividadescomplementares.get(estudante).containsKey(codigo)) {
				atividadescomplementares.get(estudante).get(codigo).adicionaLink(link);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * adiciona pesquisa de extensao no hashmap
	 * @param estudante estudante
	 * @param tipo tipo da atvd
	 * @param unidadeAcumulada unidade acumulada da atvd
	 * @param disciplina disciplina da atvd
	 * @return retorna o codigo
	 */
	public String adicionaPesquisaExtensao(Estudante estudante, String tipo, int unidadeAcumulada, String disciplina) {
		if (!atividadescomplementares.containsKey(estudante)) {
			atividadescomplementares.put(estudante, new HashMap<>());
			String codigo = estudante.getcpf() + "_1";
			PesquisaExtensao pesquisaExtensao = new PesquisaExtensao(tipo,unidadeAcumulada,disciplina);
			atividadescomplementares.get(estudante).put(codigo, pesquisaExtensao);
			return codigo;
		}
		else {
			String codigo = estudante.getcpf() + "_" + (atividadescomplementares.get(estudante).size()+1);
			PesquisaExtensao pesquisaExtensao = new PesquisaExtensao(tipo,unidadeAcumulada,disciplina);
			atividadescomplementares.get(estudante).put(codigo, pesquisaExtensao);
			return codigo;
		}
	}
	
	/**
	 * adiciona estagio no hashmap
	 * @param estudante estudante
	 * @param tipo tipo de atvd
	 * @param unidadeAcumulada unidade acumulada da atvd
	 * @param disciplina disciplina da atvd
	 * @return retorna o codigo da atvd
	 */
	public String adicionaEstagio(Estudante estudante, String tipo, int unidadeAcumulada, String disciplina) {
		if (!atividadescomplementares.containsKey(estudante)) {
			atividadescomplementares.put(estudante, new HashMap<>());
			String codigo = estudante.getcpf() + "_1";
			Estagio estagio = new Estagio(tipo,unidadeAcumulada,disciplina);
			atividadescomplementares.get(estudante).put(codigo, estagio);
			return codigo;
		}
		else {
			String codigo = estudante.getcpf() + "_" + (atividadescomplementares.get(estudante).size()+1);
			Estagio estagio = new Estagio(tipo,unidadeAcumulada,disciplina);
			atividadescomplementares.get(estudante).put(codigo, estagio);
			return codigo;
		}
	}
	
	/**
	 * adiciona publicacao no hashmap
	 * @param estudante estudante
	 * @param tipo tipo de atvd
	 * @param tituloArtigo titulo do artigo
	 * @param doi doi do artigo
	 * @param qualis qualis do artigo
	 * @param publi tipo de publicacao
	 * @return retorna o codigo 
	 */
	public String adicionaPublicacao(Estudante estudante, String tipo, String tituloArtigo, String doi, String qualis) {
		if (!atividadescomplementares.containsKey(estudante)) {
			atividadescomplementares.put(estudante, new HashMap<>());
			String codigo = estudante.getcpf() + "_1";
			Publicacao publicacao = new Publicacao(tipo,tituloArtigo,doi,qualis);
			atividadescomplementares.get(estudante).put(codigo, publicacao);
			return codigo;
		}
		else {
			String codigo = estudante.getcpf() + "_" + (atividadescomplementares.get(estudante).size()+1);
			Publicacao publicacao = new Publicacao(tipo,tituloArtigo,doi,qualis);
			atividadescomplementares.get(estudante).put(codigo, publicacao);
			return codigo;
		}
	}
	
	/**
	 * pega os creditos da atvd
	 * @param estudante estudante
	 * @param codigo codigo da atvd
	 * @return retorna os creditos 
	 */
	public double getCreditos(Estudante estudante, String codigo) {
		if (atividadescomplementares.containsKey(estudante)) {
			if(atividadescomplementares.get(estudante).containsKey(codigo)){
				return atividadescomplementares.get(estudante).get(codigo).getCreditos();
			}
		}
		return 0;
	}
	
	/**
	 * pega as atividades do estudante 
	 * @param estudante estudante
	 * @return as atividades realizadas pelo estudante
	 */
	public HashMap<String,AtividadeComplementarAbstract> getAtividadesComplementares(Estudante estudante){
		return atividadescomplementares.get(estudante);
	}
	
}
	
	
