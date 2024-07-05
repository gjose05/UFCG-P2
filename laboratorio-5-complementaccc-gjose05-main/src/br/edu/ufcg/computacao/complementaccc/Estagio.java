package br.edu.ufcg.computacao.complementaccc;

public class Estagio extends AtividadeComplementarAbstract {
	
	private String disciplina;
	private double creditos;

	/**
	 * cria o estagio
	 * @param tipo tipo de atvd
	 * @param unidadeAcumulada unidade acumulada da atvd
	 * @param disciplina disciplina da atvd
	 */
	public Estagio(String tipo, int unidadeAcumulada, String disciplina) {
		super(tipo, unidadeAcumulada);
		this.disciplina = disciplina;
	}
	
	/**
	 * pega os creditos da atvd
	 */
	@Override
	public double getCreditos() {
		int unidades = super.getUnidades();
		creditos = ((double)unidades/60);
		super.setCreditos(this.creditos);
		return creditos;
	}
	
	/**
	 * pega o maximo de creditos da atvd
	 */
	@Override
	public int maximoCreditos() {
		return 18;
	}


}
