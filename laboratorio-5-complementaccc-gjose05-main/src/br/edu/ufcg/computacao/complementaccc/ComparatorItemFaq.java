package br.edu.ufcg.computacao.complementaccc;

import java.util.Comparator;

public class ComparatorItemFaq implements Comparator<PerguntasRespostas>{

	/**
	 * compara 2 itens
	 */
	@Override
	public int compare(PerguntasRespostas o1, PerguntasRespostas o2) {
		if (o1.getImportancia() > o2.getImportancia()) {
			return -1;
		}
		if (o1.getImportancia() < o2.getImportancia()) {
			return 1;
		}
		return 0;
	}
}
