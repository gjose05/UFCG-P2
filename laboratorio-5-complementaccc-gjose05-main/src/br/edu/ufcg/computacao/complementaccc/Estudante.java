package br.edu.ufcg.computacao.complementaccc;

public class Estudante extends UsuarioAbstract {

	private String matricula;
	
	/**
	 * cria o estudante
	 * @param nome nome do estudante
	 * @param cpf cpf do estudante 
	 * @param senha senha do estudante
	 * @param matricula matricula do estudante
	 */
	public Estudante(String nome, String cpf, int senha, String matricula) {
		super(nome,cpf,senha);
		this.matricula = matricula;
	}
	
	/**
	 * pega a matricula
	 * @return matricula
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * representaçao textual do estudante
	 */
	@Override
	public String toString() {
		return super.toString() + " " + matricula;
	}
	
}
