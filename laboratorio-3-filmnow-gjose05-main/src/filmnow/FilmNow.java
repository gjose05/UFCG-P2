package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes. 
 * 
 * @author eliane
 *
 */
public class FilmNow {
	
	private static final int TAMANHO = 100;
	
	private Filme[] filmes;
	private String[] hotlist;
	private String[] hotlistnomes;

	/**
	 * Cria o FilmNow.
	 */
	public FilmNow() {
		this.filmes = new Filme[TAMANHO];
		hotlist = new String[10];
		hotlistnomes = new String[10];
	}
	
	/**
	 * Acessa a lista de filmes mantida.
	 * @return O array de filmes.
	 */
	public Filme[] getFilmes() {
		return this.filmes.clone();
	}

	/**
	 * Acessa os dados de um filme específico.
	 * @param posicao Posição do filme no sistema.
	 * @return Dados do filme. Null se não há filme na posição.
	 */
	public String getFilme(int posicao) {
		for (int i = 0 ; i < filmes.length; i++) {
			for (int j = 0 ; j < hotlistnomes.length; j++) {
				if ((hotlistnomes[j] != null)&& (hotlistnomes[j].equals(filmes[i].getNome()))) {
					return "🔥 " + filmes[posicao].toString();
				}
			}
		}
		return filmes[posicao].toString();
	}

	/**
	 * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior. 
	 * @param posicao Posição do filme.
	 * @param nome Nome do filme.
	 * @param ano Ano de lançamento do filme.
	 * @param local Local onde o filme pode ser assitido.
	 */
	public String cadastraFilme(int posicao, String nome, String ano, String local) {
		if ((posicao > 100) || (posicao < 1)) {
			return "POSIÇÃO INVÁLIDA";
		}
		for (int i = 0 ; i < filmes.length; i++) {
			if ((filmes[i]!=null) && (filmes[i].getNome().equals(nome)) && (filmes[i].getAno().equals(ano))) {
				return "FILME JÁ ADICIONADO";
				}
			}
		if (nome.equals("") || local.equals("")) {
			return "FILME INVALIDO";
		}
		filmes[posicao] = new Filme(nome,ano,local);
		return "FILME ADICIONADO";
	}

	//Cria a hotlist utilizando a posicao do filme e da hotlist.
	
	public String criaHotlist(int posicaohotlist, int posicao) {
		int contador = 0;
		for (int i = 0 ; i < hotlistnomes.length; i++) {
			if ((hotlistnomes[i] != null) && (hotlistnomes[i].equals(hotlist[posicaohotlist]))){
				contador += 1;
			}
		}
		if (contador < 1) {
			hotlistnomes[posicaohotlist] = filmes[posicao].getNome();
			return hotlist[posicaohotlist] = posicaohotlist + " - " + filmes[posicao] + ", " + filmes[posicao].getAno();
		}
		else {
			return null;
		}
	}

	//exibe todas as posicoes nao nulas da hotlist
	public String exibeHotlist() {
		String retorno = "";
		for (int i = 0 ; i < 10 ; i++) {
			if (hotlist[i] != null) {
				 retorno += hotlist[i] + "\n";
			}
		}
		return retorno;
	}

	//exclui um dos filmes da hotlist
	public void excluiHotlist(int posicao) {
		hotlistnomes[posicao] = null;
		hotlist[posicao] = null;
	}
}