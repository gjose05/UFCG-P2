package br.edu.ufcg.computacao.complementaccc;

public class Publicacao extends AtividadeComplementarAbstract {

	private String tituloArtigo;
	private String doi;
	private String qualis;
	private double creditos;
	
	/**
	 * cria a publicacao 
	 * @param tipo tipo de atvd
	 * @param tituloArtigo titulo 
	 * @param doi doi
	 * @param qualis qualis
	 */
	public Publicacao(String tipo, String tituloArtigo, String doi, String qualis) {
		super(tipo);
		this.tituloArtigo = tituloArtigo;
		this.doi = doi;
		this.qualis = qualis;
	}
	
	/**
	 * pega os creditos 
	 */
	@Override
	public double getCreditos() {
		if (super.getTipo().equals("PERIÓDICO")&& (qualis.equals("A1") || qualis.equals("A2"))) {
			creditos = 4;
		}
		else if(super.getTipo().equals("PERIÓDICO")||qualis.equals("A3")) {
			creditos = 3;
		}
		else if(super.getTipo().equals("CONFERÊNCIA")&& (qualis.equals("A1") || qualis.equals("A2"))) {
			creditos = 3;
		}
		else if(super.getTipo().equals("CONFERÊNCIA")||qualis.equals("A3")) {
			creditos = 2;
		}
		else if(qualis.equals("A4") || qualis.equals("B1")) {
			creditos = 1;
		}
		super.setCreditos(this.creditos);
		return creditos;
	}

	/**
	 * pega o maximo de creditos
	 */
	@Override
	public int maximoCreditos() {
		return 16;
	}
	
	/**
	 * toString de publicacao
	 */
	@Override
	public String toString() {
		return "PUBLICAÇÃO" + " " + getCreditos();
	}

	
	
}
