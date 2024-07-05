package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Collections;

public class FAQController {
	
	private ArrayList<PerguntasRespostas> faqs;
	
	/**
	 * cria o faq
	 */
	public FAQController() {
		faqs = new ArrayList<>();
	}
	
	/**
	 * adiciona um item
	 * @param pergunta pergunta
	 */
	public void adicionaItem(String pergunta) {
		PerguntasRespostas novo = new PerguntasRespostas(pergunta);
		faqs.add(novo);
	}
	
	/**
	 * adiciona um item
	 * @param pergunta pergunta
	 * @param resposta resposta
	 */
	public void adicionaItem(String pergunta, String resposta) {
		PerguntasRespostas novo = new PerguntasRespostas(pergunta, resposta);
		faqs.add(novo);
	}
	
	/**
	 * altera resposta
	 * @param index localizacoes do item
	 * @param resposta resposta
	 */
	public void alteraResposta(int index, String resposta) {
		faqs.get(index).alteraResposta(resposta);
	}
	
	/**
	 * adiciona destaque
	 * @param index localizacao do item
	 * @return se deu certo retorna verdadeiro
	 */
	public boolean destacaFaq(int index) {
		if (index <= faqs.size()) {
			faqs.get(index).adicionaImportancia();
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * lista todas as faqs
	 * @return todas as faqs
	 */
	public String[] listarFaqs() {
		String[] faq = new String[faqs.size()];
		for (int i = 0; i<faqs.size();i++) {
			faq[i] = faqs.get(i).toString();
		}
		return faq;
	}
	
	/**
	 * lista as faqs por importancia
	 * @return  faqs por importancia
	 */
	public String[] listarFaqsImportancia() {
		String [] faq = new String[faqs.size()];
		ArrayList<PerguntasRespostas> copia = new ArrayList<>(this.faqs);
		Collections.sort(copia, new ComparatorItemFaq());
		for(int i = 0 ; i < copia.size();i++) {
			faq[i] = copia.get(i).toString();
		}
		return faq;
	}
	
	/**
	 * adiciona as tags
	 * @param index localizacao do item faq
	 * @param tags tags
	 */
	public void adicionaTag(int index, String[] tags) {
		faqs.get(index).adicionaTaq(tags);
	}
	
	/**
	 * lista as faqs pelas tags
	 * @param tags tags
	 * @return faqs pelas tags
	 */
	public String[] listarFaqsTag(String[] tags) {
		String[] FaqsTag = new String[faqs.size()];
		for (int i = 0 ; i < faqs.size();i++) {
			if (faqs.get(i).comparaTag(tags) == true){
				FaqsTag[i] = faqs.get(i).toString();
			}
		}
		return FaqsTag;
	}
	
}
