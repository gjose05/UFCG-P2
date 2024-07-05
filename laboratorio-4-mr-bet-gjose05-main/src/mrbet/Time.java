package mrbet;

import java.util.ArrayList;

public class Time {

	private String codigo;
	private String nome;
	private String mascote;
	private ArrayList<Campeonato> campeonatos;
	
	/**
	 * cria o time
	 * @param codigo codigo do time
	 * @param nome nome do time
	 * @param mascote mascote do time
	 */
	
	public Time(String codigo, String nome, String mascote) {
		if ((codigo == null)||(codigo=="")||(nome==null)||(nome=="")||(mascote == null)||(mascote=="")) {
			throw new IllegalArgumentException();
		}
		this.codigo = codigo;
		this.nome = nome;
		this.mascote = mascote;
		this.campeonatos = new ArrayList<>();
	}
	
	/**
	 * pega o codigo de cada time
	 * @return retorna o codigo do time
	 */
	
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * adiciona um campeonato que o time esta participando
	 * @param campeonato campeonato que o time esta participando
	 */
	
	public void adicionaCampeonato(Campeonato campeonato) {
		this.campeonatos.add(campeonato);
	}
	
	/**
	 * busca os campeonatos que o time esta participando
	 * @return retorna todos os campeonatos que o time esta participando
	 */
	
	public String getCampeonato() {
		String todosCampeonatos = "Campeonatos do " + nome + ":\n";
		for (Campeonato campeonatos : this.campeonatos) {
			todosCampeonatos += campeonatos.toString();
		}
		return todosCampeonatos;
	}

	/**
	 * retorna o string 
	 */
	@Override
	public String toString() {
		return "[" + codigo + "] " + nome + " / " + mascote + "\n";
	}
	
}
