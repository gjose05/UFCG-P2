package br.edu.ufcg.computacao.complementaccc;

import java.util.HashMap;

public abstract class RelatorioAbstract {

	private String nome;
	private String cpf;
	private String matricula;
	private HashMap<String,AtividadeComplementarAbstract> atividades;
	
	/**
	 * cria o relatorio abstrato
	 * @param nome nome do estudante
	 * @param cpf cpf do estudante
	 * @param matricula matricula do estudante
	 * @param atividades as atividades que ele fez
	 */
	public RelatorioAbstract(String nome, String cpf, String matricula, HashMap<String,AtividadeComplementarAbstract> atividades) {
		this.nome = nome;
		this.cpf = cpf;
		this.matricula = matricula;
		this.atividades = atividades;
	}
	
	/**
	 * pega as atvds do alunos
	 * @return
	 */
	public HashMap<String,AtividadeComplementarAbstract> getAtividades(){
		return atividades;
	}
	
	/**
	 * to string 
	 */
	@Override
	public String toString() {
		return nome + " " + cpf + " " + matricula;
	}
	
	
}
