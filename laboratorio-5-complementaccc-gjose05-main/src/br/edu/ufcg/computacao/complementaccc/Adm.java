package br.edu.ufcg.computacao.complementaccc;

public class Adm extends UsuarioAbstract {
	
	/**
	 * cria o adm
	 * @param nome nome do adm
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 */
	public Adm(String nome, String cpf, int senha) {
		super(nome,cpf,senha);
	}
}
