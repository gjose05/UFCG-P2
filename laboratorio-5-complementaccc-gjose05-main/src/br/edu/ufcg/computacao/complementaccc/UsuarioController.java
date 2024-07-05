package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;

public class UsuarioController {	
	
	private Adm adm;
	private ArrayList<Estudante> estudantes;
	
	/**
	 * cria o array
	 */
	public UsuarioController() {
		estudantes = new ArrayList<Estudante>();
	}
	
	/**
	 * cria o estudante
	 * @param nome nome 
	 * @param cpf cpf
	 * @param senha senha
	 * @param matricula matricula
	 * @return caso de certo retorna verdadeiro 
	 */
	public boolean criarEstudante(String nome, String cpf, int senha, String matricula) {
		Estudante f1 = new Estudante(nome,cpf,senha,matricula);
		if (estudantes.size()>=1) {
			for(int i = 0;i<estudantes.size();i++) {
				if (f1.getcpf().equals(estudantes.get(i).getcpf())) {
					return false;
				}
			}
		}
		estudantes.add(f1);
		return true;
	}
	
	/**
	 * altera o nome 
	 * @param cpf cpf
	 * @param senha senha
	 * @param novoNome novo nome
	 * @return caso de certo retorna verdadeiro 
	 */
	public boolean alteraNomeEstudante(String cpf, int senha, String novoNome) {
		for(int i = 0;i<estudantes.size();i++) {
			if ((estudantes.get(i).getcpf().equals(cpf))&&(estudantes.get(i).getsenha()==senha)) {
				estudantes.get(i).alteraNome(novoNome);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * altera senha
	 * @param cpf cpf
	 * @param senha senha
	 * @param novaSenha nova senha
	 * @return caso de certo retorna verdadeiro 
	 */
	public boolean alteraSenhaEstudante(String cpf, int senha, int novaSenha) {
		for(int i = 0;i<estudantes.size();i++) {
			if ((estudantes.get(i).getcpf().equals(cpf))&&(estudantes.get(i).getsenha()==senha)) {
				estudantes.get(i).alteraSenha(novaSenha);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * exibe os estudantes
	 * @return estudantes
	 */
	public String[] exibirEstudantes() {
		String[] nomes = new String[estudantes.size()];
		for (int i=0;i<estudantes.size();i++) {
			nomes[i] = estudantes.get(i).toString();
		}
		return nomes;
	}
	
	/**
	 * exibe o adm
	 * @return adm
	 */
	public String exibirAdm() {
		return adm.toString();
	}
	
	/**
	 * verifica se existe adm
	 * @return caso de certo retorna verdadeiro 
	 */
	public boolean temAdm() {
		if (adm != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * cria o adm
	 * @param nome nome 
	 * @param cpf cpf
	 * @param senha senha
	 */
	public void criaAdm(String nome, String cpf, int senha) {
		adm = new Adm(nome,cpf,senha);
	}
	
	/**
	 * altera senha do adm
	 * @param novaSenha nova senha
	 */
	public void alteraSenhaAdm(int novaSenha) {
		adm.alteraSenha(novaSenha);
	}
	
	/**
	 * verifica o cpf e senha do adm
	 * @param cpf cpf
	 * @param senha senha
	 * @return caso de certo retorna verdadeiro 
	 */
	public boolean verificaAdm(String cpf, int senha) {
		if((adm.getcpf().equals(cpf)) && (adm.getsenha() == senha)) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	/**
	 * arruma por ordem alfabetica os estudantes
	 */
	public void sort() {
        this.estudantes.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
    }
	
	/**
	 * pega o estudante
	 * @param cpf cpf
	 * @param senha senha
	 * @return estudante
	 */
	public Estudante getEstudante(String cpf, int senha) {
		for(int i = 0;i<estudantes.size();i++) {
			if ((estudantes.get(i).getcpf().equals(cpf))&&(estudantes.get(i).getsenha()==senha)) {
				return estudantes.get(i);
			}
		}
		throw new IllegalArgumentException();
	}
	
}
