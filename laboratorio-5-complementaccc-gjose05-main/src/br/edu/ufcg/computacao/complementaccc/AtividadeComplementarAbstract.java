package br.edu.ufcg.computacao.complementaccc;

public abstract class AtividadeComplementarAbstract{

	private String tipo;
	private String descricao;
	private String link;
	private int unidadeacumulada;
	private double creditos;

	/**
	 * cria a classe abstrata
	 * @param tipo tipo de atvd
	 * @param unidadeacumulada unidade acumulada da atvd
	 */
	public AtividadeComplementarAbstract(String tipo,int unidadeacumulada) {
		this.tipo = tipo;
		this.unidadeacumulada = unidadeacumulada;
	}
	
	/**
	 * cria a classe abstrata
	 * @param tipo tipo de atvd
	 */
	public  AtividadeComplementarAbstract(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * retorna o tipo 
	 * @return retorna o tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * adiciona descricao 
	 * @param descricao atualiza a descricao
	 */
	public void adicionaDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * adiciona o link 
	 * @param link atualiza o link
	 */
	public void adicionaLink(String link) {
		this.link = link;
	}
	
	/**
	 * retorna as unidades acumuladas
	 * @return retorna as unidades acumuladas
	 */
	public int getUnidades() {
		return unidadeacumulada;
	}
	
	/**
	 * pega os creditos
	 * @return os creditos
	 */
	public double getCreditos() {
		return 0;
	}
	
	/**
	 * atualiza o credito 
	 * @param creditos2 atualiza o crdito 
	 */
	public void setCreditos(double creditos2) {
		this.creditos = creditos2;
	}
	
	/**
	 * to string da classe abstrata
	 */
	@Override
	public String toString() {
		return tipo + " " + descricao + " " + getCreditos();
	}
	
	/**
	 * define o maximo de creditos
	 * @return maximo de creditos
	 */
	public int maximoCreditos() {
		return 0;
	}
}
