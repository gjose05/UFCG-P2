package br.edu.ufcg.computacao.complementaccc;

public class PesquisaExtensao extends AtividadeComplementarAbstract {
	
	private String disciplina;
	private double creditos;

	/**
	 * cria pesquisa de extensao 
	 * @param tipo tipo de atvd
	 * @param unidadeacumulada unidade acumulada da atvd
	 * @param disciplina disciplina da atvd
	 */
	public PesquisaExtensao(String tipo, int unidadeacumulada, String disciplina) {
		super(tipo, unidadeacumulada);
		this.disciplina = disciplina;
	}
	
	/**
	 * pega os creditos da atvd
	 */
	@Override
	public double getCreditos() {
		int unidades = super.getUnidades();
		this.creditos = (((double)unidades / 12) * 10);
		if (this.creditos >= 18) {
			return 18;
		}
		super.setCreditos(this.creditos);
		return this.creditos;
	}
	
	/**
	 * pega o maximo de creditos da atvd
	 */
	@Override
	public int maximoCreditos() {
		return 18;
	}
}
