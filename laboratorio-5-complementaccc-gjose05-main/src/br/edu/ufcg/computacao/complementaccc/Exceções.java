package br.edu.ufcg.computacao.complementaccc;

public class Exceções {

	public Exceções() {
		
		}
	
	/**
	 * excecoes de strings
	 * @param x strings
	 */
	public void String(String x) {
		if ((x == null) || (x=="")){
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * excecoes de inteiros
	 * @param x inteiros
	 */
	public void negativos(int x) {
		if (x < 0) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * excecoes das senhas
	 * @param senha senhas
	 */
	public void Senha(int senha) {
		String novo =  String.valueOf(senha);
		if (novo.length() != 8) {
			throw new IllegalArgumentException();
		}
	}
	
	
}
