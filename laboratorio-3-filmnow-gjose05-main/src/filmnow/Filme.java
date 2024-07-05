package filmnow;

//classe para realizar a orientação ao objeto dos filmes adicionados.

public class Filme {
	private String nome;
	private String ano;
	private String local;
	
	//construtor da classe
	
	public Filme(String nome, String ano, String local) {
		this.nome = nome;
		this.ano = ano;
		this.local = local;
	}
	
	//retorna o nome 
	public String getNome() {
		return nome;
	}
	
	//retorna o ano
	public String getAno() {
		return ano;
	}
	
	//retorna de maneira ja formatada o detalhamento dos filmes
	public String toString() {
		return nome + ", " + ano + "\n" + local;
	}
}