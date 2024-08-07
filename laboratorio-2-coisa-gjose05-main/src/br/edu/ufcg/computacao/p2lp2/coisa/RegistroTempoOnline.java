package br.edu.ufcg.computacao.p2lp2.coisa;

/** 
 * define a quantidade de tempo que o aluno estudou a materia.
 * @author guilherme.jose.araujo.oliveira
 */
public class RegistroTempoOnline{
	/** 
	 * define inicialmente o tempo necessario para atingir a meta.
	 * define o nome da disciplina.
	 * registra o tempo online do aluno.
	 */
	private int tempoNecessario;
	private String disciplina;
	private int tempoOnline;
/**
 * atraves do metodo RegistraTempoOnline o usuario define duas das variaveis, o tempo necessario para a meta ser batida e o nome da materia.
 * @param materia
 * @param tempo
 */
	public RegistroTempoOnline(String materia, int tempo) {
		tempoNecessario = tempo;
		disciplina = materia;
		tempoOnline = 0;
	}
/**
 * caso o usuario nao informe o tempo necessario, o programa automaticamente define para as 120 horas(ja que foi instruido que caso nao seja mencionado a materia utilizaria 60 horas)
 * @param materia
 */
	public RegistroTempoOnline(String materia) {
		disciplina = materia;
		tempoNecessario = 120;
		tempoOnline = 0;
	}
/**
 * atraves desse metodo, o usuario consegue adicionar seu tempo de estudo, utilizando o parametro x.
 * @param x
 */
	public void adicionaTempoOnline(int tempo) {
		tempoOnline += tempo;
	}
/** 
 * caso esse metodo seja chamado, ele retorna como verdadeiro, caso o aluno ja tenha atingido a meta definida inicialmente, ou falso, caso o aluno nao tenha atingido a meta.
 * @return
 */
	public boolean atingiuMetaTempoOnline() {
		if (tempoOnline >= (tempoNecessario)) {
			return true;
		}
		else {
			return false;
		}
	}
/**
 * esse metodo retorna uma combinaçao entre todos os parametros definidos no programa, para uma melhor visualização das informações.
 */
	public String toString() {
		return disciplina + " " + tempoOnline + "/" + tempoNecessario;
	}
}
