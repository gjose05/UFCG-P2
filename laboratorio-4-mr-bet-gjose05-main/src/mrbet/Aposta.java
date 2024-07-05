package mrbet;

public class Aposta {
	
	private String codigo;
	private String nome;
	private String colocacao;
	private String valor;

	/**
	 * cria a aposta 
	 * @param codigo codigo do time
	 * @param nome nome do campeonato
	 * @param colocacao colocacao esperada
	 * @param valor valor da aposta
	 */
	public Aposta(String codigo, String nome, String colocacao, String valor) {
		this.codigo = codigo;
		this.nome = nome;
		this.colocacao = colocacao;
		this.valor = valor;
	}
	
	/**
	 * 	retorna a aposta formatada
	 */
	@Override
	public String toString() {
		return codigo + nome + "\n"+ colocacao + "\n" + valor + "\n";
	}
}

