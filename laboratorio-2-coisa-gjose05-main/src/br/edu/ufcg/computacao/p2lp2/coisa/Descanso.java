package br.edu.ufcg.computacao.p2lp2.coisa;

/** 
 * registra a quantidade de descanso dos alunos e retorna se eles estão cansados ou descansados.
 * @author guilherme.jose.araujo.oliveira
 */
public class Descanso {
/** 
 * define as horas de descanso e o numero de semanas. 
 */
	private int horasDeDescanso;
	private int numerodesemanas;
/** 
 * coloca como 0 as variaveis definidas inicialmente.
 */
	public Descanso() {
		horasDeDescanso = 0;
		numerodesemanas = 0;
	}
/** 
 * define atraves de "valor" a variavel horasdedescanso
 * @param valor
 */
	public void defineHorasDescanso(int horas) {
		horasDeDescanso = horas;
	}
/** define atraves de "x" a variavel numero de semanas.
 * @param x
 */
	public void defineNumeroSemanas(int semanas) {
		numerodesemanas = semanas;
	}
/** 
 * com o metodo getStatusGeral, é possivel atraves da divisao entre as variaveis horasdeDescanso e numerodesemanas definir se o aluno esta cansado ou descansado
 * @return cansado ou descansado 
 */
	public String getStatusGeral() {
		if (numerodesemanas == 0) {
			return "cansado";
		}
		else{
			int tempodescanso = (horasDeDescanso / numerodesemanas);
			if (tempodescanso >= 26) {
				return "descansado";
			}
			else {
				return "cansado";
			}
		}
	}
}
