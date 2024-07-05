package br.edu.ufcg.computacao.complementaccc;

import java.util.HashMap;

public class ComplementaCCCFacade {
	//declarar controladores
	
	private UsuarioController f1;
	private FAQController faq;
	private AtividadeComplementarController atividadescomplementares;
	private RelatorioController relatorios;
	private Exceções e;
	
	/**
	 * cria o ccc fachada
	 */
	public ComplementaCCCFacade() {
		f1 = new UsuarioController();
		faq = new FAQController();
		atividadescomplementares = new AtividadeComplementarController();
		relatorios = new RelatorioController();
		e = new Exceções();
	}
	
	/**
	 * cria o estudante 
	 * @param nome nome do estudante
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante 
	 * @param matricula matricula do estudante
	 * @return caso de certo o cadastro retorna verdadeiro
	 */
	boolean criarEstudante(String nome, String cpf, int senha, String matricula) {
		e.String(nome);
		e.String(cpf);
		e.String(matricula);
		e.Senha(senha);
		return f1.criarEstudante(nome, cpf, senha, matricula);
	}
	
	/**
	 * cria o administrador
	 * @param nome nome do adm
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @return caso de certo o cadastro retorna verdadeiro
	 */
	boolean criarAdm(String nome, String cpf, int senha) {
		e.Senha(senha);
		e.String(nome);
		e.String(cpf);
		if (f1.temAdm() == false) {
			f1.criaAdm(nome, cpf, senha);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * exibe todos os estudantes cadastrados no sistema
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @return retorna um array de string contendo as informaçoes dos estudantes
	 */
	String[] exibirEstudantes(String cpf, int senha){
		//ADMIN
		e.String(cpf);
		e.Senha(senha);
		if (f1.verificaAdm(cpf, senha) == true) {
			f1.sort();
			return f1.exibirEstudantes();
		}
		else {
			return null;
		}
	}
	
	/**
	 * altera nome ou senha do estudante
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param tipoAlteracao tipo da alteraçao (nome ou senha)
	 * @param novoValor novo nome ou nova senha
	 * @return caso de certo a alteraçao retorna verdadeiro 
	 */
	boolean alterarEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
		e.String(cpf);
		e.Senha(senha);
		if (tipoAlteracao.equals("nome")) {
			return f1.alteraNomeEstudante(cpf, senha, novoValor);
		}
		if (tipoAlteracao.equals("senha")) {
			return f1.alteraSenhaEstudante(cpf, senha, Integer.parseInt(novoValor));
		}
		return false;
	}
	
	/**
	 * exibe o adm
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @return retorna as informaçoes do adm
	 */
	String exibirAdmin(String cpf, int senha){
		e.String(cpf);
		e.Senha(senha);
		if (f1.verificaAdm(cpf, senha) == true) {
			return f1.exibirAdm();
		}
		else{
			return "";
		}
	}
	
	/**
	 * substitui as informaçoes do adm
	 * @param cpf cpf do adm atual
	 * @param senhaAtual senha do adm atual
	 * @param novoNome nome do novo adm
	 * @param cpfNovo cpf do novo adm
	 * @param senhaNova senha do novo adm
	 * @return caso de certo retorna verdadeiro
	 */
	boolean configurarNovoADMIN(String cpf, int senhaAtual, String novoNome, String cpfNovo, int senhaNova){
		e.String(cpf);
		e.Senha(senhaAtual);
		e.String(novoNome);
		e.String(cpfNovo);
		e.Senha(senhaNova);
		if (f1.verificaAdm(cpf, senhaAtual) == true) {
			f1.criaAdm(novoNome, cpfNovo, senhaNova);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * muda a senha do adm
	 * @param cpf cpf do adm
	 * @param senhaAtual senha antiga do adm
	 * @param senhaNova nova senha do adm
	 * @return caso de certo retorna verdadeiro
	 */
	boolean configurarSenhaADMIN(String cpf, int senhaAtual, int senhaNova){
		e.String(cpf);
		e.Senha(senhaAtual);
		e.Senha(senhaNova);
		if (f1.verificaAdm(cpf, senhaAtual) == true) {
			f1.alteraSenhaAdm(senhaNova);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * adiciona um item faz
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @param pergunta pergunta importante
	 * @return caso de certo retorna verdadeiro
	 */
	boolean adicionarItemFAQ(String cpf, int senha, String pergunta) {
		e.String(cpf);
		e.Senha(senha);
		e.String(pergunta);
		if (f1.verificaAdm(cpf, senha) == true) {
			faq.adicionaItem(pergunta);
			return true;

		}
		else{
			return false;
		}
	}
	
	/**
	 * adiciona um item faq
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @param pergunta pergunta importante
	 * @param resposta resposta dessa pergunta 
	 * @return caso de certo retorna verdadeiro
	 */
	boolean adicionarItemFAQ(String cpf, int senha, String pergunta, String resposta) {
		e.String(cpf);
		e.Senha(senha);
		e.String(pergunta);
		e.String(resposta);
		if (f1.verificaAdm(cpf, senha) == true) {
			faq.adicionaItem(pergunta,resposta);
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * altera a resposta de um item ja cadastrado
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @param itemIndex localizacao do item faq
	 * @param resposta resposta alterada
	 * @return caso de certo retorna verdadeiro
	 */
	boolean alteraRespostaItem(String cpf, int senha, int itemIndex, String resposta) {
		e.String(cpf);
		e.Senha(senha);
		e.String(resposta);
		e.negativos(itemIndex);
		if (f1.verificaAdm(cpf, senha) == true) {
			faq.alteraResposta(itemIndex, resposta);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * lista todos os itens faq cadastrados
	 * @return todos os itens faq cadastrados
	 */
	String[] listarFAQ() {
		return faq.listarFaqs();
	}
	
	/**
	 * lista todos os itens faq por ordem de destaque
	 * @return todos os itens faq por ordem de destaque
	 */
	String[] listarFAQPorDestaque() {
		return faq.listarFaqsImportancia();
	}
	
	/**
	 * adiciona 1 em destaque do item faq
	 * @param itemIndex localizacao do item
	 * @return caso de certo retorna verdadeiro
	 */
	boolean destacarItem(int itemIndex) {
		e.negativos(itemIndex);
		return faq.destacaFaq(itemIndex);
	}
	
	/**
	 * adiciona tags aos itens faq
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @param itemIndex localizaçao do item 
	 * @param tags tags para adicionar
	 * @return caso de certo retorna verdadeiro
	 */
	boolean atribuirTagsItemFAQ(String cpf, int senha,int itemIndex, String[] tags) {
		e.String(cpf);
		e.Senha(senha);
		e.negativos(itemIndex);
		if (f1.verificaAdm(cpf, senha) == true) {
			faq.adicionaTag(itemIndex, tags);
			return true;
		}
		return false;
	}
	
	/**
	 * retorna os itens faq pelas tags
	 * @param tags tags
	 * @return os itens que contem as tags
	 */
	String[] buscarItemFAQ(String[] tags) {
		return faq.listarFaqsTag(tags);
	}
	
	/**
	 * cria atividade de monitoria 
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param tipo tipo de atividade
	 * @param unidadeAcumulada quantas unidades ele conseguiu na atvd
	 * @param disciplina disciplina da monitoria
	 * @return retorna o codigo da atvd
	 */
	String criarAtividadeMonitoriaEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		e.String(cpf);
		e.Senha(senha);
		e.String(tipo);
		e.String(disciplina);
		e.negativos(unidadeAcumulada);
		Estudante estudante = f1.getEstudante(cpf, senha);
		return atividadescomplementares.adicionaMonitoria(estudante, tipo, unidadeAcumulada, disciplina);
	}
	
	/**
	 * altera a descricao da atvd
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param codigoAtividade codigo da atvd
	 * @param descricao descricao da atvd
	 * @return caso de certo retorna verdadeiro
	 */
	boolean alterarDescricaoAtividade(String cpf, int senha, String codigoAtividade, String descricao) {
		e.String(cpf);
		e.Senha(senha);
		e.String(codigoAtividade);
		e.String(descricao);
		Estudante estudante = f1.getEstudante(cpf, senha);
		return atividadescomplementares.alteraDescricao(estudante, codigoAtividade, descricao);
	}
	
	/**
	 * adiciona o link de comprovacao da atvd
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param codigoAtividade codigo da atvd
	 * @param linkComprovacao link da atvd
	 * @return caso de certo retorna verdadeiro
	 */
	boolean alterarComprovacaoAtividade(String cpf, int senha, String codigoAtividade, String linkComprovacao) {
		e.String(cpf);
		e.Senha(senha);
		e.String(codigoAtividade);
		e.String(linkComprovacao);
		Estudante estudante = f1.getEstudante(cpf, senha);
		return atividadescomplementares.alteraLink(estudante, codigoAtividade, linkComprovacao);
	}
	
	/**
	 * cria atividade de pesquisa de extensao
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param tipo tipo de atividade
	 * @param unidadeAcumulada quantas unidades ele conseguiu na atvd
	 * @param disciplina disciplina da pesquisa
	 * @return retorna o codigo da atvd
	 */
	String criarAtividadePesquisaExtensaoEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		e.String(cpf);
		e.Senha(senha);
		e.String(tipo);
		e.negativos(unidadeAcumulada);
		e.String(disciplina);
		Estudante estudante = f1.getEstudante(cpf, senha);
		return atividadescomplementares.adicionaPesquisaExtensao(estudante, tipo, unidadeAcumulada, disciplina);
	}
	
	/**
	 * cria atividade de estagio
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param tipo tipo de atividade
	 * @param unidadeAcumulada quantas unidades ele conseguiu na atvd
	 * @param disciplina disciplina do estagio
	 * @return retorna o codigo da atvd
	 */
	String criarAtividadeEstagioEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		e.String(cpf);
		e.Senha(senha);
		e.String(tipo);
		e.String(disciplina);
		e.negativos(unidadeAcumulada);
		Estudante estudante = f1.getEstudante(cpf, senha);
		return atividadescomplementares.adicionaEstagio(estudante, tipo, unidadeAcumulada, disciplina);
	}
	
	/**
	 * cria atvd de publicacao 
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param tipo tipo de atvd
	 * @param tituloArtigo titulo do artigo
	 * @param doi doi do artigo
	 * @param qualis qualis do artigo
	 * @param publi tipo de publicacao
	 * @return retorna o codigo da atvd
	 */
	String criarAtividadePublicacaoEmEstudante(String cpf, int senha, String tipo, String tituloArtigo, String doi, String qualis) {
		e.String(cpf);
		e.Senha(senha);
		e.String(qualis);
		e.String(doi);
		e.String(tituloArtigo);
		e.String(tipo);
		Estudante estudante = f1.getEstudante(cpf, senha);
		return atividadescomplementares.adicionaPublicacao(estudante, tipo, tituloArtigo, doi, qualis);
	}
	
	/**
	 * pega o credito da atvd
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param codigoAtividade codigo da atvd
	 * @return retorna os creditos da atvd
	 */
	double creditosAtividade(String cpf, int senha, String codigoAtividade) {
		e.String(cpf);
		e.Senha(senha);
		e.String(codigoAtividade);
		Estudante estudante = f1.getEstudante(cpf, senha);
		return atividadescomplementares.getCreditos(estudante, codigoAtividade);
	}
	
	/**
	 * cria relatorio completo 
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @return retorna a posicao
	 */
	int criarRelatorioCompleto(String cpf, String senha) {
		e.String(cpf);
		int novaSenha =  Integer.parseInt(senha);
		e.Senha(novaSenha);
		Estudante estudante = f1.getEstudante(cpf, novaSenha);
		HashMap<String,AtividadeComplementarAbstract> atividades = atividadescomplementares.getAtividadesComplementares(estudante);
		return relatorios.criaRelatorioCompleto(atividades, estudante);
	}
	
	/**
	 * cria relatorio resumido por atvd
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @return retorna a posicao
	 */
	int criarRelatorioResumido(String cpf, String senha) {
		e.String(cpf);
		int novaSenha =  Integer.parseInt(senha);
		e.Senha(novaSenha);
		Estudante estudante = f1.getEstudante(cpf, novaSenha);
		HashMap<String,AtividadeComplementarAbstract> atividades = atividadescomplementares.getAtividadesComplementares(estudante);
		return relatorios.criaRelatorioResumido(atividades, estudante);
	}
	
	/**
	 * cria o relatorio por atvd
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante 
	 * @param tipoAtividade tipo da atvd
	 * @return retorna a posicao 
	 */
	int criarRelatorioPorATV(String cpf, String senha, String tipoAtividade) {
		e.String(cpf);
		int novaSenha =  Integer.parseInt(senha);
		e.Senha(novaSenha);
		e.String(tipoAtividade);
		Estudante estudante = f1.getEstudante(cpf, novaSenha);
		HashMap<String,AtividadeComplementarAbstract> atividades = atividadescomplementares.getAtividadesComplementares(estudante);
		return relatorios.criaRelatorioAtvd(atividades,estudante,tipoAtividade);
	}
	
	/**
	 * exibe o relatorio escolhido
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param indexRelatorio posicao no sistema
	 * @return retorna o relatorio
	 */
	String exibirRelatorio(String cpf, String senha, int indexRelatorio) {
		e.String(cpf);
		int novaSenha =  Integer.parseInt(senha);
		e.Senha(novaSenha);
		e.negativos(indexRelatorio);
		Estudante estudante = f1.getEstudante(cpf, novaSenha);
		return relatorios.exibeRelatorio(indexRelatorio);
	}

}
