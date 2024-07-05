package mrbet;

import java.util.ArrayList;
import java.util.HashMap;

public class MrBetSistema {
	
	private HashMap<String, Time> times;
	private HashMap<String, Campeonato> campeonatos;
	private ArrayList<Aposta> apostas;
	
	/**
	 * cria o mrbet
	 */
	public MrBetSistema(){
		this.times = new HashMap<>();
		this.campeonatos = new HashMap<>();
		this.apostas = new ArrayList<>();
	}
	
	/**
	 * cadastra o time
	 * @param codigo codigo de identificação
	 * @param nome nome do time
	 * @param mascote mascote do time
	 * @return retorna uma mensagem verificando se o cadastramento deu certo
	 */
	
	public String cadastraTime(String codigo, String nome, String mascote) {
		Time novoTime = new Time(codigo,nome,mascote);
	    if (times.containsKey(codigo)) {
	    	return "O TIME JÁ EXISTE\n";
	    }
	    times.put(codigo, novoTime);
	    return "INCLUSÃO REALIZADA!\n";
	}
	
	/**
	 * recupera o time a partir do codigo cadastrado
	 * @param codigo codigo do time
	 * @return retorna uma mensagem verificando se o procedimento ocorreu como esperado
	 */
	
	public String recuperaCodigo(String codigo) {
		if ((codigo==null)||(codigo=="")) {
			throw new IllegalArgumentException();
		}
		if (times.containsKey(codigo)){
			Time time = this.times.get(codigo);
			return time.toString();
			}
		return "O TIME NÃO EXISTE!\n";
	}
	
	/**
	 * cadastra um novo campeonato
	 * @param nome nome do campeonato
	 * @param qntParticipantes quantidade de participantes do campeonato
	 * @return retorna uma mensagem verificando se o procedimento ocorreu como esperado
	 */
	
	public String adicionaCampeonato(String nome, int qntParticipantes) {
		if ((nome==null)||(nome=="")||(qntParticipantes==0)) {
			throw new IllegalArgumentException();
		}
		Campeonato novocampeonato = new Campeonato(nome, qntParticipantes);
	    if (campeonatos.containsKey(nome)) {
	    	return "CAMPEONATO JÁ EXISTE!\n";
	    }
		campeonatos.put(nome, novocampeonato);
		return "CAMPEONATO ADICIONADO!\n";
	}
	
	/**
	 * esse metodo é utilizado para verificar se o time esta no campeonato ou adicionar o time
	 * @param codigo codigo do time
	 * @param nome nome do campeonato
	 * @return retorna uma mensagem verificando se o procedimento ocorreu como esperado
	 */
	public String incluiNoCampeonato(String codigo, String nome) {
		if ((nome==null)||(nome=="")||(codigo==null)||(codigo=="")) {
			throw new IllegalArgumentException();
		}
		if((times.containsKey(codigo))&&(campeonatos.containsKey(nome))) {
			this.times.get(codigo).adicionaCampeonato(this.campeonatos.get(nome));
			return this.campeonatos.get(nome).adicionaTime(this.times.get(codigo));
		}
		if (!times.containsKey(codigo)) {
			return "O TIME NÃO EXISTE!\n";
		}
		if (!campeonatos.containsKey(nome)) {
			return "O CAMPEONATO NÃO EXISTE!\n";
		}
		else {
			return this.campeonatos.get(nome).adicionaTime(this.times.get(codigo));
		}
	}
	
	/**
	 * verifica se o time esta participando do campeonato
	 * @param codigo codigo do time
	 * @param nome nome do campeonato
	 * @return retorna uma mensagem verificando se o procedimento ocorreu como esperado
	 */
	public String verificaCampeonato(String codigo, String nome) {
		if ((nome==null)||(nome=="")||(codigo==null)||(codigo=="")) {
			throw new IllegalArgumentException();
		}
		if (!times.containsKey(codigo)) {
			return "O TIME NÃO EXISTE!\n";
		}
		if (!campeonatos.containsKey(nome)) {
			return "O CAMPEONATO NÃO EXISTE!\n";
		}
		Time timeverificado = this.times.get(codigo);
		Campeonato campeonato = this.campeonatos.get(nome);
		return campeonato.verificaTime(timeverificado);
	}
	
	/**
	 * verifica os campeonatos que o time esta participando
	 * @param codigo codigo do time
	 * @return retorna os campeonatos que o time esta participando
	 */
	
	public String campeonatosTimes(String codigo) {
		if ((codigo==null)||(codigo=="")) {
			throw new IllegalArgumentException();
		}
		Time times = this.times.get(codigo);
		return times.getCampeonato();
	}
	
	/**
	 * cria e verifica as apostas realizadas
	 * @param codigo codigo do time
	 * @param nome nome do campeonato
	 * @param colocacao colocao esperada do time no campeonato
	 * @param valor valor da aposta 
	 * @return retorna uma mensagem verificando se o procedimento ocorreu como esperado
	 */
	public String criaBet(String codigo, String nome, int colocacao, String valor) {
		if ((nome==null)||(nome=="")||(codigo==null)||(codigo=="")||(valor==null)||(valor=="")) {
			throw new IllegalArgumentException();
		}
		if ((this.times.containsKey(codigo)) && (this.campeonatos.containsKey(nome)) && (this.campeonatos.get(nome).getQntTimes() >= colocacao)) {
			String colocacaoformatada = colocacao + "/" + this.campeonatos.get(nome).getQntTimes();
			Aposta novaAposta = new Aposta(this.times.get(codigo).toString(),nome,colocacaoformatada,valor);
			this.apostas.add(novaAposta);
			return "APOSTA REGISTRADA!\n";
		}
		else {
			return "APOSTA NÃO REGISTRADA!\n";
		}
	}
	
	/**
	 * busca as apostas realizadas
	 * @return retorna as apostas feitas
	 */
	public String getBet() {
		String tudo = "";
		for (Aposta apostas : this.apostas) {
			tudo += apostas.toString();
		}
		return tudo;
	}
	
}
