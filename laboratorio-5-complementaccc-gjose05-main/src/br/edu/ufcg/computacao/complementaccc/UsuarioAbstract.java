package br.edu.ufcg.computacao.complementaccc;

public abstract class UsuarioAbstract  {
	
	private String nome;
	private String cpf;
	private int senha;
	
	/**
	 * cria o usuario 
	 * @param nome nome do usuario 
	 * @param cpf cpf do usuario 
	 * @param senha senha do usuario 
	 */
	public UsuarioAbstract(String nome, String cpf, int senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}
	
	/**
	 * altera nome
	 * @param novoNome novo nome
	 */
	public void alteraNome(String novoNome) {
		nome = novoNome;
	}
	
	/**
	 * altera senha 
	 * @param novasenha nova senha
	 */
	public void alteraSenha(int novasenha) {
		this.senha = novasenha;
	}
	
	/**
	 * pega o nome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * pega o cpf 
	 * @return cpf 
	 */
	public String getcpf() {
		return cpf;
	}
	
	/**
	 * pega a senha 
	 * @return senha
	 */
	public int getsenha() {
		return senha;
	}
		
	/**
	 * to string de usuario
	 */
	public String toString() {
		return nome + " " + cpf;
	}
}
