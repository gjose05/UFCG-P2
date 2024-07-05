package mrbet;

public class Campeonato {
	
	private String nome;
	private Time[] participantes;
	private int contador;
	
	/**
	 * cria o campeonato
	 * @param nome nome do campeonato
	 * @param qntParticipantes quantidade de participantes no campeonato 
	 */
	
	public Campeonato(String nome, int qntParticipantes) {
		this.nome = nome;
		participantes = new Time[qntParticipantes];
	}
	
	/**
	 * retorna o campeonato de forma formatada
	 */
	@Override
	public String toString() {
		return "* " + nome + " - " + contador + "/" + participantes.length + "\n";
	}
	
	/**
	 * adiciona time no campeonato
	 * @param time time que participa do campeonato
	 * @return retorna uma mensagem de verificação do sucesso da operação
	 */
	public String adicionaTime(Time time) {
		if ((contador + 1 ) == (participantes.length)) {
			return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!\n";
		}
		participantes[contador] = time;
		contador++;
		return "TIME INCLUÍDO NO CAMPEONATO!\n";
	}
	
	/**
	 * verifica se o time esta no campeonato
	 * @param time time que quer ver se esta no campeonato
	 * @returnretorna uma mensagem de verificação do sucesso da operação
	 */
	public String verificaTime(Time time) {
		String nome = time.getCodigo();
		for(int i = 0; i < participantes.length; i++) {
			if ((participantes[i]!=null) && (participantes[i].getCodigo().equals(nome))) {
				return "O TIME ESTÁ NO CAMPEONATO!\n";
			}
		}
		return "O TIME NÃO ESTÁ NO CAMPEONATO!\n";
	}
	
	/**
	 * pega a quantidade de times que participam do campeonato
	 * @return quantidade de times que participam do campeonato
	 */
	public int getQntTimes() {
		return participantes.length;
	}
	
}
