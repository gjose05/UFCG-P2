package br.edu.ufcg.computacao.complementaccc;

public class Monitoria extends AtividadeComplementarAbstract {
	
	private String disciplina;
	private double creditos;
	
	/**
	 * cria monitoria
	 * @param tipo tipo de atvd
	 * @param unidadeacumulada unidade acumulada da atvd
	 * @param disciplina disciplina da atvd
	 */
	public Monitoria(String tipo, int unidadeacumulada, String disciplina) {
		super(tipo, unidadeacumulada);
		this.disciplina = disciplina;
	}
	
	/**
	 * pega os creditos da atvd
	 */
	@Override
	public double getCreditos() {
		int unidades = super.getUnidades();
		double creditos = 0;
		if (unidades == 1) {
			creditos = 4;
		}
		else if(unidades == 2) {
			creditos = 8;
		}
		else if(unidades==3) {
			creditos = 12;
		}
		else if (unidades >=4) {
			creditos = 16;
		}
		super.setCreditos(this.creditos);
		return creditos;
	}
	
	/**
	 * pega o maximo de creditos da atvd
	 */
	@Override
	public int maximoCreditos() {
		return 16;
	}
	
}
