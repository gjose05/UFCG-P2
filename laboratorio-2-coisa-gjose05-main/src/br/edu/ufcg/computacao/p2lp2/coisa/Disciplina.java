package br.edu.ufcg.computacao.p2lp2.coisa;

/** 
 * programa que define as 4 notas de provas da disciplina, as horas de estudo e a media dessas notas.
 * @author guilherme.jose.araujo.oliveira
 */
public class Disciplina {
/**
 * define as variaveis das notas e provas separadamente para uma melhor visualização, define a disciplina, horas e a media.
 */
	private Double nota1;
	private Double nota2;
	private Double nota3;
	private Double nota4;
	private String disciplina;
	private int horas;
	private double[] total;
	private Double media;
	
	public Disciplina(String materia) {
/**
 * com o metodo construtor é possivel definir a quantidade de provas e as notas como 0, como o problema pede, alem de definir as horas tambem como 0.
 */
		total = new double[4];
		disciplina = materia;
		nota1 = (double) 0;
		nota2 = (double) 0;
		nota3 = (double) 0;
		nota4 = (double) 0;
		horas = 0;
		media = (double) 0;
	}
	
	public void cadastraHoras(int horas) {
		/** 
		 * atraves da variavel x, esse metodo adiciona as horas do aluno.
		 */
		this.horas = horas;
	}
	public void cadastraNota(int nota, double valorNota) {
		/**
		 * com esse metodo, é possivel definir as notas de cada uma das provas, utilizando o indice do array para um controle.
		 */
		total[nota-1] = valorNota;
		if (nota == 1) {
			nota1 = valorNota;
		}
		else if (nota == 2) {
			nota2 = valorNota;
		}
		else if (nota==3) {
			nota3 = valorNota;
		}
		else if (nota==4) {
			nota4 = valorNota;
		}
	}
	
	public boolean aprovado() {
	/**
	 * esse metodo retorna como verdadeiro, caso a media das 4 provas seja igual ou superior a 7, caso contrario, o programa retorna falso.
	 */
		media = (nota1 + nota2 + nota3 + nota4) / 4;
		if (media >= 7) {
			return true;
		}
		else {
			return false;
		}
	}

	public String toString() {
		/**
		 * esse metodo retorna todas as informações disponibilizadas no programa ataves de uma string.
		 */
		return disciplina + " " + horas + " " + media + " " + "[" + total[0] + ", " + total[1] + ", " + total[2] + ", " + total[3] + "]";
	}
}
